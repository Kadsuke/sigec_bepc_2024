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
 * @author kadsuke
 */
public class BackendCentreController {
    private CentreService service;
    
     public BackendCentreController() throws SQLException {
        this.service = new CentreService();
    }
    //Get la liste de toutes les centres
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }

    public List<Objet> getAllSpecial() throws SQLException{
        return this.service.getAllSpecial();
    }
    
   //Enregistrement d'une centre
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    } 
    
    
}
