/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Objet;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.StatistiqueService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tiere
 */
public class BackendStatistiqueController extends BackendController{

    StatistiqueService service;
    public BackendStatistiqueController() throws SQLException{
        super();
        this.service = new StatistiqueService();
    }
    @Override
    public void validate(HashMap<String, String> formData) throws EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
    public List<Objet> getExDBAllStatistiqueByCentre(Connection con) throws SQLException {
        return this.service.getExDBAllStatistiqueByCentre(con);
    }

    //Ajouter Dernierement
    public List<Objet> getExDBAllStatistiqueActeurByEtab(Connection con) throws SQLException {
        return this.service.getExDBAllStatistiqueActeurByEtab(con);
    }
    
    public List<Objet> getExDBAllStatistiqueByEtab(Connection con) throws SQLException {
        return this.service.getExDBAllStatistiqueByEtab(con);
    }
    
    // Etab
    public List<Objet> getAllStatistiqueByEtab() throws SQLException {
        return this.service.getAllStatistiqueByEtab();
    }
    
     public List<Objet> getAllStatistiqueActeurByEtab() throws SQLException {
        return this.service.getAllStatistiqueActeurByEtab();
    }
     
     public List<Objet> getAllStatistiqueEtabByHandicap() throws SQLException {
        return this.service.getAllStatistiqueEtabByHandicap();
    }
     
    public List<Objet> getAllStatistiqueEtabByOption() throws SQLException {
        return this.service.getAllStatistiqueEtabByOption();
    }
    
    public List<Objet> getAllStatistiqueEtabBySituation() throws SQLException {
        return this.service.getAllStatistiqueEtabBySituation();
    }
    //Province
    
    public List<Objet> getAllStatistiqueByProvince() throws SQLException {
        return this.service.getAllStatistiqueByProvince();
    }
    
     public List<Objet> getAllStatistiqueActeurByProvince() throws SQLException {
        return this.service.getAllStatistiqueActeurByProvince();
    }
     
     public List<Objet> getAllStatistiqueProvinceByHandicap() throws SQLException {
        return this.service.getAllStatistiqueProvinceByHandicap();
    }
     
    public List<Objet> getAllStatistiqueProvinceByOption() throws SQLException {
        return this.service.getAllStatistiqueProvinceByOption();
    }
    
    public List<Objet> getAllStatistiqueProvinceBySituation() throws SQLException {
        return this.service.getAllStatistiqueProvinceBySituation();
    }
    //Region
    
    public List<Objet> getAllStatistiqueByRegion() throws SQLException {
        return this.service.getAllStatistiqueByRegion();
    }
    
     public List<Objet> getAllStatistiqueActeurByRegion() throws SQLException {
        return this.service.getAllStatistiqueActeurByRegion();
    }
     
     public List<Objet> getAllStatistiqueRegionByHandicap() throws SQLException {
        return this.service.getAllStatistiqueRegionByHandicap();
    }
     
    public List<Objet> getAllStatistiqueRegionByOption() throws SQLException {
        return this.service.getAllStatistiqueRegionByOption();
    }
    
    public List<Objet> getAllStatistiqueRegionBySituation() throws SQLException {
        return this.service.getAllStatistiqueRegionBySituation();
    }
     
     
}
