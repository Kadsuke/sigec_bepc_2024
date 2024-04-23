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
public class TypeInscription extends Type{
    public TypeInscription(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("typeInscription_id"));
        this.setLibelle(rs.getString("typeInscriptionLibelle"));
        // this.setDefaultEntity(rs.getBoolean("typeInscriptionDefault"));
    }
}
