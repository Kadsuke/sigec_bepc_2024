/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class Dispense extends Objet{
    private Session session;
    private Structure etablissement;
    private Epreuve epreuve;
    private Candidat candidat;

    
    public Dispense(){
        super();
    }
    
    public Dispense(Map data){
        this.setSession((Session) data.get("session_id"));
    }
    public Structure getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Structure etablissement) {
        this.etablissement = etablissement;
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

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
    
    

    
}
