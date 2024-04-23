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
public class PaysNaissance extends Pays{
    public PaysNaissance(ResultSet rs) throws SQLException{
        this.setPaysToString(true);
        this.setId(rs.getLong("pays_id"));
        this.setNomPays(rs.getString("nomPays"));
    }
}
