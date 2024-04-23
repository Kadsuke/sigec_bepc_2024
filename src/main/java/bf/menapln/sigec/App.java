package bf.menapln.sigec;

import bf.menapln.entity.Objet;
import bf.menapln.service.Service;
import bf.menapln.service.SessionService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Objet selectedItem = null;
    private static List liste = null;
    private static String listeSource = null;
     private static Stage frame;
    private BorderPane container;
    private BorderPane content;

    @Override
    public void start(Stage stage) throws IOException {
       
        try {
            SessionService userservice = new SessionService();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
             scene = new Scene(loadFXML("login"));
            // scene = new Scene(loadFXML("miseAJour"));
              stage.setResizable(false);
              stage.setScene(scene);
              stage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    
    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        App.scene = scene;
    }

    
    public BorderPane getContent(){
        return this.content;
    }
    
    public BorderPane getContainer(){
        return this.container;
    }

    public static Objet getSelectedItem() {
        return App.selectedItem;
    }

    public static void setSelectedItem(Objet selectedItem) {
        App.selectedItem = selectedItem;
    }

    public static Stage getFrame() {
        return frame;
    }

    public void setFrame(Stage frame) {
        this.frame = frame;
    }

    public static List getListe() {
        return liste;
    }

    public static void setListe(List liste) {
        App.liste = liste;
    }

    public static String getListeSource() {
        return listeSource;
    }

    public static void setListeSource(String listeSource) {
        App.listeSource = listeSource;
    }
    
}