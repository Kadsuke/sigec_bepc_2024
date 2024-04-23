/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.entity.Situation;
import bf.menapln.entity.Statistique;
import bf.menapln.entity.StatistiqueActeur;
import bf.menapln.entity.Type;
import bf.menapln.entity.TypeHandicap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiere
 */
public class StatistiqueRepository extends Repository implements InterfaceDAO{

    public StatistiqueRepository(Factory factory) {
        super(factory);
    }

  /*  public StatistiqueRepository(Connection connexion) {
        super(connexion);
    }*/
    
    @Override
    public Objet save(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Etab
    
    public List<Objet> getAllStatistiqueEtabByOption() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueEtabByOption")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique(rs);
            stat.setOption(new Option());
            stat.getOption().setOptionLibelle(rs.getString("optionLibelle"));
            liste.add(stat);
        }
       // connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    
    public List<Objet> getAllStatistiqueEtabBySituation() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueEtabBySituation")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique(rs);
            stat.setSituation(new Situation());
            stat.getSituation().setSituationLibelle(rs.getString("tpSituation_libelle"));
            liste.add(stat);
        }
//        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
        
    }
    
    public List<Objet> getAllStatistiqueByCentre() throws SQLException {
        String sql = "SELECT * FROM viewStatistiqueByCentre";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique(rs);
            liste.add(stat);
        }
        return liste;
    }
    
    public List<Objet> getAllStatistiqueByEtab() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueByEtab")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique(rs);
            liste.add(stat);
        }
//        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
    
    public List<Objet> getAllStatistiqueEtabByHandicap() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueEtabByHandicap")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique(rs);
            stat.setTypeHandicap(new Type());
            stat.getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
            liste.add(stat);
        }
       // connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    public List<Objet> getAllStatistiqueActeurByEtab() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueActeurByEtab")){
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            StatistiqueActeur stat = new StatistiqueActeur(rs);
            liste.add(stat);
        }
//        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    
    // Province
    
    public List<Objet> getAllStatistiqueProvinceByOption() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueProvinceByOption")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setOption(new Option());
            stat.getOption().setOptionLibelle(rs.getString("optionLibelle"));
            stat.setProvince(new Localite());
            stat.getProvince().setNomLoclite(rs.getString("nom_province"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    
    public List<Objet> getAllStatistiqueProvinceBySituation() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueProvinceBySituation")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setSituation(new Situation());
            stat.getSituation().setSituationLibelle(rs.getString("tpSituation_libelle"));
            stat.setProvince(new Localite());
            stat.getProvince().setNomLoclite(rs.getString("nom_province"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }

    public List<Objet> getAllStatistiqueByProvince() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueByProvince")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setProvince(new Localite());
            stat.getProvince().setNomLoclite(rs.getString("nom_province"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
    
    public List<Objet> getAllStatistiqueProvinceByHandicap() throws SQLException {        
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueProvinceByHandicap")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setTypeHandicap(new Type());
            stat.getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
            stat.setProvince(new Localite());
            stat.getProvince().setNomLoclite(rs.getString("nom_province"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    public List<Objet> getAllStatistiqueActeurByProvince() throws SQLException {        
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueActeurByProvince")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            StatistiqueActeur stat = new StatistiqueActeur(rs);
            stat.setProvince(new Localite());
            stat.getProvince().setNomLoclite(rs.getString("nom_province"));
            stat.setNbPresident(rs.getInt("nbPresident"));
            stat.setNbSecretaire(rs.getInt("nbSecretaire"));
            stat.setNbCorrecteur(rs.getInt("nbCorrecteur"));
            stat.setNbSuperviseur(rs.getInt("nbSuperviseur"));
            stat.setNbPresidentCentre(rs.getInt("nbPresidentCentreSecondaire"));
            stat.setNbVicePresident(rs.getInt("nbVicePresident"));
            liste.add(stat);
        }
      //  connection.commit();
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
}
    // Region
    
    public List<Objet> getAllStatistiqueRegionByOption() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueRegionByOption")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setOption(new Option());
            stat.getOption().setOptionLibelle(rs.getString("optionLibelle"));
            stat.setRegion(new Localite());
            stat.getRegion().setNomLoclite(rs.getString("nom_region"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
    
    public List<Objet> getAllStatistiqueRegionBySituation() throws SQLException {        
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueRegionBySituation")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setSituation(new Situation());
            stat.getSituation().setSituationLibelle(rs.getString("tpSituation_libelle"));
            stat.setRegion(new Localite());
            stat.getRegion().setNomLoclite(rs.getString("nom_region"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
         return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
   
    public List<Objet> getAllStatistiqueByRegion() throws SQLException {        
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueByRegion")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setRegion(new Localite());
            stat.getRegion().setNomLoclite(rs.getString("nom_region"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
    
    public List<Objet> getAllStatistiqueRegionByHandicap() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueRegionByHandicap")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Statistique stat = new Statistique();
            stat.setTypeHandicap(new Type());
            stat.getTypeHandicap().setLibelle(rs.getString("typeH_libelle"));
            stat.setRegion(new Localite());
            stat.getRegion().setNomLoclite(rs.getString("nom_region"));
            stat.setTotalInscrit(rs.getInt("tatalInscrits"));
            stat.setNbG(rs.getInt("nbG"));
            stat.setNbF(rs.getInt("nbF"));
            stat.setNbApte(rs.getInt("nbApte"));
            stat.setNbInapte(rs.getInt("nbInapte"));
            liste.add(stat);
        }
       return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
    public List<Objet> getAllStatistiqueActeurByRegion() throws SQLException {
        try (Connection connection = this.factory.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM viewStatistiqueActeurByRegion")){
            List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            StatistiqueActeur stat = new StatistiqueActeur();
            stat.setRegion(new Localite());
            stat.getRegion().setNomLoclite(rs.getString("nom_region"));
            stat.setNbPresident(rs.getInt("nbPresident"));
            stat.setNbSecretaire(rs.getInt("nbSecretaire"));
            stat.setNbCorrecteur(rs.getInt("nbCorrecteur"));
            stat.setNbSuperviseur(rs.getInt("nbSuperviseur"));
            stat.setNbPresidentCentre(rs.getInt("nbPresidentCentreSecondaire"));
            stat.setNbVicePresident(rs.getInt("nbVicePresident"));
            liste.add(stat);
        }
        return liste;
        } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Gérez l'exception ici ou propagez-la
    }
    }
}
