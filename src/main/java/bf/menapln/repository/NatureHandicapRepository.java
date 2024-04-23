/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.NatureHandicap;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kadsuke
 */
public class NatureHandicapRepository extends Repository implements InterfaceDAO{

    public NatureHandicapRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        NatureHandicap type = (NatureHandicap)objet;
        String sql;
        sql = "INSERT INTO natureHandicap(typeHandicap_id,natureHandicapLibelle) VALUES(?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, type.getTypeHandicap().getId());
        pstmt.setString(2, type.getNatureHandicapLibelle());
        pstmt.executeUpdate();
        type.setId(this.lastInsertedId());
        return type;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "select nH.*,tH.* from natureHandicap nH\n" +
"INNER JOIN typeHandicap tH on tH.typeHandicap_id = nH.typeHandicap_id";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            NatureHandicap handicap = new NatureHandicap();
            handicap.setId(rs.getLong("natureHandicap_id"));
            handicap.setNatureHandicapLibelle(rs.getString("natureHandicapLibelle"));
            handicap.setTypeHandicap(Type.id(rs.getLong("typeHandicap_id")));
            handicap.getTypeHandicap().setLibelle(rs.getString("typeHandicapLibelle"));
            liste.add(handicap);
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
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM natureHandicap ORDER BY natureHandicap_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("natureHandicap_id");
        }
        return id;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Objet> getByTypeHandicap(Type typeHandicap) throws SQLException {
        String sql = "select * from natureHandicap where typeHandicap_id = ? ";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, typeHandicap.getId());
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            NatureHandicap handicap = new NatureHandicap();
            handicap.setId(rs.getLong("natureHandicap_id"));
            handicap.setNatureHandicapLibelle(rs.getString("natureHandicapLibelle"));
            handicap.setTypeHandicap(Type.id(rs.getLong("typeHandicap_id")));
            liste.add(handicap);
        }
           return liste;
    }
    
}
