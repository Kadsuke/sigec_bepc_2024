/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Epreuve;
import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.EpreuveOptionsService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendEpreuveOptionsController {
   
     private EpreuveOptionsService service;
    public BackendEpreuveOptionsController() throws SQLException {
        this.service = new EpreuveOptionsService();
    }
    //Get la liste de toutes les epreuves options
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
    public List<Objet> getAllByEpreuve(Epreuve epreuve) throws SQLException{
        return this.service.getAllByEpreuve(epreuve);
    }
    
    //Enregistrement d'une association
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
}
