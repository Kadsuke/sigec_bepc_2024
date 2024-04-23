package bf.menapln.view.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import bf.menapln.controller.*;
import bf.menapln.entity.Candidat;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Correcteur;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Membre;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.SessionService;
import bf.menapln.sigec.App;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ActeurAffecterViewController extends VueController implements Initializable{
   private String succes = "Opération effectuée avec succès!\n";
    
    @FXML
    public ComboBox<Object> comboboxCentreExamen;
    @FXML
    public ComboBox<Object> comboboxJury;
    @FXML
    public ComboBox<Object> comboboxCentreSecondaire;
    @FXML
    public TextField juryLibelleField;
    @FXML
    public Label titre;
    @FXML
    public Label msgSpecialite;
    @FXML
    public Label msgJury;
    @FXML
    public Label msgCentreExamen;

    @FXML 
    public TextField rechercheField;
    @FXML
    public Button btnModifier;
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
    BackendCentreController backendCentreController;    
    BackendJuryController backendJuryController;

   // Localite centreChoisi;
    Centre centreExamen;
    Centre centreSecondaire;
    ObservableList<Object> listCentresExam,listCentreSecondaires,listActeurs,listActeursFiltre,listJury;
    List<Objet> listJurys,acteursSelected = new ArrayList<>();

    public ActeurAffecterViewController() throws SQLException {
        this.backendAffectationActeurController = new BackendAffectationActeurController();
        this.backendJuryController = new BackendJuryController();
        this.backendCentreController = new BackendCentreController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  super.initialize(url, rb);
       // this.centreChoisi = new Localite();//Pour gérer la recherche sur le comboCentreExamen
        try {
            this.listCentresExam = convertToFxList(this.backendCentreController.getAll().stream()
            .map(obj-> (obj instanceof Centre)?(Centre) obj : null)
            .filter(centre->centre != null && centre.getTypeCentre().getLibelle().equalsIgnoreCase("Principale"))
            .collect(Collectors.toList()));
            this.comboboxCentreExamen.setItems(this.listCentresExam);        
            listActeurs = this.convertToFxList(this.backendAffectationActeurController.getAllMembreJury().stream().filter(m->((Correcteur)m).getJury()!= null).collect(Collectors.toList())); 
            System.out.println(listActeurs);
            this.listActeursFiltre = listActeurs;
            this.listActeurs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // this.comboboxCentreExamen.setEditable(true);
       // this.filterOnComboBox(this.comboboxCentreExamen); 
       // this.centreExamenOnchange();
       // this.juryOnchange();
       // this.centreSecondaireOnchange();
    }

    // Action au changement du  centre d'examen
    public void centreExamenOnchange(){
        this.centreExamen = (Centre) comboboxCentreExamen.getValue();
        //  this.centreChoisi = (Localite)this.listCentresExam.stream().filter(e->((Localite)e).getId().equals(centre.getId())).findFirst().orElse(new Localite());
        try { 
            this.listJury = convertToFxList(this.backendJuryController.getAll().stream()
            .map(obj-> (obj instanceof Jury)?(Jury) obj : null)
            .filter(jury->jury != null && jury.getCentreExamen().getId().equals(centreExamen.getCentre().getId()))
            .collect(Collectors.toList()));
            this.comboboxJury.setItems(this.convertToFxList(this.listJury));
            this.acteursSelected.clear();
            this.tableView.setItems(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }

    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void juryOnchange(){
            if (this.comboboxJury.getValue()!=null) {
                this.comboboxCentreSecondaire.setItems(this.convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
                this.listActeursFiltre = this.convertToFxList(listActeurs.stream()
                .filter(c->((Membre)c).getCandidatPosteJury().getLocaliteCand().getId().equals(this.centreExamen.getCentre().getId()) && ((Membre)c).getJury().getId().equals(((Jury)this.comboboxJury.getValue()).getId()))
                .sorted(Comparator.comparing( c -> ((Membre)c).getCandidatPosteJury().getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((Membre)c).getCandidatPosteJury().getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listActeurs();
                this.msgJury.setText(((Jury)this.comboboxJury.getValue()).toString());                
                // this.msgSpecialite.setText(((Specialite)this.specialiteCombo.getValue()).toString());
                this.msgCentreExamen.setText(((Centre)this.centreExamen).toString());

            }
    }

    // Action au changement du  centre secondaire
    public void centreSecondaireOnchange(){
            if (this.comboboxCentreSecondaire.getValue()!=null) {
                Centre cs = ((Centre)this.comboboxCentreSecondaire.getValue());
                this.listActeursFiltre = this.convertToFxList(listActeurs.stream()
                .filter(c->((Membre)c).getCandidatPosteJury().getLocaliteCand().getId().equals(cs.getCentre().getId()))
                .collect(Collectors.toList()));
                this.listActeurs();
            }
    }
    
    @FXML
    private void listActeurs(){
        this.titre.setText("Liste des acteurs par JURY (Eff: "+this.listActeurs.size()+")");
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
        this.tableView.setItems(listActeursFiltre);
    }

    // Exporter la liste en Excel
    @FXML
    public void ExporterExcel(){
        exportToExcel(this.tableView,"exportMembreJury.xlsx");
        //this.infoBoxSuccess("Liste des acteurs par jury exportée avec succès", "Information", null);
    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listActeurs();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
        // this.titre.setText("Listes des acteurs par ordre de mérite correspondants au filtre ( Effectif : "+this.tableView.getItems().size()+")");
    }
    
    @FXML
    public void affectationActeurForm(ActionEvent e) throws IOException, SQLException{

        FXMLLoader loader = new FXMLLoader(App.class.getResource("affectationActeur.fxml"));
        AffectationActeurController affecController = new AffectationActeurController();
        loader.setController(affecController);
         AnchorPane formInscription = loader.load();
         affecController.setBorderFils(this.getBorderFils());
         this.getBorderFils().setCenter(formInscription); 
    }

    @FXML
    public  void cleanRecherche(){
        this.rechercheField.setText("");
        listActeurs();
    }

    public BorderPane getBorderFils() {
        return this.borderFils;
    }
    
    public void setBorderFils(BorderPane borderFils) {
        this.borderFils= borderFils;
    }
}
