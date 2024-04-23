/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class Zone extends VilleComposition{
    private Session session;
    
    public Zone(){
        super();
    }
    
    public Zone(Map data){
        this.setNomLoclite((String) data.get("libelleZone"));
        this.setSession((Session) data.get("session"));
        this.setParentLocalite((Localite) data.get("villeComposition"));
    }
    public Zone(ResultSet rs) throws SQLException{
        this.setParentLocalite(Localite.id(rs.getLong("localite_id")));
        this.setId(rs.getLong("zone_id"));
        this.setNomLoclite(rs.getString("libelleZone"));
        this.setSession(Session.id(rs.getLong("session_id")));
    }
    
    public static Zone id(Long id){
        id = (id == null || id == 0)?null:id;
        Zone zone =  new Zone();
        zone.setId(id);
        return zone;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }    
    
}
