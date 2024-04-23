/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Epreuve;
import bf.menapln.entity.Objet;
import bf.menapln.repository.EpreuveRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class EpreuveService extends Service{
    public EpreuveService() throws SQLException{
        super();
        this.implementationDAO = new EpreuveRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException, EmptyDataException {
        //this.validate();
        Epreuve epreuve = new Epreuve(this.formData); 
        return this.implementationDAO.save(epreuve);
     
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getByParentNull() throws SQLException {
        return ((EpreuveRepository)this.implementationDAO).getEpreuveWithNoParent();
    }
    
    @Override
    public void validate() throws EmptyDataException {
        
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    //public List<Objet> getBy
}
