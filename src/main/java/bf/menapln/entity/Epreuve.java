/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author kadsuke
 */
public class Epreuve extends Objet{
    private String epreuveLibelle;
    private String epreuveAcronyme;
    private Long coefficient;
    private Epreuve parent;
    private Type typeEpreuve;
    private Session session;
    private List<Objet> option = new ArrayList<Objet>();
    private List<Epreuve> epreuvesLie = new ArrayList<Epreuve>();
    private Double note;
    private Boolean comptabiliseCoefSer = true;

    public Epreuve(){
        super();
    }

   public Epreuve(Map data){
        this.setEpreuveLibelle((String) data.get("epreuveLibelle"));
        this.setEpreuveAcronyme((String) data.get("epreuveAcronyme"));
        if((Epreuve) data.get("parent_id") == null){
            this.setParent(new Epreuve());
            }else{
            this.setParent((Epreuve) data.get("parent_id"));
            }
    }
   
   public Epreuve(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("epreuve_id"));
        this.setParent(Epreuve.id(rs.getLong("parent_id")));
        this.setEpreuveAcronyme(rs.getString("epreuveAcronyme"));
        this.setEpreuveLibelle(rs.getString("epreuveLibelle"));
    }
    public static Epreuve id(Long id){
        Epreuve e = new Epreuve();
        e.setId(id);
        return e;
    }
    
    public Epreuve getParent() {
        return parent;
    }

    public void setParent(Epreuve parent) {
        this.parent = parent;
    }

    public String getEpreuveLibelle() {
        return epreuveLibelle;
    }

    public Epreuve setEpreuveLibelle(String epreuveLibelle) {
        this.epreuveLibelle = epreuveLibelle;
        return this;
    }

    public String getEpreuveAcronyme() {
        return epreuveAcronyme;
    }

    public void setEpreuveAcronyme(String epreuveAcronyme) {
        this.epreuveAcronyme = epreuveAcronyme;
    }

    public Object getSession() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Boolean estComptabiliseCoefSer() {
        return comptabiliseCoefSer;
    }

    public void setComptabiliseCoefSer(Boolean comptabiliseCoefSer) {
        this.comptabiliseCoefSer = comptabiliseCoefSer;
    }
    
    
    public Long getCoefficient() {
        return coefficient;
    }

    public Epreuve setCoefficient(Long coefficient) {
        this.coefficient = coefficient;
        return this;
    }
    
     public Long getTotalPondereMax(){
        return this.getCoefficient()*20;
    }

 public String toString() {
        return this.epreuveLibelle;
    }

    public List<Objet> getOption() {
        return option;
    }

    public void setOption(List<Objet> option) {
        this.option = option;
    }
    

            @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Epreuve epreuve = (Epreuve) o;
            return Objects.equals(id, epreuve.id); // Remplacez 'id' par le champ approprié utilisé pour l'égalité.
        }

        @Override
        public int hashCode() {
            return Objects.hash(id); // Remplacez 'id' par le champ approprié utilisé pour l'égalité.
            }
}