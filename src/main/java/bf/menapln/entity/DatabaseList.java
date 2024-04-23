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
 * @author coulibaly
 */
public class DatabaseList<Integer,DatabaseEntity> extends HashMap<Integer,DatabaseEntity>{
    private DatabaseEntity localDataBase;
    
    private Map<List<String>,String> candidatExKeys;
    private List<Doublon> doublonCandidatExKeys;
    
    private Map<List<String>,String> candidatExTelephone;
    private List<Doublon> doublonCandidatExTelephone;
    
    private Map<List<String>,String> GPKeys;
    private List<Doublon> doublonGPKeys;
    
    private Map<List<String>,String> acteurKeys;
    private List<Doublon> doublonActeurKeys;
    
    private Map<List<String>,String> acteurNIPKeys;
    private List<Doublon> doublonActeurNIPKeys;
    
    private Map<List<String>,String> acteurMatricules;
    private List<Doublon> doublonActeurMatricules;

    public DatabaseList(){
        this.candidatExKeys = new HashMap<List<String>,String>();
        this.doublonCandidatExKeys = new ArrayList<Doublon>();
        
        this.candidatExTelephone = new HashMap<List<String>,String>();
        this.doublonCandidatExTelephone = new ArrayList<Doublon>();
        
        this.GPKeys = new HashMap<List<String>,String>();
        this.doublonGPKeys = new ArrayList<Doublon>();
        
        this.acteurKeys = new HashMap<List<String>,String>();
        this.doublonActeurKeys = new ArrayList<Doublon>();
        
        this.acteurNIPKeys = new HashMap<List<String>,String>();
        this.doublonActeurNIPKeys = new ArrayList<Doublon>();
        
        this.acteurMatricules = new HashMap<List<String>,String>();
        this.doublonActeurMatricules = new ArrayList<Doublon>();
    }
    
    public DatabaseList(String localDataBasePath){
        super();
        //this.localDataBase = new DatabaseEntity(localDataBasePath,localDataBasePath);
    }
    
    public void setCandidatExKeys(ResultSet rs,String currentDB) throws SQLException{
        String candidatName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<String> key = new ArrayList<String>();
        key.add(String.valueOf(rs.getLong("session_id")));
        key.add(String.valueOf(rs.getLong("etablissement_id")));
        key.add(String.valueOf(rs.getLong("candidat_id")));
        key.add(String.valueOf(rs.getLong("numeroDossier")));
        if(!this.candidatExKeys.containsKey(key)){
            this.candidatExKeys.put(key, candidatName);
        }else{
            List<String> doublon = new ArrayList<String>();
            doublon.add(this.candidatExKeys.get(key));
            doublon.add(candidatName);
            this.doublonCandidatExKeys.add(new Doublon(key,this.candidatExKeys.get(key),candidatName));
        }
    }
    
    public void setGPKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("groupePedagogiqueLibelle")+")";
        List<String> key = new ArrayList<String>();
        key.add(String.valueOf(rs.getLong("session_id")));
        key.add(String.valueOf(rs.getLong("etablissement_id")));
        key.add(String.valueOf(rs.getLong("groupePedagogique_id")));
        if(!this.GPKeys.containsKey(key)){
            this.GPKeys.put(key, gpName);
        }else{
            this.doublonGPKeys.add(new Doublon(key,this.GPKeys.get(key),gpName));
        }
    }
    
    public void setActeurKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<String> key = new ArrayList<String>();
        key.add(String.valueOf(rs.getLong("session_id")));
        key.add(String.valueOf(rs.getLong("structure_id")));
        key.add(String.valueOf(rs.getLong("candidat_id")));
        if(!this.acteurKeys.containsKey(key)){
            this.acteurKeys.put(key, gpName);
        }else{
            this.doublonActeurKeys.add(new Doublon(key,this.acteurKeys.get(key),gpName));
        }
    }
    
    public void setActeurNIPKeys(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<String> key = new ArrayList<String>();
        key.add(String.valueOf(rs.getLong("nip")));
        if(!this.acteurNIPKeys.containsKey(key)){
            this.acteurNIPKeys.put(key, gpName);
        }else{
            this.doublonActeurNIPKeys.add(new Doublon(key,this.acteurNIPKeys.get(key),gpName));
        }
    }
    
    public void setActeurMatricules(ResultSet rs,String currentDB) throws SQLException{
        String gpName = currentDB+" : ("+rs.getString("nom")+" "+rs.getString("prenom")+")";
        List<String> key = new ArrayList<String>();
        key.add(rs.getString("matricule"));
        if(!this.acteurMatricules.containsKey(key)){
            this.acteurMatricules.put(key, gpName);
        }else{
            this.doublonActeurMatricules.add(new Doublon(key,this.acteurMatricules.get(key),gpName));
        }
    }
    
    public boolean hasDoublon(){
        if(!this.getDoublonActeurKeys().isEmpty() || !this.getDoublonActeurNIPKeys().isEmpty() || !this.getDoublonCandidatExKeys().isEmpty() || !this.getDoublonCandidatExTelephone().isEmpty() || !this.getDoublonGPKeys().isEmpty()){
            return true;
        }
        return false;
    }

    public Map<List<String>, String> getCandidatExKeys() {
        return candidatExKeys;
    }

    public void setCandidatExKeys(Map<List<String>, String> candidatExKeys) {
        this.candidatExKeys = candidatExKeys;
    }

    public List<Doublon> getDoublonCandidatExKeys() {
        return doublonCandidatExKeys;
    }

    public void setDoublonCandidatExKeys(List<Doublon> doublonCandidatExKeys) {
        this.doublonCandidatExKeys = doublonCandidatExKeys;
    }

    public Map<List<String>, String> getCandidatExTelephone() {
        return candidatExTelephone;
    }

    public void setCandidatExTelephone(Map<List<String>, String> candidatExTelephone) {
        this.candidatExTelephone = candidatExTelephone;
    }

    public List<Doublon> getDoublonCandidatExTelephone() {
        return doublonCandidatExTelephone;
    }

    public void setDoublonCandidatExTelephone(List<Doublon> doublonCandidatExTelephone) {
        this.doublonCandidatExTelephone = doublonCandidatExTelephone;
    }
    
    

    public Map<List<String>, String> getGPKeys() {
        return GPKeys;
    }

    public void setGPKeys(Map<List<String>, String> GPKeys) {
        this.GPKeys = GPKeys;
    }

    public List<Doublon> getDoublonGPKeys() {
        return doublonGPKeys;
    }

    public void setDoublonGPKeys(List<Doublon> doublonGPKeys) {
        this.doublonGPKeys = doublonGPKeys;
    }

    public Map<List<String>, String> getActeurKeys() {
        return acteurKeys;
    }

    public void setActeurKeys(Map<List<String>, String> acteurKeys) {
        this.acteurKeys = acteurKeys;
    }

    public List<Doublon> getDoublonActeurKeys() {
        return doublonActeurKeys;
    }

    public void setDoublonActeurKeys(List<Doublon> doublonActeurKeys) {
        this.doublonActeurKeys = doublonActeurKeys;
    }

    public Map<List<String>, String> getActeurNIPKeys() {
        return acteurNIPKeys;
    }

    public void setActeurNIPKeys(Map<List<String>, String> acteurNIPKeys) {
        this.acteurNIPKeys = acteurNIPKeys;
    }

    public List<Doublon> getDoublonActeurNIPKeys() {
        return doublonActeurNIPKeys;
    }

    public void setDoublonActeurNIPKeys(List<Doublon> doublonActeurNIPKeys) {
        this.doublonActeurNIPKeys = doublonActeurNIPKeys;
    }

    public Map<List<String>, String> getActeurMatricules() {
        return acteurMatricules;
    }

    public void setActeurMatricules(Map<List<String>, String> acteurMatricules) {
        this.acteurMatricules = acteurMatricules;
    }

    public List<Doublon> getDoublonActeurMatricules() {
        return doublonActeurMatricules;
    }

    public void setDoublonActeurMatricules(List<Doublon> doublonActeurMatricules) {
        this.doublonActeurMatricules = doublonActeurMatricules;
    }
    
    

    public DatabaseEntity getLocalDataBase() {
        return localDataBase;
    }

    public void setLocalDataBase(DatabaseEntity localDataBase) {
        this.localDataBase = localDataBase;
    }
    
}
