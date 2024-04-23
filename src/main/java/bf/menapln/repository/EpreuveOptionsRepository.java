/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.EpreuveOptions;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.entity.Pays;
import bf.menapln.entity.Session;
import bf.menapln.entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class EpreuveOptionsRepository extends Repository implements InterfaceDAO{

    public EpreuveOptionsRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        EpreuveOptions epreuveOptions = (EpreuveOptions)objet;
        String sql;
        sql = "INSERT INTO epreuveOption(epreuve_id,option_id,session_id,typeEpreuve_id,coefficient,duree,estComposePreTour,estComposeSecTour,estRachetable,ordreEpreuve)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, epreuveOptions.getEpreuve().getId());
        pstmt.setLong(2, epreuveOptions.getOption().getId());
        pstmt.setLong(3, epreuveOptions.getSession().getId());
        pstmt.setLong(4, epreuveOptions.getTypeEpreuve().getId());
        pstmt.setLong(5, epreuveOptions.getCoefficient());
        pstmt.setString(6, epreuveOptions.getDuree());
        pstmt.setString(7, epreuveOptions.getEstComposePreTour());
        pstmt.setString(8, epreuveOptions.getEstComposeSecTour());
        pstmt.setString(9, epreuveOptions.getEstRachetable());
        pstmt.setLong(10, epreuveOptions.getOrdreEpreuve());
        pstmt.executeUpdate();
        return epreuveOptions;
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
         String sql = "SELECT * FROM epreuveOption";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            EpreuveOptions epreuveOptions = new EpreuveOptions();
            epreuveOptions.setId(rs.getLong("epreuveOption_id"));
          //  epreuveOptions.setEpreuveLibelle(rs.getString("indicatif"));
           // epreuveOptions.setNomPays(rs.getString("nomPays"));
         //   epreuveOptions.setNationalite(rs.getString("nationalite"));
            
            liste.add(epreuveOptions);
        }
        return liste;
    }
    
    public List<Objet> getAllByEpreuve(Epreuve epreuve) throws SQLException {
        String sql = "SELECT * FROM viewEpreuveOption where epreuve_id = ?";
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, epreuve.getParent().getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Option option = new Option();
            option.setId(rs.getLong("option_id"));
            option.setOptionLibelle(rs.getString("optionLibelle"));
            liste.add(option);
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
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM epreuveOption ORDER BY epreuveOption_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("epreuveOption_id");
        }
        return id;
    }

    }
   
    /*
    public List<Epreuve> getAllOptionByEpreuve() throws SQLException{
        String sql = "SELECT * FROM viewEpreuveSerie";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        
        List<Epreuve> epreuves = new ArrayList<Epreuve>();
        int i = 0;
        Map epreuveid = new HashMap<Long,Integer>();
        Epreuve epreuve = null;
        while (rs.next()) {
            if(!epreuveid.containsKey(rs.getLong("epreuve_id"))){
                epreuve = Epreuve.id(rs.getLong("epreuve_id"));
                epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
                epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
                epreuve.setCoefficient(rs.getLong("coefficient"));
                epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
                epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
                epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
                epreuve.setEstRachetable(rs.getBoolean("estRachetable"));
                epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
                epreuve.setSession(Session.id(rs.getLong("session_id")));
                epreuve.getSession().setAnnee(rs.getLong("annee"));
                epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
                epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
                epreuveid.put(epreuve.getId(), i);
                epreuves.add(epreuve);
                i++;
            }
            Option serie = Option.id(rs.getLong("serie_id"));
            serie.setSerieLibelle(rs.getString("serieLibelle"));
            serie.setDefinition(rs.getString("definition"));
            epreuves.get((int) epreuveid.get(rs.getLong("epreuve_id"))).addSerie(serie);
        }
        return epreuves;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        String sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estComposePreTour = ? ORDER BY ordreEpreuve";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.setBoolean(2, true);
        ResultSet rs    = stmt.executeQuery();
        Option serie = null;
        while (rs.next()) {
            if(serie == null){
                serie = new Option();
                serie.setId(rs.getLong("serie_id"));
                serie.setSerieLibelle(rs.getString("serieLibelle"));
                serie.setDefinition(rs.getString("definition"));
            }
            Epreuve epreuve = Epreuve.id(rs.getLong("epreuve_id"));
            epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
            epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            epreuve.setCoefficient(rs.getLong("coefficient"));
            epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
            epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
            epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
            epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
            epreuve.setEstRachetable(rs.getBoolean("estRachetable"));
            epreuve.setSession(Session.id(rs.getLong("session_id")));
            epreuve.getSession().setAnnee(rs.getLong("annee"));
            epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
            epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
            serie.addEpreuve(epreuve);
        }
        return (serie == null)?new Option():serie;
    }
    
    public Objet getEpreuveSecTourBySerie(Long id) throws SQLException {
        String sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estComposeSecTour = ? ORDER BY ordreEpreuve";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.setBoolean(2, true);
        ResultSet rs    = stmt.executeQuery();
        Option serie = null;
        while (rs.next()) {
            if(serie == null){
                serie = new Option();
                serie.setId(rs.getLong("serie_id"));
                serie.setSerieLibelle(rs.getString("serieLibelle"));
                serie.setDefinition(rs.getString("definition"));
            }
            Epreuve epreuve = Epreuve.id(rs.getLong("epreuve_id"));
            epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
            epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            epreuve.setCoefficient(rs.getLong("coefficient"));
            epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
            epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
            epreuve.setSession(Session.id(rs.getLong("session_id")));
            epreuve.getSession().setAnnee(rs.getLong("annee"));
            epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
            epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
            serie.addEpreuve(epreuve);
        }
        return (serie == null)?new Option():serie;
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        return null;
    }


    public List<Epreuve> getAllEpreuveByNoFrancais() throws SQLException{
        String sql = "SELECT * FROM viewEpreuveSerie";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        
        List<Epreuve> epreuves = new ArrayList<Epreuve>();
        int i = 0;
        Map epreuveid = new HashMap<Long,Integer>();
        Epreuve epreuve = null;
        while (rs.next()) {
            if(!epreuveid.containsKey(rs.getLong("epreuve_id"))){
                epreuve = Epreuve.id(rs.getLong("epreuve_id"));
                epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
                epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
                epreuve.setCoefficient(rs.getLong("coefficient"));
                epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
                epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
                epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
                epreuve.setEstRachetable(rs.getBoolean("estRachetabe"));
                epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
                epreuve.setSession(Session.id(rs.getLong("session_id")));
                epreuve.getSession().setAnnee(rs.getLong("annee"));
                epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
                epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
                epreuveid.put(epreuve.getId(), i);
                epreuves.add(epreuve);
                i++;
            }
            Option serie = Option.id(rs.getLong("serie_id"));
            serie.setSerieLibelle(rs.getString("serieLibelle"));
            serie.setDefinition(rs.getString("definition"));
            epreuves.get((int) epreuveid.get(rs.getLong("epreuve_id"))).addSerie(serie);
        }
        return epreuves;
    }
    
    public Objet getEpreuvePreTourBySerie(Long id) throws SQLException {
        String sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estComposePreTour = ? ORDER BY ordreEpreuve";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.setBoolean(2, true);
        ResultSet rs    = stmt.executeQuery();
        Option serie = null;
        while (rs.next()) {
            if(serie == null){
                serie = new Option();
                serie.setId(rs.getLong("serie_id"));
                serie.setSerieLibelle(rs.getString("serieLibelle"));
                serie.setDefinition(rs.getString("definition"));
            }
            Epreuve epreuve = Epreuve.id(rs.getLong("epreuve_id"));
            epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
            epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            epreuve.setCoefficient(rs.getLong("coefficient"));
            epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
            epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
            epreuve.setSession(Session.id(rs.getLong("session_id")));
            epreuve.getSession().setAnnee(rs.getLong("annee"));
            epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
            epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
            serie.addEpreuve(epreuve);
        }
        return (serie == null)?new Option():serie;
    }


    public List<Epreuve> getAllSerieByEpreuveNofr() throws SQLException{
        String sql = "SELECT * FROM viewEpreuveSerie where estTypeFrancais = ? and typeEpreuve_id != ? and epreuve_id != ?";
        
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setBoolean(1, false);
        stmt.setLong(2, 3);
        stmt.setLong(3, 15);
        ResultSet rs    = stmt.executeQuery();
        
        List<Epreuve> epreuves = new ArrayList<Epreuve>();
        int i = 0;
        Map epreuveid = new HashMap<Long,Integer>();
        Epreuve epreuve = null;
        while (rs.next()) {
            if(!epreuveid.containsKey(rs.getLong("epreuve_id"))){
                epreuve = Epreuve.id(rs.getLong("epreuve_id"));
                epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
                epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
                epreuve.setCoefficient(rs.getLong("coefficient"));
                epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
                epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
                epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
                epreuve.setEstRachetable(rs.getBoolean("estRachetable"));
                epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
                epreuve.setSession(Session.id(rs.getLong("session_id")));
                epreuve.getSession().setAnnee(rs.getLong("annee"));
                epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
                epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
                epreuveid.put(epreuve.getId(), i);
                epreuves.add(epreuve);
                i++;
            }
            Option serie = Option.id(rs.getLong("serie_id"));
            serie.setSerieLibelle(rs.getString("serieLibelle"));
            serie.setDefinition(rs.getString("definition"));
            epreuves.get((int) epreuveid.get(rs.getLong("epreuve_id"))).addSerie(serie);
        }
        return epreuves;
    }

    public Objet getByIdTour(Long id,Jury jury) throws SQLException {
        String sql;
        PreparedStatement pstmt;
        switch(jury.getEtape().getTourCode()){
            case 2:
                sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estTypeFrancais = ? ORDER BY ordreEpreuve";
                pstmt  = this.factory.connect().prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.setBoolean(2, false);
            break;
            default:
                sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estComposePreTour = ? ORDER BY ordreEpreuve";
                pstmt  = this.factory.connect().prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.setBoolean(2, true);
            break;
        }
        ResultSet rs    = pstmt.executeQuery();
        Option serie = null;
        while (rs.next()) {
            if(serie == null){
                serie = new Option();
                serie.setId(rs.getLong("serie_id"));
                serie.setSerieLibelle(rs.getString("serieLibelle"));
                serie.setDefinition(rs.getString("definition"));
            }
            Epreuve epreuve = Epreuve.id(rs.getLong("epreuve_id"));
            epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
            epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            epreuve.setCoefficient(rs.getLong("coefficient"));
            epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
            epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
            epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
            epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
            epreuve.setEstRachetable(rs.getBoolean("estRachetable"));
            epreuve.setSession(Session.id(rs.getLong("session_id")));
            epreuve.getSession().setAnnee(rs.getLong("annee"));
            epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
            epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
            serie.addEpreuve(epreuve);
        }
        return (serie == null)?new Option():serie;
    }

    /***
     * PM
     */
    /*
    public Objet getByIdTourPremier(Long id,Jury jury) throws SQLException {
        String sql;
        PreparedStatement pstmt;
                sql = "SELECT * FROM viewEpreuveSerie where serie_id = ? and estComposePreTour = ? ORDER BY ordreEpreuve";
                pstmt  = this.factory.connect().prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.setBoolean(2, true);
        ResultSet rs    = pstmt.executeQuery();
        Option serie = null;
        while (rs.next()) {
            if(serie == null){
                serie = new Option();
                serie.setId(rs.getLong("serie_id"));
                serie.setSerieLibelle(rs.getString("serieLibelle"));
                serie.setDefinition(rs.getString("definition"));
            }
            Epreuve epreuve = Epreuve.id(rs.getLong("epreuve_id"));
            epreuve.setEpreuveLibelle(rs.getString("epreuveLibelle"));
            epreuve.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
            epreuve.setCoefficient(rs.getLong("coefficient"));
            epreuve.setDuree(LocalTime.parse(rs.getString("duree")));
            epreuve.setEstComposeSecTour(rs.getBoolean("estComposeSecTour"));
            epreuve.setEstComposePreTour(rs.getBoolean("estComposePreTour"));
            epreuve.setEstTypeFrancais(rs.getBoolean("estTypeFrancais"));
            epreuve.setEstRachetable(rs.getBoolean("estRachetable"));
            epreuve.setSession(Session.id(rs.getLong("session_id")));
            epreuve.getSession().setAnnee(rs.getLong("annee"));
            epreuve.setTypeEpreuve(Type.id(rs.getLong("typeEpreuve_id")));
            epreuve.getTypeEpreuve().setLibelle(rs.getString("typeEpreuveLibelle"));
            serie.addEpreuve(epreuve);
        }
        return (serie == null)?new Option():serie;
    }
 */

   