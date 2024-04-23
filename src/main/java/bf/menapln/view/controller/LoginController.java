/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.controller.BackendLoginController;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.sigec.App;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kadsuke
 */
public class LoginController extends VueController implements Initializable {
 @FXML
public TextField identifiantField; 

@FXML
public PasswordField mdpField;



public LoginController() throws SQLException {
        this.backendLoginController = new BackendLoginController();        
    }
     
        BackendLoginController backendLoginController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  updateEyeImage();
    }    
    
    
    
    
    public void onActionConnect() throws Exception{
     try {
         HashMap formData = new HashMap();
         String motDePasseHashed = this.encrypte(this.charArrToSTring(mdpField.getText().toCharArray()));
         formData.put("username", identifiantField.getText());
         formData.put("pwd", motDePasseHashed);
         Objet objet = backendLoginController.connect(formData);
        // infoBoxSuccess("Connecté avec succès", "Succès", null);
         identifiantField.clear();
         mdpField.clear();
         this.fermerFenetreDeConnexion();
         this.chargerPageAccueil(objet); 
     } catch (SQLException ex) {
         infoBoxError(ex.getMessage(), "Erreur", null);
     } catch (EmptyDataException ex) {
         
         infoBoxError(ex.getMessage(), "Erreur", null);
     } catch (exception.EmptyDataException ex) {
         infoBoxError(ex.getMessage(), "Erreur", null);
     }
     catch (Exception ex) {
         infoBoxError(ex.getMessage(), "Erreur", null);
     }
    }
   
    private void fermerFenetreDeConnexion() {
        // Obtenez la scène actuelle et fermez sa fenêtre parente
        Stage stage = (Stage) identifiantField.getScene().getWindow();
        stage.close();
    }
    
    private void chargerPageAccueil(Objet objet) throws IOException {
        List<Menu> menu = ((Profil)objet).getMenus();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("layout.fxml"));
        Parent accueil = loader.load();
        LayoutController accueilController = loader.getController();
        accueilController.loadMenus(menu);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        // Afficher la page d'accueil dans une nouvelle fenêtre
        Stage accueilStage = new Stage();
        accueilStage.setX(bounds.getMinX());
        accueilStage.setY(bounds.getMinY());
        accueilStage.setWidth(bounds.getWidth());
        accueilStage.setHeight(bounds.getHeight());
        // AccueilController peut être votre contrôleur pour la page d'accueil
        //accueilStage.setTitle(sessionManager.getUser().getUsername());
        accueilStage.setScene(new Scene(accueil));
        //accueilStage.setResizable(false);
        accueilStage.show();
    }

    
    
}
