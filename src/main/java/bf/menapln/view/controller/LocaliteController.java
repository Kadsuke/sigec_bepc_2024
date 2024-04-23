/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendLocaliteController;
import bf.menapln.controller.BackendTypeController;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LocaliteController extends VueController implements Initializable {

    
    @FXML
    public ComboBox<Object> comboboxTypeLocalite; 
    
    @FXML
    public ComboBox<Object> comboboxLocaliteParente; 
    
    @FXML
    public TextField codeLocaliteField; 
        
    @FXML
    public TextField nomLocaliteField;
    
    @FXML
    public TextField rechercheField; 
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Localite,Integer> colId;
    
    @FXML
    public TableColumn<Localite,String> colTypeLocalite;
    
    @FXML
    public TableColumn<Localite, String> colLocaliteParente;
    
    @FXML
    public TableColumn<Localite, String> colCodeLocalite;
    
    @FXML
    public TableColumn<Localite, String> colNomLocalite;
    
    
    ObservableList<Object> listType,listParent;
    
    
    
    public LocaliteController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendTypeController = new BackendTypeController();
    }

    BackendLocaliteController backendLocaliteController;
    BackendTypeController backendTypeController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            listType =  convertToFxList(backendTypeController.getAll("Localité"));
            comboboxTypeLocalite.setItems(listType);
            listAll();
            rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                this.fieldRechercheKeyUp();
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilCandidatPosteJuryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            colId.setVisible(false);
            } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public  void fieldRechercheKeyUp() throws SQLException{
        listAll();
        this.filtrerTableView(this.tableView,rechercheField.getText());
    }
    @FXML
    public void onChangeActionType(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Type typeLocalite = (Type) comboboxTypeLocalite.getValue();
        if(typeLocalite.getLibelle().equalsIgnoreCase("région")){
            comboboxLocaliteParente.setDisable(true);
        }else if(typeLocalite.getLibelle().equalsIgnoreCase("province")){
            comboboxLocaliteParente.setDisable(false);
            listParent = convertToFxList(backendLocaliteController.getAllByType("region"));
            comboboxLocaliteParente.setItems(listParent);
        }else if(typeLocalite.getLibelle().equalsIgnoreCase("commune")){
            comboboxLocaliteParente.setDisable(false);
            listParent = convertToFxList(backendLocaliteController.getAllByType("province"));
            comboboxLocaliteParente.setItems(listParent);
        }else if(typeLocalite.getLibelle().equalsIgnoreCase("Secteur/village")){
            comboboxLocaliteParente.setDisable(false);
            listParent = convertToFxList(backendLocaliteController.getAllByType("commune"));
            comboboxLocaliteParente.setItems(listParent);
        }
        else if(typeLocalite.getLibelle().equalsIgnoreCase("Zone")){
            comboboxLocaliteParente.setDisable(false);
            listParent = convertToFxList(backendLocaliteController.getAllByType("commune"));
            comboboxLocaliteParente.setItems(listParent);
        }
    }

     public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        formData.put("typeLocalite", ((Type)comboboxTypeLocalite.getValue()));
        formData.put("parentLocalite", ((Localite)comboboxLocaliteParente.getValue()));
        formData.put("codeLocalite", codeLocaliteField.getText());
        formData.put("nomLocalite", nomLocaliteField.getText());  
        backendLocaliteController.save(formData);
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
        listAll();
        nomLocaliteField.clear();
        codeLocaliteField.clear();
    }
     
     @FXML
    public void listAll() throws SQLException{
        ObservableList<Object> typeList = convertToFxList(backendLocaliteController.getAll());
        tableView.setItems(typeList);
        //colId.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getId()));
        colTypeLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeLocalite().getLibelle()));
        colLocaliteParente.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getParentLocalite().getNomLoclite()));
        colCodeLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCodeLocalite()));
        colNomLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNomLoclite()));   
 }
    
}
