package bf.menapln.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BackendCentreCompositionController extends BackendController{
     private CentreCompositionService service;
    
    @Override
    public void validate(HashMap<String,String> formData) throws EmptyDataException{
        
    }
    
    //Get la liste de toutes les structures
    public ObservableList<Object> getAll() throws SQLException{
        this.service = new CentreCompositionService();
        List<Objet> filieres = this.service.getAll("");
        return FXCollections.observableArrayList(filieres);
    }

    //Get la liste de tous les etabs pouvant etre centre de composition
    public ObservableList<Object> getAllEtablissements() throws SQLException{
        this.service = new CentreCompositionService();
        List<Objet> listes = this.service.getAllEtablissements();
        return FXCollections.observableArrayList(listes);
    }
    
    //Enregistrement d'un ou plusieurs centre(s) de compo
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException{
        this.service = new CentreCompositionService();
        this.validate(formData);
        service.setFormData(formData);
        service.saveMultiple();
    }

    //Enregistrement d'un ou plusieurs centre(s) de compo
    public void update(Objet o) throws SQLException{
        this.service = new CentreCompositionService();
        service.update(o);
    }
}
