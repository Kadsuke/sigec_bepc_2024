/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendMiseAJourController {
    private MiseAJourService service;
    
    public BackendMiseAJourController() throws SQLException {
        this.service = new MiseAJourService();
    }
    //Mise A jour
    public Boolean saveLocalite() throws SQLException{
        return this.service.saveLocalite();
    }
    
    public Boolean saveEtablissement() throws SQLException{
        return this.service.saveEtablissement();
    }
    
    public Boolean saveDirection() throws SQLException{
        return this.service.saveDirection();
    }
    
    public Boolean updateDatabase() throws SQLException{
        return this.service.updateDatabase();
    }
}
