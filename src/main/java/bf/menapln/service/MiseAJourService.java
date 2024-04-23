/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import bf.menapln.repository.*;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class MiseAJourService extends Service {
    public MiseAJourService() throws SQLException{
        super();
        this.implementationDAO = new MiseAJourRepository(this.factory);
    }
    
    public Boolean saveLocalite() throws SQLException{
        this.implementationDAO = new MiseAJourRepository(this.factory);
        return ((MiseAJourRepository)this.implementationDAO).saveLocalite();
    }

    public Boolean saveEtablissement() throws SQLException{
        this.implementationDAO = new MiseAJourRepository(this.factory);
        return ((MiseAJourRepository)this.implementationDAO).saveEtablissement();
    }
    
    public Boolean saveDirection() throws SQLException{
        this.implementationDAO = new MiseAJourRepository(this.factory);
        return ((MiseAJourRepository)this.implementationDAO).saveDirection();
    }
    
    public Boolean updateDatabase() throws SQLException{
        this.implementationDAO = new MiseAJourRepository(this.factory);
        return ((MiseAJourRepository)this.implementationDAO).updateDatabase();
    }
    
    
    
    
    
    
    
    
    
    @Override
    public Objet save() throws SQLException {
        Critere critere = new Critere(this.formData);
        this.implementationDAO.save(critere);
        return critere;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    


    @Override
    public void setImplementation(String str) {
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

    @Override
    public void validate() throws exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
