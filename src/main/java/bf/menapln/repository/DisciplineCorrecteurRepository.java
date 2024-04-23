/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Correcteur;
import bf.menapln.entity.Membre;
import bf.menapln.entity.Objet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class DisciplineCorrecteurRepository extends Repository implements InterfaceDAO{

    public DisciplineCorrecteurRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Correcteur p = (Correcteur)objet;
        String sql;
        sql = "INSERT INTO disciplineCorrecteur(session_id,personnel_id,epreuve_id,option_id) VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, p.getSession().getId());
        pstmt.setLong(2, p.getPersonnel().getId());
        pstmt.setLong(3, p.getEpreuveOption().getEpreuve().getId());
        pstmt.setLong(4, p.getEpreuveOption().getOption().getId());
        pstmt.executeUpdate();
        return p;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        Correcteur cor = (Correcteur)objet;
        String sql;
        sql = "DELETE FROM disciplineCorrecteur WHERE session_id=? AND personnel_id=?";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, cor.getSession().getId());  
        pstmt.setLong(2, cor.getPersonnel().getId());        
        pstmt.executeUpdate();
        return cor;
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long lastInsertedId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
