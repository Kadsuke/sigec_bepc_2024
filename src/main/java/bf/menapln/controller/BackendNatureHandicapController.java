/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.LocaliteService;
import bf.menapln.service.NatureHandicapService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendNatureHandicapController {
    private NatureHandicapService service;
    
    public BackendNatureHandicapController() throws SQLException {
        this.service = new NatureHandicapService();
    }
    //Get la liste de toutes les localités
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
      //  return FXCollections.observableArrayList(natureHandicap);
}
    //Get la liste de toutes les localités
    public List<Objet> getAllByType(Type handicap) throws SQLException{
        return this.service.getByTypeHandicap(handicap);
       // return FXCollections.observableArrayList(natureHandicap);
}
    
   //Enregistrement d'une Nature Handicape
    public void save(HashMap formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    } 
}
