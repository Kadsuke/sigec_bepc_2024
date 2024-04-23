/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Structure;
import bf.menapln.repository.EtablissementRepository;
import bf.menapln.repository.StructureRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class StructureService extends Service{
    public StructureService() throws SQLException{
        super();
        this.implementationDAO = new StructureRepository(this.factory);
    }
    
    @Override
    public Objet save() throws SQLException, EmptyDataException {
        Structure structure = new Etablissement(this.formData);
        this.setImplementation((String)this.formData.get("typoField"));
        this.implementationDAO.save(structure);
        return structure;
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        this.implementationDAO = new StructureRepository(this.factory);
        return this.implementationDAO.getAll();
    }

    @Override
    public void validate() throws EmptyDataException {
        
    }

    @Override
    public void setImplementation(String str) {
        switch(str){
            case "Etablissement":
                this.implementationDAO = new EtablissementRepository(this.factory);
            break;
            default:
                this.implementationDAO = new StructureRepository(this.factory);
            break;
        }
    }
    
    public List<Objet> getAllTypeStructure(String str) throws SQLException {
       return ((StructureRepository)this.implementationDAO).getAllEtablissement(str);       
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Objet> getByLocaliteId(String str) throws SQLException {
        return ((StructureRepository)this.implementationDAO).getByLocaliteId(Long.parseLong(str));
    }
    
    public List<Objet> getByTypeLocaliteAndId(String type,Localite localite) throws SQLException {
        return ((StructureRepository)this.implementationDAO).getByTypeLocaliteId(type,localite);
    }
    
    public List<Objet> getByCommuneId(String type,Localite localite) throws SQLException {
        return ((StructureRepository)this.implementationDAO).getByCommuneId(type,localite);
    }
    
    public List<Objet> getByProvinceId(String type,Localite localite) throws SQLException {
        return ((StructureRepository)this.implementationDAO).getByProvinceId(type,localite);
    }
    
    public List<Objet> getByRegionId(String type,Localite localite) throws SQLException {
        return ((StructureRepository)this.implementationDAO).getByRegionId(type,localite);
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
