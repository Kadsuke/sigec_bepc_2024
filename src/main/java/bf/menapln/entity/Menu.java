/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.beans.property.BooleanProperty;

/**
 *
 * @author coulibaly
 */
public class Menu extends Objet{
    private String menuLibelle;
    private String action;
    private Menu parent;
    private Profil profil;
    private BooleanProperty selected;
    private List<Menu> subMenus;
    private String icons;

    
    public Menu(){
        super();
    }
    
    public Menu(Map data){
        this.setMenuLibelle((String) data.get("menuLibelle"));
        this.setAction((String) data.get("action"));
        this.setIcons((String) data.get("icons"));
        if (data.get("menuParent_id") == null) {
            this.setParent(new Menu());
        }else{
            this.setParent((Menu) data.get("menuParent_id"));
        } 
      //  this.setParent((data.get("menuParent_id") != null)?Menu.id(Long.parseLong((String) data.get("menuParent_id"))):new Menu());
    }
    
    public Menu(ResultSet rs) throws SQLException{
        this.setId(rs.getLong("menu_id"));
        this.setParent(Menu.id(rs.getLong("menuParent_id")));
        this.getParent().setMenuLibelle(rs.getString("menuParent_libelle"));
        this.setMenuLibelle(rs.getString("menuLibelle"));
        this.setAction(rs.getString("action"));
        this.setIcons(rs.getString("icons"));
    }
    
    
    
    public static Menu id(Long id){
        Menu m = new Menu();
        m.setId(id);
        return m;
    }

    public String getMenuLibelle() {
        return menuLibelle;
    }

    public void setMenuLibelle(String menuLibelle) {
        this.menuLibelle = menuLibelle;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    @Override
    public String toString() {
        return this.menuLibelle;
    }
     public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }
    
    public void addSubMenu(Menu subMenu){
     if (subMenus == null) {
            subMenus = new ArrayList<>();
        }
        this.subMenus.add(subMenu);
        // Assurez-vous de configurer les relations parent/enfant si nécessaire
        subMenu.setParent(this);
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
    
    
}
