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
 * @author LENOVO
 */
public class ProfilMenuController extends VueController implements Initializable {

    @FXML
    private ListView listViewMenu;
    
    @FXML
    private TextField profilField;
    
    @FXML
    private ComboBox<Object> comboboxProfil;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<Object,Integer> colId;

    @FXML
    public TableColumn<Object,String> colProfil;
    
    @FXML
    public TableColumn<Object,String> colMenu;
    
     public ProfilMenuController() throws SQLException {
        this.backendMenuController = new BackendMenuController();
        this.backendProfilController = new BackendProfilController();

    }
     
        BackendMenuController backendMenuController;
        BackendProfilController backendProfilController;
        
    ObservableList<Object> listMenu,listProfil;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            colId.setVisible(false);
            listMenu = convertToFxList(backendMenuController.getAll());
            listProfil = convertToFxList(backendProfilController.getAll());
            comboboxProfil.setItems(listProfil);
            listViewMenu.setItems(listMenu);
            listViewMenu.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } catch (SQLException ex) {
            Logger.getLogger(ProfilMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public void saveAction() throws EmptyDataException, SQLException {
        try { 
            HashMap formData = new HashMap();
            ObservableList<Object> selectedItems = listViewMenu.getSelectionModel().getSelectedItems();
            List<Menu> menus = new ArrayList<>();
            for (Object item : selectedItems) {
                menus.add((Menu)item);
            }
            formData.put("menus", (List<Menu>)menus);
            formData.put("profil", (Profil)comboboxProfil.getValue()); 
            backendProfilController.saveProfilMenu(formData);
            infoBoxSuccess("Enregistré avec succès", "Succès", null);
            comboboxProfil.setValue(null);
            listViewMenu.getSelectionModel().clearSelection();
        } catch (exception.EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        }
    }
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> critereList = convertToFxList(backendProfilController.getAll());
        //    tableView.setItems(critereList);
        //    colCritere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCritereLibelle()));
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
}
