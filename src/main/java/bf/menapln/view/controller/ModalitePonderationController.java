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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModalitePonderationController extends VueController implements Initializable {

    @FXML
    public ComboBox<Object> comboboxPoste;
    
    @FXML
    public ComboBox<Object> comboboxCritere;
    
    @FXML
    public TableColumn<CriterePoste,String> colPoste;
    
    @FXML
    public TableColumn<CriterePoste,String> colCritere;
    
    @FXML
    public TableColumn<CriterePoste,String> coltypeChamp;
    
    @FXML
    public TableColumn<CriterePoste,String> colPonderationCritere;
   
    @FXML
    public TableColumn<CriterePoste,String> colModaliteL;
    
    @FXML
    public TableColumn<CriterePoste,String> colPonderationModaliteL;
    
    @FXML
    public TableColumn<CriterePoste,String> colOrdre;
    //Edit Element
    @FXML
    public TableColumn<Modalite,String> colModalite;
    
    @FXML
    public TableColumn<Modalite,String> colPonderationModalite;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableView tableViewModalite;
    
    Objet session;
    public ModalitePonderationController() throws SQLException {
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
            listAll();
            comboboxPoste.setItems(listTypePoste);
            tableViewModalite.setEditable(true);
            colPonderationModalite.setCellFactory(TextFieldTableCell.forTableColumn());
            colPonderationModalite.setOnEditCommit(event -> {
                try {
                    Modalite modalite = event.getTableView().getItems().get(event.getTablePosition().getRow());
                    Type poste = (Type) comboboxPoste.getValue();
                    CriterePoste critNewPonde = new CriterePoste();
                    Critere critere = (Critere) comboboxCritere.getValue();
                    modalite.setPonderationModalite(Double.parseDouble(event.getNewValue()));
                    critNewPonde.setPoste(poste);
                    critNewPonde.setCritere(critere);
                    critNewPonde.setModalite(modalite);
                    critNewPonde.setSession((Session)session);
                    backendCriterePosteController.update(critNewPonde);
                    listAll();
                } catch (SQLException ex) {
                    infoBoxError(ex.getMessage(), "ERREUR", null);
                } catch (EmptyDataException ex) {
                    infoBoxError(ex.getMessage(), "ERREUR", null);
                }
            });
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    @FXML
    public void saveAction() throws EmptyDataException, SQLException {
        HashMap formData = new HashMap();
        formData.put("session", (Session)session);
        formData.put("poste", (Type)comboboxPoste.getValue());
        formData.put("critere", (Critere)comboboxCritere.getValue());
        backendCriterePosteController.save(formData);
        comboboxCritere.setValue(null);
     //   listAll();
    }
    
    @FXML
    public void onActionChangePoste(){
        try {
            Type poste = (Type) comboboxPoste.getValue();
            Type list = (Type)backendCriterePosteController.getByPoste(poste);
            listCritere = convertToFxList(list.getCriteres());
            comboboxCritere.setItems(listCritere);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    @FXML
    public void onActionChangeCritere(){
        try {
            Type poste = (Type) comboboxPoste.getValue();
            Critere critere = (Critere) comboboxCritere.getValue();
            Critere list = (Critere)backendCriterePosteController.getAllByPosteAndCritere(poste,critere);
            listModalite = convertToFxList(list.getModalites());
            tableViewModalite.setItems(listModalite);
            colPonderationModalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPonderationModalite().toString()));
            //listModalite = convertToFxList(backendModaliteController.getAll());
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> modaliteList = convertToFxList(backendCriterePosteController.getAll());
            tableView.setItems(modaliteList);
            colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
            colCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getCritereLibelle()));
            coltypeChamp.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getTypeChamp()));
            colPonderationCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritere().getPonderationCritere().toString()));
            colModaliteL.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getModalite().getModaliteLibelle()));
            colPonderationModaliteL.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPonderationModalite().toString()));
            colOrdre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOrdre().toString()));
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

        
    }
    
}
