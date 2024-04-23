package bf.menapln.view.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import bf.menapln.controller.BackendAffectationCandidatController;
import bf.menapln.controller.BackendCentreController;
import bf.menapln.controller.BackendJuryController;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.reporting.ListeCandidatJury;
import bf.menapln.reporting.PDF;
import bf.menapln.service.SessionService;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import com.itextpdf.layout.element.Paragraph;

public class GenerationPvViewController extends VueController implements Initializable{
    private String succes = "Opération effectuée avec succès!\n";
    @FXML 
    public TextField rechercheField;
    @FXML 
    public Button bntEnregistrer;
    @FXML
    public Button btnSansJury;
    @FXML
    public Button clean;
    @FXML
    public Label effectif;
    @FXML
    public Label titre;
    @FXML
    public TableColumn<CandidatJury,String> region;
    @FXML
    public TableColumn<CandidatJury,String> province;
    @FXML
    public TableColumn<CandidatJury,String> numeroPV;
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
    public TableColumn<CandidatJury, String> handicap;
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
    private BorderPane bordeFils;

    @FXML
    public Boolean sansJurychoose = false;

    @FXML
    public VBox pdfContentPane;
    
    BackendAffectationCandidatController backendAffectationCandidatController;    
    BackendJuryController backendJuryController;
    BackendCentreController backendCentreController;
    Centre centreExamen;
    Centre centreSecondaire;
    ObservableList<Object> listEtabs,listCentresExam,listCentreSecondaires,listTypeExamens,listCandidats,listCandidatsFiltre,listCandidatSansJury,listCandidatSansPV,listJury;
    List<Objet> listJurys,candidatsSelected = new ArrayList<>(),listAllCandidats;

    public GenerationPvViewController() throws SQLException {
        this.backendAffectationCandidatController = new BackendAffectationCandidatController();
        this.backendJuryController = new BackendJuryController();
        this.backendCentreController = new BackendCentreController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.listCentresExam = convertToFxList(this.backendCentreController.getAll().stream()
            .map(obj-> (obj instanceof Centre)?(Centre) obj : null)
            .filter(centre->centre != null && centre.getTypeCentre().getLibelle().equalsIgnoreCase("Principale"))
            .collect(Collectors.toList()));
            this.listAllCandidats = this.backendAffectationCandidatController.getAllCandidatJury();
            this.comboboxCentreExamen.setItems(this.listCentresExam);  
            listCandidats = this.convertToFxList(this.listAllCandidats.stream().filter(c->((CandidatJury)c).getJury() != null).collect(Collectors.toList()));
            listCandidatSansPV =  this.convertToFxList(this.listCandidats.stream().filter(c->((CandidatJury)c).getJury() != null
            ).sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getCentreExamen().getParentLocalite().getParentLocalite().getNomLoclite(), String.CASE_INSENSITIVE_ORDER )//region
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getCentreExamen().getParentLocalite().getNomLoclite(), String.CASE_INSENSITIVE_ORDER  ) )//province
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getCentreExamen().getNomLoclite(), String.CASE_INSENSITIVE_ORDER  ) )//centre examen
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getJury().getJuryLibelle(), String.CASE_INSENSITIVE_ORDER  ) )//jury
            //.thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNatureHandicap().getNatureHandicapLibelle(),String.CASE_INSENSITIVE_ORDER)) //handicap  
            .thenComparing(Comparator.comparing(c -> {
                String natureHandicap = ((CandidatJury) c).getCandidat().getNatureHandicap().getNatureHandicapLibelle();
                return natureHandicap != null ? "Oui" : "Non";
            }, String.CASE_INSENSITIVE_ORDER))
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getOption().getOptionLibelle(), String.CASE_INSENSITIVE_ORDER  ) )//option
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER  ) )//nom
            .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))//prenom
            .collect(Collectors.toList()));  
            this.listCandidatsFiltre = listCandidatSansPV;
            this.listCandidats();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.comboboxCentreExamen.setEditable(true);
      //  this.filterOnComboBox(this.comboboxCentreExamen); 
        //this.centreExamenOnchange();
        this.juryOnchange();
        this.centreSecondaireOnchange();
        // this.listCandidatSansJury();
        // this.titre.setText("Gestion des numéros PV (Eff: "+this.listCandidatsFiltre.size()+")");
    }
    
    // générer les PV
    public void genererPV(){
        int i =1;
        for (Object objet : tableView.getItems()) {
            ((CandidatJury)objet).getCandidat().setNumeroPv(i);
            i++;
        }
        tableView.refresh();
    }

    // enregistrer les PV générés
    public void enregistrerPV() throws SQLException, EmptyDataException{
         HashMap formData = new HashMap();
        SessionService sessionService = new SessionService();
        try {
            Session session = (Session)sessionService.getActiveSession();
            formData.put("session", session);
            formData.put("listCandidats", this.tableView.getItems());
            backendAffectationCandidatController.savePV(formData);
            // System.out.println("FORMDATA :"+formData); backendController.save(formData);
            this.infoBoxSuccess(this.succes+" \n PV enregistré avec succès", "SUCCES", null);
        } catch (SQLException ex) {
            this.infoBoxError(ex.getMessage(), "ERREUR", null);
        }
    }
    
    // supprimer les PV enregistrés
    public void supprimerPV() throws SQLException, EmptyDataException{
        HashMap formData = new HashMap();
       SessionService sessionService = new SessionService();
       try {
           Session session = (Session)sessionService.getActiveSession();
           formData.put("session", session);
           backendAffectationCandidatController.deletePV(formData);
           // System.out.println("FORMDATA :"+formData); backendController.save(formData);
           this.infoBoxSuccess(this.succes+" \n PV supprimés avec succès", "SUCCES", null);
           this.listCandidats();
       } catch (SQLException ex) {
           this.infoBoxError(ex.getMessage(), "ERREUR", null);
       }
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
                    this.candidatsSelected.clear();
                    this.tableView.setItems(null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    // Action au changement du JURY (recuperer les candidats du centre choisi par ordre alpha.)
    public void juryOnchange(){
        this.comboboxJury.setOnAction(event->{
            this.sansJurychoose = false;
            if (this.comboboxJury.getValue()!=null) {
                Jury jury = (Jury)this.comboboxJury.getValue();
                this.comboboxCentreSecondaire.setItems(this.convertToFxList(((Jury)this.comboboxJury.getValue()).getCentreSecondaires()));
                // Specialite sp = (Specialite)this.specialiteCombo.getValue();
                this.listCandidatsFiltre = this.convertToFxList(listCandidats.stream()
                .filter(c->((CandidatJury)c).getJury().getId().equals(jury.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreExamen.getCentre().getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();

            } 
            
        });
    }

    // Action au changement du  centre secondaire
    public void centreSecondaireOnchange(){
        this.centreSecondaire = (Centre) comboboxCentreSecondaire.getValue();
            if (this.comboboxCentreSecondaire.getValue()!=null) {
                Jury jury = (Jury)this.comboboxJury.getValue();
                this.listCandidatsFiltre = this.convertToFxList(listCandidats.stream()
                .filter(c->((CandidatJury)c).getJury().getId().equals(jury.getId()) && ((CandidatJury)c).getCandidat().getCentreExamen().getId().equals(this.centreSecondaire.getCentre().getId()))
                .sorted(Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getNom(), String.CASE_INSENSITIVE_ORDER )
                .thenComparing( Comparator.comparing( c -> ((CandidatJury)c).getCandidat().getPrenom(), String.CASE_INSENSITIVE_ORDER  ) ))
                .collect(Collectors.toList()));
                this.listCandidats();
            } 
        }

    @FXML
    private void listCandidats(){
        if (!sansJurychoose) {
            this.titre.setText("Gestion des numéros PV (Eff: "+this.listCandidatsFiltre.size()+")"); 
        }
        region.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getJury().getCentreExamen().getParentLocalite().getParentLocalite().toString()));
        province.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getJury().getCentreExamen().getParentLocalite().toString()));
        jury.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getJury()!=null)?cellData.getValue().getJury().getJuryLibelle():"")); 
        centre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getCentreExamen().toString()));
        nom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getNom()));           
        prenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getPrenom())); 
        numeroPV.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getCandidat().getNumeroPv() != null)?cellData.getValue().getCandidat().getNumeroPv().toString():null));
        //handicap.setCellValueFactory(cellData->this.toStringProperty((cellData.getValue().getCandidat().getNatureHandicap().getNatureHandicapLibelle() == null) ? "Non": "Oui"));
        handicap.setCellValueFactory(cellData -> {
            String natureHandicapLibelle = cellData.getValue().getCandidat().getNatureHandicap().getNatureHandicapLibelle();
            return new SimpleStringProperty((natureHandicapLibelle == null) ? "Non" : "Oui");
        });
        option.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCandidat().getOption().toString()));
        tableView.setItems(listCandidatsFiltre);
    }

    // Liste des candidats sans Jury
    public void listCandidatSansJury(){
        this.btnSansJury.setOnAction(e->{
            this.listCandidatsFiltre = this.convertToFxList(this.listAllCandidats.stream().filter(c->((CandidatJury)c).getJury() == null).collect(Collectors.toList())); 
            this.listCandidats();
            this.titre.setText("\t \t \t Gestion des numéros PV \n Liste des candidats NON affecté dans un JURY (Eff: "+this.listCandidatsFiltre.size()+")");
            sansJurychoose = true;
        });
    }

    // Exporter la liste en Excel
    @FXML
    public void ExporterExcel(){
        exportToExcel(this.tableView,"exportCandidatJuryPV.xlsx");
    }

    @FXML
    public  void fieldRechercheKeyUp(){
        listCandidats();
        this.filtrerTableView(this.tableView,this.rechercheField.getText());
        if (!sansJurychoose) {
            this.titre.setText("Gestion des numéros PV (Eff: "+this.tableView.getItems().size()+")");
        }
    }
    
    @FXML
    public  void cleanRecherche(){
        this.rechercheField.setText("");
        listCandidats();
    }

    public BorderPane getBordeFils() {
        return this.bordeFils;
    }
    
    public void setBordeFils(BorderPane bordeFils) {
        this.bordeFils= bordeFils;
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
            test.setPath("liste_candidats_inscrits.pdf");
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
