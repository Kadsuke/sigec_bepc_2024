/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.enumeration.Sexe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class CandidatRepository extends Repository implements InterfaceDAO{

    public CandidatRepository(Factory factory) {
        super(factory);
    }

    public Candidat recupCandidatActuel(Candidat cand) throws SQLException{
        
        String sql = "Select * from candidat where candidat_id = ?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, cand.getId());
        ResultSet rs    = stmt.executeQuery();

        Candidat candidat = new Candidat();

        while (rs.next()) {
        candidat.setIue(rs.getString("iue"));
        candidat.setNom(rs.getString("nom"));
        candidat.setPrenom(rs.getString("prenom"));
        candidat.setSexe(Sexe.valueOf(rs.getString("sexe")));
        candidat.setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
        candidat.setTypeDateNaissance(rs.getString("typeDateNaissance"));
        candidat.setLieuNaissance(rs.getString("lieuNaissance"));
        candidat.setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
        candidat.setNomMere(rs.getString("nomMere"));
        candidat.setPrenomMere(rs.getString("prenomMere"));
        candidat.setNomPere(rs.getString("nomPere"));
        candidat.setPrenomPere(rs.getString("prenomPere"));
        candidat.setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
        candidat.setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
    }
        this.factory.close();
        stmt.close();
        rs.close();
        return candidat;
    }
    @Override
    public Objet save(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql;
        sql = "INSERT INTO candidat(candidat_id,paysNaissance_id,paysNationalite_id,nom,prenom,sexe,\n"
                +"dateNaissance,numeroActeNaissance,lieuNaissance,lienActeNaissance,lienPhoto,etablissement_id,"
                + "session_id,nomPere,prenomPere,nomMere,prenomMere,typeDateNaissance)\n"
                +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Long dernier = this.lastInsertedId();
                if (dernier!=null) {dernier+=1;
                }else{dernier =1L;
                }
                candidat.setId(dernier);
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, candidat.getId());
        pstmt.setLong(2, candidat.getPaysNaissance().getId());
        pstmt.setLong(3, candidat.getNationalite().getId());
        pstmt.setString(4, candidat.getNom());
        pstmt.setString(5, candidat.getPrenom());
        pstmt.setString(6, candidat.getSexe().name());
        pstmt.setString(7, candidat.getDateNaissance().toString());
        if(candidat.getNumeroActeNaissance() == null){
            pstmt.setObject(8, null);
        }else{
            pstmt.setString(8, candidat.getNumeroActeNaissance());
        }
        
        pstmt.setString(9, candidat.getLieuNaissance());
        pstmt.setString(10, candidat.getLienActeNaissance());
        pstmt.setString(11, candidat.getLienPhoto());
        pstmt.setLong(12, candidat.getEtablissementCandidat().getId());
        pstmt.setLong(13, candidat.getSession().getId());
        pstmt.setString(14, candidat.getNomPere());
        pstmt.setString(15, candidat.getPrenomPere());
        pstmt.setString(16, candidat.getNomMere());
        pstmt.setString(17, candidat.getPrenomMere());
        pstmt.setString(18, candidat.getTypeDateNaissance());
        
        pstmt.executeUpdate();
        candidat.setId(this.lastInsertedId());
        this.factory.close();
        pstmt.close();
        return candidat;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql = "DELETE FROM candidat WHERE candidat_id = ? and session_id= ? and etablissement_id = ? and numeroDossier = ?";
       try (Connection connection = this.factory.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setLong(1, candidat.getId());
        pstmt.setLong(2, candidat.getSession().getId());
        pstmt.setLong(3, candidat.getEtablissementCandidat().getId());
        pstmt.setString(4, candidat.getNumeroDossier());
        pstmt.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; //
    }
        return candidat;  // La suppression a réussi, retournez l'objet Dispense supprimé
    }
    

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        Candidat candidat = (Candidat)objet;
        String sql = "UPDATE candidat SET paysNaissance_id=?, paysNationalite_id=?, nom=?, prenom=?, sexe=?, dateNaissance=?, "
            + "numeroActeNaissance=?, lieuNaissance=?, lienActeNaissance=?, lienPhoto=?, etablissement_id=?, session_id=?, "
            + "nomPere=?, prenomPere=?, nomMere=?, prenomMere=?, typeDateNaissance=? WHERE candidat_id=? and session_id= ? and etablissement_id = ? and numeroDossier = ?";
        
        try (Connection connection = this.factory.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
      // PreparedStatement pstmt = this.factory.connect().prepareStatement;
      connection.setAutoCommit(false);
        pstmt.setLong(1, candidat.getPaysNaissance().getId());
        pstmt.setLong(2, candidat.getNationalite().getId());
        pstmt.setString(3, candidat.getNom());
        pstmt.setString(4, candidat.getPrenom());
        pstmt.setString(5, candidat.getSexe().name());
        pstmt.setString(6, candidat.getDateNaissance().toString());
        
        if (candidat.getNumeroActeNaissance() == null) {
            pstmt.setObject(7, null);
        } else {
            pstmt.setString(7, candidat.getNumeroActeNaissance());
        }
        pstmt.setString(8, candidat.getLieuNaissance());
        pstmt.setString(9, candidat.getLienActeNaissance());
        pstmt.setString(10, candidat.getLienPhoto());
        pstmt.setLong(11, candidat.getEtablissementCandidat().getId());
        pstmt.setLong(12, candidat.getSession().getId());
        pstmt.setString(13, candidat.getNomPere());
        pstmt.setString(14, candidat.getPrenomPere());
        pstmt.setString(15, candidat.getNomMere());
        pstmt.setString(16, candidat.getPrenomMere());
        pstmt.setString(17, candidat.getTypeDateNaissance());
        pstmt.setLong(18, candidat.getId());
        pstmt.setLong(19, candidat.getSession().getId());
        pstmt.setLong(20, candidat.getEtablissementCandidat().getId());
        pstmt.setString(21, candidat.getNumeroDossier());
        pstmt.executeUpdate();
        connection.commit();
       } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
    }

    return candidat;
    }

    @Override
    public List<Objet> getAll() throws SQLException {
         try (Connection connection = this.factory.connect();
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM viewCandidatsInscrits order by region_id,province_id,commune_id,nom,prenom")) {
             connection.setAutoCommit(false);
            List<Objet> candidats = new ArrayList<Objet>();
            while (rs.next()) {
                long candidatId = rs.getLong("candidat_id");
                String numeroDossier = rs.getString("numeroDossier");
                long sessionId = rs.getLong("session_id");
                long etablissementId = rs.getLong("structure_id");
                Candidat candidat = null;
                for (Objet c : candidats) {
                    if (c instanceof Candidat && ((Candidat) c).getId() == candidatId &&
                            ((Candidat) c).getNumeroDossier().equalsIgnoreCase(numeroDossier) && 
                            ((Candidat) c).getSession().getId() ==  sessionId && 
                            ((Candidat) c).getEtablissementCandidat().getId() == etablissementId) {
                   // if (c.getId() == candidatId ) {
                        candidat = (Candidat)c;
                        break;
                    }
                }
                if (candidat == null) {
                    candidat = new Candidat();
                    candidat.setId(candidatId);

                //candidat.setId(rs.getLong("candidat_id"));
                    candidat.setIue(rs.getString("iue"));
                    candidat.setNom(rs.getString("nom"));
                    candidat.setPrenom(rs.getString("prenom"));
                    candidat.setSexe(Sexe.valueOf(rs.getString("sexe")));
                    candidat.setTelephone(rs.getString("telephone"));
                    candidat.setTelephoneDeux(rs.getString("telephoneDeux"));
                    candidat.setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
                    candidat.setTypeDateNaissance(rs.getString("typeDateNaissance"));
                    candidat.setLieuNaissance(rs.getString("lieuNaissance"));
                    candidat.setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
                    candidat.setLienActeNaissance(rs.getString("lienActeNaissance"));
                    candidat.setLienPhoto(rs.getString("lienPhoto"));
                    candidat.setAnneeDernierDiplome(rs.getLong("anneeDernierDiplome"));
                    candidat.setNomMere(rs.getString("nomMere"));
                    candidat.setPrenomMere(rs.getString("prenomMere"));
                    candidat.setNomPere(rs.getString("nomPere"));
                    candidat.setPrenomPere(rs.getString("prenomPere"));
                    candidat.setNumeroDossier(rs.getString("numeroDossier"));
                    //Session
                    candidat.setSession(Session.id(rs.getLong("session_id")));
                    candidat.getSession().setAnnee(rs.getLong("annee"));
                    //Pays
                    candidat.setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
                    candidat.getPaysNaissance().setNomPays(rs.getString("nomPays"));
                    //Nationalite
                    candidat.setNationalite(Pays.id(rs.getLong("nationalite_id")));
                    candidat.getNationalite().setNationalite(rs.getString("nationalite"));
                    candidat.getNationalite().setPaysToString(false);
                    //Type Inscription
                    candidat.setTypeInscription(Type.id(rs.getLong("typeInsc_id")));
                    candidat.getTypeInscription().setLibelle(rs.getString("typeInsc_libelle"));
                    //Type Statut
                    candidat.setTypeCandidat(Type.id(rs.getLong("typeCandidat_id")));
                    candidat.getTypeCandidat().setLibelle(rs.getString("typeCandidatLibelle"));
                    //Type Situation
                    candidat.setTypeSituation(Type.id(rs.getLong("tpSituation_id")));
                    candidat.getTypeSituation().setLibelle(rs.getString("tpSituation_libelle"));
                    //Type Handicap
                    candidat.setTypeHandicap(Type.id(rs.getLong("typeH_id")));
                    candidat.getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
                    //Nature Handicap
                    candidat.setNatureHandicap(NatureHandicap.id(rs.getLong("natureH_id")));
                    candidat.getNatureHandicap().setNatureHandicapLibelle(rs.getString("natureH_libelle"));
                    //Prescription Handicap
                    candidat.setPrescriptionHandicap(Type.id(rs.getLong("presci_id")));
                    candidat.getPrescriptionHandicap().setLibelle(rs.getString("presci_libelle"));
                    //Sport
                    candidat.setSport(rs.getString("sport"));
                    //Options
                    candidat.setOption(Option.id(rs.getLong("option_id")));
                    candidat.getOption().setOptionLibelle(rs.getString("optionLibelle"));
                    //Concours
                    candidat.setConcoursRatache(Type.id(rs.getLong("concoursRattache_id")));
                    candidat.getConcoursRatache().setLibelle(rs.getString("concoursRattacheLibelle"));
                    //Groupe Pedagogique
                    candidat.setGroupePedagogique((GroupePedagogique.id(rs.getLong("gp_id"))));
                    candidat.getGroupePedagogique().setGroupePedagogiqueLibelle(rs.getString("gp_libelle"));
                    //Etablissement
                    candidat.setEtablissementCandidat((Structure.id(rs.getLong("structure_id"))));
                    candidat.getEtablissementCandidat().setNomStructure(rs.getString("nomStructure"));
                    //Zone
                    candidat.setZone((Localite.id(rs.getLong("zone_id"))));
                    candidat.getZone().setNomLoclite(rs.getString("nom_zone"));
                    //Centre d'Examen  
                    candidat.setCentreExamen((Localite.id(rs.getLong("centreExamenId"))));
                    candidat.getCentreExamen().setNomLoclite(rs.getString("libelleVilleComposition"));
                    // Commune
                    candidat.getCentreExamen().setParentLocalite((Localite.id(rs.getLong("commune_id"))));
                    candidat.getCentreExamen().getParentLocalite().setNomLoclite(rs.getString("libelleCommune"));
                    // Province
                    candidat.getCentreExamen().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("province_id")));
                    candidat.getCentreExamen().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleProvince"));
                    // Region
                    candidat.getCentreExamen().getParentLocalite().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("region_id")));
                    candidat.getCentreExamen().getParentLocalite().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("libelleRegion"));
                        
                    
                    //candidat.getCentreExamen().setTypeLocalite(Type.id(rs.getLong("centreType")));
                   // candidat.getCentreExamen().getTypeLocalite().setLibelle(rs.getString("libelleTypeLocal"));
                    
                    candidats.add(candidat);
                }
                        SerieConcours serie = new SerieConcours();
                        serie.setSerie(Type.id(rs.getLong("serieChoix")));
                        serie.getSerie().setLibelle(rs.getString("serieLibelle"));

                        Structure etablissement = new Structure();
                        etablissement.setId(rs.getLong("etabChoix_id"));
                        etablissement.setAcronymeStructure(rs.getString("etabChoix_accronyme"));
                        etablissement.setNomStructure(rs.getString("etabChoix_nom"));

                        HashMap<Structure, SerieConcours> choixEtabSerie = candidat.getChoixEtabSerie();
                        if (choixEtabSerie == null) {
                            choixEtabSerie = new HashMap<>();
                        }
                            choixEtabSerie.put(etablissement, serie);
                            candidat.setChoixEtabSerie(choixEtabSerie);
                        }
       connection.commit();
       return candidats;
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    
 public List<Objet> getCandidatsInscrits(Session session) throws SQLException {
        String sql = "SELECT * FROM viewCandidatsInscrits where session_id = ? order by region_id,province_id,commune_id,nom,prenom";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, session.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Map<String,Candidat> choixCandidat = new HashMap<String,Candidat>();
        while (rs.next()) {
            String key = rs.getLong("candidat_id")+"_"+rs.getLong("structure_id");
            if (!choixCandidat.containsKey(key)) {
                Candidat candidat = new Candidat(rs);
                candidat.setOption(new Option(rs));
                candidat.setEtablissementCandidat(new Etablissement(rs));
                candidat.getEtablissementCandidat().setLocalite(new Commune(rs));
                candidat.setPaysNaissance(new PaysNaissance(rs));
                candidat.setNationalite(new PaysNationalite(rs));
                candidat.setTypeCandidat(new TypeCandidature(rs));
                candidat.setTypeInscription(new TypeInscription(rs));
                candidat.setVilleComposition(new VilleComposition(rs));
                candidat.setGroupePedagogique(new GroupePedagogique(rs));
                candidat.setZone(new Zone(rs));
                candidat.setTypeHandicap(new TypeHandicap(rs));
                candidat.setNatureHandicap(new NatureHandicap(rs));
                candidat.setPrescriptionHandicap(new PrescriptionHandicap(rs));
                candidat.setTypeSituation(new TypeSituation(rs));
                candidat.setSession(new Session(rs));
                candidat.setChoixEtablissements(new ArrayList<>());
                if(rs.getString("concoursRattache") != null){
                    candidat.setConcoursRatache(Type.id(rs.getLong("concoursRattache_id")));
                    candidat.getConcoursRatache().setLibelle(rs.getString("concoursRattacheLibelle"));
                }
                choixCandidat.put(key, candidat);
                liste.add(candidat);
            }
            
            if (rs.getString("serieChoix") != null) {
                SerieConcours serie = new SerieConcours(rs);
                ChoixEtablissement choix = new ChoixEtablissement(rs);
                choix.setSerie(serie);
               choixCandidat.get(key).getChoixEtablissements().add(choix);
            }
        }
        // System.out.println("Liste candidat : "+liste.size());
        return liste;
    }
    
    public List<Objet> getCandidat(Option serie, Localite centreExamen) throws SQLException {
       String sql = "SELECT * FROM viewCandidat where serie_id = ? and villeComposition = ?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, serie.getId());
        stmt.setLong(2, centreExamen.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Candidat candidat = new Candidat(rs);
            candidat.setId(rs.getLong("candidat_id"));
            candidat.setIue(rs.getString("iue"));
            candidat.setNom(rs.getString("nom"));
            candidat.setPrenom(rs.getString("prenom"));
            candidat.setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidat.setTelephone(rs.getString("telephone"));
            candidat.setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidat.setLieuNaissance(rs.getString("lieuNaissance"));
            candidat.setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidat.setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidat.setLienPhoto(rs.getString("lienPhoto"));
            candidat.setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
            candidat.setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidat.setOption(Option.id(rs.getLong("serie_id")));
            candidat.getOption().setOptionLibelle(rs.getString("serieLibelle"));
            
            liste.add(candidat);
        }
        this.factory.close();
        stmt.close();
        rs.close();
        return liste;
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        String sql = "SELECT * FROM viewCandidat where numeroPV = ?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs    = stmt.executeQuery();

        Candidat candidatt = new Candidat();

        while (rs.next()) {
          //  candidatt.setId(rs.getLong("candidat_id"));
            candidatt.setIue(rs.getString("iue"));
            candidatt.setNom(rs.getString("nom"));
            candidatt.setPrenom(rs.getString("prenom"));
            candidatt.setSexe(Sexe.valueOf(rs.getString("sexe")));
            candidatt.setTelephone(rs.getString("telephone"));
            candidatt.setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
            candidatt.setLieuNaissance(rs.getString("lieuNaissance"));
            candidatt.setNumeroActeNaissance(rs.getString("numeroActeNaissance"));
            candidatt.setLienActeNaissance(rs.getString("lienActeNaissance"));
            candidatt.setLienPhoto(rs.getString("lienPhoto"));
            candidatt.setPaysNaissance(Pays.id(rs.getLong("paysNaissance_id")));
            candidatt.setNationalite(Pays.id(rs.getLong("paysNationalite_id")));
            candidatt.setSport(rs.getString("sport"));
            candidatt.setOption(Option.id(rs.getLong("serie_id")));
            candidatt.getOption().setOptionLibelle(rs.getString("serieLibelle"));
        }
        this.factory.close();
        stmt.close();
        rs.close();
        return candidatt;    
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        try (Connection connection = this.factory.connect();
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM candidat ORDER BY candidat_id DESC LIMIT 1")) {
            Long id = null;
            while (rs.next()) {
                id = rs.getLong("candidat_id");
            }
            return id;
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Long createId() throws SQLException{
        try (Connection connection = this.factory.connect();
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM candidat ORDER BY candidat_id DESC LIMIT 1")) {
        
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("candidat_id");
        }
         return (id==null)?1:id+1;
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    
    public int nbreCandidatTotalFille(String stat) throws SQLException{
        String sql = "SELECT * FROM viewCandidat WHERE sexe='Féminin' ";
        //String sq = "";
        switch (stat) {
            case "Entrée en Seconde":
                sql+="AND concoursRattacheLibelle = 'Entrée en Seconde'";
                break;
            case "Prémière année BEP":
                sql+="AND concoursRattacheLibelle = 'Prémière année BEP'";
                break;
            case "BEPC SEUL":
                sql+="AND concoursRattacheLibelle = 'BEPC SEUL'";
                break;
            case "PC":
                sql+="AND optionLibelle = 'PC'";
                break;
            case "PCAL":
                sql+="AND optionLibelle = 'PCAL'";
                break;
            case "PCAR":
                sql+="AND optionLibelle = 'PCAR'";
                break;
            case "PCITA":
                sql+="AND optionLibelle = 'PCITA'";
                break;
            case "PCESP":
                sql+="AND optionLibelle = 'PCESP'";
                break;
            case "Apte":
                sql+="AND sport = 'Apte'";
                break;
            case "Inapte":
                sql+="AND sport = 'Inapte'";
                break;
            case "Regulier":
                sql+="AND typeCandidatLibelle = 'Régulier'";
                break;
            case "Libre":
                sql+="AND typeCandidatLibelle = 'Libre'";
                break;
            default:
                sql=sql;
        }
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
         while (rs.next()) {
              Candidat candidat = new Candidat(rs);
              liste.add(candidat);
         }
        this.factory.close();
        stmt.close();
        rs.close();
        return liste.size();
    }
    
    public int nbreCandidatTotalGarcon(String stat) throws SQLException{
        String sql = "SELECT * FROM viewCandidat WHERE sexe='Masculin'";
        switch (stat) {
            case "Entrée en Seconde":
                sql+="AND concoursRattacheLibelle = 'Entrée en Seconde'";
                break;
            case "Prémière année BEP":
                sql+="AND concoursRattacheLibelle = 'Prémière année BEP'";
                break;
            case "BEPC SEUL":
                sql+="AND concoursRattacheLibelle = 'BEPC SEUL'";
                break;
            case "PC":
                sql+="AND optionLibelle = 'PC'";
                break;
            case "PCAL":
                sql+="AND optionLibelle = 'PCAL'";
                break;
            case "PCAR":
                sql+="AND optionLibelle = 'PCAR'";
                break;
            case "PCITA":
                sql+="AND optionLibelle = 'PCITA'";
                break;
            case "PCESP":
                sql+="AND optionLibelle = 'PCESP'";
                break;
            case "Apte":
                sql+="AND sport = 'Apte'";
                break;
            case "Inapte":
                sql+="AND sport = 'Inapte'";
                break;
            /*case "EDI":
                sql+="AND situationLibelle = 'EDI'";
                break;
            case "Normale":
                sql+="AND situationLibelle = 'Normale'";
                break;
            case "EVO":
                sql+="AND situationLibelle = 'EVO'";
                break;*/
            case "Regulier":
                sql+="AND typeCandidatLibelle = 'Régulier'";
                break;
            case "Libre":
                sql+="AND typeCandidatLibelle = 'Libre'";
                break;
            default:
                sql=sql;
        }
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
         while (rs.next()) {
              Candidat candidat = new Candidat(rs);
              liste.add(candidat);
         }
        this.factory.close();
        stmt.close();
        rs.close();
        return liste.size();
    }

    
}
