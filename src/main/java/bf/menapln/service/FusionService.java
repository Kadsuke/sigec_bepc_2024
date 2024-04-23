/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.repository.FusionRepository;
import java.sql.SQLException;
import java.util.List;
import javafx.concurrent.Task;

/**
 *
 * @author kadsuke
 */
public class FusionService extends Service{

    public FusionService() throws SQLException{
        super();
        this.implementationDAO = new FusionRepository(this.factory);
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Long verifierData(String path,String alias,String table) throws SQLException{
        FusionRepository fusionRepo = new FusionRepository(factory);
        return fusionRepo.verifierData(path,alias,table);
    }
    
    public Long verifierUnicity(String path,String alias,String table) throws SQLException{
        FusionRepository fusionRepo = new FusionRepository(factory);
        return fusionRepo.checkEveryData(path,alias,table);
    }
    
    public void loadData(String path,String alias,String[] table) throws SQLException{
        FusionRepository fusionRepo = new FusionRepository(factory);
        fusionRepo.loadData( path, alias, table);
    }

    @Override
    public Objet save() throws SQLException, exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validate() throws exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
