package bf.menapln.view.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.itextpdf.layout.element.Paragraph;

import bf.menapln.controller.*;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.reporting.ListeCandidatJury;
import bf.menapln.sigec.App;
import bf.menapln.view.dialog.PdfViewerDialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class CandidatAffecterViewController extends VueController implements Initializable{
    @FXML 
    public TextField rechercheField;
    @FXML 
    public Button bntEnregistrer;
    @FXML
    public Button btnModifier;
    @FXML
    public Button btnAnnuler;
    @FXML
    public Button clean;
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
    public TableColumn<CandidatJury, String> cocher;
    @FXML
    public TableColumn<CandidatJury, String> jury;
    
    @FXML
    public ComboBox<Object> typeExamensCombo; 
    @FXML
    public ComboBox<Object> optionsCombo;
    @FXML
    public ComboBox<Object> filieresCombo;
    @FXML
    public ComboBox<Object> specialiteCombo;
    @FXML
    public ComboBox<Object> comboboxCentreExamen;
    @FXML
    public ComboBox<Object> comboboxJury;
    @FXML
    public ComboBox<Object> comboboxCentreSecondaire;

    @FXML
    public TableColumn<CandidatJury, String> handicap;
    @FXML
    private BorderPane borderFils;
    
    BackendAffectationCandidatController backendAffectationCandidatController;    
    BackendJuryController backendJuryController;
    BackendInscriptionController backendInscriptionController;
    BackendCentreController backendCentreController;


    Localite centreChoisi;
    Localite centreSecondaire;
    ObservableList<Object> listEtabs,listCentresExam,listCentreSecondaires,listTypeExamens,listCandidats,listCandidatsFiltre,listJury;
    List<Objet> listJurys,candidatsSelected = new ArrayList<>();

    public CandidatAffecterViewController() throws SQLException {
        this.backendAffectationCandidatController = new BackendAffectationCandidatController();
        this.backendJuryController = new BackendJuryController();
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendCentreController = new BackendCentreController();
    }

    /**
     * Initializes the controller class.
     */  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.centreChoisi = new Localite();//Pour gérer la recherche sur le comboCentreExamen
        try {
            this.listCentresExam =convertToFxList(this.backendCentreController.getAllSpecial()
            .stream()
            .map(obj-> (obj instanceof Localite)?(Localite) obj : null)
            .filter(localite->localite != null && localite.getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
            .collect(Collectors.toList()));
            this.comboboxCentreExamen.setItems(this.listCentresExam);           
            listCandidats = this.convertToFxList(this.backendAffectationCandidatController.getAllCandidatJury().stream().filter(c->((CandidatJury)c).getJury() != null).collect(Collectors.toList())); 
            this.listCandidatsFiltre = this.convertToFxList(this.backendAffectationCandidatController.getAllCandidatJury().stream().filter(c->((CandidatJury)c).getJury() != null).collect(Collectors.toList()));
            this.listCandidats();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Action au changement du  centre d'examen
    public void centreExamenOnchange(){
        this.centreChoisi = (Localite) comboboxCentreExamen.getValue();
                try {
                    this.listJury = convertToFxList(this.backendJuryController.getAll().stream()
                    .map(obj-> (obj instanceof Jury)?(Jury) obj : null)
                    .filter(jury->jury != null && jury.getCentreExamen().getId().equals(this.centreChoisi.getId()))
                    .collect(Collectors.toList()));
                    this.comboboxJury.setItems(this.listJury);
                    this.candidatsSelected.clear();
                    this.tableView.setItems(null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void juryOnchange(){
                Jury jury = (Jury)this.comboboxJury.getValue();
                this.comboboxCentreSecondaire.setItems(this.convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
                this.listCandidatsFiltre = this.convertToFxList(listCandidats.stream()
                .filter(c->((CandidatJury)c).getJury().getId().equals(jury.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreChoisi.getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();

            } 

    // Action au changement du  centre secondaire
    public void centreSecondaireOnchange(){
        this.centreSecondaire = (Localite) comboboxCentreSecondaire.getValue();
            if (this.comboboxCentreSecondaire.getValue()!=null) {
                Jury jury = (Jury)this.comboboxJury.getValue();
                this.listCandidatsFiltre = this.convertToFxList(listCandidats.stream()
                .filter(c->((CandidatJury)c).getJury().getId().equals(jury.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreSecondaire.getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();
            } 
    }

   

    @FXML
    private void listCandidats(){
        // this.titre.setText("Listes des candidats par ordre alpha. correspondants au filtre ( Effectif : "+listCandidatsFiltre.size()+")");
        jury.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getJury()!=null)?cellData.getValue().getJury().getJuryLibelle():"")); 
        nom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));           
        prenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom())); 
        dateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getDateNaissance().toString()));
        option.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getOption().getOptionLibelle()));
        // concours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getConcours().getConcoursLibelle()));
        sexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getSexe().name()));
        sport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getSport()));
        lieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getLieuNaissance()));
        etablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getEtablissementCandidat().getNomStructure()));
        handicap.setCellValueFactory(cellData -> {
            String natureHandicapLibelle = cellData.getValue().getCandidat().getNatureHandicap().getNatureHandicapLibelle();
            return new SimpleStringProperty((natureHandicapLibelle == null) ? "Non" : "Oui");
        });
        tableView.setItems(listCandidatsFiltre);
    }

    @FXML
    public void affectationCandidatForm(ActionEvent e) throws IOException, SQLException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("affectationCandidat.fxml"));
        AffectationCandidatController affecController = new AffectationCandidatController();
        loader.setController(affecController);
         AnchorPane formInscription = loader.load();
         affecController.setBorderFils(this.getBorderFils());
         this.getBorderFils().setCenter(formInscription); 
   
    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listCandidats();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
    }
    
    @FXML
    public  void cleanRecherche(){
        this.rechercheField.setText("");
        listCandidats();
    }

    public BorderPane getBorderFils() {
        return this.borderFils;
    }
    
    public void setBorderFils(BorderPane borderFils) {
        this.borderFils= borderFils;
    }

    public void ExporterExcel(){
        exportToExcel(this.tableView,"exportCandidatJury.xlsx");
    }

    public void gesTimbre(ListeCandidatJury test) throws SQLException{
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String outputDate = date.format(formatter);
        String [] emploi = new String[2];
        String [] signataire = new String[2];
        emploi[1]="";
        emploi[0]="Directeur Provincial";
        signataire[1]="";
        signataire[0]="";
        test.setFonction(emploi);
        test.setSignataire(signataire);
        test.setTimbre(new Paragraph("Ministère de l'Education Nationale, de l'Alphabétisation et de la Promotion des Langues Nationales \n"
                + " ------- \n"
                + "Direction Régionale de l'Education Post Primaire et Sécondaire de: "+sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getNomLoclite()+" \n"
                + " ------- \n"
                + "Direction Provinciale de l'Education Post Primaire et Sécondaire de: "+sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getNomLoclite()));
               
                test.setDevise(new Paragraph("Burkina Faso \n Unité - Progrès - Justice \n\n\n\n\n\n"
                    + "Fait à "+sessionManager.getUser().getStructure().getLocalite().getNomLoclite()+" le "+outputDate));
    }


    public void exportPdf() throws FileNotFoundException, SQLException{
         List<Objet> listeCandidats;
        try {
            listeCandidats = convertToList(this.listCandidatsFiltre);
            ListeCandidatJury test = new ListeCandidatJury();
            test.setTitle(new Paragraph("Liste général des candidats ".toUpperCase()));
            test.setPath("liste_candidats_inscrits_jury.pdf");
            gesTimbre(test);
            test.setTableHeaderData(new String[]{"Nom","Prénom(s)","Sexe","Date&Lieu de naissance","Sport","Option","Centre","Jury"});
            test.setListe(listeCandidats);
            test.generatePDF();
            PdfViewerDialog e = new PdfViewerDialog(test);
            Optional result = e.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(GenerationPvViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
