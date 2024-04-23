package bf.menapln.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.CandidatJuryService;

public class BackendAffectationCandidatController extends BackendController{
    CandidatJuryService service;
    
   public List<Objet> save(HashMap formData) throws SQLException, EmptyDataException{
    this.validate(formData);
    this.service = new CandidatJuryService();
    service.setFormData(formData);
    // service.save();
    return service.saveMultiple();
   }

    @Override
    public void validate(HashMap formData) throws EmptyDataException {
        if(formData.containsKey("jury") && (formData.get("jury")) == null){
            throw new EmptyDataException("Veuillez sélectionnez le jury");
        }   

        if(formData.containsKey("listCandidats") && (formData.get("listCandidats")) == null){
            throw new EmptyDataException("Veuillez  sélectionnez des  candidats à affecter au jury");
        } 
    }
    
    public List<Objet> getAllCandidatJury() throws SQLException{
        this.service = new CandidatJuryService();
        List<Objet> items = this.service.getAllCandidatJury();
        return items;
    }
    public List<Objet> savePV(HashMap formData) throws SQLException, EmptyDataException{
        this.validate(formData);
        this.service = new CandidatJuryService();
        service.setFormData(formData);
        // service.save();
        return service.savePV();
    }
    public boolean deletePV(HashMap formData) throws SQLException, EmptyDataException{
        this.validate(formData);
        this.service = new CandidatJuryService();
        service.setFormData(formData);
        return service.deletePV();
    }
}
