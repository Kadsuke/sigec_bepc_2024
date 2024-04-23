/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.view.dialog;

import bf.menapln.view.controller.VueController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author coulibaly
 */
public class TextInputDialogue extends Dialog<String>{
    private String content;
    private TextField field;
    private VueController controller;
    
    public TextInputDialogue(String title,String header, String content,VueController controller){
        this.setTitle(title);
        this.setHeaderText(header);
        this.content = content;
        this.controller = controller;
        this.buildUI();
        this.setResultConverter();
    }
    
    public void buildUI(){
        VBox pane = new VBox();
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox pane1 = new VBox();
        
        Label contentLabel = new Label(this.content);
        this.field = new TextField();
        this.field.setPrefHeight(35);
        this.field.setPrefWidth(200);
       // this.controller.textFormat(this.field, true);
        pane1.getChildren().add(contentLabel);
        pane1.getChildren().add(this.field);
        
        pane.getChildren().add(pane1);
        
        this.getDialogPane().setContent(pane);
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        this.getDialogPane().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Button btn = (Button)this.getDialogPane().lookupButton(ButtonType.OK);
        btn.setText("Enregistrer");
        btn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                if(!validateDialog()){
                    t.consume();
                }
            }

            private boolean validateDialog() {
                if(field.getText().isEmpty()){
                    return false;
                }
                return true;
            }
            
        });
    }
    
    public void setResultConverter(){
        Callback<ButtonType,String> result = new Callback<ButtonType,String>(){
            @Override
            public String call(ButtonType p) {
                if(p == ButtonType.OK){
                    return field.getText();
                }else{
                    return null;
                }
            }
            
        };
        setResultConverter(result);
        //System.out.println(result.);
    }
    
    public void setPropertyBindings(){
        
    }
    
}
