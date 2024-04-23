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
public class NatureHandicap extends Objet{
    private Type typeHandicap;
    private String natureHandicapLibelle;
    
    public NatureHandicap(){
        super();
    }
    
    public NatureHandicap(Map data){
        this.setNatureHandicapLibelle((String) data.get("natureHandicap"));
        this.setTypeHandicap((Type)(data.get("typeHandicap")));
    }
    
    public NatureHandicap(ResultSet rs) throws SQLException {
        this.setId(rs.getLong("natureHandicap_id"));
        this.setTypeHandicap(Type.id(rs.getLong("typeHandicap_id")));
        this.getTypeHandicap().setLibelle(rs.getString("typeHandicapLibelle"));
        this.setNatureHandicapLibelle(rs.getString("natureHandicapLibelle"));
    }
        
    
    public static NatureHandicap id(Long id){
        NatureHandicap h = new NatureHandicap();
        h.setId(id);
        return h;
    }
    
    public Type getTypeHandicap() {
        return typeHandicap;
    }

    public void setTypeHandicap(Type typeHandicap) {
        this.typeHandicap = typeHandicap;
    }

    public String getNatureHandicapLibelle() {
        return natureHandicapLibelle;
    }

    public void setNatureHandicapLibelle(String natureHandicapLibelle) {
        this.natureHandicapLibelle = natureHandicapLibelle;
    }
    
     public String toString() {
        return this.natureHandicapLibelle;
    }
    
}
