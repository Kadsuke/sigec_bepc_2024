/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author coulibaly
 */
public class Factory {
    private String dbname;
    private Database database;
    private Connection connection;
    
    public Factory(String dbname) throws SQLException{
        this.setDbname(dbname);
        this.database = new Database(this);
        this.connection = connect();
    }
    public static Factory getInstance(String dbname) throws SQLException{
        return new Factory(dbname);
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    
    public String getUrl(){
        return "jdbc:sqlite:"+this.getDbname()+".db";
    }
    public Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection(this.getUrl());
        return conn;
    }

    public void close() throws SQLException {
         if (connection != null) {
            // System.out.print("************Je ferme la connexion**********");
            connection.close();
        }
    }

    public Boolean isclose() throws SQLException {
        return connection == null || connection.isClosed();
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
