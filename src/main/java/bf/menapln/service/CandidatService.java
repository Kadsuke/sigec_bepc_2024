/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.repository.CandidatRepository;
import bf.menapln.repository.ChoixCandidatRepository;
import bf.menapln.repository.DispenseRepository;
import bf.menapln.repository.InscriptionRepository;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class CandidatService extends Service{
    public CandidatService() throws SQLException{
        super();
        this.implementationDAO = new CandidatRepository(this.factory);
    }

    @Override
    public Objet save() throws SQLException {
        Candidat c = new Candidat(this.formData);
        Inscription insc = new Inscription(this.formData);
        ChoixEtablissement choix = new ChoixEtablissement(this.formData);
        Dispense dispense = new Dispense(this.formData);  
        insc.setCandidat(c);
        choix.setCandidat(c);
        dispense.setCandidat(c);
        this.implementationDAO = new CandidatRepository(this.factory);
        this.implementationDAO.save(c);
        this.implementationDAO = new InscriptionRepository(this.factory);
        this.implementationDAO.save(insc);
        
        if(((String)this.formData.get("sport")).equalsIgnoreCase("Inapte")){
            this.implementationDAO = new DispenseRepository(this.factory);
            this.implementationDAO.save(dispense);
        }
        
        if(((Type)this.formData.get("concours_id")).getId() != 3){
            HashMap<Structure,SerieConcours> choixEtab = (HashMap<Structure,SerieConcours>) this.formData.get("choix");
            for (Map.Entry<Structure, SerieConcours> entry : choixEtab.entrySet()) {
                Structure cle = entry.getKey();
                SerieConcours valeur = entry.getValue();
                choix.setId(cle.getId());
                choix.setSerie(valeur);
                this.implementationDAO = new ChoixCandidatRepository(this.factory);
                this.implementationDAO.save(choix);
              
            }
        }
        
        
        
        return c;
    }

    @Override
    public void validate() {
        
    }

    /* @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    } */

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        Session sess = new Session();
        sess.setId(2L);
        return ((CandidatRepository)this.implementationDAO).getCandidatsInscrits(sess);
    }
    
    public List<Objet> getCandidat(Option option, Localite villeComposition) throws SQLException {
        return ((CandidatRepository)this.implementationDAO).getCandidat(option, villeComposition);
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public Objet updateCandidat() throws SQLException {
        Candidat c = new Candidat(this.formData);
        String candidatToUpdate = (String)this.formData.get("candidat_id");
        c.setId(Long.valueOf(candidatToUpdate));
        Inscription insc = new Inscription(this.formData);
        ChoixEtablissement choix = new ChoixEtablissement(this.formData);
        Dispense dispense = new Dispense(this.formData);
        this.implementationDAO.upadte(c);
        insc.setCandidat(c);
        //choix.setCandidat(c);
        dispense.setCandidat(c);
        this.implementationDAO = new InscriptionRepository(this.factory);
        this.implementationDAO.upadte(insc);
        this.implementationDAO = new DispenseRepository(this.factory);
        this.implementationDAO.upadte(dispense);
        HashMap<Structure,SerieConcours> choixEtab = (HashMap<Structure,SerieConcours>) this.formData.get("choix");
        if(((Type)this.formData.get("concours_id")).getId() != 3){
            this.implementationDAO = new ChoixCandidatRepository(this.factory);
            ((ChoixCandidatRepository)this.implementationDAO).deleteAll(choix);
            if(choixEtab!=null){
                for (Structure structure : choixEtab.keySet()) {
                   SerieConcours type = choixEtab.get(structure);
                   //choix.getCandidat().setEtablissementChoix(structure);
                   //choix.getCandidat().setSerieChoix(type);
                   this.implementationDAO = new ChoixCandidatRepository(this.factory);
                   this.implementationDAO.upadte(choix);
            }
        }
    }else{     
        this.implementationDAO = new ChoixCandidatRepository(this.factory);
        ((ChoixCandidatRepository)this.implementationDAO).deleteAll(choix);
    }
        return c;  
}
    
    public void updatePV(Objet objet) throws SQLException {
        this.implementationDAO = new InscriptionRepository(this.factory);
        Inscription i = new Inscription();
        //i.setSession(((CandidatJury)objet).getSession());
       // i.setCandidat(((CandidatJury)objet).getCandidat());
        ((InscriptionRepository)this.implementationDAO).upadtePV(i);
    }

    public List<Objet> upadteMultipleCentre() throws SQLException{
        this.implementationDAO = new InscriptionRepository(this.factory);
        List<Objet> candidats = (List<Objet>)this.formData.get("listCandidats");
        Localite c = (Localite)this.formData.get("centre");
        for (Objet objet : candidats) {
            ((Candidat)objet).setCentreExamen(c);
            ((InscriptionRepository)this.implementationDAO).upadteCentre(objet);
        }
       return  candidats;
    }

    public List<Objet> upadteMultipleZone() throws SQLException{
        this.implementationDAO = new InscriptionRepository(this.factory);
        List<Objet> candidats = (List<Objet>)this.formData.get("listCandidats");
        Localite c = (Localite)this.formData.get("zone");
        for (Objet objet : candidats) {
            ((Candidat)objet).setZone(c);
            ((InscriptionRepository)this.implementationDAO).upadteZone(objet);
        }
       return  candidats;
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        return this.implementationDAO.getById(id);
    }
    
    public Long createId() throws SQLException{
        return ((CandidatRepository)this.implementationDAO).createId();
    }
    
     public int nbreCandidatTotalFille(String filtre) throws SQLException{
        return ((CandidatRepository)this.implementationDAO).nbreCandidatTotalFille(filtre);
    }
    
    public int nbreCandidatTotalGarcon(String filtre) throws SQLException{
        return ((CandidatRepository)this.implementationDAO).nbreCandidatTotalGarcon(filtre);
    }

    public void updateAptitudeListe() throws SQLException {
        this.implementationDAO = new InscriptionRepository(this.factory);
        ((InscriptionRepository)this.implementationDAO).updateAptitudeListe();
    }

    public void updateCorrecteur() throws SQLException {
        this.implementationDAO = new InscriptionRepository(this.factory);
        ((InscriptionRepository)this.implementationDAO).updateCorrecteur();
    }

    public void updateEtatJury() throws SQLException {
        this.implementationDAO = new InscriptionRepository(this.factory);
        ((InscriptionRepository)this.implementationDAO).updateEtatJury();
    }
    
    public void delete(Objet objet) throws SQLException{
        this.implementationDAO = new ChoixCandidatRepository(this.factory);
        ((ChoixCandidatRepository)this.implementationDAO).deleteCandi(objet);
        this.implementationDAO = new DispenseRepository(this.factory);
        ((DispenseRepository)this.implementationDAO).deleteCandi(objet);
        this.implementationDAO = new InscriptionRepository(this.factory);
        ((InscriptionRepository)this.implementationDAO).delete(objet);
        this.implementationDAO = new CandidatRepository(this.factory);
        ((CandidatRepository)this.implementationDAO).delete(objet);
    }
}
