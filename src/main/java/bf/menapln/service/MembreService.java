/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.CandidatPosteJury;
import bf.menapln.entity.Correcteur;
import bf.menapln.entity.Epreuve;
import bf.menapln.entity.EpreuveOptions;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Membre;
import bf.menapln.entity.Option;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.repository.CandidatPosteJuryRepository;
import bf.menapln.repository.DisciplineCorrecteurRepository;
import bf.menapln.repository.MembreJuryRepository;
import bf.menapln.repository.PersonnelRepository;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class MembreService extends Service{
    public MembreService() throws SQLException{
        super();
        this.implementationDAO = new MembreJuryRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException {
        Correcteur membre = new Correcteur(this.formData);
        this.implementationDAO = new PersonnelRepository(this.factory);
        this.implementationDAO.save(membre.getPersonnel());
        this.implementationDAO = new MembreJuryRepository(this.factory);
        this.implementationDAO.save(membre);
        if(membre.getPoste().getLibelle().equals("Correcteur")){
            this.implementationDAO = new DisciplineCorrecteurRepository(this.factory);
            for(Objet option : membre.getEpreuve().getOption()){
                membre.setEpreuveOption(new EpreuveOptions());
                membre.getEpreuveOption().setEpreuve(((Correcteur)membre).getEpreuve());
                membre.getEpreuveOption().setOption((Option)option);
                this.implementationDAO.save(membre);
            }
        }
        return null;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getCorrecteurs(Session session,Jury jury,Epreuve epreuve) throws SQLException{
        return ((MembreJuryRepository)this.implementationDAO).getCorrecteurs(session, jury, epreuve);
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    public List<Objet> getAllByJury(Objet id) throws SQLException {
        return ((MembreJuryRepository)this.implementationDAO).getAllByJury((Jury)id);
    }

    public List<Objet> saveMultiple() throws SQLException, EmptyDataException {
        List<Objet> candidats = (List<Objet>)this.formData.get("listActeurs");
        Jury j = (Jury)this.formData.get("jury");
        System.out.println(" JURY "+j.getCentreExamen().getId());
        CandidatPosteJuryRepository candidatRepo = new CandidatPosteJuryRepository(factory);
        MembreJuryRepository membreRepo = new MembreJuryRepository(this.factory);
        PersonnelRepository personnelRepo = new PersonnelRepository(this.factory);
        DisciplineCorrecteurRepository discCorrecteurRepo = new DisciplineCorrecteurRepository(this.factory);
         System.out.println("MembreService.saveMultiple() LISTE DES MEMBRES : "+candidats);
        for (Objet objet : candidats) {
            Correcteur membre = (Correcteur)objet;
            if (membre.getJury() != null) {//Si update
                 System.out.println("ANCIEN JURY "+membre.getJury());
                membreRepo.delete(membre);                
                discCorrecteurRepo.delete(membre);
                personnelRepo.delete(membre.getPersonnel());
            }
            membre.setJury(j);
            personnelRepo.save(membre.getPersonnel());
            this.implementationDAO.save(membre);
            for (Objet epreuve : membre.getCandidatPosteJury().getEpreuves()) {
                // System.out.println("MembreService.saveMultiple() "+epreuve);
                for(Objet option : ((Epreuve)epreuve).getOption()){
                    membre.setEpreuveOption(new EpreuveOptions());
                    membre.getEpreuveOption().setEpreuve((Epreuve)epreuve);
                    membre.getEpreuveOption().setOption((Option)option);
                    discCorrecteurRepo.save(membre);
                }
            }
            // Changement de l'état de candidature de l'acteur
            membre.getCandidatPosteJury().setEtatCandidature("Affecté");
            candidatRepo.updateEtatCandidature(membre.getCandidatPosteJury());
        }
       return  candidats;
    }

    // Pour l'affectation
    public List<Objet> getAllMembreJury() throws SQLException {
        return ((MembreJuryRepository) this.implementationDAO).getAllMembreJury();
    }
    @Override
    public void validate() throws exception.EmptyDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
}
