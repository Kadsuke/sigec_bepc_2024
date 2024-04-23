/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class Doublon {
    private List<String> key;
    private String entity1;
    private String entity2;
    
    public Doublon(){
        this.key = new ArrayList<String>();
    }
    public Doublon(List<String> key,String entity1,String entity2){
        super();
        this.key = key;
        this.entity1 = entity1;
        this.entity2 = entity2;
    }
    
    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public String getEntity1() {
        return entity1;
    }

    public void setEntity1(String entity1) {
        this.entity1 = entity1;
    }

    public String getEntity2() {
        return entity2;
    }

    public void setEntity2(String entity2) {
        this.entity2 = entity2;
    }
    
}
