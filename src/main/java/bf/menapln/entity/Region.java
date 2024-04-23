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
public class Region extends Localite{
    public Region(ResultSet rs) throws SQLException {
        this.setId(rs.getLong("region_id"));
        this.setCodeLocalite(rs.getString("codeRegion"));
        this.setNomLoclite(rs.getString("libelleRegion"));
    }
}
