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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author coulibaly
 */
public class CandidatPosteJuryRepository extends Repository implements InterfaceDAO{

    public CandidatPosteJuryRepository(Factory factory) {
        super(factory);
    }

    public CandidatPosteJuryRepository(Connection con) {
        super(con);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CandidatPosteJury p = (CandidatPosteJury)objet;
        String sql;
        sql = "INSERT INTO candidatPosteJury(session_id,structure_id,\n"
                + "poste_id,nom,prenom,sexe,telephone,matricule,nip,candidat_id)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
         Long dernier = this.lastInsertedId();
                if (dernier!=null) {dernier+=1;}else{dernier =1L;}
                p.getCandidat().setId(dernier);
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, p.getSession().getId());
        // pstmt.setLong(2, p.getLocaliteCand().getId());
        pstmt.setLong(2, p.getStructure().getId());
        pstmt.setLong(3, p.getPoste().getId());
        pstmt.setString(4, p.getCandidat().getNom());
        pstmt.setString(5, p.getCandidat().getPrenom());
        pstmt.setString(6, p.getCandidat().getSexe().toString());
        pstmt.setString(7, p.getCandidat().getTelephone());
        pstmt.setString(8, p.getCandidat().getMatricule());
        pstmt.setString(9, p.getCandidat().getNip());
        pstmt.setLong(10, p.getCandidat().getId());
        pstmt.executeUpdate();
       // p.getCandidat().setId(this.lastInsertedId());
        this.factory.close();
        pstmt.close();
        return p;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        CandidatPosteJury candidatPosteJury = (CandidatPosteJury)objet;
        String sql = "DELETE FROM candidatPosteJury WHERE candidat_id = ? and structure_id = ?";
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

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        CandidatPosteJury candidat = (CandidatPosteJury)objet;
        String sql = "UPDATE candidatPosteJury set etatCandidature = ? WHERE candidat_id = ? and structure_id = ?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setString(1, candidat.getEtatCandidature());
        stmt.setLong(2, candidat.getCandidat().getId());
        stmt.setLong(3, candidat.getStructure().getId());
        stmt.executeUpdate();
        this.factory.close();
        stmt.close();
        return candidat;
    }
    
    public Objet updateCandidat(Objet objet) throws SQLException{
        CandidatPosteJury candidat = (CandidatPosteJury)objet;
        String sql = "UPDATE candidatPosteJury SET structure_id=?,poste_id = ?, nom=?, prenom=?, sexe=?,"
                + " telephone=?, matricule=?,nip=? WHERE candidat_id=? and structure_id = ?";
        try (Connection connection = this.factory.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
      connection.setAutoCommit(false);
        // pstmt.setLong(1, candidat.getLocaliteCand().getId());
        pstmt.setLong(1, candidat.getStructure().getId());
        pstmt.setLong(2, candidat.getPoste().getId());
        pstmt.setString(3, candidat.getCandidat().getNom());
        pstmt.setString(4, candidat.getCandidat().getPrenom());
        pstmt.setString(5, candidat.getCandidat().getSexe().name());
        pstmt.setString(6, candidat.getCandidat().getTelephone());
        pstmt.setString(7, candidat.getCandidat().getMatricule());
        pstmt.setString(8, candidat.getCandidat().getNip());
        pstmt.setLong(9, candidat.getCandidat().getId());
        pstmt.setLong(10, candidat.getStructure().getId());
        pstmt.executeUpdate();
        connection.commit();
    } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception ici
        throw e; // Vous pouvez choisir de la propager ou de la gérer localement
}

    return candidat;
 }
    
    public List<Critere> getCriteresOfCandidat(CandidatPosteJury c) throws SQLException {
        String sql = "SELECT * FROM viewCritereCandidatPosteJury WHERE session_id="+c.getSession().getId()+" AND candidat_id="+c.getCandidat().getId()+" AND structure_id="+c.getStructure().getId()+" AND poste_id="+c.getPoste().getId();
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Critere> liste = new ArrayList<Critere>();
        Map ids = new HashMap<>();
        while (rs.next()) {
            // Criteres
            if(!ids.containsKey(rs.getLong("critere_id"))){
                Critere critere = Critere.id(rs.getLong("critere_id"));
                critere.setModalites(new ArrayList<>());
                Modalite moda = Modalite.id(rs.getLong("modalite_id"));
                critere.getModalites().add(moda);
                liste.add(critere);
                ids.put(rs.getLong("critere_id"), critere);
            }else{
                ((Critere)ids.get(rs.getLong("critere_id"))).getModalites().add(Modalite.id(rs.getLong("modalite_id")));
            }
        }
        // System.out.println("Liste Critères sont :"+liste);
        return liste;
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewCandidatPosteJury";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> candidats = new ArrayList<Objet>();
        Map<String,CandidatPosteJury> ids = new HashMap<String,CandidatPosteJury>();
        while (rs.next()) {
            String key = rs.getLong("candidat_id")+"_"+rs.getLong("structure_id");
            if(!ids.containsKey(key)){
                CandidatPosteJury candidat = new CandidatPosteJury(rs);
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
                    candidat.setCriteres(this.getCriteresOfCandidat(candidat));
                    candidat.setEpreuve(new ArrayList<Epreuve>());
                    ids.put(key,candidat);
                    candidats.add(candidat);
            }
            if (rs.getString("epreuve_id") != null) {
                Epreuve epAv = new Epreuve();
                epAv.setId(rs.getLong("epreuve_id"));
                epAv.setEpreuveLibelle(rs.getString("epreuveLibelle"));
                if (!ids.get(key).getEpreuves().contains(epAv)) {
                    ids.get(key).getEpreuves().add(epAv);
                    Epreuve currentEp = epAv;
                    List<Objet> listOption = new ArrayList<Objet>();
                    Epreuve test = ids.get(key).getEpreuves().stream().filter(ep ->ep.getId().equals(currentEp.getId())).findFirst().orElse(new Epreuve());
                    if (test.getId() != null) { // Si l'epreuve existe déjà dans le Map
                        // Ajouter la spécialité à la liste des spé. de l'epreuve courante
                        listOption = test.getOption();
                        listOption.add(new Option(rs));
                        // System.out.println("Epreuv "+currentEp+ "  existe comme clé");
                        ((CandidatPosteJury)ids.get(key)).getEpreuves().stream().filter(ep ->ep.getId().equals(currentEp.getId())).findFirst().orElse(new Epreuve()).setOption(listOption);
                    } else {//Ajouter l'epreuve dans le map
                        //  System.out.println("Epreuv "+currentEp+ "  doit etre une nouvelle clé");
                        listOption.add(new Option(rs));
                        currentEp.setOption(listOption);
                        ((CandidatPosteJury)ids.get(key)).getEpreuves().add(currentEp);
                    }
                }
            }
        }
        return candidats;
    }

    /* @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewCandidatPosteJury";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> candidats = new ArrayList<Objet>();
        Set<Long> epreuveIds = new HashSet<>();
        Map<Long, Critere> ids = new HashMap<>();
        while (rs.next()) {
            long candidatId = rs.getLong("candidat_id");
            long structureId = rs.getLong("structure_id");
                CandidatPosteJury candidat = null;
                for (Objet c : candidats) {
                    if (c instanceof CandidatPosteJury && ((CandidatPosteJury) c).getCandidat().getId() == candidatId &&
                            ((CandidatPosteJury) c).getStructure().getId() == structureId) {
                   // if (c.getId() == candidatId ) {
                        candidat = (CandidatPosteJury)c;
                        break;
                    }
                }
                //System.out.println("Traitement du candidat : " + candidatId);
                if (candidat == null) {
                    //candidat = new CandidatPosteJury();
                    //candidat.setId(candidatId);
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
                    candidat.setCriteres(this.getCriteresOfCandidat(candidat));
                    candidats.add(candidat);

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
                
                epreuveIds.clear();
               
         }
        
        this.factory.close();
        stmt.close();
        rs.close();
        return candidats;
    } */

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
       String sql = "SELECT * FROM candidatPosteJury ORDER BY candidat_id DESC LIMIT 1";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("candidat_id");
        }
        this.factory.close();
        stmt.close();
        rs.close();
        return id;
        
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Objet> getAllWithoutRetenu() throws SQLException {
        String sql = "SELECT * FROM viewCandidatPosteJury where etatCandidature = 'Retenu'";
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Map ids = new HashMap();
        CandidatPosteJury candidat = null;
        while (rs.next()) {
            if(!ids.containsKey(rs.getLong("candidat_id"))){
                candidat = new CandidatPosteJury(rs);
                candidat.getCandidat().setId(rs.getLong("candidat_id"));
                ids.put(rs.getLong("candidat_id"), "");
                liste.add(candidat);
            }
        }
        this.factory.close();
        stmt.close();
        rs.close();
        return liste;
    }

    public Objet updateEtatCandidature(Objet objet) throws SQLException {
        CandidatPosteJury candidat = (CandidatPosteJury)objet;
        String sql = "UPDATE candidatPosteJury set etatCandidature = ? WHERE candidat_id = ? AND nip=? AND session_id=?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setString(1, candidat.getEtatCandidature());
        stmt.setLong(2, candidat.getCandidat().getId());
        stmt.setString(3, candidat.getCandidat().getNip());
        stmt.setLong(4, candidat.getSession().getId());
        stmt.executeUpdate();
        return candidat;
    }
}