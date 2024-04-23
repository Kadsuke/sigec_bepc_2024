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
public class BackendCritereController {
    private CritereService service;
    
    public BackendCritereController() throws SQLException {
        this.service = new CritereService();
    }
    //Get la liste de toutes les critères
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
    public Objet getByPoste(Type poste) throws SQLException{
        return this.service.getAllByPoste(poste);
    }
    //Enregistrement d'un critere
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
}
