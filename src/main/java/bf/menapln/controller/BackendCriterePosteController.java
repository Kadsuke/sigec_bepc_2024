/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendCriterePosteController {
    private CriterePosteService service;
    
    public BackendCriterePosteController() throws SQLException {
        this.service = new CriterePosteService();
    }
    //Get la liste de toutes les critères
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
    public Objet getByPoste(Type poste) throws SQLException{
        return this.service.getAllByPoste(poste);
    }
    
     public Objet getAllByPosteAndCritere(Type poste,Critere crit) throws SQLException{
        return this.service.getAllByPosteAndCritere(poste,crit);
    }
    
    //Enregistrement d'un critere
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    public void update(Objet objet) throws SQLException, EmptyDataException{
        //this.validate(formData);
       // this.service.setFormData(formData);
        this.service.update(objet);
    }
    
}
