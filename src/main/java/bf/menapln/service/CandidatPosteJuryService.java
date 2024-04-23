/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.repository.*;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author coulibaly
 */
public class CandidatPosteJuryService extends Service{
    public CandidatPosteJuryService() throws SQLException{
        super();
        this.implementationDAO = new CandidatPosteJuryRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException, EmptyDataException {
        CandidatPosteJury candidat = new CandidatPosteJury(this.formData);
        CritereCandidatPosteJury critereCandidatPosteJury = new CritereCandidatPosteJury(this.formData);
        EpreuveOptionCandidatPosteJury epreuveOptionCandidatPosteJury = new EpreuveOptionCandidatPosteJury(this.formData);
        critereCandidatPosteJury.setCandidatPosteJury(candidat);
        epreuveOptionCandidatPosteJury.setCandidatPosteJury(candidat);
        this.implementationDAO = new CandidatPosteJuryRepository(this.factory);
        this.implementationDAO.save(candidat);
        ObservableList<Object> selectedItems = (ObservableList<Object>) this.formData.get("epreuve");
        List<Objet> allOption = (List<Objet>) this.formData.get("option");
        if(this.formData.get("epreuve") !=null){
            for (Object item : selectedItems) {
                for(Objet option : allOption){
                    epreuveOptionCandidatPosteJury.setEpreuve((Epreuve)item);
                    epreuveOptionCandidatPosteJury.setOption((Option) option);
                    this.implementationDAO = new EpreuveCandidatPosteJuryRepository(this.factory);
                    this.implementationDAO.save(epreuveOptionCandidatPosteJury);
                }
                   
            }
        }
        HashMap<Critere,List<Modalite>> choixCritereModalite = (HashMap<Critere,List<Modalite>>) this.formData.get("choixCritereModalite");
        for (Map.Entry<Critere,List<Modalite>> entry : choixCritereModalite.entrySet()) {
            Critere crit = entry.getKey();
            for (Modalite mod : entry.getValue()) {
                critereCandidatPosteJury.setCritere(crit);
                critereCandidatPosteJury.setModalite(mod);
                this.implementationDAO = new CritereCandidatPosteRepository(this.factory);
                this.implementationDAO.save(critereCandidatPosteJury);
                System.out.println("Clé : " + mod.getId() + ", Valeur : " + crit.getId());
            }
        }
        
        /*HashMap<Modalite,Critere> choixCritereModalite = (HashMap<Modalite,Critere>) this.formData.get("choixCritereModalite");
        for (Map.Entry<Modalite, Critere> entry : choixCritereModalite.entrySet()) {
            Modalite cle = entry.getKey();
            Critere valeur = entry.getValue();
            critereCandidatPosteJury.setCritere(valeur);
            critereCandidatPosteJury.setModalite(cle);
            this.implementationDAO = new CritereCandidatPosteRepository(this.factory);
            this.implementationDAO.save(critereCandidatPosteJury);
        }*/
        return candidat;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }

    public List<Objet> getAllWithoutRetenu() throws SQLException {
        return ((CandidatPosteJuryRepository)this.implementationDAO).getAllWithoutRetenu();
    }
    
    
    public Objet updateCandidat() throws SQLException, EmptyDataException {
        CandidatPosteJury candidat = new CandidatPosteJury(this.formData);
        EpreuveOptionCandidatPosteJury epreuveOptionCandidatPosteJury = new EpreuveOptionCandidatPosteJury(this.formData);
        CritereCandidatPosteJury critereCandidatPosteJury = new CritereCandidatPosteJury(this.formData);
        candidat.getCandidat().setId(Long.valueOf((String)this.formData.get("candidat_id")));
        epreuveOptionCandidatPosteJury.setCandidatPosteJury(candidat);
        critereCandidatPosteJury.setCandidatPosteJury(candidat);
        this.implementationDAO = new CandidatPosteJuryRepository(this.factory);
        ((CandidatPosteJuryRepository)this.implementationDAO).updateCandidat(candidat);
        this.implementationDAO = new EpreuveCandidatPosteJuryRepository(this.factory);
        ((EpreuveCandidatPosteJuryRepository)this.implementationDAO).deleteEPCan(epreuveOptionCandidatPosteJury);
        ObservableList<Object> selectedItems = (ObservableList<Object>) this.formData.get("epreuve");
        List<Objet> allOption = (List<Objet>) this.formData.get("option");
        if(this.formData.get("epreuve") !=null){
            for (Object item : selectedItems) {
                for(Objet option : allOption){
                    epreuveOptionCandidatPosteJury.setEpreuve((Epreuve)item);
                    epreuveOptionCandidatPosteJury.setOption((Option) option);
                    this.implementationDAO = new EpreuveCandidatPosteJuryRepository(this.factory);
                    this.implementationDAO.save(epreuveOptionCandidatPosteJury);
                }
                   
            }
        }
        this.implementationDAO = new CritereCandidatPosteRepository(this.factory);
        ((CritereCandidatPosteRepository)this.implementationDAO).deleteCritereModal(critereCandidatPosteJury);
        HashMap<Critere,List<Modalite>> choixCritereModalite = (HashMap<Critere,List<Modalite>>) this.formData.get("choixCritereModalite");
        
        for (Map.Entry<Critere,List<Modalite>> entry : choixCritereModalite.entrySet()) {
            Critere crit = entry.getKey();
            for (Modalite mod : entry.getValue()) {
                critereCandidatPosteJury.setCritere(crit);
                critereCandidatPosteJury.setModalite(mod);
                this.implementationDAO = new CritereCandidatPosteRepository(this.factory);
                this.implementationDAO.save(critereCandidatPosteJury);
               // System.out.println("Clé : " + mod.getId() + ", Valeur : " + crit.getId());
            }
        }
        return candidat;
    }

    
    @Override
    public void validate() throws EmptyDataException {
        
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        CandidatPosteJury candidat = (CandidatPosteJury)objet;
        candidat.setEtatCandidature("Retenu");
        return this.implementationDAO.upadte(candidat);
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void delete(Objet objet) throws SQLException{
        this.implementationDAO = new CritereCandidatPosteRepository(this.factory);
        ((CritereCandidatPosteRepository)this.implementationDAO).delete(objet);
        
        this.implementationDAO = new EpreuveCandidatPosteJuryRepository(this.factory);
        ((EpreuveCandidatPosteJuryRepository)this.implementationDAO).delete(objet);
        
        this.implementationDAO = new CandidatPosteJuryRepository(this.factory);
        ((CandidatPosteJuryRepository)this.implementationDAO).delete(objet);
    }
}
