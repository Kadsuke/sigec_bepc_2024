/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;

import java.sql.Connection;
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
public class MiseAJourRepository extends Repository implements InterfaceDAO{

    public MiseAJourRepository(Factory factory) {
        super(factory);
    }
    
    public boolean saveDirection() throws SQLException {
        boolean success = true;
        List<String> sqlList = new ArrayList<>();
        
        
        
        try (Connection connection = this.factory.connect()) {
        for (String sql : sqlList) {
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                // Gérer l'erreur
                e.printStackTrace();
                success = false; // Échec de l'exécution d'au moins une requête
            }
        }
    } catch (SQLException e) {
        // Gérer l'erreur de connexion
        e.printStackTrace();
        success = false; // Échec de la connexion à la base de données
    }

    return success;
}
    
    
    public boolean saveLocalite() throws SQLException {
        boolean success = true;
        List<String> sqlList = new ArrayList<>();
        //sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9265','Loc8865','4','5841','DARSALAMY')");
        //sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9266','Loc8866','4','7170','Sandogo de Sourgoubila')");
       // sqlList.add("DELETE FROM candidatPosteJury WHERE candidat_id = 1;");
        //sqlList.add("DELETE FROM candidatPosteJury WHERE candidat_id = 2;");
        
      /*  sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6041");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6042");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6043");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6044");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6045");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6046");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6047");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6048");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6049");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6050");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6051");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6052");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6053");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6054");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6055");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6056");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6057");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6058");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6059");
        sqlList.add("UPDATE structure set localite_id = 4239 WHERE structure_id = 6060");*/
      //  sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9267','Loc8867','5','9260','Zone 1')");

        
        
 
        /*sqlList.add("UPDATE structure set localite_id = 2234 WHERE structure_id = 840");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Zoula' WHERE structure_id = 6007");
        
        sqlList.add("UPDATE structure set nomStructure = 'COLLEGE LE PETIT MONDE' WHERE structure_id = 724");
        sqlList.add("UPDATE structure set nomStructure = 'COLLEGE PRIVE MARIE CURIE' WHERE structure_id = 643");
        sqlList.add("UPDATE structure set nomStructure = 'COLLEGE PRIVE WEND KUUNI DE SAKOULA' WHERE structure_id = 446");
        sqlList.add("UPDATE structure set nomStructure = 'LYCEE NABA PIIGA DE DAYONGO' WHERE structure_id = 744");
        sqlList.add("UPDATE structure set nomStructure = 'LYCEE PRIVE WENDVENEGDO' WHERE structure_id = 6396");
        sqlList.add("UPDATE structure set nomStructure = 'LYCEE PRIVE LES RACINES' WHERE structure_id = 1141");
        
        sqlList.add("UPDATE localite set nomLocalite = 'KOKOSSÉ TANDAGA' WHERE localite_id = 3129");
        sqlList.add("UPDATE localite set nomLocalite = 'Kaonghin' WHERE localite_id = 7135");
        sqlList.add("UPDATE localite set nomLocalite = 'Tollingui' WHERE localite_id = 7005");
        sqlList.add("UPDATE localite set parentLocalite = 4239 WHERE localite_id = 4303");*/
        try (Connection connection = this.factory.connect()) {
        for (String sql : sqlList) {
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                // Gérer l'erreur
                e.printStackTrace();
                success = false; // Échec de l'exécution d'au moins une requête
            }
        }
    } catch (SQLException e) {
        // Gérer l'erreur de connexion
        e.printStackTrace();
        success = false; // Échec de la connexion à la base de données
    }

    return success;
}
    
    public boolean saveEtablissement() throws SQLException {
        boolean success = true;
        List<String> sqlList = new ArrayList<>();
       /* sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6520',' ','1','22','2214','COLLEGE PRIVE FRANCO ARABE TU-SALAM','C P F A T S',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6521',' ','1','22','2214','LYCEE PRIVE WEND YAM DE DASSASGHO','L P W Y',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6522',' ','1','22','2214','COURS DU SOIR MERE THERESA',' C S M T',' ')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6520','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6521','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6522','2','1')");*/
    /*   sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6523',' ','1','22','2214','COURS DU SOIR FIMBA TRIOMPHE','C S F T',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6524',' ','1','22','2214','COURS DU SOIR ECOLE DEMOCRATIQUE DE TOUDOUDWEOGO','C S E D T',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6525',' ','1','22','2234','COLLEGE PRIVE RABSSIDA','C P R',' ')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6523','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6524','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6525','2','1')");
*/
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6541',' ','1','22','2298','CANDIDATS LIBRES DE PABRE','CL PABRE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6542',' ','1','22','2298','CANDIDATS LIBRES DE BIGTOGO','CL BIGTOGO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6543',' ','1','22','2298','CANDIDATS LIBRES DE GOUPANA','CL GOUPANA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6544',' ','1','22','2234','CANDIDATS LIBRES DE KALZI','CL KALZI',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6545',' ','1','22','2234','CANDIDATS LIBRES DE KIENFANGUE','CL KIENFANGUE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6546',' ','1','22','2271','CANDIDATS LIBRES DE GUIGUEMTENGA','CL GUIGEMTENGA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6547',' ','1','22','2271','CANDIDATS LIBRES DE DIDRI','CL DIDRI',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6548',' ','1','22','2346','CANDIDATS LIBRES DE LOUGSI','CL LOUGSI',' ')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6541','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6542','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6543','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6544','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6545','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6546','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6547','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6548','2','1')");

        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6549',' ','1','38','6365','CEG DE BOULMA','CEG BOULMA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6550',' ','1','38','6390','LYCEE DEPARMENTAL DE BAGARE','LD Bagaré',' ')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6549','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6550','1','1')");



        try (Connection connection = this.factory.connect()) {
                for (String sql : sqlList) {
                    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                        pstmt.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        success = false; // Échec de l'exécution d'au moins une requête
                    }
                }
            } catch (SQLException e) {
                // Gérer l'erreur de connexion
                e.printStackTrace();
                success = false; // Échec de la connexion à la base de données
            }

        return success;
} 
    
   public boolean updateDatabase() throws SQLException {
        boolean success = true;
        List<String> sqlList = new ArrayList<>();
        List<String> createSqlList = new ArrayList<>();
       // sqlList.add("delete from profilmenus where profil_id = 12 and menu_id= 30");
        //sqlList.add("delete from profilmenus where profil_id = 12 and menu_id= 31");
        //sqlList.add("delete from profilmenus where profil_id = 12 and menu_id= 32");
        //sqlList.add("delete from profilmenus where profil_id = 12 and menu_id= 1");
       // sqlList.add("delete from profilmenus where profil_id = 12 and menu_id= 2");
      // sqlList.add("ALTER TABLE choixCandidat ADD COLUMN numeroDossier integer;");
      //sqlList.add("ALTER TABLE epreuveCandidatPosteJury ADD COLUMN structure_id integer;");
       sqlList.add("ALTER TABLE inscription ADD COLUMN centre_id integer;");
       sqlList.add("ALTER TABLE inscription ADD COLUMN localite_id integer;");
       sqlList.add("UPDATE inscription SET centre_id = (SELECT centre_id FROM  centre WHERE inscription.centreExamen_id = centre.centre_identifiant);");
       sqlList.add("UPDATE inscription SET localite_id = (SELECT localite_id FROM  centre WHERE inscription.centreExamen_id = centre.centre_identifiant);");
       // sqlList.add("UPDATE choixCandidat SET numeroDossier = (SELECT numeroDossier FROM inscription WHERE inscription.candidat_id = choixCandidat.candidat_id);");
       //sqlList.add("UPDATE epreuveCandidatPosteJury SET structure_id = (SELECT structure_id FROM candidatPosteJury WHERE candidatPosteJury.candidat_id = epreuveCandidatPosteJury.candidat_id);");
        try (Connection connection = this.factory.connect()) {
                for (String sql : sqlList) {
                    try (PreparedStatement dropTableStmt = connection.prepareStatement(sql)) {
                        dropTableStmt.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        success = false; // Échec de l'exécution d'au moins une requête
                    }
                }
            } catch (SQLException e) {
                // Gérer l'erreur de connexion
                e.printStackTrace();
                success = false; // Échec de la connexion à la base de données
            }
          /*  createSqlList.add("CREATE TABLE IF NOT EXISTS centre (\n"
            + "	centre_identifiant integer,\n"
            + "	localite_id integer NOT NULL REFERENCES localite(localite_id),\n"
            + "	centre_id integer NOT NULL REFERENCES localite(localite_id),\n"
            + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
            + "	typeCentre_id integer NOT NULL REFERENCES typeCentre(typeCentre_id),\n"
            +"  UNIQUE(session_id,localite_id,centre_id,centre_identifiant),\n"
            + "	PRIMARY KEY(session_id,localite_id,centre_id,centre_identifiant),\n"
            + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
            + "	FOREIGN KEY(localite_id) REFERENCES localite(localite_id),\n"
            + "	FOREIGN KEY(centre_id) REFERENCES localite(localite_id),\n"
            + "	FOREIGN KEY(typeCentre_id) REFERENCES typeCentre(typeCentre_id)\n"
            + ");");*/
        
        // Recréer la table avec la nouvelle structure
        try (Connection connection = this.factory.connect()) {
                for (String sqlcreate : createSqlList) {
                    try (PreparedStatement createTableStmt = connection.prepareStatement(sqlcreate)) {
                        createTableStmt.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        success = false; // Échec de l'exécution d'au moins une requête
                    }
                }
            } catch (SQLException e) {
                // Gérer l'erreur de connexion
                e.printStackTrace();
                success = false; // Échec de la connexion à la base de données
            }
            return success;
    }
    
    
    @Override
    public Objet save(Objet objet) throws SQLException {
        Critere critere = (Critere)objet;
        String sql;
        sql = "INSERT INTO critere(critereLibelle) VALUES(?)";

        PreparedStatement pstmt = this.factory.connect().prepareStatement(sql);
        pstmt.setString(1, critere.getCritereLibelle());
        pstmt.executeUpdate();
        critere.setId(this.lastInsertedId());
        return critere;
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
        String sql = "SELECT * FROM critere";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        List<Objet> liste = new ArrayList<Objet>();
        while (rs.next()) {
            Critere critere = new Critere();
            critere.setId(rs.getLong("critere_id"));
            critere.setCritereLibelle(rs.getString("critereLibelle"));
            liste.add(critere);
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
        String sql = "SELECT * FROM critere ORDER BY critere_id DESC LIMIT 1";
        
        Statement stmt  = this.factory.connect().createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Long id = null;
        while (rs.next()) {
            id = rs.getLong("critere_id");
        }
        return id;
    }

    @Override
    public Objet getById(Objet objet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
