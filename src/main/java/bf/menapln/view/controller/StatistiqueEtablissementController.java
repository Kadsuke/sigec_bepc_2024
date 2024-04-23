/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.reporting.PDFExporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;



/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class StatistiqueEtablissementController extends VueController implements Initializable {
    @FXML 
    private ComboBox<String> comboboxTypeStat;
    
    @FXML
    private Button enregistrerBtn;
    
    @FXML
    private Button imprimerBtn;
    
    @FXML
    private TableView tableView;
    
    @FXML
    private TableView tableViewDeux;
    
    @FXML
    private TableView tableViewTrois;
    
    @FXML
    private TableView tableViewListe;
    
    @FXML
    private TableView tableViewClasse;
    
    @FXML
    private TableView tableViewConcours;
    
    @FXML
    private TableView tableViewOption;
    
    ObservableList<String> listSortie = FXCollections.observableArrayList("Liste Générale",
        "Liste Par Classe","Liste Par Concours","Liste Par Option");
    
    public StatistiqueEtablissementController() throws SQLException {
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendGroupePedagogiqueController = new BackendGroupePedagogiqueController();
        this.backendTypeController = new BackendTypeController();
        this.backendOptionController = new BackendOptionController();
        //this.pdfExporter = new PDFExporter();

    }
    
        BackendInscriptionController backendInscriptionController;
        BackendGroupePedagogiqueController backendGroupePedagogiqueController;
        BackendTypeController backendTypeController;
        BackendOptionController backendOptionController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxTypeStat.setItems(listSortie);
        //imprimerBtn.setVisible(false);
        enregistrerBtn.setDisable(true);
        tableauStatistique();
    }
    
    public void afficherApercuPDF() {
        // Remplacez "chemin/vers/votre/fichier.pdf" par le chemin réel de votre fichier PDF
        String cheminPDF = "exportTest.pdf";
    }
    
    public void onChangeTypeStruct(){
        enregistrerBtn.setDisable(false);
    }
    public void ImprimerPDF() throws IOException, FileNotFoundException, SQLException {
        String stat = comboboxTypeStat.getValue();
            if (stat != null && !stat.isEmpty()) {
                switch (stat) {
                case "Liste Générale":
                        exportPdfListeGenerale();
                break;
                case "Liste Par Classe":
                        exportPdfListeParClasse();
                break;
                case "Liste Par Concours":
                        exportPdfListeParConcours();
                break;
                case "Liste Par Option":
                        exportPdfListeParOption();
                break;
                      
                default:
                    System.out.println("Liste non prise en charge");
                }
        }
    }
    
    // Liste Generale
    public void exportPdfListeGenerale() throws FileNotFoundException, IOException, SQLException{
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tableViewListe = new TableView();
            ObservableList<Object> data = convertToFxList(backendInscriptionController.getAll().stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList()));
            
            TableColumn<Object, Integer> colId = new TableColumn<>("N°Ordre");
            colId.setCellValueFactory(cellData -> this.toIntegerProperty(data.indexOf(cellData.getValue()) + 1).asObject());
            colId.setPrefWidth(10);
            
            TableColumn<Candidat, String> colNom = new TableColumn<>("Nom");
            colNom.setCellValueFactory(cellData -> this.toStringProperty(cellData.getValue().getNom()));

            TableColumn<Candidat, String> colPrenom = new TableColumn<>("Prénom");
            colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
            
            TableColumn<Candidat, String> colSexe = new TableColumn<>("Sexe");
            colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
            
            TableColumn<Candidat, String> colDateNaissance = new TableColumn<>("Date de Naissance");
            colDateNaissance.setCellValueFactory(cellData->{
                LocalDate date = cellData.getValue().getDateNaissance();
                String typeDateNaissance = cellData.getValue().getTypeDateNaissance();

                if (date != null) {
                    if ("en".equalsIgnoreCase(typeDateNaissance) || "vers".equalsIgnoreCase(typeDateNaissance)) {
                        // Display only the year
                        return toStringProperty(String.valueOf(date.getYear()));
                    } else {
                        // Display the full date
                        String formattedDate = DATE_FORMATTER.format(date);
                        return toStringProperty(formattedDate);
                    }
                } else {
                    return toStringProperty(""); // Handle the case when the date is null
                }
            });
            
            TableColumn<Candidat, String> colLieuNaissance = new TableColumn<>("Lieu de Naissance");
            colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
            
            TableColumn<Candidat, String> colPaysNaissance = new TableColumn<>("Pays de Naissance");
            colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
            
            TableColumn<Candidat, String> colNationalite = new TableColumn<>("Nationalité");
            colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
            
            TableColumn<Candidat, String> colSport = new TableColumn<>("Sport");
            colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
            
            TableColumn<Candidat, String> colConcours = new TableColumn<>("Concours");
            colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
            
            TableColumn<Candidat, String> colOption = new TableColumn<>("Option");
            colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
            
            TableColumn<Candidat, String> colSignature = new TableColumn<>("Signature");
            
            tableViewListe.getColumns().addAll(colId,colNom,colPrenom,colSexe,colDateNaissance,
                    colLieuNaissance,colPaysNaissance,colNationalite,colSport,colConcours,colOption,colSignature);
            tableViewListe.setItems(data);
            tableViewListe.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            
            
            
            String dossierPath = "document";
            String fichierPath = "document/liste_generale.docx";
            
            File dossier = new File(dossierPath);
            if (!dossier.exists()) {
                dossier.mkdirs(); // Créez le dossier et ses parents si nécessaire
            }
            
            XWPFDocument document = new XWPFDocument();

            // Exportez les données de la première TableView
            exportTableListeToWord(document, tableViewListe, "Liste Générale");

            FileOutputStream out = new FileOutputStream(fichierPath);


            // Ajoutez un saut de page
            document.createParagraph().createRun().addBreak(BreakType.PAGE);

            // Enregistrez le document Word
            document.write(out);
            infoBoxSuccess("Document Word exporté avec succès.", "Success", null);   
            
    }
    
    // Liste Par classe    
    public void exportPdfListeParClasse(){
        try {
            DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
           List<Objet> listGP = backendGroupePedagogiqueController.getAllByEtab(sessionManager.getUser().getStructure().getId().toString());
           List<Objet> data = backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
           
            for(Objet list : listGP){
                GroupePedagogique gp = (GroupePedagogique)list;
                List<Objet> listFiltrer = data.stream()
                        .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getGroupePedagogique().getId().equals(gp.getId()))
                        .collect(Collectors.toList());
                
                ObservableList<Object> gpData = convertToFxList(listFiltrer);
                //FilteredList<Object> filteredList = new FilteredList<>(data, obj -> obj.toString().toLowerCase().contains("yourFilterCriteria"));
                tableViewClasse = new TableView<>();

                TableColumn<Object, Integer> colId = new TableColumn<>("N°Ordre");
                colId.setCellValueFactory(cellData -> this.toIntegerProperty(data.indexOf(cellData.getValue()) + 1).asObject());
                colId.setPrefWidth(10);

                TableColumn<Candidat, String> colNom = new TableColumn<>("Nom");
                colNom.setCellValueFactory(cellData -> this.toStringProperty(cellData.getValue().getNom()));

                TableColumn<Candidat, String> colPrenom = new TableColumn<>("Prénom");
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));

                TableColumn<Candidat, String> colSexe = new TableColumn<>("Sexe");
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));

                TableColumn<Candidat, String> colDateNaissance = new TableColumn<>("Date de Naissance");
                colDateNaissance.setCellValueFactory(cellData->{
                LocalDate date = cellData.getValue().getDateNaissance();
                String typeDateNaissance = cellData.getValue().getTypeDateNaissance();

                if (date != null) {
                    if ("en".equalsIgnoreCase(typeDateNaissance) || "vers".equalsIgnoreCase(typeDateNaissance)) {
                        // Display only the year
                        return toStringProperty(String.valueOf(date.getYear()));
                    } else {
                        // Display the full date
                        String formattedDate = DATE_FORMATTER.format(date);
                        return toStringProperty(formattedDate);
                    }
                } else {
                    return toStringProperty(""); // Handle the case when the date is null
                }
            });
                TableColumn<Candidat, String> colLieuNaissance = new TableColumn<>("Lieu de Naissance");
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));

                TableColumn<Candidat, String> colPaysNaissance = new TableColumn<>("Pays de Naissance");
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));

                TableColumn<Candidat, String> colNationalite = new TableColumn<>("Nationalité");
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));

                TableColumn<Candidat, String> colSport = new TableColumn<>("Sport");
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));

                TableColumn<Candidat, String> colConcours = new TableColumn<>("Concours");
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));

                TableColumn<Candidat, String> colOption = new TableColumn<>("Option");
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));

                TableColumn<Candidat, String> colPrenomPere = new TableColumn<>("Prénom(s Père)");
                colPrenomPere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenomPere()));

                TableColumn<Candidat, String> colNomMere = new TableColumn<>("Nom Mère");
                colNomMere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNomMere()));

                TableColumn<Candidat, String> colPrenomMere = new TableColumn<>("Prénom(s) Mère");
                colPrenomMere.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenomMere()));

                TableColumn<Candidat, String> colContact = new TableColumn<>("Contact");
                colContact.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                
                TableColumn<Candidat, String> colSignature = new TableColumn<>("Signature");

                tableViewClasse.getColumns().addAll(colId,colNom,colPrenom,colSexe,colDateNaissance,
                        colLieuNaissance,colPaysNaissance,colNationalite,colSport,colConcours,colOption,colPrenomPere,colNomMere,
                        colPrenomMere,colContact,colSignature);
                tableViewClasse.setItems(gpData);
                tableViewClasse.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
                
                String dossierPath = "document";
                String fichierPath = "document/liste_gp";

                File dossier = new File(dossierPath);
                if (!dossier.exists()) {
                    dossier.mkdirs(); // Créez le dossier et ses parents si nécessaire
                }
                
                
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(fichierPath+gp.getGroupePedagogiqueLibelle()+".docx");
                // Exportez les données de la première TableView
                exportTableListeClasseToWord(document, tableViewClasse, "Liste Générale "+gp.getGroupePedagogiqueLibelle());

                // Ajoutez un saut de page
                document.createParagraph().createRun().addBreak(BreakType.PAGE);

                // Enregistrez le document Word
                document.write(out);
                
            }
            infoBoxSuccess("Importer avec succès", "Success", null);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
    // Liste Par classe
    public void exportPdfListeParConcours(){
        try {
            DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            List<Objet> listConcours = backendTypeController.getAll("Type Concours");
            List<Objet> data = backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
            for(Objet list : listConcours){
                Type concours = (Type)list;
                List<Objet> listFiltrer = data.stream()
                        .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getConcoursRatache().getId().equals(concours.getId()))
                        .collect(Collectors.toList());
                
                ObservableList<Object> gpData = convertToFxList(listFiltrer);
                //FilteredList<Object> filteredList = new FilteredList<>(data, obj -> obj.toString().toLowerCase().contains("yourFilterCriteria"));
                tableViewConcours = new TableView<>();

                TableColumn<Object, Integer> colId = new TableColumn<>("N°Ordre");
                colId.setCellValueFactory(cellData -> this.toIntegerProperty(data.indexOf(cellData.getValue()) + 1).asObject());
                colId.setPrefWidth(10);

                TableColumn<Candidat, String> colNom = new TableColumn<>("Nom");
                colNom.setCellValueFactory(cellData -> this.toStringProperty(cellData.getValue().getNom()));

                TableColumn<Candidat, String> colPrenom = new TableColumn<>("Prénom");
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));

                TableColumn<Candidat, String> colSexe = new TableColumn<>("Sexe");
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));

                TableColumn<Candidat, String> colDateNaissance = new TableColumn<>("Date de Naissance");
                colDateNaissance.setCellValueFactory(cellData->{
                LocalDate date = cellData.getValue().getDateNaissance();
                String typeDateNaissance = cellData.getValue().getTypeDateNaissance();

                if (date != null) {
                    if ("en".equalsIgnoreCase(typeDateNaissance) || "vers".equalsIgnoreCase(typeDateNaissance)) {
                        // Display only the year
                        return toStringProperty(String.valueOf(date.getYear()));
                    } else {
                        // Display the full date
                        String formattedDate = DATE_FORMATTER.format(date);
                        return toStringProperty(formattedDate);
                    }
                } else {
                    return toStringProperty(""); // Handle the case when the date is null
                }
            });

                TableColumn<Candidat, String> colLieuNaissance = new TableColumn<>("Lieu de Naissance");
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));

                TableColumn<Candidat, String> colPaysNaissance = new TableColumn<>("Pays de Naissance");
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));

                TableColumn<Candidat, String> colNationalite = new TableColumn<>("Nationalité");
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));

                TableColumn<Candidat, String> colSport = new TableColumn<>("Sport");
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));

                TableColumn<Candidat, String> colOption = new TableColumn<>("Option");
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));

                TableColumn<Candidat, String> colSignature = new TableColumn<>("Signature");

                tableViewConcours.getColumns().addAll(colId,colNom,colPrenom,colSexe,colDateNaissance,
                        colLieuNaissance,colPaysNaissance,colNationalite,colSport,colOption,colSignature);
                tableViewConcours.setItems(gpData);
                tableViewConcours.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
                String dossierPath = "document";
                String fichierPath = "document/liste_concours";

                File dossier = new File(dossierPath);
                if (!dossier.exists()) {
                    dossier.mkdirs(); // Créez le dossier et ses parents si nécessaire
                }
                
                
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(fichierPath+concours.getLibelle()+".docx");
                // Exportez les données de la première TableView
                exportTableListeConcoursToWord(document, tableViewConcours, "Liste Générale "+concours.getLibelle());

                // Ajoutez un saut de page
                document.createParagraph().createRun().addBreak(BreakType.PAGE);

                // Enregistrez le document Word
                document.write(out);
                
            }
            infoBoxSuccess("Importer avec succès", "Success", null);
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
    // Liste Par Option
    public void exportPdfListeParOption(){
        try {
            DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
           List<Objet> listOption = backendOptionController.getAll();
           List<Objet> data = backendInscriptionController.getAll().stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
           
            for(Objet list : listOption){
                Option opt = (Option)list;
                List<Objet> listFiltrer = data.stream()
                        .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getOption().getId().equals(opt.getId()))
                        .collect(Collectors.toList());
                
                ObservableList<Object> gpData = convertToFxList(listFiltrer);
                //FilteredList<Object> filteredList = new FilteredList<>(data, obj -> obj.toString().toLowerCase().contains("yourFilterCriteria"));
                tableViewOption = new TableView<>();

                TableColumn<Object, Integer> colId = new TableColumn<>("N°Ordre");
                colId.setCellValueFactory(cellData -> this.toIntegerProperty(data.indexOf(cellData.getValue()) + 1).asObject());
                colId.setPrefWidth(10);

                TableColumn<Candidat, String> colNom = new TableColumn<>("Nom");
                colNom.setCellValueFactory(cellData -> this.toStringProperty(cellData.getValue().getNom()));

                TableColumn<Candidat, String> colPrenom = new TableColumn<>("Prénom");
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));

                TableColumn<Candidat, String> colSexe = new TableColumn<>("Sexe");
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));

                TableColumn<Candidat, String> colDateNaissance = new TableColumn<>("Date de Naissance");
                colDateNaissance.setCellValueFactory(cellData->{
                LocalDate date = cellData.getValue().getDateNaissance();
                String typeDateNaissance = cellData.getValue().getTypeDateNaissance();

                if (date != null) {
                    if ("en".equalsIgnoreCase(typeDateNaissance) || "vers".equalsIgnoreCase(typeDateNaissance)) {
                        // Display only the year
                        return toStringProperty(String.valueOf(date.getYear()));
                    } else {
                        // Display the full date
                        String formattedDate = DATE_FORMATTER.format(date);
                        return toStringProperty(formattedDate);
                    }
                } else {
                    return toStringProperty(""); // Handle the case when the date is null
                }
            });

                TableColumn<Candidat, String> colLieuNaissance = new TableColumn<>("Lieu de Naissance");
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));

                TableColumn<Candidat, String> colPaysNaissance = new TableColumn<>("Pays de Naissance");
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));

                TableColumn<Candidat, String> colNationalite = new TableColumn<>("Nationalité");
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));

                TableColumn<Candidat, String> colSport = new TableColumn<>("Sport");
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));

                TableColumn<Candidat, String> colConcours = new TableColumn<>("Concours");
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));


                TableColumn<Candidat, String> colSignature = new TableColumn<>("Signature");

                tableViewOption.getColumns().addAll(colId,colNom,colPrenom,colSexe,colDateNaissance,
                        colLieuNaissance,colPaysNaissance,colNationalite,colSport,colConcours,colSignature);
                tableViewOption.setItems(gpData);
                tableViewOption.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
                
                String dossierPath = "document";
                String fichierPath = "document/liste_option";

                File dossier = new File(dossierPath);
                if (!dossier.exists()) {
                    dossier.mkdirs(); // Créez le dossier et ses parents si nécessaire
                }
                
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(fichierPath+opt.getOptionLibelle()+".docx");
                // Exportez les données de la première TableView
                exportTableListeOptionToWord(document, tableViewOption, "Liste Générale "+opt.getOptionLibelle());

                // Ajoutez un saut de page
                document.createParagraph().createRun().addBreak(BreakType.PAGE);

                // Enregistrez le document Word
                document.write(out);
                
            }
            infoBoxSuccess("Importer avec succès", "Success", null); 
            
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(), "Erreur", null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Stat résumé
    public void exportPdfStatGenerale(){

        try {
            //TableView<DataObject> tableView = new TableView<>();

            //Tableau 1
            TableColumn<DataObject, String> colOption = new TableColumn<>("Option");
            TableColumn<DataObject, Long> colApte = new TableColumn<DataObject,Long>("Aptes");
            TableColumn<DataObject, Long> colApteGarcon = new TableColumn<DataObject,Long>("Garçons");
            TableColumn<DataObject, Long> colApteFilles = new TableColumn<DataObject,Long>("Filles");
            TableColumn<DataObject, Long> colApteTotal = new TableColumn<DataObject,Long>("Total");
            colApte.getColumns().addAll(colApteGarcon, colApteFilles, colApteTotal);
            
            TableColumn<DataObject, Long> colInapte = new TableColumn<DataObject,Long>("Inaptes");
            TableColumn<DataObject, Long> colInapteGarcon = new TableColumn<DataObject,Long>("Garçons");
            TableColumn<DataObject, Long> colInapteFilles = new TableColumn<DataObject,Long>("Filles");
            TableColumn<DataObject, Long> colInapteTotal = new TableColumn<DataObject,Long>("Total");
            colInapte.getColumns().addAll(colInapteGarcon, colInapteFilles, colInapteTotal);

            TableColumn<DataObject, Long> colTotal = new TableColumn<DataObject,Long>("Total");
            TableColumn<DataObject, Long> colTotalGarcon = new TableColumn<DataObject,Long>("Garçons");
            TableColumn<DataObject, Long> colTotalFilles = new TableColumn<DataObject,Long>("Filles");
            TableColumn<DataObject, Long> colTotalTotal = new TableColumn<DataObject,Long>("Total");

            colTotal.getColumns().addAll(colTotalGarcon, colTotalFilles, colTotalTotal);

            colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption()));
            
            colApteGarcon.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getApteGarcon()).asObject());
            colApteFilles.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getApteFilles()).asObject());
            colApteTotal.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getApteTotal()).asObject());

            colInapteGarcon.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getInapteGarcon()).asObject());
            colInapteFilles.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getInapteFilles()).asObject());
            colInapteTotal.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getInapteTotal()).asObject());

            colTotalGarcon.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getTotalGarcon()).asObject());
            colTotalFilles.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getTotalFilles()).asObject());
            colTotalTotal.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getTotalTotal()).asObject());

            tableView.getColumns().addAll(colOption, colApte, colInapte, colTotal);
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            
            // Ajouter des données
            ObservableList<DataObject> data = FXCollections.observableArrayList();
            List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
            
            /**
             * Section Apte
             */
            // APTE GARCON
            long nombreApteGarconPC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreApteGarconPCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreApteGarconPCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreApteGarconPCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreApteGarconPCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreApteGarconTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            
            // APTE FILLE
            long nombreApteFillePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreApteFillePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreApteFillePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreApteFillePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreApteFillePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreApteFilleTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            
            // APTE FILLE
            long nombreAptePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC"))
                        .count();
            long nombreAptePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL"))
                        .count();
            long nombreAptePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR"))
                        .count();
            long nombreAptePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN"))
                        .count();
            long nombreAptePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA"))
                        .count();
            long nombreApteTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("apte"))
                        .count();
            
            
            /**
             * Section Inapte
             */
            // InaaPTE GARCON
            long nombreInapteGarconPC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreInapteGarconPCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreInapteGarconPCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreInapteGarconPCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreInapteGarconPCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreInapteGarconTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            
            // APTE FILLE
            long nombreInapteFillePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreInapteFillePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreInapteFillePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreInapteFillePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreInapteFillePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreInapteFilleTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            
            // APTE FILLE
            long nombreInaptePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC"))
                        .count();
            long nombreInaptePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL"))
                        .count();
            long nombreInaptePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR"))
                        .count();
            long nombreInaptePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN"))
                        .count();
            long nombreInaptePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte") && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA"))
                        .count();
            long nombreInapteTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSport().equalsIgnoreCase("inapte"))
                        .count();
            
            /**
             * Section Total
             */
            // GARCON
            long nombreGarconPC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconPCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconPCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconPCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconPCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            // FILLE
            long nombreFillePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFillePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFillePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFillePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFillePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFilleTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            // TOTAL
            long nombrePC = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PC"))
                        .count();
            long nombrePCAL = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAL"))
                        .count();
            long nombrePCAR = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCAR"))
                        .count();
            long nombrePCESP = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCLATIN"))
                        .count();
            long nombrePCITA = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getOption().getOptionLibelle().equalsIgnoreCase("PCITA"))
                        .count();
            long nombreTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null)
                        .count();
            
            
            
            String[] options = {"PC", "PCAL", "PCAR", "PCLATIN", "PCITA","TOTAL"};
            //Apte
            Long[] apteGarcon = {nombreApteGarconPC, nombreApteGarconPCAL, nombreApteGarconPCAR, nombreApteGarconPCESP, nombreApteGarconPCITA,nombreApteGarconTotal};
            Long[] apteFilles = {nombreApteFillePC, nombreApteFillePCAL, nombreApteFillePCAR, nombreApteFillePCESP, nombreApteFillePCITA,nombreApteFilleTotal};
            Long[] apteTotal = {nombreAptePC, nombreAptePCAL, nombreAptePCAR, nombreAptePCESP, nombreAptePCITA,nombreApteTotal};
            //Inapte
            Long[] inapteGarcon = {nombreInapteGarconPC, nombreInapteGarconPCAL, nombreInapteGarconPCAR, nombreInapteGarconPCESP, nombreInapteGarconPCITA,nombreInapteGarconTotal};
            Long[] inapteFilles = {nombreInapteFillePC, nombreInapteFillePCAL, nombreInapteFillePCAR, nombreInapteFillePCESP, nombreInapteFillePCITA,nombreInapteFilleTotal};
            Long[] inapteTotal = {nombreInaptePC, nombreInaptePCAL, nombreInaptePCAR, nombreInaptePCESP, nombreInaptePCITA,nombreInapteTotal};
            //Total
            Long[] totalGarcon = {nombreGarconPC, nombreGarconPCAL, nombreGarconPCAR, nombreGarconPCESP, nombreGarconPCITA,nombreGarconTotal};
            Long[] totalFilles = {nombreFillePC, nombreFillePCAL, nombreFillePCAR, nombreFillePCESP, nombreFillePCITA,nombreFilleTotal};
            Long[] totalTotal = {nombrePC, nombrePCAL, nombrePCAR, nombrePCESP, nombrePCITA,nombreTotal};
            
            for (int i = 0; i < options.length; i++) {
                data.add(new DataObject(options[i], apteGarcon[i], apteFilles[i], apteTotal[i], inapteGarcon[i], inapteFilles[i], inapteTotal[i], totalGarcon[i], totalFilles[i], totalTotal[i]));
            }


            tableView.setItems(data);
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }      
  }
    
    // Stat résumé
    public void exportPdfStatGeneraleConcours(){

        try {            
            TableColumn<DataObject, String> colConcours = new TableColumn<>("Concours");
            TableColumn<DataObject, Long> colConcoursGarcon = new TableColumn<>("Garçons");
            TableColumn<DataObject, Long> colConcoursFilles = new TableColumn<>("Filles");
            TableColumn<DataObject, Long> colConcoursTotal = new TableColumn<>("Total");

            colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcours()));
            
            colConcoursGarcon.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getConcoursGarcon()).asObject());
            colConcoursFilles.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getConcoursFilles()).asObject());
            colConcoursTotal.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getConcoursTotal()).asObject());

            tableViewDeux.getColumns().addAll(colConcours, colConcoursGarcon, colConcoursFilles, colConcoursTotal);
            tableViewDeux.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            // Ajouter des données
            ObservableList<DataObject> data = FXCollections.observableArrayList();
            List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
            
            
            // TOTAL
            long nombrePremiereBep = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Prémière année BEP"))
                        .count();
            long nombreEntreSeconde = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Entrée en Seconde"))
                        .count();
            long nombreBepc = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("BEPC SEUL"))
                        .count();

            long nombreTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null)
                        .count();
            
            //Concours
            //Fille
            long nombreFilleEntreSeconde = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Entrée en Seconde")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFilleBep = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Prémière année BEP")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFilleBepc = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("BEPC SEUL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
   
           long nombreFille = dataCandidat.stream()
                .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                .filter(candidat->candidat != null && 
                        candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                .count();
            
            // Garçon
            long nombreGarconEntreSeconde = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Entrée en Seconde")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconBep = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Prémière année BEP")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            long nombreGarconBepc = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("BEPC SEUL")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
          long nombreGarcon = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null &&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
        
        
            
            String[] concours = {"Entrée en Seconde", "Prémière année BEP", "BEPC SEUL","TOTAL"};
            
            //Concours
            Long[] totalGarconConcours = {nombreGarconEntreSeconde, nombreGarconBep, nombreGarconBepc,nombreGarcon};
            Long[] totalFillesConcours = {nombreFilleEntreSeconde, nombreFilleBep, nombreFilleBepc,nombreFille};
            Long[] totalTotalConcours = {nombreEntreSeconde, nombrePremiereBep, nombreBepc,nombreTotal};

             for (int i = 0; i < concours.length; i++) {
                data.add(new DataObject(concours[i], totalGarconConcours[i], totalFillesConcours[i], totalTotalConcours[i]));
            }

            tableViewDeux.setItems(data);
            tableViewDeux.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
          //  exportTableViewToPdf(tableView, "tableview_snapshot.pdf");
          //  infoBoxSuccess("Importer avec succès", "Success", null); 
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  }
    

     // Stat résumé
    public void exportPdfStatGeneraleSituation(){

        try {
             // Tableau 3
            
            TableColumn<DataObject, String> colSituation = new TableColumn<>("Situation");
            TableColumn<DataObject, Long> colSituationGarcon = new TableColumn<>("Garçons");
            TableColumn<DataObject, Long> colSituationFilles = new TableColumn<>("Filles");
            TableColumn<DataObject, Long> colSituationTotal = new TableColumn<>("Total");


            colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSituation()));
            colSituationGarcon.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getSituationGarcon()).asObject());
            colSituationFilles.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getSituationFilles()).asObject());
            colSituationTotal.setCellValueFactory(cellData->this.toLongProperty(cellData.getValue().getSituationTotal()).asObject());

            tableViewTrois.getColumns().addAll(colSituation, colSituationGarcon, colSituationFilles, colSituationTotal);
            tableViewTrois.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            // Ajouter des données
            ObservableList<DataObject> data = FXCollections.observableArrayList();
            List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList());
            
            // TOTAL
            long nombreNormal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Normal"))
                        .count();
            long nombreEdi = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("EDI"))
                        .count();
            long nombreRefugie = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Réfugié"))
                        .count();

            long nombreTotal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null)
                        .count();

            //Situation
            //Fille
            long nombreFilleNormal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Normal")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
            long nombreFilleRefugie = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Réfugié")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
        long nombreFilleEDI = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                        candidat.getTypeSituation().getLibelle().equalsIgnoreCase("EDI")&&
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
        long nombreFille = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSexe().name().equalsIgnoreCase("Feminin"))
                        .count();
        // Garcon
        long nombreGarconNormal = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Normal")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
        long nombreGarconRefugie = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("Réfugié")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
        long nombreGarconEDI = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getTypeSituation().getLibelle().equalsIgnoreCase("EDI")&&
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
        
        long nombreGarcon = dataCandidat.stream()
                    .map(obj->(obj instanceof Candidat) ? (Candidat) obj : null)
                        .filter(candidat->candidat != null && 
                                candidat.getSexe().name().equalsIgnoreCase("Masculin"))
                        .count();
            
            String[] situation = {"Normal","EDI", "Réfugié","TOTAL"};
        
            //Situation
            Long[] totalGarconSituation = {nombreGarconNormal, nombreGarconEDI, nombreGarconRefugie,nombreGarcon};
            Long[] totalFillesSituation = {nombreFilleNormal, nombreFilleEDI, nombreFilleRefugie, nombreFille};
            Long[] totalTotalSituation = {nombreNormal, nombreEdi, nombreRefugie, nombreTotal};
            
            for (int i = 0; i < situation.length; i++) {
                data.add(new DataObject(totalGarconSituation[i], situation[i], totalFillesSituation[i], totalTotalSituation[i]));
            }

            
            tableViewTrois.setItems(data);
            tableViewTrois.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
           // exportTableViewToWordControl(tableViewTrois, "tableview_export_deux.docx");
           // infoBoxSuccess("Importer avec succès", "Success", null); 
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueEtablissementController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  }
    
    public void exportTableViewToWord(TableView<DataObject> tableView, String fileName) {
        XWPFDocument document = new XWPFDocument();

        // Créer un paragraphe pour le titre
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("TableView Export");

        // Ajouter une ligne vide
        document.createParagraph();

        // Créer un tableau pour les données du TableView
        XWPFTable table = document.createTable();

        // Ajouter les en-têtes de colonne au tableau
        XWPFTableRow headerRow = table.getRow(0);
        if (headerRow == null) {
            headerRow = table.createRow();
        }
        
        while (headerRow.getTableCells().size() < 4) {
            headerRow.createCell();
        }
        headerRow.getCell(0).setText("Situation");
        headerRow.getCell(1).setText("Garçons");
        headerRow.getCell(2).setText("Filles");
        headerRow.getCell(3).setText("Total");

        // Ajouter les données au tableau
        ObservableList<DataObject> items = tableView.getItems();
        for (int i = 0; i < items.size(); i++) {
            DataObject dataObject = items.get(i);
            XWPFTableRow tableRow = table.createRow();

            tableRow.getCell(0).setText(dataObject.getSituation());
            tableRow.getCell(1).setText(String.valueOf(dataObject.getSituationGarcon()));
            tableRow.getCell(2).setText(String.valueOf(dataObject.getSituationFilles()));
            tableRow.getCell(3).setText(String.valueOf(dataObject.getSituationTotal()));
        }

        // Enregistrer le document Word
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            document.write(out);
            System.out.println("TableView exporté avec succès en tant que document Word : " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation du TableView en tant que document Word : " + e.getMessage());
        }
    }
    
    public class DataObject {
        private String situation;
        private Long situationGarcon;
        private Long situationFilles;
        private Long situationTotal;
        
        private String concours;
        private Long concoursGarcon;
        private Long concoursFilles;
        private Long concoursTotal;
        
        private String option;
        private Long apteGarcon;
        private Long apteFilles;
        private Long apteTotal;
        private Long inapteGarcon;
        private Long inapteFilles;
        private Long inapteTotal;
        private Long total;
        private Long totalGarcon;
        private Long totalFilles;
        private Long totalTotal;
        

        // Constructeurs, getters et setters nécessaires
        public DataObject(Long situationGarcon,String situation, Long situationFilles, Long situationTotal) {
                this.situation = situation;
                this.situationGarcon = situationGarcon;
                this.situationFilles = situationFilles;
                this.situationTotal = situationTotal;
        }
        
        public DataObject(String concours, Long concoursGarcon, Long concoursFilles, Long concoursTotal) {
                this.concours = concours;
                this.concoursGarcon = concoursGarcon;
                this.concoursFilles = concoursFilles;
                this.concoursTotal = concoursTotal;
        }
        
        public DataObject(String option, Long apteGarcon, Long apteFilles, Long apteTotal, 
                          Long inapteGarcon, Long inapteFilles, Long inapteTotal, 
                           Long totalGarcon, Long totalFilles, Long totalTotal) {
            this.option = option;
            this.apteGarcon = apteGarcon;
            this.apteFilles = apteFilles;
            this.apteTotal = apteTotal;
            this.inapteGarcon = inapteGarcon;
            this.inapteFilles = inapteFilles;
            this.inapteTotal = inapteTotal;
            this.totalGarcon = totalGarcon;
            this.totalFilles = totalFilles;
            this.totalTotal = totalTotal;
        }
        public String getSituation() {
                return situation;
        }

        public void setSituation(String situation) {
                this.situation = situation;
        }

        public Long getSituationGarcon() {
                return situationGarcon;
        }

        public void setSituationGarcon(Long situationGarcon) {
                this.situationGarcon = situationGarcon;
        }

        public Long getSituationFilles() {
                return situationFilles;
        }

        public void setSituationFilles(Long situationFilles) {
                this.situationFilles = situationFilles;
        }

        public Long getSituationTotal() {
                return situationTotal;
        }

        public void setSituationTotal(Long situationTotal) {
                this.situationTotal = situationTotal;
        }
        
        public String getConcours() {
                return concours;
        }

        public void setConcours(String concours) {
                this.concours = concours;
        }


        public Long getConcoursGarcon() {
                return concoursGarcon;
        }

        public void setConcoursGarcon(Long concoursGarcon) {
                this.concoursGarcon = concoursGarcon;
        }

        public Long getConcoursFilles() {
                return concoursFilles;
        }

        public void setConcoursFilles(Long concoursFilles) {
                this.concoursFilles = concoursFilles;
        }

        public Long getConcoursTotal() {
                return concoursTotal;
        }

        public void setConcoursTotal(Long concoursTotal) {
                this.concoursTotal = concoursTotal;
        }
        
        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        public Long getApteGarcon() {
            return apteGarcon;
        }

        public void setApteGarcon(Long apteGarcon) {
            this.apteGarcon = apteGarcon;
        }

        public Long getApteFilles() {
            return apteFilles;
        }

        public void setApteFilles(Long apteFilles) {
            this.apteFilles = apteFilles;
        }

        public Long getApteTotal() {
            return apteTotal;
        }

        public void setApteTotal(Long apteTotal) {
            this.apteTotal = apteTotal;
        }

        public Long getInapteGarcon() {
            return inapteGarcon;
        }

        public void setInapteGarcon(Long inapteGarcon) {
            this.inapteGarcon = inapteGarcon;
        }

        public Long getInapteFilles() {
            return inapteFilles;
        }

        public void setInapteFilles(Long inapteFilles) {
            this.inapteFilles = inapteFilles;
        }

        public Long getInapteTotal() {
            return inapteTotal;
        }

        public void setInapteTotal(Long inapteTotal) {
            this.inapteTotal = inapteTotal;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Long getTotalGarcon() {
            return totalGarcon;
        }

        public void setTotalGarcon(Long totalGarcon) {
            this.totalGarcon = totalGarcon;
        }

        public Long getTotalFilles() {
            return totalFilles;
        }

        public void setTotalFilles(Long totalFilles) {
            this.totalFilles = totalFilles;
        }

        public Long getTotalTotal() {
            return totalTotal;
        }

        public void setTotalTotal(Long totalTotal) {
            this.totalTotal = totalTotal;
        }
    }
    
    public void tableauStatistique(){
        exportPdfStatGenerale();
        exportPdfStatGeneraleConcours();
        exportPdfStatGeneraleSituation();
    }
    
    public void exportWord(){
        exportToWordDeux(tableView,"STATISTIQUES DES INSCRITS PAR OPTION ET PAR STATUT AU SPORT",tableViewDeux,"STATISTIQUES DES INSCRITS PAR CONCOURS",tableViewTrois,"STATISTIQUES DES INSCRITS PAR SITUATION","document/Statistique_Generale.docx");
    }

    
   public void exportToWordDeux(TableView<DataObject> tableView1, String title1,
                              TableView<DataObject> tableView2, String title2,
                              TableView<DataObject> tableView3, String title3,
                              String filePath) {
        try (XWPFDocument document = new XWPFDocument(); FileOutputStream out = new FileOutputStream(filePath)) {
            // Exportez les données de la première TableView
            exportTable1View1ToWord(document, tableView1, title1);

            // Ajoutez un saut de page
            document.createParagraph().createRun().addBreak(BreakType.PAGE);

            // Exportez les données de la deuxième TableView
            exportTable2View2ToWord(document, tableView2, title2);

            // Ajoutez un saut de page
            document.createParagraph().createRun().addBreak(BreakType.PAGE);

            // Exportez les données de la troisième TableView
            exportTable3View3ToWord(document, tableView3, title3);

            // Enregistrez le document Word
            document.write(out);
            infoBoxSuccess("Document Word exporté avec succès.", "Success", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportTable1View1ToWord(XWPFDocument document, TableView<DataObject> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        XWPFTable table = document.createTable(tableView.getItems().size() + 1, 10); // Assuming you have 10 columns, adjust accordingly

        // Add the headers
        table.getRow(0).getCell(0).setText("Option");
        table.getRow(0).getCell(1).setText("Apte Garçon");
        table.getRow(0).getCell(2).setText("Apte Filles");
        table.getRow(0).getCell(3).setText("Apte Total");
        table.getRow(0).getCell(4).setText("Inapte Garçon");
        table.getRow(0).getCell(5).setText("Inapte Filles");
        table.getRow(0).getCell(6).setText("Inapte Total");
        table.getRow(0).getCell(7).setText("Total Garçon");
        table.getRow(0).getCell(8).setText("Total Filles");
        table.getRow(0).getCell(9).setText("Total Total");

        // Add data from the TableView to the table
        ObservableList<DataObject> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(data.get(i).getOption());
            table.getRow(i + 1).getCell(1).setText(String.valueOf(data.get(i).getApteGarcon()));
            table.getRow(i + 1).getCell(2).setText(String.valueOf(data.get(i).getApteFilles()));
            table.getRow(i + 1).getCell(3).setText(String.valueOf(data.get(i).getApteTotal()));
            table.getRow(i + 1).getCell(4).setText(String.valueOf(data.get(i).getInapteGarcon()));
            table.getRow(i + 1).getCell(5).setText(String.valueOf(data.get(i).getInapteFilles()));
            table.getRow(i + 1).getCell(6).setText(String.valueOf(data.get(i).getInapteTotal()));
            table.getRow(i + 1).getCell(7).setText(String.valueOf(data.get(i).getTotalGarcon()));
            table.getRow(i + 1).getCell(8).setText(String.valueOf(data.get(i).getTotalFilles()));
            table.getRow(i + 1).getCell(9).setText(String.valueOf(data.get(i).getTotalTotal()));
        }
    }
    
    private void exportTable2View2ToWord(XWPFDocument document, TableView<DataObject> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<DataObject> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(data.get(i).getConcours());
            table.getRow(i + 1).getCell(1).setText(String.valueOf(data.get(i).getConcoursGarcon()));
            table.getRow(i + 1).getCell(2).setText(String.valueOf(data.get(i).getConcoursFilles()));
            table.getRow(i + 1).getCell(3).setText(String.valueOf(data.get(i).getConcoursTotal()));
        }
    }

    private void exportTable3View3ToWord(XWPFDocument document, TableView<DataObject> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<DataObject> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(data.get(i).getSituation());
            table.getRow(i + 1).getCell(1).setText(String.valueOf(data.get(i).getSituationGarcon()));
            table.getRow(i + 1).getCell(2).setText(String.valueOf(data.get(i).getSituationFilles()));
            table.getRow(i + 1).getCell(3).setText(String.valueOf(data.get(i).getSituationTotal()));
        }
    }

    private void exportTableListeToWord(XWPFDocument document, TableView<Candidat> tableView, String title) {
       //document.getDocument().getBody().addNewSectPr().addNewPgSz().setOrient(STPageOrientation.LANDSCAPE);
       // Mettez le document en mode paysage
            CTBody body = document.getDocument().getBody();
            if (!body.isSetSectPr()) {
                body.addNewSectPr().addNewPgSz().setOrient(STPageOrientation.LANDSCAPE);
            }
                XWPFHeader header = document.createHeader(HeaderFooterType.DEFAULT);

            // Ajoutez du contenu à l'en-tête
            XWPFParagraph headerParagraph = header.createParagraph();
            headerParagraph.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun headerRun = headerParagraph.createRun();
            headerRun.setBold(true);
            headerRun.setFontSize(12);
            ObservableList<Candidat> datai = tableView.getItems();
            headerRun.setText(datai.get(0).getEtablissementCandidat().getNomStructure());
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<Candidat> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(String.valueOf(i + 1)); // N°Ordre
            table.getRow(i + 1).getCell(1).setText(data.get(i).getNom());
            table.getRow(i + 1).getCell(2).setText(data.get(i).getPrenom());
            table.getRow(i + 1).getCell(3).setText(data.get(i).getSexe().name());
            table.getRow(i + 1).getCell(4).setText(data.get(i).getDateNaissance().toString());
            table.getRow(i + 1).getCell(5).setText(data.get(i).getLieuNaissance());
            table.getRow(i + 1).getCell(6).setText(data.get(i).getPaysNaissance().getNomPays());
            table.getRow(i + 1).getCell(7).setText(data.get(i).getNationalite().getNationalite());
            table.getRow(i + 1).getCell(8).setText(data.get(i).getSport());
            table.getRow(i + 1).getCell(9).setText(data.get(i).getConcoursRatache().getLibelle());
            table.getRow(i + 1).getCell(10).setText(data.get(i).getOption().getOptionLibelle());
            table.getRow(i + 1).getCell(11).setText(""); // Signature, vous devez obtenir cette information de quelque part

            // Assurez-vous d'ajuster les indices des colonnes en fonction de la structure réelle de votre TableView
        }
    }


    private void exportTableListeClasseToWord(XWPFDocument document, TableView<Candidat> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        System.out.print("Total colonne ="+numCols);
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<Candidat> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(String.valueOf(i + 1)); // N°Ordre
            table.getRow(i + 1).getCell(1).setText(data.get(i).getNom());
            table.getRow(i + 1).getCell(2).setText(data.get(i).getPrenom());
            table.getRow(i + 1).getCell(3).setText(data.get(i).getSexe().name());
            table.getRow(i + 1).getCell(4).setText(data.get(i).getDateNaissance().toString());
            table.getRow(i + 1).getCell(5).setText(data.get(i).getLieuNaissance());
            table.getRow(i + 1).getCell(6).setText(data.get(i).getPaysNaissance().getNomPays());
            table.getRow(i + 1).getCell(7).setText(data.get(i).getNationalite().getNationalite());
            table.getRow(i + 1).getCell(8).setText(data.get(i).getSport());
            table.getRow(i + 1).getCell(9).setText(data.get(i).getConcoursRatache().getLibelle());
            table.getRow(i + 1).getCell(10).setText(data.get(i).getOption().getOptionLibelle());
            table.getRow(i + 1).getCell(11).setText(data.get(i).getPrenomPere());
            table.getRow(i + 1).getCell(12).setText(data.get(i).getNomMere());
            table.getRow(i + 1).getCell(13).setText(data.get(i).getPrenomMere());
            table.getRow(i + 1).getCell(14).setText(data.get(i).getTelephone());
            table.getRow(i + 1).getCell(15).setText(""); // Signature, vous devez obtenir cette information de quelque part

            // Assurez-vous d'ajuster les indices des colonnes en fonction de la structure réelle de votre TableView
        }
    }
    
    private void exportTableListeConcoursToWord(XWPFDocument document, TableView<Candidat> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        System.out.print("Total colonne ="+numCols);
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<Candidat> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(String.valueOf(i + 1)); // N°Ordre
            table.getRow(i + 1).getCell(1).setText(data.get(i).getNom());
            table.getRow(i + 1).getCell(2).setText(data.get(i).getPrenom());
            table.getRow(i + 1).getCell(3).setText(data.get(i).getSexe().name());
            table.getRow(i + 1).getCell(4).setText(data.get(i).getDateNaissance().toString());
            table.getRow(i + 1).getCell(5).setText(data.get(i).getLieuNaissance());
            table.getRow(i + 1).getCell(6).setText(data.get(i).getPaysNaissance().getNomPays());
            table.getRow(i + 1).getCell(7).setText(data.get(i).getNationalite().getNationalite());
            table.getRow(i + 1).getCell(8).setText(data.get(i).getSport());
            table.getRow(i + 1).getCell(9).setText(data.get(i).getOption().getOptionLibelle());
            table.getRow(i + 1).getCell(10).setText(""); // Signature, vous devez obtenir cette information de quelque part

            // Assurez-vous d'ajuster les indices des colonnes en fonction de la structure réelle de votre TableView
        }
    }
    
    private void exportTableListeOptionToWord(XWPFDocument document, TableView<Candidat> tableView, String title) {
    // Create a paragraph for the title of the section
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(14);

        // Add a line break
        document.createParagraph();

        // Create a paragraph for the data of the TableView
        XWPFParagraph tableParagraph = document.createParagraph();

        // Create a table
        int numRows = tableView.getItems().size() + 1; // Add 1 for header row
        int numCols = tableView.getColumns().size();
        System.out.print("Total colonne ="+numCols);
        XWPFTable table = document.createTable(numRows, numCols);

        // Add the headers
        for (int i = 0; i < numCols; i++) {
            table.getRow(0).getCell(i).setText(tableView.getColumns().get(i).getText());
        }

        // Add data from the TableView to the table
        ObservableList<Candidat> data = tableView.getItems();
        for (int i = 0; i < data.size(); i++) {
            table.getRow(i + 1).getCell(0).setText(String.valueOf(i + 1)); // N°Ordre
            table.getRow(i + 1).getCell(1).setText(data.get(i).getNom());
            table.getRow(i + 1).getCell(2).setText(data.get(i).getPrenom());
            table.getRow(i + 1).getCell(3).setText(data.get(i).getSexe().name());
            table.getRow(i + 1).getCell(4).setText(data.get(i).getDateNaissance().toString());
            table.getRow(i + 1).getCell(5).setText(data.get(i).getLieuNaissance());
            table.getRow(i + 1).getCell(6).setText(data.get(i).getPaysNaissance().getNomPays());
            table.getRow(i + 1).getCell(7).setText(data.get(i).getNationalite().getNationalite());
            table.getRow(i + 1).getCell(8).setText(data.get(i).getSport());
            table.getRow(i + 1).getCell(9).setText(data.get(i).getConcoursRatache().getLibelle());
            table.getRow(i + 1).getCell(10).setText(""); // Signature, vous devez obtenir cette information de quelque part

            // Assurez-vous d'ajuster les indices des colonnes en fonction de la structure réelle de votre TableView
        }
    }
}
