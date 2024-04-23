/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.CandidatPosteJury;
import bf.menapln.entity.Correcteur;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Membre;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.entity.Structure;
import bf.menapln.entity.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class MembreJuryRepository extends Repository implements InterfaceDAO{

    public MembreJuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Membre p = (Membre)objet;
        String sql;
        sql = "INSERT INTO membreJury(session_id,jury_id,poste_id,personnel_id,centreExamen_id) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, p.getSession().getId());
        pstmt.setLong(2, p.getJury().getId());        
        pstmt.setLong(3, p.getPoste().getId());
        pstmt.setLong(4, p.getPersonnel().getId());
        pstmt.setLong(5, p.getJury().getCentreExamen().getId());
        pstmt.executeUpdate();
        return p;
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
        String sql = "SELECT * FROM viewMembreJury";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        Membre membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("personnel_id"))){
                membre = new Membre(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                ids.put(rs.getLong("personnel_id"), "");
                liste.add(membre);
            }
            //membre.getEpreuve().addSerie(new Serie(rs));
        }
        return liste;
    }

    public List<Objet> getCorrecteurs(Jury jury){
        
        return null;
    }
    
    public List<Objet> getCorrecteurs(Epreuve epreuve){
        
        return null;
    }
    
    public List<Objet> getCorrecteurs(Session session,Jury jury,Epreuve epreuve) throws SQLException{
        String sql = "SELECT * FROM viewMembreJury where session_id = ? and jury_id = ? and epreuve_id = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, session.getId());
        pstmt.setLong(2, jury.getId());
        pstmt.setLong(3, epreuve.getId());
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        Correcteur membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("personnel_id"))){
                membre = new Correcteur(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                ids.put(rs.getLong("personnel_id"), "");
                liste.add(membre);
            }
            //membre.getEpreuve().addSerie(new Serie(rs));
        }
        return liste;
    }

    public List<Objet> getCorrecteursFr(Session session,Jury jury,Epreuve epreuve) throws SQLException{
        String sql = "SELECT * FROM viewMembreJury where session_id = ? and jury_id = ? and epreuveLibelle = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, session.getId());
        pstmt.setLong(2, jury.getId());
        pstmt.setString(3, "Français");
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        Correcteur membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("personnel_id"))){
                membre = new Correcteur(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                ids.put(rs.getLong("personnel_id"), "");
                liste.add(membre);
            }
            //membre.getEpreuve().addSerie(new Serie(rs));
        }
        return liste;
    }

    public List<Objet> getCorrecteursAng(Session session,Jury jury,Epreuve epreuve) throws SQLException{
        String sql = "SELECT * FROM viewMembreJury where session_id = ? and jury_id = ? and epreuveLibelle = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, session.getId());
        pstmt.setLong(2, jury.getId());
        pstmt.setString(3, "Anglais écrit");
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        Correcteur membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("personnel_id"))){
                membre = new Correcteur(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                ids.put(rs.getLong("personnel_id"), "");
                liste.add(membre);
            }
            //membre.getEpreuve().addSerie(new Serie(rs));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Objet> getAllByJury(Jury jury) throws SQLException {
        String sql = "SELECT * FROM viewMembreJury where jury_id = ?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, jury.getId());
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        Membre membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("personnel_id"))){
                membre = new Membre(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                ids.put(rs.getLong("personnel_id"), "");
                liste.add(membre);
            }
            //membre.getEpreuve().addSerie(new Serie(rs));
        }
        return liste;
    }

    // Pour affectation des acteurs
    public List<Objet> getAllMembreJury() throws SQLException {
        String sql = "SELECT * FROM viewAffectationMembreJury"; 
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        CandidatPosteJury candidat = null;
        Map ids = new HashMap();
        Correcteur membre = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("candidat_id"))){
                membre = new Correcteur(rs);
                membre.getPersonnel().setId(rs.getLong("personnel_id"));
                if(rs.getString("jury_id") != null){
                    membre.setJury(new Jury(rs));
                }
                candidat = new CandidatPosteJury(rs);
                    candidat.getCandidat().setId(rs.getLong("candidat_id"));
                 // Commune
                    candidat.setLocaliteCand(Localite.id(rs.getLong("commune_id")));
                    candidat.getLocaliteCand().setNomLoclite(rs.getString("nom_commune"));
                    // Province
                    candidat.getLocaliteCand().setParentLocalite(Localite.id(rs.getLong("province_id")));
                    candidat.getLocaliteCand().getParentLocalite().setNomLoclite(rs.getString("nom_province"));
                    // Region
                    candidat.getLocaliteCand().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("region_id")));
                    candidat.getLocaliteCand().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("nom_region"));
                    // Type Structure
                    candidat.setStructure((Structure.id(rs.getLong("structure_id"))));
                    candidat.getStructure().setAcronymeStructure(rs.getString("acronymeStructure"));
                    candidat.getStructure().setCodeStructure(rs.getString("codeStructure"));
                    candidat.getStructure().setNomStructure(rs.getString("nomStructure"));
                    candidat.getStructure().setTypeStructure((Type.id(rs.getLong("type_id"))));
                    candidat.getStructure().getTypeStructure().setLibelle(rs.getString("type_libelle"));
                    candidat.setEtatCandidature(rs.getString("etatCandidature"));
                    // Poste
                    candidat.setPoste(Type.id(rs.getLong("poste_id")));
                    candidat.getPoste().setLibelle(rs.getString("posteLibelle"));
                    membre.setCandidatPosteJury(candidat);
                ids.put(rs.getLong("candidat_id"), membre.getCandidatPosteJury());
                liste.add(membre);
            }
            long epreuveId = rs.getLong("epreuve_id");
                Epreuve epAv = new Epreuve();
                epAv.setId(epreuveId);
                epAv.setEpreuveLibelle(rs.getString("epreuveLibelle"));
                if (!candidat.getEpreuves().contains(epAv)) {
                        Epreuve ep = new Epreuve();
                        ep.setId(epreuveId);
                        ep.setEpreuveLibelle(rs.getString("epreuveLibelle"));

                        // Ajouter l'épreuve au candidat
                        candidat.addEpreuve(ep);

                        // Ajouter l'identifiant de l'épreuve à l'ensemble
                        candidat.getEpreuves().add(ep);
                    }
            
        }
        // System.out.println("MEMBRE JURY REPO : "+liste);
        return liste;
    }
}
