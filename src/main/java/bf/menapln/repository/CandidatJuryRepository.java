/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Candidat;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.NatureHandicap;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.entity.Pays;
import bf.menapln.entity.Structure;
import bf.menapln.entity.Type;
import bf.menapln.enumeration.Sexe;
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
public class CandidatJuryRepository extends Repository implements InterfaceDAO{

    public CandidatJuryRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CandidatJury candidat = (CandidatJury)objet;
        String sql;
        sql = "INSERT INTO candidatJury(session_id,jury_id,centreComposition_id,candidat_id,etablissement_id)\n"
                +"VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, candidat.getSession().getId());  
        pstmt.setLong(2, candidat.getJury().getId());
        pstmt.setLong(3, candidat.getJury().getCentreExamen().getId());
        pstmt.setLong(4, candidat.getCandidat().getId());        
        pstmt.setLong(5, candidat.getCandidat().getEtablissementCandidat().getId());
        pstmt.executeUpdate();
        return candidat;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        CandidatJury candidat = (CandidatJury)objet;
        String sql;
        sql = "DELETE FROM candidatJury WHERE session_id=? AND jury_id=? AND centreExamen_id=? AND candidat_id=? AND etablissement_id=?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, candidat.getSession().getId());  
        pstmt.setLong(2, candidat.getJury().getId());
        pstmt.setLong(3, candidat.getJury().getCentreExamen().getId());
        pstmt.setLong(4, candidat.getCandidat().getId());        
        pstmt.setLong(5, candidat.getCandidat().getEtablissementCandidat().getId());
        pstmt.executeUpdate();
        return candidat;
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewAffectationCandidatJury";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CandidatJury candidat = new CandidatJury();
            if(rs.getString("jury_id") != null){
                candidat.setJury(Jury.id(rs.getLong("jury_id")));
                candidat.getJury().setJuryLibelle(rs.getString("juryLibelle"));
            }
            candidat.setCandidat(Candidat.id(rs.getLong("candidat_id")));
            candidat.getCandidat().setIue(rs.getString("iue"));
            candidat.getCandidat().setNom(rs.getString("nom"));
            candidat.getCandidat().setPrenom(rs.getString("prenom"));
            candidat.getCandidat().setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidat.getCandidat().setTelephone(rs.getString("telephone"));
            candidat.getCandidat().setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidat.getCandidat().setLieuNaissance(rs.getString("lieuNaissance"));
            candidat.getCandidat().setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidat.getCandidat().setNumeroDossier(rs.getString("numeroDossier"));
            candidat.getCandidat().setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidat.getCandidat().setLienPhoto(rs.getString("lienPhoto"));
            candidat.getCandidat().setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
            candidat.getCandidat().setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidat.getCandidat().setOption(Option.id(rs.getLong("option_id")));
            candidat.getCandidat().getOption().setOptionLibelle(rs.getString("optionLibelle"));
            candidat.getCandidat().setZone(Localite.id(rs.getLong("zone_id")));
            candidat.getCandidat().setCentreExamen((Localite.id(rs.getLong("centreExamen_id"))));
            candidat.getCandidat().getCentreExamen().setNomLoclite(rs.getString("libelleCentreExamen"));
            candidat.getCandidat().setEtablissementCandidat(Structure.id(rs.getLong("etablissement_id")));
            candidat.getCandidat().getEtablissementCandidat().setNomStructure(rs.getString("nomStructure"));
            candidat.getCandidat().getEtablissementCandidat().setAcronymeStructure(rs.getString("acronymeStructure"));
             //Type Handicap
             candidat.getCandidat().setTypeHandicap(Type.id(rs.getLong("typeH_id")));
             candidat.getCandidat().getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
             //Nature Handicap
             candidat.getCandidat().setNatureHandicap(NatureHandicap.id(rs.getLong("natureH_id")));
             candidat.getCandidat().getNatureHandicap().setNatureHandicapLibelle(rs.getString("natureH_libelle"));
             //Prescription Handicap
             candidat.getCandidat().setPrescriptionHandicap(Type.id(rs.getLong("presci_id")));
             candidat.getCandidat().getPrescriptionHandicap().setLibelle(rs.getString("presci_libelle"));

            candidat.getCandidat().setSport(rs.getString("sport"));
            candidat.setSession(Session.id(rs.getLong("session_id")));
            candidat.getSession().setId(rs.getLong("session_id"));
            candidat.getSession().setAnnee(rs.getLong("annee"));
            if (candidat.getJury() != null) {
               candidat.getJury().setCentreExamen(candidat.getCandidat().getCentreExamen());
           }
            liste.add(candidat);
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

    public List<Objet> getCandidatOrdered() throws SQLException {
        String sql = "SELECT * FROM viewCandidatJury ORDER BY juryLibelle,nom,prenom";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CandidatJury candidat = new CandidatJury();
            if(rs.getString("jury_id") != null){
                candidat.setJury(Jury.id(rs.getLong("jury_id")));
                candidat.getJury().setJuryLibelle(rs.getString("juryLibelle"));
            }
            candidat.setSession(Session.id(rs.getLong("session_id")));
            candidat.getSession().setAnnee(rs.getLong("annee"));
            candidat.setCandidat(Candidat.id(rs.getLong("candidat_id")));
            candidat.getCandidat().setIue(rs.getString("iue"));
            candidat.getCandidat().setNom(rs.getString("nom"));
            candidat.getCandidat().setPrenom(rs.getString("prenom"));
            candidat.getCandidat().setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidat.getCandidat().setNumeroDossier(rs.getString("numeroDossier"));
            candidat.getCandidat().setTelephone(rs.getString("telephone"));
            candidat.getCandidat().setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidat.getCandidat().setLieuNaissance(rs.getString("lieuNaissance"));
            candidat.getCandidat().setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidat.getCandidat().setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidat.getCandidat().setLienPhoto(rs.getString("lienPhoto"));
            if(rs.getString("numeroPV") != null){candidat.getCandidat().setNumeroPv(rs.getInt("numeroPV"));}
            candidat.getCandidat().setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
            candidat.getCandidat().setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidat.getCandidat().setOption(Option.id(rs.getLong("option_id")));
            candidat.getCandidat().getOption().setOptionLibelle(rs.getString("optionLibelle"));
            candidat.getCandidat().setCentreExamen((Localite.id(rs.getLong("centre_identifiant"))));
         //   candidat.getCandidat().getCentreExamen().setCentre(Localite.id(rs.getLong("centre_id")));
         //   candidat.getCandidat().getCentreExamen().getCentre().setNomLoclite(rs.getString("nomLocalite"));
            
            liste.add(candidat);
        }
        return liste;
    }

    public List<Objet> getCandidatJury(Jury jury) throws SQLException {
        String sql;
        PreparedStatement stmt = null;
        int test = 1;
        switch(test){
            case 2:
                sql = "SELECT * FROM viewCandidatJury where jury_id = ? and codeDecisionJury = ?\n"
                +" ORDER BY numeroPV";
                stmt = this.factory.connect().prepareStatement(sql);
                stmt.setLong(1, jury.getId());
                // stmt.setInt(2, jury.getEtape().getTourCode());
                stmt.setInt(2, 1);
            break;
            default:
                sql = "SELECT * FROM viewCandidatJury where jury_id = ?\n"
                +" ORDER BY numeroPV";
                stmt = this.factory.connect().prepareStatement(sql);
                stmt.setLong(1, jury.getId());
            break;
        }
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CandidatJury candidat = new CandidatJury();
            candidat.setJury(Jury.id(rs.getLong("jury_id")));
            candidat.getJury().setJuryLibelle(rs.getString("juryLibelle"));
            
            candidat.setCandidat(Candidat.id(rs.getLong("candidat_id")));
            candidat.getCandidat().setIue(rs.getString("iue"));
            candidat.getCandidat().setNom(rs.getString("nom"));
            candidat.getCandidat().setPrenom(rs.getString("prenom"));
            candidat.getCandidat().setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidat.getCandidat().setTelephone(rs.getString("telephone"));
            candidat.getCandidat().setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidat.getCandidat().setLieuNaissance(rs.getString("lieuNaissance"));
            candidat.getCandidat().setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidat.getCandidat().setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidat.getCandidat().setLienPhoto(rs.getString("lienPhoto"));
            if(rs.getString("numeroPV") != null){
                candidat.getCandidat().setNumeroPv(rs.getInt("numeroPV"));
            }
            candidat.getCandidat().setNumeroDossier(rs.getString("numeroDossier"));
            candidat.getCandidat().setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
            candidat.getCandidat().setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidat.getCandidat().setOption(Option.id(rs.getLong("option_id")));
            candidat.getCandidat().getOption().setOptionLibelle(rs.getString("optionLibelle"));
            candidat.getCandidat().setCentreExamen((Localite.id(rs.getLong("centre_identifiant"))));
          //  candidat.getCandidat().getCentreExamen().setCentre(Localite.id(rs.getLong("centre_id")));
           // candidat.getCandidat().getCentreExamen().getCentre().setNomLoclite(rs.getString("nomLocalite"));
            
            liste.add(candidat);
        }
        return liste;
    }

   //Candidat affectation 
    public List<Objet> getAllCandidatJury() throws SQLException {
        String sql = "SELECT * FROM viewAffectationCandidatJury";
        Statement stmt  = this.factory.connect().createStatement(); 
        ResultSet rs    = stmt.executeQuery(sql) ;
        List<Objet> liste = new ArrayList<Objet>();  
        while (rs.next()) { 
            CandidatJury candidat = new CandidatJury();
            if(rs.getString("jury_id") != null){
                candidat.setJury(Jury.id(rs.getLong("jury_id")));
                candidat.getJury().setJuryLibelle(rs.getString("juryLibelle"));
            }
            candidat.setCandidat(Candidat.id(rs.getLong("candidat_id")));
            candidat.getCandidat().setIue(rs.getString("iue"));
            candidat.getCandidat().setNom(rs.getString("nom"));
            candidat.getCandidat().setPrenom(rs.getString("prenom"));
            candidat.getCandidat().setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidat.getCandidat().setNumeroPv(rs.getInt("numeroPV"));
            candidat.getCandidat().setTelephone(rs.getString("telephone"));
            candidat.getCandidat().setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidat.getCandidat().setTypeDateNaissance(rs.getString("typeDateNaissance"));
            candidat.getCandidat().setLieuNaissance(rs.getString("lieuNaissance"));
            candidat.getCandidat().setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidat.getCandidat().setNumeroDossier(rs.getString("numeroDossier"));
            candidat.getCandidat().setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidat.getCandidat().setLienPhoto(rs.getString("lienPhoto"));
            candidat.getCandidat().setZone(Localite.id(rs.getLong("zone_id")));
            candidat.getCandidat().setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id"))); 
            candidat.getCandidat().setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidat.getCandidat().setOption(Option.id(rs.getLong("option_id")));
            candidat.getCandidat().getOption().setOptionLibelle(rs.getString("optionLibelle"));
            candidat.getCandidat().setCentreExamen((Localite.id(rs.getLong("centreExamen_id"))));
            candidat.getCandidat().getCentreExamen().setNomLoclite(rs.getString("libelleCentreExamen"));
           // candidat.getCandidat().getCentreExamen((Localite.id(rs.getLong("centreExamen_id"))));
            candidat.getCandidat().setEtablissementCandidat(Structure.id(rs.getLong("etablissement_id")));
            candidat.getCandidat().getEtablissementCandidat().setNomStructure(rs.getString("nomStructure"));
            candidat.getCandidat().getEtablissementCandidat().setAcronymeStructure(rs.getString("acronymeStructure"));
            //Type Handicap
            candidat.getCandidat().setTypeHandicap(Type.id(rs.getLong("typeH_id")));
            candidat.getCandidat().getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
            //Nature Handicap
            candidat.getCandidat().setNatureHandicap(NatureHandicap.id(rs.getLong("natureH_id")));
            candidat.getCandidat().getNatureHandicap().setNatureHandicapLibelle(rs.getString("natureH_libelle"));
            //Prescription Handicap
            candidat.getCandidat().setPrescriptionHandicap(Type.id(rs.getLong("presci_id")));
            candidat.getCandidat().getPrescriptionHandicap().setLibelle(rs.getString("presci_libelle"));
            candidat.getCandidat().setSport(rs.getString("sport"));
            candidat.setSession(Session.id(rs.getLong("session_id")));
            candidat.getSession().setId(rs.getLong("session_id"));
            candidat.getSession().setAnnee(rs.getLong("annee"));
            if (candidat.getJury() != null) {
                candidat.getJury().setCentreExamen(candidat.getCandidat().getCentreExamen());
            }
            if(rs.getString("typeLocaliteLibelle").equals("Commune")){
                System.out.println("typeCommune");
                candidat.getCandidat().getCentreExamen().setParentLocalite(Localite.id(rs.getLong("parentn1_id")));
                candidat.getCandidat().getCentreExamen().getParentLocalite().setNomLoclite(rs.getString("libelleParentn1"));
                candidat.getCandidat().getCentreExamen().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("parentn2_id")));
                candidat.getCandidat().getCentreExamen().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleParentn2"));
            }else{
                System.out.println("typeVillage"+rs.getString("typeLocaliteLibelle"));
                candidat.getCandidat().getCentreExamen().setParentLocalite(Localite.id(rs.getLong("parentn2_id")));
                candidat.getCandidat().getCentreExamen().getParentLocalite().setNomLoclite(rs.getString("libelleParentn2"));
                candidat.getCandidat().getCentreExamen().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("parentn3_id")));
                candidat.getCandidat().getCentreExamen().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleParentn3"));
            }
             liste.add(candidat);
        }
        return liste;
    }
}
