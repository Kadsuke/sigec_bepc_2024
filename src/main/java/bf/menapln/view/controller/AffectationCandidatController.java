package bf.menapln.view.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.service.SessionService;
import exception.EmptyDataException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class AffectationCandidatController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!\n";
    
    @FXML
    public ComboBox<Object> comboboxCentreExamen;
    @FXML
    public ComboBox<Object> comboboxJury;
    @FXML
    public ComboBox<Object> comboboxZone;
    @FXML
    public ComboBox<Object> comboboxCentreSecondaire;
    @FXML
    public ComboBox<Object> comboboxEtab;
    @FXML
    public ComboBox<Object> optionsCombo;
    @FXML
    public ComboBox<Object> comboboxEsh;
    
    @FXML
    public TextField juryLibelleField;
    @FXML
    public TitledPane titre;
    @FXML
    public Label msgSpecialite;
    @FXML
    public Label msgJury;
    @FXML
    public Label msgCentreExamen;
    @FXML 
    public CheckBox toutCocherCheckBox;
    @FXML
    public ComboBox<Object> etatAffecter;
    
    /* @FXML 
    public TextField capaciteField; */

    @FXML 
    public TextField rechercheField;
    @FXML 
    public Button bntEnregistrer;
    @FXML
    public Button btnModifier;
    @FXML
    public Button btnAnnuler;
    @FXML
    public Button btnSupprimer;
    @FXML
    public Label effectif;

    @FXML
    public TableColumn<CandidatJury,Integer> colId;
    @FXML
    public TableColumn<CandidatJury,String> session;
    @FXML
    public TableColumn<CandidatJury,Integer> numDossier;
    @FXML
    public TableColumn<CandidatJury, String> nom;
    @FXML
    public TableColumn<CandidatJury, String> prenom;
    @FXML
    public TableColumn<CandidatJury, String> dateNaissance;
    @FXML
    public TableColumn<CandidatJury, String> sexe;
    @FXML
    public TableColumn<CandidatJury, String> option;
    @FXML
    public TableColumn<CandidatJury, String> groupePedagogique;
    @FXML
    public TableColumn<CandidatJury, String> telephone;
    @FXML
    public TableColumn<CandidatJury, String> concours;
    @FXML
    public TableColumn<CandidatJury, String> diplome;

    @FXML
    public TableColumn<CandidatJury, String> typehandicap;
    @FXML
    public TableColumn<CandidatJury, String> sport;
    @FXML
    public TableColumn<CandidatJury, String> examen;
    @FXML
    public TableColumn<CandidatJury, String> colEpreuves;
    @FXML
    public TableColumn<CandidatJury, String> choix;
    @FXML
    public TableColumn<CandidatJury, String> nomPere;
    @FXML
    public TableColumn<CandidatJury, String> prenomPere;
    @FXML
    public TableColumn<CandidatJury, String> nomMere;
    @FXML
    public TableColumn<CandidatJury, String> prenomMere;
    @FXML
    public TableColumn<CandidatJury, String> lieuNaissance;
    @FXML
    public TableColumn<CandidatJury, String> centre;
    @FXML
    public TableColumn<CandidatJury, String> zone;
    @FXML
    public TableColumn<CandidatJury, String> etablissement;
    @FXML
    public TableColumn<CandidatJury, String> handicap;
    @FXML
    public TableColumn<CandidatJury, String> cocher;
    @FXML
    public TableColumn<CandidatJury, String> jury;
    @FXML
    public TextField lesXpremiers;

    @FXML
    public Label effectifJury;
    
    @FXML
    private BorderPane borderFils;
    
    Localite centreExamen;
    Localite centreSecondaire;
    ObservableList<Object> listOption,listCentreExamens,listCentreSecondaires,listJury,listZones,listCandidatsFiltre,listCandidats;
    List<Objet> candidatsSelected = new ArrayList<>();
    public AffectationCandidatController() throws SQLException {
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendJuryController = new BackendJuryController();
        this.backendCentreController = new BackendCentreController();
        this.backendOptionController = new BackendOptionController();
        this.backendSessionController = new BackendSessionController();
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendAffectationCandidatController = new BackendAffectationCandidatController();
    }

    BackendOptionController backendOptionController;
    BackendCentreController backendCentreController;
    BackendJuryController backendJuryController;
    BackendLocaliteController backendLocaliteController;
    BackendSessionController backendSessionController;
    BackendInscriptionController backendInscriptionController;
    BackendAffectationCandidatController backendAffectationCandidatController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.listCandidats = this.convertToFxList(this.backendAffectationCandidatController.getAllCandidatJury());  
            this.listOption = convertToFxList(backendOptionController.getAll());
            this.listCentreExamens = convertToFxList(this.backendCentreController.getAllSpecial()
            .stream()
            .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            .filter(localite->localite != null && localite.getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            .collect(Collectors.toList()));

            optionsCombo.setItems(this.listOption);
            comboboxCentreExamen.setItems(listCentreExamens);
            this.comboboxEsh.setItems(FXCollections.observableArrayList("OUI","NON"));
            this.comboboxZone.setItems(FXCollections.observableArrayList("OUI","NON"));
          //  this.comboboxEsh.setValue("NON");
            this.etatAffecter.setItems(FXCollections.observableArrayList("tout le monde","affectés uniquement","NON affectés uniquement"));
            this.lesXpremiers.setOnAction(e->{
                this.cocherLesXpremiers();
            });
           // this.etatAffecter.setValue("tout le monde");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void cocherLesXpremiers(){
        try {
            Integer x = Integer.parseInt(lesXpremiers.getText());
            int nbElem = this.tableView.getItems().size();
            if (toutEstCocher) {//Si tout est déjà coché
                if (nbElem <= x) {//ne rien faire
                } else {//Décocher tous ceux après x
                    for (int j = x; j < nbElem; j++) {
                        ((Objet)this.tableView.getItems().get(j)).setChecked(false);
                    }
                }
            } else {//si tout n'est pas coché
                if (nbElem <= x) {//cocher tout
                    toutEstCocher = false;
                    this.toutCocher();
                } else {//Cocher les x premiers
                    toutEstCocher = true;
                    this.toutCocher();//décocher tout avant de cocher les x premiers
                    for (int j = 0; j < x; j++) {
                        ((Objet)this.tableView.getItems().get(j)).setChecked(true);
                    }
                }
            }
            toutEstCocher = false;
            toutCocherCheckBox.setSelected(false);
            this.tableView.refresh();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    // Changing Centre Examen
    @FXML
    public void onChangeActionCentre(ActionEvent e) throws SQLException, EmptyDataException {
        this.comboboxEsh.setValue(null);
        this.etatAffecter.setValue(null);
        this.effectifJury.setText("Jury *");
        this.effectifJury.setTextFill(Color.BLACK);
        this.centreExamen = (Localite) comboboxCentreExamen.getValue();
        this.listZones = convertToFxList(this.backendLocaliteController.getAll("").stream()
        .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
        .filter(localit->localit != null && localit.getTypeLocalite().getLibelle().equalsIgnoreCase("Zone") && localit.getParentLocalite().getId().equals(this.centreExamen.getId()))
        .collect(Collectors.toList()));
       // comboboxZone.setItems(this.listZones);
        this.listJury = convertToFxList(this.backendJuryController.getAll().stream()
        .map(obj-> (obj instanceof Jury)?(Jury) obj : null)
        .filter(jury->jury != null && jury.getCentreExamen().getId().equals(centreExamen.getId()))
        .collect(Collectors.toList()));
        comboboxJury.setItems(this.listJury);
        this.candidatsSelected.clear();
        toutCocherCheckBox.setSelected(false);
        this.tableView.setItems(null);
         
    }

    // Changing Zone
    @FXML
    public void onChangeActionZone(ActionEvent e) throws SQLException, EmptyDataException {
        this.comboboxEsh.setValue(null);
        this.etatAffecter.setValue(null);
        this.candidatsSelected.clear();
        this.tableView.setItems(null);

    }

    @FXML
    public void onChangeActionOption(ActionEvent e) throws SQLException, EmptyDataException {
        this.comboboxEsh.setValue(null);
        this.etatAffecter.setValue(null);
        this.comboboxZone.setValue(null);
        this.candidatsSelected.clear();
        toutCocherCheckBox.setSelected(false);
        this.tableView.setItems(null);
    }

    // Changing Zone
    @FXML
    public void onChangeActionJury(ActionEvent e) throws SQLException, EmptyDataException {
        if (this.comboboxJury.getValue()!=null) {
            this.comboboxEsh.setValue(null);
            this.etatAffecter.setValue(null);
            this.comboboxZone.setValue(null);
            this.tableView.setItems(null);
            toutCocherCheckBox.setSelected(false);
            Jury j = (Jury)this.comboboxJury.getValue();
            comboboxCentreSecondaire.setItems(convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
            this.effectifJury.setText("Jury * (Eff. actuel : "+this.effectifJurySelected(j)+")");
            this.effectifJury.setTextFill(Color.RED);
            this.msgJury.setText(((Jury)this.comboboxJury.getValue()).toString());                
                this.msgSpecialite.setText(((Option)this.optionsCombo.getValue()).toString());
                this.msgCentreExamen.setText(((Localite)this.centreExamen).toString());
        }
    }
       // Effectif du Jury courant
        public int effectifJurySelected(Jury j){
            List<Object> listCandidatJury = listCandidats.stream()
            .filter(c->((CandidatJury)c).getJury() != null
            ).collect(Collectors.toList());
            listCandidatJury = listCandidatJury.stream()
            .filter(c->((CandidatJury)c).getJury().getId().equals(j.getId())
            ).collect(Collectors.toList());
            return listCandidatJury.size();

        }
        /*Option op = (Option)this.optionsCombo.getValue();
        comboboxCentreSecondaire.setItems(convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
        this.listCandidatsFiltre = this.convertToFxList(this.listCandidats.stream()
                .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getCentre().getId().equals(this.centreExamen.getCentre().getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();
                this.msgJury.setText(((Jury)this.comboboxJury.getValue()).toString());                
                this.msgSpecialite.setText(((Option)this.optionsCombo.getValue()).toString());
                this.msgCentreExamen.setText(((Centre)this.centreExamen).toString());*/

   // }

    // Changing Centre Secondaire
    @FXML
    public void onChangeActionCentreSecondaire(ActionEvent e) throws SQLException, EmptyDataException {
        this.comboboxEsh.setValue(null);
        this.etatAffecter.setValue(null);
        this.tableView.setItems(null);
        toutCocherCheckBox.setSelected(false);
        this.centreSecondaire = (Localite) comboboxCentreSecondaire.getValue();
        Option op = (Option)this.optionsCombo.getValue();
            if (this.comboboxCentreSecondaire.getValue()!=null) {
                this.listCandidatsFiltre = this.convertToFxList(this.listCandidats.stream()
                .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreSecondaire.getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();
            }

    }

    @FXML
    public void saveAction(ActionEvent e) throws SQLException, EmptyDataException {
        HashMap formData = new HashMap();
        SessionService sessionService = new SessionService();
        this.candidatsSelected.clear();
        for (Object object : this.tableView.getItems()) {
            if (((Objet)object).isChecked()) {
                this.candidatsSelected.add((Objet)object);
            }
        }
        try {
            Session session = (Session)sessionService.getActiveSession();
            formData.put("session", session);
            formData.put("jury", (Jury)this.comboboxJury.getValue());            
            formData.put("listCandidats", this.candidatsSelected);
            List<Objet> savedCandidats = backendAffectationCandidatController.save(formData);
            this.infoBoxSuccess(this.succes+" \n ("+savedCandidats.size()+" candidats affectés)", "SUCCES", null);
            this.candidatsSelected.clear();
            this.tableView.refresh();
            toutCocherCheckBox.setSelected(false);
        } catch (SQLException | bf.menapln.exception.EmptyDataException ex) {
            this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }

    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listCandidats();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
        this.titre.setText("Listes des candidats par ordre alpha. correspondants au filtre ( Effectif : "+this.tableView.getItems().size()+")");
    }

@FXML
    private void listCandidats(){
        this.titre.setText("Listes des candidats par ordre alpha. correspondants au filtre ( Effectif : "+listCandidatsFiltre.size()+")");
        jury.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getJury()!=null)?cellData.getValue().getJury().getJuryLibelle():"????")); 
        nom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));           
        prenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom())); 
        dateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getDateNaissance().toString()));
        option.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getOption().getOptionLibelle()));
        sexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getSexe().name()));
       // sport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getSport()));
        lieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getLieuNaissance()));
        etablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getEtablissementCandidat().getNomStructure()));
        //handicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrescriptionHandicap().getLibelle()));
        typehandicap.setCellValueFactory(cellData->{
            String typeHandicapLibelle = cellData.getValue().getCandidat().getTypeHandicap().getLibelle();
            return new SimpleStringProperty((typeHandicapLibelle == null) ? "Non" : typeHandicapLibelle);
        });
        
        //this.toStringProperty(cellData.getValue().getCandidat().getTypeHandicap().getLibelle()));
        handicap.setCellValueFactory(cellData -> {
            String natureHandicapLibelle = cellData.getValue().getCandidat().getPrescriptionHandicap().getLibelle();
            return new SimpleStringProperty((natureHandicapLibelle == null) ? "Non" : natureHandicapLibelle);
        });
        cocher.setCellValueFactory( 
        c -> {
            CandidatJury j = c.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().setValue(j.isChecked());
            // System.out.println("JURY "+j+" EST DEJA COCHER : "+j.isChecked());
            checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                j.setChecked(new_val);
                // System.out.println("JURY "+j+" COCHER : "+j.isChecked());
            });
            return new SimpleObjectProperty(checkBox);
        });
        tableView.setItems(listCandidatsFiltre);
    }

    @FXML
    public void rowClicked(MouseEvent e){//au click d'une ligne du tableau
        try {
            Jury j = (Jury)tableView.getSelectionModel().getSelectedItem();
            j.setChecked(!j.isChecked());
            System.out.println("JURY :"+j+" COCHÉ : "+j.isChecked());
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public BorderPane getBorderFils() {
        return borderFils;
    }

    public void setBorderFils(BorderPane borderFils) {
        this.borderFils = borderFils;
    }
    public void etatAffectation(){
        this.candidatsCorrespondantAuFiltre();
        this.listCandidats();
    }

    public void onChangeActionEsh(){
        this.etatAffecter.setValue(null);
        this.tableView.setItems(null);
    }

      // Recuperation des candidats correspondant au filtre
      public void candidatsCorrespondantAuFiltre(){
            
            if(optionsCombo.getValue() == null){
                this.infoBoxError("Veuillez choisir l'option", "Erreur", null);
                this.etatAffecter.setValue(null);
            }else if(comboboxEsh.getValue() == null){
                this.infoBoxError("Veuillez choisir Handicap", "Erreur", null);
                this.etatAffecter.setValue(null);
            }else if(comboboxZone.getValue() == null){
                this.infoBoxError("Veuillez choisir Zone", "Erreur", null);
                this.etatAffecter.setValue(null);
            }else{
                Jury j = (Jury)comboboxJury.getValue() ;
                Option op = (Option)optionsCombo.getValue();
                String eshYN = this.comboboxEsh.getValue().toString();
                String zoneYN = this.comboboxZone.getValue().toString();
                String etat = this.etatAffecter.getValue().toString();
                ObservableList<Object> tmp =  this.convertToFxList(this.listCandidats.stream()
            .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId())
            && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getId()))
            //&& ((CandidatJury)c).getCandidat().getZone().getId().equals(j.getCentreComposition().getZone().getId()))
                .collect(Collectors.toList()));

            if (eshYN.equals("OUI")) {
                    tmp = this.convertToFxList(tmp.stream()
                        .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) 
                            && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getId())
                            && (((CandidatJury)c).getCandidat().getPrescriptionHandicap() != null || ((CandidatJury)c).getCandidat().getPrescriptionHandicap().getId() != 0)
                        )
                        .collect(Collectors.toList()));
                }
            
            if (zoneYN.equals("OUI")) {
                    tmp = this.convertToFxList(tmp.stream()
                        .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) 
                            && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getId())
                            && ((CandidatJury)c).getCandidat().getZone().getId().equals(j.getCentreComposition().getZone().getId())
                            && (((CandidatJury)c).getCandidat().getPrescriptionHandicap() != null || ((CandidatJury)c).getCandidat().getPrescriptionHandicap().getId() != 0)
                        )
                        .collect(Collectors.toList()));
            }

            if (etat.equals("NON affectés uniquement")) {
                System.out.println("No Affectation");
                    tmp = this.convertToFxList(tmp.stream()
                        .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) 
                        && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getId())
                            && ((CandidatJury)c).getJury() == null
                        )
                        .collect(Collectors.toList()));
            }
            if (etat.equals("affectés uniquement")) {
                    tmp = this.convertToFxList(tmp.stream()
                        .filter(c->((CandidatJury)c).getCandidat().getOption().getId().equals(op.getId()) 
                            && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getId())  
                            && ((CandidatJury)c).getJury() != null
                        )
                    .collect(Collectors.toList()));
            }
            this.listCandidatsFiltre = tmp.sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ));
            }
            
    }
}

