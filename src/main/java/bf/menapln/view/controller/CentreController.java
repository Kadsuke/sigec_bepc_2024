/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.Localite;
import bf.menapln.entity.*;
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

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CentreController extends VueController implements Initializable {
    
    
    @FXML
    public ComboBox<Object> comboboxTypeCentre;
    
    @FXML
    public ComboBox<Object> comboboxRegion; 
    
    @FXML
    public ComboBox<Object> comboboxProvince; 
    
    @FXML
    public ComboBox<Object> comboboxCommune;
    
    @FXML
    public ComboBox<Object> comboboxVillageSecteur;
    
    Objet session;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Centre,String> colTypeCentre;
    
    @FXML
    public TableColumn<Centre, String> colCentre;
    
    ObservableList<Object> listTypeCentre,listRegion,listProvince,listCommune,listVillage;
    public CentreController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendStructureController = new BackendStructureController();
        this.backendTypeController = new BackendTypeController();
        this.backendSessionController = new BackendSessionController();
        this.backendCentreController = new BackendCentreController();
    }
    BackendLocaliteController backendLocaliteController;
    BackendStructureController backendStructureController;
    BackendTypeController backendTypeController;
    BackendSessionController backendSessionController;
    BackendCentreController backendCentreController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listRegion = convertToFxList(backendLocaliteController.getAll("region"));
            listTypeCentre = convertToFxList(backendTypeController.getAll("Type Centre"));
            session = backendSessionController.getSessionActive();
            comboboxRegion.setItems(listRegion);
            comboboxTypeCentre.setItems(listTypeCentre);
            listCentre();
        } catch (SQLException ex) {
            Logger.getLogger(CentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
     public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap();
        Type typeCentre = (Type) comboboxTypeCentre.getValue();
            formData.put("localite", ((Localite)comboboxCommune.getValue()));
            formData.put("centre", ((Localite)comboboxVillageSecteur.getValue()));
            formData.put("session", ((Session)session));
            formData.put("typeCentre", ((Type)comboboxTypeCentre.getValue()));
            backendCentreController.save(formData);
            infoBoxSuccess("Enregistré avec succès", "Succès", null);
            listCentre();
            comboboxVillageSecteur.setValue(null);
        
        //listStruture();
    }
    
    // Changing Region
    @FXML
    public void onChangeActionRegion(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite region = (Localite) comboboxRegion.getValue();
        try {
            listProvince = convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString()));
            comboboxProvince.setItems(listProvince);
            filterOnComboBox(comboboxProvince,listProvince);
        } catch (SQLException ex) {
            Logger.getLogger(CentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Changing Province
    @FXML
    public void onChangeActionProvince(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite province = (Localite) comboboxProvince.getValue();
        System.out.print(province.getNomLoclite());
        try {
            listCommune = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
            comboboxCommune.setItems(listCommune);
            filterOnComboBox(comboboxCommune,listCommune);
        } catch (SQLException ex) {
            Logger.getLogger(CentreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Changing Commune
    @FXML
    public void onChangeActionCommune(ActionEvent e) throws SQLException, exception.EmptyDataException {
        Localite commune = (Localite) comboboxCommune.getValue();
        try {
            listVillage = convertToFxList(backendLocaliteController.getAllCentre(commune));
            comboboxVillageSecteur.setItems(listVillage);
        } catch (SQLException ex) {
            Logger.getLogger(CentreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void listCentre() throws SQLException{
       try {
        ObservableList<Object> centreList =convertToFxList(backendCentreController.getAll());
         colTypeCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeCentre().getLibelle()));
         colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentre().getNomLoclite()));
        tableView.setItems(centreList);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }


    
    }
}
