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
public class Province extends Localite{
    public Province(ResultSet rs) throws SQLException {
        this.setId(rs.getLong("province_id"));
        this.setCodeLocalite(rs.getString("codeProvince"));
        this.setNomLoclite(rs.getString("libelleProvince"));
        this.setParentLocalite(new Region(rs));
    }
}
