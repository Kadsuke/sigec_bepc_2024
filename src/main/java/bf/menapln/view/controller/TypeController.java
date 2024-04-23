/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendTypeController;
import bf.menapln.entity.Type;
import bf.menapln.generique.ActionButtonTableCell;
import exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class TypeController extends VueController implements Initializable {
@FXML 
private ComboBox<String> comboboxTypeH;

@FXML 
private ComboBox<String> comboboxTypeB;

@FXML
private TextField typeLibelleField;

@FXML
private TextField rechercheType;

@FXML
public TableView tableView;
    
@FXML
public TableColumn<Type,Integer> colId;

@FXML
public TableColumn<Type,String> colLibelle;

    
ObservableList<String> list = FXCollections.observableArrayList("Localité",
        "Statut étab.","Offre ens.","Type struct.","Type épreuve","Poste jury"
,"Type candidat","Type insc.","Type handicap","Prescription hand.",
"Type Concours","Type Centre","Type situation","Type serie");

    /**
     * Initializes the controller class.
     */
    public TypeController() throws SQLException {
        this.backendController = new BackendTypeController();
    }

    BackendTypeController backendController;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboboxTypeH.setItems(list);
        comboboxTypeB.setItems(list);
        
    }    
    @FXML
    public void comboChange(ActionEvent e) throws SQLException{
        comboboxTypeB.setValue(comboboxTypeH.getValue());
        listAll(e);
    }
    
    @FXML
    public void editType(Type tableItem) {
        
        // Implémentez la logique de modification avec l'objet "data"
        // Vous pouvez ouvrir un formulaire de modification ici
        System.out.println("Modifier Type : " + tableItem.getId());
    }
    @FXML
    public void listAll(ActionEvent e) throws SQLException{        
        String valeur = comboboxTypeB.getValue();
        ObservableList<Object> typeList = convertToFxList(backendController.getAll(valeur));          
        colId.setCellValueFactory(new PropertyValueFactory<Type,Integer>("id"));
        colLibelle.setCellValueFactory(new PropertyValueFactory<Type,String>("libelle"));
        tableView.setItems(typeList);
        
 }
    @FXML
    public void saveAction(ActionEvent e) throws SQLException, EmptyDataException{
        HashMap<String,String> formData = new HashMap<String,String>();
        formData.put("typoField", comboboxTypeB.getValue());
        formData.put("typeLibelle", typeLibelleField.getText());
        backendController.save(formData);
        typeLibelleField.clear();
    }
}
