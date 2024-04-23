/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.repository.StatistiqueRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tiere
 */
public class StatistiqueService extends Service{

    public StatistiqueService() throws SQLException{
        super();
        this.implementationDAO = new StatistiqueRepository(this.factory);
    }
    
 
    public List<Objet> getExDBAllStatistiqueByCentre(Connection con) throws SQLException {
        StatistiqueRepository repository = new StatistiqueRepository(this.factory);
        return repository.getAllStatistiqueByCentre();
    }
    
  
     public List<Objet> getExDBAllStatistiqueByEtab(Connection con) throws SQLException {
        StatistiqueRepository repository = new StatistiqueRepository(this.factory);
        return repository.getAllStatistiqueByEtab();
    }
    
    public List<Objet> getExDBAllStatistiqueActeurByEtab(Connection con) throws SQLException {
        StatistiqueRepository repository = new StatistiqueRepository(this.factory);
        return repository.getAllStatistiqueActeurByEtab();
    }
    
    //Etab
    
    public List<Objet> getAllStatistiqueEtabByOption() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueEtabByOption();
    }
    
    public List<Objet> getAllStatistiqueEtabBySituation() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueEtabBySituation();
    }
    
    public List<Objet> getAllStatistiqueByEtab() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueByEtab();
    }
    
    public List<Objet> getAllStatistiqueActeurByEtab() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueActeurByEtab();
    }
      
      public List<Objet> getAllStatistiqueEtabByHandicap() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueEtabByHandicap();
    }
      
    //Province
    public List<Objet> getAllStatistiqueProvinceByOption() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueProvinceByOption();
    }
    
    public List<Objet> getAllStatistiqueProvinceBySituation() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueProvinceBySituation();
    }
    
    public List<Objet> getAllStatistiqueByProvince() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueByProvince();
    }
    
    public List<Objet> getAllStatistiqueActeurByProvince() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueActeurByProvince();
    }
      
    public List<Objet> getAllStatistiqueProvinceByHandicap() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueProvinceByHandicap();
    }
    //Region
    public List<Objet> getAllStatistiqueRegionByOption() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueRegionByOption();
    }
    
    public List<Objet> getAllStatistiqueRegionBySituation() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueRegionBySituation();
    }
    
    public List<Objet> getAllStatistiqueByRegion() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueByRegion();
    }
    
    public List<Objet> getAllStatistiqueActeurByRegion() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueActeurByRegion();
    }
      
    public List<Objet> getAllStatistiqueRegionByHandicap() throws SQLException {
        return ((StatistiqueRepository)this.implementationDAO).getAllStatistiqueRegionByHandicap();
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

    @Override
    public Objet save() throws SQLException, exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validate() throws exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
