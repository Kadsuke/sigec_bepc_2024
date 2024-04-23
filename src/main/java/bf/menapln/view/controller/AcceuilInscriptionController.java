/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.generique.ActionButtonTableCell;
import bf.menapln.generique.PDFViewer;
import bf.menapln.reporting.PDFExporter;
import bf.menapln.sigec.App;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcceuilInscriptionController extends VueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane borderFils;
    
    @FXML
    private LayoutController layout;
    
    @FXML
    public TableView tableView;

    @FXML
    public TableColumn<Candidat,Integer> colId;

    @FXML
    public TableColumn<Candidat,String> colNom;
    
    @FXML
    public TableColumn<Candidat,String> colPrenom;
    
    @FXML
    public TableColumn<Candidat,String> colTypeDateNaissance;
        
    @FXML
    public TableColumn<Candidat,String> colDateNaissance;

    @FXML
    public TableColumn<Candidat,String> colLieuNaissance;
 
    @FXML
    public TableColumn<Candidat,String> colSport;
    
    @FXML
    public TableColumn<Candidat,String> colPaysNaissance;
    
    @FXML
    public TableColumn<Candidat,String> colNationalite;
    
    @FXML
    public TableColumn<Candidat,String> colOption;
    
    @FXML
    public TableColumn<Candidat,String> colSexe;
    
    @FXML
    public TableColumn<Candidat,String> colConcours;
    
    @FXML
    public TableColumn<Candidat,String> colZone;
    
    @FXML
    public TableColumn<Candidat,String> colCentre;
    @FXML
    public TableColumn<Candidat,String> colReg;
    @FXML
    public TableColumn<Candidat,String> colProv;
    
    @FXML
    public TableColumn<Candidat,String> colGroupePedagogique;
    
    @FXML
    public TableColumn<Candidat,String> colEtablissement;
    
    @FXML
    public TableColumn<Candidat,String> colNumDossier;
    
    @FXML
    public TableColumn<Candidat,String> colEtablissementSerie;
    
    @FXML
    public TableColumn<Candidat,String> colSituation;
    @FXML
    public TableColumn<Candidat,String> colTypeHandicap;
    @FXML
    public TableColumn<Candidat,String> colNatureHandicap;
    @FXML
    public TableColumn<Candidat,String> colPrescriptionHandicap;
    
    
    @FXML
    private TextField rechercheField;
    
    @FXML
    private ComboBox<String> comboboxTypeList;
    
    @FXML
    private ComboBox<Object> comboboxValeurList;
    
    @FXML
    private ComboBox<Object> comboboxProvince;
    
    @FXML
    private ComboBox<Object> comboboxRegion;

    @FXML
    private Label label;
    
    
    
    @FXML
    private Button buttonNew;
    
    @FXML
    private Button buttonExcel;
    
    ObservableList<String> typeList = FXCollections.observableArrayList("Tout",
        "Par Etablissement","Par Centre");
    private Stage primaryStage;
    ObservableList<Object> listCandidats = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            listCandidats = convertToFxList(backendInscriptionController.getAll());

            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                comboboxTypeList.setVisible(false);
                comboboxValeurList.setVisible(false);
                comboboxProvince.setVisible(false);
                comboboxRegion.setVisible(false);
                listCandidats = this.convertToFxList(listCandidats.stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList()));
                // this.listAll();
                this.AjouterBtn();

                
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                comboboxTypeList.setItems(typeList);
                comboboxProvince.setVisible(false);
                comboboxRegion.setVisible(false);
                this.AjouterBtn();

            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                comboboxTypeList.setItems(typeList);
                comboboxProvince.setItems(convertToFxList(backendLocaliteController.getAllByParent(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId().toString())));
                comboboxRegion.setVisible(false);
                this.AjouterBtn();

            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                comboboxTypeList.setVisible(false);
                comboboxValeurList.setVisible(false);
                comboboxProvince.setVisible(false);
                comboboxRegion.setVisible(false);
               // this.AjouterBtn();
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                comboboxTypeList.setItems(typeList);
                comboboxRegion.setItems(convertToFxList(backendLocaliteController.getAll("region")));
                this.AjouterBtn();
            }
            this.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                this.fieldRechercheKeyUp();
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public AcceuilInscriptionController() throws SQLException {
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendEtablissementController = new BackendStructureController();
        this.backendSerieConcoursRattacheController = new BackendSerieConcoursRattacheController();
        this.backendSerieConcoursRattacheController = new BackendSerieConcoursRattacheController();
        this.backendNaturehandicapController = new BackendNatureHandicapController();
        this.backendPrescriptionNaturehandicapController = new BackendPrescriptionNatureHandicapController();

    }
    
        BackendInscriptionController backendInscriptionController;
        BackendLocaliteController backendLocaliteController;
        BackendStructureController backendEtablissementController;
        BackendSerieConcoursRattacheController backendSerieConcoursRattacheController;
        BackendNatureHandicapController backendNaturehandicapController;
        BackendPrescriptionNatureHandicapController backendPrescriptionNaturehandicapController;
        
        //PDFExporter pdfExporter;

    @FXML
    public void openInscription(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("inscription.fxml"));
        AnchorPane formInscription = loader.load();
        borderFils.setCenter(formInscription);
    }
    
    @FXML
    public void listAll() throws SQLException{
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        /* ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll().stream()
        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(sessionManager.getUser().getStructure().getId()))
                .collect(Collectors.toList())); */
        tableView.setItems(listCandidats);
        this.label.setText("Liste des candidats à l'examen du BEPC "+tableView.getItems().size());
        colReg.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getLocalite().getParentLocalite().getParentLocalite().toString()));
        colProv.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getLocalite().getParentLocalite().toString()));
        colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
        colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getVilleComposition().getNomLoclite()));
        colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
        colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
        colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
        colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
        colDateNaissance.setCellValueFactory(cellData -> {
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
        colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
        colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
        colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
        colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
        colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
        colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
        colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
        colEtablissementSerie.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getChoixEtablissements().toString()));
        colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
        colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
        colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
        colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
        colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
        
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                PDFViewer.afficherPDF("/Projet", primaryStage);
            }
        });
        }
    
    public void exportPdf(){
        try {
            ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll());
            tableView.setItems(typeList);
            PDFExporter pdfExporter = new PDFExporter();
            pdfExporter.setMinistere("Ministère de l'éducation Nationale de la promotion\ndes langues");
            pdfExporter.setDreps("Direction Régional des cascades");
            pdfExporter.setDpeps("Direction Provinciale de la comoé");
            pdfExporter.setEtablissement("Lycée Santa de Niangoloko");
//            pdfExporter.exportToPDF(tableView, "exportTest.pdf");

            String filePath = "exportTest.pdf";
            PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null) {
            if (printerJob.showPrintDialog(tableView.getScene().getWindow())) {
                VBox printLayout = createPrintLayout(filePath);

                // Adapter la taille du layout à la page
                Node node = printLayout;
                Printer printer = printerJob.getPrinter();
                PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
               // PageLayout pageLayout = printer.createPageLayout(Paper.A4, Printer.MarginType.HARDWARE_MINIMUM);
                double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
                double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
                double scale = Math.min(scaleX, scaleY);

                node.getTransforms().add(new Scale(scale, scale));

                // Imprimer le document
                boolean success = printerJob.printPage(pageLayout, node);
                if (success) {
                    printerJob.endJob();
                }
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    private static VBox createPrintLayout(String filePath) {
        // Ajouter ici les éléments que vous souhaitez imprimer (par exemple, un titre, etc.)
        VBox printLayout = new VBox();

        // Vous pouvez également charger le fichier PDF dans un composant ImageView ou WebView ici
        // et l'ajouter au layout si nécessaire.

        return printLayout;
    }

    public BorderPane getBorderFils() {
        return borderFils;
    }

    public void setBorderFils(BorderPane borderFils) {
        this.borderFils = borderFils;
    }
    
    @FXML
    public  void fieldRechercheKeyUp() throws SQLException{
        listAll();
        this.filtrerTableView(this.tableView,rechercheField.getText());
        this.label.setText("Liste des candidats à l'examen du BEPC "+tableView.getItems().size());
    }
    
     public void AjouterBtn(){
        TableColumn<Object, Void> actionColumn = ActionButtonTableCell.createTableColumn(
                tableView,
                    event -> {
                        Candidat candidat = (Candidat) event.getSource();
                        this.openModalFormWithInitialData(candidat);
                },
                    event -> {
                        Objet candidat = (Objet) event.getSource();
                        this.openConfirmSupp(candidat);
            }
        );
    }
     
     private void openConfirmSupp(Objet candidat){
            ButtonType buttonTypeYes = new ButtonType("Oui");
            ButtonType buttonTypeNo = new ButtonType("Non");

            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION,
                   "Voulez-vous vraiment supprimer cet candidat ?", buttonTypeYes, buttonTypeNo);

           confirmationDialog.setTitle("Confirmation de suppression");

           confirmationDialog.showAndWait().ifPresent(response -> {
               if (response == buttonTypeYes) {
                   try {
                       backendInscriptionController.delete(candidat);
                       infoBoxSuccess("Candidat Supprimé avec succès", "Success", null);
                       listAll();
                   } catch (SQLException ex) {
                       Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   catch (EmptyDataException ex) {
                       Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   catch (NullPointerException ex) {
                       Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else if (response == buttonTypeNo) {
                   confirmationDialog.close();
               }
           });
       }
     
    
    //Modification
    public void openModalFormWithInitialData(Candidat candidat) {
    try {
        // Chargez le fichier FXML du formulaire de modification
        FXMLLoader loader = new FXMLLoader(App.class.getResource("inscription.fxml"));
        Parent root = loader.load();

        // Accédez au contrôleur du formulaire de modification
        InscriptionController modificationController = loader.getController();
        modificationController.disableAll();
        modificationController.getModifButton().setVisible(true);
        modificationController.getSaveButton().setVisible(false);
        modificationController.setCandidatIdField(candidat.getId());
        modificationController.getNumeroDossierField().setDisable(true);
        // Injectez les données initiales dans les contrôles du formulaire
        
        //commune
        modificationController.setComboboxCommune(modificationController.getListCommune());
        modificationController.getComboboxCommune().setValue(candidat.getVilleComposition().getParentLocalite());
        //Province
        modificationController.setComboboxProvince(modificationController.getListProvince());
        modificationController.getComboboxProvince().setValue(candidat.getVilleComposition().getParentLocalite().getParentLocalite());
        //Region
        modificationController.setComboboxRegion(modificationController.getListRegion());
        modificationController.getComboboxRegion().setValue(candidat.getVilleComposition().getParentLocalite().getParentLocalite().getParentLocalite());
 
        modificationController.setNomField(candidat.getNom());
        modificationController.setPrenomField(candidat.getPrenom());
        modificationController.setLieuNaissanceField(candidat.getLieuNaissance());
        modificationController.setTelephoneField(candidat.getTelephone());
        modificationController.setTelephoneDeuxField(candidat.getTelephoneDeux());
        modificationController.setNumeroActeField(candidat.getNumeroActeNaissance());
        modificationController.setAnneeCepField(candidat.getAnneeDernierDiplome());
        modificationController.setNomMereField(candidat.getNomMere());
        modificationController.setPrenomMereField(candidat.getPrenomMere());
        modificationController.setNomPereField(candidat.getNomPere());
        modificationController.setPrenomPereField(candidat.getPrenomPere());
        modificationController.setNumeroDossierField(candidat.getNumeroDossier());
        //Sexe
        modificationController.setComboboxSexe(modificationController.getListSexe());
        modificationController.getComboboxSexe().getSelectionModel().select(candidat.getSexe());
        //Centre d'Examen
        modificationController.setComboboxCentreExamen(modificationController.getListCommune());
        modificationController.getComboboxCentreExamen().getSelectionModel().select(candidat.getVilleComposition());
        //Centre d'Examen
        modificationController.setComboboxZone(modificationController.getListZone());
        modificationController.getComboboxZone().getSelectionModel().select(candidat.getZone());
        //Etablissement
        modificationController.setComboboxEtablissement(modificationController.getListEtabCommune());
        modificationController.getComboboxEtablissement().getSelectionModel().select(candidat.getEtablissementCandidat());
        //Type Inscription
        modificationController.setComboboxTypeInscription(modificationController.getListTypeInsc());
        modificationController.getComboboxTypeInscription().getSelectionModel().select(candidat.getTypeInscription());
        //Type Candidat
        modificationController.setComboboxStatut(modificationController.getListTypeStatut());
        modificationController.getComboboxStatut().getSelectionModel().select(candidat.getTypeCandidat());
        //Type Situation
        modificationController.setComboboxSituation(modificationController.getListTypeSituation());
        modificationController.getComboboxSituation().getSelectionModel().select(candidat.getTypeSituation());
        
        
        //Type Handicap
        if(candidat.getTypeHandicap()!= null){
            modificationController.setComboboxTypeHandicap(modificationController.getListTypeHandicap());
            modificationController.getComboboxTypeHandicap().getSelectionModel().select(candidat.getTypeHandicap());
        }else{
            modificationController.setComboboxTypeHandicap(modificationController.getListTypeHandicap());
            modificationController.getComboboxTypeHandicap().getSelectionModel().select("");
        }
        
        //Nature Handicap
        if(candidat.getTypeHandicap() != null){
            modificationController.setComboboxNatureHandicap(convertToFxList(backendNaturehandicapController.getAllByType(candidat.getTypeHandicap())));
            modificationController.getComboboxNatureHandicap().getSelectionModel().select(candidat.getNatureHandicap());
        }else{
            modificationController.getComboboxNatureHandicap().getSelectionModel().select("");
        }
        if(candidat.getNatureHandicap() != null){
            modificationController.setComboboxPrescriptionHandicap(convertToFxList(backendPrescriptionNaturehandicapController.getByNatureHandicap(candidat.getNatureHandicap())));
            modificationController.getComboboxPrescriptionHandicap().getSelectionModel().select(candidat.getPrescriptionHandicap());
        }
        else{
            modificationController.getComboboxPrescriptionHandicap().getSelectionModel().select("");
        }
        
        //Prescription Handicap
        
        //Option
        modificationController.setComboboxOption(modificationController.getListOption());
        modificationController.getComboboxOption().getSelectionModel().select(candidat.getOption());
        //Sport
        modificationController.setComboboxSport(modificationController.getListSport());
        modificationController.getComboboxSport().getSelectionModel().select(candidat.getSport());
        //Pays
        modificationController.setComboboxPaysNaissance(modificationController.getListPays());
        modificationController.getComboboxPaysNaissance().getSelectionModel().select(candidat.getPaysNaissance());
       // modificationController.getComboboxPaysNaissance().setValue(candidat.getPaysNaissance());
        //Nationalité
        modificationController.setComboboxNationalite(modificationController.getListNationalite());
        modificationController.getComboboxNationalite().getSelectionModel().select(candidat.getNationalite());
       // modificationController.getComboboxNationalite().setValue(candidat.getNationalite());
        //Groupe Pedagogique
        modificationController.setComboboxGroupePedagogique(modificationController.getListGPEtab());
        modificationController.getComboboxGroupePedagogique().getSelectionModel().select(candidat.getGroupePedagogique());
        //Concours Rattaché
        modificationController.setComboboxConcours(modificationController.getListTypeConcours());
        modificationController.getComboboxConcours().getSelectionModel().select(candidat.getConcoursRatache());
        //Type Date
        modificationController.setComboboxTypeDate(modificationController.getListTypeDate());
        modificationController.getComboboxTypeDate().getSelectionModel().select(candidat.getTypeDateNaissance());
        // Date De Naissance
        modificationController.setDateNaissancemField(modificationController.getDateNaissancemField());
        modificationController.getDateNaissancemField().setValue(candidat.getDateNaissance());
        
        if(candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("bepc seul")){

        }else{
            modificationController.getComboboxEtabPremier().setDisable(false);
            modificationController.getComboboxSeriePremier().setDisable(false);
            modificationController.getComboboxEtabSecond().setDisable(false);
            modificationController.getComboboxSerieSecond().setDisable(false);
            modificationController.getComboboxEtabTroisieme().setDisable(false);
            modificationController.getComboboxSerieTroisieme().setDisable(false);
            modificationController.setListSerie(convertToFxList(backendSerieConcoursRattacheController.getAllByConcours(candidat.getConcoursRatache())));
            Map<Structure, SerieConcours> choixEtabSerie = candidat.getChoixEtabSerie();
            if(candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Entrée en Seconde")){
                System.out.println("je suis entree et ma province "+ candidat.getCentreExamen().getParentLocalite().getParentLocalite().getId());
                modificationController.setListEtablissementChoix(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",candidat.getCentreExamen().getParentLocalite().getParentLocalite())));
            }else if(candidat.getConcoursRatache().getLibelle().equalsIgnoreCase("Prémière année BEP")){
                System.out.println("je suis bep et ma region"+candidat.getCentreExamen().getParentLocalite().getParentLocalite().getParentLocalite().getId());
                modificationController.setListEtablissementChoix(convertToFxList(backendEtablissementController.getEtabByRegion("Etablissement",candidat.getCentreExamen().getParentLocalite().getParentLocalite().getParentLocalite())));
            }
            
            // Vérifiez si la liste des choix est non nulle et contient au moins un choix
            if (choixEtabSerie != null && !choixEtabSerie.isEmpty()) {
                int index = 0;
                modificationController.setComboboxEtabSecond(modificationController.getListEtablissementChoix());
                modificationController.setComboboxEtabTroisieme(modificationController.getListEtablissementChoix());
                modificationController.setComboboxSerieSecond(modificationController.getListSerie());
                modificationController.setComboboxSerieTroisieme(modificationController.getListSerie());

                for (Structure etablissement : choixEtabSerie.keySet()) {
                    SerieConcours serie = choixEtabSerie.get(etablissement);
                    switch (index) {
                        case 0:
                            modificationController.setComboboxEtabPremier(modificationController.getListEtablissementChoix());
                            modificationController.getComboboxEtabPremier().getSelectionModel().select(etablissement);
                            modificationController.setComboboxSeriePremier(modificationController.getListSerie());
                            modificationController.getComboboxSeriePremier().getSelectionModel().select(serie);
                            break;
                        case 1:
                            //modificationController.setComboboxEtabSecond(modificationController.getListEtablissementChoix());
                            modificationController.getComboboxEtabSecond().getSelectionModel().select(etablissement);
                            //modificationController.setComboboxSerieSecond(modificationController.getListSerie());
                            modificationController.getComboboxSerieSecond().getSelectionModel().select(serie);
                            break;
                        case 2:
                            //modificationController.setComboboxEtabTroisieme(modificationController.getListEtablissementChoix());
                            modificationController.getComboboxEtabTroisieme().getSelectionModel().select(etablissement);
                            //modificationController.setComboboxSerieTroisieme(modificationController.getListSerie());
                            modificationController.getComboboxSerieTroisieme().getSelectionModel().select(serie);
                            break;
                        }
                index++;
            }
        }
    }
        // Créez une nouvelle fenêtre (stage) pour le dialogue modal
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL); // Rend la fenêtre modale
        modalStage.initStyle(StageStyle.UTILITY); // Style de la fenêtre modal
        
        Screen screen = Screen.getPrimary();
        double screenWidth = screen.getBounds().getWidth()-100.0;
        double screenHeight = screen.getBounds().getHeight()-100.0;
        // Définissez le contenu du formulaire à afficher dans le dialogue modal
        modalStage.setScene(new Scene(root,screenWidth, screenHeight));

        // Affichez le dialogue modal
        modalStage.showAndWait();
        listAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
    public void exportExcel(){
        exportToExcel(tableView,"exportCandidat.xlsx");
    }
    
    public void onChangeTypeList() throws SQLException{
        String type = comboboxTypeList.getValue();
        if(type.equalsIgnoreCase("Tout")){
            comboboxValeurList.setDisable(true);
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll().stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getCentreExamen().getParentLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
            colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
            colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
            colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
            colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
            colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
            colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
            colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
            colEtablissementSerie.setCellValueFactory(cellData -> {
                   Candidat candidat = cellData.getValue();
                   Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                   StringJoiner structureJoiner = new StringJoiner(";");
                   StringJoiner serieJoinder = new StringJoiner("{}");
                   for (Structure structure : structures) {
                       structureJoiner.add(structure.getNomStructure());
                       //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                   }

                   return new SimpleStringProperty(structureJoiner.toString());
               });
            colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
            colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
            colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
            colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
            colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll().stream()
                .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getCentreExamen().getParentLocalite().getParentLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
                colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
                colEtablissementSerie.setCellValueFactory(cellData -> {
                   Candidat candidat = cellData.getValue();
                   Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                   StringJoiner structureJoiner = new StringJoiner(";");
                   StringJoiner serieJoinder = new StringJoiner("{}");
                   for (Structure structure : structures) {
                       structureJoiner.add(structure.getNomStructure());
                       //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                   }

                   return new SimpleStringProperty(structureJoiner.toString());
               });
                colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
                colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
                colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
                colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
                colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll());
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
                colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
                colEtablissementSerie.setCellValueFactory(cellData -> {
                   Candidat candidat = cellData.getValue();
                   Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                   StringJoiner structureJoiner = new StringJoiner(";");
                   StringJoiner serieJoinder = new StringJoiner("{}");
                   for (Structure structure : structures) {
                       structureJoiner.add(structure.getNomStructure());
                       //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                   }

                   return new SimpleStringProperty(structureJoiner.toString());
               });
                colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
                colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
                colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
                colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
                colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll());
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
                colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
                colEtablissementSerie.setCellValueFactory(cellData -> {
                   Candidat candidat = cellData.getValue();
                   Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                   StringJoiner structureJoiner = new StringJoiner(";");
                   StringJoiner serieJoinder = new StringJoiner("{}");
                   for (Structure structure : structures) {
                       structureJoiner.add(structure.getNomStructure());
                       //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                   }

                   return new SimpleStringProperty(structureJoiner.toString());
               });
                colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
                colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
                colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
                colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
                colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
            }
        }else if(type.equalsIgnoreCase("Par Etablissement")){
            comboboxValeurList.setDisable(false);
            tableView.getItems().clear();
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                comboboxValeurList.setItems(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",sessionManager.getUser().getStructure().getLocalite().getParentLocalite())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                comboboxValeurList.setItems(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                comboboxValeurList.setItems(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                comboboxValeurList.setItems(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",(Localite)comboboxProvince.getValue())));
            }
        }else if(type.equalsIgnoreCase("Par Centre")){
            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                comboboxValeurList.setItems(convertToFxList(backendLocaliteController.getAllCentreExamen().stream()
                            .map(obj->(obj instanceof Centre) ? (Centre)obj:null)
                            .filter(localite->localite !=null && localite.getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                            .collect(Collectors.toList())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                comboboxValeurList.setItems(convertToFxList(backendLocaliteController.getAllCentreExamen().stream()
                            .map(obj->(obj instanceof Centre) ? (Centre)obj:null)
                            .filter(localite->localite !=null && localite.getLocalite().getParentLocalite().getId().equals(((Localite)comboboxProvince.getValue()).getId()))
                            .collect(Collectors.toList())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                comboboxValeurList.setItems(convertToFxList(backendLocaliteController.getAllCentreExamen().stream()
                            .map(obj->(obj instanceof Centre) ? (Centre)obj:null)
                            .filter(localite->localite !=null && localite.getLocalite().getParentLocalite().getId().equals(((Localite)comboboxProvince.getValue()).getId()))
                            .collect(Collectors.toList())));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                comboboxValeurList.setItems(convertToFxList(backendLocaliteController.getAllCentreExamen().stream()
                            .map(obj->(obj instanceof Centre) ? (Centre)obj:null)
                            .filter(localite->localite !=null && localite.getLocalite().getParentLocalite().getId().equals(((Localite)comboboxProvince.getValue()).getId()))
                            .collect(Collectors.toList())));
            } 
        
        }
    }
    
    public void onChangeValeurList(){
        String type = comboboxTypeList.getValue();
        if(type.equalsIgnoreCase("Par Etablissement")){
            try {
                Structure etablissement = (Structure)comboboxValeurList.getValue();
                //System.out.print("Etablissemnt" +etablissement.getId());
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll().stream()
                        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(etablissement.getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
                colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
        colEtablissementSerie.setCellValueFactory(cellData -> {
                        Candidat candidat = cellData.getValue();
                        Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                        StringJoiner structureJoiner = new StringJoiner(";");
                        StringJoiner serieJoinder = new StringJoiner("{}");
                        for (Structure structure : structures) {
                            structureJoiner.add(structure.getNomStructure());
                            //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                        }

                        return new SimpleStringProperty(structureJoiner.toString());
                    });

             colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
             colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
             colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
            colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
            colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }else if(type.equalsIgnoreCase("Par Centre")){
            try {
                Centre centre = (Centre)comboboxValeurList.getValue();
                DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                ObservableList<Object> typeList = convertToFxList(backendInscriptionController.getAll().stream()
                        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getCentreExamen().getId().equals(centre.getId()))
                        .collect(Collectors.toList()));
                tableView.setItems(typeList);
                colZone.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getZone().getNomLoclite()));
                colCentre.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getCentreExamen().getNomLoclite()));
                colTypeDateNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeDateNaissance()));
                colEtablissement.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getEtablissementCandidat().getNomStructure()));
                colNom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNom()));
                colPrenom.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrenom()));
                colSexe.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSexe().name()));
                colDateNaissance.setCellValueFactory(cellData -> {
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
                colLieuNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getLieuNaissance()));
                colSport.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getSport()));
                colPaysNaissance.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPaysNaissance().getNomPays()));
                colNationalite.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNationalite().getNationalite()));
                colOption.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getOption().getOptionLibelle()));
                colConcours.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getConcoursRatache().getLibelle()));
                colGroupePedagogique.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getGroupePedagogique().getGroupePedagogiqueLibelle()));
                colEtablissementSerie.setCellValueFactory(cellData -> {
                           Candidat candidat = cellData.getValue();
                           Set<Structure> structures = candidat.getChoixEtabSerie().keySet();
                        StringJoiner structureJoiner = new StringJoiner(";");
                        StringJoiner serieJoinder = new StringJoiner("{}");
                        for (Structure structure : structures) {
                            structureJoiner.add(structure.getNomStructure());
                            //serieJoinder.add(candidat.getChoixEtabSerie().get(structure).toString());
                        }

                        return new SimpleStringProperty(structureJoiner.toString());
                    });
             colSituation.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeSituation().getLibelle()));
                colTypeHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getTypeHandicap().getLibelle()));
                colNatureHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNatureHandicap().getNatureHandicapLibelle()));
                colPrescriptionHandicap.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getPrescriptionHandicap().getLibelle()));
            colNumDossier.setCellValueFactory(cellData->this.toStringProperty(cellData.getValue().getNumeroDossier()));
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
     public void onChangeRegion(){
        try {
            Localite region = (Localite)comboboxRegion.getValue();
            comboboxProvince.setItems(convertToFxList(backendLocaliteController.getAllByParent(region.getId().toString())));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}

