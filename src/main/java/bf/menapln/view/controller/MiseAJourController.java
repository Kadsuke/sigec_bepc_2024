/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MiseAJourController extends VueController implements Initializable{

    @FXML
    public Button buttonDB;
    @FXML
    public Button buttonDP;
    @FXML
    public Button buttonLocalite;
    @FXML
    public Button buttonEtab;
    /**
     * Initializes the controller class.
     */
    public MiseAJourController() throws SQLException {
        this.backendMiseAJourController = new BackendMiseAJourController();
    }

    BackendMiseAJourController backendMiseAJourController;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonDP.setDisable(true);
        buttonEtab.setDisable(true);
        buttonLocalite.setDisable(true);
        buttonDB.setDisable(false);
        // TODO
    }
    @FXML
    public void miseAJourDirection(ActionEvent e) throws SQLException{
        backendMiseAJourController.saveDirection();
        infoBoxSuccess("Les liens des DP mis à jour avec succès", "Succès", null);
        buttonLocalite.setDisable(false);
        buttonDP.setDisable(true);
    }
    
    @FXML
    public void miseAJourLocalite(ActionEvent e) throws SQLException{
        backendMiseAJourController.saveLocalite();
        infoBoxSuccess("Les localités mis à jour avec succès", "Succès", null);
        buttonEtab.setDisable(false);
        buttonLocalite.setDisable(true);
    }
    
    @FXML
    public void miseAJourEtablissement(ActionEvent e) throws SQLException{
        backendMiseAJourController.saveEtablissement();
        infoBoxSuccess("Les établissements mis à jour avec succès", "Succès", null);
        buttonEtab.setDisable(true);
    }
    
    @FXML
    public void updateDatabase(ActionEvent e) throws SQLException{
        backendMiseAJourController.updateDatabase();
        infoBoxSuccess("La base de données mis à jour avec succès", "Succès", null);
        buttonLocalite.setDisable(true);
        buttonDB.setDisable(true);
    }
    
}
