/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class ChoixCandidatRepository extends Repository implements InterfaceDAO{

    public ChoixCandidatRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        ChoixEtablissement choixEtablissement = (ChoixEtablissement)objet;
        String sql;
        sql = "INSERT INTO choixCandidat(session_id,candidat_id,etablissement_id,choixEtablissement_id,serie_id)\n"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, choixEtablissement.getCandidat().getSession().getId());
        pstmt.setLong(2, choixEtablissement.getCandidat().getId());
        pstmt.setLong(3, choixEtablissement.getCandidat().getEtablissementCandidat().getId());
        pstmt.setLong(4, choixEtablissement.getId());
        pstmt.setLong(5, choixEtablissement.getSerie().getId());
        pstmt.executeUpdate();
        this.factory.close(); 
        pstmt.close();
        return choixEtablissement;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        ChoixEtablissement choixEtablissement = (ChoixEtablissement)objet;
        String sql;
        Long nb = null;
        sql= "SELECT COUNT(*) FROM choixCandidat WHERE candidat_id = ? and choixEtablissement_id = ? and etablissement_id = ?";
        try (PreparedStatement pstmt = this.factory.connect().prepareStatement(sql)) {
            pstmt.setLong(1, choixEtablissement.getCandidat().getId());
            pstmt.setLong(2, choixEtablissement.getCandidat().getId());
            pstmt.setLong(3, choixEtablissement.getCandidat().getEtablissementCandidat().getId());
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    nb = resultSet.getLong(1);
                }
                this.factory.close();
            }
        }
        if(nb>0){
            sql = "DELETE FROM choixCandidat WHERE candidat_id = ? and choixEtablissement_id = ? and etablissement_id = ?";
            try (Connection connection = this.factory.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
             pstmt.setLong(1, choixEtablissement.getCandidat().getId());
             pstmt.setLong(2, choixEtablissement.getCandidat().getId());
            pstmt.setLong(4, choixEtablissement.getCandidat().getEtablissementCandidat().getId());
             pstmt.executeUpdate();
             } catch (SQLException e) {
             e.printStackTrace(); // Gérez l'exception ici
             throw e; // Vous pouvez choisir de la propager ou de la gérer localement
        }
     } 
       return choixEtablissement;
    }
    
    
    public Objet deleteCandi(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql = "DELETE FROM choixCandidat WHERE candidat_id = ? and numeroDossier=? and etablissement_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidat.getId());
        pstmt.setString(2, candidat.getNumeroDossier());
        pstmt.setLong(3, candidat.getEtablissementCandidat().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return candidat;  // La suppression a réussi, retournez l'objet Dispense supprimé
       
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        ChoixEtablissement choixEtablissement = (ChoixEtablissement)objet;
        String sql;
        Long nb = null;
        sql= "SELECT COUNT(*) FROM choixCandidat WHERE candidat_id = ? and choixEtablissement_id = ? and numeroDossier=? and etablissement_id = ?";
        try (PreparedStatement pstmt = this.factory.connect().prepareStatement(sql)) {
            /* pstmt.setLong(1, choixEtablissement.getCandidat().getId());
            pstmt.setLong(2, choixEtablissement.getCandidat().getEtablissementChoix().getId());
            pstmt.setString(3, choixEtablissement.getCandidat().getNumeroDossier());
            pstmt.setLong(4, choixEtablissement.getCandidat().getEtablissementCandidat().getId()); */
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    nb = resultSet.getLong(1);
                }
                this.factory.close();
            }
        }
        if(nb>0){
            sql = "DELETE FROM choixCandidat WHERE candidat_id = ? and choixEtablissement_id = ? and numeroDossier=? and etablissement_id = ?";
            try (Connection connection = this.factory.connect();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
                /* pstmt.setLong(1, choixEtablissement.getCandidat().getId());
                pstmt.setLong(2, choixEtablissement.getCandidat().getEtablissementChoix().getId());
                pstmt.setString(3, choixEtablissement.getCandidat().getNumeroDossier());
                pstmt.setLong(4, choixEtablissement.getCandidat().getEtablissementCandidat().getId()); */
                pstmt.executeUpdate();
             } catch (SQLException e) {
             e.printStackTrace(); // Gérez l'exception ici
             throw e; // Vous pouvez choisir de la propager ou de la gérer localement
        }
            sql = "INSERT INTO choixCandidat(session_id,candidat_id,etablissement_id,choixEtablissement_id,serie_id,numeroDossier)\n"
                + "VALUES(?,?,?,?,?,?)";

            PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
            /* pstmt.setLong(1, choixEtablissement.getCandidat().getSession().getId());
            pstmt.setLong(2, choixEtablissement.getCandidat().getId());
            pstmt.setLong(3, choixEtablissement.getCandidat().getEtablissementCandidat().getId());
            pstmt.setLong(4, choixEtablissement.getCandidat().getEtablissementChoix().getId());
            pstmt.setLong(5, choixEtablissement.getCandidat().getSerieChoix().getSerie().getId());
            pstmt.setString(6, choixEtablissement.getCandidat().getNumeroDossier()); */
            pstmt.executeUpdate();
            this.factory.close();
            pstmt.close();
     }else{
            sql = "INSERT INTO choixCandidat(session_id,candidat_id,etablissement_id,choixEtablissement_id,serie_id,numeroDossier)\n"
                + "VALUES(?,?,?,?,?,?)";

            PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
            /* pstmt.setLong(1, choixEtablissement.getCandidat().getSession().getId());
            pstmt.setLong(2, choixEtablissement.getCandidat().getId());
            pstmt.setLong(3, choixEtablissement.getCandidat().getEtablissementCandidat().getId());
            pstmt.setLong(4, choixEtablissement.getCandidat().getEtablissementChoix().getId());
            pstmt.setLong(5, choixEtablissement.getCandidat().getSerieChoix().getSerie().getId());
            pstmt.setString(6, choixEtablissement.getCandidat().getNumeroDossier()); */
            pstmt.executeUpdate();
            this.factory.close();
            pstmt.close();
        }
       return choixEtablissement;
    }
    
    
    public Objet deleteAll(Objet objet) throws SQLException {
        ChoixEtablissement choixEtablissement = (ChoixEtablissement)objet;
        String sql;
        
            sql = "DELETE FROM choixCandidat WHERE candidat_id = ? and numeroDossier=? and etablissement_id = ?";
            try (Connection connection = this.factory.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
             /* pstmt.setLong(1, choixEtablissement.getCandidat().getId());
             pstmt.setString(2, choixEtablissement.getCandidat().getNumeroDossier());
             pstmt.setLong(3, choixEtablissement.getCandidat().getEtablissementCandidat().getId()); */
             pstmt.executeUpdate();
             } catch (SQLException e) {
             e.printStackTrace(); // Gérez l'exception ici
             throw e; // Vous pouvez choisir de la propager ou de la gérer localement
     } 
       return choixEtablissement;
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
