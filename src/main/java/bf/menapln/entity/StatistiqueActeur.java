/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kadsuke
 */
public class StatistiqueActeur extends Objet{
    private Structure structure;
   private Integer nbPresident;
   private Integer nbSecretaire;
   private Integer nbCorrecteur;
   private Integer nbSuperviseur;
   private Integer nbPresidentCentre;
   private Integer nbAccompagnant;
   private Integer nbVicePresident;
    private Localite region;
    private Localite province;
   //private Integer 
   
   public StatistiqueActeur(ResultSet rs) throws SQLException{
        this.setStructure(Structure.id(rs.getLong("structure_id")));
        this.getStructure().setNomStructure(rs.getString("nomStructure"));
        this.setNbPresident(rs.getInt("nbPresident"));
        this.setNbSecretaire(rs.getInt("nbSecretaire"));
        this.setNbCorrecteur(rs.getInt("nbCorrecteur"));
        this.setNbSuperviseur(rs.getInt("nbSuperviseur"));
        this.setNbPresidentCentre(rs.getInt("nbPresidentCentreSecondaire"));
        this.setNbVicePresident(rs.getInt("nbVicePresident"));
   }

    public StatistiqueActeur() {
        super();
    }
  

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Integer getNbPresident() {
        return nbPresident;
    }

    public void setNbPresident(Integer nbPresident) {
        this.nbPresident = nbPresident;
    }

    public Integer getNbSecretaire() {
        return nbSecretaire;
    }

    public void setNbSecretaire(Integer nbSecretaire) {
        this.nbSecretaire = nbSecretaire;
    }

    public Integer getNbCorrecteur() {
        return nbCorrecteur;
    }

    public void setNbCorrecteur(Integer nbCorrecteur) {
        this.nbCorrecteur = nbCorrecteur;
    }

    public Integer getNbSuperviseur() {
        return nbSuperviseur;
    }

    public void setNbSuperviseur(Integer nbSuperviseur) {
        this.nbSuperviseur = nbSuperviseur;
    }

    public Integer getNbPresidentCentre() {
        return nbPresidentCentre;
    }

    public void setNbPresidentCentre(Integer nbPresidentCentre) {
        this.nbPresidentCentre = nbPresidentCentre;
    }

    public Integer getNbVicePresident() {
        return nbVicePresident;
    }

    public void setNbVicePresident(Integer nbVicePresident) {
        this.nbVicePresident = nbVicePresident;
    }

    public Localite getRegion() {
        return region;
    }

    public void setRegion(Localite region) {
        this.region = region;
    }

    public Localite getProvince() {
        return province;
    }

    public void setProvince(Localite province) {
        this.province = province;
    }
   
    
}
