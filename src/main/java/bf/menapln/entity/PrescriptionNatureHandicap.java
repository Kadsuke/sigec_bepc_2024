/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class PrescriptionNatureHandicap extends Objet{
    private Type typePrescription;
    private NatureHandicap natureHandicap;

    public PrescriptionNatureHandicap() {
    }

   public PrescriptionNatureHandicap(Map data){   
        this.setTypePrescription((Type)(data.get("typePrecription")));
        this.setNatureHandicap((NatureHandicap)(data.get("natureHandicap")));
    }
    
    public PrescriptionNatureHandicap(ResultSet rs) throws SQLException {
        this.setTypePrescription(Type.id(rs.getLong("typeHandicap_id")));
        this.getTypePrescription().setLibelle(rs.getString("typeHandicapLibelle"));
   //     this.setNatureHandicap(NatureHan rs.getString("natureHandicapLibelle"));
    }

    
    public Type getTypePrescription() {
        return typePrescription;
    }

    public void setTypePrescription(Type typePrescription) {
        this.typePrescription = typePrescription;
    }

    public NatureHandicap getNatureHandicap() {
        return natureHandicap;
    }

    public void setNatureHandicap(NatureHandicap natureHandicap) {
        this.natureHandicap = natureHandicap;
    }

    @Override
    public String toString() {
        return this.getTypePrescription().getLibelle();
    }
    
    
    
}
