/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendNatureHandicapController;
import bf.menapln.controller.BackendTypeController;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.generique.ActionButtonTableCell;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class NatureHandicapController extends VueController implements Initializable {
    @FXML
    public ComboBox<Object> comboboxTypeHandicap; 
    
    @FXML
    public TextField NatureHandicapField; 
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Localite,Integer> colId;
    
    @FXML
    public TableColumn<String,String> colTypeHandicap;
    
    @FXML
    public TableColumn<String, String> colNatureHandicap;
    
    ObservableList<Object> listTypeHandicap;
    
    BackendTypeController backendTypeController;
    BackendNatureHandicapController backendNatureHandicapController;
    
    public NatureHandicapController() throws SQLException {
        this.backendTypeController = new BackendTypeController();
        this.backendNatureHandicapController = new BackendNatureHandicapController();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listTypeHandicap = convertToFxList(backendTypeController.getAll("Type handicap"));
            comboboxTypeHandicap.setItems(listTypeHandicap);
            listAll();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(NatureHandicapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        if (comboboxTypeHandicap != null && comboboxTypeHandicap.getSelectionModel().getSelectedItem() != null) {
            formData.put("typeHandicap", ((Type) comboboxTypeHandicap.getSelectionModel().getSelectedItem()));
        } else {
            System.out.println("Null 1");
        }

        if (NatureHandicapField != null) {
            formData.put("natureHandicap", NatureHandicapField.getText());
        } else {
            System.out.println("Null 2");
        }

        if (backendNatureHandicapController != null) {
            backendNatureHandicapController.save(formData);
        } else {
            System.out.println("Null 3");
        }
           // backendNatureHandicapController.save(formData);
            NatureHandicapField.clear();
            comboboxTypeHandicap.setValue(null);
    }
     
     @FXML
    public void listAll() throws SQLException{
        TableColumn<Localite, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                tableView,
                    event -> {
                        Localite t = (Localite) event.getSource();
                        
                            // Logique pour l'édition en ouvrant un modal
                        //editType(t);
                },
                    event -> {
                // Logique pour la suppression en ouvrant un modal de confirmation
                    //Type data = event;
                // Utilisez "data" pour effectuer la suppression
            }
        );
        
        
        ObservableList<Object> natureHandicap = convertToFxList(backendNatureHandicapController.getAll());
        for (Object item : natureHandicap) {
            System.out.println(item);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("natureHandicap_id"));
        colTypeHandicap.setCellValueFactory(new PropertyValueFactory<>("typeHandicapLibelle"));
        colNatureHandicap.setCellValueFactory(new PropertyValueFactory<>("natureHandicapLibelle"));
        tableView.setItems(natureHandicap);
        
 }
    
}
