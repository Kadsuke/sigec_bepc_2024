/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
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
public class BackendModaliteController {
    private ModaliteService service;
    
    public BackendModaliteController() throws SQLException {
        this.service = new ModaliteService();
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
}
