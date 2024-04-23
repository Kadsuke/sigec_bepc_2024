/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.EpreuveOptions;
import bf.menapln.entity.*;
import bf.menapln.repository.EpreuveOptionsRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class EpreuveOptionsService extends Service{
    
    public EpreuveOptionsService() throws SQLException{
        super();
        this.implementationDAO = new EpreuveOptionsRepository(this.factory);
    }

    @Override
    public Objet save() throws SQLException, EmptyDataException {
       // this.validate();
        EpreuveOptions epreuveOptions = new EpreuveOptions(this.formData); 
        return this.implementationDAO.save(epreuveOptions);
    
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validate() throws EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Objet> getAllByEpreuve(Epreuve epreuve) throws SQLException{
        return ((EpreuveOptionsRepository)this.implementationDAO).getAllByEpreuve(epreuve);
    }
}
