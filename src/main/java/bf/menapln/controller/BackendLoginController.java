/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.service.*;
import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BackendLoginController {
    private UserService service;
    private MenuService serviceMenu;
    private SessionManager sessionManager;
    
     public BackendLoginController() throws SQLException {
        this.service = new UserService();
        this.serviceMenu = new MenuService();
        this.sessionManager = SessionManager.getInstance();
    }
    //Get la liste de toutes les centres
    public List<Objet> getAll() throws SQLException{
        return this.service.getAll("");
    }
    
   //Enregistrement d'une centre
    public Objet connect(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException, Exception{
        this.service.setFormData(formData);
        Objet ob = this.service.connect();
        if(ob==null){
            throw new Exception("Compte non trouvé pour l'utilisateur : ");

        }else{
            User user = (User)ob;
            this.sessionManager.setUser(user);
            Objet prof = this.serviceMenu.getByProfil(((User)ob).getProfil());
            return prof;
          
        }
    }
    
    
    
    
}
