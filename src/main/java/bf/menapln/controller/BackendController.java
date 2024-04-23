/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.SessionService;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author tiere
 */
public abstract class BackendController {
    
    //private Long session_id;
    public abstract void validate(HashMap<String,String> formData) throws EmptyDataException;
    
    
    
/*
    public void setSession_id(Long session_id) throws SQLException {
        SessionService sessionService = new SessionService();
        this.session_id = session_id;
    }

    public Long getSession_id(){
        return this.session_id;
    }*/
    
    public String alphaBet(int index){
        String[] tab = {"A","B","C","D","E","F","G","H","I","J"};
        return tab[index-1];
    }
    
    public String firstLetterUpper(String strt){
        String str = strt.trim();
        String text = "";
        
        if (str == null || str.length() == 0) {
            text = str;
        }else{
            if(str.length() == 1){
                text = str.toUpperCase();//str.substring(0, 1).toUpperCase() + str.substring(1);
            }else{
                String[] tab = str.split(" ");
                for(int i=0; i<tab.length; i++){
                    //System.out.println("######## "+str+" "+tab[i]);
                    if(!tab[i].isEmpty()){
                        text+=" "+tab[i].substring(0, 1).toUpperCase() + tab[i].substring(1);
                    }
                    
                }
            }
        }
        
        return text;
    }
}
