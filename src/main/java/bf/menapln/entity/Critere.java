/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kadsuke
 */
public class Critere extends Objet{
    private String critereLibelle;
    private String typeChamp;
    private Double ponderationCritere;
    private Long ordreCritere;
    private List<Modalite> modalites = new ArrayList<Modalite>(); 

    public Critere(){
        super();
    }
   
    public Critere(Map data){
        this.setCritereLibelle((String) data.get("critereLibelle"));
       // this.setTypeChamp((String) data.get("typeChamp"));
       // this.setPonderationCritere((Double) data.get("ponderation"));
    }
    public static Critere id(Long id){
        Critere p = new Critere();
        p.setId(id);
        return p;
    }

    public String getCritereLibelle() {
        return critereLibelle;
    }

    public void setCritereLibelle(String critereLibelle) {
        this.critereLibelle = critereLibelle;
    }

    public String getTypeChamp() {
        return typeChamp;
    }

    public void setTypeChamp(String typeChamp) {
        this.typeChamp = typeChamp;
    }

    public Double getPonderationCritere() {
        return ponderationCritere;
    }

    public void setPonderationCritere(Double ponderationCritere) {
        this.ponderationCritere = ponderationCritere;
    }

    public List<Modalite> getModalites() {
        return modalites;
    }

    public Critere setModalites(List<Modalite> modalites) {
        this.modalites = modalites;
        return this;
    }
    
    public Critere addModalite(Modalite modalite){
         this.modalites.add(modalite);
        return this;
    }

    public Long getOrdreCritere() {
        return ordreCritere;
    }

    public void setOrdreCritere(Long ordreCritere) {
        this.ordreCritere = ordreCritere;
    }
    
    
    
    @Override
    public String toString(){
        return this.critereLibelle;
    }
}
