/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.CentreJury;
import bf.menapln.entity.Etablissement;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Modalite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Structure;
import bf.menapln.entity.TourComposition;
import bf.menapln.enumeration.TypeCentres;
import bf.menapln.repository.CentreJuryRepository;
import bf.menapln.repository.CriterePosteRepository;
import bf.menapln.repository.EtatJuryRepository;
import bf.menapln.repository.JuryRepository;
import javafx.collections.ObservableList;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class JuryService extends Service{
    
    public JuryService() throws SQLException{
        super();
        this.implementationDAO = new JuryRepository(this.factory);
    }

    @Override 
    public Objet save() throws SQLException {
        Jury jury = new Jury(this.formData);
        this.implementationDAO.save(jury);
        this.implementationDAO = new CentreJuryRepository(this.factory); 
        List<Object> selectedItems = (List<Object>) this.formData.get("listCentreSecondaire");
        List<Localite> centreA = new ArrayList<>();
       // centreA.add(jury.getCentreExamen());
        for (Object item : selectedItems) {
            centreA.add((Localite)item);
       }
       Localite centrePrin = (Localite)this.formData.get("centreExamen_id");
       CentreJury cjPrincipal = new CentreJury();
       List<CentreJury> listeCentreJ = new ArrayList<>();
        cjPrincipal.setJury(jury);
        cjPrincipal.setCentre(centrePrin);
        cjPrincipal.setTypeCentres(TypeCentres.PRINCIPAL);
        listeCentreJ.add(cjPrincipal);

        for (Localite cen : centreA) {
            CentreJury cjSecondaire = new CentreJury();
            cjSecondaire.setJury(jury);
            cjSecondaire.setCentre(cen);
            cjSecondaire.setTypeCentres(TypeCentres.SECONDAIRE);
            listeCentreJ.add(cjSecondaire);
        }
        for (CentreJury iterable_element : listeCentreJ) {
            System.out.println("Rouge Noir B2OBA"+iterable_element.toString());
            this.implementationDAO.save(iterable_element);
        }
        return jury;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Objet> getAllDefaultJury() throws SQLException {
        return ((JuryRepository)this.implementationDAO).getAllDefaultJury();
    }

    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getJury(Localite etab) throws SQLException {
        return ((JuryRepository)this.implementationDAO).getJury(etab);
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        return this.implementationDAO.upadte(objet);
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        Jury jury = (Jury) this.implementationDAO.getById(id);
        this.implementationDAO = new EtatJuryRepository(this.factory);
        jury.setEtape((TourComposition) this.implementationDAO.getById(jury));
        return jury;
    }
    
    public void valideEtape(Jury jury) throws SQLException {
        this.implementationDAO = new EtatJuryRepository(this.factory);
        switch(jury.getEtape().getTourCode()){
            case 1 :
                TourComposition secondTour = (TourComposition) ((EtatJuryRepository)this.implementationDAO).getById(jury,false);
                secondTour.setActif(true);
                jury.getEtape().setValide(true);
                jury.getEtape().setActif(false);
                ((EtatJuryRepository)this.implementationDAO).updateEtape(jury);
                ((EtatJuryRepository)this.implementationDAO).valideEtape(jury);
                jury.setEtape(secondTour);
                ((EtatJuryRepository)this.implementationDAO).updateEtape(jury);
                //System.out.println(jury.getEtape().getTourCode());
            break;
            case 2 :
                jury.getEtape().setValide(true);
            break;
        }
    }

    public List<Objet> getAllByCentreExamen(Localite centreExam) throws SQLException {
        return ((JuryRepository) this.implementationDAO).getAllByCentreExamen(centreExam);
    }

    @Override
    public void validate() throws exception.EmptyDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
    public Objet delete(Objet objet) throws SQLException{
        return this.implementationDAO.delete(objet);
    }
}
