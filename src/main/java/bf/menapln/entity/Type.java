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
 * @author coulibaly
 */
public class Type extends Objet{
    private String libelle;
    private List<Critere> criteres = new ArrayList<Critere>(); 
    
    public Type(){
        super();
    }
    
    public Type(Map data){
        super(data);
        this.libelle = (String) data.get("typeLibelle");
    }
    
    public static Type id(Long id){
        Type type = new Type();
        type.setId(id);
        return type;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public List<Critere> getCriteres() {
        return criteres;
    }

    public Type setCriteres(List<Critere> criteres) {
        this.criteres = criteres;
        return this;
    }
    
    public Type addCritere(Critere critere){
         this.criteres.add(critere);
        return this;
    }
    
    public String toString(){
        return this.libelle;
    }
    
}
