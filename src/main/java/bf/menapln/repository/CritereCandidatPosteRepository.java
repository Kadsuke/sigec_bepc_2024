/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.entity.Pays;
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
public class CritereCandidatPosteRepository extends Repository implements InterfaceDAO{

    public CritereCandidatPosteRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CritereCandidatPosteJury critereCandidatPoste = (CritereCandidatPosteJury)objet;
        String sql;
        sql = "INSERT INTO critereCandidatPosteJury(session_id,critere_id,poste_id,modalite_id,candidat_id,structure_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, critereCandidatPoste.getSession().getId());
        pstmt.setLong(2, critereCandidatPoste.getCritere().getId());
        pstmt.setLong(3, critereCandidatPoste.getCandidatPosteJury().getPoste().getId());
        pstmt.setLong(4, critereCandidatPoste.getModalite().getId());
        pstmt.setLong(5, critereCandidatPoste.getCandidatPosteJury().getCandidat().getId());
        pstmt.setLong(6, critereCandidatPoste.getCandidatPosteJury().getStructure().getId());
        pstmt.executeUpdate();
        return critereCandidatPoste;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        CandidatPosteJury candidatPosteJury = (CandidatPosteJury)objet;
        String sql = "DELETE FROM critereCandidatPosteJury WHERE candidat_id = ? and structure_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidatPosteJury.getCandidat().getId());
        pstmt.setLong(2, candidatPosteJury.getStructure().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return candidatPosteJury;  // La suppression a réussi, retournez l'objet Dispense supprimé
       
    }
    
    public Objet deleteCritereModal(Objet objet) throws SQLException {
        CritereCandidatPosteJury critere = (CritereCandidatPosteJury)objet;
        String sql = "DELETE FROM critereCandidatPosteJury WHERE candidat_id = ? and structure_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, critere.getCandidatPosteJury().getCandidat().getId());
        pstmt.setLong(2, critere.getCandidatPosteJury().getStructure().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return critere;  // La suppression a réussi, retournez l'objet Dispense supprimé
       
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM modalite";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Modalite modalite = new Modalite();
            modalite.setId(rs.getLong("modalite_id"));
            modalite.setModaliteLibelle(rs.getString("modaliteLibelle"));
            liste.add(modalite);
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
        String sql = "SELECT * FROM modalite ORDER BY modalite_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("modalite_id");
        }
        return id;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
