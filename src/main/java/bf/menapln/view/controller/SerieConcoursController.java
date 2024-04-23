/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.entity.Type;
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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SerieConcoursController extends VueController implements Initializable {
    
    @FXML
    private ListView<Object> listViewSerie;
    
    @FXML
    private ComboBox<Object> comboboxConcours;
    
    ObservableList<Object> listTypeSerie,listConcoursRattache;
    
    Objet session;
    
    BackendTypeController backendTypeController;
    BackendSerieConcoursRattacheController backendSerieConcoursRattacheController;
    BackendSessionController backendSessionController;
    
    public SerieConcoursController() throws SQLException {
        this.backendTypeController = new BackendTypeController();
        this.backendSerieConcoursRattacheController = new BackendSerieConcoursRattacheController();
        this.backendSessionController = new BackendSessionController();
    }
    /**
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            listTypeSerie = convertToFxList(backendTypeController.getAll("Type serie"));
            listConcoursRattache = convertToFxList(backendTypeController.getAll("Type Concours"));
            comboboxConcours.setItems(listConcoursRattache);
            session = backendSessionController.getSessionActive();
            listViewSerie.setItems(listTypeSerie);
            listViewSerie.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            //listAll();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(NatureHandicapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        ObservableList<Object> selectedItems = listViewSerie.getSelectionModel().getSelectedItems();
//        formData.put("typeHandicap", ((Type) comboboxNatureHandicap.getSelectionModel().getSelectedItem()));
        for (Object item : selectedItems) {
            formData.put("session" ,(Session)session);
            formData.put("serie", ((Type) item));
            formData.put("concoursRattache", ((Type) comboboxConcours.getValue()));
            backendSerieConcoursRattacheController.save(formData); 
        }
         listViewSerie.getSelectionModel().clearSelection();
     
    }
     
     @FXML
    public void listAll() throws SQLException{
        
        
 }
   
    
}
