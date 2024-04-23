/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendFusionDataController;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class FusionDataController extends VueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField chemin;
    
    @FXML
    private Label labelNombreBases;
    
    @FXML
    private Button verificationButton;
    
    @FXML
    private Button mergeButton;

    @FXML
    public TableColumn<DatabaseModel,String> colBaseBon;
    
    @FXML
    public TableColumn<DatabaseModel,String> colTable;
    
    @FXML
    public TableColumn<DatabaseModel,Integer> colTotal;
    
    @FXML
    private TableView tableViewDonneesParTable;
    
    @FXML
    public TableColumn<DatabaseModelProble,String> colBaseProbleme;
    
    @FXML
    public TableColumn<DatabaseModelProble,String> colProbleme;
    
    @FXML
    private TableView tableViewBaseProblem;
    
    @FXML
    private int nombreBasesAFusionner = 0;
    
    @FXML
    List<File> bases_all;

    
    BackendFusionDataController backendFusionDataController;
    
    @FXML 
    private ComboBox<String> comboboxTypeFusion;
    
    ObservableList<String> list = FXCollections.observableArrayList("","Etablissement", "Provinciale", "Régionale","Centrale");
   
    ObservableList<DatabaseModel> listDatabase = FXCollections.observableArrayList();
    
    ObservableList<DatabaseModelProble> listDatabaseProblem = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
            comboboxTypeFusion.setItems(list.filtered(lis->lis.equalsIgnoreCase("Etablissement")));
        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
            comboboxTypeFusion.setItems(list.filtered(lis->lis.equalsIgnoreCase("Provinciale")));
        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Régional")){
            comboboxTypeFusion.setItems(list.filtered(lis->lis.equalsIgnoreCase("Régionale")));
        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
            comboboxTypeFusion.setItems(list.filtered(lis->lis.equalsIgnoreCase("Centrale")));
        }
        verificationButton.setDisable(true);
        mergeButton.setDisable(false);
    }    
    
    
    public void save(){
        
    }
    
    public void parcourir(ActionEvent e){
        
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node) e.getSource()).getScene().getWindow());
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Sélectionner un dossier");

        File selectedDirectory = directoryChooser.showDialog(stage);
        if (selectedDirectory != null) {
        chemin.setText(selectedDirectory.toString());
        bases_all = this.getAllDatabaseFiles(selectedDirectory);
        nombreBasesAFusionner = bases_all.size();
        labelNombreBases.setText(String.valueOf(nombreBasesAFusionner));

        // Effacez la liste existante avant de la remplir
        listDatabase.clear();

        for (File file : bases_all) {
            List<TableInfoModel> tablesInfo = getTablesInfo(file, List.of("groupePedagogique", "candidat", "candidatPosteJury", "Centre", "choixCandidat", "critereCandidatPosteJury", "dispense", "epreuveCandidatPosteJury", "inscription", "personnel", "user"));
            listDatabase.addAll(new DatabaseModel(file.getAbsolutePath(), tablesInfo));
        }
        tableViewDonneesParTable.setItems(listDatabase);
        colBaseBon.setCellValueFactory(cellData -> cellData.getValue().databaseNameProperty());
        colTable.setCellValueFactory(cellData -> {
        ObservableList<TableInfoModel> tables = cellData.getValue().getTables();
        String tableInfo = tables.stream()
                .map(table -> table.getTableName() + " (" + table.getRowCount() + ")")
                .collect(Collectors.joining(", "));
        return new SimpleStringProperty(tableInfo);
    });
    }
}

private List<File> getAllDatabaseFiles(File directory) {
        List<File> bases = new ArrayList<>();

        if (directory.isDirectory()) {
            // Obtenez la liste de tous les fichiers dans le dossier
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".db")) {
                        bases.add(file);
                    } else if (file.isDirectory()) {
                        // Si c'est un sous-dossier, appelez récursivement la fonction
                        bases.addAll(getAllDatabaseFiles(file));
                    }
                }
            }
        }

        return bases;
    }

private List<TableInfoModel> getTablesInfo(File databaseFile, List<String> tablesToCount) {
        List<TableInfoModel> tables = new ArrayList<>();

        try {
            // Charger le driver JDBC SQLite
            Class.forName("org.sqlite.JDBC");

            // Établir la connexion à la base de données
            String databaseUrl = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
            try (Connection connection = DriverManager.getConnection(databaseUrl)) {
                for (String tableName : tablesToCount) {
                    int rowCount = getRowCount(connection, tableName);
                    tables.add(new TableInfoModel(tableName, rowCount));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return tables;
    }

private int getRowCount(Connection connection, String tableName) throws SQLException {
        // Récupérer le nombre de lignes dans la table
        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*) FROM " + tableName)) {
            return resultSet.getInt(1);
        }
    }
    
public void charger() throws SQLException{
            backendFusionDataController = new BackendFusionDataController();
            String typeFusion = this.comboboxTypeFusion.getValue();
            String path = chemin.getText();
            List<HashMap<String,String>> baseProblemes = new ArrayList<>();
            bases_all.forEach(base ->{
                try {
                     HashMap<String,String> baseProblem = backendFusionDataController.loadFile(base.toString(), typeFusion);
                     baseProblemes.add(baseProblem);
                } catch (SQLException ex) {
                   // baseProblem.add(base.toString());
                   // Logger.getLogger(FusionDataController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });
            for (HashMap<String,String> bProbleme : baseProblemes) {
                 for (Map.Entry<String, String> entry : bProbleme.entrySet()) {
                    String cle = entry.getKey();
                    String valeur = entry.getValue();
                    listDatabaseProblem.addAll(new DatabaseModelProble(cle, valeur));
                }
            }
            tableViewBaseProblem.setItems(listDatabaseProblem);
            colBaseProbleme.setCellValueFactory(cellData -> cellData.getValue().problemDatabaseNameProperty());
            colProbleme.setCellValueFactory(cellData -> cellData.getValue().problemNameProperty());
            //this.changeBaseProblem();
        }
            
           // System.out.print("BaseProbleme"+baseProblem);
    
    public void changeBaseProblem(){
        tableViewDonneesParTable.setItems(listDatabaseProblem);
        colBaseProbleme.setCellValueFactory(cellData -> cellData.getValue().problemDatabaseNameProperty());
        colProbleme.setCellValueFactory(cellData -> cellData.getValue().problemNameProperty());
    }
    
    public void changeTypeFusion(){
        verificationButton.setDisable(false);
       // mergeButton.setDisable(true);
    }
    
    public void verification(){
        try {
            backendFusionDataController = new BackendFusionDataController();
            String typeFusion = this.comboboxTypeFusion.getValue();
            String path = chemin.getText();
            backendFusionDataController.verification(path, typeFusion);
          //  infoBoxSuccess("Base Fusionnée avec succès", "Succes", null);
        } catch (SQLException ex) {
            //infoBoxError("Données existantes", "Erreur", null);
        }
        
    }
    
    // Classe de modèle pour représenter une table avec son nombre de données
    public static class TableInfoModel {
        private final SimpleStringProperty tableName;
        private final SimpleIntegerProperty rowCount;

        public TableInfoModel(String tableName, int rowCount) {
            this.tableName = new SimpleStringProperty(tableName);
            this.rowCount = new SimpleIntegerProperty(rowCount);
        }

        public String getTableName() {
            return tableName.get();
        }

        public SimpleStringProperty tableNameProperty() {
            return tableName;
        }

        public int getRowCount() {
            return rowCount.get();
        }

        public SimpleIntegerProperty rowCountProperty() {
            return rowCount;
        }
    }

    // Classe de modèle pour représenter une base de données avec ses tables
    public static class DatabaseModel {
        private final SimpleStringProperty databaseName;
        private final ObservableList<TableInfoModel> tables;

        public DatabaseModel(String databaseName, List<TableInfoModel> tables) {
            this.databaseName = new SimpleStringProperty(databaseName);
            this.tables = FXCollections.observableArrayList(tables);
        }

        public String getDatabaseName() {
            return databaseName.get();
        }

        public SimpleStringProperty databaseNameProperty() {
            return databaseName;
        }

        public ObservableList<TableInfoModel> getTables() {
            return tables;
        }
    }
    
    public static class DatabaseModelProble {
        private final SimpleStringProperty problemDatabaseName;
        private final SimpleStringProperty problem;

        public DatabaseModelProble(String databaseName, String proble) {
            this.problemDatabaseName = new SimpleStringProperty(databaseName);
            this.problem = new SimpleStringProperty(proble);
        }

        public String getProblemDatabaseName() {
            return problemDatabaseName.get();
        }

        public SimpleStringProperty problemDatabaseNameProperty() {
            return problemDatabaseName;
        }
        
        public String getProblemName() {
            return problem.get();
        }

        public SimpleStringProperty problemNameProperty() {
            return problem;
        }
    }
}
