/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.service.FusionService;
import bf.menapln.view.controller.VueController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author tiere
 */
public class BackendFusionDataController extends VueController{
    
    FusionService service;
    
    public HashMap<String,String> loadFile(String path, String typeFusion) throws SQLException{
        return this.fusionData(path, typeFusion);
    }
    
    public void verification(String path, String typeFusion)throws SQLException{
        String alias = "kadsuke";
        //String[] table = this.listeTable(typeFusion);
        Boolean check = this.checkData(path,typeFusion, alias);
        if(check){
                infoBoxError("Des Erreurs dans vos bases,veuillez verifier le tableau", "Erreur", null);
            }else{
                 infoBoxSuccess("Toutes les données des bases sont ok vous pouvez passer à la validation", "Success", null);
            }
    }
    
    
    public HashMap<String,String> fusionData(String path, String typeFusion){
        HashMap<String,String> baseProblem = new HashMap<>();
      //  String baseProblem = null;
        try {
            this.service = new FusionService();
            String alias = "bepc";
            String[] table = this.listeTable(typeFusion);
            //Boolean check = this.checkData(path,typeFusion, alias);
            //if(check){
                infoBoxError("Des Erreurs dans vos bases,veuillez verifier le tableau", "Erreur", null);
            //}else{
                this.loadData(path, alias, table);
            //}
        } catch (SQLException ex) {
            baseProblem.put(path, ex.getMessage());
            //infoBoxError("Des erreurs ont été rencontrées,veuillez verifier dans le tableau", "Erreur", null);
           // Logger.getLogger(BackendFusionDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baseProblem;
    }

    public String[] listeTable(String typeFusion){
        String[] tab = null;
        switch (typeFusion) {
            case "Etablissement":
                String[] tabEtab = {"candidat","inscription","choixCandidat","dispense"};
                tab=tabEtab;
            break;
            case "Provinciale":
                String[] tabDP = {"groupePedagogique","candidat","inscription","candidatPosteJury","choixCandidat","critereCandidatPosteJury","epreuveCandidatPosteJury"};
                tab=tabDP;
            break;
            case "Régionale":
                String[] tabDR = {"groupePedagogique","candidat","candidatPosteJury","Centre","choixCandidat","critereCandidatPosteJury","dispense","epreuveCandidatPosteJury","inscription","personnel","user"};
                tab=tabDR;
            break;
            default:
                String[] tabCent = {"groupePedagogique","candidat","candidatPosteJury","Centre","choixCandidat","critereCandidatPosteJury","epreuveCandidatPosteJury","inscription","dispense","personnel","user"};
                tab=tabCent;
        }
        return tab;
    }
    
    
    public Boolean checkData(String path, String typeFusion, String alias){
        try {
            this.service = new FusionService();
        } catch (SQLException ex) {
            infoBoxError(ex.getMessage(),"Erreur", null);
        }
        String[] tab = null;
        Boolean verifier = true;
        HashMap<String,Long> dataImport = new HashMap<>();
        switch (typeFusion) {
            case "Etablissement":
                String[] tabEtab = {"candidat","inscription","choixCandidat","dispense"};
                tab=tabEtab;
            break;
            case "Provinciale":
                String[] tabDP = {"groupePedagogique","candidat","inscription","candidatPosteJury","choixCandidat","critereCandidatPosteJury","epreuveCandidatPosteJury"};
                tab=tabDP;
            break;
            case "Régionale":
                String[] tabDR = {"groupePedagogique","candidat","candidatPosteJury","Centre","choixCandidat","critereCandidatPosteJury","dispense","epreuveCandidatPosteJury","inscription","personnel","user"};
                tab=tabDR;
            break;
            default:
                String[] tabCent = {"groupePedagogique","candidat","candidatPosteJury","Centre","choixCandidat","critereCandidatPosteJury","epreuveCandidatPosteJury","inscription","dispense","personnel","user"};
                tab=tabCent;
        }
        
        for(int i=0; i<tab.length; i++){
            try {
                Long valeur = null;
                valeur = this.service.verifierUnicity(path,alias, tab[i]);
                //dataImport.put(tab[i], valeur);
                if(valeur==0){
                    verifier = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BackendFusionDataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return verifier;
    }
    
    /*private String formatDataForDialog(HashMap<String, Long> dataImport) {
        StringBuilder formattedData = new StringBuilder();
        for (Map.Entry<String, Long> entry : dataImport.entrySet()) {
            formattedData.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return formattedData.toString();
    }*/
    
    public void loadData(String path, String alias, String[] table) throws SQLException{        
        this.service = new FusionService();
        this.service.loadData(path,alias, table);
    }
}
