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
public class TypeCandidature extends Type{
    public TypeCandidature(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("typeCandidat_id"));
        this.setLibelle(rs.getString("typeCandidatLibelle"));
        // this.setDefaultEntity(rs.getBoolean("typeCandidatDefault"));
        // System.out.println("def val : "+this.getLibelle()+" "+this.isDefaultEntity());
    }
}
