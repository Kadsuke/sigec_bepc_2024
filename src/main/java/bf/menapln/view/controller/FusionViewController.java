/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendFusionDataController;
import bf.menapln.controller.BackendStatistiqueController;
import bf.menapln.entity.DatabaseEntity;
import bf.menapln.entity.DatabaseList;
import bf.menapln.entity.Statistique;
import bf.menapln.entity.StatistiqueActeur;
import bf.menapln.view.dialog.TestDatabaseMergeDialog;
import exception.EmptyDataException;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class FusionViewController extends VueController implements Initializable {
    @FXML
    public Button loadDatabasesBtn;
    
    @FXML
    public Button testBtn;
    
    @FXML
    public Button mergeBtn;
    
    @FXML
    public TextField folderField;
    
    @FXML
    private Label structureCountLabel;
    
    @FXML
    public TableView<Statistique> statCandExBeforFusion;
    
    @FXML
    public TableColumn<Statistique,String> structureCandExBeforeFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> garconsBeforeFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> fillesBeforeFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> inscritsCandExBeforeFusionCol;
    
    @FXML
    public TableView<StatistiqueActeur> statActBefortFusion;
    
    @FXML
    public TableColumn<StatistiqueActeur,String> strutureActBeforeFusionCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> presidentBeforCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> secretaireBeforCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> correcteurBeforCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> superviseurBeforCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> presidentCentreSecondaireBeforCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> vicePresidentBeforCol;
    
    @FXML
    public VBox messageBox;
    
    @FXML
    public TableView<Statistique> statCandExAfterFusion;
    
    @FXML
    public TableColumn<Statistique,String> structureCandExAfterFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> garconsAfterFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> fillesAfterFusionCol;
    
    @FXML
    public TableColumn<Statistique,Integer> inscritsCandExAfterFusionCol;
    
    @FXML
    public TableView<StatistiqueActeur> statActAfterFusion;
    
    @FXML
    public TableColumn<StatistiqueActeur,String> strutureActAfterFusionCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> presidentAfterCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> secretaireAfterCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> correcteurAfterCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> superviseurAfterCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> presidentCentreSecondaireAfterCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> vicePresidentAfterCol;
    
    private File selectedFolder;
    private DatabaseList<Integer,DatabaseEntity> dataBaseListe;
    BackendStatistiqueController backendController;
    
    public FusionViewController() throws SQLException{
        super();
         this.backendController = new BackendStatistiqueController();
       // this.setDefaultController(new BackendStatistiqueController());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // try {
            this.loadDatabasesBtn.setDisable(true);
            this.testBtn.setDisable(true);
            this.mergeBtn.setDisable(true);
            
           /*  if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                this.statCandExAfterFusion.setItems(this.listToSat((backendController.getAllStatistiqueByEtab())));
                this.statActAfterFusion.setItems(this.listToSatAct(backendController.getAllStatistiqueActeurByEtab()));
                this.structureCandExBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                this.structureCandExAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                this.statCandExAfterFusion.setItems(this.listToSat((backendController.getAllStatistiqueByEtab())));
                this.statActAfterFusion.setItems(this.listToSatAct(backendController.getAllStatistiqueActeurByEtab()));
                this.structureCandExBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                this.structureCandExAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
                this.statCandExAfterFusion.setItems(this.listToSat((backendController.getAllStatistiqueByProvince())));
                this.statActAfterFusion.setItems(this.listToSatAct(backendController.getAllStatistiqueActeurByProvince()));
                this.structureCandExBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                this.strutureActBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                this.structureCandExAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                this.strutureActAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                this.statCandExAfterFusion.setItems(this.listToSat((backendController.getAllStatistiqueByRegion())));
                this.statActAfterFusion.setItems(this.listToSatAct(backendController.getAllStatistiqueActeurByRegion()));
                this.structureCandExBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                this.structureCandExAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                this.statCandExAfterFusion.setItems(this.listToSat((backendController.getAllStatistiqueByRegion())));
                this.statActAfterFusion.setItems(this.listToSatAct(backendController.getAllStatistiqueActeurByRegion()));
                this.structureCandExBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActBeforeFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                this.structureCandExAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().toString()));
                this.strutureActAfterFusionCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
            }
         
            
            this.garconsBeforeFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbG()).asObject());
            this.fillesBeforeFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbF()).asObject());
            this.inscritsCandExBeforeFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getTotalInscrit()).asObject());
            
            this.presidentBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbPresident()).asObject());
            this.secretaireBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbSecretaire()).asObject());
            this.correcteurBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbCorrecteur()).asObject());
            this.superviseurBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbSuperviseur()).asObject());
            this.vicePresidentBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbVicePresident()).asObject());
            this.presidentCentreSecondaireBeforCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbPresidentCentre()).asObject());
            
            this.garconsAfterFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbG()).asObject());
            this.fillesAfterFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbF()).asObject());
            this.inscritsCandExAfterFusionCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getTotalInscrit()).asObject());
            
            this.presidentAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbPresident()).asObject());
            this.secretaireAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbSecretaire()).asObject());
            this.correcteurAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbCorrecteur()).asObject());
            this.superviseurAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbSuperviseur()).asObject());
            this.vicePresidentAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbVicePresident()).asObject());
            this.presidentCentreSecondaireAfterCol.setCellValueFactory(cell->toIntegerProperty(cell.getValue().getNbPresidentCentre()).asObject());
        */
      //  } catch (SQLException ex) {
      //      Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
      //  }

    }

    public void loadFolder(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser = new JFileChooser(); 
        fileChooser.setDialogTitle(new String("Sélectionnez le dossier regroupant les bases à fusioner"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
            this.selectedFolder = fileChooser.getSelectedFile();
            this.folderField.setText(this.selectedFolder.getAbsolutePath());
            this.loadDatabasesBtn.setDisable(false);
            this.testBtn.setDisable(true);
            this.mergeBtn.setDisable(true);
        }
        else {
            //this.loadDatabasesBtn.setDisable(true);
            System.out.println("No Selection ");
        }
    }
    /*public void loadDatabases() {
    try {
        BackendStatistiqueController ctrBack = new BackendStatistiqueController();
        if (this.selectedFolder == null) {
            this.infoBoxError("Veuillez sélectionner un dossier valide pour les bases de données", "Info", null);
        } else {
            int i = 0; // Déclaration de la variable i
            String currentDB = "";
            try {
                this.structureCountLabel.setText(null);
                this.statCandExBeforFusion.getItems().clear();
                this.statActBefortFusion.getItems().clear();
                this.dataBaseListe = new DatabaseList();
                this.dataBaseListe.setLocalDataBase(new DatabaseEntity("bd_bepc.db", "bd_bepc.db"));
                this.dataBaseListe.getLocalDataBase().setConnexion();

                // Utiliser une méthode récursive pour parcourir les fichiers et les sous-dossiers
                int numberOfDatabases = exploreFolder(selectedFolder, i);

                this.structureCountLabel.setText(Integer.toString(numberOfDatabases)); // Utilisation de Integer.toString(i) pour définir le texte
                this.loadDatabasesBtn.setDisable((numberOfDatabases > 0) ? true : false);
                this.testBtn.setDisable((numberOfDatabases > 0) ? false : true);
            } catch (SQLException ex) {
                this.infoBoxError("Mauvaise base : " + currentDB + " " + ex.getMessage(), "Erreur", null);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
}*/

/*private int exploreFolder(File folder, int i) throws SQLException {
    BackendStatistiqueController ctrBack = new BackendStatistiqueController();
    for (File file : folder.listFiles()) {
        if (file.isDirectory()) {
            // Si le fichier est un dossier, appeler récursivement la méthode pour explorer le sous-dossier
            i = exploreFolder(file, i);
        } else if (FilenameUtils.getExtension(file.getName()).equals("db")) {
            String currentDB = file.getName();
            this.dataBaseListe.put(i, new DatabaseEntity(file.getAbsolutePath(), file.getName()));
            this.dataBaseListe.get(i).setConnexion();
            this.statCandExBeforFusion.getItems().addAll(this.listToSat(ctrBack.getExDBAllStatistiqueByEtab(this.dataBaseListe.get(i).getConnexion())));
            this.statActBefortFusion.getItems().addAll(this.listToSatAct(ctrBack.getExDBAllStatistiqueActeurByEtab(this.dataBaseListe.get(i).getConnexion())));
            i++;
        }
    }
    return i;
}*/

 public void loadDatabases(){
        try {
            BackendStatistiqueController ctrBack = new BackendStatistiqueController();
            if(this.selectedFolder == null){
                this.infoBoxError("Veuillez sélectionner l'emplacement des bases", "Info", null);
            }else{
                Integer i = 0;
                String currentDB="";
                try {
                    this.structureCountLabel.setText(null);
                    this.statCandExBeforFusion.getItems().clear();
                    this.statActBefortFusion.getItems().clear();
                    this.dataBaseListe = new DatabaseList();
                    this.dataBaseListe.setLocalDataBase(new DatabaseEntity("bd_bepc.db","bd_bepc.db"));
                    this.dataBaseListe.getLocalDataBase().setConnexion();
                    for(File db : this.selectedFolder.listFiles()){
                        if(FilenameUtils.getExtension(db.getName()).equals("db")){
                            currentDB = db.getName();
                            this.dataBaseListe.put(i, new DatabaseEntity(db.getAbsolutePath(),db.getName()));
                            this.dataBaseListe.get(i).setConnexion();
                           // this.statCandExBeforFusion.getItems().addAll(this.listToSat(ctrBack.getExDBAllStatistiqueByEtab(this.dataBaseListe.get(i).getConnexion())));
                           // this.statActBefortFusion.getItems().addAll(this.listToSatAct(ctrBack.getExDBAllStatistiqueActeurByEtab(this.dataBaseListe.get(i).getConnexion())));
                            i++;
                        }
                    }
                 
                    this.structureCountLabel.setText(i.toString());
                    this.loadDatabasesBtn.setDisable((i>0)?true:false);
                    this.testBtn.setDisable((i>0)?false:true);
                } catch (SQLException ex) {
                   // Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
                   
                    this.infoBoxError("Mauvaise base : "+currentDB+" "+ex.getMessage(), "Erreur", null);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
private void parcourirDossiers(File dossier, BackendStatistiqueController ctrBack, Integer i) throws SQLException {
    for (File fichier : dossier.listFiles()) {
        if (fichier.isDirectory()) {
            // Appel récursif pour parcourir les sous-dossiers
            parcourirDossiers(fichier, ctrBack, i);
        } else if (FilenameUtils.getExtension(fichier.getName()).equals("db")) {
            String currentDB = fichier.getName();
            this.dataBaseListe.put(i, new DatabaseEntity(fichier.getAbsolutePath(), fichier.getName()));
            this.dataBaseListe.get(i).setConnexion();
            this.statCandExBeforFusion.getItems().addAll(this.listToSat(ctrBack.getExDBAllStatistiqueByEtab(this.dataBaseListe.get(i).getConnexion())));
            this.statActBefortFusion.getItems().addAll(this.listToSatAct(ctrBack.getExDBAllStatistiqueActeurByEtab(this.dataBaseListe.get(i).getConnexion())));
            i++;
        }
    }
   // this.structureCountLabel.setText(i.toString());
}
    
    public void testMergeDatabases(){
        this.dataBaseListe.getCandidatExKeys().clear();
        this.dataBaseListe.getDoublonCandidatExKeys().clear();
        int i = 0;
        for(Map.Entry db : this.dataBaseListe.entrySet()){
            try {
                if(i == 0){
                    ResultSet rs = this.dataBaseListe.getLocalDataBase().getConnexion().prepareStatement("SELECT * FROM candidat").executeQuery();
                    Integer candidatCount = 0;
                    while(rs.next()){
                        this.dataBaseListe.setCandidatExKeys(rs, this.dataBaseListe.getLocalDataBase().getName());
                        candidatCount++;
                    }
                    this.dataBaseListe.getLocalDataBase().setCandidatCount(candidatCount);
                    
                    
                    rs = this.dataBaseListe.getLocalDataBase().getConnexion().prepareStatement("SELECT * FROM groupePedagogique").executeQuery();
                    Integer gpCount = 0;
                    while(rs.next()){
                        this.dataBaseListe.setGPKeys(rs, this.dataBaseListe.getLocalDataBase().getName());
                        gpCount++;
                    }
                    this.dataBaseListe.getLocalDataBase().setGpCount(gpCount);

                    rs = this.dataBaseListe.getLocalDataBase().getConnexion().prepareStatement("SELECT * FROM candidatPosteJury").executeQuery();
                    Integer acteurCount = 0;
                    while(rs.next()){
                        this.dataBaseListe.setActeurKeys(rs, this.dataBaseListe.getLocalDataBase().getName());
                        this.dataBaseListe.setActeurNIPKeys(rs, this.dataBaseListe.getLocalDataBase().getName());
                        this.dataBaseListe.setActeurMatricules(rs, this.dataBaseListe.getLocalDataBase().getName());
                        acteurCount++;
                    }
                    this.dataBaseListe.getLocalDataBase().setActeursCount(acteurCount);
                    this.dataBaseListe.getLocalDataBase().getConnexion().close();
                    i++;
                }
                ResultSet rs = this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("SELECT * FROM candidat").executeQuery();
                while(rs.next()){
                    this.dataBaseListe.setCandidatExKeys(rs, this.dataBaseListe.get(db.getKey()).getName());
                }
                
                rs = this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("SELECT * FROM groupePedagogique").executeQuery();
                while(rs.next()){
                    this.dataBaseListe.setGPKeys(rs, this.dataBaseListe.get(db.getKey()).getName());
                }
                
                rs = this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("SELECT * FROM candidatPosteJury").executeQuery();
                while(rs.next()){
                    this.dataBaseListe.setActeurKeys(rs, this.dataBaseListe.get(db.getKey()).getName());
                    this.dataBaseListe.setActeurNIPKeys(rs, this.dataBaseListe.get(db.getKey()).getName());
                    this.dataBaseListe.setActeurMatricules(rs, this.dataBaseListe.get(db.getKey()).getName());
                }
            } catch (SQLException ex) {
               // Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
                this.infoBoxError(ex.getMessage(), "Info", null);
            }
        }
        TestDatabaseMergeDialog e = new TestDatabaseMergeDialog(this.dataBaseListe);
        Optional result = e.showAndWait();
        this.testBtn.setDisable(true);
        if(!this.dataBaseListe.hasDoublon()){ 
            this.mergeBtn.setDisable(false);
        }else{
            this.loadDatabasesBtn.setDisable(false);
        }
        
    }
    
    public void mergeDatabases(){
        try {
            String erreur = "";
            String currentDB = "bd_bepc.db";
            BackendStatistiqueController ctr = new BackendStatistiqueController();
            for(Map.Entry db : this.dataBaseListe.entrySet()){
                // try {
                    boolean yes = true;
                    this.dataBaseListe.get(db.getKey()).getConnexion().setAutoCommit(false);
                    // insertion des deux colonnes centre_id et localite_id
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("ATTACH DATABASE \"" + this.dataBaseListe.getLocalDataBase().getPath() + "\" AS  currentDB").execute();
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("ALTER TABLE inscription ADD COLUMN centre_id integer").execute();
                        System.out.println("FusionViewController.mergeDatabases()### centre_id OK");
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("ALTER TABLE inscription ADD COLUMN localite_id integer").execute();
                        System.out.println("FusionViewController.mergeDatabases()### localite_id OK");
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("UPDATE inscription SET centre_id = (SELECT centre_id FROM  centre WHERE inscription.centreExamen_id = centre.centre_identifiant)").execute();
                        System.out.println("FusionViewController.mergeDatabases()### update centre_id  OK");
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("UPDATE inscription SET localite_id = (SELECT localite_id FROM  centre WHERE inscription.centreExamen_id = centre.centre_identifiant)").execute();
                        System.out.println("FusionViewController.mergeDatabases()### update localite_id  OK");
                    } catch (SQLException e) {
                        System.out.println("FusionViewController.mergeDatabases()#### Les deux colonnes centre_id et localite_id EXISTE");
                    }
                    // insertion des centres
                    try {
                        String profil = sessionManager.getUser().getProfil().getProfilLibelle();
                        if(profil.equalsIgnoreCase("Régional") || profil.equalsIgnoreCase("Root") ||  profil.equalsIgnoreCase("Central")){
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.centre  SELECT * FROM centre").execute();
                            System.out.println("FusionViewController.mergeDatabases()### insert centre OK");
                        }/* else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.centre  SELECT * FROM centre").execute();
                            System.out.println("FusionViewController.mergeDatabases()### insert centre OK");
                        } */
                    } catch (SQLException e) {
                        System.out.println("FusionViewController.mergeDatabases()### Les centres existe,CONTINUE");
                    }
                    
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.groupePedagogique  SELECT * FROM groupePedagogique").execute();
                    } catch (SQLException e) {
                        System.out.println("BLEM : INSERT INTO currentDB.groupePedagogique  SELECT * FROM groupePedagogique");
                        erreur+="\n"+e;
                        yes = false;
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.candidat  SELECT * FROM candidat").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.candidat  SELECT * FROM candidat");
                        erreur+="\n"+e;
                        yes = false;
                    }
                    
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.inscription  SELECT * FROM inscription").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.inscription  SELECT * FROM inscription");
                        erreur+="\n"+e;
                        yes = false;
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.dispense  SELECT * FROM dispense").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.dispense  SELECT * FROM dispense");
                        erreur+="\n"+e;
                        yes = false;
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.choixCandidat  SELECT serie_id,session_id,choixEtablissement_id,etablissement_id,candidat_id,numeroDossier,ordre FROM choixCandidat").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.choixCandidat  SELECT serie_id,session_id,choixEtablissement_id,etablissement_id,candidat_id,numeroDossier,ordre FROM choixCandidat");
                        try {//Ajout colone numeroDossier
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("ALTER TABLE choixCandidat ADD COLUMN numeroDossier integer").execute();
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("UPDATE choixCandidat SET numeroDossier = (SELECT numeroDossier FROM inscription WHERE inscription.candidat_id = choixCandidat.candidat_id)").execute();
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.choixCandidat  SELECT serie_id,session_id,choixEtablissement_id,etablissement_id,candidat_id,numeroDossier,ordre FROM choixCandidat").execute();
                        } catch (SQLException e2) {
                            System.out.println(" PAS DE SOLUTION: INSERT INTO currentDB.choixCandidat  SELECT serie_id,session_id,choixEtablissement_id,etablissement_id,candidat_id,numeroDossier,ordre FROM choixCandidat");
                            erreur+="\n"+e;
                            yes = false;
                        }
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.candidatPosteJury  SELECT * FROM candidatPosteJury").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.candidatPosteJury  SELECT * FROM candidatPosteJury");
                        erreur+="\n"+e;
                        yes = false;
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.epreuveCandidatPosteJury  SELECT * FROM epreuveCandidatPosteJury").execute();
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.epreuveCandidatPosteJury  SELECT * FROM epreuveCandidatPosteJury");
                        try {
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("ALTER TABLE epreuveCandidatPosteJury ADD COLUMN structure_id integer").execute();
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("UPDATE epreuveCandidatPosteJury SET structure_id = (SELECT structure_id FROM candidatPosteJury WHERE candidatPosteJury.candidat_id = epreuveCandidatPosteJury.candidat_id)").execute();
                            this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.epreuveCandidatPosteJury  SELECT * FROM epreuveCandidatPosteJury").execute();
                        } catch (SQLException e2) {
                            System.out.println(" PAS DE SOLUTION: INSERT INTO currentDB.epreuveCandidatPosteJury  SELECT * FROM epreuveCandidatPosteJury");
                            erreur+="\n"+e;
                            yes = false;
                        }
                    }
                    try {
                        this.dataBaseListe.get(db.getKey()).getConnexion().prepareStatement("INSERT INTO currentDB.critereCandidatPosteJury  SELECT * FROM critereCandidatPosteJury").execute();
                        // this.dataBaseListe.get(db.getKey()).getConnexion().commit();
                        // this.dataBaseListe.get(db.getKey()).getConnexion().close();
                        // this.statCandExAfterFusion.setItems(this.listToSat((ctr.getAllStatistiqueByEtab())));
                        // this.statActAfterFusion.setItems(this.listToSatAct(ctr.getAllStatistiqueActeurByEtab()));
                        
                        // this.messageBox.getChildren().add(new Label(this.dataBaseListe.get(db.getKey()).getPath()));
                        // this.infoBoxSuccess("Fusion terminée avec succès", "Info", null);
                    } catch (SQLException e) {
                        System.out.println(" BLEM: INSERT INTO currentDB.critereCandidatPosteJury  SELECT * FROM critereCandidatPosteJury\nFUSION ABORT");
                        erreur+="\n"+e;
                        yes = false;
                        // this.infoBoxError(e.getMessage(), "Info", null);
                    }
                    
                    // this.dataBaseListe.get(db.getKey()).getConnexion().commit();
                    // this.dataBaseListe.get(db.getKey()).getConnexion().close();
                    
                    // this.statCandExAfterFusion.setItems(this.listToSat((ctr.getAllStatistiqueByEtab())));
                    // this.statActAfterFusion.setItems(this.listToSatAct(ctr.getAllStatistiqueActeurByEtab()));
                    
                    // this.messageBox.getChildren().add(new Label(this.dataBaseListe.get(db.getKey()).getPath()));
                    // this.infoBoxSuccess("Fusion terminée avec succès", "Info", null);
                /* } catch (SQLException ex) {
                    System.out.println("FusionViewController.mergeDatabases()### ");
                    Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
                    this.infoBoxError(ex.getMessage(), "Info", null);
                } */
                if(yes){
                    this.dataBaseListe.get(db.getKey()).getConnexion().commit();
                    this.dataBaseListe.get(db.getKey()).getConnexion().close();
                    
                    // this.statCandExAfterFusion.setItems(this.listToSat((ctr.getAllStatistiqueByEtab())));
                    // this.statActAfterFusion.setItems(this.listToSatAct(ctr.getAllStatistiqueActeurByEtab()));
                    
                    this.messageBox.getChildren().add(new Label(this.dataBaseListe.get(db.getKey()).getPath()));
                    this.infoBoxSuccess("Fusion terminée avec succès", "Info", null);
                }else{
                    this.dataBaseListe.get(db.getKey()).getConnexion().rollback();
                    this.dataBaseListe.get(db.getKey()).getConnexion().close();
                    this.infoBoxError(erreur, "Info ERROR", null);
                }
            }
      } catch (SQLException ex) {
            this.infoBoxError(ex.getMessage(), "Info", null);
            Logger.getLogger(FusionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reset(){
        this.folderField.setText("");
        this.structureCountLabel.setText("");
        this.statCandExBeforFusion.getItems().clear();
        this.statActBefortFusion.getItems().clear();
        this.messageBox.getChildren().clear();
        this.statCandExAfterFusion.getItems().clear();
        this.statActAfterFusion.getItems().clear();
        this.loadDatabasesBtn.setDisable(true);
        this.testBtn.setDisable(true);
        this.mergeBtn.setDisable(true);
    }
    public ObservableList<Statistique> listToSat(List l){
        return FXCollections.observableArrayList(l);
    }
    
    public ObservableList<StatistiqueActeur> listToSatAct(List l){
        return FXCollections.observableArrayList(l);
    }
    
    
}
