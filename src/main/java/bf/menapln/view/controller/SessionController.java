/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendSessionController;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import bf.menapln.generique.ActionButtonTableCell;
import bf.menapln.service.TypeService;
import exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SessionController extends VueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private DatePicker dateDebutInscField;

    @FXML
    private DatePicker dateFinInscField;
    
    @FXML
    private DatePicker dateFinSessRemplField;
    
    @FXML
    private DatePicker dateDebutSessRemplField;
    
    @FXML
    private DatePicker dateDebutSessNormField;
    
    @FXML
    private DatePicker dateFinSessNormField;
    
    @FXML
    private TextField anneeField;
    
    @FXML
    private TextField moyAdmissionField;
    
    @FXML
    private TextField moyRachatField;
    
    @FXML
    private TextField moyAdmissibleField;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<Session,Integer> colId;
    
    @FXML
    public TableColumn<Session,String> colAnnee;
    
    @FXML
    public TableColumn<Session,String> colDebutSessNorm;
    
    @FXML
    public TableColumn<Session,String> colFinSessNorm;
    
    @FXML
    public TableColumn<Session,String> colDebutSessRempl;
    
    @FXML
    public TableColumn<Session,String> colFinSessRempl;
    
    @FXML
    public TableColumn<Session,String> colDebutInscription;
    
    @FXML
    public TableColumn<Session,String> colFinInscription;
    
    @FXML
    public TableColumn<Session,String> colMoyAdmission;
    
    @FXML
    public TableColumn<Session,String> colMoyRachat;
    
    @FXML
    public TableColumn<Session,String> colMoyAdmissibilite;
    
    
    public SessionController() throws SQLException {
        this.backendController = new BackendSessionController();
    }
    BackendSessionController backendController;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listAll();
        } catch (SQLException ex) {
            Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setVisible(false);
    }
    
    @FXML
    public void listAll() throws SQLException{
        TableColumn<Type, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                tableView,
                    event -> {
                        Type t = (Type) event.getSource();
                        
                            // Logique pour l'édition en ouvrant un modal
                       // editType(t);
                },
                    event -> {
                // Logique pour la suppression en ouvrant un modal de confirmation
                    //Type data = event;
                // Utilisez "data" pour effectuer la suppression
            }
        );
        
        ObservableList<Object> sessionList = convertToFxList(backendController.getAll());          
        colId.setCellValueFactory(new PropertyValueFactory<Session,Integer>("id"));
        colAnnee.setCellValueFactory(new PropertyValueFactory<Session,String>("annee"));
        colDebutSessNorm.setCellValueFactory(new PropertyValueFactory<Session,String>("dateDebutSessionNormale"));
        colFinSessNorm.setCellValueFactory(new PropertyValueFactory<Session,String>("dateFinSessionNormale"));
        colDebutSessRempl.setCellValueFactory(new PropertyValueFactory<Session,String>("dateDebutSessionRemplacement"));
        colFinSessRempl.setCellValueFactory(new PropertyValueFactory<Session,String>("dateFinSessionRemplacement"));
        colDebutInscription.setCellValueFactory(new PropertyValueFactory<Session,String>("dateDebutInscription"));
        colFinInscription.setCellValueFactory(new PropertyValueFactory<Session,String>("dateFinInscription"));
        colMoyAdmission.setCellValueFactory(new PropertyValueFactory<Session,String>("moyAdmission"));
        colMoyRachat.setCellValueFactory(new PropertyValueFactory<Session,String>("moyRachat"));
        colMoyAdmissibilite.setCellValueFactory(new PropertyValueFactory<Session,String>("moyAdmissible"));
        tableView.setItems(sessionList);      
 }
    @FXML
    public void saveAction(ActionEvent e) throws SQLException, EmptyDataException{
        HashMap<String,String> formData = new HashMap<String,String>();
        formData.put("annee", anneeField.getText());
        formData.put("dateDebutSessionRemplacement", dateDebutSessRemplField.getValue().toString());
        formData.put("dateFinSessionRemplacement", dateFinSessRemplField.getValue().toString());
        formData.put("dateDebutInscription", dateDebutInscField.getValue().toString());
        formData.put("dateFinInscription", dateFinInscField.getValue().toString());
        formData.put("dateDebutSessionNormale", dateDebutSessNormField.getValue().toString());
        formData.put("dateFinSessionNormale", dateFinSessNormField.getValue().toString());
        formData.put("moyAdmission", moyAdmissionField.getText());
        formData.put("moyRachat", moyRachatField.getText());
        formData.put("moyAdmissible", moyAdmissibleField.getText());
        listAll();
        backendController.save(formData);
        anneeField.clear();
        dateDebutSessRemplField.setValue(null);
        dateFinSessRemplField.setValue(null);
        dateDebutInscField.setValue(null);
        dateFinInscField.setValue(null);
        dateDebutSessNormField.setValue(null);
        dateFinSessNormField.setValue(null);
        moyAdmissionField.clear();
        moyRachatField.clear();
        moyAdmissibleField.clear();
    }
    
    @FXML
    public void resetAction(ActionEvent e) throws SQLException, EmptyDataException{
        anneeField.clear();
        dateDebutSessRemplField.setValue(null);
        dateFinSessRemplField.setValue(null);
        dateDebutInscField.setValue(null);
        dateFinInscField.setValue(null);
        dateDebutSessNormField.setValue(null);
        dateFinSessNormField.setValue(null);
        moyAdmissionField.clear();
        moyRachatField.clear();
        moyAdmissibleField.clear();
    }
    
    
}
