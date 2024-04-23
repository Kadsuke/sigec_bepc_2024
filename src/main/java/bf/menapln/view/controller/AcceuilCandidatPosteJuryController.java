/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.generique.ActionButtonTableCell;
import bf.menapln.sigec.App;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kadsuke
 */
public class AcceuilCandidatPosteJuryController extends VueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane borderFils;
    
    @FXML
    private LayoutController layout;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<CandidatPosteJury,Long> colId;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colMatricule;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colNip;

    @FXML
    public TableColumn<CandidatPosteJury,String> colNom;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colPrenom;
        
    @FXML
    public TableColumn<CandidatPosteJury,String> colSexe;

    @FXML
    public TableColumn<CandidatPosteJury,String> colTelephone;
 
    @FXML
    public TableColumn<CandidatPosteJury,String> colLocalite;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colStructure;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colStatut;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colPoste;
    
    @FXML
    public TableColumn<CandidatPosteJury,String> colDiscipline;
    
    @FXML
    private TextField rechercheField;
    
    @FXML
    private Button buttonNew;
    
    @FXML
    private Button buttonExcel;
    
    @FXML
    private ComboBox<String> comboboxTypeList;
    
    @FXML
    private ComboBox<Object> comboboxValeurList;
    
    @FXML
    private ComboBox<Object> comboboxProvince;
    
    @FXML
    private ComboBox<Object> comboboxRegion;
    
    HashMap<Modalite,Critere> choixCritereModalite = new HashMap<Modalite,Critere> ();
    
    List<CritereCandidatPosteJury> critereCandidatPosteJurys = new ArrayList<>();

    Objet session;
    
    List<CheckBox> checkBoxList = new ArrayList<>();
    
    Type ob;
    
    Label labelElement;
    @FXML
    Label effectif;
    
    ComboBox<Object> comboBox;
    
    CheckBox checkBox;
    
    HashMap<Option,Epreuve> epOp = new HashMap<Option,Epreuve>();
    
    CritereCandidatPosteJury critereCandidatPosteJury = new CritereCandidatPosteJury();
    
    ObservableList<Sexe> listSexe = FXCollections.observableArrayList(Sexe.values());
    
    ObservableList<Object> listRegion,listPoste,listCritereModalite,listTypeStruture,listProvince,
            listCommune,listStruture,listVillage,listModalite,listEpreuve,listOption;
    
    ObservableList<String> typeList = FXCollections.observableArrayList("Tout","Par Etablissement",
     "Par Structure");
    
    ObservableList<Object> listActeurs = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setVisible(false);
        try {
            listActeurs = convertToFxList(backendCandidatPosteJuryController.getAll());
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                comboboxTypeList.setVisible(false);
                comboboxValeurList.setVisible(false);
                comboboxProvince.setVisible(false);
                comboboxRegion.setVisible(false);
                this.listAll();
                this.lancerPopUp();
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                comboboxTypeList.setItems(typeList);
                comboboxProvince.setVisible(false);
                comboboxRegion.setVisible(false);
                comboboxValeurList.setEditable(true);
                this.lancerPopUp();

            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                comboboxTypeList.setItems(typeList);
                comboboxProvince.setItems(convertToFxList(backendLocaliteController.getAllByParent(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId().toString())));
                comboboxRegion.setVisible(false);
                comboboxValeurList.setEditable(true);
                //this.lancerPopUp();

            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                comboboxTypeList.setVisible(false);
                comboboxValeurList.setVisible(false);
                comboboxValeurList.setEditable(true);
                comboboxProvince.setVisible(false);
                comboboxRegion.setItems(convertToFxList(backendLocaliteController.getAll("region")));
                //this.lancerPopUp();
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                comboboxTypeList.setItems(typeList);
                comboboxValeurList.setEditable(true);
                comboboxRegion.setItems(convertToFxList(backendLocaliteController.getAll("region")));
                this.lancerPopUp();
            }
            this.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                this.fieldRechercheKeyUp();
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilCandidatPosteJuryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public AcceuilCandidatPosteJuryController() throws SQLException {
        this.backendCandidatPosteJuryController = new BackendCandidatPosteJuryController();
        this.backendCritereController = new BackendCritereController();
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendEtablissementController = new BackendStructureController();
    }
    
        BackendCandidatPosteJuryController backendCandidatPosteJuryController;
        BackendCritereController backendCritereController;
        BackendLocaliteController backendLocaliteController;
        BackendStructureController backendEtablissementController;

    @FXML
    public void openInscription(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("candidatPosteJury.fxml"));
        AnchorPane formInscription = loader.load();
        borderFils.setCenter(formInscription);
    }
    
    @FXML
    public void listAll() throws SQLException{       
        // ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll());
    //    super.listAll();
        tableView.setItems(listActeurs);
        this.effectif.setText("Candidat acteurs à l'examen du BEPC "+tableView.getItems().size());
        colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
        colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
        colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
        colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
        colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
        colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
        colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
        colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
        colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
        colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
        colDiscipline.setCellValueFactory(cellData -> {
            CandidatPosteJury candidat = cellData.getValue();
            List<Epreuve> epreuves = candidat.getEpreuves();
            StringJoiner epreuvesJoiner = new StringJoiner(";");
            for (Epreuve epreuve : epreuves) {
                epreuvesJoiner.add(epreuve.getEpreuveLibelle());
            }

            return new SimpleStringProperty(epreuvesJoiner.toString());
        });
        colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
        
 }
    public void lancerPopUp(){
        TableColumn<Localite, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                tableView,
                    event -> {
                        CandidatPosteJury t = (CandidatPosteJury) event.getSource();
                        checkBoxList.clear();
                        this.openModalFormWithInitialData(t);
                        
                },
                    event -> {
                        Objet candidat = (Objet) event.getSource();
                        this.openConfirmSupp(candidat);
            }
        );
    }
    
    public void exportExcel(){
        exportToExcel(tableView,"exportCandidatPosteJury.xlsx");
    }
    
    private void openConfirmSupp(Objet candidat){
            ButtonType buttonTypeYes = new ButtonType("Oui");
            ButtonType buttonTypeNo = new ButtonType("Non");

            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION,
                   "Voulez-vous vraiment supprimer cet candidat ?", buttonTypeYes, buttonTypeNo);

           confirmationDialog.setTitle("Confirmation de suppression");

           confirmationDialog.showAndWait().ifPresent(response -> {
               if (response == buttonTypeYes) {
                   try {
                       backendCandidatPosteJuryController.delete(candidat);
                       infoBoxSuccess("Candidat Supprimé avec succès", "Success", null);
                       listAll();
                   } catch (SQLException ex) {
                       infoBoxError(ex.getMessage(), "Erreur", null);
                   } catch (EmptyDataException ex) {
                       infoBoxError(ex.getMessage(), "Erreur", null);
                   }catch (NullPointerException ex) {
                       infoBoxError(ex.getMessage(), "Erreur", null);
                   }
               } else if (response == buttonTypeNo) {
                   confirmationDialog.close();
               }
           });
       }
 
    public BorderPane getBorderFils() {
        return borderFils;
    }

    public void setBorderFils(BorderPane borderFils) {
        this.borderFils = borderFils;
    }
    
    @FXML
    public  void fieldRechercheKeyUp() throws SQLException{
        listAll();
        this.filtrerTableView(this.tableView,rechercheField.getText());
        this.effectif.setText("Candidat acteurs à l'examen du BEPC "+tableView.getItems().size());
    }
    
    //Modification
    public void openModalFormWithInitialData(CandidatPosteJury candidatPosteJury) {
    try {
        // Chargez le fichier FXML du formulaire de modification
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("candidatPosteJury.fxml"));
        FXMLLoader loader = new FXMLLoader(App.class.getResource("candidatPosteJury.fxml"));
        Parent root = loader.load();

        // Accédez au contrôleur du formulaire de modification
        CandidatPosteJuryController modificationController = loader.getController();
        
        if(!candidatPosteJury.getPoste().getLibelle().equalsIgnoreCase("Correcteur")){
            modificationController.getListViewEpreuve().setDisable(true);
        }else{
            modificationController.getListViewEpreuve().setDisable(false);
        }
        
        modificationController.getSaveButton().setVisible(false);
        modificationController.getUpdateButton().setVisible(true);
        modificationController.getResetButton().setVisible(false);
        modificationController.setCandidatIdField(candidatPosteJury.getCandidat().getId());
        modificationController.setListStruture(convertToFxList(backendEtablissementController.getEtabByCommune(candidatPosteJury.getStructure().getTypeStructure().getLibelle(),candidatPosteJury.getLocaliteCand())));
        
        // Injectez les données initiales dans les contrôles du formulaire
        modificationController.setNomField(candidatPosteJury.getCandidat().getNom());
        modificationController.setPrenomField(candidatPosteJury.getCandidat().getPrenom());
        modificationController.setNipField(candidatPosteJury.getCandidat().getNip());
        modificationController.setMatriculeField(candidatPosteJury.getCandidat().getMatricule());
        modificationController.setTelephoneField(candidatPosteJury.getCandidat().getTelephone());
        modificationController.setListViewEpreuve(modificationController.getListEpreuve());
        for (Object epreuve : candidatPosteJury.getEpreuves()) {
           // System.out.println("Contient "+epreuve.getEpreuveLibelle()+"liste epre "+modificationController.getListEpreuve());
            if (modificationController.getListEpreuve().contains(epreuve)) {
                modificationController.getListViewEpreuve().getSelectionModel().select(epreuve);
            }
        }
       
       // modificationController.getListViewEpreuve().setItems(candidatPosteJury.getEpreuves());
        modificationController.setComboboxPoste(modificationController.getListPoste());
        modificationController.getComboboxPoste().getSelectionModel().select(candidatPosteJury.getPoste());
        modificationController.setComboboxRegion(modificationController.getListRegion());
        modificationController.getComboboxRegion().getSelectionModel().select(candidatPosteJury.getLocaliteCand().getParentLocalite().getParentLocalite());
        modificationController.setComboboxProvince(modificationController.getListProvince());
        modificationController.getComboboxProvince().getSelectionModel().select(candidatPosteJury.getLocaliteCand().getParentLocalite());
        modificationController.setComboboxCommune(modificationController.getListCommune());
        modificationController.getComboboxCommune().getSelectionModel().select(candidatPosteJury.getLocaliteCand());
        modificationController.setComboboxStructure(modificationController.getListStruture());
        modificationController.getComboboxStructure().getSelectionModel().select(candidatPosteJury.getStructure());
        modificationController.setComboboxTypeStructure(modificationController.getListTypeStruture());
        modificationController.getComboboxTypeStructure().getSelectionModel().select(candidatPosteJury.getStructure().getTypeStructure());
        modificationController.setComboboxSexe(modificationController.getListSexe());
        modificationController.getComboboxSexe().getSelectionModel().select(candidatPosteJury.getCandidat().getSexe());
        modificationController.chargeFormulaire(candidatPosteJury);
        
         

        // Créez une nouvelle fenêtre (stage) pour le dialogue modal
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL); // Rend la fenêtre modale
        modalStage.initStyle(StageStyle.UTILITY); // Style de la fenêtre modal
        
        Screen screen = Screen.getPrimary();
        double screenWidth = screen.getBounds().getWidth()-100.0;
        double screenHeight = screen.getBounds().getHeight()-100.0;
        // Définissez le contenu du formulaire à afficher dans le dialogue modal
        modalStage.setScene(new Scene(root,screenWidth, screenHeight));

        // Affichez le dialogue modal
        modalStage.showAndWait();
        listAll();
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
    public void onChangeTypeList() throws SQLException{
        String type = comboboxTypeList.getValue();
        if(type.equalsIgnoreCase("Tout")){
            comboboxValeurList.setDisable(true);
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                //System.out.println("All Province"+backendCandidatPosteJuryController.getAll().stream().count());
                 ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll().stream()
                .map(obj-> (obj instanceof CandidatPosteJury)?(CandidatPosteJury) obj : null)
                       .filter(candidat->candidat != null && candidat.getLocaliteCand().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                      .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));                      
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                System.out.println("All Region"+backendCandidatPosteJuryController.getAll().stream().count());
                ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll().stream()
                .map(obj-> (obj instanceof CandidatPosteJury)?(CandidatPosteJury) obj : null)
                        .filter(candidat->candidat != null && candidat.getLocaliteCand().getParentLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll());
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));         
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll());
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));   
            }
            
        }else if(type.equalsIgnoreCase("Par Etablissement")){
            comboboxValeurList.setDisable(false);
            tableView.getItems().clear();
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                listStruture = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",sessionManager.getUser().getStructure().getLocalite().getParentLocalite()));
                comboboxValeurList.setItems(listStruture);
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                listStruture = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue()));
                comboboxValeurList.setItems(listStruture);
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                listStruture = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue()));
                comboboxValeurList.setItems(listStruture);
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                listStruture = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue()));
            }
        }else if(type.equalsIgnoreCase("Par Structure")){
            comboboxValeurList.setDisable(false);
            tableView.getItems().clear();
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                listStruture = convertToFxList(backendEtablissementController.getAll("Structure")
                .stream()
                .map(obj-> (obj instanceof Structure)?(Structure) obj : null)
                        .filter(structure->structure != null && structure.getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                comboboxValeurList.setItems(listStruture);
                filterOnComboBox(comboboxValeurList,listStruture);
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                listStruture = convertToFxList(backendEtablissementController.getAll("").stream()
                .map(obj-> (obj instanceof Structure)?(Structure) obj : null)
                        .filter(structure->structure != null && structure.getLocalite().getParentLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                comboboxValeurList.setItems(listStruture);
                filterOnComboBox(comboboxValeurList,listStruture);        
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                listStruture = convertToFxList(backendEtablissementController.getAll("").stream()
                .map(obj-> (obj instanceof Structure)?(Structure) obj : null)
                        .filter(structure->structure != null && structure.getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                comboboxValeurList.setItems(listStruture);
                filterOnComboBox(comboboxValeurList,listStruture); 
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                listStruture = convertToFxList(backendEtablissementController.getAll("").stream()
                .map(obj-> (obj instanceof Structure)?(Structure) obj : null)
                        .filter(structure->structure != null && structure.getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                comboboxValeurList.setItems(listStruture);
                filterOnComboBox(comboboxValeurList,listStruture);
            }
        }
    }
    
    public void onChangeValeurList(){
        String type = comboboxTypeList.getValue();
        if(type.equalsIgnoreCase("Par Etablissement")){
            try {
                Structure etablissement = listStruture.stream()
                    .filter(obj -> (obj instanceof Structure))
                    .map(obj -> (Structure) obj)
                    .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxValeurList.getValue().toString()))
                    .findFirst().get();
              //  Structure etablissement = (Structure)comboboxValeurList.getValue();
                ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll().stream()
                .map(obj-> (obj instanceof CandidatPosteJury)?(CandidatPosteJury) obj : null)
                        .filter(candidat->candidat != null && candidat.getStructure().getId().equals(etablissement.getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
              } catch (SQLException ex) {
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }else if(type.equalsIgnoreCase("Par Structure")){
            try {
                Structure etablissement = listStruture.stream()
                    .filter(obj -> (obj instanceof Structure))
                    .map(obj -> (Structure) obj)
                    .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxValeurList.getValue().toString()))
                    .findFirst().get();
           //     Structure etablissement = (Structure)comboboxValeurList.getValue();
                ObservableList<Object> typeList = convertToFxList(backendCandidatPosteJuryController.getAll().stream()
                .map(obj-> (obj instanceof CandidatPosteJury)?(CandidatPosteJury) obj : null)
                        .filter(candidat->candidat != null && candidat.getStructure().getId().equals(etablissement.getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom()));
                colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getMatricule()));
                colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNip()));
                colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getCandidat().getSexe())));
                colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getTelephone()));
                colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocaliteCand().getNomLoclite()));
                colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
                colDiscipline.setCellValueFactory(cellData -> {
                    CandidatPosteJury candidat = cellData.getValue();
                    List<Epreuve> epreuves = candidat.getEpreuves();
                    StringJoiner epreuvesJoiner = new StringJoiner(";");
                    for (Epreuve epreuve : epreuves) {
                        epreuvesJoiner.add(epreuve.getEpreuveLibelle());
                    }

                    return new SimpleStringProperty(epreuvesJoiner.toString());
                });
                colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtatCandidature()));
              } catch (SQLException ex) {
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
     public void onChangeRegion(){
        try {
            Localite region = (Localite)comboboxRegion.getValue();
            comboboxProvince.setItems(convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString())));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
