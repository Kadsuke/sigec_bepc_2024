/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Centre;
import bf.menapln.entity.CentreComposition;
import bf.menapln.entity.Jury;
import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import bf.menapln.repository.CentreCompositionRepository;
import bf.menapln.repository.CentreRepository;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class CentreCompositionService extends Service{
    public CentreCompositionService() throws SQLException{
        super();
        this.implementationDAO = new CentreCompositionRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException {
        CentreComposition centre = new CentreComposition(this.formData);
        return this.implementationDAO.save(centre);
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getCentres() throws SQLException {
        return ((CentreCompositionRepository)this.implementationDAO).getCentres();
    }
    
    public List<Objet> getCentres(Localite villeComposition) throws SQLException {
        return ((CentreCompositionRepository)this.implementationDAO).getCentres(villeComposition);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    // 
    public List<Objet> getAllEtablissements() throws SQLException {
        return ((CentreCompositionRepository)this.implementationDAO).getAllEtablissements();
    }

    public List<Objet> saveMultiple() throws SQLException, EmptyDataException {
        List<Objet> centres = (List<Objet>)this.formData.get("listCentres");
        Session session = (Session)this.formData.get("session");
        for (Objet objet : centres) {
            CentreComposition c = (CentreComposition)objet;
            c.setSession(session);
            try {
                this.implementationDAO.save(c);//enregistrement
            } catch (Exception e) {
                try {
                    this.implementationDAO.upadte(c);//update
                } catch (Exception ex) {
                    // TODO: handle exception
                    ex.getStackTrace();
                }
            }
            
        }
       return  centres;
    }
    @Override
    public void validate() throws exception.EmptyDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
