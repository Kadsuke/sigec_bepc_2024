/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendLocaliteController;
import bf.menapln.controller.BackendStructureController;
import bf.menapln.controller.BackendTypeController;
import bf.menapln.entity.Localite;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class StructureController extends VueController implements Initializable {
    
    
    @FXML
    public ComboBox<Object> comboboxTypeStructure;
    
    @FXML
    public ComboBox<Object> comboboxRegion; 
    
    @FXML
    public ComboBox<Object> comboboxProvince; 
    
    @FXML
    public ComboBox<Object> comboboxCommune;
    
    @FXML
    public ComboBox<Object> comboboxVillageSecteur; 
    
    @FXML
    public ComboBox<Object> comboboxCentreExamen;
    
    @FXML
    public ComboBox<Object> comboboxStatutEtablissement; 
    
    @FXML
    public ComboBox<Object> comboboxOffreEnseignement;
    
    @FXML
    public ComboBox<Object> comboboxStructureParente;
    
    
    @FXML
    public TextField codeStrutureField; 
    
    @FXML
    public TextField nomStructureField; 
     
    @FXML
    public TextField acronymeStructureField; 

    @FXML
    public TextField capaciteStructureField;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Structure,Integer> colId;
    
    @FXML
    public TableColumn<Structure,String> colTypeStructure;
    
    @FXML
    public TableColumn<Structure, String> colCodeStructure;
    
    @FXML
    public TableColumn<Structure, String> colNomStructure;
    
    @FXML
    public TableColumn<Structure, String> colAcronymeStructure;
    
    @FXML
    public TableColumn<Structure, String> colLocalisation;
    @FXML 
    private ComboBox<Object> typeStruCharge;
    
    @FXML 
    private ComboBox<Object> typeLocalite;
    
    
    @FXML
    private TextField chemin;
    
    @FXML
    private Label zoneText;
    
    @FXML
    private Label zoneEtat;
    
    ObservableList<Object> listStructure,listRegion,listTypeOffre,listTypeStatut,listTypeStructure,listProvince,listCommune,listCentreExamen,listVillage;
    public StructureController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendStructureController = new BackendStructureController();
        this.backendTypeController = new BackendTypeController();
    }
    BackendLocaliteController backendLocaliteController;
    BackendStructureController backendStructureController;
    BackendTypeController backendTypeController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listRegion =  convertToFxList(backendLocaliteController.getAll("region"));
            listTypeOffre = convertToFxList(backendTypeController.getAll("Offre ens."));
            listTypeStatut = convertToFxList(backendTypeController.getAll("Statut étab."));
            listTypeStructure = convertToFxList(backendTypeController.getAll("Type struct."));
            listStructure = convertToFxList(backendStructureController.getAll(""));
            comboboxRegion.setItems(listRegion);
            comboboxStructureParente.setItems(listStructure);
            comboboxOffreEnseignement.setItems(listTypeOffre);
            comboboxStatutEtablissement.setItems(listTypeStatut);
            comboboxTypeStructure.setItems(listTypeStructure);
            
            //Desactivation des champs
            colId.setVisible(false);
            comboboxRegion.setDisable(true);
            comboboxProvince.setDisable(true);
            comboboxCommune.setDisable(true);
            comboboxVillageSecteur.setDisable(true);
            comboboxStatutEtablissement.setDisable(true);
            comboboxOffreEnseignement.setDisable(true);
            codeStrutureField.setDisable(true);
            nomStructureField.setDisable(true);
            acronymeStructureField.setDisable(true);
            capaciteStructureField.setDisable(true);
            comboboxStructureParente.setDisable(true);
             listStructure();
             typeStructures();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void typeStructures(){
        try {
           ObservableList<Object> types = convertToFxList(backendTypeController.getAll("Type struct."));
           typeStruCharge.setItems(types);
        } catch (SQLException ex) {
            this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    
     public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        Type typeStructure = (Type) comboboxTypeStructure.getValue();
        if(typeStructure.getLibelle().equalsIgnoreCase("etablissement")){
            formData.put("typeStructure", ((Type)comboboxTypeStructure.getValue()));
           // formData.put("localiteStructure", ((Localite)comboboxVillageSecteur.getValue()));
            formData.put("localiteStructure", ((Localite)comboboxCommune.getValue()));
            formData.put("structureParente", ((Structure)comboboxStructureParente.getValue()));
//            formData.put("centreExamen",((Localite)comboboxCentreExamen.getValue()));
            formData.put("codeStructure", codeStrutureField.getText());
            formData.put("nomStructure", nomStructureField.getText());
            formData.put("acronymeStructure", acronymeStructureField.getText());
            formData.put("statutEtablissement",((Type)comboboxStatutEtablissement.getValue()));
            formData.put("offreEnseignement", ((Type)comboboxOffreEnseignement.getValue()));
            formData.put("capacite", capaciteStructureField.getText());
            
        }else if(typeStructure.getLibelle().equalsIgnoreCase("direction régionale")){
            formData.put("typeStructure", ((Type)comboboxTypeStructure.getValue()));
            formData.put("localiteStructure", ((Localite)comboboxRegion.getValue()));
            formData.put("structureParente", ((Structure)comboboxStructureParente.getValue()));
       //     formData.put("centreExamen",((Localite)comboboxCentreExamen.getValue()));
            formData.put("codeStructure", codeStrutureField.getText());
            formData.put("nomStructure", nomStructureField.getText());
            formData.put("acronymeStructure", acronymeStructureField.getText());
            formData.put("statutEtablissement",((Type)comboboxStatutEtablissement.getValue()));
            formData.put("offreEnseignement", ((Type)comboboxOffreEnseignement.getValue()));
            formData.put("capacite", capaciteStructureField.getText());
            
        }else if(typeStructure.getLibelle().equalsIgnoreCase("direction provinciale")){
            formData.put("typeStructure", ((Type)comboboxTypeStructure.getValue()));
            formData.put("localiteStructure", ((Localite)comboboxProvince.getSelectionModel().getSelectedItem()));
            formData.put("structureParente", ((Structure)comboboxStructureParente.getValue()));
      //      formData.put("centreExamen",((Localite)comboboxCentreExamen.getValue()));
            formData.put("codeStructure", codeStrutureField.getText());
            formData.put("nomStructure", nomStructureField.getText());
            formData.put("acronymeStructure", acronymeStructureField.getText());
            formData.put("statutEtablissement",((Type)comboboxStatutEtablissement.getValue()));
            formData.put("offreEnseignement", ((Type)comboboxOffreEnseignement.getValue()));
            formData.put("capacite", capaciteStructureField.getText());
        }
        backendStructureController.save(formData);
        codeStrutureField.clear();
        nomStructureField.clear();
        acronymeStructureField.clear();
        comboboxStatutEtablissement.setValue(null);
        comboboxOffreEnseignement.setValue(null);
        capaciteStructureField.clear();
        
        listStructure();
    }
     
     @FXML
    private void listStructure(){
        try {
            ObservableList<Object> structureList = convertToFxList(backendStructureController.getAll(""));
            tableView.setItems(structureList);
            //colId.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getId()));
            colTypeStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeStructure().getLibelle()));
            colCodeStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCodeStructure()));
            colNomStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNomStructure()));
            colAcronymeStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getAcronymeStructure()));    
            colLocalisation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLocalite().getNomLoclite()));
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void onChangeActionTypeStructure(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Type typeStructure = (Type) comboboxTypeStructure.getValue();
        if(typeStructure.getLibelle().equalsIgnoreCase("etablissement")){
            comboboxRegion.setDisable(false);
            comboboxProvince.setDisable(false);
            comboboxCommune.setDisable(false);
            comboboxVillageSecteur.setDisable(false);
            comboboxStatutEtablissement.setDisable(false);
            comboboxOffreEnseignement.setDisable(false);
            codeStrutureField.setDisable(false);
            nomStructureField.setDisable(false);
            acronymeStructureField.setDisable(false);
            capaciteStructureField.setDisable(false);
            comboboxStructureParente.setDisable(false);
            
            // Vider les champs
            comboboxRegion.setValue(null);
            comboboxProvince.setValue(null);
            comboboxCommune.setValue(null);
            comboboxVillageSecteur.setValue(null);
         //   comboboxCentreExamen.setValue(null);
            comboboxStatutEtablissement.setValue(null);
            comboboxOffreEnseignement.setValue(null);
            codeStrutureField.setText("");
            nomStructureField.setText("");
            acronymeStructureField.setText("");
            capaciteStructureField.setText("");
            comboboxStructureParente.setValue(null);
        }else if(typeStructure.getLibelle().equalsIgnoreCase("direction régionale")){
            comboboxRegion.setDisable(false);
            comboboxProvince.setDisable(false);
            comboboxCommune.setDisable(false);
            comboboxVillageSecteur.setDisable(false);
            comboboxStatutEtablissement.setDisable(true);
            comboboxOffreEnseignement.setDisable(true);
            codeStrutureField.setDisable(false);
            nomStructureField.setDisable(false);
            acronymeStructureField.setDisable(false);
            capaciteStructureField.setDisable(true);
            comboboxStructureParente.setDisable(true);
            
            // Vider les champs
            comboboxRegion.setValue(null);
            comboboxProvince.setValue(null);
            comboboxCommune.setValue(null);
            comboboxVillageSecteur.setValue(null);
            comboboxStatutEtablissement.setValue(null);
            comboboxOffreEnseignement.setValue(null);
            codeStrutureField.setText("");
            nomStructureField.setText("");
            acronymeStructureField.setText("");
            capaciteStructureField.setText("");
            comboboxStructureParente.setValue(null);
        }else if(typeStructure.getLibelle().equalsIgnoreCase("direction provinciale")){
            comboboxRegion.setDisable(false);
            comboboxProvince.setDisable(false);
            comboboxCommune.setDisable(false);
            comboboxVillageSecteur.setDisable(false);
            comboboxStatutEtablissement.setDisable(true);
            comboboxOffreEnseignement.setDisable(true);
            codeStrutureField.setDisable(false);
            nomStructureField.setDisable(false);
            acronymeStructureField.setDisable(false);
            capaciteStructureField.setDisable(true);
            comboboxStructureParente.setDisable(false);
            
            // Vider les champs
            comboboxRegion.setValue(null);
            comboboxProvince.setValue(null);
            comboboxCommune.setValue(null);
            comboboxVillageSecteur.setValue(null);
            comboboxStatutEtablissement.setValue(null);
            comboboxOffreEnseignement.setValue(null);
            codeStrutureField.setText("");
            nomStructureField.setText("");
            acronymeStructureField.setText("");
            capaciteStructureField.setText("");
            comboboxStructureParente.setValue(null);
        }
        
    }
    
    // Changing Region
    @FXML
    public void onChangeActionRegion(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite region = (Localite) comboboxRegion.getValue();
        try {
            listProvince = convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString()));
            comboboxProvince.setItems(listProvince);
            filterOnComboBox(comboboxProvince,listProvince);
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Changing Province
    @FXML
    public void onChangeActionProvince(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite province = (Localite) comboboxProvince.getValue();
        System.out.print(province.getNomLoclite());
        try {
            listCommune = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
            comboboxCommune.setItems(listCommune);
            filterOnComboBox(comboboxCommune,listCommune);
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Changing Commune
    @FXML
    public void onChangeActionCommune(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite commune = (Localite) comboboxCommune.getValue();
        try {
            listVillage = convertToFxList(backendLocaliteController.getAllByParent(commune.getId().toString()));
            comboboxVillageSecteur.setItems(listVillage);
            filterOnComboBox(comboboxVillageSecteur,listVillage);
        } catch (SQLException ex) {
            Logger.getLogger(StructureController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void parcourir(ActionEvent e){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node) e.getSource()).getScene().getWindow());
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier");
        fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Fichiers Excel", "*.xlsx"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            System.out.println(selectedFile);
            chemin.setText(selectedFile.toString());
        }
    }
    
    public void charger(){
        Type typeStructure = (Type)typeStruCharge.getSelectionModel().getSelectedItem();
        String path = chemin.getText();
        zoneEtat.setText("Importation en cours patienter ...");
        String ligneEchec = null;
        try {
            ligneEchec = backendStructureController.saveFiles(path, typeStructure);
            zoneEtat.setText("lignes non importées "+ligneEchec);
            infoBoxSuccess("Opération éffectuée avec succès", "Succès", null);
        } catch (SQLException | IOException  ex) {
            zoneEtat.setText("lignes non importées "+ligneEchec);
            infoBoxError(ex.getMessage(), "Erreur", null);
        } 
    }

}
