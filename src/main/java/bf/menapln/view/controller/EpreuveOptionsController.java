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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EpreuveOptionsController extends VueController implements Initializable {


    @FXML
    public ComboBox<Object> comboboxOption;

     @FXML
    public ComboBox<Object> comboboxEpreuve;
     
    @FXML
    public ComboBox<Object> comboboxTypeEpreuve;
      
    @FXML
    public TextField coefficientField;
       
    @FXML
    public TextField ordreEpreuveField;
    
    @FXML
    public ComboBox<String> comboboxDuree;
         
    @FXML
    public ComboBox<String> comboboxComposePremierTour;
           
    @FXML
    public ComboBox<String> comboboxComposeSecondTour;
                  
    @FXML
    public ComboBox<String> comboboxRachetable;
           
    
    @FXML
    public VBox listePanel;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<EpreuveOptions,Integer> colId;
    
    @FXML
    public TableColumn<EpreuveOptions, String> colOption;
    
    @FXML
    public TableColumn<EpreuveOptions, String> colEpreuve;
    
    @FXML
    public TableColumn<EpreuveOptions, String> colType;
    
    @FXML
    public TableColumn<EpreuveOptions, String> colCoefficient;
    
    @FXML
    public TableColumn<EpreuveOptions, String> colDuree;
    
    @FXML
    public TableColumn<Object,String> colOrdreEpreuve;
    
    ObservableList<Object> listOption,listEpreuve,listTypeEpreuve;
    
    Objet session;
    
    ObservableList<String> list = FXCollections.observableArrayList("Oui","Non");
    
    public EpreuveOptionsController() throws SQLException {
        this.backendEpreuveOptionController = new BackendEpreuveOptionsController();
        this.backendSessionController = new BackendSessionController();
        this.backendEpreuveController = new BackendEpreuveController();
        this.backendOptionController = new BackendOptionController();
        this.backendTypeController = new BackendTypeController();
    }

    BackendEpreuveOptionsController backendEpreuveOptionController;
    BackendSessionController backendSessionController;
    BackendEpreuveController backendEpreuveController;
    BackendOptionController backendOptionController;
    BackendTypeController backendTypeController;
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboboxRachetable.setItems(list);
        comboboxComposePremierTour.setItems(list);
        comboboxComposeSecondTour.setItems(list);
        try {
            listOption = convertToFxList(backendOptionController.getAll());
            listEpreuve = convertToFxList(backendEpreuveController.getAll());
            listTypeEpreuve = convertToFxList(backendTypeController.getAll("Type épreuve"));
            session = backendSessionController.getSessionActive();
            comboboxOption.setItems(listOption);
            comboboxEpreuve.setItems(listEpreuve);
            comboboxTypeEpreuve.setItems(listTypeEpreuve);
            
        } catch (SQLException ex) {
            Logger.getLogger(EpreuveOptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Remplir le ComboBox avec les heures et les minutes
        for (int hour = 0; hour < 5; hour++) {
            for (int minute = 0; minute < 60; minute += 5) {
                String formattedTime = String.format("%02d:%02d", hour, minute);
                comboboxDuree.getItems().add(formattedTime);
            }
        }
   
    }  

    public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap ();
        formData.put("session_id",  ((Session)session));
        formData.put("option_id", ((Option) comboboxOption.getValue()));
        formData.put("epreuve_id",  ((Epreuve) comboboxEpreuve.getValue()));
        formData.put("typeEpreuve_id", ((Type) comboboxTypeEpreuve.getValue()));
        formData.put("coefficient", coefficientField.getText());
        formData.put("duree", comboboxDuree.getValue());
        formData.put("estComposePreTour",  comboboxComposePremierTour.getValue());
        formData.put("estComposeSecTour",  comboboxComposeSecondTour.getValue());
        formData.put("estRachetable",  comboboxRachetable.getValue());
        formData.put("ordreEpreuve",  ordreEpreuveField.getText());
        backendEpreuveOptionController.save(formData);
        this.resetAction();
        
}

   @FXML
    public void resetAction() throws SQLException, exception.EmptyDataException{
        comboboxOption.setValue(null);
        comboboxEpreuve.setValue(null);
        comboboxTypeEpreuve.setValue(null);
        coefficientField.clear();
        comboboxDuree.setValue(null);
        comboboxComposePremierTour.setValue(null);
        comboboxComposeSecondTour.setValue(null);
        comboboxRachetable.setValue(null);
           
}

    
     @FXML
    private void listEpreuveOptions() throws SQLException{
        ObservableList<Object> epreuveOptionsList = convertToFxList(backendEpreuveOptionController.getAll());
        colOption.setCellValueFactory(new PropertyValueFactory<EpreuveOptions,String>("optionLibelle"));
        colEpreuve.setCellValueFactory(new PropertyValueFactory<EpreuveOptions, String>("epreuveLibelle"));
        colType.setCellValueFactory(new PropertyValueFactory<EpreuveOptions, String>("typeEpreuveLibelle"));
        colCoefficient.setCellValueFactory(new PropertyValueFactory<EpreuveOptions, String>("coefficient"));
        colDuree.setCellValueFactory(new PropertyValueFactory<EpreuveOptions, String>("duree"));
        //System.out.println("LES FILIÈRES : "+filieres);
        tableView.setItems(epreuveOptionsList);


    
    }
    
}
