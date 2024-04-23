/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Candidat;
import bf.menapln.entity.CandidatPosteJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Critere;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.GroupePedagogique;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Modalite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.enumeration.TypeCentres;

import java.sql.Connection;
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
public class JuryRepository extends Repository implements InterfaceDAO{

    public JuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Jury jury = (Jury)objet; 
        String sql;
        sql = "INSERT INTO jury(session_id,juryLibelle,juryCapacite,centreComposition_id,jury_id)\n"
                + "VALUES(?,?,?,?,?)";
        Long dernier = this.lastInsertedId();
        if (dernier!=null) {dernier+=1;
        }else{dernier = 1L;}
        jury.setId(dernier);
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, jury.getSession().getId());
        pstmt.setString(2, jury.getJuryLibelle());
        pstmt.setLong(3, jury.getJuryCapacite());        
        pstmt.setLong(4, jury.getCentreComposition().getEtablissement().getId());         
        pstmt.setLong(5, jury.getId());
        pstmt.executeUpdate();
        jury.setId(this.lastInsertedId());
        return jury;
    }

    
    @Override
    public Objet delete(Objet objet) throws SQLException {
        Jury gp = (Jury)objet;
        String sql = "DELETE FROM jury WHERE jury_id = ? and session_id = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, gp.getId());
        pstmt.setLong(2, gp.getSession().getId());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }
        return gp;  // 
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        Jury inscription = (Jury)objet;
        String sql = "UPDATE jury set juryLibelle = ?,juryCapacite where session_id = ? and jury_id = ?";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setString(1, inscription.getJuryLibelle());
        pstmt.setLong(2, inscription.getJuryCapacite());
        pstmt.setLong(3, inscription.getSession().getId());
        pstmt.setLong(4, inscription.getId());
        pstmt.executeUpdate();
        return inscription;
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewJury"; 
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        List<Objet> jurys = new ArrayList<Objet>();
        while (rs.next()) {
                long juryId = rs.getLong("jury_id");
                String juryLibelle = rs.getString("juryLibelle");
                Jury jury = null;
                for (Objet j : jurys) {
                    if (j instanceof Jury && ((Jury) j).getId() == juryId &&
                            ((Jury) j).getJuryLibelle().equalsIgnoreCase(juryLibelle)) {
                                jury = (Jury)j;
                                break;
                    }
                }

                if (jury == null) {
                    jury = new Jury();
                    jury.setId(rs.getLong("jury_id"));
                    jury.setJuryLibelle(rs.getString("juryLibelle"));
                    jury.setJuryCapacite(rs.getLong("juryCapacite"));
                             
                    CentreComposition c = new CentreComposition();
                    Etablissement etab = new Etablissement();
                    etab.setId(rs.getLong("centreCompo_id"));
                    etab.setNomStructure(rs.getString("centreCompo_libelle"));
                    c.setEtablissement(etab);
                    c.setZone(Localite.id(rs.getLong("zone_id")));
                    jury.setCentreComposition(c);
                    jury.setSession(Session.id(rs.getLong("session_id")));
                    jury.setCentreSecondaires(this.getCentreSecondaires(jury));
                    jury.setChecked(true);
                    jurys.add(jury);

            }
            if(rs.getString("typeCentre").equals("PRINCIPAL")){
                Localite csr = new Localite();
                csr.setId(rs.getLong("localite_id"));
                csr.setNomLoclite(rs.getString("nomLocalite"));
                jury.setCentreExamen(csr);
            }   
            
        }
        return jurys;
    }

    // Recupération des critères d'un acteur donné
    public List<Localite> getCentreSecondaires(Jury c) throws SQLException {
        String sql = "SELECT * FROM viewJury WHERE session_id= ? AND jury_id= ? AND typeCentre= ?";
        //Statement stmt  = this.factory.connect().createStatement();
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, c.getSession().getId());
        stmt.setLong(2, c.getId());
        stmt.setString(3, "SECONDAIRE");
        ResultSet rs    = stmt.executeQuery();
        List<Localite> liste = new ArrayList<Localite>();
        while (rs.next()) {
            Localite cs = new Localite();
            cs.setId(rs.getLong("localite_id"));
            cs.setNomLoclite(rs.getString("nomLocalite"));
            liste.add(cs);
        }
     //   System.out.println("Ensemble Liste"+liste);
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
