/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiere
 */
public class DoublonOLD {
    private List<Long> key;
    private String entity1;
    private String entity2;
    
    public DoublonOLD(){
        this.key = new ArrayList<Long>();
    }
    public DoublonOLD(List<Long> key,String entity1,String entity2){
        super();
        this.key = key;
        this.entity1 = entity1;
        this.entity2 = entity2;
    }
    
    public List<Long> getKey() {
        return key;
    }

    public void setKey(List<Long> key) {
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
