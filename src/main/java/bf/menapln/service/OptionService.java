/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.repository.OptionRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class OptionService extends Service{
    public OptionService() throws SQLException{
        super();
        this.implementationDAO = new OptionRepository(this.factory);
    }
    
    @Override
    public Objet save() throws SQLException, EmptyDataException {
       // this.validate();
        Option option = new Option(this.formData);
        this.implementationDAO.save(option);
        return option;
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    /*
    public List<Objet> getSerie(Session session, Localite villeComposition) throws SQLException {
        return ((SerieRepository)this.implementationDAO).getSerie(session, villeComposition);
    }
    
    public List<Objet> getSerie(Jury jury) throws SQLException {
        return ((SerieRepository)this.implementationDAO).getSerie(jury);
    }
*/
    @Override
    public void validate() throws EmptyDataException {
       
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

    @Override
    public Objet getById(Long id) throws SQLException {
        return ((OptionRepository)this.implementationDAO).getById(id);

    }
    
}
