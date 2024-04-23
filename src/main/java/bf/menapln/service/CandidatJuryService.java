/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Candidat;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.Inscription;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.repository.CandidatJuryRepository;
import bf.menapln.repository.InscriptionRepository;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class CandidatJuryService extends Service{
    public CandidatJuryService() throws SQLException{
        super();
        this.implementationDAO = new CandidatJuryRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException {
        CandidatJury candidat = new CandidatJury(this.formData);
       return  this.implementationDAO.save(candidat);
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getCandidatOrdered() throws SQLException {
        return ((CandidatJuryRepository)this.implementationDAO).getCandidatOrdered();
    }
    
    public List<Objet> savePV() throws SQLException, EmptyDataException {
        List<Objet> candidats = (List<Objet>)this.formData.get("listCandidats");
        Session s = (Session)this.formData.get("session");
        InscriptionRepository inscRepo = new InscriptionRepository(factory);
        Inscription ins = new Inscription();
        ins.setSession(s);
        for (Objet objet : candidats) {
            ins.setCandidat(((CandidatJury)objet).getCandidat());
            inscRepo.upadtePV(ins);
        }
       return  candidats;
    }

    public boolean deletePV() throws SQLException, EmptyDataException {
        Session s = (Session)this.formData.get("session");
        InscriptionRepository inscRepo = new InscriptionRepository(factory);
        Inscription ins = new Inscription();
        ins.setSession(s);
        inscRepo.deletePV(ins);
        return  true;
    }
    
    public List<Objet> getCandidatJury(Jury jury) throws SQLException {
        return ((CandidatJuryRepository)this.implementationDAO).getCandidatJury(jury);
    }



    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        System.out.println("DANS CandidatService");
        Candidat candidat = (Candidat)objet;
        CandidatService serv = new CandidatService();
        return serv.update(candidat);
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Objet getById(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    /*public List<Objet> getCandidatJurySpecialite(Jury jury,Specialite specialite) throws SQLException {
        return ((CandidatJuryRepository)this.implementationDAO).getCandidatJurySpecialite(jury, specialite);
    }*/

    /*public Objet updateEtatSport(CandidatJury candidatJury) throws SQLException{
        InscriptionRepository inscRepo = new InscriptionRepository(factory);
        Inscription inscrit = new Inscription();
        inscrit.setCandidat(candidatJury.getCandidat());
        FeuilleCompositionService feuilleService = new FeuilleCompositionService();
        FeuilleComposition feuille = (FeuilleComposition)feuilleService.getFeuille(candidatJury.getCandidat().getId(),15L);
        // feuille.setNote(null);
        // inscrit.setSession(candidatJury.getSession());
        if (feuille!= null) {
            feuilleService.updateNoteDDH(candidatJury.getCandidat().getId(),15L);
        }
        return inscRepo.upadteSport(inscrit);
    }*/
    
    public List<Objet> saveMultiple() throws SQLException, EmptyDataException {
        List<Objet> candidats = (List<Objet>)this.formData.get("listCandidats");
        Jury j = (Jury)this.formData.get("jury");
        for (Objet objet : candidats) {
            if (((CandidatJury)objet).getJury() != null) {
                System.out.println("ANCIEN JURY "+((CandidatJury)objet).getJury());
                this.implementationDAO.delete(objet);
            }
            ((CandidatJury)objet).setJury(j);
            this.implementationDAO.save(objet);
        }
       return  candidats;
    }
    
    public List<Objet> getAllCandidatJury() throws SQLException {
        return ((CandidatJuryRepository) this.implementationDAO).getAllCandidatJury();
    }
    @Override
    public void validate() throws exception.EmptyDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
}
