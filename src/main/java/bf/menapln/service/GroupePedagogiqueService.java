/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.GroupePedagogique;
import bf.menapln.entity.Objet;
import bf.menapln.repository.GroupePedagogiqueRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class GroupePedagogiqueService extends Service{
    public GroupePedagogiqueService() throws SQLException{
        super();
        //this.setImplementation("Etablissement");
        this.implementationDAO = new GroupePedagogiqueRepository(this.factory);
    }
    
    @Override
    public Objet save() throws SQLException, EmptyDataException {
        //this.validate();
        GroupePedagogique groupePedagogique = new GroupePedagogique(this.formData);
        this.implementationDAO.save(groupePedagogique);
        return groupePedagogique;
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
     public List<Objet> getAllGroupePedagogique() throws SQLException {
        return ((GroupePedagogiqueRepository)this.implementationDAO).getAllGroupePedagogique();
    }
    

    @Override
    public void validate() throws EmptyDataException {
        
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Objet getByGroupePedagogiqueId(String str) throws SQLException {
        return ((GroupePedagogiqueRepository)this.implementationDAO).getById(Long.parseLong(str));
    }
    
    public List<Objet> getByEtabId(String str) throws SQLException {
        return ((GroupePedagogiqueRepository)this.implementationDAO).getByEtablissementId(Long.parseLong(str));
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        return this.implementationDAO.upadte(objet);
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Long createId() throws SQLException{
        return ((GroupePedagogiqueRepository)this.implementationDAO).createId();
    }
    
    public Objet delete(Objet objet) throws SQLException{
        return this.implementationDAO.delete(objet);
    }
}
