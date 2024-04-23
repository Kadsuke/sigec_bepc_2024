package bf.menapln.view.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.SessionService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

public class AffectationActeurController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!\n";
    
    @FXML
    public ComboBox<Object> comboboxCentreExamen;
    @FXML
    public ComboBox<Object> comboboxJury;
    @FXML
    public ComboBox<Object> comboboxCentreSecondaire;
    @FXML
    public ComboBox<Object> comboboxEtab;
    @FXML
    public ComboBox<Object> typeExamensCombo; 
    @FXML
    public ComboBox<Object> optionsCombo;
    @FXML
    public ComboBox<Object> filieresCombo;
    @FXML
    public ComboBox<Object> specialiteCombo;
    @FXML
    public ComboBox<Object> etatAffecter;
    @FXML
    public ComboBox<Object> posteCombo;
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
    public TableColumn<Membre,Integer> colId;
    @FXML
    public TableColumn<Membre,String> session;
    
    @FXML
    public TableColumn<Membre, String> cocher;
    @FXML
    public TableColumn<Membre, String> jury;
    @FXML
    public TableColumn<Membre,String> colMatricule;
    
    @FXML
    public TableColumn<Membre,String> colNip;

    @FXML
    public TableColumn<Membre,String> colNom;
    
    @FXML
    public TableColumn<Membre,String> colPrenom;
        
    @FXML
    public TableColumn<Membre,String> colSexe;

    @FXML
    public TableColumn<Membre,String> colTelephone;
 
    @FXML
    public TableColumn<Membre,String> colLocalite;
    
    @FXML
    public TableColumn<Membre,String> colStructure;
    
    @FXML
    public TableColumn<Membre,String> colStatut;

    @FXML
    public TableColumn<Membre,String> colPoste;
    @FXML
    public TableColumn<Membre, String> colEpreuves;
    
    @FXML
    private BorderPane borderFils;
    
    BackendAffectationActeurController backendAffectationActeurController;    
    BackendJuryController backendJuryController;
    BackendTypeController backendTypeController;
    BackendCentreController backendCentreController;
    Centre centreExamen;
    Centre centreSecondaire;
    ObservableList<Object> listEtabs,listCentresExam,listCentreSecondaires,listTypeExamens,listActeurs,listActeursFiltre,listPostes,listJury;
    List<Objet> listJurys,acteursSelected = new ArrayList<>();

    public AffectationActeurController() throws SQLException {
        this.backendAffectationActeurController = new BackendAffectationActeurController();
        this.backendJuryController = new BackendJuryController();
        this.backendTypeController = new BackendTypeController();
        this.backendCentreController = new BackendCentreController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //super.initialize(url, rb);
        try {
            this.listCentresExam = convertToFxList(this.backendCentreController.getAll().stream()
            .map(obj-> (obj instanceof Centre)?(Centre) obj : null)
            .filter(centre->centre != null && centre.getTypeCentre().getLibelle().equalsIgnoreCase("Principale"))
            .collect(Collectors.toList()));
            this.comboboxCentreExamen.setItems(this.listCentresExam);             
            listActeurs = this.convertToFxList(this.backendAffectationActeurController.getAllMembreJury()); 
            listPostes = this.convertToFxList(this.backendTypeController.getAll("Poste jury"));
            this.posteCombo.setItems(listPostes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      //  this.comboboxCentreExamen.setEditable(true);
       // this.filterOnComboBox(this.comboboxCentreExamen); 
       // this.centreExamenOnchange();
       // this.juryOnchange();
       // this.posteOnchange();
        // this.centreSecondaireOnchange();
        this.etatAffecter.setItems(FXCollections.observableArrayList("tout le monde","affectés uniquement","NON affectés uniquement"));
        this.etatAffecter.setValue("tout le monde");
        this.etatAffectation();
    }

    // Action au changement du  centre d'examen
    public void centreExamenOnchange(){
        this.centreExamen = (Centre) comboboxCentreExamen.getValue();
        try {
            this.listJury = convertToFxList(this.backendJuryController.getAll().stream()
            .map(obj-> (obj instanceof Jury)?(Jury) obj : null)
            .filter(jury->jury != null && jury.getCentreExamen().getId().equals(centreExamen.getCentre().getId()))
            .collect(Collectors.toList()));
            this.comboboxJury.setItems(this.listJury);
        this.acteursSelected.clear();
        this.tableView.setItems(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void juryOnchange(){
        this.comboboxJury.setOnAction(event->{
            if (this.comboboxJury.getValue()!=null) {
                this.comboboxCentreSecondaire.setItems(this.convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
                this.candidatsCorrespondantAuFiltre();
                this.listActeurs();
                this.msgJury.setText(((Jury)this.comboboxJury.getValue()).toString());                
                this.msgCentreExamen.setText(((Centre)this.centreExamen).toString());

            } 
        });
    }

    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void posteOnchange(){
        this.posteCombo.setOnAction(event->{
            this.candidatsCorrespondantAuFiltre();
            this.listActeurs();
        });
    }

    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void epreuveOnchange(){
        this.posteCombo.setOnAction(event->{
            this.candidatsCorrespondantAuFiltre();
            this.listActeurs();
        });
    }
    

    // Action au changement du  centre secondaire
    public void centreSecondaireOnchange(){

                Centre cs = ((Centre)this.comboboxCentreSecondaire.getValue());
                // Specialite sp = (Specialite)this.specialiteCombo.getValue();
                this.listActeursFiltre = this.convertToFxList(listActeurs.stream()
                .filter(c->((Membre)c).getCandidatPosteJury().getLocaliteCand().getId().equals(cs.getCentre().getId()))
                .collect(Collectors.toList()));
                this.listActeurs();
            } 

    public void etatAffectation(){
        this.etatAffecter.setOnAction(event->{
            this.candidatsCorrespondantAuFiltre();
            this.listActeurs();
        });
        
    }

    // Recuperation des candidats correspondant au filtre
    public void candidatsCorrespondantAuFiltre(){
            String etat = etatAffecter.getValue().toString();
            Type p = (Type)posteCombo.getValue();
            ObservableList<Object> tmp = this.convertToFxList(listActeurs.stream()
                .filter(c->((Membre)c).getCandidatPosteJury().getLocaliteCand().getId().equals(this.centreExamen.getCentre().getId()))
                .collect(Collectors.toList()));
           
            if (p != null) {
                tmp = this.convertToFxList(tmp.stream()
                .filter(c->((Membre)c).getCandidatPosteJury().getPoste().getId().equals(p.getId()))
                .collect(Collectors.toList()));

                if (etat.equals("affectés uniquement")) {
                    tmp = this.convertToFxList(tmp.stream()
                    .filter(c->((Membre)c).getJury() != null)
                    .collect(Collectors.toList()));
                }
                if (etat.equals("NON affectés uniquement")) {
                    tmp = this.convertToFxList(tmp.stream()
                    .filter(c->((Membre)c).getJury() == null)
                    .collect(Collectors.toList()));
                }
            }
            
            this.listActeursFiltre = tmp.sorted(Comparator.comparing( c -> ((Membre)c).getCandidatPosteJury().getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
            .thenComparing( Comparator.comparing( c -> ((Membre)c).getCandidatPosteJury().getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ));
    }

    @FXML
    private void saveAction() throws SQLException, EmptyDataException{
        HashMap formData = new HashMap();
        SessionService sessionService = new SessionService();
        this.acteursSelected.clear();
        for (Object object : this.tableView.getItems()) {
            if (((Objet)object).isChecked()) {
                this.acteursSelected.add((Objet)object);
            }
        }
        try {
            Session session = (Session)sessionService.getActiveSession();
            Jury jut = (Jury)this.comboboxJury.getValue();
          //  System.out.println("Avec Id "+jut.getCentreExamen().getId());
         //   System.out.println("Avec Centre "+jut.getCentreExamen().getCentre().getId());
            formData.put("session", session);
            formData.put("jury", (Jury)this.comboboxJury.getValue());            
            formData.put("listActeurs", this.acteursSelected);
            // System.out.println("FORMDATA :"+formData);
            List<Objet> savedCandidats = backendAffectationActeurController.save(formData);
            this.infoBoxSuccess(this.succes+" \n ("+savedCandidats.size()+" acteurs affectés)", "SUCCES", null);
            this.acteursSelected.clear();
            this.tableView.refresh();
        } catch (SQLException | EmptyDataException ex) {
           Logger.getLogger(AffectationActeurController.class.getName()).log(Level.SEVERE, null, ex);
           // this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    @FXML
    private void listActeurs(){
        this.titre.setText("Listes des acteurs par ordre de mérite correspondants au filtre ( Effectif : "+listActeursFiltre.size()+")");
        jury.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getJury()!=null)?cellData.getValue().getJury().getJuryLibelle():"????")); 
        colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getCandidat().getNom()));
        colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getCandidat().getPrenom()));
        colMatricule.setCellValueFactory(cellData->this.toStringProperty("'"+cellData.getValue().getCandidatPosteJury().getCandidat().getMatricule()));
        colNip.setCellValueFactory(cellData->this.toStringProperty("'"+cellData.getValue().getCandidatPosteJury().getCandidat().getNip()));
        colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getCandidat().getSexe().name()));
        colTelephone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getCandidat().getTelephone()));
        colLocalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getLocaliteCand().getNomLoclite()));
        colStructure.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getStructure().getNomStructure()));
        colStatut.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getEtatCandidature()));
        colPoste.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPoste().getLibelle()));
        colEpreuves.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidatPosteJury().getEpreuves().toString()));
        cocher.setCellValueFactory(
        c -> {
            Membre j = c.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().setValue(j.isChecked());
            // System.out.println("JURY "+j+" EST DEJA COCHER : "+j.isChecked());
            checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
                j.setChecked(new_val);
                // System.out.println("JURY "+j+" COCHER : "+j.isChecked());
            });
            return new SimpleObjectProperty(checkBox);
        });
        tableView.setItems(listActeursFiltre);
    }


    @FXML
    public  void fieldRechercheKeyUp(){
        listActeurs();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
        this.titre.setText("Listes des acteurs par ordre de mérite correspondants au filtre ( Effectif : "+this.tableView.getItems().size()+")");
    }
    

    public BorderPane getBorderFils() {
        return this.borderFils;
    }
    
    public void setBorderFils(BorderPane borderFils) {
        this.borderFils= borderFils;
    }
}
