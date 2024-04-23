/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.GroupePedagogiqueService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendLocaliteController {
    private LocaliteService service;
    
     public BackendLocaliteController() throws SQLException {
        this.service = new LocaliteService();
    }
    //Get la liste de toutes les localités
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
        //return FXCollections.observableArrayList(localite);
    
    }
    
    public List<Objet> getAllByType(String type) throws SQLException{
        return this.service.getAll(type);
        //return FXCollections.observableArrayList(localite);
    
    }
    
   //Enregistrement d'une localité
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    } 
    
    public List<Objet> getAll(String typeLocalite) throws SQLException{
        return this.service.getAll(typeLocalite);
       // return FXCollections.observableArrayList(localites);
    }
    
    public List<Objet> getAllByParent(String parent) throws SQLException{
        return this.service.getByParentId(parent);
        //return FXCollections.observableArrayList(localites);
    }
    
    public List<Objet> getAllByTypeAndParent(String parent,String type) throws SQLException{
        return this.service.getByTypeLocalite(parent, type);
        //return FXCollections.observableArrayList(localites);
    }
    
    public List<Objet> getAllCommune(Localite parent) throws SQLException{
        return this.service.getCommune(parent);
        //return FXCollections.observableArrayList(localites);
    }
    
     public List<Objet> getAllCentre(Localite parent) throws SQLException{
        return this.service.getCentre(parent);
        //return FXCollections.observableArrayList(localites);
    }
     
     public List<Objet> getAllCentreExam(Localite parent) throws SQLException{
        return this.service.getCentreExam(parent);
        //return FXCollections.observableArrayList(localites);
    }
     
     public List<Objet> getAllCentreExamen() throws SQLException{
        return this.service.getCentreExamen();
        //return FXCollections.observableArrayList(localites);
    }
    
}
