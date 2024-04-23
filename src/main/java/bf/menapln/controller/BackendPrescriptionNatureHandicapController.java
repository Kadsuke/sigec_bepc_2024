/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.NatureHandicapService;
import bf.menapln.service.PrescriptionNatureHandicapService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendPrescriptionNatureHandicapController {
    private PrescriptionNatureHandicapService service;
    
    public BackendPrescriptionNatureHandicapController() throws SQLException {
        this.service = new PrescriptionNatureHandicapService();
    }
    //Get la liste de toutes les localités
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
        //return FXCollections.observableArrayList(prescriptionNatureHandicap);
    
}
    
   //Enregistrement d'une Prescription Nature Handicape
    public void save(HashMap formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    public List<Objet> getByNatureHandicap(NatureHandicap natureHandicap) throws SQLException{
        return this.service.getByNatureHandicap(natureHandicap);
    
} 
}
