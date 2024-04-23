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
public class GroupePedagogique extends Objet{
    private String groupePedagogiqueLibelle;
    private Structure etablissement;
    private Session session;

    public GroupePedagogique(){
        super();
    }
    public GroupePedagogique(Map data){
        this.setId(Long.valueOf((String)data.get("groupePedagogique_id")));
        this.setSession((Session) data.get("session"));
        this.setGroupePedagogiqueLibelle((String) data.get("groupePedagogique"));
        this.setEtablissement((Structure) data.get("etablissement"));
       
    }

    public GroupePedagogique(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("gp_id"));
       this.setGroupePedagogiqueLibelle(rs.getString("gpLibelle"));
    }
    
    public static GroupePedagogique id(Long id){
        id = (id == null || id == 0)?null:id;
        GroupePedagogique groupePedagogique = new GroupePedagogique();
        groupePedagogique.setId(id);
        return groupePedagogique;
    }
    /*
    public GroupePedagogique(ResultSet rs) throws SQLException {
        this.setCodeLocalite(rs.getString("codeLocalite"));
        this.setNomLoclite(rs.getString("nomLocalite"));
        //this.setTypeLocalite(Type.id(rs.getLong("typeLocalite_id")));
        //this.setParentLocalite(Localite.id(Long.parseLong((String) data.get("parentLocalite"))));
    }
*/

    public String getGroupePedagogiqueLibelle() {
        return groupePedagogiqueLibelle;
    }

    public void setGroupePedagogiqueLibelle(String groupePedagogiqueLibelle) {
        this.groupePedagogiqueLibelle = groupePedagogiqueLibelle;
    }

    public Structure getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Structure etablissement) {
        this.etablissement = etablissement;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    public String toString(){
        return this.groupePedagogiqueLibelle;
    }
    
}
