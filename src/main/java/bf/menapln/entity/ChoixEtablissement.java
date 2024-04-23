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
 * @author coulibaly
 */
public class ChoixEtablissement extends Etablissement{
    private Session session;
    private SerieConcours serie;
    private Long ordre;
    private Candidat candidat;

    
    public Long getOrdre() {
        return ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }

    public SerieConcours getSerie() {
        return serie;
    }

    public void setSerie(SerieConcours serie) {
        this.serie = serie;
    }

    public ChoixEtablissement(){
        super();
    }
    
    public ChoixEtablissement(Map data){
        this.setSession((Session) data.get("session_id"));
    }

    public ChoixEtablissement(ResultSet rs) throws SQLException{
    this.setId(rs.getLong("etabChoix_id"));
    this.setAcronymeStructure(rs.getString("etabChoix_accronyme"));
    this.setNomStructure(rs.getString("etabChoix_nom"));
    // this.setOrdre(rs.getLong("ordre"));
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

    
    
}
