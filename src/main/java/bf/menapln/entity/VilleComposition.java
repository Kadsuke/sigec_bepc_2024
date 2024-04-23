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
public class VilleComposition extends Localite{
    protected Integer effectif;
    protected Integer nombreJury;
    protected List<Option> series;
    protected Map<Long,Option> seriesMap;
    protected List<Jury> jurys;
    protected List<Centre> centreCompositions;
    protected List<Zone> zones;
    protected Map<Long,Zone> zonesMap;
    protected static Integer quantumCandidat;
    protected static Integer margeErreurMin;
    protected static Integer margeErreurMax;
    
     public VilleComposition(){
         super();
     }
    
    public VilleComposition(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("centreExamen_id"));
        this.setCodeLocalite(rs.getString("codeVilleComposition"));
        this.setNomLoclite(rs.getString("libelleVilleComposition"));
        if(this.fieldExist(rs, "effCentreExamen")){
            this.setEffectif(rs.getInt("effCentreExamen"));
        }
        if(this.fieldExist(rs, "commune_id")){
            this.setParentLocalite(new Commune(rs));
        }
    }

    public Integer getEffectif() {
        return effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }
    
    public void addEffectif(Integer effectif){
        this.effectif += effectif;
    }
    
    public void incrementEffectif(){
        this.effectif++;
    }

    public Integer getNombreJury() {
        return nombreJury;
    }

    public void setNombreJury(Integer nombreJury) {
        this.nombreJury = nombreJury;
    }

    public List<Centre> getCentreCompositions() {
        return centreCompositions;
    }

    public void setCentreCompositions(List<Centre> centreCompositions) {
        this.centreCompositions = centreCompositions;
    }
    
    public void addCentreCompositions(Centre centre) {
        centre.setLocalite(this);
        this.centreCompositions.add(centre);
    }

    public Map<Long, Zone> getZonesMap() {
        return zonesMap;
    }

    public void setZonesMap(Map<Long, Zone> zonesMap) {
        this.zonesMap = zonesMap;
    }
    
    public void addZoneMap(Zone zone){
        zone.setParentLocalite(this.getParentLocalite());
        this.zonesMap.put(zone.getId(), zone);
    }

    public List<Jury> getJurys() {
        return jurys;
    }

    public void setJurys(List<Jury> jurys) {
        this.jurys = jurys;
    }
    
    public void addJury(Jury jury){
        this.jurys.add(jury);
    }

    public List<Option> getSeries() {
        return series;
    }

    public void setSeries(List<Option> series) {
        this.series = series;
    }
    
    public void addSerie(Option option){
        this.series.add(option);
    }

    public Map<Long, Option> getSeriesMap() {
        return seriesMap;
    }

    public void setSeriesMap(Map<Long, Option> seriesMap) {
        this.seriesMap = seriesMap;
    }
    
    public void addSeriesMap(Option option){
        this.seriesMap.put(option.getId(), option);
    }
    
    public static Integer getQuantumCandidat() {
        return quantumCandidat;
    }

    public static void setQuantumCandidat(Integer quantumCandidat) {
        VilleComposition.quantumCandidat = quantumCandidat;
    }

    public static Integer getMargeErreurMin() {
        return VilleComposition.margeErreurMin;
    }

    public static void setMargeErreurMin(Integer margeErreurMin) {
        VilleComposition.margeErreurMin = margeErreurMin;
    }

    public static Integer getMargeErreurMax() {
        return VilleComposition.margeErreurMax;
    }

    public static void setMargeErreurMax(Integer margeErreurMax) {
        VilleComposition.margeErreurMax = margeErreurMax;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
    
    public void addZone(Zone zone){
        zone.setParentLocalite(this);
        this.zones.add(zone);
    }
    
    
    public void computeJuryNumber(){
        //if(this instance of )System.out.println(this.getNomLoclite()+" : zones size : "+this.getZones().size());
        Integer pe = this.effectif/VilleComposition.quantumCandidat;
        Integer modulo = this.effectif%VilleComposition.quantumCandidat;
        if(modulo >= VilleComposition.quantumCandidat - VilleComposition.margeErreurMin || (pe != 0 && modulo/pe + ((modulo%pe != 0)?1:0) + VilleComposition.quantumCandidat> VilleComposition.quantumCandidat + VilleComposition.margeErreurMax)){
            this.setNombreJury(pe+1);
        }else{
            this.setNombreJury(pe);
        }
    }
    
    /* public void computCentreCompoJuryNumber(){
        Integer nj = this.nombreJury;
        if(this.nombreJury > 0){
            Integer quantum = this.effectif/this.nombreJury;
            do{
                int index = 0;
                while(nj != 0 && index < this.getCentreCompositions().size()){
                    Centre centre = this.getCentreCompositions().get(index);
                    if(quantum*(centre.getNombreJury()+1) <= centre.getCapacite()){
                        centre.incrementNombreJury();
                        nj--;
                    }
                    index++;
                }
            }while(nj != 0);
        }
    } */
    
    
}
