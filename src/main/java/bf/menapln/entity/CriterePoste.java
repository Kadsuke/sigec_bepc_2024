/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class CriterePoste extends Objet{
    private Type poste;
    private Session session;
    private Critere critere;
    private Modalite modalite;
    private Double ponderationCritere;
    private Double ponderationModalite;
    private Long ordre;
    private Double poids;
    private String typeChamp;
    
    public CriterePoste() {
        super();
    }
    
    public CriterePoste(Map data){
        this.setPoste((Type) data.get("poste"));
        this.setCritere((Critere) data.get("critere"));
        this.setSession((Session) data.get("session"));
        this.setOrdre((Long) data.get("ordreCritere"));
        this.setPonderationCritere((Double) data.get("ponderationCritere"));
        this.setTypeChamp((String) data.get("typeChamp"));
        //this.setPoids((Double) data.get("poidsCritere"));
    }

    public static CriterePoste id(Long id){
        CriterePoste eo = new CriterePoste();
        eo.setId(id);
        return eo;
    }

    public Type getPoste() {
        return poste;
    }

    public void setPoste(Type poste) {
        this.poste = poste;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Critere getCritere() {
        return critere;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    public Modalite getModalite() {
        return modalite;
    }

    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    public Double getPonderationCritere() {
        return ponderationCritere;
    }

    public void setPonderationCritere(Double ponderationCritere) {
        this.ponderationCritere = ponderationCritere;
    }

    public Long getOrdre() {
        return ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getPonderationModalite() {
        return ponderationModalite;
    }

    public void setPonderationModalite(Double ponderationModalite) {
        this.ponderationModalite = ponderationModalite;
    }

    public String getTypeChamp() {
        return typeChamp;
    }

    public void setTypeChamp(String typeChamp) {
        this.typeChamp = typeChamp;
    }
     
    
    
    
    
    
}
