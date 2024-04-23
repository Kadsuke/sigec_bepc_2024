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
public class Structure extends Objet{
    private Type typeStructure;
    private String codeStructure;
    private String nomStructure;
    private String acronymeStructure;
    private String capacite;
    private Localite localite;
    private Structure parent;
    
    public Structure(){
        super();
    }
    public Structure(Map data){
        super(data);
        this.setCodeStructure((String) data.get("codeStructure"))
        .setNomStructure((String) data.get("nomStructure"))
        .setAcronymeStructure((String) data.get("acronymeStructure"))
        .setLocalite((Localite)data.get("localiteStructure"))
        .setTypeStructure((Type) data.get("typeStructure"));
        if((Structure) data.get("structureParente") == null){
            this.setParent(new Structure());
            }else{
            this.setParent((Structure) data.get("structureParente"));
            }
        
       // .setParent(new Structure());
        
    }
    
     public Structure(ResultSet rs) throws SQLException {
        this.setCodeStructure(rs.getString("codeStructure"));
        this.setId(rs.getLong("structure_id"));
        this.setNomStructure(rs.getString("nomStructure"));
        this.setAcronymeStructure(rs.getString("acronymeStructure"));
        this.setTypeStructure(Type.id(rs.getLong("typeStructure_id")));
    }
    public static Structure id(Long id){
        id = (id == null || id == 0)?null:id;
        Structure structure = new Structure();
        structure.setId(id);
        return structure;
    }
    
   
    public Type getTypeStructure() {
        return typeStructure;
    }

    public Structure setTypeStructure(Type typeStructure) {
        this.typeStructure = typeStructure;
        return this;
    }

    public String getCodeStructure() {
        return codeStructure;
    }

    public Structure setCodeStructure(String codeStructure) {
        this.codeStructure = codeStructure;
        return this;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public Structure setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
        return this;
    }

    public String getAcronymeStructure() {
        return acronymeStructure;
    }

    public Structure setAcronymeStructure(String acronymeStructure) {
        this.acronymeStructure = acronymeStructure;
        return this;
    }

    public String getCapacite() {
        return capacite;
    }

    public Structure setCapacite(String capacite) {
        this.capacite = capacite;
        return this;
    }

    
    public Localite getLocalite() {
        return localite;
    }

    public Structure setLocalite(Localite localite) {
        this.localite = localite;
        return this;
    }


    public Structure getParent() {
        return parent;
    }

    public Structure setParent(Structure parent) {
        this.parent = parent;
        return this;
    }
    
    public String toString(){
        if(this.acronymeStructure == null){
            return this.nomStructure;
        }else{
            return this.nomStructure;
        }
    }
    
}
