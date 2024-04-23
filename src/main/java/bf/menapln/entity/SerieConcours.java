/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kadsuke
 */
public class SerieConcours extends Objet{
    private Session session;
    private Type serie;
    private Type concoursRattache;

    public SerieConcours() {
        super();
}
    
    public SerieConcours(Map data){
        this.setSession((Session) data.get("session"));
        this.setSerie((Type) data.get("serie"));
        this.setConcoursRattache((Type) data.get("concoursRattache"));
   }

    public SerieConcours(ResultSet rs) throws SQLException{
        this.setSerie(Type.id(rs.getLong("serieChoix")));
        this.getSerie().setLibelle(rs.getString("serieLibelle"));
    }
    
    public static SerieConcours id(Long id){
        SerieConcours eo = new SerieConcours();
        eo.setId(id);
        return eo;
    }
        
    public Type getSerie() {
        return serie;
    }

    public void setSerie(Type serie) {
        this.serie = serie;
    }

    public Type getConcoursRattache() {
        return concoursRattache;
    }

    public void setConcoursRattache(Type concoursRattache) {
        this.concoursRattache = concoursRattache;
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String toString(){
        return this.serie.getLibelle();
    }
}
