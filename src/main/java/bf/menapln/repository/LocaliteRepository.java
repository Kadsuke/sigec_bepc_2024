/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Localite;
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
 * @author coulibaly
 */
public class LocaliteRepository extends Repository implements InterfaceDAO{

    public LocaliteRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
       Localite localite = (Localite)objet;
        String sql;
        sql = "INSERT INTO localite(typeLocalite_id,parentLocalite,codeLocalite,nomLocalite)"
                + " VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, localite.getTypeLocalite().getId());
        if(localite.getParentLocalite() == null || localite.getParentLocalite().getId() == null){
            pstmt.setObject(2, null);
        }else{
            pstmt.setLong(2, localite.getParentLocalite().getId());
        }
        pstmt.setString(3, localite.getCodeLocalite());
        pstmt.setString(4, localite.getNomLoclite());
        pstmt.executeUpdate();
        localite.setId(this.lastInsertedId());
        return localite;
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
        String sql = "SELECT * FROM viewLocalite";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.getTypeLocalite().setLibelle(rs.getString("typeLocaliteLibelle"));
            localite.setParentLocalite(Localite.id(rs.getLong("parentLocalite")));
            localite.getParentLocalite().setNomLoclite(rs.getString("nomParent"));
            liste.add(localite);
        }
           return liste;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM localite ORDER BY localite_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("localite_id");
        }
        return id;
    }
    
    public List<Objet> getRegion() throws SQLException {
        String sql = "SELECT * FROM region";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
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
    public List<Objet> getProvince() throws SQLException {
        String sql = "SELECT * FROM province";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
            liste.add(localite);
        }
           return liste;
    }
    
    public List<Objet> getCommune(Localite parent) throws SQLException {
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
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
            liste.add(localite);
        }
           return liste;
    }
    
    public List<Objet> getAllCommune() throws SQLException {
        String sql = "SELECT * FROM commune";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
            liste.add(localite);
        }
           return liste;
    }
    
    public List<Objet> getVillageQuartier() throws SQLException {
        String sql = "SELECT * FROM village";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
            liste.add(localite);
        }
           return liste;
    }
    
    
    
    public List<Objet> getVilleComposition(Session session) throws SQLException {
        String sql = "SELECT * FROM villeComposition where session_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, session.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
            liste.add(localite);
        }
        return liste;
    }
    
    public List<Objet> getVilleComposition(Session session, Localite parent) throws SQLException {
        String sql = "SELECT * FROM villeComposition where session_id = ? and parent_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, session.getId());
        stmt.setLong(2, parent.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Localite localite = new Localite();
            localite.setId(rs.getLong("localite_id"));
            localite.setCodeLocalite(rs.getString("codeLocalite"));
            localite.setNomLoclite(rs.getString("nomLocalite"));
            //localite.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
            localite.setParentLocalite(Localite.id(rs.getLong("parent_id")));
            localite.getParentLocalite().setCodeLocalite(rs.getString("parentCode"));
            localite.getParentLocalite().setNomLoclite(rs.getString("parentLibelle"));
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
    
    public List<Objet> getCentre(Localite parent) throws SQLException {
        String sql = "SELECT * FROM localite WHERE localite_id = ?\n" +
                        "UNION\n" +
                      "SELECT * FROM localite WHERE parentLocalite = ? and typeLocalite_id is not 5";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, parent.getId());
        stmt.setLong(2, parent.getId());
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
    
    public List<Objet> getCentreExam(Localite parent) throws SQLException {
        String sql = "SELECT * from viewCentreExamen where communeId = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, parent.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Centre centre = new Centre();
            centre.setId(rs.getLong("centre_identifiant"));
            centre.setLocalite(Localite.id(rs.getLong("communeId")));
            centre.getLocalite().setNomLoclite(rs.getString("nomCommune"));
            centre.setCentre(Localite.id(rs.getLong("centreExamenId")));
            centre.getCentre().setNomLoclite(rs.getString("nomCentre"));
            centre.setTypeCentre(Type.id(rs.getLong("typeId")));
            centre.getTypeCentre().setLibelle(rs.getString("typeLibelle"));
            liste.add(centre);
        }
           return liste;
    }
    
    public List<Objet> getCentreExamen() throws SQLException {
        String sql = "SELECT * from viewCentreExamen";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Centre centre = new Centre();
            centre.setId(rs.getLong("centre_identifiant"));
            centre.setLocalite(Localite.id(rs.getLong("communeId")));
            centre.getLocalite().setNomLoclite(rs.getString("nomCommune"));
            centre.getLocalite().setParentLocalite(Localite.id(rs.getLong("provinceId")));
            centre.getLocalite().getParentLocalite().setNomLoclite(rs.getString("nomProvince"));
            centre.getLocalite().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("regionId")));
            centre.getLocalite().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("nomRegion"));
            centre.setCentre(Localite.id(rs.getLong("centreExamenId")));
            centre.getCentre().setNomLoclite(rs.getString("nomCentre"));
            centre.setTypeCentre(Type.id(rs.getLong("typeId")));
            centre.getTypeCentre().setLibelle(rs.getString("typeLibelle"));
            liste.add(centre);
        }
           return liste;
    }
    
}
