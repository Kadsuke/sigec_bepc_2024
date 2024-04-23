/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.List;
import java.util.Map;

import bf.menapln.enumeration.TypeCentres;

/**
 *
 * @author kadsuke
 */
public class CentreJury extends Objet{
    private Localite centre;
    private CentreComposition etablissement;
    private Session session;
    private Jury jury;
    private TypeCentres typeCentres;


    public CentreJury(){
        super();
    }
    
    public CentreJury(Map data){
        
    }
    
    public static CentreJury id(Long id){
        id = (id == null || id == 0)?null:id;
        CentreJury cent = new CentreJury();
        cent.setId(id);
        return cent;
    }

    public Localite getCentre() {
        return centre;
    }

    public void setCentre(Localite centre) {
        this.centre = centre;
    }

    public CentreComposition getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(CentreComposition etablissement) {
        this.etablissement = etablissement;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public TypeCentres getTypeCentres() {
        return typeCentres;
    }

    public void setTypeCentres(TypeCentres typeCentres) {
        this.typeCentres = typeCentres;
    }

    @Override
    public String toString() {
        return "CentreJury [getCentre()=" + getCentre().toString() + "]";
    }

    
}
