/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Objet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author tiere
 */
public class FusionRepository extends Repository implements InterfaceDAO{

    public FusionRepository(Factory factory) {
        super(factory);
    }
    
    @Override
    public Objet save(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void attachDabaseFile(String path,   String alias) throws SQLException{
        Statement attach  = this.factory.connect().createStatement();
        String sqlAttach = "ATTACH DATABASE '"+path+"' AS "+alias+";";
        attach.executeUpdate(sqlAttach);
        attach.executeUpdate("PRAGMA foreign_keys=OFF;");
    }
    
    public void detachDataBase(String alias) throws SQLException{
        Statement detach  = this.factory.connect().createStatement();
        detach.executeUpdate("PRAGMA foreign_keys=ON;");
        detach.executeUpdate("DETACH DATABASE '"+alias+"';");
    }
    
    public Long verifierData(String path,String alias, String table) throws SQLException{
        Statement attach  = this.factory.connect().createStatement();
        String sqlAttach = "ATTACH DATABASE '"+path+"' AS "+alias+";";
        attach.executeUpdate(sqlAttach);
        attach.executeUpdate("PRAGMA foreign_keys=OFF;");
        
        String sql = "SELECT count(*) AS nombre FROM "+alias+"."+table;
        System.err.println(" ## dans verif" +sqlAttach);
        ResultSet rs = attach.executeQuery(sql);
        Long nbre = null;
        while (rs.next()) {
            nbre = rs.getLong("nombre");
        }
        
        
        attach.executeUpdate("PRAGMA foreign_keys=ON;");
        attach.executeUpdate("DETACH DATABASE "+alias+";");
        
        return nbre;
    }
    
    
    public void loadData(String path,String alias, String[] table) throws SQLException{
        Statement attach  = this.factory.connect().createStatement();
        String sqlAttach = "ATTACH DATABASE '"+path+"' AS "+alias+";";
        attach.executeUpdate(sqlAttach);
        attach.executeUpdate("PRAGMA foreign_keys=OFF;");
        double progressStep = 1.0 / (table.length + 2);

        for(int i=0; i<table.length; i++){
            attach.executeUpdate("INSERT INTO "+table[i]+" SELECT * FROM "+alias+"."+table[i]+";");
        }
        
        attach.executeUpdate("PRAGMA foreign_keys=ON;");
        attach.executeUpdate("DETACH DATABASE '"+alias+"';");
    }
    
    public Long checkEveryData(String path,String alias, String table) throws SQLException{
        Statement attach  = this.factory.connect().createStatement();
        String sqlAttach = "ATTACH DATABASE '"+path+"' AS "+alias+";";
        attach.executeUpdate(sqlAttach);
        attach.executeUpdate("PRAGMA foreign_keys=OFF;");
        
        String sql = "SELECT count(*) AS nombre FROM "+alias+"."+table+","
                + ""+table+"where "+alias+"."+table+".id= "+table+".id;";
//        System.err.println(" ## dans verif" +sqlAttach);
        ResultSet rs = attach.executeQuery(sql);
        Long nbre = null;
        while (rs.next()) {
            nbre = rs.getLong("nombre");
        }
        
        
        attach.executeUpdate("PRAGMA foreign_keys=ON;");
        attach.executeUpdate("DETACH DATABASE "+alias+";");
        
        return nbre;
    }
}
