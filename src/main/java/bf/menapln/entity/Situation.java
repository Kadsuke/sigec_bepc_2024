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
public class Situation extends Objet{
    private String situationLibelle;
   

    
    
    public Situation(){
        super();
    }

    public String getSituationLibelle() {
        return situationLibelle;
    }

    public void setSituationLibelle(String situationLibelle) {
        this.situationLibelle = situationLibelle;
    }
    
}