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
public class DispenseRepository extends Repository implements InterfaceDAO{

    public DispenseRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Dispense dispense = (Dispense)objet;
        String sql;
        sql = "INSERT INTO dispense(session_id,candidat_id,etablissement_id,epreuve_id)\n"
                + "VALUES(?,?,?,?)";
        try (Connection connection = this.factory.connect();
                
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, dispense.getSession().getId());
        pstmt.setLong(2, dispense.getCandidat().getId());
        pstmt.setLong(3, dispense.getCandidat().getEtablissementCandidat().getId());
        pstmt.setLong(4, 15);
       // pstmt.setString(5, dispense.getCandidat().getNumeroDossier());
        pstmt.executeUpdate();
         } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return dispense;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        Dispense dispense = (Dispense)objet;
        String sql = "DELETE FROM dispense WHERE candidat_id = ? and session_id = ? and etablissement_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, dispense.getCandidat().getId());
        pstmt.setLong(2, dispense.getSession().getId());
        pstmt.setLong(3, dispense.getCandidat().getEtablissementCandidat().getId());
        //pstmt.setString(4, dispense.getCandidat().getNumeroDossier());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return dispense;  // La suppression a réussi, retournez l'objet Dispense supprimé
       
    }
    
    public Objet deleteCandi(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql = "DELETE FROM dispense WHERE candidat_id = ? and session_id = ? and etablissement_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidat.getId());
        pstmt.setLong(2, candidat.getSession().getId());
        pstmt.setLong(3, candidat.getEtablissementCandidat().getId());
      //  pstmt.setString(4, candidat.getNumeroDossier());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return candidat;  // La suppression a réussi, retournez l'objet Dispense supprimé
       
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
    //    Long total = countDispensesForCandidat(objet);
        Dispense dispense = (Dispense)objet;
        String sql;
        Long nb = null;
        sql= "SELECT COUNT(*) FROM dispense WHERE candidat_id = ? and session_id = ? and etablissement_id = ?";
        try (PreparedStatement pstmt = this.factory.connect().prepareStatement(sql)) {
            pstmt.setLong(1, dispense.getCandidat().getId());
            pstmt.setLong(2, dispense.getSession().getId());
        pstmt.setLong(3, dispense.getCandidat().getEtablissementCandidat().getId());
      //  pstmt.setString(4, dispense.getCandidat().getNumeroDossier());
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    nb = resultSet.getLong(1);
                }
                this.factory.close();
            }
        }
        if((nb != null && nb <= 0 && dispense.getCandidat().isApte()) || (nb != null && nb > 0 && !dispense.getCandidat().isApte())){
            //Ne rien faire
            System.out.print("rien a faire");
        }else if(nb != null && nb <= 0 && !dispense.getCandidat().isApte()){
            System.out.print("ajouter = "+dispense.getCandidat().isApte());
            sql = "INSERT INTO dispense(session_id,candidat_id,etablissement_id,epreuve_id)\n"
                + "VALUES(?,?,?,?)";
            try (Connection connection = this.factory.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, dispense.getSession().getId());
            pstmt.setLong(2, dispense.getCandidat().getId());
            pstmt.setLong(3, dispense.getCandidat().getEtablissementCandidat().getId());
            pstmt.setLong(4, 15);
           // pstmt.setString(5, dispense.getCandidat().getNumeroDossier());
            pstmt.executeUpdate();
            } catch (SQLException e) { // Gérez l'exception ici
                // Gérez l'exception ici
            throw e; // Vous pouvez choisir de la propager ou de la gérer localement
        }
            this.factory.close();
            return dispense;
        }else if(nb != null && nb > 0 && dispense.getCandidat().isApte()){
            System.out.print("Supprimer"+dispense.getCandidat().isApte());
           return delete(objet);
        }
        
        return dispense;
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
    
  public Long countDispensesForCandidat(Objet objet) throws SQLException {
        Dispense dispense = (Dispense)objet;
        String sql = "SELECT COUNT(*) FROM dispense WHERE candidat_id = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, dispense.getCandidat().getId());

        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            return resultSet.getLong(1);
        }

         this.factory.close();
         resultSet.close();
         pstmt.close();
        return Long.parseLong("0"); // Si aucune dispense n'est trouvée
        
    }

}
