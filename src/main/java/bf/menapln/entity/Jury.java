/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class Jury extends Objet{
    private String juryLibelle;
    private Long juryCapacite;
    private TourComposition etape;
    private Session session;
    private Localite CentreExamen;
    private List<Localite> centreSecondaires;
    private CentreComposition centreComposition;

    public Jury(){
        super();
        this.etat = false;
    }
    
    public Jury(Map data){
        this.setJuryLibelle((String) data.get("juryLibelle"));
        this.setCentreComposition(new CentreComposition());
        // this.getCentre().setEtatblissement(Etablissement.id(Long.parseLong((String) data.get("etablissement_id"))));
        if (data.get("etablissement_id") != null) {
            this.getCentreComposition().setEtablissement((Etablissement) data.get("etablissement_id"));
        } else {
            this.getCentreComposition().setEtablissement(new Etablissement());
        }        
        this.setJuryCapacite(Long.parseLong((String) data.get("juryCapacite")));
        this.setCentreExamen((Localite)(data.get("centreExamen_id")));
        this.setSession((Session) data.get("session_id"));
    }
    
    public static Jury id(Long id){
        Jury jury = new Jury();
        jury.setId(id);
        return jury;
    }
    
    public Jury(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("jury_id"));
        this.setJuryLibelle(rs.getString("juryLibelle"));
        this.setJuryCapacite(rs.getLong("juryCapacite"));
       // this.setCentreExamen(new Localite(rs));
    }
    
    public String getJuryLibelle() {
        return juryLibelle;
    }

    public void setJuryLibelle(String juryLibelle) {
        this.juryLibelle = juryLibelle;
    }

    public Long getJuryCapacite() {
        return juryCapacite;
    }

    public void setJuryCapacite(Long juryCapacite) {
        this.juryCapacite = juryCapacite;
    } 

    public TourComposition getEtape() {
        return etape;
    }

    public void setEtape(TourComposition etape) {
        this.etape = etape;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    @Override
    public String toString(){
        return this.juryLibelle;
    }
    
    public Localite getCentreExamen() {
        return CentreExamen;
    }

    public void setCentreExamen(Localite centreExamen) {
        CentreExamen = centreExamen;
    }

    public List<Localite> getCentreSecondaires() {
        return centreSecondaires;
    }

    public void setCentreSecondaires(List<Localite> centreSecondaires) {
        this.centreSecondaires = centreSecondaires;
    }

    public CentreComposition getCentreComposition() {
        return centreComposition;
    }

    public void setCentreComposition(CentreComposition centreComposition) {
        this.centreComposition = centreComposition;
    }

    

    
}
