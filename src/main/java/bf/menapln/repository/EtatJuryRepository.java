/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Objet;
import bf.menapln.entity.TourComposition;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class EtatJuryRepository extends Repository implements InterfaceDAO{

    public EtatJuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Jury jury = (Jury)objet;
        String sql;
         sql = "INSERT INTO etatJury(session_id,jury_id,tourComposition_id,actif,valide)\n"
                 + "    VALUES(?,?,?,?,?)";
         PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
         pstmt.setLong(1, jury.getSession().getId());
         pstmt.setLong(2, jury.getId());
         pstmt.setLong(3, 2);
         pstmt.setBoolean(4, true);
         pstmt.setBoolean(5, false);
         pstmt.executeUpdate();
        return jury;
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
        Jury jury = (Jury)objet;
        String sql = "SELECT * FROM etatJury e INNER JOIN tourComposition t \n"
                +" ON t.tourComposition_id = e.tourComposition_id where session_id = ? and jury_id = ? and actif = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, jury.getSession().getId());
        stmt.setLong(2, jury.getId());
        stmt.setBoolean(3, true);
        ResultSet rs    = stmt.executeQuery();
        TourComposition tour = null;
        while (rs.next()) {
            tour = new TourComposition(rs);
            tour.setTourCode(rs.getInt("tourCode"));
        }
        return tour;
    }
    
    public Objet getById(Objet objet,boolean etat) throws SQLException {
        Jury jury = (Jury)objet;
        String sql = "SELECT * FROM etatJury e INNER JOIN tourComposition t \n"
                +" ON t.tourComposition_id = e.tourComposition_id where session_id = ? and jury_id = ? and actif = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, jury.getSession().getId());
        stmt.setLong(2, jury.getId());
        stmt.setBoolean(3, etat);
        ResultSet rs    = stmt.executeQuery();
        TourComposition tour = null;
        while (rs.next()) {
            tour = new TourComposition(rs);
            tour.setActif(rs.getBoolean("actif"));
            tour.setValide(rs.getBoolean("valide"));
        }
        return tour;
    }
    
    public Objet valideEtape(Objet objet) throws SQLException {
        Jury jury = (Jury)objet;
        String sql = "UPDATE etatJury set valide = ? where session_id = ? and jury_id = ? and tourComposition_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setBoolean(1, jury.getEtape().isValide());
        stmt.setLong(2, jury.getSession().getId());
        stmt.setLong(3, jury.getId());
        stmt.setLong(4, jury.getEtape().getId());
        stmt.executeUpdate();
        return objet;
    }
    
    public Objet updateEtape(Objet objet) throws SQLException {
        Jury jury = (Jury)objet;
        String sql = "UPDATE etatJury set actif = ? where session_id = ? and jury_id = ? and tourComposition_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setBoolean(1, jury.getEtape().isActif());
        stmt.setLong(2, jury.getSession().getId());
        stmt.setLong(3, jury.getId());
        stmt.setLong(4, jury.getEtape().getId());
        stmt.executeUpdate();
        return objet;
    }

    public Objet lastInsertedIde() throws SQLException {
        String sql = "SELECT * FROM etatJury ORDER BY tourComposition_id DESC LIMIT 1";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        TourComposition tour = null;
        while (rs.next()) {
            id = rs.getLong("tourComposition_id");
        }
        
        return tour.id(id);
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastInsertedId'");
    }
}
