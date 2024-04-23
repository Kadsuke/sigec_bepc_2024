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
public class PaysNationalite extends Pays{
    public PaysNationalite(ResultSet rs) throws SQLException{
        this.setPaysToString(false);
        this.setId(rs.getLong("nationalite_id"));
        this.setNationalite(rs.getString("nationalite"));
    }
}
