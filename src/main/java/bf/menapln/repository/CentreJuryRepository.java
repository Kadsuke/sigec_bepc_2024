/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.CandidatPosteJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreJury;
import bf.menapln.entity.Critere;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Modalite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author kadsuke
 */
public class CentreJuryRepository extends Repository implements InterfaceDAO{

    public CentreJuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CentreJury centrejury = (CentreJury)objet; 
        String sql;
        sql = "INSERT INTO centrejury(session_id,centreComposition_id,centreExamen_id,jury_id,typeCentre)\n"
                + "VALUES(?,?,?,?,?)";
       
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, centrejury.getJury().getSession().getId());
        pstmt.setLong(2, centrejury.getJury().getCentreComposition().getEtablissement().getId());
        pstmt.setLong(3, centrejury.getCentre().getId());     
        pstmt.setLong(4, centrejury.getJury().getId());
        pstmt.setString(5, centrejury.getTypeCentres().toString());      
        pstmt.executeUpdate();
        return centrejury;
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
        String sql = "SELECT * FROM viewJury";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Jury jury = new Jury();
            jury.setJuryCapacite(rs.getLong("juryCapacite"));
            jury.setId(rs.getLong("jury_id"));
            jury.setJuryLibelle(rs.getString("juryLibelle"));
            jury.setCentreExamen(Localite.id(rs.getLong("CentreExamen_id")));
            //jury.getCentreExamen().setCentre(rs.getString("nomLocalite"));
      //      Centre c = new Centre();
       //     c.setEtatblissement(new Etablissement(rs));
        //    jury.setCentre(c);
            jury.setSession(Session.id(rs.getLong("session_id")))   ;
        //    jury.setCentreSecondaires(this.getCentreSecondaires(jury));

            // jury.setChecked(true);
            // System.out.println("CENTRE JURY :"+jury.getCentre().getEtatblissement());
            liste.add(jury);
        }
        return liste;
    }

    // Recupération des critères d'un acteur donné
    public List<Centre> getCentreSecondaires(Jury c) throws SQLException {
        String sql = "SELECT * FROM viewCentreSecondaire WHERE session_id="+c.getSession().getId()+" AND jury_id="+c.getId()+" AND CentreExamen_id="+c.getCentreExamen().getId();
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Centre> liste = new ArrayList<Centre>();
        while (rs.next()) {
            Centre cs = new Centre();
            liste.add(cs);
        }
        return liste;
    }

    public List<Objet> getAllDefaultJury() throws SQLException {
        String sql = "SELECT * FROM jury";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Jury jury = new Jury();
            jury.setJuryCapacite(rs.getLong("juryCapacite"));
            jury.setId(rs.getLong("jury_id"));
            jury.setJuryLibelle(rs.getString("juryLibelle"));
         //   jury.setCentreExamen(Localite.id(rs.getLong("CentreExamen_id")));
            liste.add(jury);
        }
        return liste;
    }
    
    public List<Objet> getJury(Localite etab) throws SQLException {
        String sql = "SELECT * FROM viewJury where CentreExamen_id = ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, etab.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Jury jury = Jury.id(rs.getLong("jury_id"));
            jury.setJuryCapacite(rs.getLong("juryCapacite"));
            jury.setJuryLibelle(rs.getString("juryLibelle"));
         //   jury.setCentreExamen(Localite.id(rs.getLong("CentreExamen_id")));
          //  jury.getCentreExamen().setNomLoclite(rs.getString("nomLocalite"));
            /* jury.setCentre(new Centre());
            jury.getCentre().setCapacite(rs.getLong("capacite"));
            jury.getCentre().setSession(Session.id(rs.getLong("session_id")));
            jury.getCentre().getSession().setAnnee(rs.getLong("annee"));
           
            jury.getCentre().setEtatblissement(Etablissement.id(rs.getLong("etablissement_id")));
            jury.getCentre().getEtatblissement().setCodeStructure(rs.getString("codeStructure"));
            jury.getCentre().getEtatblissement().setNomStructure(rs.getString("nomStructure"));
            jury.getCentre().getEtatblissement().setAcronymeStructure(rs.getString("acronymeStructure"));
             */
            liste.add(jury);
        }
        return liste;
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override 
    public Objet getById(Long id) throws SQLException {
        String sql = "SELECT * FROM viewJury where jury_id = ?";
        System.out.println("DANS JURYREPO : ID DU JURY EST : "+id);
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs    = stmt.executeQuery();
        Jury jury = null;
        while (rs.next()) {
            jury = new Jury(rs);
            jury.setSession(new Session(rs));
        }
        return jury;
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM jury ORDER BY jury_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("jury_id");
        }
        return id;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // 
    public List<Objet> getAllByCentreExamen(Localite centreExamen) throws SQLException {
        return this.getAll().stream().filter(j->((Jury)j).getCentreExamen().getId().equals(centreExamen.getId())).collect(Collectors.toList());
    }
}
