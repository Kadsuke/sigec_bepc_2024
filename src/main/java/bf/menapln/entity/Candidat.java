/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import bf.menapln.enumeration.Sexe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class Candidat extends Objet{
    private Structure etablissementCandidat;
    private List<ChoixEtablissement> choixEtablissements;
    private Session session;
    
    private Type typeCandidat;
    private Type typeInscription;
    private Type typeSituation;
    private Option option;
    private Localite centreExamen;
    private Localite zone;
    private Type concoursRatache;
    private GroupePedagogique groupePedagogique;

    private String iue;
    private String nom;
    private String prenom;
     private String nomPere;
    private String prenomPere;
    private String nomMere;
    private String prenomMere;
    private String telephone;
    private String telephoneDeux;
    private String dernierDiplome;
    private Long anneeDernierDiplome;
    
    private Sexe sexe;
    private Pays paysNaissance;
    private Pays nationalite;
    
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String numeroActeNaissance;
    private String lienActeNaissance;
    private String lienPhoto;

    private String situationHandicap;
    private NatureHandicap natureHandicap;
    private Type typeHandicap;
    private Type prescriptionHandicap;
    private String sport;
    private Integer numeroPv;
    private String numeroDossier;
    
    private Inscription inscription;
    
    private List<Objet> copies;
  //  private Map<Long,FeuilleComposition> copiesSecondTour;
  //  private Map<Long,FeuilleComposition> copiesTypeFrancais;
    
    private Double moyenneTypeFrancais = 0.0;

    private Double totalPondere = 0.0;
    private int totalCoefDispense = 0;
    Boolean elimine = false;
    private String typeDateNaissance;

    private String dateTepo;
    private boolean present;
    
    private HashMap<Structure,SerieConcours> choixEtabSerie = new HashMap<>();
    
    private boolean inJury;
    private Localite villeComposition;

    public Localite getVilleComposition() {
        return villeComposition;
    }

    public void setVilleComposition(Localite villeComposition) {
        this.villeComposition = villeComposition;
    }

    public Candidat(){
        super();
    }

    public Candidat(Map data){
     //   this.setId(Long.valueOf((String)data.get("candidat_id")));
        this.setNom((String) data.get("nom"));
        this.setPrenom((String) data.get("prenom"));
        this.setSexe((Sexe) data.get("sexe"));
        this.setNumeroActeNaissance((String) data.get("numeroActeNaissance"));
        this.setTypeDateNaissance((String) data.get("typeDateNaissance"));
        this.setDateNaissance((LocalDate) formatDate((String)data.get("dateNaissance")));
        this.setLieuNaissance((String) data.get("lieuNaissance"));
        this.setTelephone((String) data.get("telephone"));
        this.setTelephoneDeux((String) data.get("telephoneDeux"));
        this.setEtablissementCandidat( (Structure) data.get("etablissement_id"));
        this.setTypeCandidat((Type) data.get("typeCandidat_id"));
        this.setTypeInscription((Type) data.get("typeInscription_id"));
        this.setOption((Option) data.get("option_id"));
        this.setPaysNaissance((Pays) data.get("paysNaissance_id"));
        this.setNationalite((Pays) data.get("nationalite_id"));
        this.setAnneeDernierDiplome(Long.parseLong((String) data.get("anneeDernierDiplome")));
        this.setSport((String) data.get("sport"));
        this.setCentreExamen((Localite) data.get("centreExamen_id"));
        this.setZone((Localite) data.get("zone_id"));
        this.setConcoursRatache((Type) data.get("concours_id"));
        this.setNatureHandicap((NatureHandicap) data.get("natureHandicap"));
        this.setPrescriptionHandicap((Type) data.get("prescription"));
        this.setGroupePedagogique((GroupePedagogique) data.get("groupePedagogique"));
        this.setSession((Session) data.get("session_id"));
        this.setNomPere((String) data.get("nomPere"));
        this.setPrenomPere((String) data.get("prenomPere"));
        this.setNomMere((String) data.get("nomMere"));
        this.setPrenomMere((String) data.get("prenomMere"));
        this.setTypeSituation((Type) data.get("typeSituation_id"));
        
    }
    
    public Candidat(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("candidat_id"));
        if(this.fieldExist(rs, "iue")){
            this.setIue(rs.getString("iue"));
        }
        this.setNom(rs.getString("nom"));
        this.setPrenom(rs.getString("prenom"));
        this.setSexe(Sexe.valueOf(rs.getString("sexe")));
        this.setTelephone(rs.getString("telephone"));
        this.setDateNaissance(LocalDate.parse(rs.getString("dateNaissance")));
        if(this.fieldExist(rs, "numeroPV")){
            this.setNumeroPv(rs.getInt("numeroPV"));
        }
        this.setSport(rs.getString("sport"));
        this.setEtablissementCandidat(Structure.id(rs.getLong("structure_id")));
        this.getEtablissementCandidat().setNomStructure(rs.getString("nomStructure"));
        this.setLieuNaissance(rs.getString("lieuNaissance"));
        //this.setCentreExamen(Centre.id(rs.getLong("centreExamen_id")));
        //this.getCentreExamen().setNomLoclite(rs.getString("nom_centre"));
        this.setTypeDateNaissance(rs.getString("typeDateNaissance"));
        this.setNumeroDossier(rs.getString("numeroDossier"));
        this.setAnneeDernierDiplome(rs.getLong("anneeDernierDiplome"));
    }
    
    public static Candidat id(Long id){
        Candidat c = new Candidat();
        c.setId(id);
        return c;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }
    
    
    public Localite getCentreExamen() {
        return centreExamen;
    }

    public void setCentreExamen(Localite centreExamen) {
        this.centreExamen = centreExamen;
    }

    public Localite getZone() {
        return zone;
    }

    public void setZone(Localite zone) {
        this.zone = zone;
    }

    
    public Type getTypeSituation() {
        return typeSituation;
    }

    public void setTypeSituation(Type typeSituation) {
        this.typeSituation = typeSituation;
    }

    
    public GroupePedagogique getGroupePedagogique() {
        return groupePedagogique;
    }

    public void setGroupePedagogique(GroupePedagogique groupePedagogique) {
        this.groupePedagogique = groupePedagogique;
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }
    public Type getConcoursRatache() {
        return concoursRatache;
    }

    public void setConcoursRatache(Type concoursRatache) {
        this.concoursRatache = concoursRatache;
    }

    public String getDernierDiplome() {
        return dernierDiplome;
    }

    public void setDernierDiplome(String dernierDiplome) {
        this.dernierDiplome = dernierDiplome;
    }
    
     public String getTypeDateNaissance() {
        return typeDateNaissance;
    }

    public void setTypeDateNaissance(String typeDateNaissance) {
        this.typeDateNaissance = typeDateNaissance;
    }

    public String getNumeroActeNaissance() {
        return numeroActeNaissance;
    }

    public void setNumeroActeNaissance(String numeroActeNaissance) {
        this.numeroActeNaissance = numeroActeNaissance;
    }

    public Type getTypeHandicap() {
        return typeHandicap;
    }

    public void setTypeHandicap(Type typeHandicap) {
        this.typeHandicap = typeHandicap;
    }

    public String getSport() {
        return sport;
    }

    
    public void setSport(String sport) {
        this.sport = sport;
    }

    public Type getTypeCandidat() {
        return typeCandidat;
    }

    public void setTypeCandidat(Type typeCandidat) {
        this.typeCandidat = typeCandidat;
    }

    public Type getTypeInscription() {
        return typeInscription;
    }

    public void setTypeInscription(Type typeInscription) {
        this.typeInscription = typeInscription;
    }

    

    public Long getAnneeDernierDiplome() {
        return anneeDernierDiplome;
    }

    public void setAnneeDernierDiplome(Long anneeDernierDiplome) {
        this.anneeDernierDiplome = anneeDernierDiplome;
    }

    public Pays getPaysNaissance() {
        return paysNaissance;
    }

    public void setPaysNaissance(Pays paysNiassance) {
        this.paysNaissance = paysNiassance;
    }

    public Pays getNationalite() {
        return nationalite;
    }

    public void setNationalite(Pays nationalite) {
        this.nationalite = nationalite;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public Candidat nom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getIue() {
        return iue;
    }

    public void setIue(String identifiant) {
        this.iue = identifiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateTepo() {
        return dateTepo;
    }
    public void setDateTep(String dateTepo) {
        this.dateTepo = dateTepo;
    }


    public String getPrenom() {
        return prenom;
    }

    public Candidat prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public Candidat sexe(Sexe sexe) {
        this.sexe = sexe;
        return this;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public Candidat telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
    
    public String getTelephoneDeux() {
        return telephoneDeux;
    }

    public Candidat telephoneDeux(String telephoneDeux) {
        this.telephoneDeux = telephoneDeux;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTelephoneDeux(String telephoneDeux) {
        this.telephoneDeux = telephoneDeux;
    }
        
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public Candidat lieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
        return this;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getSituationHandicap() {
        return situationHandicap;
    }

    public Candidat situationHandicap(String situationHandicap) {
        this.situationHandicap = situationHandicap;
        return this;
    }

    public void setSituationHandicap(String situationHandicap) {
        this.situationHandicap = situationHandicap;
    }

    public Structure getEtablissementCandidat() {
        return etablissementCandidat;
    }

    public Candidat etablissementCandidat(Etablissement etablissement) {
        this.etablissementCandidat = etablissement;
        return this;
    }

    public void setEtablissementCandidat(Structure etablissement) {
        this.etablissementCandidat = etablissement;
    }

    public Option getOption() {
        return option;
    }

    public Candidat option(Option option) {
        this.option = option;
        return this;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    // Debut Nature Handicap
    public NatureHandicap getNatureHandicap() {
        return natureHandicap;
    }

    public Candidat natureHandicap(NatureHandicap natureHandicap) {
        this.natureHandicap = natureHandicap;
        return this;
    }

    public void setNatureHandicap(NatureHandicap natureHandicap) {
        this.natureHandicap = natureHandicap;
    }
    
    public Type getPrescriptionHandicap() {
        return prescriptionHandicap;
    }

    public Candidat prescriptionHandicap(Type prescriptionHandicap) {
        this.prescriptionHandicap = prescriptionHandicap;
        return this;
    }

    public void setPrescriptionHandicap(Type prescriptionHandicap) {
        this.prescriptionHandicap = prescriptionHandicap;
    }

    public String getLienActeNaissance() {
        return lienActeNaissance;
    }

    public void setLienActeNaissance(String lienActeNaissance) {
        this.lienActeNaissance = lienActeNaissance;
    }

    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }

    public boolean isInJury() {
        return inJury;
    }

    public void setInJury(boolean inJury) {
        this.inJury = inJury;
    }

    public Integer getNumeroPv() {
        return numeroPv;
    }

    public void setNumeroPv(Integer numeroPv) {
        this.numeroPv = numeroPv;
    }

    public List<Objet> getCopies() {
        return copies;
    }

    public void setCopies(List<Objet> copies) {
        this.copies = copies;
    }
    
    public void addCopie(Objet copie){
        this.copies.add(copie);
    }

    public Double getTotalPondere() {
        return totalPondere;
    }

    public void setTotalPondere(Double totalPondere) {
        
        this.totalPondere += totalPondere;
    }
    
    public Double getTotaPondereMax(){
        return (this.getTotalCoef()*20.0);
    }
    
    public Double moyenne(){
      //  Double totCoef = this.getCopies().get
        DecimalFormat df = new DecimalFormat("0.00");
        String moyToString = df.format((double)this.getTotalPondere()/this.getTotalCoef());
        return Double.parseDouble(moyToString.replace(",", "."));
      // return (this.getTotalPondere()/this.getTotalCoef());

    }
    
    public String decisionJury(){
        
        return this.etatRachat(this.getInscription().getSession().getMoyRachat(), this.moyenne(), this.getInscription().getSession().getMoyAdmissible());
    }
    
    public String etatRachat(Double moyRachat,Double moyenne,Double moyAdmissibilite){
        if(this.getElimine()){
            return "Radié";
        }else if(moyenne >=10){
            return "Admis";
        }else if(moyenne >= 9.95){
            return "Rachat";
        } /* else if(moyenne >=7.0){
            return "Admissible";
        } */
        else{
            return "Ajourné";
        }

    }
    public Integer codeDecisionJury(){
        switch(this.decisionJury()){
            case "Admissible":
                return 2;
            case "Ajourné":
                return 3;
            case "Rachat":
                return 4;
            case "Radié":
                return 5;
            default:
                return 1;
        }
    }
    
    public String mention(){
        return  (this.moyenne() < this.getInscription().getSession().getMoyAdmission())?"Insuffisant":(this.moyenne() < 12)?"Passable":(this.moyenne() < 14)?"A. Bien":(this.moyenne() < 16)?"Bien":(this.moyenne() < 18)?"Très bien":"Excellent";
    }
    
    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        inscription.setCandidat(this);
        this.inscription = inscription;
    }
    
    public boolean isApte(){
        return (this.sport.equals("Apte"))?true:false;
    }

    public Double getTotalCoefDispense() {
        return totalCoefDispense*1.0;
    }
    
    
    
    public void setTotalCoefDispense(int totalCoefDispense) {
        this.totalCoefDispense += totalCoefDispense;
    }
    
    public Double getTotalCoef(){
        return this.getOption().getTotalCoef()-this.getTotalCoefDispense()*1.0;
    }

    public Boolean getElimine() {
        return elimine;
    }

    public void setElimine(Boolean elimine) {
        this.elimine = elimine;
    }
    
   /* public Map<Long, FeuilleComposition> getCopiesSecondTour() {
        return copiesSecondTour;
    }

    public void setCopiesSecondTour(Map<Long, FeuilleComposition> copiesSecondTour) {
        this.copiesSecondTour = copiesSecondTour;
    }
    
    public void addCopieSecondTour(FeuilleComposition copie){
        this.copiesSecondTour.put(copie.getComposition().getEpreuve().getId(), copie);
    }
    
    public Map<Long, FeuilleComposition> getCopiesTypeFrancais() {
        return copiesTypeFrancais;
    }

    public void setCopiesTypeFrancais(Map<Long, FeuilleComposition> copiesTypeFrancais) {
        this.copiesTypeFrancais = copiesTypeFrancais;
    }
    
     public void addCopieTypeFrancais(FeuilleComposition copie){
        this.moyenneTypeFrancais += copie.getNote()*copie.getComposition().getEpreuve().getCoefficient()/5;
        this.copiesTypeFrancais.put(this.getId(), copie);
    }
     
    /* public Double moyenneEpreuveLie(){
        Double moy=0.0;
        for (Epreuve epreuve : copiesTypeFrancais) {
            moy += epreuve.getCoefficient()*epreuve.getNote()/5;
        }
        return moy;
    }*/
    public Double getMoyenneTypeFrancais() {
        DecimalFormat df = new DecimalFormat("0.00");
        String moyToString = df.format(this.moyenneTypeFrancais);
        return Double.parseDouble(moyToString.replace(",", "."));
    }

    public void setMoyenneTypeFrancais(Double moyenneTypeFrancais) {
        this.moyenneTypeFrancais = moyenneTypeFrancais;
    }
    
    /*public Double epreuveMaxNote(FeuilleComposition copie){
        Double note1;
        Double note2;
        if(copie.getComposition().getEpreuve().getEpreuveLibelle().equalsIgnoreCase("Français")){
            note1 = copie.getCandidat().getMoyenneTypeFrancais();
            note2 = (this.getCopiesSecondTour() != null && this.getCopiesSecondTour().containsKey(copie.getComposition().getEpreuve().getId()))?this.getCopiesSecondTour().get(copie.getComposition().getEpreuve().getId()).getNote():0; 
        }else{
            note1 = copie.getNote();
            note2 = (this.getCopiesSecondTour() != null && this.getCopiesSecondTour().containsKey(copie.getComposition().getEpreuve().getId()))?this.getCopiesSecondTour().get(copie.getComposition().getEpreuve().getId()).getNote():0;
       
        }
        return (note1 == null)?note1:(note1 >= note2)?note1:note2;
    }*/
    
    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
    
    public LocalDate formatDate(String str){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate theDate = LocalDate.parse(str,format);
        
        return theDate;
    }

    public HashMap<Structure, SerieConcours> getChoixEtabSerie() {
        return choixEtabSerie;
    }

    public void setChoixEtabSerie(HashMap<Structure, SerieConcours> choixEtabSerie) {
        this.choixEtabSerie = choixEtabSerie;
    }
    
    public List<ChoixEtablissement> getChoixEtablissements() {
        return choixEtablissements;
    }

    public void setChoixEtablissements(List<ChoixEtablissement> choixEtablissements) {
        this.choixEtablissements = choixEtablissements;
    }
    
}
