/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class Inscription extends Objet{
    private Session session;
    private Candidat candidat;

    private String situationHandicap;
    private NatureHandicap natureHandicap;
    private Type typeHandicap;
    private Type prescriptionHandicap;
    private String sport;
    private Integer numeroPv;
    private Type situation;
    private Option option;
    private String numeroDossier;
    
   

    private Map<Long,Epreuve> dispenses;
    
    public Inscription(){
        super();
    }
    
    public Inscription(Map data){
        this.setSession((Session) data.get("session_id"));
        this.setNumeroDossier((String) data.get("numeroDossier"));
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }


    
    public Type getTypeHandicap() {
        return typeHandicap;
    }

    public void setTypeHandicap(Type typeHandicap) {
        this.typeHandicap = typeHandicap;
    }

    public String getSport() {
        return sport;
    }

    
    public void setSport(String sport) {
        this.sport = sport;
    }

    public Map<Long, Epreuve> getDispenses() {
        return dispenses;
    }

    public void setDispenses(Map<Long, Epreuve> dispenses) {
        this.dispenses = dispenses;
    }
    
   public boolean isDispense(Epreuve epreuve){
       return (this.dispenses.containsKey(epreuve.getId()))? true : false;
   }

public String getSituationHandicap() {
    return situationHandicap;
}

public void setSituationHandicap(String situationHandicap) {
    this.situationHandicap = situationHandicap;
}

public NatureHandicap getNatureHandicap() {
    return natureHandicap;
}

public void setNatureHandicap(NatureHandicap natureHandicap) {
    this.natureHandicap = natureHandicap;
}

public Type getPrescriptionHandicap() {
    return prescriptionHandicap;
}

public void setPrescriptionHandicap(Type prescriptionHandicap) {
    this.prescriptionHandicap = prescriptionHandicap;
}

public Integer getNumeroPv() {
    return numeroPv;
}

public void setNumeroPv(Integer numeroPv) {
    this.numeroPv = numeroPv;
}

public Type getSituation() {
    return situation;
}

public void setSituation(Type situation) {
    this.situation = situation;
}

public Option getOption() {
    return option;
}

public void setOption(Option option) {
    this.option = option;
}

public String getNumeroDossier() {
    return numeroDossier;
}

public void setNumeroDossier(String numeroDossier) {
    this.numeroDossier = numeroDossier;
}

   
}
