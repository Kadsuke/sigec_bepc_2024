/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendStatistiqueController;
import bf.menapln.entity.Statistique;
import bf.menapln.entity.StatistiqueActeur;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author kadsuke
 */
public class HomeController extends VueController implements Initializable{
    @FXML
    public TableView<Statistique> dataTable;
    
    @FXML
    public TableColumn<Statistique,String> structureCol;
    
    @FXML
    public TableColumn<Statistique,String> serieCol;
    
    @FXML
    public TableColumn<Statistique,Integer> totalInscritsCol;
    
    @FXML
    public TableColumn<Statistique,Integer> nbGCol;
    
    @FXML
    public TableColumn<Statistique,Integer> nbFCol;
    
    @FXML
    public TableColumn<Statistique,Integer> nbApteCol;
    
    @FXML
    public TableColumn<Statistique,Integer> nbInapteCol;
    
    @FXML
    public TableView<StatistiqueActeur> dataTable2;
    
    @FXML
    public TableColumn<StatistiqueActeur,String> structureCol2;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> presidentCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> secretaireCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> correcteurCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> superviseurCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> vicepresidentCol;
    
    @FXML
    public TableColumn<StatistiqueActeur,Integer> preseidentcentresecondaire;
    
    @FXML
    public BarChart barChart;
    
    @FXML
    public ComboBox typeStatistiqueCol;
    
    @FXML
    VBox statVBox = new VBox();
    BackendStatistiqueController backendController;
    public HomeController() throws SQLException{
        super();
        this.backendController = new BackendStatistiqueController();
       // this.setDefaultController(new BackendStatistiqueController());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Invite")){
            this.typeStatistiqueCol.getItems().addAll("","Option","Situation","Handicap","Acteur");
            this.typeStatistiqueCol.getSelectionModel().select("");
            this.statVBox.getChildren().clear();
        }else{
            typeStatistiqueCol.setDisable(true);
        
        }
    }
    
    public void typeStatistiqueOnChange(){
            this.barChart.getData().clear();
            switch(this.typeStatistiqueCol.getSelectionModel().getSelectedItem().toString()){
                case "Option":
                    try {
                        this.statVBox.getChildren().clear();
                        this.statVBox.getChildren().add(this.dataTable);
                        if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabByOption()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabByOption()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Regional")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueProvinceByOption()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionByOption()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionByOption()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }
                        this.serieCol.setText("Option");
                        this.serieCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getOption().getOptionLibelle()));
                        this.totalInscritsCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getTotalInscrit()).asObject());
                        this.nbGCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbG()).asObject());
                        this.nbFCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbF()).asObject());
                        this.nbApteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbApte()).asObject());
                        this.nbInapteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbInapte()).asObject());

                        Map<Integer,XYChart.Series> series = new HashMap<Integer,XYChart.Series>();
                        Integer nbSeries = 0;
                        for(Statistique stat : this.dataTable.getItems()){
                            series.put(nbSeries, new XYChart.Series());
                            series.get(nbSeries).setName(stat.getOption().getOptionLibelle());
                            series.get(nbSeries).getData().add(new XYChart.Data("Garçons",stat.getNbG()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Filles",stat.getNbF()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Aptes",stat.getNbApte()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Inapte",stat.getNbInapte()));
                            this.barChart.getData().add(series.get(nbSeries));
                            nbSeries++;
                        }
                        this.barChart.setTitle(sessionManager.getUser().getStructure().getNomStructure());
                        //this.barChart.getData().addAll(series);

                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
                case "Situation":
                    try {
                        this.statVBox.getChildren().clear();
                        this.statVBox.getChildren().add(this.dataTable);
                        
                        if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabBySituation()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabBySituation()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Regional")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueProvinceBySituation()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionBySituation()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionBySituation()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }
//this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        this.serieCol.setText("Situation");
                        this.serieCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getSituation().getSituationLibelle()));
                        this.totalInscritsCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getTotalInscrit()).asObject());
                        this.nbGCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbG()).asObject());
                        this.nbFCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbF()).asObject());
                        this.nbApteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbApte()).asObject());
                        this.nbInapteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbInapte()).asObject());

                        Map<Integer,XYChart.Series> series = new HashMap<Integer,XYChart.Series>();
                        Integer nbSeries = 0;
                        for(Statistique stat : this.dataTable.getItems()){
                            series.put(nbSeries, new XYChart.Series());
                            series.get(nbSeries).setName(stat.getSituation().getSituationLibelle());
                            series.get(nbSeries).getData().add(new XYChart.Data("Garçons",stat.getNbG()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Filles",stat.getNbF()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Aptes",stat.getNbApte()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Inapte",stat.getNbInapte()));
                            this.barChart.getData().add(series.get(nbSeries));
                            nbSeries++;
                        }
                        this.barChart.setTitle(sessionManager.getUser().getStructure().getNomStructure());
                        //this.barChart.getData().addAll(series);

                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
                case "Acteur":
                    try {
                        this.statVBox.getChildren().clear();
                        this.statVBox.getChildren().add(this.dataTable2);
                        
                        if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                            this.dataTable2.setItems(this.listStatistiqueActToFxList(backendController.getAllStatistiqueActeurByEtab()));
                            this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                            this.dataTable2.setItems(this.listStatistiqueActToFxList(backendController.getAllStatistiqueActeurByEtab()));
                            this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Regional")){
                            this.dataTable2.setItems(this.listStatistiqueActToFxList(backendController.getAllStatistiqueActeurByProvince()));
                            this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                            this.dataTable2.setItems(this.listStatistiqueActToFxList(backendController.getAllStatistiqueActeurByRegion()));
                            this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                            this.dataTable2.setItems(this.listStatistiqueActToFxList(backendController.getAllStatistiqueActeurByRegion()));
                            this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }
//this.structureCol2.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        this.presidentCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbPresident()).asObject());
                        this.secretaireCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbSecretaire()).asObject());
                        this.correcteurCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbCorrecteur()).asObject());
                        this.superviseurCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbSuperviseur()).asObject());
                        this.vicepresidentCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbVicePresident()).asObject());
                        this.preseidentcentresecondaire.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbPresidentCentre()).asObject());

                        Map<Integer,XYChart.Series> series = new HashMap<Integer,XYChart.Series>();
                        Integer nbSeries = 0;
                        for(StatistiqueActeur stat : this.dataTable2.getItems()){
                            series.put(nbSeries, new XYChart.Series());
                            if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                                series.get(nbSeries).setName(stat.getStructure().toString());
                            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                                series.get(nbSeries).setName(stat.getStructure().toString());
                            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Regional")){
                                series.get(nbSeries).setName(stat.getProvince().getNomLoclite());
                            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                                series.get(nbSeries).setName(stat.getRegion().getNomLoclite());
                            }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                                series.get(nbSeries).setName(stat.getRegion().getNomLoclite());
                            }
                            
                            series.get(nbSeries).getData().add(new XYChart.Data("Président",stat.getNbPresident()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Sécretaite",stat.getNbSecretaire()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Correcteur",stat.getNbCorrecteur()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Superviseur",stat.getNbSuperviseur()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Vice-Président",stat.getNbVicePresident()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Président Centre Sécondaire",stat.getNbPresidentCentre()));
                            this.barChart.getData().add(series.get(nbSeries));
                            nbSeries++;
                        }
                        this.barChart.setTitle(sessionManager.getUser().getStructure().getNomStructure());
                        //this.barChart.getData().addAll(series);

                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
                case "Handicap":
                    try {
                        this.statVBox.getChildren().clear();
                        this.statVBox.getChildren().add(this.dataTable);
                        
                        if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Etablissement")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabByHandicap()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Provincial")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueEtabByHandicap()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Regional")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueProvinceByHandicap()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getProvince().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Central")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionByHandicap()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }else if(sessionManager.getUser().getProfil().getProfilLibelle().equalsIgnoreCase("Root")){
                            this.dataTable.setItems(this.listStatistiqueToFxList(backendController.getAllStatistiqueRegionByHandicap()));
                            this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getRegion().getNomLoclite()));
                        }
//this.structureCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getStructure().getNomStructure()));
                        this.serieCol.setText("Handicap");
                        this.serieCol.setCellValueFactory(cell->this.toStringProperty(cell.getValue().getTypeHandicap().getLibelle()));
                        this.totalInscritsCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getTotalInscrit()).asObject());
                        this.nbGCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbG()).asObject());
                        this.nbFCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbF()).asObject());
                        this.nbApteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbApte()).asObject());
                        this.nbInapteCol.setCellValueFactory(cell->this.toIntegerProperty(cell.getValue().getNbInapte()).asObject());

                        Map<Integer,XYChart.Series> series = new HashMap<Integer,XYChart.Series>();
                        Integer nbSeries = 0;
                        for(Statistique stat : this.dataTable.getItems()){
                            series.put(nbSeries, new XYChart.Series());
                            series.get(nbSeries).setName(stat.getTypeHandicap().getLibelle());
                            series.get(nbSeries).getData().add(new XYChart.Data("Garçons",stat.getNbG()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Filles",stat.getNbF()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Aptes",stat.getNbApte()));
                            series.get(nbSeries).getData().add(new XYChart.Data("Inapte",stat.getNbInapte()));
                            this.barChart.getData().add(series.get(nbSeries));
                            nbSeries++;
                        }
                        this.barChart.setTitle(sessionManager.getUser().getStructure().getNomStructure());
                        //this.barChart.getData().addAll(series);

                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            }
    }
    
   
}
