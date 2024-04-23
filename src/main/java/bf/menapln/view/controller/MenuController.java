/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import bf.menapln.exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MenuController extends VueController implements Initializable {

    @FXML
    private ComboBox<Object> comboboxMenuParente;
    
    @FXML
    private TextField menuField;
    
    @FXML
    private TextField actionMenuField;
    
    @FXML
    private TextField iconsMenuField;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<Menu,Long> colId;
    
    @FXML
    public TableColumn<Menu,String> colMenuParente;
    
    @FXML
    public TableColumn<Menu,String> colMenu;

    @FXML
    public TableColumn<Menu,String> colActionMenu;
    
    ObservableList<Object> listMenu;
   
    public MenuController() throws SQLException {
        this.backendMenuController = new BackendMenuController();

    }
     
        BackendMenuController backendMenuController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            listMenu = convertToFxList(backendMenuController.getAll());
            comboboxMenuParente.setItems(listMenu);
            listAll();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
            formData.put("menuParent_id", ((Menu)comboboxMenuParente.getValue()));
            formData.put("menuLibelle", menuField.getText());
            formData.put("action", actionMenuField.getText());
            formData.put("icons", iconsMenuField.getText());
            backendMenuController.save(formData);
            infoBoxSuccess("Enregistré avec succès", "Succès", null);
            listAll();
            //comboboxMenuParente.setValue(null);
            menuField.setText("");
            actionMenuField.setText("");
        
        //listStruture();
    }
    
    @FXML
    private void listAll(){
        try {            
            ObservableList<Object> menuList = convertToFxList(backendMenuController.getAll());
            tableView.setItems(menuList);
           // colMenuParente.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getParent().getId()));
            colMenu.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getMenuLibelle()));
            colActionMenu.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getAction()));
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
}
