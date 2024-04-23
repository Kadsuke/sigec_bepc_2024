/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.Objet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class EpreuveRepository extends Repository implements InterfaceDAO{

    public EpreuveRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Epreuve epreuve = (Epreuve)objet;
        String sql;
        sql = "INSERT INTO epreuve(parent_id,epreuveLibelle,epreuveAcronyme) VALUES(?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        if (epreuve.getParent().getId() == null) {
            pstmt.setObject(1, null);
        } else {
            pstmt.setLong(1, epreuve.getParent().getId());
        }
        pstmt.setString(2, epreuve.getEpreuveLibelle());
        pstmt.setString(3, epreuve.getEpreuveAcronyme());
        pstmt.executeUpdate();
        epreuve.setId(this.lastInsertedId());
        return epreuve;
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
        String sql = "SELECT * FROM epreuve ";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Epreuve epreuve = new Epreuve(rs);
            epreuve.setId(rs.getLong("epreuve_id"));
           // epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
           // epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            
            liste.add(epreuve);
        }
        return liste;
    }
    
    public List<Objet> getEpreuveWithNoParent() throws SQLException{
        String sql = "select * from epreuve where parent_id is null";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Epreuve epreuve = new Epreuve(rs);
            //epreuve.setId(rs.getLong("epreuve_id"));
           // epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
           // epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            
            liste.add(epreuve);
        }
        return liste;
    }
    
  
     @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM epreuve ORDER BY epreuve_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("epreuve_id");
        }
        return id;
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
}
