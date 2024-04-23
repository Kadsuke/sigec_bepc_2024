/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Candidat;
import bf.menapln.entity.Dispense;
import bf.menapln.entity.Inscription;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Pays;
import bf.menapln.entity.Session;
import bf.menapln.enumeration.Sexe;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class InscriptionRepository extends Repository implements InterfaceDAO{

    public InscriptionRepository(Factory factory) {
        super(factory);
    }
    @Override
    public Objet save(Objet objet) throws SQLException {
        Inscription inscription = (Inscription)objet;
        String sql;
        sql = "INSERT INTO inscription(session_id,candidat_id,etablissement_id,typeCandidat_id,option_id,\n"
                + "typeInscription_id,natureHandicap_id,prescription_id,\n"
                + "sport,anneeDernierDiplome,dateInscription,centreExamen_id,concoursRattache,groupePedagogique_id,\n"
                + "typeSituation_id,telephone,telephoneDeux,zone_id,numeroDossier)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getSession().getId());
        pstmt.setLong(2, inscription.getCandidat().getId());
        pstmt.setLong(3, inscription.getCandidat().getEtablissementCandidat().getId());
        pstmt.setLong(4, inscription.getCandidat().getTypeCandidat().getId());
        pstmt.setLong(5, inscription.getCandidat().getOption().getId());
        pstmt.setLong(6, inscription.getCandidat().getTypeInscription().getId());
        if(inscription.getCandidat().getNatureHandicap() == null){
            pstmt.setObject(7, null);
        }else{
            pstmt.setLong(7, inscription.getCandidat().getNatureHandicap().getId());
        }
        if(inscription.getCandidat().getPrescriptionHandicap() == null){
            pstmt.setObject(8, null);
        }else{
            pstmt.setLong(8, inscription.getCandidat().getPrescriptionHandicap().getId());
        }
        pstmt.setString(9, inscription.getCandidat().getSport());
        pstmt.setLong(10, inscription.getCandidat().getAnneeDernierDiplome());
        pstmt.setString(11, inscription.getAddDate().toString());
        pstmt.setLong(12, inscription.getCandidat().getCentreExamen().getId());
        pstmt.setLong(13, inscription.getCandidat().getConcoursRatache().getId());
        pstmt.setLong(14, inscription.getCandidat().getGroupePedagogique().getId());
        pstmt.setLong(15, inscription.getCandidat().getTypeSituation().getId());
        pstmt.setString(16, inscription.getCandidat().getTelephone());
        pstmt.setString(17, inscription.getCandidat().getTelephoneDeux());
        pstmt.setLong(18, inscription.getCandidat().getZone().getId());
        pstmt.setString(19, inscription.getNumeroDossier());
        pstmt.executeUpdate();
        this.factory.close();
        pstmt.close();
        return inscription;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql = "DELETE FROM inscription WHERE candidat_id = ? and session_id = ? and etablissement_id = ? and numeroDossier = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidat.getId());
        pstmt.setLong(2, candidat.getSession().getId());
        pstmt.setLong(3, candidat.getEtablissementCandidat().getId());
        pstmt.setString(4, candidat.getNumeroDossier());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return candidat;  // La suppression a réussi, retournez l'objet Dispense supprimé
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        Inscription inscription = (Inscription)objet;
        String sql = "UPDATE inscription SET session_id=?, etablissement_id=?, typeCandidat_id=?, option_id=?, "
            + "typeInscription_id=?, natureHandicap_id=?, prescription_id=?, sport=?, anneeDernierDiplome=?, "
            + "dateInscription=?, centreExamen_id=?, concoursRattache=?, groupePedagogique_id=?, typeSituation_id=?, "
            + "telephone=?, telephoneDeux=?, zone_id=? WHERE candidat_id=? and session_id = ? and etablissement_id = ? and numeroDossier = ?";
    
        
        try (Connection connection = this.factory.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        connection.setAutoCommit(false);
       //PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getSession().getId());
        pstmt.setLong(2, inscription.getCandidat().getEtablissementCandidat().getId());
        pstmt.setLong(3, inscription.getCandidat().getTypeCandidat().getId());
        pstmt.setLong(4, inscription.getCandidat().getOption().getId());
        pstmt.setLong(5, inscription.getCandidat().getTypeInscription().getId());
        
        if (inscription.getCandidat().getNatureHandicap() == null) {
            pstmt.setObject(6, null);
        } else {
            pstmt.setLong(6, inscription.getCandidat().getNatureHandicap().getId());
        }
        
        if (inscription.getCandidat().getPrescriptionHandicap() == null) {
            pstmt.setObject(7, null);
        } else {
            pstmt.setLong(7, inscription.getCandidat().getPrescriptionHandicap().getId());
        }
        
        pstmt.setString(8, inscription.getCandidat().getSport());
        pstmt.setLong(9, inscription.getCandidat().getAnneeDernierDiplome());
        pstmt.setString(10, inscription.getCandidat().getAddDate().toString());
        pstmt.setLong(11, inscription.getCandidat().getCentreExamen().getId());
        pstmt.setLong(12, inscription.getCandidat().getConcoursRatache().getId());
        pstmt.setLong(13, inscription.getCandidat().getGroupePedagogique().getId());
        pstmt.setLong(14, inscription.getCandidat().getTypeSituation().getId());
        pstmt.setString(15, inscription.getCandidat().getTelephone());
        pstmt.setString(16, inscription.getCandidat().getTelephoneDeux());
        pstmt.setLong(17, inscription.getCandidat().getZone().getId());
        pstmt.setLong(18, inscription.getCandidat().getId());
        pstmt.setLong(19, inscription.getSession().getId());
        pstmt.setLong(20, inscription.getCandidat().getEtablissementCandidat().getId());
        pstmt.setString(21, inscription.getCandidat().getNumeroDossier());

        pstmt.executeUpdate();
        connection.commit();
       } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }

    return inscription;
    }

    public Objet upadteZone(Objet objet) throws SQLException {
        Candidat inscription = (Candidat)objet;
        String sql = "UPDATE inscription set zone_id = ? where session_id = ? and candidat_id = ? and etablissement_id= ? and numeroDossier = ?";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getZone().getId());
        pstmt.setLong(2, inscription.getSession().getId());
        pstmt.setLong(3, inscription.getId());
        pstmt.setLong(4, inscription.getEtablissementCandidat().getId());
        pstmt.setString(5, inscription.getNumeroDossier());
        pstmt.executeUpdate();
        return inscription;
    }
    
    public Objet upadtePV(Objet objet) throws SQLException {
        Inscription inscription = (Inscription)objet;
        String sql = "UPDATE inscription set numeroPV = ? where session_id = ? and candidat_id = ? and etablissement_id= ? and numeroDossier = ?";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getCandidat().getNumeroPv());
        pstmt.setLong(2, inscription.getSession().getId());
        pstmt.setLong(3, inscription.getCandidat().getId());
        pstmt.setLong(4, inscription.getCandidat().getEtablissementCandidat().getId());
        pstmt.setString(5, inscription.getCandidat().getNumeroDossier());
        pstmt.executeUpdate();
        return inscription;
    }

    public Objet upadteCentre(Objet objet) throws SQLException {
        Candidat inscription = (Candidat)objet;
        String sql = "UPDATE inscription set centreExamen_id = ? where session_id = ? and candidat_id = ? and etablissement_id= ? and numeroDossier = ?";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getCentreExamen().getId());
       // pstmt.setLong(2, inscription.getCentreExamen().getCentre().getId());
       // pstmt.setLong(3, inscription.getCentreExamen().getLocalite().getId());
        pstmt.setLong(2, inscription.getSession().getId());
        pstmt.setLong(3, inscription.getId());
        pstmt.setLong(4, inscription.getEtablissementCandidat().getId());
        pstmt.setString(5, inscription.getNumeroDossier());
        pstmt.executeUpdate();
        return inscription;
    }

    public Objet deletePV(Objet objet) throws SQLException {
        Inscription inscription = (Inscription)objet;
        String sql = "UPDATE inscription set numeroPV = NULL where session_id = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, inscription.getSession().getId());
        pstmt.executeUpdate();
        return inscription;
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

    public void updateAptitudeListe() throws SQLException {
            String sql = "select * from inscription i LEFT JOIN dispense disp ON disp.candidat_id = i.candidat_id where i.sport = 'Inapte' and disp.candidat_id IS NULL";
            PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        ResultSet rs    = stmt.executeQuery();
        List<Candidat> liste = new ArrayList<Candidat>();
        while (rs.next()) {
            Candidat candidat = Candidat.id(rs.getLong("candidat_id"));
            liste.add(candidat);
        }
        if(liste != null)
        for (Candidat candidat : liste) {
            String sql1 = "insert into dispense(session_id,candidat_id,epreuve_id) VALUES (?,?,?);";
            PreparedStatement pstmt = this.factory.connect().prepareStatement(sql1);
            pstmt.setLong(1, 1);
            pstmt.setLong(2, candidat.getId());
            pstmt.setLong(3, 13);
            this.factory.close();
            pstmt.close();
            rs.close();
            pstmt.executeUpdate();
        }
    }

    public void updateCorrecteur() throws SQLException {
       // String sql = "update feuilleComposition set correcteur_id = 43 where epreuve_id = 13 and correcteur_id is NULL";
        String sql = "update feuilleComposition set correcteur_id = 41 where epreuve_id = 4 and correcteur_id is NULL";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.executeUpdate();
    }

    public void updateEtatJury() throws SQLException {
            String sql = "SELECT jury.jury_id FROM jury LEFT JOIN etatjury ON jury.jury_id = etatjury.jury_id AND etatjury.tourComposition_id = 2 WHERE etatjury.jury_id IS NULL";
            PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        ResultSet rs    = stmt.executeQuery();
        List<Jury> liste = new ArrayList<Jury>();
        while (rs.next()) {
            Jury jury = Jury.id(rs.getLong("jury_id"));
            liste.add(jury);
        }
        if(liste != null)
        for (Jury jury : liste) {
            String sql1 = "insert into etatjury(session_id,jury_id,tourcomposition_id,actif,valide) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = this.factory.connect().prepareStatement(sql1);
            pstmt.setLong(1, 1);
            pstmt.setLong(2, jury.getId());
            pstmt.setLong(3, 2);
            pstmt.setBoolean(4, false);
            pstmt.setBoolean(5, false);


            pstmt.executeUpdate();
        }
    }
    
}
