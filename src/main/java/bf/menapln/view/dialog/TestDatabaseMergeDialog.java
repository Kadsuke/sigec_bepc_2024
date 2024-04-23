/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.view.dialog;

import bf.menapln.dataModel.BilanTestModel;
import bf.menapln.entity.DatabaseEntity;
import bf.menapln.entity.DatabaseList;
import bf.menapln.entity.Doublon;
import bf.menapln.sigec.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author coulibaly
 */
public class TestDatabaseMergeDialog extends Dialog<DatabaseList>{
    private DatabaseList dataBaseListe;
    public TableView<Doublon> viewDoublonCandidatEx;
    public TableColumn<Doublon,String> candidatExKeys;
    public TableColumn<Doublon,String> candidatEx1;
    public TableColumn<Doublon,String> candidatEx2;
    
    public TestDatabaseMergeDialog(DatabaseList dbliste){
        this.dataBaseListe = dbliste;
        this.setTitle("Bilan du test de fusion");
        this.setWidth(App.getScene().getWidth()-50);
        //this.initOwner(App.getFrame());
        this.setResizable(true);
        this.buildUI();
    }
    public TableView builBilanTableView(){
        TableColumn entity = new TableColumn();
        entity.setCellValueFactory(new PropertyValueFactory<BilanTestModel, String>("entity"));
        
        TableColumn<BilanTestModel,Integer> total = new TableColumn<BilanTestModel,Integer>("Total");
        total.setCellValueFactory(new PropertyValueFactory<BilanTestModel, Integer>("total"));
        
        TableColumn totalImportable = new TableColumn("Total importable");
        totalImportable.setCellValueFactory(new PropertyValueFactory<BilanTestModel, Integer>("totalImportable"));
        
        TableColumn totalDoublon = new TableColumn("Total doublon");
        totalDoublon.setCellValueFactory(new PropertyValueFactory<BilanTestModel, Integer>("totalDoublon"));
        
        ObservableList<BilanTestModel> data = FXCollections.observableArrayList(
            new BilanTestModel("Groupe pédagogique",this.dataBaseListe.getGPKeys().size()+this.dataBaseListe.getDoublonGPKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getGpCount(),this.dataBaseListe.getGPKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getGpCount(),this.dataBaseListe.getDoublonGPKeys().size()),
            new BilanTestModel("Candidats",this.dataBaseListe.getCandidatExKeys().size()+this.dataBaseListe.getDoublonCandidatExKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getCandidatCount(),this.dataBaseListe.getCandidatExKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getCandidatCount(),this.dataBaseListe.getDoublonCandidatExKeys().size()),
            new BilanTestModel("Candidats aux poste de jury",this.dataBaseListe.getActeurKeys().size()+this.dataBaseListe.getDoublonActeurKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getActeursCount(),this.dataBaseListe.getActeurKeys().size()-((DatabaseEntity)this.dataBaseListe.getLocalDataBase()).getActeursCount(),this.dataBaseListe.getDoublonActeurKeys().size()+this.dataBaseListe.getDoublonActeurNIPKeys().size())
        );
        
        TableView<BilanTestModel> bilan = new TableView<BilanTestModel>();
        bilan.getColumns().addAll(entity,total,totalImportable,totalDoublon);
        bilan.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        bilan.setItems(data);
        
        
        return bilan;
    }
    public void buildDoublonCandExTableView(){
        this.candidatExKeys = new TableColumn("ID & Téléphone");
        this.candidatEx1 = new TableColumn("Candidat 1");
        this.candidatEx2 = new TableColumn("Candidat 2");
        this.viewDoublonCandidatEx = new TableView();
        this.viewDoublonCandidatEx.getColumns().addAll(FXCollections.observableArrayList(this.candidatExKeys,this.candidatEx1,this.candidatEx2));
        this.viewDoublonCandidatEx.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        this.viewDoublonCandidatEx.getItems().addAll(this.dataBaseListe.getDoublonCandidatExKeys());
        this.viewDoublonCandidatEx.getItems().addAll(this.dataBaseListe.getDoublonCandidatExTelephone());
        this.candidatExKeys.setCellValueFactory(new PropertyValueFactory<Doublon, String>("key"));
        this.candidatEx1.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity1"));
        this.candidatEx2.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity2"));
        
    }
    
    public TableView buildDoublonGPTableView(){
        TableColumn keys = new TableColumn("ID");
        TableColumn gp1 = new TableColumn("Groupe pédagogique 1");
        TableColumn gp2 = new TableColumn("Groupe pédagogique 2");
        TableView gpTableView = new TableView();
        gpTableView.getColumns().addAll(FXCollections.observableArrayList(keys,gp1,gp2));
        gpTableView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        gpTableView.getItems().addAll(this.dataBaseListe.getDoublonGPKeys());
        keys.setCellValueFactory(new PropertyValueFactory<Doublon, String>("key"));
        gp1.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity1"));
        gp2.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity2"));
        return gpTableView;
    }
    
    public TableView buildDoublonActeurTableView(){
        TableColumn keys = new TableColumn("ID & NIP & Matricule");
        TableColumn entity1 = new TableColumn("Acteur 1");
        TableColumn entity2 = new TableColumn("Acteur 2");
        TableView doublonTableView = new TableView();
        doublonTableView.getColumns().addAll(FXCollections.observableArrayList(keys,entity1,entity2));
        doublonTableView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        doublonTableView.getItems().addAll(this.dataBaseListe.getDoublonActeurKeys());
        doublonTableView.getItems().addAll(this.dataBaseListe.getDoublonActeurNIPKeys());
        doublonTableView.getItems().addAll(this.dataBaseListe.getDoublonActeurMatricules());
        keys.setCellValueFactory(new PropertyValueFactory<Doublon, String>("key"));
        entity1.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity1"));
        entity2.setCellValueFactory(new PropertyValueFactory<Doublon, String>("entity2"));
        return doublonTableView;
    }
    
    
    public void buildUI(){//#0096c9
        this.buildDoublonCandExTableView();
        
        HBox titlePane = new HBox();
        titlePane.setMinHeight(40);
        titlePane.getChildren().add(new Label("Resultats de la simulation de fusion"));
        titlePane.setStyle("-fx-border-color:gray");
        titlePane.setAlignment(Pos.CENTER);
        VBox.setMargin(titlePane, new Insets(0,0,10,0));
        
        VBox splitPaneComponent11 = new VBox();
        splitPaneComponent11.getChildren().add(new Label("Statistique de la simulation"));
        splitPaneComponent11.getChildren().add(this.builBilanTableView());
        splitPaneComponent11.setStyle("-fx-border-color:gray");
        VBox.setMargin(splitPaneComponent11, new Insets(10,10,10,10));
        
        VBox splitPaneComponent12 = new VBox();
        splitPaneComponent12.getChildren().add(new Label("Détail des doublons sur les groupes pédagogiques"));
        splitPaneComponent12.getChildren().add(this.buildDoublonGPTableView());
        splitPaneComponent12.setStyle("-fx-border-color:gray");
        VBox.setMargin(splitPaneComponent12, new Insets(10,10,10,10));
        
        
        VBox splitPane1 = new VBox();
        splitPane1.getChildren().add(splitPaneComponent11);
        splitPane1.getChildren().add(splitPaneComponent12);
        
        VBox splitPaneComponent21 = new VBox();
        splitPaneComponent21.getChildren().add(new Label("Détail des doublons sur les candidats"));
        splitPaneComponent21.getChildren().add(this.viewDoublonCandidatEx);
        splitPaneComponent21.setStyle("-fx-border-color:gray");
        VBox.setMargin(splitPaneComponent21, new Insets(10,10,10,10));
        
        VBox splitPaneComponent22 = new VBox();
        splitPaneComponent22.getChildren().add(new Label("Détail des doublons sur les candidats aux postes de jury"));
        splitPaneComponent22.getChildren().add(this.buildDoublonActeurTableView());
        splitPaneComponent22.setStyle("-fx-border-color:gray");
        VBox.setMargin(splitPaneComponent22, new Insets(10,10,10,10));
        
        
        VBox splitPane2 = new VBox();
        splitPane2.getChildren().add(splitPaneComponent21);
        splitPane2.getChildren().add(splitPaneComponent22);
        
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(splitPane1,splitPane2);
        
        VBox pane = new VBox();
        
        pane.getChildren().add(titlePane);
        pane.getChildren().add(splitPane);
        
        //pane.getChildren().add(this.saveBtn);
        this.getDialogPane().setContent(pane);
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        
        Button btn = (Button)this.getDialogPane().lookupButton(ButtonType.CLOSE);
        btn.setText("Fermer");
        /*btn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                if(!validateDialog()){
                    t.consume();
                }
            }

            private boolean validateDialog() {
                if(epreuve == null){
                    return false;
                }
                boolean serieIsSelected = false;
                for(Serie serie : epreuve.getSeries()){
                    if(serie.getCheckbox().isSelected()){
                        serieIsSelected = true;
                    }
                }
                if(!serieIsSelected){
                    return false;
                }
                return true;
            }
            
        });*/
    }
}
