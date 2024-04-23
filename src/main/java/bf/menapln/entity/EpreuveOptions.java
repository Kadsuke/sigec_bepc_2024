/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class EpreuveOptions extends Objet{
    private Option option;
    private Epreuve epreuve;
    private Long coefficient;
    private String duree;
    private String estComposeSecTour;
    private String estComposePreTour;
    private String estRachetable;
    private String estTypeFrancais;
    private Type typeEpreuve;
    private Session session;
    private List<Objet> options = new ArrayList<Objet>();
    private List<Epreuve> epreuvesLie = new ArrayList<Epreuve>();
    private Double note;
    private Boolean comptabiliseCoefSer = true;
    private Long ordreEpreuve;

    public EpreuveOptions() {
        super();
}
    
    public EpreuveOptions(Map data){
        this.setSession((Session) data.get("session_id"));
        this.setOption((Option) data.get("option_id"));
        this.setEpreuve((Epreuve) data.get("epreuve_id"));
        this.setCoefficient(Long.parseLong((String) data.get("coefficient")));
        this.setDuree( (String)data.get("duree"));
        this.setEstComposeSecTour ((String) data.get("estComposeSecTour"));
        this.setEstComposePreTour ((String) data.get("estComposePreTour"));
        this.setEstRachetable((String) data.get("estRachetable"));
        this.setEstTypeFrancais((String) data.get("estTypeFrancais"));
        this.setTypeEpreuve((Type) data.get("typeEpreuve_id"));
        this.setOrdreEpreuve(Long.parseLong((String) data.get("ordreEpreuve")));
        //this.setNote((Double)data.get("note"));
        
        
    }
    public static EpreuveOptions id(Long id){
        EpreuveOptions eo = new EpreuveOptions();
        eo.setId(id);
        return eo;
    }
        
    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    
    
    public Option getOptions() {
        return option;
    }

    public void setOptions(Option option) {
        this.option = option;
    }

    public Long getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Long coefficient) {
        this.coefficient = coefficient;
    }
    
    public Long getOrdreEpreuve() {
        return ordreEpreuve;
    }

    public void setOrdreEpreuve(Long ordreEpreuve) {
        this.ordreEpreuve = ordreEpreuve;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getEstComposeSecTour() {
        return estComposeSecTour;
    }

    public void setEstComposeSecTour(String estComposeSecTour) {
        this.estComposeSecTour = estComposeSecTour;
    }

    public String getEstComposePreTour() {
        return estComposePreTour;
    }

    public void setEstComposePreTour(String estComposePreTour) {
        this.estComposePreTour = estComposePreTour;
    }

    public String getEstRachetable() {
        return estRachetable;
    }

    public void setEstRachetable(String estRachetable) {
        this.estRachetable = estRachetable;
    }

    public String getEstTypeFrancais() {
        return estTypeFrancais;
    }

    public void setEstTypeFrancais(String estTypeFrancais) {
        this.estTypeFrancais = estTypeFrancais;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    

    public Type getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(Type typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setOptions(List<Objet> options) {
        this.options = options;
    }

    public List<Epreuve> getEpreuvesLie() {
        return epreuvesLie;
    }

    public void setEpreuvesLie(List<Epreuve> epreuvesLie) {
        this.epreuvesLie = epreuvesLie;
    }

    public Boolean getComptabiliseCoefSer() {
        return comptabiliseCoefSer;
    }

    public void setComptabiliseCoefSer(Boolean comptabiliseCoefSer) {
        this.comptabiliseCoefSer = comptabiliseCoefSer;
    }

    
    
    
}
