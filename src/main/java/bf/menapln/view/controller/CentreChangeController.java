package bf.menapln.view.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.service.SessionService;
import exception.EmptyDataException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CentreChangeController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!\n";
    
    @FXML
    public ComboBox<Object> comboboxCentreExamenSource;

    @FXML
    public ComboBox<Object> comboboxCentreExamenDestination;

    @FXML
    public ComboBox<Object> comboboxEtablissement;

    @FXML
    public ComboBox<Object> comboboxJury;
    @FXML
    public ComboBox<Object> comboboxZone;
    @FXML
    public ComboBox<Object> comboboxCentreSecondaire;
    @FXML
    public ComboBox<Object> comboboxEtab;
    @FXML
    public ComboBox<Object> optionsCombo;
    
    @FXML
    public TextField juryLibelleField;
    @FXML
    public TitledPane titre;
    @FXML
    public Label msgSpecialite;
    @FXML
    public Label msgJury;
    @FXML
    public Label msgCentreExamen;
    @FXML 
    public CheckBox toutCocherCheckBox;
    
    /* @FXML 
    public TextField capaciteField; */

    @FXML 
    public TextField rechercheField;
    @FXML 
    public Button bntEnregistrer;
    @FXML
    public Button btnModifier;
    @FXML
    public Button btnAnnuler;
    @FXML
    public Button btnSupprimer;
    @FXML
    public Label effectif;

    @FXML
    public TableColumn<Candidat,Integer> colId;
    @FXML
    public TableColumn<Candidat,String> session;
    @FXML
    public TableColumn<Candidat,Integer> numDossier;
    @FXML
    public TableColumn<Candidat, String> nom;
    @FXML
    public TableColumn<Candidat, String> prenom;
    @FXML
    public TableColumn<Candidat, String> dateNaissance;
    @FXML
    public TableColumn<Candidat, String> sexe;
    @FXML
    public TableColumn<Candidat, String> option;
    @FXML
    public TableColumn<Candidat, String> groupePedagogique;
    @FXML
    public TableColumn<Candidat, String> telephone;
    @FXML
    public TableColumn<Candidat, String> concours;
    @FXML
    public TableColumn<Candidat, String> sport;
    @FXML
    public TableColumn<Candidat, String> choix;
    @FXML
    public TableColumn<Candidat, String> nomPere;
    @FXML
    public TableColumn<Candidat, String> prenomPere;
    @FXML
    public TableColumn<Candidat, String> nomMere;
    @FXML
    public TableColumn<Candidat, String> prenomMere;
    @FXML
    public TableColumn<Candidat, String> lieuNaissance;
    @FXML
    public TableColumn<Candidat, String> centre;
    @FXML
    public TableColumn<Candidat, String> zone;
    @FXML
    public TableColumn<Candidat, String> etablissement;
    @FXML
    public TableColumn<Candidat, String> cocher;
   // @FXML
    /*public TableColumn<CandidatJury, String> jury;*/
    @FXML
    public TextField lesXpremiers;
    
    @FXML
    private BorderPane borderFils;
    
    Localite centreExamen;
    Localite centreSecondaire;
    ObservableList<Object> listOption,listCentreExamens,listCentreSecondaires,listJury,listZones,listCandidatsFiltre,listCandidats,listEtablissement;
    List<Objet> candidatsSelected = new ArrayList<>();
    public CentreChangeController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendJuryController = new BackendJuryController();
        this.backendCentreController = new BackendCentreController();
        this.backendOptionController = new BackendOptionController();
        this.backendSessionController = new BackendSessionController();
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendAffectationCandidatController = new BackendAffectationCandidatController();
        this.backendStructureController = new BackendStructureController();
    }

    BackendOptionController backendOptionController;
    BackendCentreController backendCentreController;
    BackendJuryController backendJuryController;
    BackendLocaliteController backendLocaliteController;
    BackendSessionController backendSessionController;
    BackendInscriptionController backendInscriptionController;
    BackendAffectationCandidatController backendAffectationCandidatController;
    BackendStructureController backendStructureController;
    

    /** 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try { 
            this.listCandidats = this.convertToFxList(this.backendInscriptionController.getAll()); 
            this.listCentreExamens = convertToFxList(backendLocaliteController.getAllByParent(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId().toString()));
            this.listCentreSecondaires = convertToFxList(this.backendCentreController.getAllSpecial()
            .stream()
            .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            .filter(localite->localite != null && localite.getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            .collect(Collectors.toList()));
            System.out.println("notre User"+ sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId());
            comboboxCentreExamenSource.setItems(this.listCentreExamens);
            comboboxCentreExamenDestination.setItems(this.listCentreSecondaires);

            this.lesXpremiers.setOnAction(e->{
                this.cocherLesXpremiers();
            });

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void cocherLesXpremiers(){
        try {
            Integer x = Integer.parseInt(lesXpremiers.getText());
            int nbElem = this.tableView.getItems().size();
            if (toutEstCocher) {//Si tout est déjà coché
                if (nbElem <= x) {//ne rien faire
                } else {//Décocher tous ceux après x
                    for (int j = x; j < nbElem; j++) {
                        ((Objet)this.tableView.getItems().get(j)).setChecked(false);
                    }
                }
            } else {//si tout n'est pas coché
                if (nbElem <= x) {//cocher tout
                    toutEstCocher = false;
                    this.toutCocher();
                } else {//Cocher les x premiers
                    toutEstCocher = true;
                    this.toutCocher();//décocher tout avant de cocher les x premiers
                    for (int j = 0; j < x; j++) {
                        ((Objet)this.tableView.getItems().get(j)).setChecked(true);
                    }
                }
            }
            toutEstCocher = false;
            toutCocherCheckBox.setSelected(false);
            this.tableView.refresh();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    // Changing Centre Examen
    @FXML
    public void onChangeActionCentre(ActionEvent e) throws SQLException, EmptyDataException {
        this.centreExamen = (Localite) comboboxCentreExamenSource.getValue();
        this.listEtablissement = convertToFxList(this.backendStructureController.getEtabByCommune("Etablissement",this.centreExamen));
        comboboxEtablissement.setItems(this.listEtablissement);
        this.candidatsSelected.clear();
        this.tableView.setItems(null);
         
    }

    // Changing Etablissement
    @FXML  
    public void onChangeActionEtab(ActionEvent e) throws SQLException, EmptyDataException {
        Candidat cand;
        Structure op = (Structure)this.comboboxEtablissement.getValue();
        Localite ce = (Localite)this.comboboxCentreExamenSource.getValue();
        this.listCandidatsFiltre = this.convertToFxList(this.listCandidats.stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(op.getId()) 
               //  && candidat.getVilleComposition().getId() == ce.getId()
                )
                .sorted(Comparator.comparing( c -> ((Candidat)c).getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((Candidat)c).getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();
    }
    
    

    @FXML
    public void saveAction(ActionEvent e) throws SQLException, EmptyDataException {
        HashMap formData = new HashMap();
        SessionService sessionService = new SessionService();
        this.candidatsSelected.clear();
        if(this.comboboxCentreExamenDestination.getValue() == null){
            this.infoBoxError("Veuillez sélectionné la Destination", "ERREUR", null);
        }else{

        
        for (Object object : this.tableView.getItems()) {
            if (((Objet)object).isChecked()) {
                this.candidatsSelected.add((Objet)object);
            }
        }
        try {
            Session session = (Session)sessionService.getActiveSession();
            formData.put("session", session);
            formData.put("centre", (Localite)this.comboboxCentreExamenDestination.getValue());            
            formData.put("listCandidats", this.candidatsSelected);
            List<Objet> savedCandidats = this.backendInscriptionController.changeCentre(formData);
            this.infoBoxSuccess(this.succes+" \n ("+savedCandidats.size()+" candidats dont le centre a changé)", "SUCCES", null);
            this.candidatsSelected.clear();
            this.tableView.refresh();
        } catch (SQLException | bf.menapln.exception.EmptyDataException ex) {
            this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }

    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listCandidats();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
        this.titre.setText("Listes des candidats par ordre alpha. correspondants au filtre ( Effectif : "+this.tableView.getItems().size()+")");
    }

@FXML
    private void listCandidats(){
        this.titre.setText("Listes des candidats par ordre alpha. correspondants au filtre ( Effectif : "+listCandidatsFiltre.size()+")");
        centre.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getVilleComposition().toString()))); 
        nom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));           
        prenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom())); 
        dateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getDateNaissance().toString()));
        option.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
        sexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
        sport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
        lieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
        etablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
        cocher.setCellValueFactory(
        c -> {
            Candidat j = c.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().setValue(j.isChecked());
            // System.out.println("JURY "+j+" EST DEJA COCHER : "+j.isChecked());
            checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                j.setChecked(new_val);
                // System.out.println("JURY "+j+" COCHER : "+j.isChecked());
            });
            return new SimpleObjectProperty(checkBox);
        });
        tableView.setItems(listCandidatsFiltre);
    }

    @FXML
    public void rowClicked(MouseEvent e){//au click d'une ligne du tableau
        try {
            Jury j = (Jury)tableView.getSelectionModel().getSelectedItem();
            j.setChecked(!j.isChecked());
            System.out.println("JURY :"+j+" COCHÉ : "+j.isChecked());
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public BorderPane getBorderFils() {
        return borderFils;
    }

    public void setBorderFils(BorderPane borderFils) {
        this.borderFils = borderFils;
    }


    
}
