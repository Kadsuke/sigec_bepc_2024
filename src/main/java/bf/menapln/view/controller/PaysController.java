/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendPaysController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import bf.menapln.exception.EmptyDataException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import bf.menapln.entity.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class PaysController extends VueController implements Initializable{

    @FXML
    public TextField indicatifField;

    @FXML
    public TextField nomPaysField;

    @FXML
    public TextField nationaliteField;

    @FXML
    public VBox listePanel;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Pays,Integer> colId;
    
    @FXML
    public TableColumn<Pays,String> colIndicatif;
    
    @FXML
    public TableColumn<Pays, String> colNomPays;
    
    @FXML
    public TableColumn<Pays, String> colNationalite;
    
    
    
    public PaysController() throws SQLException {
        this.backendController = new BackendPaysController();
    }

    BackendPaysController backendController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setVisible(false);
        listPays();
      //  btnNouveau.setVisible(false);
    }    
    
    public void saveAction() throws EmptyDataException, SQLException {
        HashMap<String,String> formData = new HashMap<String,String>();
        formData.put("indicatif", indicatifField.getText());
        formData.put("nomPays", nomPaysField.getText());
        formData.put("nationalite", nationaliteField.getText());
        backendController.save(formData);
        indicatifField.clear();
        nomPaysField.clear();
        nationaliteField.clear();
        listPays();
    }
    
    @FXML
    private void listPays(){
        try {            
            ObservableList<Object> paysList = convertToFxList(backendController.getAll());
            
           colId.setCellValueFactory(new PropertyValueFactory<Pays,Integer>("id"));
           colIndicatif.setCellValueFactory(new PropertyValueFactory<Pays,String>("indicatif"));
           colNomPays.setCellValueFactory(new PropertyValueFactory<Pays, String>("nomPays"));
           colNationalite.setCellValueFactory(new PropertyValueFactory<Pays, String>("nationalite"));
           tableView.setItems(paysList);
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
    
}
