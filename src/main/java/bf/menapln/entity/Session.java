/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.sql.Date;

/**
 *
 * @author coulibaly
 */
public class Session extends Objet{
    private Long annee;
    private String sessionLibelle;
    private LocalDate dateDebutSessionRemplacement;
    private LocalDate dateFinSessionRemplacement;
    private LocalDate dateDebutSessionNormale;
    private LocalDate dateFinSessionNormale;
    private LocalDate dateDebutInscription;
    private LocalDate dateFinInscription;
    private Double moyAdmission;
    private Double moyRachat;
    private Double moyAdmissible;
    private Boolean statutSession;

    
    public Session(){
        super();
    }
    public Session(Map data){
        this.setAnnee(Long.parseLong((String) data.get("annee")))
        .setDateDebutSessionRemplacement(LocalDate.parse(data.get("dateDebutSessionRemplacement").toString()))
        .setDateFinSessionRemplacement(LocalDate.parse(data.get("dateFinSessionRemplacement").toString()))
        .setDateDebutInscription(LocalDate.parse(data.get("dateDebutInscription").toString()))
        .setDateFinInscription(LocalDate.parse(data.get("dateFinInscription").toString()))
        .setDateDebutSessionNormale(LocalDate.parse(data.get("dateDebutSessionNormale").toString()))
        .setDateFinSessionNormale(LocalDate.parse(data.get("dateFinSessionNormale").toString()))
        .setMoyAdmission(Double.parseDouble((String) data.get("moyAdmission")))
        .setMoyRachat(Double.parseDouble((String) data.get("moyRachat")))
        .setmoyAdmissible(Double.parseDouble((String) data.get("moyAdmissible")));

        
    }
    
    public static Session id(Long id){
        Session session = new Session();
        session.setId(id);
        return session;
    }
    
    public Session(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("session_id"));
        this.setAnnee(rs.getLong("annee"));
        this.setMoyRachat(rs.getDouble("moyRachat"));
        this.setMoyAdmission(rs.getDouble("moyAdmission"));
        this.setmoyAdmissible(rs.getDouble("moyAdmissible"));
        this.setDateDebutSessionRemplacement(LocalDate.parse(rs.getString("dateDebutSessionRemplacement")));
        this.setDateFinSessionRemplacement(LocalDate.parse(rs.getString("dateFinSessionRemplacement")));
        this.setDateDebutInscription(LocalDate.parse(rs.getString("dateDebutInscription")));
        this.setDateFinInscription(LocalDate.parse(rs.getString("dateFinInscription")));
        this.setDateDebutSessionNormale(LocalDate.parse(rs.getString("dateDebutSessionNormale")));
        this.setDateFinSessionNormale(LocalDate.parse(rs.getString("dateFinSessionNormale")));
    }
    
    public String getSessionLibelle() {
        return sessionLibelle;
    }

    public Session setSessionLibelle(String sessionLibelle) {
        this.sessionLibelle = sessionLibelle;
        return this;
    }

    public Long getAnnee() {
        return annee;
    }

    public Session annee(Long annee) {
        this.annee = annee;
        return this;
    }

    public Session setAnnee(Long annee) {
        this.annee = annee;
        return this;
    }

    public LocalDate getDateDebutSessionRemplacement() {
        return dateDebutSessionRemplacement;
    }

    public Session dateDebutSessionRemplacement(LocalDate dateDebutSessionRemplacement) {
        this.dateDebutSessionRemplacement = dateDebutSessionRemplacement;
        return this;
    }

    public Session setDateDebutSessionRemplacement(LocalDate dateDebutSessionRemplacement) {
        this.dateDebutSessionRemplacement = dateDebutSessionRemplacement;
        return this;
    }

    public LocalDate getDateFinSessionRemplacement() {
        return dateFinSessionRemplacement;
    }

    public Session dateFinSession(LocalDate dateFinSessionRemplacement) {
        this.dateFinSessionRemplacement = dateFinSessionRemplacement;
        return this;
    }

    public Session setDateFinSessionRemplacement(LocalDate dateFinSessionRemplacement) {
        this.dateFinSessionRemplacement = dateFinSessionRemplacement;
        return this;
    }

    public LocalDate getDateDebutSessionNormale() {
        return dateDebutSessionNormale;
    }

    public Session setDateDebutSessionNormale(LocalDate dateDebutSessionNormale) {
        this.dateDebutSessionNormale = dateDebutSessionNormale;
        return this;
    }

    public LocalDate getDateFinSessionNormale() {
        return dateFinSessionNormale;
    }

    public Session setDateFinSessionNormale(LocalDate dateFinSessionNormale) {
        this.dateFinSessionNormale = dateFinSessionNormale;
        return this;
    }
 
    public LocalDate getDateDebutInscription() {
        return dateDebutInscription;
    }

    public Session dateDebutInscription(LocalDate dateDebutInscription) {
        this.dateDebutInscription = dateDebutInscription;
        return this;
    }

    public Session setDateDebutInscription(LocalDate dateDebutInscription) {
        this.dateDebutInscription = dateDebutInscription;
        return this;
    }

    public LocalDate getDateFinInscription() {
        return dateFinInscription;
    }

    public Session dateFinInscription(LocalDate dateFinInscription) {
        this.dateFinInscription = dateFinInscription;
        return this;
    }

    public Session setDateFinInscription(LocalDate dateFinInscription) {
        this.dateFinInscription = dateFinInscription;
        return this;
    }

    public Double getMoyAdmission() {
        return moyAdmission;
    }

    public Session setMoyAdmission(Double moyAdmission) {
        this.moyAdmission = moyAdmission;
        return this;
    }

    public Double getMoyRachat() {
        return moyRachat;
    }

    public Session setMoyRachat(Double moyRachat) {
        this.moyRachat = moyRachat;
        return this;
    }

    public Double getMoyAdmissible() {
        return moyAdmissible;
    }

    public Session setmoyAdmissible(Double moyAdmissible) {
        this.moyAdmissible = moyAdmissible;
        return this;
    }

    public Boolean getStatutSession() {
        return statutSession;
    }
    public void setStatutSession(Boolean statutSession) {
        this.statutSession = statutSession;
    }
    @Override
    public String toString() {
        return this.getAnnee().toString();
    }
}
