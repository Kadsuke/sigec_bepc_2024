/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.Menu;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Profil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coulibaly
 */
public class MenuRepository extends Repository implements InterfaceDAO{

    public MenuRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        Menu menu = (Menu)objet;
        String sql;
        sql = "INSERT INTO menu(menuParent_id,menuLibelle,action,icons) VALUES(?,?,?,?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        if(menu.getParent().getId() == null){
            pstmt.setObject(1, null);
        }else{
            pstmt.setLong(1, menu.getParent().getId());
        }
        pstmt.setString(2, menu.getMenuLibelle());
        pstmt.setString(3, menu.getAction());
        pstmt.setString(4, menu.getIcons());
        pstmt.executeUpdate();
        menu.setId(this.lastInsertedId());
        return menu;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM menu";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Menu menu = new Menu();
            menu.setId(rs.getLong("menu_id"));
            menu.setMenuLibelle(rs.getString("menuLibelle"));
            liste.add(menu);
        }
        return liste;
    }

    @Override
    public List<Objet> getByParentId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Objet getByProfil(Objet objet) throws SQLException {
        Profil profil = (Profil)objet;
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * from viewProfilMenu where profil_id = ?"; 
        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setLong(1, profil.getId());
        ResultSet resultSet    = pstmt.executeQuery();
       
        Map<Long, Menu> menuMap = new HashMap<>();
        while (resultSet.next()) {
            Long parentId = resultSet.getLong("parentId");
            Long menuId = resultSet.getLong("menu_id");
            // Créer le menu fils
            Menu menu = new Menu();
            menu.setId(menuId);
            menu.setMenuLibelle(resultSet.getString("menuLibelle"));
            menu.setAction(resultSet.getString("action"));
            System.out.println("Parent ="+parentId);
            if (parentId == 0) {
                System.out.println("Parent = 0 et libelle ="+menu.getMenuLibelle());
                // Le menu est une racine (n'a pas de parent)
               // menus.add(menu);
            } else {
            // Vérifier si le menu parent existe déjà dans la map
                if (menuMap.containsKey(parentId)) {
                    // Ajouter le menu fils au menu parent existant
                    menuMap.get(parentId).addSubMenu(menu);
                } else {
                    // Créer le menu parent et ajouter le menu fils
                    Menu parentMenu = new Menu();
                    parentMenu.setId(resultSet.getLong("parentId"));
                    parentMenu.setMenuLibelle(resultSet.getString("parentLibelle"));
                    parentMenu.setIcons(resultSet.getString("parentIcon"));
                    parentMenu.addSubMenu(menu);
                    // Ajouter le menu parent à la liste des menus
                    menus.add(parentMenu);

                    // Ajouter le menu parent à la map pour référence future
                    menuMap.put(parentId, parentMenu);
                }
            }
        }
        profil.setMenus(menus);
        return profil;
    }

    @Override
    public Long lastInsertedId() throws SQLException {
       String sql = "SELECT * FROM menu ORDER BY menu_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        Long id = null;
        while (rs.next()) {
           id = rs.getLong("menu_id");
        }
        return id;
    }
    
}
