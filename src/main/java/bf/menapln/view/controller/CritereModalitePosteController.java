/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CritereModalitePosteController extends VueController implements Initializable {

    @FXML
    public ComboBox<Object> comboboxPoste;
    
    @FXML
    public ComboBox<Object> comboboxCritere;
    
    @FXML
    public ComboBox<String> comboboxTypeChamp;
    
    @FXML
    public TextField ponderationField;
    
    @FXML
    public TextField ordreField;
    
    @FXML
    public TableColumn<CriterePoste,String> colPoste;
    
    @FXML
    public TableColumn<CriterePoste,String> colCritere;
    
    @FXML
    public TableColumn<CriterePoste,String> coltypeChamp;
    
    @FXML
    public TableColumn<CriterePoste,String> colPonderationCritere;
    
    @FXML
    public TableColumn<CriterePoste,String> colModalite;
    
    @FXML
    public TableColumn<CriterePoste,String> colPonderationModalite;
    
    @FXML
    public TableColumn<CriterePoste,String> colOrdre;
    
    @FXML
    public TableView tableView;
    
    @FXML
    private ListView<Object> listViewModalite;
    
    Objet session;
    public CritereModalitePosteController() throws SQLException {
        this.backendModaliteController = new BackendModaliteController();
        this.backendSessionController = new BackendSessionController();
        this.backendTypeController = new BackendTypeController();
        this.backendCritereController = new BackendCritereController();
        this.backendCriterePosteController = new BackendCriterePosteController();
    }
    
    
    BackendModaliteController backendModaliteController;
    BackendCritereController backendCritereController;
    BackendSessionController backendSessionController;
    BackendTypeController backendTypeController;
    BackendCriterePosteController backendCriterePosteController;
    
    ObservableList<Object> listTypePoste,listModalite,listCritere;
    
    ObservableList<String> listTypeChamp = FXCollections.observableArrayList("Choix Multiple",
        "Choix Unique");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            session = backendSessionController.getSessionActive();
            listTypePoste = convertToFxList(backendTypeController.getAll("Poste jury"));
            listModalite = convertToFxList(backendModaliteController.getAll());
            listCritere = convertToFxList(backendCritereController.getAll());
           // listAll();
            comboboxTypeChamp.setItems(listTypeChamp);
            comboboxPoste.setItems(listTypePoste);
            comboboxCritere.setItems(listCritere);
            listViewModalite.setItems(listModalite);
            listViewModalite.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } catch (SQLException ex) {
            Logger.getLogger(CritereModalitePosteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAction() throws EmptyDataException, SQLException {
        HashMap formData = new HashMap();
        formData.put("session", (Session)session);
        formData.put("poste", (Type)comboboxPoste.getValue());
        formData.put("critere", (Critere)comboboxCritere.getValue());
        formData.put("typeChamp", (String)comboboxTypeChamp.getValue());
        formData.put("ponderationCritere", Double.valueOf(ponderationField.getText()));
        formData.put("ordreCritere", Long.valueOf(ordreField.getText()));
        formData.put("listmodalite", listViewModalite.getSelectionModel().getSelectedItems());
        backendCriterePosteController.save(formData);
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
        comboboxCritere.setValue(null);
        comboboxTypeChamp.setValue(null);
        ponderationField.clear();
        listViewModalite.getSelectionModel().clearSelection();
      //  listAll();
    }
    
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> modaliteList = convertToFxList(backendCritereController.getAll());
            tableView.setItems(modaliteList);
           colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
           colCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getCritereLibelle()));
           coltypeChamp.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getTypeChamp()));
           colPonderationCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getPonderationCritere().toString()));
           colModalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getModalite().getModaliteLibelle()));
           colPonderationModalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPonderationModalite().toString()));
           colOrdre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOrdre().toString()));
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
    
}
