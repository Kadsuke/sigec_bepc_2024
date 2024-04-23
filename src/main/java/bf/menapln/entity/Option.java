/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class Option extends Objet{
    private String optionLibelle;
    private String optionDefinition;
    private List<Epreuve> epreuves = new ArrayList<Epreuve>();
    private Integer totalCoef = 0;
    
    
    public Option(){
        super();
    }

     public Option(Map data){
        this.setOptionLibelle ((String)data.get("optionLibelle"));
        this.setOptionDefinition((String)("optionDefinition"));
         
    }
    
     public static Option id(Long id){
        Option o = new Option();
        o.setId(id);
        return o;
    }
     
     
    public Option(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("option_id"));
        this.setOptionLibelle(rs.getString("optionLibelle"));
        this.setOptionDefinition(rs.getString("optionDefinition"));
    }
     
     
    
    public String getOptionLibelle() {
        return optionLibelle;
    }

    public void setOptionLibelle(String optionLibelle) {
        this.optionLibelle = optionLibelle;
    }

    public String getOptionDefinition() {
        return optionDefinition;
    }

    public void setOptionDefinition(String optionDefinition) {
        this.optionDefinition = optionDefinition;
    }
    
    public List<Epreuve> getEpreuves() {
        return epreuves;
    }

    public Option setEpreuves(List<Epreuve> epreuves) {
        this.epreuves = epreuves;
        return this;
    }
    
    public Option addEpreuve(Epreuve epreuve){
         this.epreuves.add(epreuve);
        if(epreuve.estComptabiliseCoefSer()){
            this.totalCoef += epreuve.getCoefficient().intValue();
        }
        return this;
    }
    
    public Integer getTotalCoef() {
        return totalCoef;
    }

    public void setTotalCoef(Integer totalCoef) {
        this.totalCoef = totalCoef;
    }
    @Override
    public String toString() {
        return this.optionLibelle;
    }
    
}
