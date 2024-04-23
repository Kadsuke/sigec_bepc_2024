/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Option;
import bf.menapln.entity.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class OptionRepository extends Repository implements InterfaceDAO {

    public OptionRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Option option = (Option) objet;
        String sql;
        sql = "INSERT INTO option(optionLibelle,optionDefinition) VALUES(?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setString(1, option.getOptionLibelle());
        pstmt.setString(2, option.getOptionDefinition());
        pstmt.executeUpdate();
        option.setId(this.lastInsertedId());
        return option;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM option";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Option option = new Option();
            option.setId(rs.getLong("option_id"));
            option.setOptionLibelle(rs.getString("optionLibelle"));
            option.setOptionDefinition(rs.getString("optionDefinition"));
           
            liste.add(option);
        }
           return liste;
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
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM option ORDER BY option_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("option_id");
        }
        return id;
    }

    }
  
