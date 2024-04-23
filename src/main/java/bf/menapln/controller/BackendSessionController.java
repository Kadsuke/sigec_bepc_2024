/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.SessionService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendSessionController {
    private SessionService service;
    
    public BackendSessionController() throws SQLException {
        this.service = new SessionService();
    }
    //Get la liste de toutes les filières
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
        //return FXCollections.observableArrayList(session);
    }
    
    //Enregistrement d'une filière
    public void save(HashMap<String,String> formData) throws SQLException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    public Objet getSessionActive() throws SQLException{
       return this.service.getActiveSession();
    }
}
