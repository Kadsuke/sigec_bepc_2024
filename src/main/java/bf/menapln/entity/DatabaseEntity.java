/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tiere
 */
public class DatabaseEntity {
   private String path;
    private String name;
    private Connection connexion;
    private Integer candidatCount;
    private Integer gpCount;
    private Integer acteursCount;
    public DatabaseEntity(String path,String name){
        this.path = path;
        this.name = name;
    }
    
    //public void setDbInstance()

    public Connection getConnexion() {
       return connexion;
    }

    public void setConnexion() throws SQLException {
        /*Factory factory = Factory.getInstance(this.path);
        this.connexion = factory.connect();
        return "jdbc:sqlite:"+this.getDbname()+".db";*/
        this.connexion = DriverManager.getConnection("jdbc:sqlite:"+this.path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCandidatCount() {
        return candidatCount;
    }

    public void setCandidatCount(Integer candidatCount) {
        this.candidatCount = candidatCount;
    }

    public Integer getGpCount() {
        return gpCount;
    }

    public void setGpCount(Integer gpCount) {
        this.gpCount = gpCount;
    }

    public Integer getActeursCount() {
        return acteursCount;
    }

    public void setActeursCount(Integer acteursCount) {
        this.acteursCount = acteursCount;
    }
     
}
