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
public class Modalite extends Objet{
    private String modaliteLibelle;
    private Double ponderationModalite;
    
    public Modalite(){
        super();
    }
   
    public Modalite(Map data){
        this.setModaliteLibelle((String) data.get("modalite"));
    }
    public static Modalite id(Long id){
        Modalite p = new Modalite();
        p.setId(id);
        return p;
    }

    public String getModaliteLibelle() {
        return modaliteLibelle;
    }

    public void setModaliteLibelle(String modaliteLibelle) {
        this.modaliteLibelle = modaliteLibelle;
    }

    public Double getPonderationModalite() {
        return ponderationModalite;
    }

    public void setPonderationModalite(Double ponderationModalite) {
        this.ponderationModalite = ponderationModalite;
    }
    
    
    
    @Override
    public String toString(){
        return this.modaliteLibelle;
    }
}
