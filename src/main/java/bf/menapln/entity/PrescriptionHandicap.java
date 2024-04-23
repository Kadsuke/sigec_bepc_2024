/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author coulibaly
 */
public class PrescriptionHandicap extends Type{
    public PrescriptionHandicap(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("prescription_id"));
        this.setLibelle(rs.getString("prescriptionLibelle"));
    }    
}
