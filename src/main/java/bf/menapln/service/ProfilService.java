/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.Menu;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Profil;
import bf.menapln.entity.ProfilMenu;
import bf.menapln.repository.ProfilMenuRepository;
import bf.menapln.repository.ProfilRepository;
import exception.EmptyDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class ProfilService extends Service{
    
    public ProfilService() throws SQLException{
        super();
        this.implementationDAO = new ProfilRepository(this.factory);
    }

    @Override
    public Objet save() throws SQLException, EmptyDataException {
       // this.validate();
        Profil p = new Profil(this.formData);
        this.implementationDAO.save(p);
        return p;
    }
    
    public Objet saveProfilMenu() throws SQLException, EmptyDataException {
       // this.validate();
        ProfilMenu pm = new ProfilMenu(this.formData);
        this.implementationDAO = new ProfilMenuRepository(this.factory);
        List<Menu> men = (List<Menu>) this.formData.get("menus");
        for(Menu menu : men){
            System.out.print(menu.getMenuLibelle());
            pm.setMenu(menu);
            this.implementationDAO.save(pm);
        }   
        return pm;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet update(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validate() throws EmptyDataException {
        Profil p = (Profil) this.formData.get("profil");
        if(p.getProfilLibelle().isEmpty()){
            throw new EmptyDataException("Le libellé du profil ne doit pas être vide");
        }
        if(p.getMenus().isEmpty()){
            throw new EmptyDataException("Aucun menu associé au profil");
        }
    }

    @Override
    public void setImplementation(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
