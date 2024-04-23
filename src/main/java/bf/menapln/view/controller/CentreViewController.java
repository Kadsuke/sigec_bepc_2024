package bf.menapln.view.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import bf.menapln.controller.BackendCentreCompositionController;
import bf.menapln.entity.Candidat;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Localite;
import bf.menapln.sigec.App;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class CentreViewController extends VueController implements Initializable{
    BackendCentreCompositionController backendCentreCompoController;
    
    @FXML
    private BorderPane borderFils;

    @FXML
    private LayoutController layout;
    @FXML
    public TableColumn<CentreComposition,String> etab;
    @FXML
    public TableColumn<CentreComposition,String> capacite;
    @FXML
    public TableColumn<CentreComposition, String> zone;
    @FXML
    public TableColumn<CentreComposition, String> region;
    @FXML
    public TableColumn<CentreComposition, String> province;
    @FXML
    public TableColumn<CentreComposition, String> centreExamen;
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
    public ComboBox<Object> centreExamenCombo;
    ObservableList<Object> listCentres,regions,provinces,centreExamens,listEtabs,centresExam,listZones,zonesDuCentreExamen,listCentresCompo;
    
    public CentreViewController(){
        this.backendCentreCompoController = new BackendCentreCompositionController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.listCentresCompo = backendCentreCompoController.getAll();
            this.listCentres = this.listCentresCompo;
            this.listCentreComposition();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @SuppressWarnings("unchecked")
    @FXML
    private void listCentreComposition(){
        // this.titre.setText("Listes des centres ");
        region.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getLocalite().getParentLocalite().getParentLocalite().toString())); 
        province.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getLocalite().getParentLocalite().toString())); 
        centreExamen.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getLocalite().toString())); 
        etab.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getNomStructure())); 
        capacite.setCellFactory(TextFieldTableCell.forTableColumn());
        capacite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCapacite().toString()));
        
        capacite.setOnEditCommit(event -> {
            CentreComposition centre = event.getTableView().getItems().get(event.getTablePosition().getRow());
            if (Integer.parseInt(event.getNewValue()) >= 300) {
                centre.setCapacite(Long.parseLong(event.getNewValue()));
                try {
                    this.backendCentreCompoController.update(centre);
                    this.infoBoxSuccess("Capacité mis à jour avec succès", "Modification de capacité d'un centre", "");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    this.infoBoxError("Echec mis à jour de la capacité", "Modification de capacité", "");
                }
            } else {
                this.infoBoxError("La capacité d'un centre est de minimum 300", "CAPACITE INVALIDE", "");
                Integer.parseInt("");
            }
        });
        zone.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getZone() != null)?cellData.getValue().getZone().toString():""));
        this.tableView.setEditable(true);
        this.tableView.setItems(this.listCentres);
    }

    // Chargement des centres de compositon au changement du centre d'examen
    public void centreExamenOnchange(){
        this.centreExamenCombo.setOnAction(event -> {
            Centre selectedItem= (Centre)this.centreExamenCombo.getSelectionModel().getSelectedItem();
            this.listCentres = convertToFxList(this.listCentresCompo.stream()
                .filter(e->((CentreComposition)e).getEtablissement().getLocalite().getId().equals(selectedItem.getId()))
                .collect(Collectors.toList()));
            this.listCentreComposition();
        });
    }

    
    public void centreViewForm() throws IOException, SQLException{
         FXMLLoader loader = new FXMLLoader(App.class.getResource("centreFormView.fxml"));
         BorderPane formInscription = loader.load();
         borderFils.setCenter(formInscription);

        /*FXMLLoader loader = new FXMLLoader(App.class.getResource("centreFormView.fxml"));
        CentreFormViewController controller = new CentreFormViewController();
        loader.setController(controller);
        BorderPane  form = loader.load();
        controller.setBordeFils(this.getBordeFils());//recuperation du borderPane actuel
        controller.getBordeFils().setCenter(form);*/
    }

    public BorderPane getBorderFils() {
        return this.borderFils;
    }
    
    public void setBorderFils(BorderPane borderFils) {
        this.borderFils= borderFils;
    }
}
