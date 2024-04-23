/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.repository.*;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class NatureHandicapService extends Service{
    public NatureHandicapService() throws SQLException{
        super();
        this.implementationDAO = new NatureHandicapRepository(this.factory);
    }
    
    @Override
    public Objet save() throws SQLException {
        NatureHandicap natureHandicap = new NatureHandicap(this.formData);
        System.out.println((String)this.formData.get("typeHandicap_id"));
        return this.implementationDAO.save(natureHandicap);
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Objet> getByTypeHandicap(Type str) throws SQLException {
        return ((NatureHandicapRepository)this.implementationDAO).getByTypeHandicap(str);
    }
    
}
