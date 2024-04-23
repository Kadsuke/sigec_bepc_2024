/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import exception.EmptyDataException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InscriptionController extends VueController implements Initializable{

    @FXML
    private ComboBox<Object> comboboxRegion;

    @FXML
    private ComboBox<Object> comboboxProvince;

    @FXML
    private ComboBox<Object> comboboxCommune;
    
    @FXML
    private ComboBox<Object> comboboxVillage;

    @FXML
    private ComboBox<Object> comboboxCentreExamen;

    @FXML
    private ComboBox<Object> comboboxEtablissement;
    
    @FXML
    private ComboBox<Object> comboboxGroupePedagogique;

    @FXML
    private ComboBox<Object> comboboxTypeInscription;

    @FXML
    private ComboBox<Object> comboboxStatut;

    @FXML
    private ComboBox<Object> comboboxPaysNaissance;

    @FXML
    private ComboBox<Object> comboboxNationalite;

    @FXML
    private ComboBox<String> comboboxTypeDate;

    @FXML
    private ComboBox<Sexe> comboboxSexe;

    @FXML
    private ComboBox<Object> comboboxSituation;

    @FXML
    private ComboBox<Object> comboboxOption;

    @FXML
    private ComboBox<String> comboboxSport;

    @FXML
    private ComboBox<Object> comboboxTypeHandicap;
    
    @FXML
    private ComboBox<Object> comboboxConcours;
   
    @FXML
    private ComboBox<Object> comboboxNatureHandicap;

    @FXML
    private ComboBox<Object> comboboxPrescriptionHandicap;
    
    @FXML
    private ComboBox<Object> comboboxEtabPremier;

    @FXML
    private ComboBox<Object> comboboxSeriePremier;

    @FXML
    private ComboBox<Object> comboboxEtabSecond;

    @FXML
    private ComboBox<Object> comboboxSerieSecond;

    @FXML
    private ComboBox<Object> comboboxEtabTroisieme;

    @FXML
    private ComboBox<Object> comboboxSerieTroisieme;

    @FXML
    private ComboBox<Object> comboboxZone;
    
    @FXML
    private TextField numeroActeField;
    
    @FXML
    private TextField numeroDossierField;
    
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField lieuNaissanceField;
    
    @FXML
    private TextField telephoneField;

    @FXML
    private TextField telephoneDeuxField;
    
    @FXML
    private TextField nomPereField;

    @FXML
    private TextField prenomPereField;

    @FXML
    private TextField nomMereField;

    @FXML
    private TextField prenomMereField;
    
    @FXML
    private TextField anneeCepField;
    
    @FXML
    private DatePicker dateNaissancemField;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button modifButton;
    
    @FXML
    private Button resetButton;
    
    @FXML
    private Button BackButton;
    @FXML
    private TextField candidatIdField;

    ObservableList<String> listTypeDate = FXCollections.observableArrayList("le",
            "en", "vers");
    
    ObservableList<String> listSport = FXCollections.observableArrayList("Apte",
            "Inapte");
   
    ObservableList<Sexe> listSexe = FXCollections.observableArrayList(Sexe.values());

    Objet session;
    
    ObservableList<Object> listRegion,listPays,listEtabCommune,listEtabProvince,listVillage,listTypeInsc,listTypeStatut,
            listGPEtab,listTypeSituation,listOption,listTypeHandicap,listTypeConcours,listTypeSerie,listNationalite,
            listNatureHandicap,listPrescriptionHandicap,listCentreExamen,listProvince,listCommune,
            listEtablissementChoix,listEtablissement,listGP,listSerie,listZone;

    
    /**
     * Initializes the controller class.
     */
    public InscriptionController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendPaysController = new BackendPaysController();
        this.backendEtablissementController = new BackendStructureController();
        this.backendTypeController = new BackendTypeController();
        this.backendOptionController = new BackendOptionController();
        this.backendGroupePedagogiqueController = new BackendGroupePedagogiqueController();
        this.backendNaturehandicapController = new BackendNatureHandicapController();
        this.backendPrescriptionNaturehandicapController = new BackendPrescriptionNatureHandicapController();
        this.backendSessionController = new BackendSessionController();
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendSerieConcoursRattacheController = new BackendSerieConcoursRattacheController();
    }

    BackendLocaliteController backendLocaliteController;
    BackendPaysController backendPaysController;
    BackendStructureController backendEtablissementController;
    BackendTypeController backendTypeController;
    BackendOptionController backendOptionController;
    BackendGroupePedagogiqueController backendGroupePedagogiqueController;
    BackendNatureHandicapController backendNaturehandicapController;
    BackendPrescriptionNatureHandicapController backendPrescriptionNaturehandicapController;
    BackendSessionController backendSessionController;
    BackendInscriptionController backendInscriptionController;
    BackendSerieConcoursRattacheController backendSerieConcoursRattacheController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Etablissement")){
                listRegion =  convertToFxList(backendLocaliteController.getAll("region").stream()
                            .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                            .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId()))
                            .collect(Collectors.toList()));
            
                listProvince =  convertToFxList(backendLocaliteController.getAll("province").stream()
                                .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                                .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                                .collect(Collectors.toList()));

                listCommune = convertToFxList(backendLocaliteController.getAll("commune").stream()
                                .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                                .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getId()))
                                .collect(Collectors.toList()));
                
                listTypeInsc = convertToFxList(backendTypeController.getAll("Type insc.").stream()
                                .map(obj->(obj instanceof Type) ? (Type)obj:null)
                                .filter(type->type !=null && type.getLibelle().equalsIgnoreCase("Ordinaire"))
                                .collect(Collectors.toList()));
                listTypeStatut = convertToFxList(backendTypeController.getAll("Type candidat"));
                        /*.stream()
                                .map(obj->(obj instanceof Type) ? (Type)obj:null)
                                .filter(type->type !=null && type.getLibelle().equalsIgnoreCase("Régulier"))
                                .collect(Collectors.toList()));*/
                listEtablissement = convertToFxList(backendEtablissementController.getAll("Etablissement").stream()
                                .map(obj->(obj instanceof Structure) ? (Structure)obj:null)
                                .filter(structure->structure !=null && structure.getId().equals(sessionManager.getUser().getStructure().getId()))
                                .collect(Collectors.toList()));
                
                }else if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Direction Provinciale")){
                    listRegion =  convertToFxList(backendLocaliteController.getAll("region").stream()
                            .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                            .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId()))
                            .collect(Collectors.toList()));
            
                    listProvince =  convertToFxList(backendLocaliteController.getAll("province").stream()
                                    .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                                    .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                                    .collect(Collectors.toList()));
                    
                    listTypeInsc = convertToFxList(backendTypeController.getAll("Type insc."));
                    listTypeStatut = convertToFxList(backendTypeController.getAll("Type candidat"));
                }else{
                    listRegion =  convertToFxList(backendLocaliteController.getAll("region"));
            
                   /* listProvince =  convertToFxList(backendLocaliteController.getAll("province").stream()
                                    .map(obj->(obj instanceof Localite) ? (Localite)obj:null)
                                    .filter(localite->localite !=null && localite.getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                                    .collect(Collectors.toList()));*/
                    
                    listTypeInsc = convertToFxList(backendTypeController.getAll("Type insc."));
                    listTypeStatut = convertToFxList(backendTypeController.getAll("Type candidat"));
                }
            
            
            listPays = convertToFxList(backendPaysController.getAll());
            listNationalite = convertToFxList(backendPaysController.getAllNationalite());
            listTypeHandicap = convertToFxList(backendTypeController.getAll("Type handicap"));
            listTypeHandicap.add(0, "");
            //listTypeInsc = convertToFxList(backendTypeController.getAll("Type insc."));
            //listTypeStatut = convertToFxList(backendTypeController.getAll("Type candidat"));      
            listTypeSituation = convertToFxList(backendTypeController.getAll("Type situation"));       
            listOption = convertToFxList(backendOptionController.getAll());
            listTypeConcours = convertToFxList(backendTypeController.getAll("Type Concours"));
            session = backendSessionController.getSessionActive();
            comboboxRegion.setItems(listRegion);
            comboboxCommune.setItems(listCommune);
            comboboxProvince.setItems(listProvince);
            comboboxEtablissement.setItems(listEtablissement);
            comboboxTypeInscription.setItems(listTypeInsc);
            comboboxStatut.setItems(listTypeStatut);
            comboboxPaysNaissance.setItems(listPays);
            comboboxNationalite.setItems(listNationalite);
            comboboxSexe.setItems(listSexe);
            comboboxSituation.setItems(listTypeSituation);
            comboboxOption.setItems(listOption);
            comboboxSport.setItems(listSport);
            comboboxConcours.setItems(listTypeConcours);
            saveButton.setDisable(true);  
            BackButton.setVisible(false);
            modifButton.setVisible(false);
            candidatIdField.setVisible(false);
            comboboxVillage.setDisable(true);
            dateNaissancemField.setEditable(false);
            this.ActionClearAndDisable();
            this.DateControl();
            MaskWithNumberTextField(telephoneField,8);
            MaskWithNumberTextField(telephoneDeuxField,8);
            MaskWithNumberTextField(anneeCepField,4);
            
            // Faire l'action lorsque l'année perd son focus
            anneeCepField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    onChangeActionAnneeDiplome();
                } catch (SQLException ex) {
                    Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EmptyDataException ex) {
                    Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        comboboxEtabPremier.setEditable(true);
        comboboxEtabSecond.setEditable(true);
        comboboxEtabTroisieme.setEditable(true);
        comboboxSeriePremier.setEditable(true);
        comboboxSerieSecond.setEditable(true);
        comboboxSerieTroisieme.setEditable(true);
        comboboxPaysNaissance.setEditable(true);
        comboboxNationalite.setEditable(true);
        
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboboxTypeDate.setItems(listTypeDate);
        
        // TODO

        filterOnComboBox(comboboxRegion,listRegion);
        filterOnComboBox(comboboxSeriePremier,listTypeSerie);
        filterOnComboBox(comboboxPaysNaissance,listPays);
        filterOnComboBox(comboboxNationalite,listNationalite);
    }
    
    @FXML
    public void DateControl(){
        LocalDate today = LocalDate.now();
            LocalDate minDate = today.minusYears(10);        
            // Limitez la date maximale à aujourd'hui
            dateNaissancemField.setValue(minDate);
            dateNaissancemField.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(empty || item.isAfter(minDate));
            }
        });
         dateNaissancemField.setOnKeyPressed(this::handleKeyPressed);
        

    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            handleDateValidation();
        }
    }
    
    @FXML
    private void handleDateValidation() {
        LocalDate selectedDate = dateNaissancemField.getValue();
        String typeDate = (String)comboboxTypeDate.getValue();

        if (selectedDate != null) {
            try {
                if ("en".equalsIgnoreCase(typeDate) || "vers".equalsIgnoreCase(typeDate)) {
                        // Vérifier si la date est différente du 31 décembre
                        if (selectedDate.getDayOfMonth() != 31 || selectedDate.getMonth() != Month.DECEMBER) {
                            // Afficher une erreur
                            infoBoxError("Pour le type "+typeDate+" veuillez sélectionner le 31 décembre.","Erreur",null);
                            // Vous pouvez également forcer la date à être le 31 décembre
                            selectedDate = LocalDate.of(selectedDate.getYear(), Month.DECEMBER, 31);
                            dateNaissancemField.setValue(selectedDate);
                        } else {
                            // La date est le 31 décembre, aucune action nécessaire
                        }
                    } else {
                        // Le type n'est pas "en" ou "vers", aucune action nécessaire
                    }
                } catch (DateTimeParseException e) {
                // Afficher une erreur si le format de date est incorrect
                infoBoxError("Format de date incorrect. Utilisez le format 'jj/mm/aaaa'.","Erreur",null);
            }
        } else {
            // Afficher un message indiquant à l'utilisateur de sélectionner une date
            infoBoxError("Veuillez Valider la date avec la touche Enter","Erreur",null);
        }
    }

    
    public Boolean valideForm(){
        Boolean valide = true;
        Object val = listTypeHandicap.get(0);
        System.out.println("typeHandicap"+comboboxTypeHandicap.getValue() );
            if(comboboxTypeHandicap.getValue() == null || Objects.equals(comboboxTypeHandicap.getValue(), null)){
                
            }
            else{
            if(!comboboxTypeHandicap.getValue().equals(val)){
                        if(comboboxNatureHandicap.getValue() == null || comboboxNatureHandicap.getValue().equals(val)){
                            infoBoxError("Veuillez choisir une nature.", "ERREUR", null);
                            return false;
                        }else{
                            if(comboboxPrescriptionHandicap.getValue() == null || comboboxPrescriptionHandicap.getValue().equals(val)){
                               infoBoxError("Veuillez choisir une prescription.", "ERREUR", null);
                               return false;
                            }
                    }
                }
        
        }
        return valide;
    
    }
    public Boolean valideFormInsc(){
        Boolean valide = true;
            if(comboboxTypeHandicap.getValue() == null || comboboxTypeHandicap.getValue().toString().isEmpty()){
            
        }else{
            if(comboboxNatureHandicap.getValue() == null || comboboxNatureHandicap.getValue().toString().isEmpty()){
                infoBoxError("Veuillez choisir une nature.", "ERREUR", null);
                return false;
            }else{
                if(comboboxPrescriptionHandicap.getValue() == null || comboboxPrescriptionHandicap.getValue().toString().isEmpty()){
                   infoBoxError("Veuillez choisir une prescription.", "ERREUR", null);
                   return false;
                }
            }
            }
        return valide;
    
    }
    
    public Boolean valideDateConcours(){
        Boolean valide = true;
        Object val = listTypeHandicap.get(0);
        if(dateNaissancemField.getValue() == null){
            infoBoxError("date de Naissance du candidat non rensigné", "ERREUR", null);
        }else {
            try {
                Session sess;
                Type typeHandicap = null;
                Type concours = (Type) comboboxConcours.getValue();
                if(comboboxTypeHandicap.getValue() != null){
                if( !Objects.equals(comboboxTypeHandicap.getValue(), null)){
                    if(!comboboxTypeHandicap.getValue().equals(val)){
                        typeHandicap = (Type) this.comboboxTypeHandicap.getSelectionModel().getSelectedItem();
                    }
                }
                }else{
                        typeHandicap = null;
                }   
                sess = (Session)backendSessionController.getSessionActive();
                int intValue = Math.toIntExact(sess.getAnnee());
                LocalDate dateDeSession = LocalDate.of(intValue, 12, 31);
                String dateDeNaissanceStr = (String)dateNaissancemField.getValue().toString();
                LocalDate dateDeNaissance =  LocalDate.parse(dateDeNaissanceStr);
                //Calcule de l'age
                Period age = Period.between(dateDeNaissance, dateDeSession);
                int ageCondidtion = 0;
                if (dateDeNaissance.getMonthValue() == 12 && dateDeNaissance.getDayOfMonth()==31) {
                    // Age exact du candidat (cas de ceux née en/vers ou le 31/12/YYYY)
                    ageCondidtion = age.getYears();
                } else {
                    // Ceux née avant le 31/12 auront un an de plus apres le 31/12
                    ageCondidtion = age.getYears()+1;
                }
                if(ageCondidtion < 10 || ageCondidtion > 50)  {
                   infoBoxError("Âge du candidat pas normal","ERREUR", null);
                }else {
                if(concours.getId()== 1 || concours.getLibelle().equalsIgnoreCase("Entrée en Seconde")){
                    if (typeHandicap == null) {
                        System.out.print("j'ai pas d'handicap");
                        if(ageCondidtion >18)  {
                            System.out.print("1-18");
                            infoBoxError("Âge du candidat supérieur à 18 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }else{
                        System.out.print("j'ai un handicap");
                        if(ageCondidtion >21)  {
                            System.out.print("1-21");
                            infoBoxError("Âge du candidat supérieur à 20 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }
                }else if(concours.getId()== 2 || concours.getLibelle().equalsIgnoreCase("Prémière année BEP")){
                    System.out.print("je fais bep");
                    if(comboboxTypeHandicap.getValue() == null){
                        if(ageCondidtion >19)  {
                            System.out.print("2-19");
                            infoBoxError("Âge du candidat supérieur à 19 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }else{
                        if(ageCondidtion >21)  {
                            System.out.print("2-21");
                            infoBoxError("Âge du candidat supérieur à 21 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }
                    }
                }
            } catch (SQLException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            }
        }
        return valide;
    }
    
    
    public Boolean valideDateConcoursInsc(){
        Boolean valide = true;
        if(dateNaissancemField.getValue() == null){
            infoBoxError("date de Naissance du candidat non rensigné", "ERREUR", null);
        }else {
            try {
                Session sess;
                Type typeHandicap;
                Type concours = (Type) comboboxConcours.getValue();
                if(comboboxTypeHandicap.getValue() ==null || comboboxTypeHandicap.getValue().toString().isEmpty()){
                        typeHandicap = null;
                }else{
                    
                    typeHandicap = (Type) this.comboboxTypeHandicap.getSelectionModel().getSelectedItem();
                }
                sess = (Session)backendSessionController.getSessionActive();
                int intValue = Math.toIntExact(sess.getAnnee());
                LocalDate dateDeSession = LocalDate.of(intValue, 12, 31);
                String dateDeNaissanceStr = (String)dateNaissancemField.getValue().toString();
                LocalDate dateDeNaissance =  LocalDate.parse(dateDeNaissanceStr);
                //Calcule de l'age
                Period age = Period.between(dateDeNaissance, dateDeSession);
                int ageCondidtion = 0;
                if (dateDeNaissance.getMonthValue() == 12 && dateDeNaissance.getDayOfMonth()==31) {
                    // Age exact du candidat (cas de ceux née en/vers ou le 31/12/YYYY)
                    ageCondidtion = age.getYears();
                } else {
                    // Ceux née avant le 31/12 auront un an de plus apres le 31/12
                    ageCondidtion = age.getYears()+1;
                }
                if(ageCondidtion < 10 || ageCondidtion > 50)  {
                   infoBoxError("Âge du candidat pas normal","ERREUR", null);
                }else {
                if(concours.getId()== 1 || concours.getLibelle().equalsIgnoreCase("Entrée en Seconde")){
                    if (typeHandicap == null) {
                        System.out.print("j'ai pas d'handicap");
                        if(ageCondidtion >18)  {
                            System.out.print("1-18");
                            infoBoxError("Âge du candidat supérieur à 18 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }else{
                        System.out.print("j'ai un handicap");
                        if(ageCondidtion >21)  {
                            System.out.print("1-21");
                            infoBoxError("Âge du candidat supérieur à 20 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }
                }else if(concours.getId()== 2 || concours.getLibelle().equalsIgnoreCase("Prémière année BEP")){
                    System.out.print("je fais bep");
                    if(comboboxTypeHandicap.getValue() == null){
                        if(ageCondidtion >19)  {
                            System.out.print("2-19");
                            infoBoxError("Âge du candidat supérieur à 19 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }else{
                        if(ageCondidtion >21)  {
                            System.out.print("2-21");
                            infoBoxError("Âge du candidat supérieur à 21 ans. Candidat non éligible à ce concours.", "ERREUR", null);
                            return false;
                        }
                    }
                    }
                }
            } catch (SQLException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            }
        }
        return valide;
    }
    
    
    @FXML
    public void saveAction(ActionEvent e) {
        if(valideFormInsc() && valideDateConcoursInsc()){
            HashMap formData = new HashMap();
            Pays nationali = null ;
            Pays pay = null ;
            HashMap<Structure,SerieConcours> choix = new HashMap ();
            try {
                if(comboboxEtabPremier.getValue() != null && comboboxSeriePremier.getValue() != null){
                    Structure struct1 = listEtablissementChoix.stream()
                        .filter(obj -> (obj instanceof Structure))
                        .map(obj -> (Structure) obj)
                        .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxEtabPremier.getValue().toString()))
                        .findFirst().get();
            
                    SerieConcours serie1 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSeriePremier.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct1, serie1);
                }
                if(comboboxEtabSecond.getValue() != null && comboboxSeriePremier.getValue() != null){
                    Structure struct2 = listEtablissementChoix.stream()
                        .filter(obj -> (obj instanceof Structure))
                        .map(obj -> (Structure) obj)
                        .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxEtabSecond.getValue().toString()))
                        .findFirst().get();
            
                    SerieConcours serie2 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSerieSecond.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct2, serie2);
                }
                if(comboboxEtabTroisieme.getValue() != null && comboboxSerieTroisieme.getValue() != null){
                    Structure struct3 = listEtablissementChoix.stream()
                        .filter(obj -> (obj instanceof Structure))
                        .map(obj -> (Structure) obj)
                        .filter(structure -> structure.getNomStructure().equalsIgnoreCase(comboboxEtabTroisieme.getValue().toString()))
                        .findFirst().get();
            
                    SerieConcours serie3 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSerieTroisieme.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct3, serie3);
                }
                if(comboboxPaysNaissance.getValue() != null && comboboxPaysNaissance.getValue() != null){
                    pay = listPays.stream()
                        .filter(obj -> (obj instanceof Pays))
                        .map(obj -> (Pays) obj)
                        .filter(pays -> pays.getNomPays().equalsIgnoreCase(comboboxPaysNaissance.getValue().toString()))
                        .findFirst().get();
                }
                
                if(comboboxNationalite.getValue() != null && comboboxNationalite.getValue() != null){
                    nationali = listNationalite.stream()
                        .filter(obj -> (obj instanceof Pays))
                        .map(obj -> (Pays) obj)
                        .filter(pays -> pays.getNationalite().equalsIgnoreCase(comboboxNationalite.getValue().toString()))
                        .findFirst().get();
                }
                Sexe sexe = (Sexe)comboboxSexe.getValue();
                formData.put("session_id", ((Session)session ));
                formData.put("nom", this.toUpper(nomField.getText()));
                formData.put("prenom", this.firstLetterUpper(prenomField.getText()));
                formData.put("sexe", (Sexe)sexe);
                formData.put("dateNaissance", dateNaissancemField.getValue().toString());
                formData.put("lieuNaissance", this.firstLetterUpper(lieuNaissanceField.getText()));
                formData.put("numeroActeNaissance", numeroActeField.getText());
                formData.put("telephone", telephoneField.getText());
                formData.put("telephoneDeux", telephoneDeuxField.getText());
                formData.put("numeroDossier", numeroDossierField.getText());
                formData.put("centreExamen_id", ((Localite)comboboxCentreExamen.getValue()));
                formData.put("etablissement_id", ((Structure)comboboxEtablissement.getValue()));
                formData.put("zone_id", ((Localite)comboboxZone.getValue()));
                formData.put("typeCandidat_id", ((Type)comboboxStatut.getValue()));
                formData.put("typeSituation_id", ((Type)comboboxSituation.getValue()));
                formData.put("typeInscription_id", ((Type)comboboxTypeInscription.getValue()));
                formData.put("concours_id", ((Type)comboboxConcours.getValue()));
                formData.put("option_id", ((Option)comboboxOption.getValue()));
                formData.put("paysNaissance_id", pay);

                formData.put("nationalite_id", nationali);
                formData.put("anneeDernierDiplome", anneeCepField.getText().toString());
                formData.put("sport", (String)comboboxSport.getValue());
                formData.put("natureHandicap", (NatureHandicap) comboboxNatureHandicap.getValue());
                formData.put("prescription", (Type)comboboxPrescriptionHandicap.getValue());
                formData.put("groupePedagogique", (GroupePedagogique) comboboxGroupePedagogique.getValue());
                formData.put("nomPere", this.toUpper(nomPereField.getText()));
                formData.put("prenomPere", this.firstLetterUpper(prenomPereField.getText()));
                formData.put("nomMere", this.toUpper(nomMereField.getText()));
                formData.put("prenomMere", this.firstLetterUpper(prenomMereField.getText()));
                formData.put("typeDateNaissance", comboboxTypeDate.getValue());
                formData.put("choix", choix);
                backendInscriptionController.save(formData);
                infoBoxSuccess("Candidat Enregister Avec Succes","Succes",null);
                anneeCepField.clear();
                this.ActionClearAndDisable();
                saveButton.setDisable(true);
            } catch (SQLException ex) {
                    infoBoxError(ex.getMessage(), "ERREUR", null);
            } catch (bf.menapln.exception.EmptyDataException ex) {
                    infoBoxError(ex.getMessage(), "ERREUR", null);
            }
        }   
    }
    
    @FXML
    public void updateAction() {
         if(valideForm() && valideDateConcours()){
            HashMap formData = new HashMap();
            Pays nationali = null ;
            Pays pay = null ;
            Type typeHandicap = null;
            Object val = listTypeHandicap.get(0);
            Structure struct1 = null;
            Structure struct2 = null;
            Structure struct3 = null;
            if(comboboxTypeHandicap.getValue() != null){
                if( !Objects.equals(comboboxTypeHandicap.getValue(), null)){
                    if(!comboboxTypeHandicap.getValue().equals(val)){
                        typeHandicap = (Type) this.comboboxTypeHandicap.getSelectionModel().getSelectedItem();
                    }
                }
                }else{
                        typeHandicap = null;
                }   
            
            HashMap<Structure,SerieConcours> choix = new HashMap ();
            try {
                System.out.println("etab"+listEtablissementChoix+"serie"+listSerie);
                if(comboboxEtabPremier.getValue() != null && comboboxSeriePremier.getValue() != null ){
                    Object selectedValue = comboboxEtabPremier.getValue();
                        if (selectedValue instanceof String) {
                            String stringValue = (String) selectedValue;
                            struct1 = listEtablissementChoix.stream()
                                .filter(obj -> (obj instanceof Structure))
                                .map(obj -> (Structure) obj)
                                .filter(structure -> structure.getNomStructure().equalsIgnoreCase(stringValue))
                                .findFirst().get();
                            // Faire quelque chose avec la chaîne (stringValue)
                        } else {
                            struct1 = (Structure)selectedValue;
                        }
                    
                    SerieConcours serie1 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSeriePremier.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct1, serie1);
                }
                if(comboboxEtabSecond.getValue() != null && comboboxSeriePremier.getValue() != null){
                    Object selectedValue = comboboxEtabSecond.getValue();
                    if (selectedValue instanceof String) {
                            String stringValue = (String) selectedValue;
                            struct2 = listEtablissementChoix.stream()
                                .filter(obj -> (obj instanceof Structure))
                                .map(obj -> (Structure) obj)
                                .filter(structure -> structure.getNomStructure().equalsIgnoreCase(stringValue))
                                .findFirst().get();
                            // Faire quelque chose avec la chaîne (stringValue)
                        } else {
                            struct2 = (Structure)selectedValue;
                        }
            
                    SerieConcours serie2 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSerieSecond.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct2, serie2);
                }
                if(comboboxEtabTroisieme.getValue() != null && comboboxSerieTroisieme.getValue() != null){
                    Object selectedValue = comboboxEtabSecond.getValue();
                    if (selectedValue instanceof String) {
                            String stringValue = (String) selectedValue;
                            struct3 = listEtablissementChoix.stream()
                                .filter(obj -> (obj instanceof Structure))
                                .map(obj -> (Structure) obj)
                                .filter(structure -> structure.getNomStructure().equalsIgnoreCase(stringValue))
                                .findFirst().get();
                            // Faire quelque chose avec la chaîne (stringValue)
                        } else {
                            struct3 = (Structure)selectedValue;
                        }
            
                    SerieConcours serie3 = listSerie.stream()
                        .filter(obj -> (obj instanceof SerieConcours))
                        .map(obj -> (SerieConcours) obj)
                        .filter(structure -> structure.getSerie().getLibelle().equalsIgnoreCase(comboboxSerieTroisieme.getValue().toString()))
                        .findFirst().get();
                    choix.put(struct3, serie3); 
                }
                if(comboboxPaysNaissance.getValue() != null && comboboxPaysNaissance.getValue() != null){
                    pay = listPays.stream()
                        .filter(obj -> (obj instanceof Pays))
                        .map(obj -> (Pays) obj)
                        .filter(pays -> pays.getNomPays().equalsIgnoreCase(comboboxPaysNaissance.getValue().toString()))
                        .findFirst().get();
                }
                
                if(comboboxNationalite.getValue() != null && comboboxNationalite.getValue() != null){
                    nationali = listNationalite.stream()
                        .filter(obj -> (obj instanceof Pays))
                        .map(obj -> (Pays) obj)
                        .filter(pays -> pays.getNationalite().equalsIgnoreCase(comboboxNationalite.getValue().toString()))
                        .findFirst().get();
                }
                Sexe sexe = (Sexe)comboboxSexe.getValue();
                formData.put("candidat_id", this.getCandidatIdField().getText());
                formData.put("session_id", ((Session)session ));
                formData.put("nom", this.toUpper(nomField.getText()));
                formData.put("prenom", prenomField.getText());
                formData.put("sexe", (Sexe)sexe);
                formData.put("dateNaissance", dateNaissancemField.getValue().toString());
                formData.put("lieuNaissance", lieuNaissanceField.getText());
                formData.put("numeroActeNaissance", numeroActeField.getText());
                formData.put("telephone", telephoneField.getText());
                formData.put("numeroDossier", numeroDossierField.getText());
                formData.put("telephoneDeux", telephoneDeuxField.getText());
                formData.put("centreExamen_id", ((Centre)comboboxCentreExamen.getValue()));
                formData.put("zone_id", ((Localite)comboboxZone.getValue()));
                formData.put("etablissement_id", ((Structure)comboboxEtablissement.getValue()));
                formData.put("typeCandidat_id", ((Type)comboboxStatut.getValue()));
                formData.put("typeSituation_id", ((Type)comboboxSituation.getValue()));
                formData.put("typeInscription_id", ((Type)comboboxTypeInscription.getValue()));
                formData.put("concours_id", ((Type)comboboxConcours.getValue()));
                formData.put("option_id", ((Option)comboboxOption.getValue()));
                formData.put("paysNaissance_id", pay);
                formData.put("nationalite_id", nationali);
                formData.put("anneeDernierDiplome", anneeCepField.getText().toString());
                formData.put("sport", comboboxSport.getValue());
                formData.put("typeHandicap", typeHandicap);
                formData.put("natureHandicap", (NatureHandicap) comboboxNatureHandicap.getValue());
                formData.put("prescription", (Type)comboboxPrescriptionHandicap.getValue());
                formData.put("groupePedagogique", (GroupePedagogique) comboboxGroupePedagogique.getValue());
                formData.put("nomPere", nomPereField.getText());
                formData.put("prenomPere", prenomPereField.getText());
                formData.put("nomMere", nomMereField.getText());
                formData.put("prenomMere", prenomMereField.getText());
                formData.put("prenomMere", prenomMereField.getText());
                formData.put("typeDateNaissance", comboboxTypeDate.getValue());
                formData.put("choix", choix);
                backendInscriptionController.update(formData);
                infoBoxSuccess("Candidat Modifier Avec Succes","Succes",null);
            } catch (SQLException ex) {
              //  infoBoxError(ex.getMessage(), "ERREUR", null);
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (bf.menapln.exception.EmptyDataException ex) {
                infoBoxError(ex.getMessage(), "ERREUR", null);
            }
         }
    }
    
    @FXML
    public void ActionClearAndDisable(){
            //clear
            nomField.clear();
            prenomField.clear();
            nomMereField.clear();
            nomPereField.clear();
            prenomMereField.clear();
            prenomPereField.clear();
            telephoneField.clear();
            telephoneDeuxField.clear();
            numeroActeField.clear();
            numeroDossierField.clear();
            comboboxNationalite.setValue(null);
            comboboxOption.setValue(null);
            comboboxPaysNaissance.setValue(null);
            comboboxTypeDate.setValue(null);
            lieuNaissanceField.clear();
            comboboxSexe.setValue(null);
            comboboxSituation.setValue(null);
            comboboxSport.setValue(null);
            comboboxTypeHandicap.setValue(null);
            comboboxNatureHandicap.setValue(null);
            comboboxPrescriptionHandicap.setValue(null);
            dateNaissancemField.setValue(null);
            comboboxConcours.setValue(null);
            comboboxEtabPremier.setValue(null);
            comboboxSeriePremier.setValue(null);
            comboboxEtabSecond.setValue(null);
            comboboxSerieSecond.setValue(null);
            comboboxEtabTroisieme.setValue(null);
            comboboxSerieTroisieme.setValue(null);
            // Disable
            nomField.setDisable(true);
            prenomField.setDisable(true);
            nomMereField.setDisable(true);
            nomPereField.setDisable(true);
            prenomMereField.setDisable(true);
            prenomPereField.setDisable(true);
            telephoneField.setDisable(true);
            numeroDossierField.setDisable(true);
            telephoneDeuxField.setDisable(true);
            comboboxNationalite.setDisable(true);
            comboboxOption.setDisable(true);
            comboboxPaysNaissance.setDisable(true);
            comboboxTypeDate.setDisable(true);
            lieuNaissanceField.setDisable(true);
            comboboxSexe.setDisable(true);
            comboboxSituation.setDisable(true);
            comboboxSport.setDisable(true);
            comboboxTypeHandicap.setDisable(true);
            comboboxNatureHandicap.setDisable(true);
            comboboxPrescriptionHandicap.setDisable(true);
            dateNaissancemField.setDisable(true);
            comboboxConcours.setDisable(true);
            comboboxEtabPremier.setDisable(true);
            comboboxSeriePremier.setDisable(true);
            comboboxEtabSecond.setDisable(true);
            comboboxSerieSecond.setDisable(true);
            comboboxEtabTroisieme.setDisable(true);
            comboboxSerieTroisieme.setDisable(true);
            numeroActeField.setDisable(true);
    }

    @FXML
    public void resetAction(ActionEvent e) throws SQLException, EmptyDataException {
            comboboxRegion.setValue(null);
            comboboxProvince.setValue(null);
            comboboxCommune.setValue(null);
            comboboxCentreExamen.setValue(null);
            comboboxVillage.setValue(null);
            comboboxEtablissement.setValue(null);
            comboboxTypeInscription.setValue(null);
            comboboxStatut.setValue(null);
            comboboxGroupePedagogique.setValue(null);
            anneeCepField.clear();
            this.ActionClearAndDisable();
    }

    // Changing Region
    @FXML
    public void onChangeActionRegion(ActionEvent e) throws SQLException, EmptyDataException {
        Localite region = (Localite) comboboxRegion.getValue();
        try {
            if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Direction Centrale")){
                listProvince = convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString()));
                comboboxProvince.setItems(listProvince);
                filterOnComboBox(comboboxProvince,listProvince);
            }
            
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }
    
    // Changing Province
    @FXML
    public void onChangeActionProvince(ActionEvent e) throws SQLException, EmptyDataException {
        Localite province = (Localite) comboboxProvince.getValue();
        try {
            if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Direction Provinciale")){
                listCommune = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
               // listEtablissementChoix = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",province));
                comboboxCommune.setItems(listCommune);
               // comboboxEtabPremier.setItems(listEtablissementChoix);
               // comboboxEtabSecond.setItems(listEtablissementChoix);
               // comboboxEtabTroisieme.setItems(listEtablissementChoix);
                filterOnComboBox(comboboxCommune,listCommune);
            }else if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Etablissement")){
               // listEtablissementChoix = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",province));
               // comboboxEtabPremier.setItems(listEtablissementChoix);
               // comboboxEtabSecond.setItems(listEtablissementChoix);
               // comboboxEtabTroisieme.setItems(listEtablissementChoix);
            }
            
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }

    // Changing Commune
    @FXML
    public void onChangeActionCommune(ActionEvent e) throws SQLException, EmptyDataException {
        Localite commune = (Localite) comboboxCommune.getValue();
        try {
            listCentreExamen = convertToFxList(backendLocaliteController.getAllCentre(commune)); 
            listVillage = convertToFxList(backendLocaliteController.getAllByParent(commune.getId().toString()));
            listZone = convertToFxList(backendLocaliteController.getAllByTypeAndParent(commune.getId().toString(),"5"));
            comboboxCentreExamen.setItems(listCentreExamen);
            comboboxZone.setItems(listZone);
            comboboxVillage.setItems(listVillage);
            if(sessionManager.getUser().getStructure().getTypeStructure().getLibelle().equalsIgnoreCase("Direction Provinciale")){
            listEtablissement = convertToFxList(backendEtablissementController.getEtabByCommune("Etablissement",commune));
            comboboxEtablissement.setItems(listEtablissement);
            }
            
            filterOnComboBox(comboboxCentreExamen,listCentreExamen);
            filterOnComboBox(comboboxVillage,listVillage);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }
    
    // Changing Village
    @FXML
    public void onChangeActionVillage(ActionEvent e) throws SQLException, EmptyDataException {
        Localite village = (Localite) comboboxVillage.getValue();
       // try {
            //listEtablissement = backendEtablissementController.getEtabByLocalite("Etablissement",village);
            //comboboxEtablissement.setItems(listEtablissement);
         //   filterOnComboBox(comboboxEtablissement,listEtablissement);
       // } catch (SQLException ex) {
         //   Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        //}

    }
    
    // Changing Etablissement
    @FXML
    public void onChangeActionEtablissement(ActionEvent e) throws SQLException, EmptyDataException {
        Structure etablissement = (Structure) comboboxEtablissement.getValue();
        try {
            listGP = convertToFxList(backendGroupePedagogiqueController.getAllByEtab(etablissement.getId().toString()));
            comboboxGroupePedagogique.setItems(listGP);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }

    @FXML
    public void onChangeActionCentreExamen(ActionEvent e) throws SQLException, EmptyDataException {
        Localite province = (Localite) comboboxProvince.getValue();
        try {
            ObservableList<Object> list = convertToFxList(backendLocaliteController.getAllByParent(province.getId().toString()));
            comboboxCommune.setItems(list);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }
    
    @FXML
    public void onChangeDateNaissance(){
        String typeDate = (String)comboboxTypeDate.getValue();
        LocalDate selectedDate = dateNaissancemField.getValue();
        comboboxTypeHandicap.setItems(listTypeHandicap);
        try {
            if ("en".equalsIgnoreCase(typeDate) || "vers".equalsIgnoreCase(typeDate)) {
                // Vérifier si la date est différente du 31 décembre
                if (selectedDate.getDayOfMonth() != 31 || selectedDate.getMonth() != Month.DECEMBER) {
                    // Afficher une erreur
                    infoBoxError("Pour le type "+typeDate+" veuillez sélectionner le 31 décembre.","Erreur",null);
                    // Vous pouvez également forcer la date à être le 31 décembre
                    selectedDate = LocalDate.of(selectedDate.getYear(), Month.DECEMBER, 31);
                    dateNaissancemField.setValue(selectedDate);
                } else {
                    // La date est le 31 décembre, aucune action nécessaire
                }
            } else {
                // Le type n'est pas "en" ou "vers", aucune action nécessaire
            }
        } catch (DateTimeParseException e) {
            // Afficher une erreur si le format de date est incorrect
            infoBoxError("Format de date incorrect. Utilisez le format 'jj/mm/aaaa'.","Erreur",null);
        }
    }
    
    // changing année CEP Ou Equivalent
    @FXML
    public void onChangeActionAnneeDiplome() throws SQLException, EmptyDataException {
        int annee = Integer.parseInt(anneeCepField.getText());
        Session sess = (Session)session;
        int intValue = Math.toIntExact(sess.getAnnee());
        LocalDate dateDeSession = LocalDate.of(intValue, 12, 31);
        LocalDate dateDiplome = LocalDate.of(annee, 12, 31);
        //Calcule de l'age'
        Period age = Period.between(dateDiplome, dateDeSession);
        
        if(age.getYears() >3)  {
            nomField.setDisable(false);
            prenomField.setDisable(false);
            nomMereField.setDisable(false);
            nomPereField.setDisable(false);
            prenomMereField.setDisable(false);
            telephoneField.setDisable(false);
            telephoneDeuxField.setDisable(false);
            numeroDossierField.setDisable(false);
            prenomPereField.setDisable(false);
            comboboxNationalite.setDisable(false);
            comboboxOption.setDisable(false);
            comboboxPaysNaissance.setDisable(false);
            comboboxTypeDate.setDisable(false);
            lieuNaissanceField.setDisable(false);
            comboboxSexe.setDisable(false);
            comboboxSituation.setDisable(false);
            comboboxSport.setDisable(false);
            comboboxTypeHandicap.setDisable(false);
            comboboxConcours.setDisable(false);
            numeroActeField.setDisable(false);
        }else{
            infoBoxError("Année Diplôme Non Autorisé Pour la session", "ERREUR", null);
            // Desactiver
            nomField.setDisable(true);
            prenomField.setDisable(true);
            nomMereField.setDisable(true);
            nomPereField.setDisable(true);
            prenomMereField.setDisable(true);
            numeroDossierField.setDisable(true);
            prenomPereField.setDisable(true);
            telephoneField.setDisable(true);
            telephoneDeuxField.setDisable(true);
            comboboxNationalite.setDisable(true);
            comboboxOption.setDisable(true);
            comboboxPaysNaissance.setDisable(true);
            comboboxTypeDate.setDisable(true);
            lieuNaissanceField.setDisable(true);
            comboboxSexe.setDisable(true);
            comboboxSituation.setDisable(true);
            comboboxSport.setDisable(true);
            comboboxTypeHandicap.setDisable(true);
            comboboxNatureHandicap.setDisable(true);
            comboboxPrescriptionHandicap.setDisable(true);
            dateNaissancemField.setDisable(true);
            comboboxEtabPremier.setDisable(true);
            comboboxSeriePremier.setDisable(true);
            comboboxEtabSecond.setDisable(true);
            comboboxSerieSecond.setDisable(true);
            comboboxEtabTroisieme.setDisable(true);
            comboboxSerieTroisieme.setDisable(true);
            comboboxConcours.setDisable(true);
            // Vider
            nomField.clear();
            prenomField.clear();
            nomMereField.clear();
            nomPereField.clear();
            prenomMereField.clear();
            prenomPereField.clear();
            telephoneField.clear();
            telephoneDeuxField.clear();
            numeroDossierField.clear();
            comboboxNationalite.setValue(null);
            comboboxOption.setValue(null);
            comboboxPaysNaissance.setValue(null);
            comboboxTypeDate.setValue(null);
            lieuNaissanceField.clear();
            comboboxSexe.setValue(null);
            comboboxSituation.setValue(null);
            comboboxSport.setValue(null);
            comboboxTypeHandicap.setValue(null);
            comboboxNatureHandicap.setValue(null);
            comboboxPrescriptionHandicap.setValue(null);
           // dateNaissancemField.setValue(null);
            comboboxConcours.setValue(null);
            comboboxEtabPremier.setValue(null);
            comboboxSeriePremier.setValue(null);
            comboboxEtabSecond.setValue(null);
            comboboxSerieSecond.setValue(null);
            comboboxEtabTroisieme.setValue(null);
            comboboxSerieTroisieme.setValue(null);
        }
        
    }
    @FXML
    public void onChangeActionTypeDate(ActionEvent e) throws SQLException, EmptyDataException {
        dateNaissancemField.setDisable(false);
    }
    
    @FXML
    public void onChangeActionDate(ActionEvent e) throws SQLException, EmptyDataException {
       // comboboxConcours.setDisable(false);
       // comboboxConcours.setValue(null);
    }
    
    @FXML
    public void onChangeEtab(ActionEvent e) throws SQLException, EmptyDataException {
        saveButton.setDisable(false);
    }
    
    @FXML
    public void onChangeActionTypeHandicap(ActionEvent e) throws SQLException, EmptyDataException {
        if(comboboxTypeHandicap.getValue()!=null && !comboboxTypeHandicap.getValue().toString().equals(listTypeHandicap.get(0))){
            comboboxNatureHandicap.setValue(null);
            comboboxPrescriptionHandicap.setValue(null);
            Type typeHandicap = (Type) comboboxTypeHandicap.getValue();
            listNatureHandicap = convertToFxList(backendNaturehandicapController.getAllByType(typeHandicap));
            listNatureHandicap.add(0, ""); 
            comboboxNatureHandicap.setItems(listNatureHandicap);
            
            comboboxNatureHandicap.setDisable(false);
        }else{
            comboboxNatureHandicap.setValue(null);
            comboboxPrescriptionHandicap.setValue(null);
        }
        
    }
    
    @FXML
    public void onChangeActionNatureHandicap(ActionEvent e) throws SQLException, EmptyDataException {
        NatureHandicap natureHandicap = (NatureHandicap) comboboxNatureHandicap.getValue();
        if(comboboxNatureHandicap.getValue() != null){
            listPrescriptionHandicap = convertToFxList(backendPrescriptionNaturehandicapController.getByNatureHandicap(natureHandicap));
            listPrescriptionHandicap.add(0, ""); 
            comboboxPrescriptionHandicap.setDisable(false);
            comboboxPrescriptionHandicap.setItems(listPrescriptionHandicap);
        }
    }
    @FXML
    public void onChangeConcours(ActionEvent e) throws SQLException,EmptyDataException {
        if(comboboxConcours.getValue() != null){
            Type concours = (Type) comboboxConcours.getValue();
            Localite province = (Localite) comboboxProvince.getValue();
            Localite region = (Localite) comboboxRegion.getValue();
            if(concours.getId() == 1){
                    listSerie = convertToFxList(backendSerieConcoursRattacheController.getAllByConcours(concours));
                    listEtablissementChoix = convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",province));
                    comboboxEtabPremier.setItems(listEtablissementChoix);
                    comboboxEtabSecond.setItems(listEtablissementChoix);
                    comboboxEtabTroisieme.setItems(listEtablissementChoix);
                    
                    comboboxEtabPremier.setValue(null);
                    comboboxSeriePremier.setValue(null);
                    comboboxEtabSecond.setValue(null);
                    comboboxSerieSecond.setValue(null);
                    comboboxEtabTroisieme.setValue(null);
                    comboboxSerieTroisieme.setValue(null);

                    comboboxSeriePremier.setItems(listSerie);
                    comboboxSerieSecond.setItems(listSerie);
                    comboboxSerieTroisieme.setItems(listSerie);

                    comboboxConcours.setDisable(false);
                    comboboxEtabPremier.setDisable(false);
                    comboboxSeriePremier.setDisable(false);
                    comboboxEtabSecond.setDisable(false);
                    comboboxSerieSecond.setDisable(false);
                    comboboxEtabTroisieme.setDisable(false);
                    comboboxSerieTroisieme.setDisable(false);
                    
                    filterOnComboBox(comboboxEtabPremier, listEtablissementChoix);
                    filterOnComboBox(comboboxEtabSecond, listEtablissementChoix);
                    filterOnComboBox(comboboxEtabTroisieme, listEtablissementChoix);
                    
                    filterOnComboBox(comboboxSeriePremier, listSerie);
                    filterOnComboBox(comboboxSerieSecond, listSerie);
                    filterOnComboBox(comboboxSerieTroisieme, listSerie);
                }
            // Condition du BEP
            else if(concours.getId() == 2){
                    listSerie = convertToFxList(backendSerieConcoursRattacheController.getAllByConcours(concours));
                    listEtablissementChoix = convertToFxList(backendEtablissementController.getEtabByRegion("Etablissement",region));
                    comboboxEtabPremier.setItems(listEtablissementChoix);
                    comboboxEtabSecond.setItems(listEtablissementChoix);
                    comboboxEtabTroisieme.setItems(listEtablissementChoix);
                    comboboxEtabPremier.setValue(null);
                    comboboxSeriePremier.setValue(null);
                    comboboxEtabSecond.setValue(null);
                    comboboxSerieSecond.setValue(null);
                    comboboxEtabTroisieme.setValue(null);
                    comboboxSerieTroisieme.setValue(null);

                    comboboxSeriePremier.setItems(listSerie);
                    comboboxSerieSecond.setItems(listSerie);
                    comboboxSerieTroisieme.setItems(listSerie);

                    comboboxConcours.setDisable(false);
                    comboboxEtabPremier.setDisable(false);
                    comboboxSeriePremier.setDisable(false);
                    comboboxEtabSecond.setDisable(false);
                    comboboxSerieSecond.setDisable(false);
                    comboboxEtabTroisieme.setDisable(false);
                    comboboxSerieTroisieme.setDisable(false);
                    
                    filterOnComboBox(comboboxEtabPremier, listEtablissementChoix);
                    filterOnComboBox(comboboxEtabSecond, listEtablissementChoix);
                    filterOnComboBox(comboboxEtabTroisieme, listEtablissementChoix);
                    
                    filterOnComboBox(comboboxSeriePremier, listSerie);
                    filterOnComboBox(comboboxSerieSecond, listSerie);
                    filterOnComboBox(comboboxSerieTroisieme, listSerie);
            }
            // Condition du BEPC SEUL
            else{
                    comboboxEtabPremier.setValue(null);
                    comboboxSeriePremier.setValue(null);
                    comboboxEtabSecond.setValue(null);
                    comboboxSerieSecond.setValue(null);
                    comboboxEtabTroisieme.setValue(null);
                    comboboxSerieTroisieme.setValue(null);

                    comboboxEtabPremier.setDisable(true);
                    comboboxSeriePremier.setDisable(true);
                    comboboxEtabSecond.setDisable(true);
                    comboboxSerieSecond.setDisable(true);
                    comboboxEtabTroisieme.setDisable(true);
                    comboboxSerieTroisieme.setDisable(true);
                    saveButton.setDisable(false);
            }
        }
}
    
    
    public void disableAll(){
        nomField.setDisable(false);
        prenomField.setDisable(false);
        nomMereField.setDisable(false);
        nomPereField.setDisable(false);
        prenomMereField.setDisable(false);
        telephoneField.setDisable(false);
        telephoneDeuxField.setDisable(false);
        numeroActeField.setDisable(false);
        prenomPereField.setDisable(false);
        numeroDossierField.setDisable(false);
        comboboxNationalite.setDisable(false);
        comboboxOption.setDisable(false);
        comboboxPaysNaissance.setDisable(false);
        comboboxTypeDate.setDisable(false);
        lieuNaissanceField.setDisable(false);
        comboboxSexe.setDisable(false);
        comboboxSituation.setDisable(false);
        comboboxSport.setDisable(false);
        comboboxTypeHandicap.setDisable(false);
        dateNaissancemField.setDisable(false);
        comboboxConcours.setDisable(false);
        comboboxNatureHandicap.setDisable(false);
        comboboxPrescriptionHandicap.setDisable(false);
    }
    // GETTERS AND SETTERS

    public ComboBox<Object> getComboboxRegion() {
        return comboboxRegion;
    }

    public void setComboboxRegion(ObservableList<Object> listRegion) {
        this.comboboxRegion.setItems(listRegion);
    }

    public ComboBox<Object> getComboboxProvince() {
        return comboboxProvince;
    }

    public void setComboboxProvince(ObservableList<Object> comboboxProvince) {
        this.comboboxProvince.setItems(comboboxProvince);
    }

    public ComboBox<Object> getComboboxCommune() {
        return comboboxCommune;
    }

    public void setComboboxCommune(ObservableList<Object> comboboxCommune) {
        this.comboboxCommune.setItems(comboboxCommune);
    }

    public ComboBox<Object> getComboboxVillage() {
        return comboboxVillage;
    }

    public void setComboboxVillage(ObservableList<Object> comboboxVillage) {
        this.comboboxVillage.setItems(comboboxVillage);
    }

    public ComboBox<Object> getComboboxCentreExamen() {
        return comboboxCentreExamen;
    }

    public void setComboboxCentreExamen(ObservableList<Object> comboboxCentreExamen) {
        this.comboboxCentreExamen.setItems(comboboxCentreExamen);
    }

    public ComboBox<Object> getComboboxEtablissement() {
        return comboboxEtablissement;
    }

    public void setComboboxEtablissement(ObservableList<Object> comboboxEtablissement) {
        this.comboboxEtablissement.setItems(comboboxEtablissement);
    }

    public ComboBox<Object> getComboboxGroupePedagogique() {
        return comboboxGroupePedagogique;
    }

    public void setComboboxGroupePedagogique(ObservableList<Object> comboboxGroupePedagogique) {
        this.comboboxGroupePedagogique.setItems(comboboxGroupePedagogique);
    }

    public ComboBox<Object> getComboboxTypeInscription() {
        return comboboxTypeInscription;
    }

    public void setComboboxTypeInscription(ObservableList<Object> comboboxTypeInscription) {
        this.comboboxTypeInscription.setItems(comboboxTypeInscription);
    }

    public ComboBox<Object> getComboboxStatut() {
        return comboboxStatut;
    }

    public void setComboboxStatut(ObservableList<Object> comboboxStatut) {
        this.comboboxStatut.setItems(comboboxStatut);
    }

    public ComboBox<Object> getComboboxPaysNaissance() {
        return comboboxPaysNaissance;
    }

    public void setComboboxPaysNaissance(ObservableList<Object> comboboxPaysNaissance) {
        this.comboboxPaysNaissance.setItems(comboboxPaysNaissance);
    }

    public ComboBox<Object> getComboboxNationalite() {
        return comboboxNationalite;
    }

    public void setComboboxNationalite(ObservableList<Object> comboboxNationalite) {
        this.comboboxNationalite.setItems(comboboxNationalite);
    }

    public ComboBox<String> getComboboxTypeDate() {
        return comboboxTypeDate;
    }

    public void setComboboxTypeDate(ObservableList<String> comboboxTypeDate) {
        this.comboboxTypeDate.setItems(comboboxTypeDate);
    }

    public ComboBox<Sexe> getComboboxSexe() {
        return comboboxSexe;
    }

    public void setComboboxSexe(ObservableList<Sexe> comboboxSexe) {
        this.comboboxSexe.setItems(comboboxSexe);
    }

    public ComboBox<Object> getComboboxSituation() {
        return comboboxSituation;
    }

    public void setComboboxSituation(ObservableList<Object> comboboxSituation) {
        this.comboboxSituation.setItems(comboboxSituation);
    }

    public ComboBox<Object> getComboboxOption() {
        return comboboxOption;
    }

    public void setComboboxOption(ObservableList<Object> comboboxOption) {
        this.comboboxOption.setItems(comboboxOption);
    }

    public ComboBox<String> getComboboxSport() {
        return comboboxSport;
    }

    public void setComboboxSport(ObservableList<String> comboboxSport) {
        this.comboboxSport.setItems(comboboxSport);
    }

    public ComboBox<Object> getComboboxTypeHandicap() {
        return comboboxTypeHandicap;
    }

    public void setComboboxTypeHandicap(ObservableList<Object> comboboxTypeHandicap) {
        this.comboboxTypeHandicap.setItems(comboboxTypeHandicap);
    }

    public ComboBox<Object> getComboboxConcours() {
        return comboboxConcours;
    }

    public void setComboboxConcours(ObservableList<Object> comboboxConcours) {
        this.comboboxConcours.setItems(comboboxConcours);
    }

    public ComboBox<Object> getComboboxNatureHandicap() {
        return comboboxNatureHandicap;
    }

    public void setComboboxNatureHandicap(ObservableList<Object> comboboxNatureHandicap) {
        this.comboboxNatureHandicap.setItems(comboboxNatureHandicap);
    }

    public ComboBox<Object> getComboboxPrescriptionHandicap() {
        return comboboxPrescriptionHandicap;
    }

    public void setComboboxPrescriptionHandicap(ObservableList<Object> comboboxPrescriptionHandicap) {
        this.comboboxPrescriptionHandicap.setItems(comboboxPrescriptionHandicap);
    }

    public ComboBox<Object> getComboboxEtabPremier() {
        return comboboxEtabPremier;
    }

    public void setComboboxEtabPremier(ObservableList<Object> comboboxEtabPremier) {
        this.comboboxEtabPremier.setItems(comboboxEtabPremier);
    }

    public ComboBox<Object> getComboboxSeriePremier() {
        return comboboxSeriePremier;
    }

    public void setComboboxSeriePremier(ObservableList<Object> comboboxSeriePremier) {
        this.comboboxSeriePremier.setItems(comboboxSeriePremier);
    }

    public ComboBox<Object> getComboboxEtabSecond() {
        return comboboxEtabSecond;
    }

    public void setComboboxEtabSecond(ObservableList<Object> comboboxEtabSecond) {
        this.comboboxEtabSecond.setItems(comboboxEtabSecond);
    }

    public ComboBox<Object> getComboboxSerieSecond() {
        return comboboxSerieSecond;
    }

    public void setComboboxSerieSecond(ObservableList<Object> comboboxSerieSecond) {
        this.comboboxSerieSecond.setItems(comboboxSerieSecond);
    }

    public ComboBox<Object> getComboboxEtabTroisieme() {
        return comboboxEtabTroisieme;
    }

    public void setComboboxEtabTroisieme(ObservableList<Object> comboboxEtabTroisieme) {
        this.comboboxEtabTroisieme.setItems(comboboxEtabTroisieme);
    }

    public ComboBox<Object> getComboboxSerieTroisieme() {
        return comboboxSerieTroisieme;
    }

    public void setComboboxSerieTroisieme(ObservableList<Object> comboboxSerieTroisieme) {
        this.comboboxSerieTroisieme.setItems(comboboxSerieTroisieme);
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

    public TextField getLieuNaissanceField() {
        return lieuNaissanceField;
    }

    public void setLieuNaissanceField(String lieuNaissanceField) {
        this.lieuNaissanceField.setText(lieuNaissanceField);
    }

    public TextField getTelephoneField() {
        return telephoneField;
    }

    public void setTelephoneField(String telephoneField) {
        this.telephoneField.setText(telephoneField);
    }

    public TextField getTelephoneDeuxField() {
        return telephoneDeuxField;
    }

    public void setTelephoneDeuxField(String telephoneDeuxField) {
        this.telephoneDeuxField.setText(telephoneDeuxField);
    }

    public TextField getNomPereField() {
        return nomPereField;
    }

    public void setNomPereField(String nomPereField) {
        this.nomPereField.setText(nomPereField);
    }

    public TextField getPrenomPereField() {
        return prenomPereField;
    }

    public void setPrenomPereField(String prenomPereField) {
        this.prenomPereField.setText(prenomPereField);
    }

    public TextField getNomMereField() {
        return nomMereField;
    }

    public void setNomMereField(String nomMereField) {
        this.nomMereField.setText(nomMereField);
    }

    public TextField getPrenomMereField() {
        return prenomMereField;
    }

    public void setPrenomMereField(String prenomMereField) {
        this.prenomMereField.setText(prenomMereField);
    }

    public TextField getAnneeCepField() {
        return anneeCepField;
    }

    public void setAnneeCepField(Long anneeCepField) {
        this.anneeCepField.setText(anneeCepField.toString());
    }

    public DatePicker getDateNaissancemField() {
        return dateNaissancemField;
    }

    public void setDateNaissancemField(DatePicker dateNaissancemField) {
        this.dateNaissancemField = dateNaissancemField;
    }

    public ObservableList<String> getListSport() {
        return listSport;
    }

    public void setListSport(ObservableList<String> listSport) {
        this.listSport = listSport;
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

    public ObservableList<Object> getListPays() {
        return listPays;
    }

    public void setListPays(ObservableList<Object> listPays) {
        this.listPays = listPays;
    }

    public ObservableList<Object> getListEtabCommune() {
        return listEtabCommune;
    }

    public void setListEtabCommune(ObservableList<Object> listEtabCommune) {
        this.listEtabCommune = listEtabCommune;
    }

    public ObservableList<Object> getListEtabProvince() {
        return listEtabProvince;
    }

    public void setListEtabProvince(ObservableList<Object> listEtabProvince) {
        this.listEtabProvince = listEtabProvince;
    }

    public ObservableList<Object> getListVillage() {
        return listVillage;
    }

    public void setListVillage(ObservableList<Object> listVillage) {
        this.listVillage = listVillage;
    }

    public ObservableList<Object> getListTypeInsc() {
        return listTypeInsc;
    }

    public void setListTypeInsc(ObservableList<Object> listTypeInsc) {
        this.listTypeInsc = listTypeInsc;
    }

    public ObservableList<Object> getListTypeStatut() {
        return listTypeStatut;
    }

    public void setListTypeStatut(ObservableList<Object> listTypeStatut) {
        this.listTypeStatut = listTypeStatut;
    }

    public ObservableList<Object> getListGPEtab() {
        return listGPEtab;
    }

    public void setListGPEtab(ObservableList<Object> listGPEtab) {
        this.listGPEtab = listGPEtab;
    }

    public ObservableList<Object> getListTypeSituation() {
        return listTypeSituation;
    }

    public void setListTypeSituation(ObservableList<Object> listTypeSituation) {
        this.listTypeSituation = listTypeSituation;
    }

    public ObservableList<Object> getListOption() {
        return listOption;
    }

    public void setListOption(ObservableList<Object> listOption) {
        this.listOption = listOption;
    }

    public ObservableList<Object> getListTypeHandicap() {
        return listTypeHandicap;
    }

    public void setListTypeHandicap(ObservableList<Object> listTypeHandicap) {
        this.listTypeHandicap = listTypeHandicap;
    }

    public ObservableList<Object> getListTypeConcours() {
        return listTypeConcours;
    }

    public void setListTypeConcours(ObservableList<Object> listTypeConcours) {
        this.listTypeConcours = listTypeConcours;
    }

    public ObservableList<Object> getListTypeSerie() {
        return listTypeSerie;
    }

    public void setListTypeSerie(ObservableList<Object> listTypeSerie) {
        this.listTypeSerie = listTypeSerie;
    }

    public ObservableList<Object> getListNationalite() {
        return listNationalite;
    }

    public void setListNationalite(ObservableList<Object> listNationalite) {
        this.listNationalite = listNationalite;
    }

    public ObservableList<Object> getListNatureHandicap() {
        return listNatureHandicap;
    }

    public void setListNatureHandicap(ObservableList<Object> listNatureHandicap) {
        this.listNatureHandicap = listNatureHandicap;
    }

    public ObservableList<Object> getListPrescriptionHandicap() {
        return listPrescriptionHandicap;
    }

    public void setListPrescriptionHandicap(ObservableList<Object> listPrescriptionHandicap) {
        this.listPrescriptionHandicap = listPrescriptionHandicap;
    }

    public ObservableList<Object> getListCentreExamen() {
        return listCentreExamen;
    }

    public void setListCentreExamen(ObservableList<Object> listCentreExamen) {
        this.listCentreExamen = listCentreExamen;
    }

    public ObservableList<Object> getListProvince() {
        return listProvince;
    }

    public void setListProvince(ObservableList<Object> listProvince) {
        this.listProvince = listProvince;
    }

    public ObservableList<Object> getListCommune() {
        return listCommune;
    }

    public void setListCommune(ObservableList<Object> listCommune) {
        this.listCommune = listCommune;
    }

    public ObservableList<Object> getListEtablissement() {
        return listEtablissement;
    }

    public void setListEtablissement(ObservableList<Object> listEtablissement) {
        this.listEtablissement = listEtablissement;
    }

    public ObservableList<Object> getListSerie() {
        return listSerie;
    }

    public void setListSerie(ObservableList<Object> listSerie) {
        this.listSerie = listSerie;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public ObservableList<String> getListTypeDate() {
        return listTypeDate;
    }

    public void setListTypeDate(ObservableList<String> listTypeDate) {
        this.listTypeDate = listTypeDate;
    }

    public Button getModifButton() {
        return modifButton;
    }

    public void setModifButton(Button modifButton) {
        this.modifButton = modifButton;
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

    public ComboBox<Object> getComboboxZone() {
        return comboboxZone;
    }

    public void setComboboxZone(ObservableList<Object> comboboxZone) {
        this.comboboxZone.setItems(comboboxZone);
    }

    public ObservableList<Object> getListEtablissementChoix() {
        return listEtablissementChoix;
    }

    public void setListEtablissementChoix(ObservableList<Object> listEtablissementChoix) {
        this.listEtablissementChoix = listEtablissementChoix;
    }

    public ObservableList<Object> getListGP() {
        return listGP;
    }

    public void setListGP(ObservableList<Object> listGP) {
        this.listGP = listGP;
    }

    public ObservableList<Object> getListZone() {
        return listZone;
    }

    public void setListZone(ObservableList<Object> listZone) {
        this.listZone = listZone;
    }

    public TextField getNumeroActeField() {
        return numeroActeField;
    }

    public void setNumeroActeField(String numeroActeField) {
        this.numeroActeField.setText(numeroActeField);
    }

    public TextField getNumeroDossierField() {
        return numeroDossierField;
    }

    public void setNumeroDossierField(String numeroDossierField) {
        this.numeroDossierField.setText(numeroDossierField);
    }
    
    
    
    
}
