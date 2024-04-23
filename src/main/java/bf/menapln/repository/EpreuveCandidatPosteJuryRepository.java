/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.CandidatPosteJury;
import bf.menapln.entity.EpreuveOptionCandidatPosteJury;
import bf.menapln.entity.Objet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class EpreuveCandidatPosteJuryRepository extends Repository implements InterfaceDAO{

    public EpreuveCandidatPosteJuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        EpreuveOptionCandidatPosteJury p = (EpreuveOptionCandidatPosteJury)objet;
        
        String sql;
        sql = "INSERT INTO epreuveCandidatPosteJury(candidat_id,epreuve_id,option_id,structure_id,session_id) VALUES(?,?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, p.getCandidatPosteJury().getCandidat().getId());
        pstmt.setLong(2, p.getEpreuve().getId());
        pstmt.setLong(3, p.getOption().getId());
        pstmt.setLong(4, p.getCandidatPosteJury().getStructure().getId());
        pstmt.setLong(5, p.getCandidatPosteJury().getSession().getId());
        pstmt.executeUpdate();
        return p;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        CandidatPosteJury candidatPosteJury = (CandidatPosteJury)objet;
        String sql = "DELETE FROM epreuveCandidatPosteJury WHERE candidat_id = ? and structure_id = ?";
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
    
    public Objet deleteEPCan(Objet objet) throws SQLException {
        EpreuveOptionCandidatPosteJury candidatPosteJury = (EpreuveOptionCandidatPosteJury)objet;
        String sql = "DELETE FROM epreuveCandidatPosteJury WHERE candidat_id = ? and structure_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidatPosteJury.getCandidatPosteJury().getCandidat().getId());
        pstmt.setLong(2, candidatPosteJury.getCandidatPosteJury().getStructure().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return candidatPosteJury;  // La suppression a réussi, retournez l'objet Dispense supprimé
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
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
