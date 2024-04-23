/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class UtilisateurController extends VueController implements Initializable {
    @FXML
    private ComboBox<Object> comboboxRegion;

    @FXML
    private ComboBox<Object> comboboxProvince;

    @FXML
    private ComboBox<Object> comboboxCommune;
    
    @FXML
    private ComboBox<Object> comboboxStructure;
    
    @FXML
    private ComboBox<Object> comboboxVillage;
    
    @FXML
    private ComboBox<Object> comboboxProfil;
    
    @FXML
    private ComboBox<Object> comboboxTypeStructure;
    
    @FXML
    private ComboBox<Sexe> comboboxSexe;
    
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField matriculeField;
    
    @FXML
    private TextField nipField;
    
    @FXML
    private TextField telephoneField;
    
    @FXML
    private TextField identifiantField;
    
    @FXML
    private PasswordField  mdpField;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<User,Long> colId;
    
    @FXML
    public TableColumn<User,String> colMatricule;
    
    @FXML
    public TableColumn<User,String> colNip;

    @FXML
    public TableColumn<User,String> colNom;
    
    @FXML
    public TableColumn<User,String> colPrenom;
        
    @FXML
    public TableColumn<User,String> colSexe;

    @FXML
    public TableColumn<User,String> colTelephone;
 
    @FXML
    public TableColumn<User,String> colLocalite;
    
    @FXML
    public TableColumn<User,String> colStructure;
    
    @FXML
    public TableColumn<User,String> colProfil;
    
    @FXML
    public TableColumn<User,String> colIdentifiant;
    
    @FXML
    private TextField rechercheField;
    
    ObservableList<Object> listRegion,listTypeStruture,listProvince,
            listCommune,listStruture,listVillage,listProfil;
    
    ObservableList<Sexe> listSexe = FXCollections.observableArrayList(Sexe.values());
    
    Objet session;
    
    public UtilisateurController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendEtablissementController = new BackendStructureController();
        this.backendTypeController = new BackendTypeController();
        this.backendSessionController = new BackendSessionController();
        this.BackendProfilController = new BackendProfilController();
        this.BackendUserController = new BackendUserController();
    }
     
        BackendLocaliteController backendLocaliteController;
        BackendStructureController backendEtablissementController;
        BackendTypeController backendTypeController;
        BackendSessionController backendSessionController;
        BackendProfilController BackendProfilController;
        BackendUserController BackendUserController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            colId.setVisible(false);
            listRegion =   convertToFxList(backendLocaliteController.getAll("region"));
            listTypeStruture = convertToFxList(backendTypeController.getAll("Type struct."));
            session = backendSessionController.getSessionActive();
            comboboxRegion.setItems(listRegion);
            comboboxTypeStructure.setItems(listTypeStruture);
            comboboxSexe.setItems(listSexe);
            listAll();
            comboboxRegion.setEditable(true);
            comboboxProvince.setEditable(true);
            comboboxCommune.setEditable(true);
            comboboxVillage.setEditable(true);
            comboboxStructure.setEditable(true);
            filterOnComboBox(comboboxRegion, listRegion);
            MaskWithNumberTextField(telephoneField,8);
            MaskWithNumberTextField(nipField,17);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void onChangeType(ActionEvent e) throws SQLException,EmptyDataException{
        Type typeStructure = (Type) comboboxTypeStructure.getValue();
        listProfil = convertToFxList(BackendProfilController.getAll());
        if(typeStructure.getLibelle().equalsIgnoreCase("Etablissement")){ 
            comboboxProfil.setItems(convertToFxList(BackendProfilController.getAll().stream()
                .map(obj-> (obj instanceof Profil)?(Profil) obj : null)
                .filter(profil->profil != null && profil.getProfilLibelle().equalsIgnoreCase("Etablissement"))
                .collect(Collectors.toList())));
            
        }else if(typeStructure.getLibelle().equalsIgnoreCase("Direction Régionale")){
            comboboxProfil.setItems(convertToFxList(BackendProfilController.getAll().stream()
                .map(obj-> (obj instanceof Profil)?(Profil) obj : null)
                .filter(profil->profil != null && profil.getProfilLibelle().equalsIgnoreCase("Régional"))
                .collect(Collectors.toList())));
            
        }else if(typeStructure.getLibelle().equalsIgnoreCase("Direction Provinciale")){
            comboboxProfil.setItems(convertToFxList(BackendProfilController.getAll().stream()
                .map(obj-> (obj instanceof Profil)?(Profil) obj : null)
                .filter(profil->profil != null && profil.getProfilLibelle().equalsIgnoreCase("Provincial"))
                .collect(Collectors.toList())));
        
        }else if(typeStructure.getLibelle().equalsIgnoreCase("Direction Centrale")){
            comboboxProfil.setItems(convertToFxList(BackendProfilController.getAll().stream()
                .map(obj-> (obj instanceof Profil)?(Profil) obj : null)
                .filter(profil->profil != null && profil.getProfilLibelle().equalsIgnoreCase("Central"))
                .collect(Collectors.toList())));
        
        }
    }
    
    
    @FXML
    public void onChangeActionRegion(ActionEvent e) throws SQLException, EmptyDataException {
        Optional<Localite> optionalRegion = listRegion.stream()
            .filter(obj -> (obj instanceof Localite))
            .map(obj -> (Localite) obj)
            .filter(localite -> localite.getNomLoclite().equalsIgnoreCase(comboboxRegion.getValue().toString()))
            .findFirst();
        if (optionalRegion.isPresent()) {
            Localite region = optionalRegion.get();
            try {
                listProvince = convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString()));
                comboboxProvince.setItems(listProvince);
                filterOnComboBox(comboboxProvince, listProvince);
            } catch (SQLException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Aucune région correspondante pour le filtre.");
        }
    }
    
    // Changing Province
    @FXML
    public void onChangeActionProvince(ActionEvent e) throws SQLException, EmptyDataException {
        Optional<Localite> optionalProvince = listProvince.stream()
            .filter(obj -> (obj instanceof Localite))
            .map(obj -> (Localite) obj)
            .filter(localite -> localite.getNomLoclite().equalsIgnoreCase(comboboxProvince.getValue().toString()))
            .findFirst();
        if (optionalProvince.isPresent()) {
            Localite province = optionalProvince.get();
            try {
            listCommune = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
            comboboxCommune.setItems(listCommune);
            filterOnComboBox(comboboxCommune, listCommune);
            } catch (SQLException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Aucune région correspondante pour le filtre.");
        }
    }

    // Changing Commune
    @FXML
    public void onChangeActionCommune(ActionEvent e) throws SQLException, EmptyDataException {
        //Localite commune = (Localite) comboboxCommune.getValue();
        Type typeStruct = (Type) comboboxTypeStructure.getValue();
        Optional<Localite> optionalCommune = listCommune.stream()
            .filter(obj -> (obj instanceof Localite))
            .map(obj -> (Localite) obj)
            .filter(localite -> localite.getNomLoclite().equalsIgnoreCase(comboboxCommune.getValue().toString()))
            .findFirst();
        if (optionalCommune.isPresent()) {
            Localite commune = optionalCommune.get();
            try {
                listVillage = convertToFxList(backendLocaliteController.getAllByTypeAndParent(commune.getId().toString(),"4"));
                comboboxVillage.setItems(listVillage);
                listStruture = convertToFxList(backendEtablissementController.getEtabByCommune(typeStruct.getLibelle(),commune));
                comboboxStructure.setItems(listStruture);
                filterOnComboBox(comboboxVillage, listVillage);
                filterOnComboBox(comboboxStructure, listStruture);
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Aucune région correspondante pour le filtre.");
        }
        

    }
    
    @FXML
    public void saveAction() {
        try {
            HashMap formData = new HashMap();
            String salt = BCrypt.gensalt();
            String motDePasseHashed = this.encrypte(this.charArrToSTring(mdpField.getText().toCharArray()));
            Localite commune = listCommune.stream()
                    .filter(obj -> (obj instanceof Localite))
                    .map(obj -> (Localite) obj)
                    .filter(localite -> localite.getNomLoclite().equalsIgnoreCase(comboboxCommune.getValue().toString()))
                    .findFirst().get();
            Structure structures = listStruture.stream()
                    .filter(obj -> (obj instanceof Structure))
                    .map(obj -> (Structure) obj)
                    .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxStructure.getValue().toString()))
                    .findFirst().get();
            formData.put("session", (Session)session);
            formData.put("profil", (Profil)comboboxProfil.getValue());
            formData.put("structure", (Structure)structures);
            formData.put("localite", (Localite)commune);
            formData.put("matricule", matriculeField.getText());
            formData.put("nip", nipField.getText());
            formData.put("nom", nomField.getText());
            formData.put("prenom", prenomField.getText());
            formData.put("sexe", comboboxSexe.getValue());
            formData.put("telephone", telephoneField.getText());
            formData.put("username", identifiantField.getText());
            formData.put("pwd", motDePasseHashed);
            BackendUserController.save(formData);
            infoBoxSuccess("Enregistré avec succès", "Succès", null);
            listAll();
            telephoneField.clear();
            prenomField.clear();
            nomField.clear();
            nipField.clear();
            matriculeField.clear();
            identifiantField.clear();
            mdpField.clear();
            comboboxProfil.setValue(null);
            comboboxSexe.setValue(null);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (bf.menapln.exception.EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (Exception ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        }
    }
    
    @FXML
    public void listAll() throws SQLException{        
        ObservableList<Object> userList = convertToFxList(BackendUserController.getAll());
        tableView.setItems(userList);
        colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPersonnel().getNom()));
        colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPersonnel().getPrenom()));
        colMatricule.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPersonnel().getMatricule()));
        colNip.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPersonnel().getNip()));
        colSexe.setCellValueFactory(cellData->new SimpleStringProperty(this.fromEnumToString(cellData.getValue().getPersonnel().getSexe())));
        colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPersonnel().getTelephone()));
        colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getStructure().getNomStructure()));
        colProfil.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getProfil().getProfilLibelle()));
        colIdentifiant.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getUsername()));
       }
}
