/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class CritereCandidatPosteJury extends Objet{
    private Type poste;
    private Session session;
    private Critere critere;
    private Modalite modalite;
    private CandidatPosteJury candidatPosteJury;
    
    public CritereCandidatPosteJury() {
        super();
}
    public CritereCandidatPosteJury(Map data){
        //this.setPoste((Type) data.get("poste"));
        this.setSession((Session) data.get("session"));
       // this.setCritere((Critere) data.get("critere"));
       // this.setModalite((Modalite) data.get("modalite"));
        //this.setCandidatPosteJury((CandidatPosteJury) data.get("candidat"));
    }
    
    public static CritereCandidatPosteJury id(Long id){
        CritereCandidatPosteJury eo = new CritereCandidatPosteJury();
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

    public CandidatPosteJury getCandidatPosteJury() {
        return candidatPosteJury;
    }

    public void setCandidatPosteJury(CandidatPosteJury candidatPosteJury) {
        this.candidatPosteJury = candidatPosteJury;
    }

 
    
}
