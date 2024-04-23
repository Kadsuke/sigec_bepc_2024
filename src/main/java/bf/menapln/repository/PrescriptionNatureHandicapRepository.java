/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.NatureHandicap;
import bf.menapln.entity.Objet;
import bf.menapln.entity.PrescriptionNatureHandicap;
import bf.menapln.entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class PrescriptionNatureHandicapRepository extends Repository implements InterfaceDAO{

    public PrescriptionNatureHandicapRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        PrescriptionNatureHandicap prescriptionNatureHandicap = (PrescriptionNatureHandicap)objet;
        String sql;
        sql = "INSERT INTO prescriptionHandicap(prescription_id,natureHandicap_id) VALUES(?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, prescriptionNatureHandicap.getTypePrescription().getId());
        pstmt.setLong(2, prescriptionNatureHandicap.getNatureHandicap().getId());
        pstmt.executeUpdate();
        //prescriptionNatureHandicap.setId(this.lastInsertedId());
        return prescriptionNatureHandicap;    }

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
    
    public List<Objet> getByNatureHandicap(NatureHandicap natureHandicap) throws SQLException {
        String sql = "select * from viewPrescriptionHandicap where natureHandicap_id = ? ";
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, natureHandicap.getId());
        ResultSet rs    = pstmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Type prescriptionNatureHandicap = new Type();
            prescriptionNatureHandicap.setId(rs.getLong("prescription_id"));
            prescriptionNatureHandicap.setLibelle(rs.getString("prescriptionLibelle"));
           /* PrescriptionNatureHandicap prescriptionNatureHandicap = new PrescriptionNatureHandicap();
            prescriptionNatureHandicap.setNatureHandicap(NatureHandicap.id(rs.getLong("natureHandicap_id")));
            prescriptionNatureHandicap.getNatureHandicap().setNatureHandicapLibelle(rs.getString("natureHandicapLibelle"));
            prescriptionNatureHandicap.setTypePrescription(Type.id(rs.getLong("prescription_id")));
            prescriptionNatureHandicap.getTypePrescription().setLibelle(rs.getString("prescriptionLibelle"));*/
            liste.add(prescriptionNatureHandicap);
        }
           return liste;
    }
    
}
