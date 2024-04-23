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
public class PrescriptionNatureHandicapService extends Service{
    public PrescriptionNatureHandicapService() throws SQLException{
        super();
        this.implementationDAO = new PrescriptionNatureHandicapRepository(this.factory);
    }
    
    @Override
    public Objet save() throws SQLException {
        PrescriptionNatureHandicap prescriptionNatureandicap = new PrescriptionNatureHandicap(this.formData);
        return this.implementationDAO.save(prescriptionNatureandicap);
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
    
    public List<Objet> getByNatureHandicap(NatureHandicap str) throws SQLException {
        return ((PrescriptionNatureHandicapRepository)this.implementationDAO).getByNatureHandicap(str);
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
    
}
