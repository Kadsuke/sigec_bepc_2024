/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Structure;
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
public class StructureRepository extends Repository implements InterfaceDAO {

    public StructureRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Structure structure = (Structure) objet;
        String sql;
        sql = "INSERT INTO structure(typeStructure_id,parent_id,localite_id,codeStructure,nomStructure,acronymeStructure,capaciteEtablissement)\n"
                + "    VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, structure.getTypeStructure().getId());
        if (structure.getParent().getId() == null) {
            pstmt.setObject(2, null);
        } else {
            pstmt.setLong(2, structure.getParent().getId());
        }
        pstmt.setLong(3, structure.getLocalite().getId());
        pstmt.setString(4, structure.getCodeStructure());
        pstmt.setString(5, structure.getNomStructure());
        pstmt.setString(6, structure.getAcronymeStructure());
        pstmt.setString(7, structure.getCapacite());
        pstmt.executeUpdate();
        structure.setId(this.lastInsertedId());
        return structure;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewStructure";

        Statement stmt = this.factory.connect().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Structure etab = new Structure();
            etab.setId(rs.getLong("structure_id"));
            etab.setCodeStructure(rs.getString("codeStructure"));
            etab.setNomStructure(rs.getString("nomStructure"));
            etab.setAcronymeStructure(rs.getString("acronymeStructure"));
            etab.setTypeStructure(Type.id(rs.getLong("typeStructure_id")));
            etab.getTypeStructure().setLibelle(rs.getString("typeStructureLibelle"));
            etab.setLocalite((Localite.id(rs.getLong("commune_id"))));
            etab.getLocalite().setNomLoclite(rs.getString("nom_commune"));
            etab.getLocalite().setParentLocalite(Localite.id(rs.getLong("province_id")));
            etab.getLocalite().getParentLocalite().setNomLoclite(rs.getString("nom_province"));
            etab.getLocalite().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("region_id")));
            etab.getLocalite().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("nom_region"));
            liste.add(etab);
        }
        return liste;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM structure ORDER BY structure_id DESC LIMIT 1";

        Statement stmt = this.factory.connect().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("structure_id");
        }
        return id;
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Objet> getByLocaliteId(Long id) throws SQLException {
        String sql = "SELECT * FROM structure where localite_id = ?";

        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Etablissement etab = new Etablissement();
            etab.setId(rs.getLong("structure_id"));
            etab.setCodeStructure(rs.getString("codeStructure"));
            etab.setNomStructure(rs.getString("nomStructure"));
            etab.setAcronymeStructure(rs.getString("acronymeStructure"));

            liste.add(etab);
        }
        return liste;
    }
    
    public List<Objet> getByTypeLocaliteId(String type,Localite local) throws SQLException {
        //String sql = "SELECT * FROM viewStructure where localite_id = ? and typeStructureLibelle = ?";
        String sql ="SELECT s.*,ts.*,village.*,commune.*,province.*,e.*\n" +
                    "FROM structure s\n" +
                    "INNER JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id\n" +
                    "INNER JOIN localite village ON village.localite_id = s.localite_id\n" +
                    "INNER JOIN localite commune ON commune.localite_id = village.parentLocalite\n" +
                    "INNER JOIN localite province ON province.localite_id = commune.parentLocalite\n" +
                    "INNER JOIN etablissement e ON e.etablissement_id = s.structure_id\n" +
                    "where province.localite_id = ? and ts.typeStructureLibelle = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, local.getId());
        stmt.setString(2, type);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Structure etab = new Structure(rs);
            liste.add(etab);
        }
        return liste;
    }
    
    public List<Objet> getByCommuneId(String type,Localite local) throws SQLException {
        String sql ="SELECT s.*,ts.*,commune.*,province.*,e.*\n" +
                    "FROM structure s\n" +
                    "INNER JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id\n" +
                    "INNER JOIN localite commune ON commune.localite_id = s.localite_id\n" +
                    "INNER JOIN localite province ON province.localite_id = commune.parentLocalite\n" +
                    "LEFT JOIN etablissement e ON e.etablissement_id = s.structure_id\n" +
                    "where commune.localite_id = ? and ts.typeStructureLibelle = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, local.getId());
        stmt.setString(2, type);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Structure etab = new Structure(rs);
            liste.add(etab);
        }
        return liste;
    }
    
    public List<Objet> getByProvinceId(String type,Localite local) throws SQLException {
        String sql ="SELECT s.*,ts.*,commune.*,province.*,e.*\n" +
                    "FROM structure s\n" +
                    "INNER JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id\n" +
                    "INNER JOIN localite commune ON commune.localite_id = s.localite_id\n" +
                    "INNER JOIN localite province ON province.localite_id = commune.parentLocalite\n" +
                    "INNER JOIN etablissement e ON e.etablissement_id = s.structure_id\n" +
                    "where province.localite_id = ? and ts.typeStructureLibelle = ? ORDER BY nomStructure";//edit par BOLY
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, local.getId());
        stmt.setString(2, type);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Structure etab = new Structure(rs);
            liste.add(etab);
        }
        return liste;
    }
    
    public List<Objet> getByRegionId(String type,Localite local) throws SQLException {
        String sql ="SELECT s.*,ts.*,commune.*,province.*,region.*,e.*\n" +
                    "FROM structure s\n" +
                    "INNER JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id\n" +
                    "INNER JOIN localite commune ON commune.localite_id = s.localite_id\n" +
                    "INNER JOIN localite province ON province.localite_id = commune.parentLocalite\n" +
                    "INNER JOIN localite region ON region.localite_id = province.parentLocalite\n" +
                    "INNER JOIN etablissement e ON e.etablissement_id = s.structure_id\n" +
                    "where region.localite_id = ? and ts.typeStructureLibelle = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, local.getId());
        stmt.setString(2, type);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Structure etab = new Structure(rs);
            liste.add(etab);
        }
        return liste;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Objet> getAllEtablissement(String Str) throws SQLException {
        String sql = "SELECT * FROM viewStructure where typeStructureLibelle = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setString(1, Str);
        ResultSet rs = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Etablissement etab = new Etablissement();
            etab.setId(rs.getLong("structure_id"));
            etab.setCodeStructure(rs.getString("codeStructure"));
            etab.setNomStructure(rs.getString("nomStructure"));
            etab.setAcronymeStructure(rs.getString("acronymeStructure"));

            liste.add(etab);
        }
        return liste;
    }

}
