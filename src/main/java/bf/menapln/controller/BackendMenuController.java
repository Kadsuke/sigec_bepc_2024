/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.service.*;
import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendMenuController {
    private MenuService service;
    
     public BackendMenuController() throws SQLException {
        this.service = new MenuService();
    }
    //Get la liste de toutes les centres
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
   //Enregistrement d'une centre
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    } 
    
    
}
