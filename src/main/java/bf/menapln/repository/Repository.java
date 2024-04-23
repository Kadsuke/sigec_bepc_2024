/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import java.sql.Connection;

/**
 *
 * @author kadsuke
 */
public class Repository {
    protected Factory factory;
    protected Connection connexion;
    public Repository(Factory factory){
        this.factory = factory;
    }
    
    public Repository(Connection connexion){
        this.connexion = connexion;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
}
