/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.PaysService;
import bf.menapln.service.TypeService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendTypeController {
    private TypeService service;

     public BackendTypeController() throws SQLException {
        this.service = new TypeService();
    }
    // Get la liste de toutes les types
    public List<Objet> getAll(String valeur) throws SQLException {
        return this.service.getAll(valeur);
        //return FXCollections.observableArrayList(types);
    }

    // Enregistrement d'un type
    public void save(HashMap<String, String> formData) throws SQLException, exception.EmptyDataException {
        this.service.setFormData(formData);
        this.service.save();
    }
}
