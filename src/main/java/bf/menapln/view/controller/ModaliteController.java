/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendModaliteController;
import bf.menapln.entity.Pays;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModaliteController extends VueController implements Initializable {

    @FXML
    public TextField modaliteField;
    
    @FXML
    public TableColumn<Pays,Integer> colId;
    
    @FXML
    public TableColumn<Pays,String> colModalite;
    
    @FXML
    public TableView tableView;
    
    public ModaliteController() throws SQLException {
        this.backendController = new BackendModaliteController();
    }

    BackendModaliteController backendController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listModalite();
    }

    public void saveAction() throws EmptyDataException, SQLException {
        HashMap<String,String> formData = new HashMap<String,String>();
        formData.put("modalite", modaliteField.getText());
        backendController.save(formData);
        modaliteField.clear();
        listModalite();
    }
    
    @FXML
    private void listModalite(){
        try {            
            ObservableList<Object> modaliteList = convertToFxList(backendController.getAll());
            
           colId.setCellValueFactory(new PropertyValueFactory<Pays,Integer>("id"));
           colModalite.setCellValueFactory(new PropertyValueFactory<Pays,String>("modaliteLibelle"));
           tableView.setItems(modaliteList);
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }

        
    }
    
}
