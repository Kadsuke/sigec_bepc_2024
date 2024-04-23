/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Objet;
import exception.EmptyDataException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 *
 * @author coulibaly
 */
public abstract class Service {
    protected Factory factory;
    protected InterfaceDAO implementationDAO;
    protected Map formData;
    protected Connection connection; 
    public Service() throws SQLException{
        this.factory = Factory.getInstance("bd_bepc");
        this.factory.connect();
       this.factory.getConnection().setAutoCommit(false); // Désactivez l'auto-commit
        this.connection = this.factory.getConnection();
        this.factory.getDatabase().initDatabase();
    }
    
    public abstract Objet save()throws SQLException,EmptyDataException;
    public abstract List<Objet> getByParentId(String str) throws SQLException;
    public abstract List<Objet> getAll(String str) throws SQLException;
    public abstract Objet getById(Long id) throws SQLException;
    public abstract Objet update(Objet objet) throws SQLException;
    public abstract void validate() throws EmptyDataException;
    public abstract void setImplementation(String str);
    public Map getFormData() {
        return formData;
    }

    public void setFormData(Map formData) {
        this.formData = formData;
    }
    
    // Méthode pour commencer une transaction
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    // Méthode pour valider une transaction
    public void commitTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    // Méthode pour annuler une transaction
    public void rollbackTransaction() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }
    
     public Factory instanceFactory(){
        return factory;
    }
    
    public Connection getConn() {
        return connection;
    }

    public void setConn(Connection conn) {
        this.connection = conn;
    }
    
    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
