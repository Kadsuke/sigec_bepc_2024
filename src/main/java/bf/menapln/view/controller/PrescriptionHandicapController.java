/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendNatureHandicapController;
import bf.menapln.controller.BackendPrescriptionNatureHandicapController;
import bf.menapln.controller.BackendTypeController;
import bf.menapln.entity.*;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class PrescriptionHandicapController extends VueController implements Initializable {
    
    @FXML
    private ListView<Object> listViewPrescription;
    
    @FXML
    private ComboBox<Object> comboboxNatureHandicap;
    
    ObservableList<Object> listTypePrescription,listNatureHandicap;
    
    BackendNatureHandicapController backendNatureHandicapController;
    BackendTypeController backendTypeController;
    BackendPrescriptionNatureHandicapController backendPrescriptionNatureHandicapController;
    
    public PrescriptionHandicapController() throws SQLException {
        this.backendNatureHandicapController = new BackendNatureHandicapController();
        this.backendTypeController = new BackendTypeController();
        this.backendPrescriptionNatureHandicapController = new BackendPrescriptionNatureHandicapController();
    }
    /**
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            listTypePrescription = convertToFxList(backendTypeController.getAll("Prescription hand."));
            listNatureHandicap = convertToFxList(backendNatureHandicapController.getAll());
            listViewPrescription.setItems(listTypePrescription);
            comboboxNatureHandicap.setItems(listNatureHandicap);
            listViewPrescription.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            //listAll();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(NatureHandicapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        ObservableList<Object> selectedItems = listViewPrescription.getSelectionModel().getSelectedItems();
//        formData.put("typeHandicap", ((Type) comboboxNatureHandicap.getSelectionModel().getSelectedItem()));
        for (Object item : selectedItems) {
            formData.put("typePrecription", ((Type) item));
            formData.put("natureHandicap", ((NatureHandicap) comboboxNatureHandicap.getSelectionModel().getSelectedItem()));
            backendPrescriptionNatureHandicapController.save(formData); 
        }
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
         comboboxNatureHandicap.setValue(null);
         listViewPrescription.getSelectionModel().clearSelection();
     
    }
     
     @FXML
    public void listAll() throws SQLException{
        
        
 }
   
    
}
