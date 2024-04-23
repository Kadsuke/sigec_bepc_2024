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
public class Centre extends Objet{
    private Localite localite;
    private Localite centre;
    private Session session;
    private Type typeCentre;


    public Centre(){
        super();
    }
    
    public Centre(Map data){
        this.setLocalite((Localite) data.get("localite"));
        this.setSession((Session) data.get("session"));
        this.setTypeCentre((Type) data.get("typeCentre"));
        this.setCentre((Localite) data.get("centre"));
    }
    
    public static Centre id(Long id){
        id = (id == null || id == 0)?null:id;
        Centre cent = new Centre();
        cent.setId(id);
        return cent;
    }
    public Localite getLocalite() {
        return localite;
    }

    public Centre setLocalite(Localite localite) {
        this.localite = localite;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Centre setSession(Session session) {
        this.session = session;
        return this;
    }

     public Type getTypeCentre() {
        return typeCentre;
    }

    public Centre setTypeCentre(Type typeCentre) {
        this.typeCentre = typeCentre;
        return this;
    }

    public Localite getCentre() {
        return centre;
    }

    public void setCentre(Localite centre) {
        this.centre = centre;
    }
    
        @Override
    public String toString(){
        return this.centre.getNomLoclite();
    }
}
