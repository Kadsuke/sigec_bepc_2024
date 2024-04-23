/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.entity.Pays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coulibaly
 */
public class CriterePosteRepository extends Repository implements InterfaceDAO{

    public CriterePosteRepository(Factory factory) {
        super(factory);
    }

    @Override
    public Objet save(Objet objet) throws SQLException {
        CriterePoste criterePoste = (CriterePoste)objet;
        String sql;
        sql = "INSERT INTO criterePosteJury(session_id,critere_id,critereTypeChamp,ponderationCritere,ordreCritere,poste_id,modalite_id) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
            pstmt.setLong(1, criterePoste.getSession().getId());
            pstmt.setLong(2, criterePoste.getCritere().getId());
            pstmt.setString(3, criterePoste.getTypeChamp());
            pstmt.setDouble(4, criterePoste.getPonderationCritere());
            pstmt.setLong(5, criterePoste.getOrdre());
            pstmt.setLong(6, criterePoste.getPoste().getId());
            pstmt.setLong(7, criterePoste.getModalite().getId());
            pstmt.executeUpdate();
        return criterePoste;
    }

    @Override
    public Objet delete(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Objet upadte(Objet objet) throws SQLException {
        CriterePoste criterePoste = (CriterePoste)objet;
        String sql = "UPDATE criterePosteJury SET ponderationModalite=?"
                + " WHERE session_id=? and critere_id=? and poste_id=? and modalite_id=?";

    try (PreparedStatement pstmt = this.factory.connect().prepareStatement(sql)) {
        pstmt.setDouble(1, criterePoste.getModalite().getPonderationModalite());
        pstmt.setLong(2, criterePoste.getSession().getId());
        pstmt.setLong(3, criterePoste.getCritere().getId());
        pstmt.setLong(4, criterePoste.getPoste().getId());
        pstmt.setLong(5, criterePoste.getModalite().getId());
        
     pstmt.executeUpdate();
    }

    return criterePoste;
 }

    @Override
    public List<Objet> getAll() throws SQLException {
        String sql = "SELECT * FROM viewCritereModalitePoste";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            CriterePoste criterePoste = new CriterePoste();
            criterePoste.setPoste(Type.id(rs.getLong("poste_id")));
            criterePoste.getPoste().setLibelle(rs.getString("posteLibelle"));
            criterePoste.setCritere(Critere.id(rs.getLong("critere_id")));
            criterePoste.getCritere().setCritereLibelle(rs.getString("critereLibelle"));
            criterePoste.getCritere().setTypeChamp(rs.getString("critereTypeChamp"));
            criterePoste.getCritere().setPonderationCritere(rs.getDouble("ponderationCritere"));
            criterePoste.setModalite(Modalite.id(rs.getLong("modalite_id")));
            criterePoste.getModalite().setModaliteLibelle(rs.getString("modaliteLibelle"));
            criterePoste.setPonderationModalite(rs.getDouble("ponderationModalite"));
            criterePoste.setOrdre(rs.getLong("ordreCritere"));
            liste.add(criterePoste);
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
    public Long lastInsertedId() throws SQLException {
        String sql = "SELECT * FROM modalite ORDER BY modalite_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("modalite_id");
        }
        return id;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   /* public Objet getAllByPoste(Type poste) throws SQLException {
        String sql = "SELECT * FROM viewCritereModalitePoste where poste_id = ?"; 
        PreparedStatement stmt  = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, poste.getId());
        ResultSet rs    = stmt.executeQuery();
        List<Objet> liste = new ArrayList<Objet>();
        Type type = null;
        Critere critere = null;
        while (rs.next()) {
            if(type == null){
                type = new Type();
                type.setId(rs.getLong("poste_id"));
                type.setLibelle(rs.getString("posteLibelle"));
            }
            if(critere == null){
                critere = new Critere();
                critere.setId(rs.getLong("critere_id"));
                critere.setCritereLibelle(rs.getString("critereLibelle"));
                critere.setTypeChamp(rs.getString("typeChamp"));
            }
            Modalite modalite  = Modalite.id(rs.getLong("modalite_id"));
            modalite.setModaliteLibelle(rs.getString("modaliteLibelle"));
            type.addCritere(critere);
            critere.addModalite(modalite);
        }
        return (type == null)?new Type():type;
    }*/
    
    public Objet getAllByPoste(Type poste) throws SQLException {
        String sql = "SELECT * FROM viewCritereModalitePoste where poste_id = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, poste.getId());
        ResultSet rs = stmt.executeQuery();

        Type type = null;
        Critere critere = null;

        while (rs.next()) {
            long typeId = rs.getLong("poste_id");
            if (type == null || type.getId() != typeId) {
                type = new Type();
                type.setId(typeId);
                type.setLibelle(rs.getString("posteLibelle"));
            }

            long critereId = rs.getLong("critere_id");
            if (critere == null || critere.getId() != critereId) {
                critere = new Critere();
                critere.setId(critereId);
                critere.setCritereLibelle(rs.getString("critereLibelle"));
                critere.setTypeChamp(rs.getString("critereTypeChamp"));
                critere.setPonderationCritere(rs.getDouble("ponderationCritere"));
                critere.setOrdreCritere(rs.getLong("ordreCritere"));
                type.addCritere(critere); // Associez le critère au type
            }

            Modalite modalite = new Modalite();
            modalite.setId(rs.getLong("modalite_id"));
            modalite.setModaliteLibelle(rs.getString("modaliteLibelle"));
            modalite.setPonderationModalite(rs.getDouble("ponderationModalite"));
            critere.addModalite(modalite); // Associez la modalité au critère
        }

            return (type == null) ? new Type() : type;
        }
    
    public Objet getAllByPosteAndCritere(Type poste,Critere crit) throws SQLException {
        String sql = "SELECT * FROM viewCritereModalitePoste where poste_id = ? and critere_id = ?";
        PreparedStatement stmt = this.factory.connect().prepareStatement(sql);
        stmt.setLong(1, poste.getId());
        stmt.setLong(2, crit.getId());
        ResultSet rs = stmt.executeQuery();

        Critere critere = null;

        while (rs.next()) {

            long critereId = rs.getLong("critere_id");
            if (critere == null || critere.getId() != critereId) {
                critere = new Critere();
                critere.setId(critereId);
                critere.setCritereLibelle(rs.getString("critereLibelle"));
                critere.setTypeChamp(rs.getString("critereTypeChamp"));
            }

            Modalite modalite = new Modalite();
            modalite.setId(rs.getLong("modalite_id"));
            modalite.setModaliteLibelle(rs.getString("modaliteLibelle"));
            modalite.setPonderationModalite(rs.getDouble("ponderationModalite"));
            critere.addModalite(modalite); // Associez la modalité au critère
        }

            return (critere == null) ? new Critere() : critere;
        }

 
}
