/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class CentreRepository extends Repository implements InterfaceDAO{

    public CentreRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
       Centre centre = (Centre)objet;
        String sql;
        sql = "INSERT INTO centre(localite_id,session_id,typeCentre_id,centre_id)"
                + " VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, centre.getLocalite().getId());
        pstmt.setLong(2, centre.getSession().getId());
        pstmt.setLong(3, centre.getTypeCentre().getId());
        pstmt.setLong(4, centre.getCentre().getId());
        
        pstmt.executeUpdate();
        //centre.setId(this.lastInsertedId());
        return centre;
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
        String sql = "SELECT * FROM viewCentreExamen"; 
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Centre centre = new Centre();
            centre.setId(rs.getLong("centre_identifiant"));
            centre.setSession(Session.id(rs.getLong("session_id")));
            centre.setTypeCentre(Type.id(rs.getLong("typeId")));
            centre.getTypeCentre().setLibelle(rs.getString("typeLibelle"));
            centre.setLocalite(Localite.id(rs.getLong("communeId")));
            centre.getLocalite().setNomLoclite(rs.getString("nomCommune"));
            centre.getLocalite().setParentLocalite(Localite.id(rs.getLong("provinceId")));
            centre.getLocalite().getParentLocalite().setNomLoclite(rs.getString("nomProvince"));
            centre.setCentre(Localite.id(rs.getLong("centreExamenId")));
            centre.getCentre().setNomLoclite(rs.getString("nomCentre"));
            liste.add(centre);
        }
           return liste;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM viewCentre ORDER BY localite_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("localite_id");
        }
        return id;
    }
    
    public List<Objet> getCentreByCommune(Localite parent) throws SQLException {
        String sql = "SELECT * FROM commune where parent_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, parent.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            //localite.setParentLocalite(Localite.id(rs.getLong("parentLocalite")));
            liste.add(localite);
        }
           return liste;
    }
    
    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        String sql = "SELECT * FROM localite WHERE parentLocalite = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parentLocalite")));
            liste.add(localite);
        }
        return liste;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Objet> getAllLocaliteByType(Long parent,Long type) throws SQLException {
        String sql = "SELECT * FROM localite WHERE parentLocalite = ? and typeLocalite_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, parent);
        stmt.setLong(2, type);
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parentLocalite")));
            liste.add(localite);
        }
        return liste;
    }

    //Add 21 04 for centreExamen from inscription table
    public List<Objet> getAllSpecial() throws SQLException {
        String sql = "SELECT * FROM viewCentreExameSpecial";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite centre = new Localite();
            centre.setId(rs.getLong("centreExamen_id"));
            centre.setTypeLocalite((Type.id(rs.getLong("typeLocalite_id"))));
            centre.getTypeLocalite().setLibelle(rs.getString("typeLocaliteLibelle"));
            centre.setNomLoclite((rs.getString("nomLocalite")));
            if(rs.getString("typeLocaliteLibelle").equals("Commune")){
                System.out.println("typeCommune");
                centre.setParentLocalite(Localite.id(rs.getLong("parentn1_id")));
                centre.getParentLocalite().setNomLoclite(rs.getString("libelleParentn1"));
                centre.getParentLocalite().setParentLocalite(Localite.id(rs.getLong("parentn2_id")));
                centre.getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleParentn2"));
            }else{
                System.out.println("typeVillage"+rs.getString("typeLocaliteLibelle"));
                centre.setParentLocalite(Localite.id(rs.getLong("parentn2_id")));
                centre.getParentLocalite().setNomLoclite(rs.getString("libelleParentn2"));
                centre.getParentLocalite().setParentLocalite(Localite.id(rs.getLong("parentn3_id")));
                centre.getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleParentn3"));
            }
            liste.add(centre);
        }
           return liste;
    }
    
    
}
