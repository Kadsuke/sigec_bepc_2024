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
public class CentreComposition extends Objet{
    private Session session;
    private Etablissement etablissement;
    private Long capacite;
    private Localite zone;
  

    public CentreComposition(){
        super();
    }

    public CentreComposition(Map data){
        this.setEtablissement((Etablissement) data.get("etablissement"));
        this.setSession((Session) data.get("session"));
        this.setCapacite((Long) data.get("capacite"));
    }

    public static CentreComposition id(Long id){
        id = (id == null || id == 0)?null:id;
        CentreComposition cent = new CentreComposition();
        cent.setId(id);
        return cent;
    }

    public Session getSession() {
        return session;
    }
 

    public void setSession(Session session) {
        this.session = session;
    }


    public Etablissement getEtablissement() {
        return etablissement;
    }


    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }


    public Long getCapacite() {
        return capacite;
    }


    public void setCapacite(Long capacite) {
        this.capacite = capacite;
    }


    public Localite getZone() {
        return zone;
    }


    public void setZone(Localite zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return this.etablissement.getNomStructure();
    }

    
    
}
