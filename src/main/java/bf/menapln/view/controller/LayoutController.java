/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.sigec.App;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import bf.menapln.entity.Objet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author kadsuke
 */
public class LayoutController implements Initializable{
    
//    private AcceuilInscriptionController aic = new AcceuilInscriptionController();

    @FXML
        private AcceuilInscriptionController acceuilInscriptionController;

    @FXML
        public BorderPane bordeFils; // Correspond à l'ID du BorderPane dans le FXML

    @FXML
        public AnchorPane centerPane; // Correspond à l'ID du AnchorPane dans le FXML
   
    @FXML
    private MenuBar mainMenuBar;

    public LayoutController() {
    }
    


    public BorderPane getBordeFils() {
        return bordeFils;
    }
    
    public void setBordeFils(BorderPane bordeFils) {
        this.bordeFils= bordeFils;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           // List<Menu> menus = menuService.getMenus();

            // Charger les menus dans l'interface utilisateur
            //loadMenus(menus);
            this.openHome();
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @FXML
        public void openPays() throws IOException {
                AnchorPane formPays = FXMLLoader.load(App.class.getResource("pays.fxml"));
                bordeFils.setCenter(formPays);
        }

        @FXML
        public void openStructure() throws IOException {
                AnchorPane formStructure = FXMLLoader.load(App.class.getResource("structure.fxml"));
                bordeFils.setCenter(formStructure);
        }

        @FXML
        public void openLocalite() throws IOException {
                AnchorPane formLocalite = FXMLLoader.load(App.class.getResource("localite.fxml"));
                bordeFils.setCenter(formLocalite);
        }

        @FXML
        public void openEpreuve() throws IOException {
                AnchorPane formEpreuve = FXMLLoader.load(App.class.getResource("epreuve.fxml"));
                bordeFils.setCenter(formEpreuve);
        }
        
        @FXML
        public void openOption() throws IOException {
                AnchorPane formOption = FXMLLoader.load(App.class.getResource("option.fxml"));
                bordeFils.setCenter(formOption);
        }

        @FXML
        public void openEpreuveOptions() throws IOException {
                AnchorPane formEpreuveOptions = FXMLLoader.load(App.class.getResource("epreuveOptions.fxml"));
                bordeFils.setCenter(formEpreuveOptions);
        }

        @FXML
        public void openGroupePedagogique() throws IOException {
                AnchorPane formGroupePedagogique = FXMLLoader.load(App.class.getResource("groupePedagogique.fxml"));
                bordeFils.setCenter(formGroupePedagogique);
        }

        @FXML
        public void openType() throws IOException {
                AnchorPane formType = FXMLLoader.load(App.class.getResource("type.fxml"));
                bordeFils.setCenter(formType);
        }

        @FXML
        public void openSession() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("session.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openNatureHandicap() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("natureHandicap.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openPrescriptionNatureHandicap() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("prescriptionNatureHandicap.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openConcoursSerie() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("serieConcoursRattache.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openCentre() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("centre.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openModalite() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("modalite.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openCritere() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("critere.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openError() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("error.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openAcceuilInscription() throws IOException,NullPointerException{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("acceuilInscription.fxml"));
                BorderPane formAcceuilInscription = loader.load();
                AcceuilInscriptionController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formAcceuilInscription);       
        }

        @FXML
        public void openAcceuilCandidatPoste() throws IOException,NullPointerException{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("acceuilCandidatPosteJury.fxml"));
                BorderPane formAcceuilCandidatPosteJury = loader.load();
                AcceuilCandidatPosteJuryController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formAcceuilCandidatPosteJury);       
        }
        
        @FXML
        public void openCritereModalite() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("critereModalitePoste.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openMiseAJourPonderationModalite() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("modalitePonderation.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openMenu() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("menu.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openUser() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("utilisateur.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openProfil() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("profil.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openProfilMenu() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("profilMenu.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openHome() throws IOException {
                BorderPane formSession = FXMLLoader.load(App.class.getResource("home.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openStatEtablissement() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("statistiqueEtablissement.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openStatProvince() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("statistiqueProvince.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openFusion() throws IOException {
                BorderPane formSession = FXMLLoader.load(App.class.getResource("fusionView.fxml"));
                bordeFils.setCenter(formSession);
        }

        @FXML
        public void openJury() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("jury.fxml"));
                bordeFils.setCenter(formSession);
        }
        @FXML
        public void openCandidatAffectation() throws IOException {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("listCandidatAffecter.fxml"));
                BorderPane formSession = loader.load();
                CandidatAffecterViewController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formSession); 
        }
        @FXML
        public void openListActeurAffecter() throws IOException {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("listActeurAffecter.fxml"));
                BorderPane formSession = loader.load();
                ActeurAffecterViewController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formSession); 
        }
        @FXML
        public void openActeurAffectation() throws IOException {
                AnchorPane formSession = FXMLLoader.load(App.class.getResource("jury.fxml"));
                //AnchorPane formSession = FXMLLoader.load(App.class.getResource("affectationActeur.fxml"));
                bordeFils.setCenter(formSession);
        }
        
        @FXML
        public void openCentreComposition(ActionEvent e) throws IOException, SQLException{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("centreView.fxml"));
                BorderPane formAcceuilInscription = loader.load();
                CentreViewController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formAcceuilInscription); 
        }

        @FXML
        public void openCentreChange(ActionEvent e) throws IOException, SQLException{
               FXMLLoader loader = new FXMLLoader(App.class.getResource("centreChangeForm.fxml"));
               AnchorPane formAcceuilInscription = loader.load();
                CentreChangeController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formAcceuilInscription); 
        }

        @FXML
        public void openZoneChange(ActionEvent e) throws IOException, SQLException{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("zoneChangeForm.fxml"));
                AnchorPane formAcceuilInscription = loader.load();
                ZoneChangeController acceuilController = loader.getController();
                acceuilController.setBorderFils(this.getBordeFils());
                this.getBordeFils().setCenter(formAcceuilInscription); 
        }


        @FXML
        public void openGenerationPV(ActionEvent e) throws IOException, SQLException{
            bordeFils.setCenter(FXMLLoader.load(App.class.getResource("generationPV.fxml")));
        }
    
        
        @FXML
        public void openCentreCompositionForm(ActionEvent e) throws IOException, SQLException{
                bordeFils.setCenter(FXMLLoader.load(App.class.getResource("centreCompositionForm.fxml")));
        }
        
        @FXML
        public void loadMenus(List<bf.menapln.entity.Menu> menus) {
        // Créer et ajouter des éléments de menu à mainMenuBar
        for (bf.menapln.entity.Menu menu : menus) {
            javafx.scene.control.Menu fxMenu = createFxMenu(menu);

           String iconPath = menu.getIcons();

            if (iconPath != null && !iconPath.isEmpty()) {
                // Charger l'icône depuis le chemin récupéré
                
                //Image icon = new Image(iconPath);
                Image icon = new Image(getClass().getResourceAsStream(iconPath));
                //
                // Créer un ImageView avec l'icône chargée
                ImageView iconView = new ImageView(icon);
                // Définir la taille de l'icône si nécessaire
                //pickOnBounds="true" preserveRatio="true"
                iconView.setFitWidth(20);
                iconView.setFitHeight(20);
                iconView.setPickOnBounds(true);
                iconView.setPreserveRatio(true);
                // Définir l'icône sur le menu
                fxMenu.setGraphic(iconView);
            }
            fxMenu.setStyle("-fx-font-size: 14;");
            
            if (menu.getSubMenus()!= null && !menu.getSubMenus().isEmpty()) {
                loadSubMenus(fxMenu, menu.getSubMenus());
            }

            mainMenuBar.getMenus().add(fxMenu);
        }
    }


    private void loadSubMenus(javafx.scene.control.Menu parentMenu, List<bf.menapln.entity.Menu> subMenus) {
        for (bf.menapln.entity.Menu subMenu : subMenus) {
            javafx.scene.control.MenuItem fxSubMenu = new MenuItem(subMenu.getMenuLibelle());

            // Définir le gestionnaire d'événements pour le sous-menu
            fxSubMenu.setOnAction(event -> {
                try {
                    try {
                        handleMenuAction(subMenu);
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                } catch (IOException ex) {
                    Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            parentMenu.getItems().add(fxSubMenu);
        }
    }
    
        private javafx.scene.control.Menu createFxMenu(bf.menapln.entity.Menu menu) {
                javafx.scene.control.Menu fxMenu = new javafx.scene.control.Menu(menu.getMenuLibelle());

                // Autres propriétés à configurer si nécessaire

                return fxMenu;
            }

            private javafx.scene.control.MenuItem createFxMenuItem(bf.menapln.entity.Menu menuItem) {
                javafx.scene.control.MenuItem fxSubMenu = new javafx.scene.control.MenuItem(menuItem.getMenuLibelle());

                // Autres propriétés à configurer si nécessaire

                return fxSubMenu;
            }

        private void handleMenuAction(bf.menapln.entity.Menu menu) throws IOException, SQLException {
            String actionName = menu.getAction();
            if (actionName != null && !actionName.isEmpty()) {
                switch (actionName) {
                case "openPays":
                        openPays();
                break;
                case "openStructure":
                        openStructure();
                break;
                case "openLocalite":
                        openLocalite();
                break;
                case "openEpreuve":
                        openEpreuve();
                break;
                case "openOption":
                        openOption();
                break;
                case "openEpreuveOptions":
                        openEpreuveOptions();
                break;
                case "openGroupePedagogique":
                        openGroupePedagogique();
                break;
                case "openType":
                        openType();
                break;
                case "openSession":
                        openSession();
                break;
                case "openNatureHandicap":
                        openNatureHandicap();
                break;
                case "openPrescriptionNatureHandicap":
                        openPrescriptionNatureHandicap();
                break;
                case "openConcoursSerie":
                        openConcoursSerie();
                break;
                case "openCentre":
                        openCentre();
                break;
                case "openModalite":
                        openModalite();
                break;
                case "openCritere":
                        openCritere();
                break;
                case "openError":
                        openError();
                break;
                case "openAcceuilInscription":
                        openAcceuilInscription();
                break;
                case "openAcceuilCandidatPoste":
                        openAcceuilCandidatPoste();
                break;
                case "openCritereModalite":
                        openCritereModalite();
                break;
                case "openMiseAJourPonderationModalite":
                        openMiseAJourPonderationModalite();
                break;
                case "openMenu":
                        openMenu();
                break;
                case "openUser":
                        openUser();
                break;
                case "openProfil":
                        openProfil();
                break;
                case "openHome":
                        openHome();
                break;
                case "openProfilMenu":
                    openProfilMenu();
                break;
                case "openStatEtablissement":
                    openStatEtablissement();
                break;
                case "openStatProvince":
                    openStatProvince();
                break;
                case "openFusion":
                    openFusion();
                break;
                case "openJury":
                    openJury();
                case "openActeurAffectation":
                    openActeurAffectation();
                break;
                case "openCandidatAffectation":
                    openCandidatAffectation();
                break;
                case "openCentreComposition":
                        openCentreComposition(null);
                break;
                case "openCentreCompositionForm":
                        openCentreCompositionForm(null);
                break;
                case "openListActeurAffecter":
                        openListActeurAffecter();
                break;
                case "openGenerationPV":
                        openGenerationPV(null);
                break;
                case "openCentreChange":
                        openCentreChange(null);
                break;
                case "openZoneChange":
                        openZoneChange(null);
            default:
                    System.out.println("Action non gérée pour le menu : " + actionName);
                }
           }
    // Vérifier si l'action est définie
   
}
}
