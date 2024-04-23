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
public class Statistique extends Objet{
    private Structure structure;
    private Option option;
    private Situation situation;
    private Type typeHandicap;
    private Localite region;
    private Localite province;
    private Integer nbG;
    private Integer nbF;
    private Integer nbApte;
    private Integer nbInapte;
    private Integer totalInscrit;
    
    public Statistique(ResultSet rs) throws SQLException{
        this.setStructure(new Structure());
        this.getStructure().setNomStructure(rs.getString("nomStructure"));
        this.setTotalInscrit(rs.getInt("tatalInscrits"));
        this.setNbG(rs.getInt("nbG"));
        this.setNbF(rs.getInt("nbF"));
        this.setNbApte(rs.getInt("nbApte"));
        this.setNbInapte(rs.getInt("nbInapte"));
    }
    
     public Statistique() {
        super();
    }
  

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Integer getNbG() {
        return nbG;
    }

    public void setNbG(Integer nbG) {
        this.nbG = nbG;
    }

    public Integer getNbF() {
        return nbF;
    }

    public void setNbF(Integer nbF) {
        this.nbF = nbF;
    }

    public Integer getNbApte() {
        return nbApte;
    }

    public void setNbApte(Integer nbApte) {
        this.nbApte = nbApte;
    }

    public Integer getNbInapte() {
        return nbInapte;
    }

    public void setNbInapte(Integer nbInapte) {
        this.nbInapte = nbInapte;
    }

    public Integer getTotalInscrit() {
        return totalInscrit;
    }

    public void setTotalInscrit(Integer totalInscrit) {
        this.totalInscrit = totalInscrit;
    }

    public Type getTypeHandicap() {
        return typeHandicap;
    }

    public void setTypeHandicap(Type typeHandicap) {
        this.typeHandicap = typeHandicap;
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
