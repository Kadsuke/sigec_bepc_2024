/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class SessionRepository extends Repository implements InterfaceDAO{

    public SessionRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Session session = (Session)objet;
        String sql;
        sql = "INSERT INTO session(annee,dateDebutSessionNormale,dateFinSessionNormale,dateDebutInscription,dateFinInscription,dateDebutSessionRemplacement,dateFinSessionRemplacement,moyAdmission,moyRachat,moyAdmissible)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, session.getAnnee());
        pstmt.setString(2, session.getDateDebutSessionNormale().toString());
        pstmt.setString(3, session.getDateFinSessionNormale().toString());
        pstmt.setString(4, session.getDateDebutInscription().toString());
        pstmt.setString(5, session.getDateFinInscription().toString());
        pstmt.setString(6, session.getDateDebutSessionRemplacement().toString());
        pstmt.setString(7, session.getDateFinSessionRemplacement().toString());
        pstmt.setDouble(8, session.getMoyAdmission());
        pstmt.setDouble(9, session.getMoyRachat());
        pstmt.setDouble(10, session.getMoyAdmissible());

        pstmt.executeUpdate();
        session.setId(this.lastInsertedId());
        return session;
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
        String sql = "SELECT * FROM session";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Session session = new Session();
            session.setId(rs.getLong("session_id"));
            session.setAnnee(rs.getLong("annee"));
            session.setDateDebutSessionNormale(LocalDate.parse(rs.getString("dateDebutSessionNormale")));
            session.setDateFinSessionNormale(LocalDate.parse(rs.getString("dateFinSessionNormale")));
            session.setDateDebutInscription(LocalDate.parse(rs.getString("dateDebutInscription")));
            session.setDateFinInscription(LocalDate.parse(rs.getString("dateFinInscription")));
            session.setDateDebutSessionRemplacement(LocalDate.parse(rs.getString("dateDebutSessionRemplacement")));
            session.setDateFinSessionRemplacement(LocalDate.parse(rs.getString("dateFinSessionRemplacement")));
            session.setMoyAdmission(rs.getDouble("moyAdmission"));
            session.setMoyRachat(rs.getDouble("moyrachat"));
            session.setmoyAdmissible(rs.getDouble("moyAdmissible"));
            liste.add(session);
        }
           return liste;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        String sql = "SELECT * FROM session WHERE session_id = ?\n";
        
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs    = pstmt.executeQuery();
        Session session = null; 
        while (rs.next()) {
            session = new Session(rs);
        }
        return session;
    }
    
    public Objet getActiveSession() throws SQLException {
        String sql = "SELECT * FROM session WHERE statutSession = ?\n";
        
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setBoolean(1, true);
        ResultSet rs    = pstmt.executeQuery();
        Session session = null; 
        while (rs.next()) {
            session = new Session(rs);
        }
        return session;
    }
    
    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM session ORDER BY session_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("session_id");
        }
        return id;
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
