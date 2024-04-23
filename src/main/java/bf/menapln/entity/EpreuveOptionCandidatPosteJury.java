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
public class EpreuveOptionCandidatPosteJury extends Objet{
    private Session session;
    private CandidatPosteJury candidatPosteJury;
    private Epreuve epreuve;
    private Option option;
    
    public EpreuveOptionCandidatPosteJury() {
        super();
}
    public EpreuveOptionCandidatPosteJury(Map data){
        this.setSession((Session) data.get("session"));
    }
    
    public static EpreuveOptionCandidatPosteJury id(Long id){
        EpreuveOptionCandidatPosteJury eo = new EpreuveOptionCandidatPosteJury();
        eo.setId(id);
        return eo;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    public CandidatPosteJury getCandidatPosteJury() {
        return candidatPosteJury;
    }

    public void setCandidatPosteJury(CandidatPosteJury candidatPosteJury) {
        this.candidatPosteJury = candidatPosteJury;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

 
    
}
