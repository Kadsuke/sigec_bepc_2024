/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import exception.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class CandidatPosteJuryController extends VueController implements Initializable {

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
    private ComboBox<Object> comboboxPoste;
    
    @FXML
    private ComboBox<Object> comboboxTypeStructure;
    
    @FXML
    private ComboBox<Sexe> comboboxSexe;
    
    @FXML
    private ListView<Object> listViewEpreuve;
    
    
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
    private HBox formContainer;
    
    @FXML
    private Button updateButton;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button resetButton;
    
    @FXML
    private TitledPane criteriaTitledPane;
    
    @FXML
    private TextField candidatIdField;
    
    ObservableList<Sexe> listSexe = FXCollections.observableArrayList(Sexe.values());
    
    //HashMap<Modalite,Critere> choixCritereModalite = new HashMap<Modalite,Critere> ();
    HashMap<Critere,List<Modalite>> choixCritereModalite = new HashMap<Critere,List<Modalite>> ();

    List<CritereCandidatPosteJury> critereCandidatPosteJurys = new ArrayList<>();

    Objet session;
    
    List<CheckBox> checkBoxList = new ArrayList<>();
    
    Type ob;
    
    Label labelElement;
    
    ComboBox<Object> comboBox;
    
    CheckBox checkBox;
    
    HashMap<Option,Epreuve> epOp = new HashMap<Option,Epreuve>();
    
    CritereCandidatPosteJury critereCandidatPosteJury = new CritereCandidatPosteJury();
    
    ObservableList<Object> listRegion,listPoste,listCritereModalite,listTypeStruture,listProvince,
            listCommune,listStruture,listVillage,listModalite,listEpreuve,listOption;
    private Scene scene;
    
    List<Objet> listOp;
     public CandidatPosteJuryController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendCandidatPosteJuryController = new BackendCandidatPosteJuryController();
        this.backendEtablissementController = new BackendStructureController();
        this.backendTypeController = new BackendTypeController();
        this.backendSessionController = new BackendSessionController();
        this.backendCritereController = new BackendCritereController();
        this.BackendEpreuveController = new BackendEpreuveController();
        this.backendEpreuveOptionsController = new BackendEpreuveOptionsController();
        this.backendOptionController = new BackendOptionController();
    }
     
        BackendLocaliteController backendLocaliteController;
        BackendCandidatPosteJuryController backendCandidatPosteJuryController;
        BackendStructureController backendEtablissementController;
        BackendTypeController backendTypeController;
        BackendSessionController backendSessionController;
        BackendCritereController backendCritereController;
        BackendEpreuveController BackendEpreuveController;
        BackendEpreuveOptionsController backendEpreuveOptionsController;
        BackendOptionController backendOptionController;
    
    /** 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            listRegion =   convertToFxList(backendLocaliteController.getAll("region"));
            listPoste = convertToFxList(backendTypeController.getAll("Poste jury"));
            listTypeStruture = convertToFxList(backendTypeController.getAll("Type struct."));
            listEpreuve = convertToFxList(BackendEpreuveController.getAllByParentIsNull());
            session = backendSessionController.getSessionActive();
            comboboxRegion.setItems(listRegion);
            comboboxTypeStructure.setItems(listTypeStruture);
            comboboxVillage.setDisable(true);
            comboboxPoste.setItems(listPoste);
            comboboxSexe.setItems(listSexe);
            listViewEpreuve.setDisable(true);
            updateButton.setVisible(false);
            candidatIdField.setVisible(false);
            comboboxStructure.setEditable(true);
            listViewEpreuve.setItems(listEpreuve);
            listViewEpreuve.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            MaskWithNumberTextField(telephoneField,8);
            MaskWithNumberTextField(nipField,17);
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatPosteJuryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Boolean validateForm(){
        Boolean valide = true;
        Type poste = (Type) comboboxPoste.getValue();
       
        if (this.comboboxPoste.getValue() != null) {
            // Ajout des critères de types choix multiples dans le map
            Collection<Critere> crit = choixCritereModalite.keySet();
            if (this.ob.getCriteres().size()-3 > crit.size()) {//Tous les critères non pas été sélectionnés
                this.infoBoxError("Vous devez selectionnez au moins une modalité pour chaque critère", "ERREUR ", null);
                return false;
            }
            if(poste.getLibelle().equalsIgnoreCase("Correcteur")){
                if(listViewEpreuve.getSelectionModel().isEmpty()){
                    valide = false;
                    this.infoBoxError("Veuillez selectionné les épreuves!!", "ERREUR ", null);
                }
            }
            
            ObservableList<Object> specialitesSelected= listViewEpreuve.getSelectionModel().getSelectedItems();
                for (Object item : specialitesSelected) {
                    System.out.println("Valeur"+item.toString());
                }
             
        }else{
            valide = false;
            this.infoBoxError("Aucun poste sélectionné!!", "ERREUR ", null);
        }
        return valide;
    }
    
    public void saveAction(){
        if(this.validateForm()){
            try {
            HashMap formData = new HashMap();
            List<Objet> listOption = backendOptionController.getAll();
            Structure structures = listStruture.stream()
                    .filter(obj -> (obj instanceof Structure))
                    .map(obj -> (Structure) obj)
                    .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxStructure.getValue().toString()))
                    .findFirst().get();
            formData.put("session", (Session)session);
            formData.put("epreuve", listViewEpreuve.getSelectionModel().getSelectedItems());
            formData.put("structure", structures);
            formData.put("localite", (Localite)comboboxCommune.getValue());
            formData.put("poste", (Type)comboboxPoste.getValue());
            formData.put("matricule", matriculeField.getText());
            formData.put("nip", nipField.getText());
            formData.put("nom", this.toUpper(nomField.getText()));
            formData.put("prenom", this.firstLetterUpper(prenomField.getText()));
            formData.put("sexe", comboboxSexe.getValue()); 
            formData.put("telephone", telephoneField.getText());
            formData.put("choixCritereModalite", choixCritereModalite);
            formData.put("option", listOption);
            backendCandidatPosteJuryController.save(formData);
            infoBoxSuccess("Candidat Enrégistré avec success", "Succes", null);
            viderChamps();
        } catch (SQLException | bf.menapln.exception.EmptyDataException | EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        }
   }
        
 }
    
    public void viderChamps(){
        criteriaTitledPane.setContent(null);
        checkBoxList.clear();
        telephoneField.clear();
        prenomField.clear();
        nomField.clear();
        nipField.clear();
        matriculeField.clear();
        comboboxSexe.setValue(null);
        choixCritereModalite.clear();
        listViewEpreuve.getItems().clear();
        comboboxPoste.setValue(null);
        this.chargeFormulaire(ob);
    }
    
    public void updateAction(){
        try {
            Structure structures = listStruture.stream()
                    .filter(obj -> (obj instanceof Structure))
                    .map(obj -> (Structure) obj)
                    .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxStructure.getValue().toString()))
                    .findFirst().get();
            HashMap formData = new HashMap();
            List<Objet> listOption = backendOptionController.getAll();
            formData.put("session", (Session)session);
            formData.put("candidat_id", this.getCandidatIdField().getText());
            formData.put("structure", structures);
            formData.put("localite", (Localite)comboboxCommune.getValue());
            formData.put("poste", (Type)comboboxPoste.getValue());
            formData.put("matricule", matriculeField.getText());
            formData.put("nip", nipField.getText());
            formData.put("nom", nomField.getText());
            formData.put("prenom", prenomField.getText());
            formData.put("sexe", comboboxSexe.getValue());
            formData.put("telephone", telephoneField.getText());
            formData.put("epreuve", listViewEpreuve.getSelectionModel().getSelectedItems());
            formData.put("option", listOption);
            formData.put("choixCritereModalite", choixCritereModalite);
            backendCandidatPosteJuryController.update(formData);
            infoBoxSuccess("Candidat Modifié avec success", "Succès", null);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (bf.menapln.exception.EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (EmptyDataException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        }
    }
    
    @FXML
    public void resetAction(ActionEvent e) throws SQLException, EmptyDataException {
            comboboxRegion.setValue(null);
            comboboxProvince.setValue(null);
            comboboxCommune.setValue(null);
            criteriaTitledPane.setContent(null);
            checkBoxList.clear();
            telephoneField.clear();
            prenomField.clear();
            nomField.clear();
            nipField.clear();
            matriculeField.clear();
            listViewEpreuve.getSelectionModel().clearSelection();
            comboboxSexe.setValue(null);
    }

    @FXML
    public void onChangeActionRegion(ActionEvent e) throws SQLException, EmptyDataException {
        Localite region = (Localite) comboboxRegion.getValue();
        try {
            listProvince = convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString()));
            comboboxProvince.setItems(listProvince);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Changing Province
    @FXML
    public void onChangeActionProvince(ActionEvent e) throws SQLException, EmptyDataException {
        Localite province = (Localite) comboboxProvince.getValue();
        try {
            listCommune = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
            comboboxCommune.setItems(listCommune);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Changing Commune
    @FXML
    public void onChangeActionCommune(ActionEvent e) throws SQLException, EmptyDataException {
        Localite commune = (Localite) comboboxCommune.getValue();
        Type typeStruct = (Type) comboboxTypeStructure.getValue();
        try {
            listVillage = convertToFxList(backendLocaliteController.getAllByParent(commune.getId().toString()));
            comboboxVillage.setItems(listVillage);
            listStruture = convertToFxList(backendEtablissementController.getEtabByCommune(typeStruct.getLibelle(),commune));
            comboboxStructure.setItems(listStruture);
            filterOnComboBox(comboboxStructure, listStruture);
           // comboboxStructure.setItems(listStruture);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    public void onChangeActionPoste(ActionEvent e) throws SQLException, EmptyDataException {
        Type poste = (Type) comboboxPoste.getValue();
        if(poste != null && poste.getLibelle().equalsIgnoreCase("Correcteur")){
            criteriaTitledPane.setContent(null);
            checkBoxList.clear();
            listViewEpreuve.setDisable(false);
            listViewEpreuve.setItems(convertToFxList(BackendEpreuveController.getAllByParentIsNull()));
        }else{
            criteriaTitledPane.setContent(null);
            checkBoxList.clear();
            listViewEpreuve.setDisable(true);
        }
        try {
                ob =(Type) backendCritereController.getByPoste(poste);
                this.chargeFormulaire(ob);
            } catch (SQLException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // reset le formulaire
    public void resetFormulaire() {
    for (Critere crit : this.ob.getCriteres()) {
       // labelElement.setText("");
        if (crit.getTypeChamp().equalsIgnoreCase("Choix Unique")) {
            if(comboBox.getSelectionModel() != null){
                comboBox.getSelectionModel().clearSelection();
            }
        } else if (crit.getTypeChamp().equalsIgnoreCase("Choix Multiple")) {
            for (CheckBox checkBox : checkBoxList) {
                checkBox.setSelected(false);
            }
        }
    }
}

    // Chargement du formulaire dynamique par poste selectionné
    @FXML
    public void chargeFormulaire(Type type){
        VBox mainContainer = new VBox();
        mainContainer.setSpacing(10);
        HBox currentRow = new HBox();
        currentRow.setSpacing(10);
        List<Objet> mod = new ArrayList<>();
        int elementsPerRow = 1;
        int elementCount = 0;
        for(Critere crit:type.getCriteres()){
            VBox fieldContainer = new VBox();
            mod.clear();
            fieldContainer.setPrefHeight(500);
            if(crit.getTypeChamp().equalsIgnoreCase("Choix Unique")){
                critereCandidatPosteJury.setCritere(crit);
                labelElement = new Label(crit.getCritereLibelle());
                labelElement.setTextFill(Color.RED);
                ComboBox comboBoxDynamique = new ComboBox<>();
                comboBoxDynamique.setPrefWidth(250.0);
                listModalite = FXCollections.observableArrayList(crit.getModalites());
                comboBoxDynamique.setItems(listModalite);
                comboBoxDynamique.setOnAction(event -> {
                Modalite selectedValue = (Modalite)comboBoxDynamique.getValue();
                    // Ajout de la nouvelle clé et sa valeur
                    List<Modalite> modaliteSelected = new ArrayList<>();
                    modaliteSelected.add(selectedValue);
                    choixCritereModalite.put(crit, modaliteSelected);
            });
                fieldContainer.getChildren().addAll(labelElement, comboBoxDynamique);
                
            }else if (crit.getTypeChamp().equalsIgnoreCase("Choix Multiple")) {
               labelElement = new Label(crit.getCritereLibelle());
               labelElement.setTextFill(Color.RED);
               List<Modalite> lmCandidat = new ArrayList<Modalite>();
               List<CheckBox> checkBoxList = new ArrayList<>();
               List<Modalite> modaliteSelected = new ArrayList<>();
               for (Modalite modal : crit.getModalites()) {
                    checkBox = new CheckBox(modal.getModaliteLibelle());
                    //Vérification si la modalité avait été coché
                    if (lmCandidat != null) {//Si l'acteur a des modalités pour le critère courant (vérification pas nécessaire)
                        Modalite m = lmCandidat.stream().filter(f->f.getId().equals(modal.getId())).findFirst().orElse(new Modalite());
                        if (m.getId()!=null) {
                            checkBox.setSelected(true);//Coché la modalité
                            modaliteSelected.add(modal);
                            choixCritereModalite.put(crit, modaliteSelected);
                        }
                    }
                // Action sur les checkbox
                    checkBox.selectedProperty().addListener(
                        (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        if (new_val) {//Sélectionner si coché
                            // System.out.println("Crit "+crit+"  Modal : "+modal+" COCHER");
                            modaliteSelected.add(modal);
                        } else {//Désélectionner si décoché
                            // System.out.println("Crit "+crit+"  Modal : "+modal+" DECOCHER");
                            modaliteSelected.remove(modal);
                        }
                        if (modaliteSelected.size()>0 ) {
                            choixCritereModalite.put(crit, modaliteSelected);
                        }else{//Enlever le critère du Map si aucune modalité n'est cochée
                            choixCritereModalite.remove(crit);
                        }
                    });
                    checkBoxList.add(checkBox);
                    checkBox.setUserData(modal);
                }
                VBox checkBoxContainer = new VBox();
                checkBoxContainer.getChildren().addAll(checkBoxList);
               
                fieldContainer.getChildren().addAll(labelElement,checkBoxContainer);
        }
            elementCount++;

            // Si nous avons atteint le nombre d'éléments par ligne, créez une nouvelle ligne
            if (elementCount % elementsPerRow == 0) {
                mainContainer.getChildren().add(currentRow);
                currentRow = new HBox();
                currentRow.setSpacing(10);
            }
            currentRow.getChildren().add(fieldContainer);
            critereCandidatPosteJurys.add(critereCandidatPosteJury);
        }
            // Dernier HBox s'il n'est pas encore ajouté
            if (!currentRow.getChildren().isEmpty()) {
                mainContainer.getChildren().add(currentRow);
            }
            
            criteriaTitledPane.setContent(mainContainer);
    }
    
   public void chargeFormulaire(CandidatPosteJury candidatPosteJury){
        try {
            ob =(Type) backendCritereController.getByPoste(candidatPosteJury.getPoste());
            VBox mainContainer = new VBox();
            mainContainer.setSpacing(10);
            HBox currentRow = new HBox();
            currentRow.setSpacing(10);
            List<Objet> mod = new ArrayList<>();
            int elementsPerRow = 1;
            int elementCount = 0;
            List<Critere> cc = new ArrayList<>(candidatPosteJury.getCritere());//Les critères du candidat courrant
            for(Critere crit:ob.getCriteres()){
                critereCandidatPosteJury = new CritereCandidatPosteJury();
                VBox fieldContainer = new VBox();
                mod.clear();
                fieldContainer.setPrefHeight(500);
                if(crit.getTypeChamp().equalsIgnoreCase("Choix Unique")){
                    critereCandidatPosteJury.setCritere(crit);
                    labelElement = new Label(crit.getCritereLibelle());
                    labelElement.setTextFill(Color.RED);
                    ComboBox<Object> comboBox1 = new ComboBox<>();
                    comboBox1.setPrefWidth(250.0);
                    listModalite = FXCollections.observableArrayList(crit.getModalites());
                    comboBox1.setItems(listModalite);
                    // Traitement des cas de candidat en modification
                    if (cc!=null) {//Si candidat en modification (il a déjà des critères)
                        Critere c = cc.stream().filter(f->f.getId().equals(crit.getId())).findFirst().orElse(new Critere());
                            if (c.getId() != null) {//Si l'acteur à le critère
                                Modalite m = crit.getModalites().stream().filter(f->f.getId().equals(c.getModalites().get(0).getId())).findFirst().orElse(new Modalite());
                                comboBox1.setValue(m);
                                List<Modalite> modaliteSelected = new ArrayList<>();
                                modaliteSelected.add(m);
                                choixCritereModalite.put(crit,modaliteSelected );
                            }
                    }
                    //Fin traitement cas modification
                    comboBox1.setOnAction(event -> { 
                        Modalite selectedValue = (Modalite)comboBox1.getValue();
                        // Ajout de la nouvelle clé et sa valeur
                        List<Modalite> modaliteSelected = new ArrayList<>();
                        modaliteSelected.add(selectedValue);
                        choixCritereModalite.put(crit, modaliteSelected);
                    });
                    fieldContainer.getChildren().addAll(labelElement, comboBox1);
                }else if (crit.getTypeChamp().equalsIgnoreCase("Choix Multiple")) {
                    labelElement = new Label(crit.getCritereLibelle());
                    labelElement.setTextFill(Color.RED);
                    List<Modalite> lmCandidat = new ArrayList<Modalite>();
                    List<CheckBox> checkBoxList = new ArrayList<>();
                    List<Modalite> modaliteSelected = new ArrayList<>();
                    // Traitement des cas de candidat en modification
                    if (cc!=null) {//Si candidat en modification (il a déjà des critères)
                        Critere c = cc.stream().filter(f->f.getId().equals(crit.getId())).findFirst().orElse(new Critere());
                            if (c.getId()!= null) {//Si l'acteur à le critère
                                // recuperation de la liste des modalités choisies antérieurement pour ce critère pour le candidat
                                lmCandidat = cc.stream().filter(f->f.getId().equals(crit.getId())).findFirst().orElse(new Critere()).getModalites();
                            }
                    }
                    
                    for (Modalite modal : crit.getModalites()) {
                        checkBox = new CheckBox(modal.getModaliteLibelle());
                        //Vérification si la modalité avait été coché
                        if (lmCandidat != null) {//Si l'acteur a des modalités pour le critère courant (vérification pas nécessaire)
                            Modalite m = lmCandidat.stream().filter(f->f.getId().equals(modal.getId())).findFirst().orElse(new Modalite());
                            if (m.getId()!=null) {
                                checkBox.setSelected(true);//Coché la modalité
                                modaliteSelected.add(modal);
                                choixCritereModalite.put(crit, modaliteSelected);
                            }
                        }
                        // Action sur les checkbox
                        checkBox.selectedProperty().addListener(
                            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                            if (new_val) {//Sélectionner si coché
                                modaliteSelected.add(modal);
                            } else {//Désélectionner si décoché
                                modaliteSelected.remove(modal);
                            }
                            if (modaliteSelected.size()>0 ) {
                                choixCritereModalite.put(crit, modaliteSelected);
                            }else{//Enlever le critère du Map si aucune modalité n'est cochée
                                choixCritereModalite.remove(crit);
                            }
                        });
                        checkBoxList.add(checkBox);
                        checkBox.setUserData(modal);
                    }
                    VBox checkBoxContainer = new VBox();
                    checkBoxContainer.getChildren().addAll(checkBoxList);
                    
                    fieldContainer.getChildren().addAll(labelElement,checkBoxContainer);
                }
                elementCount++;
                
                // Si nous avons atteint le nombre d'éléments par ligne, créez une nouvelle ligne
                if (elementCount % elementsPerRow == 0) {
                    mainContainer.getChildren().add(currentRow);
                    currentRow = new HBox();
                    currentRow.setSpacing(10);
                }
                currentRow.getChildren().add(fieldContainer);
                critereCandidatPosteJurys.add(critereCandidatPosteJury);
            }
            // Dernier HBox s'il n'est pas encore ajouté
            if (!currentRow.getChildren().isEmpty()) {
                mainContainer.getChildren().add(currentRow);
            }
            criteriaTitledPane.setContent(mainContainer);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatPosteJuryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    // ALL GETTERS AND SETTERS

    public ComboBox<Object> getComboboxRegion() {
        return comboboxRegion;
    }

    public void setComboboxRegion(ObservableList<Object> listRegion) {
        this.comboboxRegion.setItems(listRegion);
    }

    public ComboBox<Object> getComboboxProvince() {
        return comboboxProvince;
    }

    public void setComboboxProvince(ObservableList<Object> listProvince) {
        this.comboboxProvince.setItems(listProvince);
    }

    public ComboBox<Object> getComboboxCommune() {
        return comboboxCommune;
    }

    public void setComboboxCommune(ObservableList<Object> listCommune) {
        this.comboboxCommune.setItems(listCommune);
    }

    public ComboBox<Object> getComboboxStructure() {
        return comboboxStructure;
    }

    public void setComboboxStructure(ObservableList<Object> listStructure) {
        this.comboboxStructure.setItems(listStructure);
    }

    public ComboBox<Object> getComboboxVillage() {
        return comboboxVillage;
    }

    public void setComboboxVillage(ObservableList<Object> listVillage) {
        this.comboboxVillage.setItems(listVillage);
    }

    public ComboBox<Object> getComboboxPoste() {
        return comboboxPoste;
    }

    public void setComboboxPoste(ObservableList<Object> listPoste) {
        this.comboboxPoste.setItems(listPoste);
    }

    public ComboBox<Object> getComboboxTypeStructure() {
        return comboboxTypeStructure;
    }

    public void setComboboxTypeStructure(ObservableList<Object> listTypeStructure) {
        this.comboboxTypeStructure.setItems(listTypeStructure);
    }

    public ComboBox<Sexe> getComboboxSexe() {
        return comboboxSexe;
    }

    public void setComboboxSexe(ObservableList<Sexe> listTypeSexe) {
        this.comboboxSexe.setItems(listTypeSexe);
    }

    
    public ListView<Object> getListViewEpreuve() {
        return listViewEpreuve;
    }

    public void setListViewEpreuve(ObservableList<Object> listEpreuve) {
        this.listViewEpreuve.setItems(listEpreuve);
    }

    public TextField getNomField() {
        return nomField;
    }

    public void setNomField(String nomField) {
        this.nomField.setText(nomField);
    }

    public TextField getPrenomField() {
        return prenomField;
    }

    public void setPrenomField(String prenomField) {
        this.prenomField.setText(prenomField);
    }

    public TextField getMatriculeField() {
        return matriculeField;
    }

    public void setMatriculeField(String matriculeField) {
        this.matriculeField.setText(matriculeField);
    }

    public TextField getNipField() {
        return nipField;
    }

    public void setNipField(String nipField) {
        this.nipField.setText(nipField);
    }

    public TextField getTelephoneField() {
        return telephoneField;
    }

    public void setTelephoneField(String telephoneField) {
        this.telephoneField.setText(telephoneField);
    }

    public ObservableList<Sexe> getListSexe() {
        return listSexe;
    }

    public void setListSexe(ObservableList<Sexe> listSexe) {
        this.listSexe = listSexe;
    }

    public ObservableList<Object> getListRegion() {
        return listRegion;
    }

    public void setListRegion(ObservableList<Object> listRegion) {
        this.listRegion = listRegion;
    }

    public ObservableList<Object> getListCommune() {
        return listCommune;
    }

    public void setListCommune(ObservableList<Object> listCommune) {
        this.listCommune = listCommune;
    }
    
    

    public ObservableList<Object> getListTypeStruture() {
        return listTypeStruture;
    }

    public void setListTypeStruture(ObservableList<Object> listTypeStruture) {
        this.listTypeStruture = listTypeStruture;
    }

    public ObservableList<Object> getListProvince() {
        return listProvince;
    }

    public void setListProvince(ObservableList<Object> listProvince) {
        this.listProvince = listProvince;
    }

    public ObservableList<Object> getListStruture() {
        return listStruture;
    }

    public void setListStruture(ObservableList<Object> listStruture) {
        this.listStruture = listStruture;
    }

    public ObservableList<Object> getListVillage() {
        return listVillage;
    }

    public void setListVillage(ObservableList<Object> listVillage) {
        this.listVillage = listVillage;
    }

    public ObservableList<Object> getListEpreuve() {
        return listEpreuve;
    }

    public void setListEpreuve(ObservableList<Object> listEpreuve) {
        this.listEpreuve = listEpreuve;
    }

    public ObservableList<Object> getListPoste() {
        return listPoste;
    }

    public void setListPoste(ObservableList<Object> listPoste) {
        this.listPoste = listPoste;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public TitledPane getCriteriaTitledPane() {
        return criteriaTitledPane;
    }

    public void setCriteriaTitledPane(TitledPane criteriaTitledPane) {
        this.criteriaTitledPane = criteriaTitledPane;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public void setResetButton(Button resetButton) {
        this.resetButton = resetButton;
    }

    public TextField getCandidatIdField() {
        return candidatIdField;
    }

    public void setCandidatIdField(Long candidatId) {
        this.candidatIdField.setText(candidatId.toString());
    }
    
}
