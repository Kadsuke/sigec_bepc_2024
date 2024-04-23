/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
import bf.menapln.controller.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendInscriptionController {
    private CandidatService service;
    
    public BackendInscriptionController() throws SQLException {
        this.service = new CandidatService();
        this.backendSessionController = new BackendSessionController();
    }
    BackendSessionController backendSessionController;
    
    public void validate(HashMap<String, String> formData) throws EmptyDataException {
        Object concoursIdObject = formData.get("concours_id");
        Type concours = (Type) concoursIdObject;
       // System.out.print(concours.getLibelle());
        //zone figée
        if(formData.containsKey("nom") && ((String)formData.get("nom"))== null){
            throw new EmptyDataException("nom non renseigné");
        }
        if(formData.containsKey("prenom") && ((String)formData.get("prenom"))== null){
            throw new EmptyDataException("prenom non renseigné");
        }
        if(formData.containsKey("sexe") && (formData.get("sexe"))== null){
            throw new EmptyDataException("sexe non renseigné");
        }
        if(formData.containsKey("lieuNaissance") && ((String)formData.get("lieuNaissance")).isEmpty()){
            throw new EmptyDataException("lieu de Naissance non renseigné");
        }
        //infos candidats
        if(formData.containsKey("telephone") && ((String)formData.get("telephone")).isEmpty()){
            throw new EmptyDataException("telephone non renseigné ");
        }
        
        if(formData.containsKey("numeroDossier") && ((String)formData.get("numeroDossier")).isEmpty()){
            throw new EmptyDataException("numero de dossier non renseigné ");
        }
        
        if(((String)formData.get("telephone")).length() < 8){
            throw new EmptyDataException("Numéro de téléphone non valide ");
        }
        if(formData.containsKey("centreExamen_id") && (formData.get("centreExamen_id"))==null){
            throw new EmptyDataException("centre d'examen non renseigné ");
        }
        
        if(formData.containsKey("zone_id") && (formData.get("zone_id"))==null){
            throw new EmptyDataException("Zone non renseigné ");
        }
        
        if(formData.containsKey("etablissement_id") && (formData.get("etablissement_id"))==null){
            throw new EmptyDataException("etablissement non renseignée ");
        }
        if(formData.containsKey("typeCandidat_id") && (formData.get("typeCandidat_id"))== null){
            throw new EmptyDataException("Statut non renseigné ");
        }
        
        if(formData.containsKey("typeSituation_id") && (formData.get("typeSituation_id"))== null){
            throw new EmptyDataException("Situation non selectionné");
        }
        if(formData.containsKey("typeInscription_id") && (formData.get("typeInscription_id"))== null){
            throw new EmptyDataException("Type Inscription non selectionnée");
        }
        if(formData.containsKey("concours_id") && (formData.get("concours_id"))==null){
            throw new EmptyDataException("Concours non renseigné ");
        }
        
        if(formData.containsKey("option_id") && (formData.get("option_id"))== null){
            throw new EmptyDataException("Option non selectionnée");
        }
        
        if(formData.containsKey("paysNaissance_id") && (formData.get("paysNaissance_id"))==null){
            throw new EmptyDataException("Pays de Naissance non renseigné ");
        }
                
        if(formData.containsKey("nationalite_id") && (formData.get("nationalite_id"))== null){
            throw new EmptyDataException("Nationalité session activée");
        }
        
        if(formData.containsKey("anneeDernierDiplome") && ((String)formData.get("anneeDernierDiplome")).isEmpty()){
            throw new EmptyDataException("Annee Dernère Diplome non renseigné ");
        }
        
        if(formData.containsKey("numeroActeNaissance") && ((String)formData.get("numeroActeNaissance")).isEmpty()){
            throw new EmptyDataException("Numéro Acte Naissance non renseigné ");
        }
        
        if(formData.containsKey("sport") && ((String)formData.get("sport")).isEmpty()){
            throw new EmptyDataException("sport non renseigné ");
        }
        
        if(formData.containsKey("groupePedagogique") && (formData.get("groupePedagogique"))== null){
            throw new EmptyDataException("groupe Pedagogique non renseigné ");
        }
        
        if((formData.get("typeHandicap"))!= null){
            if((formData.get("natureHandicap"))== null){
                throw new EmptyDataException("Veuillez choisir une nature.");
            }else if((formData.get("natureHandicap"))!= null){
                    if((formData.get("prescription"))== null){
                        throw new EmptyDataException("Veuillez choisir une prescription.");
                    }
            }
        }   
        
        if(formData.containsKey("nomPere") && ((String)formData.get("nomPere")).isEmpty()){
            throw new EmptyDataException("nom du père non renseigné ");
        }

        if(formData.containsKey("prenomPere") && ((String)formData.get("prenomPere")).isEmpty()){
            throw new EmptyDataException("prenom du père non renseigné ");
        }

        if(formData.containsKey("nomMere") && ((String)formData.get("nomMere")).isEmpty()){
            throw new EmptyDataException("nom du mère non renseigné ");
        }

        if(formData.containsKey("prenomMere") && ((String)formData.get("prenomMere")).isEmpty()){
            throw new EmptyDataException("prenom du mère non renseigné ");
        }
        
        if(formData.containsKey("dateNaissance") && ((String)formData.get("dateNaissance")).isEmpty()){
            throw new EmptyDataException("date de Naissance du candidat non rensigné");
        }else{
            Session sess;
            try {
                sess = (Session)backendSessionController.getSessionActive();
                int intValue = Math.toIntExact(sess.getAnnee());
                LocalDate dateDeSession = LocalDate.of(intValue, 12, 31);
                String dateDeNaissanceStr = (String)formData.get("dateNaissance");
                LocalDate dateDeNaissance =  LocalDate.parse(dateDeNaissanceStr);
                //Calcule de l'age
                Period age = Period.between(dateDeNaissance, dateDeSession);
                int ageCondidtion = 0;
                if (dateDeNaissance.getMonthValue() == 12 && dateDeNaissance.getDayOfMonth()==31) {
                    // Age exact du candidat (cas de ceux née en/vers ou le 31/12/YYYY)
                    ageCondidtion = age.getYears();
                } else {
                    // Ceux née avant le 31/12 auront un an de plus apres le 31/12
                    ageCondidtion = age.getYears()+1;
                }
               if(ageCondidtion < 10 || ageCondidtion > 80)  {
                   throw new EmptyDataException("Âge du candidat pas normal");
                }else {
                if(formData.containsKey("concours_id") && concours.getId()== 1){
                    if(formData.containsKey("natureHandicap") && (formData.get("natureHandicap"))==null){
                        if(ageCondidtion >18)  {
                            throw new EmptyDataException("Âge du candidat supérieur à 18 ans. Candidat non éligible à ce concours.");
                        }
                    }else{
                        if(ageCondidtion >20)  {
                            throw new EmptyDataException("Âge du candidat supérieur à 20 ans. Candidat non éligible à ce concours.");
                         }
                    }
                }else if(formData.containsKey("concours_id") && concours.getId()== 2){
                    if(formData.containsKey("natureHandicap") && (formData.get("natureHandicap"))==null){
                        if(ageCondidtion >19)  {
                            throw new EmptyDataException("Âge du candidat supérieur à 19 ans. Candidat non éligible à ce concours.");
                        }
                    }else{
                        if(ageCondidtion >21)  { 
                            throw new EmptyDataException("Âge du candidat supérieur à 21 ans. Candidat non éligible à ce concours.");
                        }
                    }
                }
               }
            } catch (SQLException ex) {
                Logger.getLogger(BackendInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(formData.containsKey("concours_id") && (concours.getId()== 1 || concours.getId()== 2)){
            if(formData.containsKey("choix") && (formData.get("choix"))== null){
                throw new EmptyDataException("Vous dévez faire au moins un choix d'établissement");
            }
        }
        
        
    }

    public List<Objet> changeZone(HashMap formData) throws SQLException, EmptyDataException{
        service.setFormData(formData);
        return this.service.upadteMultipleZone();
    }
    
    
    //Get la liste de toutes les candidats
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
       // return FXCollections.observableArrayList(pays);
    }
    
    //Enregistrement d'une candidat
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException{
        this.validate(formData);
        this.service.setFormData(formData);
        this.service.save();
    }
    
    //Modification d'une candidat
    public void update(HashMap formData) throws SQLException, EmptyDataException{
        this.validate(formData);
        this.service.setFormData(formData);
        this.service.updateCandidat();
    }
    public List<Objet> changeCentre(HashMap formData) throws SQLException, EmptyDataException{
        service.setFormData(formData);
        return this.service.upadteMultipleCentre();
    }
    //Creation ID
    public Long createId() throws SQLException{
        return this.service.createId();
   }
   
    //Suppression Candidat
    public void delete(Objet candidat) throws SQLException, EmptyDataException{
        this.service.delete(candidat);
    }
   
   public int nbreCandidatTotalFille(String filtre) throws SQLException{
       return this.service.nbreCandidatTotalFille(filtre);
   }
   
   public int nbreCandidatTotalGarcon(String filtre) throws SQLException{
       return this.service.nbreCandidatTotalGarcon(filtre);
   }    
}
