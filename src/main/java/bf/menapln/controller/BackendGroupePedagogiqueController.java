/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.GroupePedagogiqueService;
import bf.menapln.service.PaysService;
import bf.menapln.service.SessionService;
import bf.menapln.service.StructureService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class BackendGroupePedagogiqueController {
    private GroupePedagogiqueService service;
    
    public BackendGroupePedagogiqueController() throws SQLException {
        this.service = new GroupePedagogiqueService();
    }
    //Get la liste de toutes les Groupe Pedagogique
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
    public List<Objet> getAllGroupePedagogique() throws SQLException{
        return this.service.getAllGroupePedagogique();
    }
    
    public List<Objet> getAllByEtab(String etab) throws SQLException{
        return this.service.getByEtabId(etab);
    }
    
    public Long createId() throws SQLException{
        return this.service.createId();
   }
    
    
    //Enregistrement d'un pays
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        this.service.setFormData(formData);
        this.service.save();
    }
    
    public Objet delete (Objet objet) throws SQLException{
        return this.service.delete(objet);
    }
    
    public Objet update (Objet objet) throws SQLException{
        return this.service.update(objet);
    }
}
