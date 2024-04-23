/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.Epreuve;
import bf.menapln.exception.*;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EpreuveController extends VueController implements Initializable {

    
    @FXML
    public TextField epreuveField;

    @FXML
    public TextField acronymeField;

    @FXML
    public ComboBox comboboxEpreuveParent;
    
    
    @FXML
    public VBox listePanel;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Epreuve,Integer> colId;
    
    @FXML
    public TableColumn<Epreuve, String> colEpreuve;
    
    @FXML
    public TableColumn<Epreuve, String> colAcronyme;
    
    @FXML
    public TableColumn<Epreuve, Epreuve> colEpreuveParente;
    
    
     
    public EpreuveController() throws SQLException {
        this.backendController = new BackendEpreuveController();
    }

    BackendEpreuveController backendController;
    ObservableList<Object> epreuveListAll;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listEpreuves();
            epreuveParent();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(EpreuveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void epreuveParent() throws SQLException{
         epreuveListAll = convertToFxList(backendController.getAll());
         comboboxEpreuveParent.setItems(epreuveListAll);
    }
    public void saveAction() {
        HashMap formData = new HashMap();
        formData.put("epreuveLibelle", epreuveField.getText());
        formData.put("epreuveAcronyme", acronymeField.getText());
        formData.put("parent_id", comboboxEpreuveParent.getValue());
            try {
                backendController.save(formData);
                infoBoxSuccess("Enregistré avec succès", "Succès", null);
                epreuveField.clear();
                acronymeField.clear();
                listEpreuves();
                epreuveParent();
            } catch (SQLException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            } catch (EmptyDataException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            } catch (exception.EmptyDataException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            }
            
            

}      
    
    @FXML
    private void listEpreuves() throws SQLException{
       try {
        ObservableList<Object> epreuveList =convertToFxList(backendController.getAll());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        //colEpreuveParente.setCellValueFactory(new PropertyValueFactory<>("parent_id"));
        colEpreuve.setCellValueFactory(new PropertyValueFactory<>("epreuveLibelle"));
        colAcronyme.setCellValueFactory(new PropertyValueFactory<>("epreuveAcronyme"));
        //System.out.println("LES FILIÈRES : "+filieres);
        tableView.setItems(epreuveList);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }


    
    }
}