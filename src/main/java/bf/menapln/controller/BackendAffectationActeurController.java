package bf.menapln.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.MembreService;

public class BackendAffectationActeurController extends BackendController{
    MembreService service;
    
   public List<Objet> save(HashMap formData) throws SQLException, EmptyDataException{
    this.validate(formData);
    this.service = new MembreService();
    service.setFormData(formData);
    // service.save();
    return service.saveMultiple();
   }

    @Override
    public void validate(HashMap formData) throws EmptyDataException {
        if(formData.containsKey("jury") && (formData.get("jury")) == null){
            throw new EmptyDataException("Veuillez sélectionnez le jury");
        }   

        if(formData.containsKey("listActeurs") && (formData.get("listActeurs")) == null){
            throw new EmptyDataException("Veuillez  sélectionnez des  acteurs à affecter au jury");
        } 
    }
    
    public List<Objet> getAllMembreJury() throws SQLException{
        this.service = new MembreService();
        List<Objet> items = this.service.getAllMembreJury();
        return items;
    }
}
