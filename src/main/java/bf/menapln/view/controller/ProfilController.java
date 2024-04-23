/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.exception.EmptyDataException;
import java.net.URL;
import bf.menapln.entity.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class ProfilController extends VueController implements Initializable {
    
    @FXML
    private TextField profilField;
    
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<Object,Integer> colId;

    @FXML
    public TableColumn<Profil,String> colProfil;
    
    
    
     public ProfilController() throws SQLException {
        this.backendProfilController = new BackendProfilController();
        this.backendMenuController = new BackendMenuController();

    }
     
        BackendProfilController backendProfilController;
        BackendMenuController backendMenuController;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setVisible(false);
       
        listAll();
    }
  
    public void saveAction() throws EmptyDataException, SQLException {
    try { 
        HashMap formData = new HashMap();
        formData.put("profilLibelle", profilField.getText()); 
        backendProfilController.save(formData);
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
        listAll();
        profilField.setText("");
    } catch (exception.EmptyDataException ex) {
        infoBoxError(ex.getMessage(), "Erreur", null);
  }
}
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> profilList = convertToFxList(backendProfilController.getAll());
            tableView.setItems(profilList);
            colProfil.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getProfilLibelle()));
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
}
