/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendCentreCompositionController;
import bf.menapln.controller.BackendJuryController;
import bf.menapln.controller.BackendLocaliteController;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Jury;
import bf.menapln.entity.UserSession;
import exception.EmptyDataException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author coulibaly
 */
public class JuryFormViewController extends VueController implements Initializable {
    @FXML
    public TextField quantumField;
    
    @FXML
    public TextField minField;
    
    @FXML
    public TextField maxField;
    
   @FXML
   public TableView<Centre> dataTable;
   
   @FXML
   public TableColumn<Centre,String> regionCol;
   
   @FXML
   public TableColumn<Centre,String> provinceCol;
   
   @FXML
   public TableColumn<Centre,String> centreCol;
   
   @FXML
   public TableColumn<Centre,Integer> effectifCol;
   
   @FXML
   public TableColumn<Centre,Integer> nombreJuryCol;
   
   //Jury
   
   @FXML
   public TableView<Jury> DataTableJury;
   
   @FXML
   public TableColumn<Jury,String> juryCol;
   
   @FXML
   public TableColumn<Jury,String> centreCompoCol;
   
   @FXML
   public TableColumn<Jury,String> centreExamenCol;
   
   @FXML
   public TableColumn<Jury,String> provinceJuryCol;
   
   @FXML
   public TableColumn<Jury,String> regionJuryCol;
   
    
    
    public JuryFormViewController() throws SQLException{
        ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    

   
    
}
