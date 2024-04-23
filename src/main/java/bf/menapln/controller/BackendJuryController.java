package bf.menapln.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.JuryService;

public class BackendJuryController extends BackendController{
    JuryService service;
    
   public void save(HashMap formData) throws SQLException, EmptyDataException{
    this.validate(formData);
    this.service = new JuryService();
    service.setFormData(formData);
    service.save();
   }

    @Override
    public void validate(HashMap formData) throws EmptyDataException {
        if(formData.containsKey("juryLibelle") && ((String)formData.get("juryLibelle")).isEmpty()){
            throw new EmptyDataException("Veuillez saisir le nom du jury");
        }   

        if(formData.containsKey("CentreExamen_id") && ((String)formData.get("CentreExamen_id")) == null){
            throw new EmptyDataException("Veuillez choisir le centre d'examen");
        } 
    }
    
    public List<Objet> getAll() throws SQLException{
        this.service = new JuryService();
        List<Objet> items = this.service.getAll("");
        return items;
    }

    public Objet delete (Objet objet) throws SQLException{
        return this.service.delete(objet);
    }

    public Objet update (Objet objet) throws SQLException{
        return this.service.update(objet);
    }

    
}
