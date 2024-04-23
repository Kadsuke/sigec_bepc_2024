/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.service;

import bf.menapln.entity.*;
import bf.menapln.exception.EmptyDataException;
import java.sql.SQLException;
import bf.menapln.repository.*;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class CritereService extends Service {
    public CritereService() throws SQLException{
        super();
        this.implementationDAO = new CritereRepository(this.factory);
    }
    @Override
    public Objet save() throws SQLException {
        Critere critere = new Critere(this.formData);
        this.implementationDAO.save(critere);
        //CriterePoste criterePoste = new CriterePoste(formData);
        //criterePoste.setCritere(critere);
       // this.implementationDAO = new CritereRepository(this.factory);
        
        //this.implementationDAO = new CriterePosteRepository(this.factory);
      //  ObservableList<Object> selectedItems = (ObservableList<Object>) this.formData.get("listmodalite");
      //  for (Object item : selectedItems) {
      //      System.out.println("Modalite : " + item);
       //     criterePoste.setModalite((Modalite)item);
       //     this.implementationDAO.save(criterePoste);
      //  }
        
        return critere;
    }

    @Override
    public List<Objet> getByParentId(String str) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll(String str) throws SQLException {
        return this.implementationDAO.getAll();
    }
    
    public List<Objet> getAllCritPost() throws SQLException {
        this.implementationDAO = new CriterePosteRepository(this.factory);
        return ((CriterePosteRepository)this.implementationDAO).getAll();
    }
    
    public Objet getAllByPoste(Type poste) throws SQLException{
        this.implementationDAO = new CriterePosteRepository(this.factory);
        return ((CriterePosteRepository)this.implementationDAO).getAllByPoste(poste);
     //   System.out.println("Modalite : " + ((CriterePosteRepository)this.implementationDAO).getAllByPoste(poste));
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

    @Override
    public void validate() throws exception.EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
