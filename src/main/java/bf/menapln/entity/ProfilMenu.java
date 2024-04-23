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
public class ProfilMenu extends Objet{
    private Profil profil;
    private Menu menu;

    public ProfilMenu() {
    }

   public ProfilMenu(Map data){   
        this.setProfil((Profil) data.get("profil"));
        this.setMenu((Menu) data.get("menu"));
    }
    
    public ProfilMenu(ResultSet rs) throws SQLException {
        
   //     this.setNatureHandicap(NatureHan rs.getString("natureHandicapLibelle"));
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    
    

    
    
}
