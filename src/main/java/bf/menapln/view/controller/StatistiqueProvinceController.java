/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.*;
import bf.menapln.entity.*;
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
import org.apache.poi.xwpf.usermodel.BreakType;



/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class StatistiqueProvinceController extends VueController implements Initializable {
    @FXML 
    private ComboBox<String> comboboxTypeStat;
    
    @FXML
    private ComboBox<Object> comboboxValeurStat;
    
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
    
    ObservableList<String> listSortie = FXCollections.observableArrayList("Tout",
        "Par Etablissement","Par Centre");
    
    public StatistiqueProvinceController() throws SQLException {
        this.backendInscriptionController = new BackendInscriptionController();
        this.backendGroupePedagogiqueController = new BackendGroupePedagogiqueController();
        this.backendTypeController = new BackendTypeController();
        this.backendOptionController = new BackendOptionController();
        this.backendLocaliteController = new BackendLocaliteController();
        this.backendEtablissementController = new BackendStructureController();

    }
    
        BackendInscriptionController backendInscriptionController;
        BackendGroupePedagogiqueController backendGroupePedagogiqueController;
        BackendTypeController backendTypeController;
        BackendOptionController backendOptionController;
        BackendLocaliteController backendLocaliteController;
        BackendStructureController backendEtablissementController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxTypeStat.setItems(listSortie);
        comboboxValeurStat.setDisable(true);
//        enregistrerBtn.setDisable(true);
        //tableauStatistique();
    }
    
    public void afficherApercuPDF() {
        // Remplacez "chemin/vers/votre/fichier.pdf" par le chemin réel de votre fichier PDF
        String cheminPDF = "exportTest.pdf";
    }
    
    public void chargerPDF(){
        // Créez le visualiseur PDF
       // PDFViewer pdfViewer = new PDFViewer();

        // Chargez le fichier PDF (remplacez "chemin/vers/votre/fichier.pdf" par le chemin de votre fichier PDF)
     //   pdfViewer.loadPDF("chemin/vers/votre/fichier.pdf");
    }
    public void onChangeTypeStruct(){
        String type = comboboxTypeStat.getValue();
        /**
         * Début de tout
         **/
        if(type.equalsIgnoreCase("Tout")){
            try {
                tableView.getColumns().clear();
        tableView.getItems().clear();
        tableViewDeux.getColumns().clear();
        tableViewDeux.getItems().clear();
        tableViewTrois.getColumns().clear();
        tableViewTrois.getItems().clear();
                List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
                        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getCentreExamen().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList());
                exportPdfStatGeneraleAll(dataCandidat);
                exportPdfStatGeneraleConcoursAll(dataCandidat);
                exportPdfStatGeneraleSituationAll(dataCandidat);
                comboboxValeurStat.setDisable(true);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueProvinceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Début Etablissement
         **/
        else if(type.equalsIgnoreCase("Par Etablissement")){
            try {
                comboboxValeurStat.setDisable(false);
                comboboxValeurStat.setItems(convertToFxList(backendEtablissementController.getEtabByProvince("Etablissement",sessionManager.getUser().getStructure().getLocalite().getParentLocalite())));
//                enregistrerBtn.setDisable(false);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueProvinceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        /**
         * Début Centre
         */
        else if(type.equalsIgnoreCase("Par Centre")){
            try {
                comboboxValeurStat.setDisable(false);
                comboboxValeurStat.setItems(convertToFxList(backendLocaliteController.getAllCentreExamen().stream()
                        .map(obj->(obj instanceof Centre) ? (Centre)obj:null)
                        .filter(localite->localite !=null && localite.getLocalite().getParentLocalite().getId().equals(sessionManager.getUser().getStructure().getLocalite().getParentLocalite().getId()))
                        .collect(Collectors.toList())));
//                enregistrerBtn.setDisable(false);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueProvinceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void onChangeValeurStruct(){
        String type = comboboxTypeStat.getValue();
        tableView.getColumns().clear();
        tableView.getItems().clear();
        tableViewDeux.getColumns().clear();
        tableViewDeux.getItems().clear();
        tableViewTrois.getColumns().clear();
        tableViewTrois.getItems().clear();
        if(type.equalsIgnoreCase("Par Etablissement")){
            
            try {
                Structure etablissement = (Structure)comboboxValeurStat.getValue();
                List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
                        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getEtablissementCandidat().getId().equals(etablissement.getId()))
                        .collect(Collectors.toList());
                exportPdfStatGeneraleAll(dataCandidat);
                exportPdfStatGeneraleConcoursAll(dataCandidat);
                exportPdfStatGeneraleSituationAll(dataCandidat);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueProvinceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else if(type.equalsIgnoreCase("Par Centre")){
        try {
                Centre centre = (Centre)comboboxValeurStat.getValue();
                List<Objet> dataCandidat = backendInscriptionController.getAll().stream()
                        .map(obj-> (obj instanceof Candidat)?(Candidat) obj : null)
                        .filter(candidat->candidat != null && candidat.getCentreExamen().getId().equals(centre.getId()))
                        .collect(Collectors.toList());
                exportPdfStatGeneraleAll(dataCandidat);
                exportPdfStatGeneraleConcoursAll(dataCandidat);
                exportPdfStatGeneraleSituationAll(dataCandidat);
            } catch (SQLException ex) {
                Logger.getLogger(StatistiqueProvinceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
}
    
    public void exportPdfStatGeneraleAll(List<Objet> dataCandidat){

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
  }
    
    // Stat résumé
    public void exportPdfStatGeneraleConcoursAll(List<Objet> dataCandidat){

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
            
  }
    
     // Stat résumé
    public void exportPdfStatGeneraleSituationAll(List<Objet> dataCandidat){

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
      //  exportPdfStatGenerale();
      //  exportPdfStatGeneraleConcours();
      //  exportPdfStatGeneraleSituation();
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


 }
