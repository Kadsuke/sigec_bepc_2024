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
public class Commune extends Localite{
    public Commune(ResultSet rs) throws SQLException {
        this.setId(rs.getLong("commune_id"));
        this.setCodeLocalite(rs.getString("codeCommune"));
        this.setNomLoclite(rs.getString("libelleCommune"));
        this.setParentLocalite(new Province(rs));
    }
}
