/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Structure;

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
public class CentreCompositionRepository extends Repository implements InterfaceDAO{

    public CentreCompositionRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CentreComposition centre = (CentreComposition)objet;
        String sql;
        sql = "INSERT INTO centreComposition(session_id,etablissement_id,capacite,zone_id)\n"
                +"VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, centre.getSession().getId());
        pstmt.setLong(2, centre.getEtablissement().getId());
        pstmt.setLong(3, centre.getCapacite());
        if (centre.getZone() != null) {
            pstmt.setLong(4, centre.getZone().getId());
        } else {
            pstmt.setObject(4, null);
        }
        
        pstmt.executeUpdate();
        return centre;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        
        CentreComposition centre = (CentreComposition)objet;
        String sql;
        sql = "UPDATE centreComposition SET capacite=?,zone_id=? WHERE session_id=? AND etablissement_id=?";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, centre.getCapacite());
        if (centre.getZone() != null) {
            pstmt.setLong(2, centre.getZone().getId());
        } else {
            pstmt.setObject(2, null);
        }
        pstmt.setLong(3, centre.getSession().getId());
        pstmt.setLong(4, centre.getEtablissement().getId());
        pstmt.executeUpdate();
        return centre;
    }
  
    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewCentreComposition";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CentreComposition centre = new CentreComposition();
            if(rs.getLong("zone_id") != 0){
                centre.setZone(Localite.id(rs.getLong("zone_id")));
                centre.getZone().setNomLoclite(rs.getString("nomLocalite"));
            }
            centre.setCapacite(rs.getLong("capacite"));
            centre.setSession(Session.id(rs.getLong("session_id")));
            centre.setEtablissement(Etablissement.id(rs.getLong("structure_id")));
            centre.getEtablissement().setCodeStructure(rs.getString("codeStructure"));
            centre.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            centre.getEtablissement().setAcronymeStructure(rs.getString("acronymeStructure"));
            Localite centreExam = Localite.id(rs.getLong("localite_id"));
            Localite prov =  Localite.id(rs.getLong("provId"));
            Localite reg = Localite.id(rs.getLong("regId"));
            centreExam.setNomLoclite(rs.getString("nomLocalite"));
            prov.setNomLoclite(rs.getString("province"));
            reg.setNomLoclite(rs.getString("region"));
            prov.setParentLocalite(reg);
            centreExam.setParentLocalite(prov);
            centre.getEtablissement().setLocalite(centreExam); 
            liste.add(centre);
        }
        return liste;
    }
    
    public List<Objet> getCentres() throws SQLException {
        String sql = "SELECT * FROM viewCentre where session_id is not null";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CentreComposition centre = new CentreComposition();
            centre.setCapacite(rs.getLong("capacite"));
            centre.setSession(Session.id(rs.getLong("session_id")));
            centre.getSession().setAnnee(rs.getLong("annee"));
            
            centre.setEtablissement(Etablissement.id(rs.getLong("structure_id")));
            centre.getEtablissement().setCodeStructure(rs.getString("codeStructure"));
            centre.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            centre.getEtablissement().setAcronymeStructure(rs.getString("acronymeStructure"));
            
            liste.add(centre);
        }
        return liste;
    }
    
    public List<Objet> getCentres(Localite villeComposition) throws SQLException {
        String sql = "SELECT * FROM viewCentre where session_id is not null and localite_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, villeComposition.getId());
        ResultSet rs    = stmt.executeQuery();
         List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CentreComposition centre = new CentreComposition();
            centre.setCapacite(rs.getLong("capacite"));
            centre.setSession(Session.id(rs.getLong("session_id")));
            centre.getSession().setAnnee(rs.getLong("annee"));
            
            centre.setEtablissement(Etablissement.id(rs.getLong("structure_id")));
            centre.getEtablissement().setCodeStructure(rs.getString("codeStructure"));
            centre.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            centre.getEtablissement().setAcronymeStructure(rs.getString("acronymeStructure"));
            
            liste.add(centre);
        }
        return liste;
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
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
    // Pour création des centre de composition
    public List<Objet> getAllEtablissements() throws SQLException {
        String sql = "SELECT * FROM viewCreationCentreComposition";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CentreComposition centre = new CentreComposition();
            if(rs.getLong("zone_id") != 0){
                centre.setZone(Localite.id(rs.getLong("zone_id")));
                centre.getZone().setNomLoclite(rs.getString("nomLocalite"));
            }
            centre.setCapacite(rs.getLong("capacite"));
            centre.setEtablissement(Etablissement.id(rs.getLong("structure_id")));
            centre.getEtablissement().setCodeStructure(rs.getString("codeStructure"));
            centre.getEtablissement().setNomStructure(rs.getString("nomStructure"));
            centre.getEtablissement().setAcronymeStructure(rs.getString("acronymeStructure"));
            centre.getEtablissement().setLocalite(Localite.id(rs.getLong("localite_id")));
            liste.add(centre);
        }
        return liste;
    }
    
    
}
