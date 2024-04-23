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
public class User extends Objet{
    private Profil profil;
    private Personnel personnel;
    private Jury jury;
    private String username;
    private String pwd;
    private Structure structure;
    
    public User(){
        super();
    }
    
    public User(Map data){
        this.setUsername((String) data.get("username"));
        this.setPwd((String) data.get("pwd"));
        this.setProfil((Profil) data.get("profil"));
        this.setPersonnel((data.get("personnel") != null)? (Personnel)data.get("personnel"):new Personnel());
        this.setStructure((Structure) data.get("structure"));
    }
    
    public User(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("user_id"));
        this.setUsername(rs.getString("username"));
        this.setPwd(rs.getString("pwd"));
        this.setStructure((Structure.id(rs.getLong("userStructId"))));
        this.getStructure().setNomStructure(rs.getString("userStructLibelle"));
        this.getStructure().setTypeStructure((Type.id(rs.getLong("userTypeStructId"))));
        this.getStructure().getTypeStructure().setLibelle(rs.getString("userTypeStructLibelle"));
        this.getStructure().setLocalite(Localite.id(rs.getLong("commune_id")));
        this.getStructure().getLocalite().setNomLoclite(rs.getString("nom_commune"));
        this.getStructure().getLocalite().setParentLocalite(Localite.id(rs.getLong("province_id")));
        this.getStructure().getLocalite().getParentLocalite().setNomLoclite(rs.getString("nom_province"));
        this.getStructure().getLocalite().getParentLocalite().setParentLocalite(Localite.id(rs.getLong("region_id")));
        this.getStructure().getLocalite().getParentLocalite().getParentLocalite().setNomLoclite(rs.getString("nom_region"));
        
    }
    
    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
    
    
    
}
