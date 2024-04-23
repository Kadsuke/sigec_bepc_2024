/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.PaysService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author LENOVO
 */
public class BackendPaysController {
    private PaysService service;
    
    public BackendPaysController() throws SQLException {
        this.service = new PaysService();
    }
    //Get la liste de toutes les pays
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
        //return FXCollections.observableArrayList(pays);
    }
    
    //Enregistrement d'un pays
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    @FXML
    public List<Objet> getAllNationalite() throws SQLException{
        List<Objet> listePays = this.service.getAll("");
        List<Objet> liste = new ArrayList<>();
        for(Object pays : listePays){
            Pays natio = new Pays();
            natio.setPaysToString(false);
            natio.setId(((Pays)pays).getId());
            natio.setNationalite(((Pays)pays).getNationalite());
            liste.add(natio);
        }
        return liste;
    }

}
