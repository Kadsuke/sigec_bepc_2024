/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.GroupePedagogique;
import bf.menapln.entity.*;
import bf.menapln.entity.Objet;
import java.sql.Connection;
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
public class GroupePedagogiqueRepository extends Repository implements InterfaceDAO{

    public GroupePedagogiqueRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
       GroupePedagogique groupePedagogique = (GroupePedagogique)objet;
        String sql;
        sql = "INSERT INTO groupePedagogique(groupePedagogique_id,session_id,etablissement_id,groupePedagogiqueLibelle)"
                + " VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, groupePedagogique.getId());
        pstmt.setLong(2, groupePedagogique.getSession().getId());
        pstmt.setLong(3, groupePedagogique.getEtablissement().getId());
        pstmt.setString(4, groupePedagogique.getGroupePedagogiqueLibelle());
        pstmt.executeUpdate();
        groupePedagogique.setId(this.lastInsertedId());
        return groupePedagogique;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        GroupePedagogique gp = (GroupePedagogique)objet;
        String sql = "DELETE FROM groupePedagogique WHERE groupePedagogique_id = ? and etablissement_id= ? and session_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, gp.getId());
        pstmt.setLong(2, gp.getEtablissement().getId());
        pstmt.setLong(3, gp.getSession().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return gp;  // 
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
       GroupePedagogique gp = (GroupePedagogique)objet;
        String sql = "UPDATE groupePedagogique SET groupePedagogiqueLibelle=? WHERE groupePedagogique_id=?";
        
        try (Connection connection = this.factory.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
      // PreparedStatement pstmt = this.factory.connect().prepareStatement;
      connection.setAutoCommit(false);
        pstmt.setString(1, gp.getGroupePedagogiqueLibelle());
        pstmt.setLong(2, gp.getId());
        pstmt.executeUpdate();
        connection.commit();
       } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
    return gp;
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT gp.groupePedagogique_id,gp.groupePedagogiqueLibelle,etab.etablissement_id,struct.nomStructure,sess.session_id,sess.annee\n" +
                        "FROM groupePedagogique gp\n" +
                        "inner join etablissement etab on etab.etablissement_id = gp.etablissement_id\n" +
                        "inner join structure struct on struct.structure_id = etab.etablissement_id\n" +
                        "inner join session sess on sess.session_id = gp.session_id";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            GroupePedagogique groupePedagogique = new GroupePedagogique();
            groupePedagogique.setId(rs.getLong("groupePedagogique_id"));
            groupePedagogique.setGroupePedagogiqueLibelle(rs.getString("groupePedagogiqueLibelle"));
            groupePedagogique.setEtablissement(Structure.id(rs.getLong("etablissement_id")));
            groupePedagogique.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            groupePedagogique.setSession(Session.id(rs.getLong("session_id")));
            groupePedagogique.getSession().setAnnee(rs.getLong("annee"));
            liste.add(groupePedagogique);
        }
           return liste;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM groupePedagogique ORDER BY groupePedagogique_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("groupePedagogique_id");
        }
        return id;
    }
    

    public List<Objet> getByEtablissementId(Long id) throws SQLException {
        String sql = "SELECT * FROM groupePedagogique WHERE etablissement_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            GroupePedagogique groupePedagogique = new GroupePedagogique();
            groupePedagogique.setId(rs.getLong("groupePedagogique_id"));
            groupePedagogique.setGroupePedagogiqueLibelle(rs.getString("groupePedagogiqueLibelle"));
            liste.add(groupePedagogique);
        }
        return liste;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Long createId() throws SQLException{
        String sql = "SELECT * FROM groupePedagogique ORDER BY groupePedagogique_id DESC LIMIT 1";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("groupePedagogique_id");
        }
        return (id==null)?1:id+1;
    }
    
    public List<Objet> getAllGroupePedagogique() throws SQLException {
        String sql = "SELECT gp.groupePedagogique_id,gp.groupePedagogiqueLibelle,etab.etablissement_id,struct.nomStructure,sess.session_id,sess.annee\n" +
                        "FROM groupePedagogique gp\n" +
                        "inner join etablissement etab on etab.etablissement_id = gp.etablissement_id\n" +
                        "inner join structure struct on struct.structure_id = etab.etablissement_id\n" +
                        "inner join session sess on sess.session_id = gp.session_id";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            GroupePedagogique groupePedagogique = new GroupePedagogique();
            groupePedagogique.setId(rs.getLong("groupePedagogique_id"));
            groupePedagogique.setGroupePedagogiqueLibelle(rs.getString("groupePedagogiqueLibelle"));
            groupePedagogique.setEtablissement(Structure.id(rs.getLong("etablissement_id")));
            groupePedagogique.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            groupePedagogique.setSession(Session.id(rs.getLong("session_id")));
            groupePedagogique.getSession().setAnnee(rs.getLong("annee"));
            liste.add(groupePedagogique);
        }
           return liste;
    }
}
