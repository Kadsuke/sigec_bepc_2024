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
public class CritereController extends VueController implements Initializable {

    
    @FXML
    public TextField critereField;
    
    @FXML
    public TableColumn<Critere,String> colCritere;
    @FXML
    public TableView tableView;
    
    public CritereController() throws SQLException {
        this.backendCritereController = new BackendCritereController();
    }

    BackendCritereController backendCritereController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // TODO
            listAll(); 
    }
    public void saveAction() throws EmptyDataException, SQLException {
        HashMap formData = new HashMap();
        formData.put("critereLibelle", critereField.getText());
        backendCritereController.save(formData);
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
        critereField.clear();
        listAll();
    }
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> critereList = convertToFxList(backendCritereController.getAll());
            tableView.setItems(critereList);
            colCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritereLibelle()));
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
    
}
