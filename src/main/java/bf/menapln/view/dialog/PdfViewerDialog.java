/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.view.dialog;

import bf.menapln.reporting.PDF;
import bf.menapln.sigec.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author tiere
 */
public class PdfViewerDialog extends Dialog<PDF>{
    private PDF dataBaseListe;
    
    public PdfViewerDialog(PDF dbliste){
        this.dataBaseListe = dbliste;
        this.setTitle("Visionneur PDF");
        //this.setWidth(App.getScene().getWidth()+500);
        //this.setWidth(App.getScene().getHeight()+100);
        //this.initOwner(App.getFrame());
        this.buildUI();
    }
    
    public void buildUI(){//#0096c9
        
//        HBox titlePane = new HBox();
//        titlePane.setMinHeight(40);
//        titlePane.getChildren().add(new Label("Visionneur de PDF"));
//        titlePane.setStyle("-fx-border-color:gray");
//        titlePane.setAlignment(Pos.CENTER);
//        VBox.setMargin(titlePane, new Insets(0,0,0,0));
        
        VBox splitPaneComponent11 = new VBox();
        splitPaneComponent11.getChildren().removeAll(splitPaneComponent11.getChildren()); 
        splitPaneComponent11.getChildren().add(PDF.pdfViewer(this.dataBaseListe));
        splitPaneComponent11.setStyle("-fx-border-color:gray");
        VBox.setMargin(splitPaneComponent11, new Insets(5,5,5,5));
        
        VBox splitPane1 = new VBox();
        splitPane1.getChildren().add(splitPaneComponent11);
        
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(splitPane1);

        VBox pane = new VBox();
        
        pane.setMinHeight(650);
        pane.setMinWidth(950);
        //pane.getChildren().add(titlePane); 
        pane.getChildren().add(splitPane);

        this.getDialogPane().setContent(pane);
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        
        Button btn = (Button)this.getDialogPane().lookupButton(ButtonType.CLOSE);
        btn.setText("Fermer");
    }
}