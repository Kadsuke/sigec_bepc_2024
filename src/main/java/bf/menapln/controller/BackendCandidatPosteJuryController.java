/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.*;
import bf.menapln.service.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendCandidatPosteJuryController {
private CandidatPosteJuryService service;
    
    public BackendCandidatPosteJuryController() throws SQLException {
        this.service = new CandidatPosteJuryService();
    }
    
    public void validateUpdate(HashMap<String, String> formData) throws EmptyDataException {
        if(formData.containsKey("localite") && (formData.get("localite"))== null){
            throw new EmptyDataException("localite non renseigné");
        }
        if(formData.containsKey("structure") && (formData.get("structure"))== null){
            throw new EmptyDataException("structure non renseigné");
        }
        if(formData.containsKey("matricule") && ((String)formData.get("matricule")).isEmpty()){
            throw new EmptyDataException("matricule non renseigné");
        }
        if(formData.containsKey("nom") && ((String)formData.get("nom")).isEmpty()){
            throw new EmptyDataException("nom non renseigné");
        }
        if(formData.containsKey("prenom") && ((String)formData.get("prenom")).isEmpty()){
            throw new EmptyDataException("prenom non renseigné");
        }
        if(formData.containsKey("sexe") && (formData.get("sexe"))== null){
            throw new EmptyDataException("sexe non renseigné");
        }
        if(formData.containsKey("telephone") && ((String)formData.get("telephone")).isEmpty()){
            throw new EmptyDataException("telephone non renseigné ");
        }
        
        if(((String)formData.get("telephone")).length() < 8){
            throw new EmptyDataException("Numéro de téléphone non valide ");
        }
        
        if(formData.containsKey("nip") && ((String)formData.get("nip")).isEmpty()){
            throw new EmptyDataException("nip non renseigné ");
        }
        
        if(((String)formData.get("nip")).length() < 17){
            throw new EmptyDataException("NIP non valide ");
        }
        
        
    }
    
    public void validate(HashMap<String, String> formData) throws EmptyDataException {
        if(formData.containsKey("localite") && (formData.get("localite"))== null){
            throw new EmptyDataException("localite non renseigné");
        }
        if(formData.containsKey("structure") && (formData.get("structure"))== null){
            throw new EmptyDataException("structure non renseigné");
        }
        if(formData.containsKey("matricule") && ((String)formData.get("matricule")).isEmpty()){
            throw new EmptyDataException("matricule non renseigné");
        }
        if(formData.containsKey("nom") && ((String)formData.get("nom")).isEmpty()){
            throw new EmptyDataException("nom non renseigné");
        }
        if(formData.containsKey("prenom") && ((String)formData.get("prenom")).isEmpty()){
            throw new EmptyDataException("prenom non renseigné");
        }
        if(formData.containsKey("sexe") && (formData.get("sexe"))== null){
            throw new EmptyDataException("sexe non renseigné");
        }
        if(formData.containsKey("telephone") && ((String)formData.get("telephone")).isEmpty()){
            throw new EmptyDataException("telephone non renseigné ");
        }
        
        if(((String)formData.get("telephone")).length() < 8){
            throw new EmptyDataException("Numéro de téléphone non valide ");
        }
        
        if(formData.containsKey("nip") && ((String)formData.get("nip")).isEmpty()){
            throw new EmptyDataException("nip non renseigné ");
        }
        
        if(((String)formData.get("nip")).length() < 17){
            throw new EmptyDataException("NIP non valide ");
        }
        
        if((formData.get("choixCritereModalite")) == null){
            throw new EmptyDataException("Veuillez choisir les critères liés au candidat");
        }   
        
    } 
    //Get la liste de toutes les candidat poste jury
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
       // return FXCollections.observableArrayList(candidat);
    }
    
    //Enregistrement d'un candidat poste jury
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.validate(formData);
        this.service.setFormData(formData);
        this.service.save();
    }
    
    //Enregistrement d'un candidat poste jury
    public void update(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.validateUpdate(formData);
        this.service.setFormData(formData);
        this.service.updateCandidat();
    }
    
    //Suppression Candidat
    public void delete(Objet candidatPosteJury) throws SQLException, EmptyDataException{
        this.service.delete(candidatPosteJury);
    }
    
}
