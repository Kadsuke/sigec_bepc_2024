/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.EpreuveOptions;
import bf.menapln.entity.*;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.entity.Pays;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class SerieConcoursRattacheRepository extends Repository implements InterfaceDAO{

    public SerieConcoursRattacheRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        SerieConcours serieConcours = (SerieConcours)objet;
        String sql;
        sql = "INSERT INTO concoursSerie(serie_id,concoursRattache_id,session_id)\n"
                + "VALUES(?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, serieConcours.getSerie().getId());
        pstmt.setLong(2, serieConcours.getConcoursRattache().getId());
        pstmt.setLong(3, serieConcours.getSession().getId());
        pstmt.executeUpdate();
        return serieConcours;
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
         String sql = "SELECT * FROM viewConcoursSerie";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            SerieConcours serieConcours = new SerieConcours();
            serieConcours.setSerie(Type.id(rs.getLong("serie_id")));
            serieConcours.getSerie().setLibelle(rs.getString("serieLibelle"));
            serieConcours.setConcoursRattache(Type.id(rs.getLong("concoursRattache_id")));
            serieConcours.getConcoursRattache().setLibelle(rs.getString("concoursRattacheLibelle"));
            liste.add(serieConcours);
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
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM epreuveOption ORDER BY epreuveOption_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("epreuveOption_id");
        }
        return id;
    }

    
    public List<Objet> getByConcours(Type concours) throws SQLException {
        String sql = "select * from viewConcoursSerie where concoursRattache_id = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, concours.getId());
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            SerieConcours serieConcours = new SerieConcours();
            serieConcours.setSerie(Type.id(rs.getLong("serie_id")));
            serieConcours.getSerie().setLibelle(rs.getString("serieLibelle"));
            serieConcours.setConcoursRattache(Type.id(rs.getLong("concoursRattache_id")));
            serieConcours.getConcoursRattache().setLibelle(rs.getString("concoursRattacheLibelle"));
            liste.add(serieConcours);
        }
           return liste;
    }
}

   