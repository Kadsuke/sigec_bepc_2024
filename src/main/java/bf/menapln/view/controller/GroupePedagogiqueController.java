/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendGroupePedagogiqueController;
import bf.menapln.controller.BackendLocaliteController;
import bf.menapln.controller.BackendSessionController;
import bf.menapln.controller.BackendStructureController;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.GroupePedagogique;
import bf.menapln.entity.*;
import bf.menapln.entity.Session;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.generique.ActionButtonTableCell;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class GroupePedagogiqueController extends VueController implements Initializable {

    @FXML
    public ComboBox<Object> comboboxEtablissement; 
    
    @FXML
    public ComboBox<Object> comboboxCommune; 
    
    @FXML
    public TextField groupePedagogiueField; 
    
    @FXML
    public TextField numeroGroupePedagogiueField;
    @FXML
    public TableView tableView;
    
    @FXML
    public TableColumn<GroupePedagogique,Integer> colId;
    
    @FXML
    public TableColumn<GroupePedagogique,String> colEtablissement;
    
    @FXML
    public TableColumn<GroupePedagogique, String> colGroupePedagogique;
    
    @FXML
    public TableColumn<GroupePedagogique, String> colSession;
    
    Objet session;
    
    ObservableList<Object> listEtablissement,listCommune;
    
    
    public GroupePedagogiqueController() throws SQLException {
        this.backendGroupePedagogiqueController = new BackendGroupePedagogiqueController();
        this.backendStructureController = new BackendStructureController();
        this.backendSessionController = new BackendSessionController();
        this.backendLocaliteController = new BackendLocaliteController();
    }

    BackendGroupePedagogiqueController backendGroupePedagogiqueController;
    BackendSessionController backendSessionController;
    BackendStructureController backendStructureController;
    BackendLocaliteController backendLocaliteController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            comboboxCommune.setDisable(true);
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                comboboxCommune.setDisable(false);
                comboboxCommune.setItems(convertToFxList(backendLocaliteController.getAllByParent(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId().toString())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("etablissement")){
                listEtablissement = convertToFxList(backendStructureController.getAllTypeStructure("Etablissement")
                .stream()
                .map(obj-> (obj instanceof Structure)?(Structure) obj : null)
                .filter(structure->structure.getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList()));
                comboboxEtablissement.setItems(listEtablissement);
            }
            listAll();
            this.AjouterBtn(); 
            MaskWithNumberTextField(numeroGroupePedagogiueField, 2);
            session = backendSessionController.getSessionActive();
        } catch (SQLException ex) {
            Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onChangeCommune(){
        try {
            Localite commune = (Localite) comboboxCommune.getValue();
            listEtablissement = convertToFxList(backendStructureController.getEtabByCommune("Etablissement",commune));
            comboboxEtablissement.setItems(listEtablissement);
        } catch (SQLException ex) {
            Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AjouterBtn(){
        TableColumn<Object, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                tableView,
                    event -> {
                        this.openConfirmModif();
                },
                    event -> {
                        Objet candidat = (Objet) event.getSource();
                        GroupePedagogique gp = (GroupePedagogique)candidat;
                        //System.out.println("gp"+gp.getSession().getId());
                         this.openConfirmSupp(candidat);
            }
        );
    }
    
    private void openConfirmSupp(Objet candidat){
            ButtonType buttonTypeYes = new ButtonType("Oui");
            ButtonType buttonTypeNo = new ButtonType("Non");
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION,
                   "Voulez-vous vraiment supprimer cet Groupe Pédagogique ?", buttonTypeYes, buttonTypeNo);

           confirmationDialog.setTitle("Confirmation de suppression");
           confirmationDialog.showAndWait().ifPresent(response -> {
               if (response == buttonTypeYes) {
                   try {
                       backendGroupePedagogiqueController.delete(candidat);
                       infoBoxSuccess("GP Supprimé avec succès", "Success", null);
                       listAll();
                   }
                   /*catch (SQLException ex) {
                       infoBoxError(ex.getMessage(), "Erreur", null);
                   }*/
                   catch (NullPointerException ex) {
                       Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
                       //infoBoxError(ex.getMessage(), "Erreur", null);
                   } catch (SQLException ex) {
                       Logger.getLogger(GroupePedagogiqueController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else if (response == buttonTypeNo) {
                   confirmationDialog.close();
               }
           });
       }
    
    private void openConfirmModif(){
            ButtonType buttonTypeNo = new ButtonType("ok");

            Alert confirmationDialog = new Alert(Alert.AlertType.INFORMATION,
                   "Modification du Groupe Pédagogique n'est pas autorisée", buttonTypeNo);

           confirmationDialog.setTitle("Modification");

           confirmationDialog.showAndWait().ifPresent(response -> {
               if (response == buttonTypeNo) {
                   confirmationDialog.close();
               }
           });
       }
     public void saveAction() throws EmptyDataException, SQLException, exception.EmptyDataException {
        HashMap formData = new HashMap ();
        formData.put("groupePedagogique_id", numeroGroupePedagogiueField.getText().toString());
        formData.put("session", ((Session) session));
        formData.put("etablissement", ((Structure)comboboxEtablissement.getValue()));
        formData.put("groupePedagogique", groupePedagogiueField.getText());
        backendGroupePedagogiqueController.save(formData);
        infoBoxSuccess("Enregistré avec succès", "Succès", null);
        groupePedagogiueField.clear();
        numeroGroupePedagogiueField.clear();
        listAll();
    
}
     
    @FXML
    public void listAll() throws SQLException{
        ObservableList<Object> typeList = convertToFxList(backendGroupePedagogiqueController.getAllGroupePedagogique());
        tableView.setItems(typeList);
        colSession.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSession().getAnnee().toString()));
        colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissement().getNomStructure()));
        colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogiqueLibelle()));
 }
    
}