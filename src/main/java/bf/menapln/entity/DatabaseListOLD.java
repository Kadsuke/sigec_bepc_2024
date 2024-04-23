/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tiere
 */
public class DatabaseListOLD<Integer,DatabaseEntity> extends HashMap<Integer,DatabaseEntity> {
   private DatabaseEntity localDataBase;
    
    private Map<List<Long>,String> candidatExKeys;
    private List<DoublonOLD> doublonCandidatExKeys;
    
    private Map<List<Long>,String> GPKeys;
    private List<DoublonOLD> doublonGPKeys;
//    
    private Map<List<Long>,String> acteurKeys;
    private List<DoublonOLD> doublonActeurKeys;
    
    private Map<List<Long>,String> acteurNIPKeys;
    private List<DoublonOLD> doublonActeurNIPKeys;

    public DatabaseListOLD(){
        this.candidatExKeys = new HashMap<List<Long>,String>();
        this.doublonCandidatExKeys = new ArrayList<DoublonOLD>();
        
        this.GPKeys = new HashMap<List<Long>,String>();
        this.doublonGPKeys = new ArrayList<DoublonOLD>();
        
        this.acteurKeys = new HashMap<List<Long>,String>();
        this.doublonActeurKeys = new ArrayList<DoublonOLD>();
        
        this.acteurNIPKeys = new HashMap<List<Long>,String>();
        this.doublonActeurNIPKeys = new ArrayList<DoublonOLD>();
        
    }
    
    public DatabaseListOLD(String localDataBasePath){
        super();
        //this.localDataBase = new DatabaseEntity(localDataBasePath,localDataBasePath);
    }
    
    public void setCandidatExKeys(ResultSet rs,String currentDB) throws SQLException{
        String candidatName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<Long> key = new ArrayList<Long>();
        key.add(rs.getLong("session_id"));
        key.add(rs.getLong("etablissement_id"));
        key.add(rs.getLong("candidat_id"));
        key.add(rs.getLong("numeroDossier"));
        if(!this.candidatExKeys.containsKey(key)){
            this.candidatExKeys.put(key, candidatName); 
        }else{
            List<String> doublon = new ArrayList<String>();
            doublon.add(this.candidatExKeys.get(key));
            doublon.add(candidatName);
            this.doublonCandidatExKeys.add(new DoublonOLD(key,this.candidatExKeys.get(key),candidatName));
        }
    }
    
    public void setGPKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("groupePedagogiqueLibelle")+")";
        List<Long> key = new ArrayList<Long>();
        key.add(rs.getLong("session_id"));
        key.add(rs.getLong("etablissement_id"));
        key.add(rs.getLong("groupePedagogique_id"));
        if(!this.GPKeys.containsKey(key)){
            this.GPKeys.put(key, gpName);
        }else{
            this.doublonGPKeys.add(new DoublonOLD(key,this.GPKeys.get(key),gpName));
        }
    }
    
    public void setActeurKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<Long> key = new ArrayList<Long>();
        key.add(rs.getLong("session_id"));
        key.add(rs.getLong("structure_id"));
        key.add(rs.getLong("candidat_id"));
        if(!this.acteurKeys.containsKey(key)){
            this.acteurKeys.put(key, gpName);
        }else{
            this.doublonActeurKeys.add(new DoublonOLD(key,this.acteurKeys.get(key),gpName));
        }
    }
    
    public void setActeurNIPKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<Long> key = new ArrayList<Long>();
        key.add(rs.getLong("nip"));
        if(!this.acteurNIPKeys.containsKey(key)){
            this.acteurNIPKeys.put(key, gpName);
        }else{
            this.doublonActeurNIPKeys.add(new DoublonOLD(key,this.acteurNIPKeys.get(key),gpName));
        }
    }
    
    public boolean hasDoublon(){
        if(!this.getDoublonActeurKeys().isEmpty() || !this.getDoublonCandidatExKeys().isEmpty() || !this.getDoublonActeurNIPKeys().isEmpty()){
            return true;
        }
        return false;
    }

    public Map<List<Long>, String> getCandidatExKeys() {
        return candidatExKeys;
    }

    public void setCandidatExKeys(Map<List<Long>, String> candidatExKeys) {
        this.candidatExKeys = candidatExKeys;
    }

    public List<DoublonOLD> getDoublonCandidatExKeys() {
        return doublonCandidatExKeys;
    }

    public void setDoublonCandidatExKeys(List<DoublonOLD> doublonCandidatExKeys) {
        this.doublonCandidatExKeys = doublonCandidatExKeys;
    }

    public Map<List<Long>, String> getGPKeys() {
        return GPKeys;
    }

    public void setGPKeys(Map<List<Long>, String> GPKeys) {
        this.GPKeys = GPKeys;
    }

    public List<DoublonOLD> getDoublonGPKeys() {
        return doublonGPKeys;
    }

    public void setDoublonGPKeys(List<DoublonOLD> doublonGPKeys) {
        this.doublonGPKeys = doublonGPKeys;
    }

    public Map<List<Long>, String> getActeurKeys() {
        return acteurKeys;
    }

    public void setActeurKeys(Map<List<Long>, String> acteurKeys) {
        this.acteurKeys = acteurKeys;
    }

    public List<DoublonOLD> getDoublonActeurKeys() {
        return doublonActeurKeys;
    }

    public void setDoublonActeurKeys(List<DoublonOLD> doublonActeurKeys) {
        this.doublonActeurKeys = doublonActeurKeys;
    }

    public Map<List<Long>, String> getActeurNIPKeys() {
        return acteurNIPKeys;
    }

    public void setActeurNIPKeys(Map<List<Long>, String> acteurNIPKeys) {
        this.acteurNIPKeys = acteurNIPKeys;
    }

    public List<DoublonOLD> getDoublonActeurNIPKeys() {
        return doublonActeurNIPKeys;
    }

    public void setDoublonActeurNIPKeys(List<DoublonOLD> doublonActeurNIPKeys) {
        this.doublonActeurNIPKeys = doublonActeurNIPKeys;
    }

    public DatabaseEntity getLocalDataBase() {
        return localDataBase;
    }

    public void setLocalDataBase(DatabaseEntity localDataBase) {
        this.localDataBase = localDataBase;
    }
    
     
}
