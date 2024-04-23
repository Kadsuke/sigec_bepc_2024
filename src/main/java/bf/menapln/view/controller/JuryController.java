package bf.menapln.view.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import bf.menapln.controller.BackendCentreCompositionController;
import bf.menapln.controller.BackendCentreController;
import bf.menapln.controller.BackendJuryController;
import bf.menapln.controller.BackendSessionController;
import bf.menapln.controller.BackendStructureController;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.GroupePedagogique;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Structure;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.generique.ActionButtonTableCell;
import bf.menapln.service.SessionService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class JuryController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!";
    
    @FXML
    public ComboBox<Object> comboboxCentreExamen;

    @FXML
    public ComboBox<Object> comboboxEtab;

    @FXML
    public TextField juryLibelleField;
    
    @FXML 
    public TextField capaciteField;

    @FXML
    public ListView listViewCentreSecondaires;

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
    public TableView tableView;
    
    @FXML
    public TableColumn<Jury,String> colCentreExamen;

    @FXML
    public TableColumn<Jury,String> colEtabCentre;
    
    @FXML
    public TableColumn<Jury,String> colJuryLibelle;
    
    @FXML
    public TableColumn<Jury, String> colCapacite;

    @FXML
    public TableColumn<Jury, String> colCentreSecondaires;

    @FXML
    public TableColumn<Jury, String> tableColumnCandidateExcluded;
    
    Jury instance;
    Localite centreChoisi;
    ObservableList<Object> listEtabs;
    ObservableList<Object> listCentresPrincipal;    
    ObservableList<Object> listCentreSecondaires;    
    List<Objet> listJurys;
    Objet session;


    public JuryController() throws SQLException {
        this.backendJuryController = new BackendJuryController();
        this.backendCentreController = new BackendCentreController();
        this.backendEtablissementController = new BackendStructureController();
        this.backendSessionController = new BackendSessionController();
        this.backendCentreCompositionController = new BackendCentreCompositionController();
    }

    BackendJuryController backendJuryController;
    BackendCentreController backendCentreController;
    BackendStructureController backendEtablissementController;
    BackendSessionController backendSessionController;
    BackendCentreCompositionController backendCentreCompositionController = new BackendCentreCompositionController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.centreChoisi = new Localite(); //Pour gérer la recherche sur le comboCentreExamen
        try {
            //Liste des Centres
            this.listCentresPrincipal = convertToFxList(this.backendCentreController.getAllSpecial()
            .stream()
            .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            .filter(localite->localite != null && localite.getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            .collect(Collectors.toList()));

            this.comboboxCentreExamen.setItems(this.listCentresPrincipal);
            //Liste des Centre de composition
            this.listEtabs = convertToFxList(backendCentreCompositionController.getAll()
            .stream()
            .map(obj -> (obj instanceof CentreComposition)?(CentreComposition) obj :null)
            .filter(centre->centre != null && centre.getEtablissement().getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            .collect(Collectors.toList()));
            session = backendSessionController.getSessionActive();           
            // this.listViewCentreSecondaires.setItems(this.listCentresExam);
            this.listViewCentreSecondaires.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
           // comboboxEtab.setItems(this.listEtabs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        this.comboboxCentreExamen.setEditable(true);
        this.filterOnComboBox(this.comboboxCentreExamen,this.listCentresPrincipal);
        this.centreExamenOnchange();
        try {
           this.listJurys = backendJuryController.getAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
          e.printStackTrace();
        }
        listJury();
        this.AjouterBtn();
    }

    @SuppressWarnings("unchecked")
    public void AjouterBtn(){
        TableColumn<Object, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                this.tableView,
                    event -> {
                        this.openConfirmModif();
                },
                    event -> {
                        Objet candidat = (Objet) event.getSource();
                        Jury gp = (Jury)candidat;
                         this.openConfirmSupp(candidat);
            }
        );
    }

     private void openConfirmSupp(Objet candidat){
            ButtonType buttonTypeYes = new ButtonType("Oui");
            ButtonType buttonTypeNo = new ButtonType("Non");
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION,
                   "Voulez-vous vraiment supprimer cet Jury ?", buttonTypeYes, buttonTypeNo);

           confirmationDialog.setTitle("Confirmation de suppression");
           confirmationDialog.showAndWait().ifPresent(response -> {
               if (response == buttonTypeYes) {
                   try {
                       backendJuryController.delete(candidat);
                       infoBoxSuccess("GP Supprimé avec succès", "Success", null);
                       listJury();
                   }
                   /*catch (SQLException ex) {
                       infoBoxError(ex.getMessage(), "Erreur", null);
                   }*/
                   catch (NullPointerException ex) {
                       Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
                       //infoBoxError(ex.getMessage(), "Erreur", null);
                   } catch (SQLException ex) {
                       Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else if (response == buttonTypeNo) {
                   confirmationDialog.close();
               }
           });
       }

       private void openConfirmModif(){
        ButtonType buttonTypeNo = new ButtonType("ok");

        Alert confirmationDialog = new Alert(Alert.AlertType.INFORMATION,
               "Modification du Jury,Cliquez dans le champs directement", buttonTypeNo);

       confirmationDialog.setTitle("Modification");

       confirmationDialog.showAndWait().ifPresent(response -> {
           if (response == buttonTypeNo) {
               confirmationDialog.close();
           }
       });
   }
    // Action au changement du  centre d'examen
    public void centreExamenOnchange(){
        this.comboboxCentreExamen.setOnAction(event->{
            if (!this.comboboxCentreExamen.getEditor().getText().isEmpty()) {
                this.centreChoisi = this.listCentresPrincipal.stream()
                   .filter(obj -> (obj instanceof Localite))
                    .map(obj -> (Localite) obj)
                    .filter(centr -> centr.getNomLoclite().equalsIgnoreCase(comboboxCentreExamen.getValue().toString()))
                    .findFirst().orElse(null);
               // List centreSecondaires;
                this.listViewCentreSecondaires.setItems(convertToFxList(this.listCentresPrincipal.stream()
                    .filter(obj -> (obj instanceof Localite))
                    .map(obj -> (Localite) obj)
                    .filter(centr -> !centr.getNomLoclite().equalsIgnoreCase(comboboxCentreExamen.getValue().toString()))
                    .collect(Collectors.toList())));

                /*this.backendCentreController.getAll().stream()
                .map(obj-> (obj instanceof Centre)?(Centre) obj : null)
                .filter(cen->cen != null && cen.getTypeCentre().getLibelle().equalsIgnoreCase("Sécondaire"))
                .collect(Collectors.toList())));*/
            this.comboboxEtab.setItems(this.listEtabs);
            }
        });
         
    }
 
    @SuppressWarnings("unchecked")
    @FXML
    private void saveAction() throws SQLException, EmptyDataException{
        HashMap formData = new HashMap();
        try {
            if(this.centreChoisi != null){
                Session session = (Session)backendSessionController.getSessionActive();
                formData.put("session_id", ((Session)session ));
                formData.put("centreExamen_id", (Localite)this.centreChoisi);    
                formData.put("etablissement_id", (Etablissement)((CentreComposition)this.comboboxEtab.getValue()).getEtablissement());
                formData.put("juryLibelle", this.juryLibelleField.getText());
                formData.put("juryCapacite", this.capaciteField.getText()); 
                formData.put("listCentreSecondaire", listViewCentreSecondaires.getSelectionModel().getSelectedItems());
                System.out.println("FORMDATA :"+formData);
                backendJuryController.save(formData); 
                listJury();
                this.infoBoxSuccess(this.succes, "SUCCES", null);
            }else{
                this.infoBoxError(this.succes, "Choisir un centre Examen", null);
            }
            
        } catch (SQLException | EmptyDataException ex) {
            //this.infoBoxError(ex.getMessage(), "ERREUR", null);
            Logger.getLogger(JuryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* catch(NullPointerException  n){
            this.infoBox("Veuillez selectionner un examen", "ERREUR", null);
        } */
    }

    @SuppressWarnings("unchecked")
    @FXML
    private void saveUpdate() throws SQLException, EmptyDataException{
        HashMap formData = new HashMap();
        try { 
            Session session = (Session)backendSessionController.getSessionActive();
          //  formData.put("jury_id", this.getCandidatIdField().getText());
            formData.put("session_id", ((Session)session ));
            formData.put("juryLibelle", this.juryLibelleField.getText());
            formData.put("juryCapacite", this.capaciteField.getText());
            System.out.println("FORMDATA :"+formData);
           // backendJuryController.update(formData);
            listJury();
            this.infoBoxSuccess(this.succes, "SUCCES", null);
        } catch (SQLException ex) {
            Logger.getLogger(JuryController.class.getName()).log(Level.SEVERE, null, ex);
           // this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }
        /* catch(NullPointerException  n){
            this.infoBox("Veuillez selectionner un examen", "ERREUR", null);
        } */
    }
    
    @FXML
    private void listJury(){
   try {
    List<Objet> items = backendJuryController.getAll();
    colCentreExamen.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));  
    colEtabCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreComposition().getEtablissement().getNomStructure()));         
    colJuryLibelle.setCellValueFactory(new PropertyValueFactory<Jury, String>("juryLibelle"));           
    colCapacite.setCellValueFactory(new PropertyValueFactory<Jury, String>("juryCapacite"));
    colCentreSecondaires.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreSecondaires().toString()));
    this.tableView.setItems(this.convertToFxList(items));
    } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}     
    
    }

    @FXML//non use
    public void rowClicked(MouseEvent e){//au click d'une ligne du tableau
        try {
            Jury j = (Jury)tableView.getSelectionModel().getSelectedItem();
            j.setChecked(!j.isChecked());
            System.out.println("JURY :"+j+" COCHÉ : "+j.isChecked());
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listJury();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
    }
    
}
