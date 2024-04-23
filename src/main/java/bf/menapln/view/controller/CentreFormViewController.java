package bf.menapln.view.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import bf.menapln.controller.*;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.SessionService;
import bf.menapln.sigec.App;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;

public class CentreFormViewController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!\n";

    
    @FXML
    private BorderPane bordeFils;
    @FXML
    public TableColumn<CentreComposition,String> etab;
    @FXML
    public TableColumn<CentreComposition,String> capacite;
    @FXML
    public TableColumn<CentreComposition, String> zone;
    @FXML
    public TableColumn<CentreComposition, String> cocher;
    @FXML
    public TableView tableView;

    // COMBOBOX
    @FXML
    public ComboBox<Object> regionCombo;
    @FXML
    public ComboBox<Object> provinceCombo;
    @FXML
    public ComboBox<Object> etabCombo;
    @FXML
    public ComboBox<Object> comboCommune;

    ObservableList<Object> listCentres,regions,provinces,listCommunes,centreExamens,listEtabs,listCentreExamens,listZones,zonesDuCentreExamen;
    List<Objet> centresSelected = new ArrayList<>();
    
    public CentreFormViewController() throws SQLException {
        this.backendCentreCompositionController = new BackendCentreCompositionController();
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendCentreController = new BackendCentreController();
    }

    BackendLocaliteController backendLocaliteController = new BackendLocaliteController();
    BackendCentreCompositionController backendCentreCompositionController = new BackendCentreCompositionController();
    BackendCentreController backendCentreController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // super.initialize(url, rb);
        try {
            listEtabs = this.backendCentreCompositionController.getAllEtablissements();
            listZones = convertToFxList(this.backendLocaliteController.getAll("").stream()
            .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            .filter(localit->localit != null && localit.getTypeLocalite().getLibelle().equalsIgnoreCase("Zone"))
            .collect(Collectors.toList()));
            //listCentreExamens = 
            //convertToFxList(this.backendCentreController.getAll().stream()
            //.map(obj-> (obj instanceof Centre)?(Centre) obj : null)
            //.filter(centre->centre != null && centre.getTypeCentre().getLibelle().equalsIgnoreCase("Principale"))
            //.collect(Collectors.toList()));
            listCommunes = convertToFxList(this.backendLocaliteController.getAllByParent(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId().toString()));
           // .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            //.filter(centre->centre != null && centre.getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            //.collect(Collectors.toList()));
            comboCommune.setItems(listCommunes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @SuppressWarnings("unchecked")
    @FXML
    private void listCentreComposition(){
        etab.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getNomStructure())); 
        capacite.setCellFactory(TextFieldTableCell.forTableColumn());
        capacite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCapacite().toString()));
        capacite.setOnEditCommit(event -> {
            CentreComposition centre = event.getTableView().getItems().get(event.getTablePosition().getRow());
            if (Integer.parseInt(event.getNewValue()) >= 300) {
                centre.setCapacite(Long.parseLong(event.getNewValue()));
            } else {
                this.infoBoxError("La capacité d'un centre est de minimum 300", "CAPACITE INVALIDE", "");
                Integer.parseInt("");
            }
        });
        cocher.setCellValueFactory(c -> {
            CentreComposition j = c.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().setValue(j.isChecked());
            checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                j.setChecked(new_val);
            });
            return new SimpleObjectProperty(checkBox);
        });

        zone.setCellValueFactory(i -> {
            CentreComposition centre = i.getValue();
            ComboBox<Object> combobox = new ComboBox<Object>();
            combobox.setItems(zonesDuCentreExamen);
            combobox.setPrefWidth(250.0);
            combobox.setOnAction(event -> { 
                // System.out.println("CentreFormViewController.listCentreComposition() SELECTIONNER : "+ combobox.getValue());
                Localite zone = (Localite)combobox.getValue();
                centre.setZone(zone);
            });
            if ((centre.getZone() != null)) {
                combobox.setValue(centre.getZone());
            }
            return new SimpleObjectProperty(combobox);
        });
        this.tableView.setEditable(true);
        this.tableView.setItems(this.listCentres);
    }

    @FXML
    private void saveAction() throws SQLException, EmptyDataException{
        HashMap formData = new HashMap();
        SessionService sessionService = new SessionService();
        this.centresSelected.clear();
        for (Object object : this.tableView.getItems()) {
            if (((Objet)object).isChecked()) {
                if (((CentreComposition)object).getCapacite() > 0) {
                    this.centresSelected.add((Objet)object);
                } else {
                    this.centresSelected.clear();
                    this.infoBoxError("Renseigner les vraix capacités des centres", "ERREUR", "Capacité nulle");
                    break;
                }
            }
        }
        if (this.centresSelected.size()>0) {
            try {
                Session session = (Session)sessionService.getActiveSession();
                formData.put("session", session);
                formData.put("listCentres", this.centresSelected);
                // System.out.println("FORMDATA :"+formData);
                backendCentreCompositionController.save(formData);
                this.infoBoxSuccess(this.succes+" \n ("+centresSelected.size()+" centres enregistrés)", "SUCCES", null);
                this.centresSelected.clear();
                this.toutCocher();this.toutCocher();
                this.tableView.refresh();
            } catch (SQLException | EmptyDataException ex) {
                this.infoBoxError(ex.getMessage(), "ERREUR", null);
            }
        }else{
            this.infoBoxError("VEUILLEZ SELECTIONNEZ AU MOINS UN CENTRE DE COMPOSITION ET RENSEIGNER SA CAPACITE", "ERREUR", null);
        }
    }
    // Chargement des etablissements au changement du centre d'examen
    public void centreExamenOnchange(){
            Localite selectedItem= (Localite)this.comboCommune.getSelectionModel().getSelectedItem();
            this.listCentres = convertToFxList(listEtabs.stream()
                .filter(e->((CentreComposition)e).getEtablissement().getLocalite().getId().equals(selectedItem.getId()))
                .collect(Collectors.toList()));
            this.zonesDuCentreExamen = this.convertToFxList(this.listZones.stream().filter(z->((Localite)z).getParentLocalite().getId().equals(selectedItem.getId())).collect(Collectors.toList()));
            this.listCentreComposition();
    }

    // Retour à la liste des centres de composition
    public void centreView() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("centreView.fxml"));
        BorderPane formInscription = loader.load();
       // borderFils.setCenter(formInscription);
       /* FXMLLoader loader = new FXMLLoader(App.class.getResource("centreView.fxml"));
        CentreViewController controller = new CentreViewController();
        loader.setController(controller);
        BorderPane  form = loader.load();
        controller.setBorderFils(this.getBordeFils());//recuperation du borderPane actuel
        controller.getBorderFils().setCenter(form);*/
    }

    public BorderPane getBordeFils() {
        return this.bordeFils;
    }
    
    public void setBordeFils(BorderPane bordeFils) {
        this.bordeFils= bordeFils;
    }
}
