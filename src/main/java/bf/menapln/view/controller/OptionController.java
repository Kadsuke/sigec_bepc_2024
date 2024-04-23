/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendOptionController;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.Option;
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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class OptionController extends VueController implements Initializable {
    
    @FXML
    public TextField optionField;

    @FXML
    public TextField definitionField;

    @FXML
    public VBox listePanel;
    
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<Option,Integer> colId;
    
    @FXML
    public TableColumn<Option, String> colOption;
    
    @FXML
    public TableColumn<Option, String> colDefinition;
    
     
    public OptionController() throws SQLException {
        this.backendController = new BackendOptionController();
    }

    BackendOptionController backendController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            listOptions();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
       public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap<String,String> formData = new HashMap<String,String>();
        formData.put("optionLibelle", optionField.getText());
        formData.put("optionDefinition", definitionField.getText());
        //System.out.println("DONNEES : "+formData);
        backendController.save(formData);
        optionField.clear();
        definitionField.clear();
        listOptions();
}      
    
    @FXML
    private void listOptions() throws SQLException{
       try {
        ObservableList<Object> optionList = convertToFxList(backendController.getAll());
        colId.setCellValueFactory(new PropertyValueFactory<Option,Integer>("id"));
        colOption.setCellValueFactory(new PropertyValueFactory<Option,String>("optionLibelle"));
        colDefinition.setCellValueFactory(new PropertyValueFactory<Option, String>("optionDefinition"));
        //System.out.println("LES FILIÈRES : "+filieres);
        tableView.setItems( optionList);
        } catch (SQLException ex) {
            Logger.getLogger("ERREUR ").log(Level.SEVERE, null, ex);
        }


    
    }
}
