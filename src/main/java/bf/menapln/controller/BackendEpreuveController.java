/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.EpreuveService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendEpreuveController {
     private EpreuveService service;
     
    public BackendEpreuveController() throws SQLException {
        this.service = new EpreuveService();
    }
    //Get la liste de toutes les epreuves
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
        //return FXCollections.observableArrayList(epreuve);
    }
    
    //Enregistrement d'un epreuve
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    public List<Objet> getAllByParentIsNull() throws SQLException{
        return this.service.getByParentNull();
    }
    
}
