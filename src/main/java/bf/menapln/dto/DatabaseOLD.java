/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kadsuke
 */
public class DatabaseOLD {
    private Factory factory;
    private Connection connexion;
    
    public DatabaseOLD(Factory factory) throws SQLException{
        this.factory = factory;
        this.connexion = this.factory.connect();
    }
    public void initDatabase() throws SQLException{
        this.createTableSession();
        this.createTableOffreEnseignement();
        this.createTableStatutEtablissement();
        this.createTableOption();
        this.createTableTypeCandidat();
        this.createTableTypeInscription();
        this.createTableTypeLocalite();
        this.createTableLocalite();
        this.createTableTypeStructure();
        this.createTableStructure();
        this.createTableGroupePedagogique();
        this.createTableEtablissement();
        this.createTableTypeHandicap();
        this.createTableNatureHandicap();
        this.createTablePrescription();
        this.createTablePrescriptionHandicap();
        this.createTablePays();
        this.createTableCentre();
        this.createTableCandidat();
        this.createTableInscription();
        this.createTableDispense();
        this.createTableJury();
        this.createTableTourComposition();
        this.createTableEtatJury();
        this.createTableCandidatJury();
        this.createTableConcoursRattache();
        this.createTableMenu();
        this.createTableProfil();
        this.createTableProfilMenus();
        this.createTableUser();
        this.createTableTypeEpreuve();
        this.createTableEpreuve();
        this.createTableEpreuveOptions();
        this.createTableSerie();
        this.createTableSerieConcours();
        this.createTableChoixCandidat();
        this.createTableCandidatPosteJury();
        this.createTableEpreuveCandidatPosteJury();
        this.createTablePersonnel();
        this.createTablePosteMembreJury();
        this.createTableMembreJury();
        this.createTableDisciplineCorrecteur();
        this.createTableTypeCentre();
        this.createTableTypeSituation();
        this.createTableModalite();
        this.createTableCritere();
        this.createTableCriterePoste();
        this.createTableCritereCandidatPosteJury();
        this.createTableResponsableStructure();
        this.createTableCentreComposition();
        this.createTableCentreJury();
        this.createViewRegion();
        this.createViewProvince();
        this.createViewCommune();
        this.createViewVillage();
        this.createViewVilleComposition();
        this.createViewSerieVilleComposition();
        this.createViewStructure();
        this.createViewEpreuveOption();
        this.createViewCentre();
        this.createViewJury();
        this.createViewCandidat();
        this.createViewCandidatJury();
        this.createViewCandidatPosteJury();
        this.createViewUser();
        this.createViewPrescriptionHandicap();
        this.createViewConcoursSerie();
        this.createViewCritereModalitePoste();
        this.createViewCentreExamen();
        this.createViewLocalite();     
     //   this.insertUser();
     //   this.insertMenu();
     //   this.insertMenuProfil();
        this.createViewProfilMenu();
        this.createViewCandidatsInscrits();
        this.createViewStatistiqueByEtab();
        this.createViewDistinctCandidatPosteJury();
        this.createViewStatistiqueActeurByEtab();
        this.createViewStatistiqueEtabByOption();
        this.createViewStatistiqueEtabBySituation();
        this.createViewStatistiqueEtabByHandicap();
        this.createViewStatistiqueByProvince();
        this.createViewStatistiqueActeurByProvince();
        this.createViewStatistiqueProvinceByOption();
        this.createViewStatistiqueProvinceBySituation();
        this.createViewStatistiqueProvinceByHandicap();
        this.createViewStatistiqueByRegion();
        this.createViewStatistiqueActeurByRegion();
        this.createViewStatistiqueRegionByOption();
        this.createViewStatistiqueRegionBySituation();
        this.createViewStatistiqueRegionByHandicap();
        this.createViewCreationCentreComposition();
        this.createViewCentreComposition();
        this.createViewAffectationCandidatJury();
        this.createViewAffectationMembreJury();
        this.createViewCritereCandidatPosteJury();
        
    }
    

    /**
     * Parametre
     * 
     */
    public void createTableSession() throws SQLException{
        
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS session (\n"
                + "	session_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	annee text NOT NULL,\n"
                + "	dateDebutSessionRemplacement text NOT NULL,\n"
                + "	dateFinSessionRemplacement text NOT NULL,\n"
                + "	dateDebutSessionNormale text NOT NULL,\n"
                + "	dateFinSessionNormale text NOT NULL,\n"
                + "	dateDebutInscription text NOT NULL,\n"
                + "	dateFinInscription text NOT NULL,\n"
                + "	moyAdmission real NOT NULL,\n"
                + "	moyRachat real NOT NULL,\n"
                + "	moyAdmissible real NOT NULL,\n"
                + "	statutSession text NOT NULL DEFAULT false\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    //Offre d'enseignement
    
    public void createTableOffreEnseignement() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS offreEnseignement (\n"
                + "	offreEnseignement_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	offreEnseignementLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableStatutEtablissement() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS statutEtablissement (\n"
                + "	statut_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	statutEtablissementLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    

 //Concours rattaché
    
    public void createTableConcoursRattache() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS concoursRattache (\n"
                + "	concoursRattache_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	concoursRattacheLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    

    public void createTableOption() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS option (\n"
                + "	option_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	optionLibelle text NOT NULL, \n"
                + "	optionDefinition text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableSerie() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS serie (\n"
                + "	serie_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	serieLibelle text NOT NULL \n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableSerieConcours() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS concoursSerie (\n"
                + "	serie_id integer NOT NULL REFERENCES serie(serie_id),\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	concoursRattache_id integer NOT NULL REFERENCES concoursRattache(concoursRattache_id),\n"
                + "     PRIMARY KEY(session_id,serie_id,concoursRattache_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }


    public void createTableTypeCandidat() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeCandidat (\n"
                + "	typeCandidat_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeCandidatLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    
    public void createTableTypeInscription() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeInscription (\n"
                + "	typeInscription_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeInscriptionLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableTypeLocalite() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeLocalite (\n"
                + "	typeLocalite_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeLocaliteLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableLocalite() throws SQLException{
        String sql1 = "DROP TABLE IF EXISTS localite;";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS localite (\n"
                + "	localite_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	codeLocalite text,\n"
                + "	typeLocalite_id integer NOT NULL REFERENCES typeLocalite(typeLocalite_id),\n"
                + "	parentLocalite integer REFERENCES localite(localite_id),\n"
                + "	nomLocalite text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableTypeStructure() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeStructure (\n"
                + "	typeStructure_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeStructureLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableStructure() throws SQLException{
        String sql1 = "DROP TABLE IF EXISTS structure;";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS structure (\n"
                + "	structure_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	codeStructure text,\n"
                + "	typeStructure_id integer NOT NULL REFERENCES typeStructure(typeStructure_id),\n"
                + "	parent_id integer REFERENCES structure(structure_id),\n"
                + "	localite_id integer NOT NULL REFERENCES localite(localite_id),\n"
                + "	nomStructure text NOT NULL,\n"
                + "	acronymeStructure text,\n"
                + "	capaciteEtablissement text\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    
    public void createTableGroupePedagogique() throws SQLException{
        
        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS groupePedagogique (\n"
                + "	groupePedagogique_id integer,\n"
                + "	groupePedagogiqueLibelle text,\n"
                + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	PRIMARY KEY(session_id,etablissement_id,groupePedagogique_id),\n"
                + "	UNIQUE(session_id,etablissement_id,groupePedagogiqueLibelle)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableEtablissement() throws SQLException{
        
        // SQL statement for creating a new table
        String sql1 = "DROP TABLE IF EXISTS etablissement;";

        String sql = "CREATE TABLE IF NOT EXISTS etablissement (\n"
                + "	etablissement_id integer NOT NULL REFERENCES structure(structure_id),\n"
                + "	statut_id integer NOT NULL REFERENCES statutEtablissement(statut_id),\n"
                + "	offreEnseignement_id integer NOT NULL REFERENCES offreEnseignement(offreEnseignement_id),\n"
                + "	PRIMARY KEY(etablissement_id)\n"
                + ");";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableTypeCentre() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeCentre (\n"
                + "	typeCentre_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeCentreLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableTypeSituation() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeSituation (\n"
                + "	typeSituation_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeSituationLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableCentre() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS centre (\n"
                + "	centre_identifiant integer,\n"
                + "	localite_id integer NOT NULL REFERENCES localite(localite_id),\n"
                + "	centre_id integer NOT NULL REFERENCES localite(localite_id),\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	typeCentre_id integer NOT NULL REFERENCES typeCentre(typeCentre_id),\n"
                +"      UNIQUE(session_id,localite_id,centre_id,centre_identifiant),\n"
                + "	PRIMARY KEY(session_id,localite_id,centre_id,centre_identifiant),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
                + "	FOREIGN KEY(localite_id) REFERENCES localite(localite_id),\n"
                + "	FOREIGN KEY(centre_id) REFERENCES localite(localite_id),\n"
                + "	FOREIGN KEY(typeCentre_id) REFERENCES typeCentre(typeCentre_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableTypeHandicap() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeHandicap (\n"
                + "	typeHandicap_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeHandicapLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableNatureHandicap() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS natureHandicap (\n"
                + "	natureHandicap_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	typeHandicap_id integer NOT NULL REFERENCES typeHandicap(typeHandicap_id),\n"
                + "	natureHandicapLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTablePrescription() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS prescription (\n"
                + "	prescription_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	prescriptionLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTablePrescriptionHandicap() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS prescriptionHandicap (\n"
                + "	natureHandicap_id integer NOT NULL REFERENCES natureHandicap(natureHandicap_id),\n"
                + "	prescription_id integer NOT NULL REFERENCES prescription(prescription_id),\n"
                + "	PRIMARY KEY(natureHandicap_id,prescription_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTablePays() throws SQLException{
        String sql1 = "DROP TABLE IF EXISTS pays;";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pays (\n"
                + "	pays_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	indicatif text NOT NULL,\n"
                + "	nomPays text NOT NULL,\n"
                + "	nationalite text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableTourComposition() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tourComposition (\n"
                + "	tourComposition_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	tourCode integer UNIQUE NOT NULL,\n"
                + "	tourCompositionLibelle text UNIQUE NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void insertTourComposition() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "INSERT INTO tourComposition(tourComposition_id,tourCompositionLibelle)\n"
                + "	values(1,1,'1er tour'),(2,2,'2e tour')\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableEtatJury() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS etatJury (\n"
                + "	session_id integer NOT NULL,\n"
                + "	jury_id integer NOT NULL,\n"
                + "	tourComposition_id integer NOT NULL,\n"
                + "	actif text NOT NULL,\n"
                + "	valide text NOT NULL,\n"
                + "	PRIMARY KEY(session_id,jury_id,tourComposition_id),\n"
                + "	CONSTRAINT fk_juryEtat FOREIGN KEY(jury_id) REFERENCES jury(jury_id),\n"
                + "	CONSTRAINT fk_tourEtat FOREIGN KEY(tourComposition_id) REFERENCES tourComposition(tourComposition_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableTypeEpreuve() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS typeEpreuve (\n"
                + "	typeEpreuve_id integer PRIMARY KEY,\n"
                + "	typeEpreuveLibelle text UNIQUE NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableEpreuve() throws SQLException{
        
        // SQL statement for creating a new tabl
        String sql1 = "DROP TABLE IF EXISTS epreuve;";
        String sql = "CREATE TABLE IF NOT EXISTS epreuve (\n"
                + "	epreuve_id integer PRIMARY KEY,\n"
                + "	parent_id integer REFERENCES epreuve(epreuve_id),\n"
                + "	epreuveLibelle text UNIQUE NOT NULL,\n"
                + "	epreuveAcronyme text\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableEpreuveOptions() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS epreuveOption (\n"
                + "	epreuve_id integer NOT NULL REFERENCES epreuve(epreuve_id),\n"
                + "	option_id integer NOT NULL REFERENCES option(option_id),\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	typeEpreuve_id integer NOT NULL REFERENCES typeEpreuve(typeEpreuve_id),\n"
                + "	coefficient integer NOT NULL,\n"
                + "	ordreEpreuve integer NOT NULL ,\n"
                + "	duree text NOT NULL,\n"
                + "	estComposeSecTour text NOT NULL DEFAULT 'false',\n"
                + "	estRachetable text NOT NULL DEFAULT 'false',\n"
                + "	estComposePreTour text NOT NULL DEFAULT 'false',\n"
                + "	PRIMARY KEY(session_id,option_id,epreuve_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    
    public void createTableMenu() throws SQLException{
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS menu (\n"
                + "	menu_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	menuParent_id integer,\n"
                + "	menuLibelle text UNIQUE NOT NULL,\n"
                + "	action text ,\n"
                + "	icons text ,\n"
                + "	FOREIGN KEY(menuParent_id) REFERENCES menu(menu_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableProfil() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS profil (\n"
                + "	profil_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	profilLibelle text UNIQUE NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableProfilMenus() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS profilMenus (\n"
                + "	profil_id integer NOT NULL,\n"
                + "	menu_id integer NOT NULL,\n"
                + "	PRIMARY KEY(profil_id,menu_id),\n"
                + "	CONSTRAINT fk_prolil_pm FOREIGN KEY(profil_id) REFERENCES profil(profil_id),\n"
                + "	CONSTRAINT fk_menu_pm FOREIGN KEY(menu_id) REFERENCES menu(menu_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableUser() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "	user_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	profil_id integer NOT NULL,\n"
                + "	structure_id integer,\n"
                + "	personnel_id integer,\n"
                + "	username text NOT NULL UNIQUE,\n"
                + "	pwd text NOT NULL,\n"
                + "	statut text NOT NULL DEFAULT 'false',\n"
                + "	FOREIGN KEY(structure_id) REFERENCES structure(structure_id),\n"
                + "	CONSTRAINT fk_prolil_user FOREIGN KEY(profil_id) REFERENCES profil(profil_id),\n"
                + "	CONSTRAINT fk_personnel_user FOREIGN KEY(personnel_id) REFERENCES personnel(personnel_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    
    public void createTableModalite() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS modalite (\n"
                + "	modalite_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	modaliteLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableCritere() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS critere (\n"
                + "	critere_id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	critereLibelle text NOT NULL\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableCriterePoste() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS criterePosteJury (\n"
                + "	session_id integer NOT NULL,\n"
                + "	critere_id integer NOT NULL,\n"
                + "	critereTypeChamp text NOT NULL,\n"
                + "	ponderationCritere double NOT NULL,\n"
                + "	poste_id integer NOT NULL,\n"
                + "	modalite_id integer NOT NULL,\n"
                + "	ponderationModalite double,\n"
                + "	ordreCritere integer ,\n"
                + "	poids double, \n"
                + "	PRIMARY KEY(session_id,critere_id,poste_id,modalite_id),\n"
                + "	FOREIGN KEY(poste_id) REFERENCES posteMembreJury(poste_id),\n"
                + "	FOREIGN KEY(critere_id) REFERENCES critere(critere_id),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
                + "	FOREIGN KEY(modalite_id) REFERENCES modalite(modalite_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableCritereCandidatPosteJury() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS critereCandidatPosteJury (\n"
                + "	candidat_id integer NOT NULL,\n"
                + "	session_id integer NOT NULL,\n"
                + "	critere_id integer ,\n"
                + "	poste_id integer ,\n"
                + "	structure_id integer ,\n"
                + "	modalite_id integer ,\n"
                + "	PRIMARY KEY(candidat_id,structure_id,session_id,critere_id,poste_id,modalite_id),\n"
                + "	FOREIGN KEY(session_id,critere_id,poste_id,modalite_id) REFERENCES criterePosteJury(session_id,critere_id,poste_id,modalite_id),\n"
                + "	FOREIGN KEY(candidat_id,structure_id) REFERENCES candidatPosteJury(candidat_id,structure_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    /***
     * Inscription
     * 
     */
    public void createTableChoixCandidat() throws SQLException{
    
    // SQL statement for creating a new table
    String sql = "CREATE TABLE IF NOT EXISTS choixCandidat (\n"
    + "	serie_id integer NOT NULL REFERENCES serie(serie_id),\n"
    + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
    + "	choixEtablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"            
    + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
    + "	candidat_id integer NOT NULL REFERENCES candidat(candidat_id),\n"
    + "	numeroDossier integer NOT NULL REFERENCES candidat(numeroDossier),\n"
    + "	ordre integer,\n"
    + "	FOREIGN KEY(session_id,etablissement_id,candidat_id,numeroDossier) REFERENCES inscription(session_id,etablissement_id,candidat_id,numeroDossier)\n"
    + ");";
    
    Statement stmt = this.connexion.createStatement();
    stmt.execute(sql);
}

public void createTableCandidat() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS candidat (\n"
                + "	candidat_id integer,\n"
                + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "     numeroDossier integer NOT NULL,\n"
                + "	iue text UNIQUE,\n"
                + "	paysNaissance_id integer NOT NULL REFERENCES pays(pays_id),\n"
                + "	paysNationalite_id integer NOT NULL REFERENCES pays(pays_id),\n"
                + "	nom text NOT NULL,\n"
                + "	prenom text NOT NULL,\n"
                + "	nomPere text NOT NULL,\n"
                + "	prenomPere text NOT NULL,\n"
                + "	nomMere text NOT NULL,\n"
                + "	prenomMere text NOT NULL,\n"
                + "	sexe text NOT NULL,\n"
                + "	dateNaissance text NOT NULL,\n"
                + "	typeDateNaissance text NOT NULL DEFAULT 'le',\n"
                + "	numeroActeNaissance text,\n"
                + "	lieuNaissance text NOT NULL,\n"
                + "	lienActeNaissance text,\n"
                + "	lienPhoto text,\n"
                + "	UNIQUE (session_id,candidat_id,etablissement_id,numeroDossier),\n"
                + "	PRIMARY KEY(session_id,etablissement_id,candidat_id,numeroDossier)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableInscription() throws SQLException{
        
        // SQL statement for creating a new table
        String sql1 = "DROP TABLE IF EXISTS inscription;";
        String sql =
                "       CREATE TABLE IF NOT EXISTS inscription (\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	candidat_id integer NOT NULL,\n"
                +"  numeroDossier integer NOT NULL ,\n"
                + "	etablissement_id integer NOT NULL ,\n"
                + "	groupePedagogique_id integer NOT NULL,\n"
                + "	typeCandidat_id integer NOT NULL REFERENCES typeCandidat(typeCandidat_id),\n"
                + "	typeSituation_id integer NOT NULL REFERENCES typeSituation(typeSituation_id),\n"
                + "	option_id integer NOT NULL REFERENCES option(option_id),\n"
                + "	typeInscription_id integer NOT NULL REFERENCES typeInscription(typeInscription_id),\n"
                + "	natureHandicap_id integer REFERENCES natureHandicap(natureHandicap_id),\n"
                + "	prescription_id integer REFERENCES prescription(prescription_id),\n"
                + "	numeroPV integer,\n"
                + "	telephone text,\n"
                + "	telephoneDeux text,\n"
                + "	sport text NOT NULL DEFAULT 'Apte',\n"
                + "	dernierDiplome text NOT NULL DEFAULT 'CEP/EQUIVALENT',\n"
                + "	anneeDernierDiplome integer NOT NULL,\n"
                + "	statutCandidature text NOT NULL DEFAULT 'false',\n"
                + "	motifRejetCandidature text,\n"
                + "	composeSessionRemplacement text NOT NULL DEFAULT 'false',\n"
                + "	dateInscription text NOT NULL,\n"
                + "	concoursRattache integer NOT NULL REFERENCES concoursRattache(concoursRattache_id),\n"
                + "	centreExamen_id integer NOT NULL REFERENCES centre(centre_id),\n"
                + "	zone_id integer NOT NULL REFERENCES localite(localite_id),\n"
                + "	UNIQUE (session_id,etablissement_id,candidat_id,numeroDossier),\n"
                + "	PRIMARY KEY(session_id,etablissement_id,candidat_id,numeroDossier),\n"
                + "	FOREIGN KEY(session_id,candidat_id,etablissement_id,numeroDossier) REFERENCES candidat(session_id,candidat_id,etablissement_id,numeroDossier),\n"
                + "	FOREIGN KEY(session_id,etablissement_id,groupePedagogique_id) REFERENCES groupePedagogique(session_id,etablissement_id,groupePedagogique_id),\n"
                + "	FOREIGN KEY(natureHandicap_id,prescription_id) REFERENCES prescriptionHandicap(natureHandicap_id,prescription_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableDispense() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS dispense (\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	candidat_id integer NOT NULL REFERENCES candidat(candidat_id),\n"
                + "	etablissement_id integer NOT NULL REFERENCES etablissement(structure_id),\n"
                + "     numeroDossier integer NOT NULL,\n"
                + "	epreuve_id integer NOT NULL,\n"
                + "	UNIQUE (session_id,etablissement_id,candidat_id,epreuve_id,numeroDossier),\n"
                + "	PRIMARY KEY(session_id,etablissement_id,candidat_id,epreuve_id,numeroDossier),\n"
                + "	FOREIGN KEY(epreuve_id) REFERENCES epreuve(epreuve_id),\n"
                + "	FOREIGN KEY(session_id,candidat_id,etablissement_id,numeroDossier) REFERENCES inscription(session_id,candidat_id,etablissement_id,numeroDossier)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableCandidatPosteJury() throws SQLException{
        
        // SQL statement for creating a new table
      // String sql1 = "DROP TABLE IF EXISTS candidatPosteJury;";
        String sql = "CREATE TABLE IF NOT EXISTS candidatPosteJury (\n"
                + "	candidat_id integer,\n"
                + "	session_id integer NOT NULL,\n"
                + "	localiteCandidat_id integer NOT NULL,\n"
                + "	structure_id text,\n"
                + "	poste_id integer NOT NULL,\n"
                + "	nom text NOT NULL,\n"
                + "	prenom text NOT NULL,\n"
                + "	sexe text NOT NULL,\n"
                + "	telephone text NOT NULL,\n"
                + "	matricule text UNIQUE,\n"
                + "	nip text UNIQUE,\n"
                + "	etatCandidature text NOT NULL DEFAULT 'En attente',\n"
                + "	totalPondere integer,\n"
                +"      UNIQUE(session_id,candidat_id,matricule,structure_id),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
                + "	FOREIGN KEY(localiteCandidat_id) REFERENCES localite(localite_id),\n"
                + "	FOREIGN KEY(structure_id) REFERENCES structure(structure_id),\n"
                + "	FOREIGN KEY(poste_id) REFERENCES posteMembreJury(poste_id)\n"
                + ");";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableEpreuveCandidatPosteJury() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS epreuveCandidatPosteJury (\n"
                + "	candidat_id integer NOT NULL,\n"
                + "	epreuve_id integer NOT NULL,\n"
                + "	option_id integer NOT NULL,\n"
                + "	structure_id integer ,\n"
                + "	PRIMARY KEY(candidat_id,structure_id,epreuve_id,option_id),\n"
                + "	FOREIGN KEY(candidat_id,structure_id) REFERENCES candidatPosteJury(candidat_id,structure_id),\n"
                + "	FOREIGN KEY(epreuve_id) REFERENCES epreuve(epreuve_id),\n"
                + "	FOREIGN KEY(option_id) REFERENCES option(option_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

/***
 * Organisation
 * 
 */

 public void createTableCentreComposition() throws SQLException{
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS centreComposition (\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
                + "	capacite integer NOT NULL,\n"
                + "	zone_id integer NULL REFERENCES zone(zone_id),\n"
                + "	primary key(session_id,etablissement_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

public void createTableJury() throws SQLException{
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS jury (\n"
                + "	jury_id integer,\n"
                + "	session_id integer NOT NULL,\n"
                + "	centreExamen_id integer REFERENCES centre(centre_id),\n"
                + "	juryLibelle text NOT NULL,\n"
                + "	juryCapacite integer NOT NULL,\n"
                + "	juryEtat text NOT NULL DEFAULT 'inactif',\n"
                + "	UNIQUE(session_id,centreExamen_id,juryLibelle),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id)\n"
                + "	PRIMARY KEY(session_id,centreExamen_id,jury_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createTableCentreJury() throws SQLException{ 
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS centreJury (\n"
                + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
                + "	centre_id integer NOT NULL REFERENCES centre(centre_id),\n"
                + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
                + "	jury_id integer NOT NULL REFERENCES jury(jury_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableCandidatJury() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS candidatJury (\n"
                + "	session_id integer NOT NULL,\n"
                + "	jury_id integer NOT NULL,\n"                
                + "	centreExamen_id integer NOT NULL,\n"
                + "	candidat_id integer NOT NULL,\n"
                + "     numeroDossier integer NOT NULL,\n"                
                + "	etablissement_id integer NOT NULL,\n"
                + "	PRIMARY KEY(session_id,jury_id,centreExamen_id,candidat_id,numeroDossier,etablissement_id),\n"
                + "	UNIQUE(session_id,candidat_id,numeroDossier,etablissement_id),\n"
                + "	FOREIGN KEY(session_id,centreExamen_id,jury_id) REFERENCES jury(session_id,centreExamen_id,jury_id),\n"
                + "	FOREIGN KEY(session_id,candidat_id,etablissement_id,numeroDossier) REFERENCES inscription(session_id,candidat_id,etablissement_id,numeroDossier)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTablePersonnel() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS personnel (\n"
                + "	personnel_id integer PRIMARY KEY,\n"
                + "	nom text NOT NULL,\n"
                + "	prenom text NOT NULL,\n"
                + "	sexe text NOT NULL,\n"
                + "	telephone text NOT NULL,\n"
                + "	matricule text UNIQUE,\n"
                + "	nip text UNIQUE\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTablePosteMembreJury() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS posteMembreJury (\n"
                + "	poste_id integer PRIMARY KEY,\n"
                + "	posteLibelle text NOT NULL UNIQUE\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableMembreJury() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS membreJury (\n"
                + "	poste_id integer NOT NULL,\n"
                + "	jury_id integer NOT NULL,\n"
                + "	centreExamen_id integer NOT NULL,\n"
                + "	session_id integer NOT NULL,\n"
                + "	personnel_id integer NOT NULL,\n"
                + "	membreDeliberant text NOT NULL DEFAULT 1,\n"
                + "	PRIMARY KEY(session_id,jury_id,personnel_id),\n"
                + "	FOREIGN KEY(poste_id) REFERENCES posteMembreJury(poste_id),\n"
                + "	FOREIGN KEY(jury_id) REFERENCES jury(jury_id),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
                + "	FOREIGN KEY(personnel_id) REFERENCES personnel(personnel_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableDisciplineCorrecteur() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS disciplineCorrecteur (\n"
                + "	session_id integer NOT NULL,\n"
                + "	personnel_id integer NOT NULL,\n"
                + "	epreuve_id text NOT NULL,\n"
                + "	option_id text NOT NULL,\n"
                + "	PRIMARY KEY(session_id,personnel_id,epreuve_id,option_id),\n"
                + "	FOREIGN KEY(session_id,option_id,epreuve_id) REFERENCES epreuveOption(session_id,option_id,epreuve_id),\n"
                + "	FOREIGN KEY(personnel_id) REFERENCES personnel(personnel_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createTableResponsableStructure() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS responsableStructure (\n"
                + "	session_id integer,\n"
                + "	personnel_id integer,\n"
                + "	structure_id integer,\n"
                + "	titre text,\n"
                + "	fonction text,\n"
                + "	FOREIGN KEY(personnel_id) REFERENCES personnel(personnel_id),\n"
                + "	FOREIGN KEY(structure_id) REFERENCES structure(structure_id)\n"
                + ");";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }


/***
 * VUE DE DONNEE
 * 
 */
public void createViewAffectationMembreJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewAffectationMembreJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewAffectationMembreJury AS\n"
                + "	SELECT sess.*,vcpj.*,mj.*,j.*,centreCompo.*\n"
                + "	FROM viewCandidatPosteJury vcpj\n"
                + "	LEFT JOIN personnel p ON p.personnel_id = vcpj.nip\n"
                + "	LEFT JOIN membreJury mj ON mj.personnel_id = p.personnel_id\n"
                + "	LEFT JOIN jury j ON j.jury_id = mj.jury_id AND j.centreExamen_id=mj.centreExamen_id\n"
                + "	LEFT JOIN centre centreCompo ON centreCompo.centre_identifiant = j.centreExamen_id\n"           
                + "	INNER JOIN session sess ON sess.session_id = vcpj.session_id\n"  
                + "	WHERE sess.statutSession=1\n"
                + ";"; 
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    public void createViewRegion() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS region AS\n"
                + "	SELECT l.localite_id, l.codeLocalite, l.nomLocalite\n"
                + "	FROM localite l\n"
                + "	INNER JOIN typeLocalite t ON t.typeLocalite_id = l.typeLocalite_id\n"
                + "	WHERE t.typeLocaliteLibelle = 'Région'\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewProvince() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS province AS\n"
                + "	SELECT t.typeLocalite_id,t.typeLocaliteLibelle,\n"
                + "     p.localite_id as parent_id, p.codeLocalite as parentCode, p.nomLocalite as parentLibelle,\n"
                + "     l.localite_id, l.codeLocalite, l.nomLocalite\n"
                + "	FROM localite l\n"
                + "	INNER JOIN typeLocalite t ON t.typeLocalite_id = l.typeLocalite_id\n"
                + "	INNER JOIN localite p ON p.localite_id = l.parentLocalite\n"
                + "	WHERE t.typeLocaliteLibelle = 'Province'\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewCommune() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS commune AS\n"
                + "	SELECT t.typeLocalite_id,t.typeLocaliteLibelle,\n"
                + "     p.localite_id as parent_id, p.codeLocalite as parentCode, p.nomLocalite as parentLibelle,\n"
                + "     l.localite_id, l.codeLocalite, l.nomLocalite\n"
                + "	FROM localite l\n"
                + "	INNER JOIN typeLocalite t ON t.typeLocalite_id = l.typeLocalite_id\n"
                + "	INNER JOIN localite p ON p.localite_id = l.parentLocalite\n"
                + "	WHERE t.typeLocaliteLibelle = 'Commune'\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewVillage() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS village AS\n"
                + "	SELECT t.typeLocalite_id,t.typeLocaliteLibelle,\n"
                + "     p.localite_id as parent_id, p.codeLocalite as parentCode, p.nomLocalite as parentLibelle,\n"
                + "     l.localite_id, l.codeLocalite, l.nomLocalite\n"
                + "	FROM localite l\n"
                + "	INNER JOIN typeLocalite t ON t.typeLocalite_id = l.typeLocalite_id\n"
                + "	INNER JOIN localite p ON p.localite_id = l.parentLocalite\n"
                + "	WHERE t.typeLocaliteLibelle = 'Secteur/village'\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    public void createViewVilleComposition() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS villeComposition;");*/
        String sql = "CREATE VIEW IF NOT EXISTS villeComposition AS\n"
                + "	SELECT distinct t.typeLocalite_id,t.typeLocaliteLibelle,\n"
                + "     p.localite_id as parent_id, p.codeLocalite as parentCode, p.nomLocalite as parentLibelle,\n"
                + "     l.localite_id, l.codeLocalite, l.nomLocalite,s.*\n"
                + "	FROM localite l\n"
                + "	INNER JOIN typeLocalite t ON t.typeLocalite_id = l.typeLocalite_id\n"
                + "	INNER JOIN localite p ON p.localite_id = l.parentLocalite\n"
                + "	INNER JOIN inscription i ON i.villeComposition = l.localite_id\n"
                + "	INNER JOIN session s ON s.session_id = i.session_id\n"
                + "	WHERE t.typeLocaliteLibelle = 'Commune'\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewSerieVilleComposition() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS serieVilleComposition;");*/
        String sql = "CREATE VIEW IF NOT EXISTS serieVilleComposition AS\n"
                + "	SELECT distinct s.*,vp.*,s.*\n"
                + "	FROM serie s\n"
                + "	INNER JOIN inscription i ON i.serie_id = s.serie_id\n"
                + "	INNER JOIN localite vp ON vp.localite_id = i.villeComposition\n"
                + "	INNER JOIN session s ON s.session_id = i.session_id\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createViewAffectationCandidatJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewAffectationCandidatJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewAffectationCandidatJury AS\n"
                + "	SELECT c.*,i.*,sess.*,option.*,centreExa.*,str.*,j.*,local.*,\n"
                +"commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
                "provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
                "prescH.prescription_id as presci_id,prescH.prescriptionLibelle as presci_libelle,\n" +
                "natureH.natureHandicap_id as natureH_id,natureH.natureHandicapLibelle as natureH_libelle,\n" +
                "typeH.typeHandicap_id as typeH_id,typeH.typeHandicapLibelle as typeH_libelle,\n" +
                "regio.localite_id as region_id,regio.nomLocalite as nom_region\n" +
                 " FROM candidat c\n"
                + " INNER JOIN inscription i ON i.candidat_id = c.candidat_id AND i.etablissement_id=c.etablissement_id AND i.numeroDossier = c.numeroDossier\n"
                
                + " INNER JOIN structure str ON str.structure_id = i.etablissement_id\n"
                + " INNER JOIN session sess ON sess.session_id = i.session_id\n"
                + " INNER JOIN option ON option.option_id = i.option_id\n"
                + " LEFT JOIN candidatJury cj ON cj.candidat_id = c.candidat_id AND cj.etablissement_id=c.etablissement_id and cj.numeroDossier = c.numeroDossier\n"
                + " LEFT JOIN centre centreExa ON centreExa.centre_identifiant = i.centreExamen_id\n"
                +"LEFT JOIN localite commu ON commu.localite_id = centreExa.localite_id\n" +
                "LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
                "LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
                "  Left join localite local on local.localite_id = centreExa.centre_id\n"+
                "LEFT JOIN prescription prescH ON prescH.prescription_id = i.prescription_id\n" +
                "LEFT JOIN natureHandicap natureH ON natureH.natureHandicap_id = i.natureHandicap_id\n" +
                "LEFT JOIN typeHandicap typeH ON typeH.typeHandicap_id = natureH.typeHandicap_id\n"
                + " LEFT JOIN jury j ON j.jury_id = cj.jury_id AND j.centreExamen_id=cj.centreExamen_id\n"
                + " WHERE sess.statutSession=1\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewStructure() throws SQLException{
         String sql = " CREATE VIEW IF NOT EXISTS viewStructure AS\n"
	 + "SELECT s.*,ts.*,p.*,e.*,statut.*,o.*,\n"
         + "commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n"
         + "provi.localite_id as province_id,provi.nomLocalite as nom_province,\n"
         + "regio.localite_id as region_id,regio.nomLocalite as nom_region\n"
	 + "FROM structure s\n"
	 + "INNER JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id\n"
	 + "LEFT JOIN structure p ON p.structure_id = s.parent_id\n"
	 + "INNER JOIN localite commu ON commu.localite_id = s.localite_id\n"
	 + "LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n"
	 + "LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n"
	 + "LEFT JOIN etablissement e ON e.etablissement_id = s.structure_id\n"
	 + "LEFT JOIN statutEtablissement statut ON statut.statut_id = e.statut_id\n"
	 + "LEFT JOIN offreEnseignement o ON o.offreEnseignement_id = e.offreEnseignement_id\n"
         + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewEpreuveOption() throws SQLException{
    //    Statement stmtt = this.connexion.createStatement();
//        stmtt.execute("DROP VIEW IF EXISTS viewEpreuveOption;");
        String sql = "CREATE VIEW IF NOT EXISTS viewEpreuveOption AS\n"
                + "	SELECT ses.*,option.*,tepr.*,e.*,eo.*\n"
                + "	FROM epreuveOption eo\n"
                + "	INNER JOIN option ON option.option_id = eo.option_id\n"
                + "	INNER JOIN session ses ON ses.session_id = eo.session_id\n"
                + "	INNER JOIN typeEpreuve tepr ON tepr.typeEpreuve_id = eo.typeEpreuve_id\n"
                + "	INNER JOIN epreuve e ON e.epreuve_id = eo.epreuve_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewCentre() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS viewCentre AS\n"
               + " SELECT centr.*,typeCn.*,sess.*,tpLoc.*\n"
               + " FROM centre c\n"
               + " INNER JOIN localite centr ON centr.localite_id = c.centre_id\n"
               //+ " LEFT JOIN localite localProvince ON localProvince.localite_id = centr.parentLocalite\n"
              // + " LEFT JOIN localite localRegion ON localRegion.localite_id = localProvince.parentLocalite\n"
               + " INNER JOIN typeLocalite tpLoc on tpLoc.typeLocalite_id = centr.typeLocalite_id\n"
               + " INNER JOIN typeCentre typeCn ON typeCn.typeCentre_id = c.typeCentre_id\n"
               + " INNER JOIN session sess ON sess.session_id = c.session_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewJury AS\n"
                + "	SELECT \n"
                + "        str.structure_id as centreCompo_id,\n"
                + "        str.nomStructure as centreCompo_libelle,\n"
                + "        j.jury_id,\n"
                + "        j.juryLibelle,\n"
                +"         j.juryCapacite\n"
                + "        ,sess.session_id,\n"
                + "        sess.annee\n"
                + "        ,centres.centre_identifiant,\n"
                + "        centres.centre_id,\n"
                + "        centres.typeCentre_id,\n"
                + "        cc.zone_id,\n"
                + "        local.nomLocalite as nomCentre\n"
                + "        FROM jury j\n"
                + "                inner join centreJury cj on cj.jury_id = j.jury_id\n"
                + "                inner join centreComposition cc on cc.etablissement_id = cj.etablissement_id\n"
                + "                inner join centre centres on centres.centre_identifiant = cj.centre_id\n"
                + "                inner join localite local on local.localite_id = centres.centre_id\n"
                + "                INNER JOIN structure str ON cj.etablissement_id = str.structure_id\n"
                + "                INNER JOIN session sess ON sess.session_id = j.session_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewCandidat() throws SQLException{
       Statement stmtt = this.connexion.createStatement();
       stmtt.execute("DROP VIEW IF EXISTS viewCandidat;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCandidat AS\n" +
        "    SELECT c.*,i.*,sess.*,option.*,str.*,concour.*,typeCa.*,\n" +
        "pay.pays_id,pay.indicatif,pay.nomPays,payNat.pays_id as nationalite_id,payNat.nationalite,\n" +
        "zo.localite_id as zone_id,zo.nomLocalite as nom_zone,\n"
        + "vilcompo.centre_identifiant as centrId,\n" +
        "centreExam.localite_id as centreExamenId,centreExam.nomLocalite as nomCentre,\n" +
        "typLoca.typeLocalite_id as centreType,\n" +
        "typLo.typeLocaliteLibelle as libelleTypeLocal,\n" +
        "commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
        "provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
        "regio.localite_id as region_id,regio.nomLocalite as nom_region,\n" +
        "tpInsc.typeInscription_id as typeInsc_id,tpInsc.typeInscriptionLibelle as typeInsc_libelle,\n" +
        "gp.groupePedagogique_id as gp_id,gp.groupePedagogiqueLibelle as gp_libelle,\n" +
        "tpSit.typeSituation_id as tpSituation_id,tpSit.typeSituationLibelle as tpSituation_libelle,\n" +
        "prescH.prescription_id as presci_id,prescH.prescriptionLibelle as presci_libelle,\n" +
        "natureH.natureHandicap_id as natureH_id,natureH.natureHandicapLibelle as natureH_libelle,\n" +
        "typeH.typeHandicap_id as typeH_id,typeH.typeHandicapLibelle as typeH_libelle,\n" +
        "chCan.choixEtablissement_id as etabChoix_id, choixEtabCandi.nomStructure as etabChoix_nom,\n" +
        "choixEtabCandi.acronymeStructure as etabChoix_accronyme,\n" +
        "chCan.serie_id as serieChoix,choixSerieCandi.serieLibelle\n" +
        "	    FROM candidat c\n" +
        "INNER JOIN inscription i ON i.candidat_id = c.candidat_id and c.numeroDossier = i.numeroDossier and c.etablissement_id = i.etablissement_id\n" +
        "INNER JOIN structure str ON str.structure_id = i.etablissement_id\n" +
        "INNER JOIN session sess ON sess.session_id = i.session_id\n" +
        "INNER JOIN localite zo ON zo.localite_id = i.zone_id\n" +
        "INNER JOIN centre vilcompo ON vilcompo.centre_identifiant = i.centreExamen_Id and vilcompo.centre_id = i.centre_id and vilcompo.localite_id = i.localite_id\n" +
        "inner join localite typLoca on typLoca.localite_id = vilcompo.localite_id\n" +
        "INNER JOIN typeLocalite typLo ON typLO.typeLocalite_id = typLoca.typeLocalite_id\n" +
        "inner join localite centreExam on centreExam.localite_id = vilcompo.centre_id\n" +
        "LEFT JOIN localite commu ON commu.localite_id = vilcompo.localite_id\n" +
        "LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
        "LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
        "INNER JOIN option ON option.option_id = i.option_id\n" +
        "INNER JOIN concoursRattache concour ON concour.concoursRattache_id = i.concoursRattache\n" +
        "INNER JOIN typeCandidat typeCa ON typeCa.typeCandidat_id = i.typeCandidat_id\n" +
        "INNER JOIN pays pay ON pay.pays_id = c.paysNaissance_id\n" +
        "INNER JOIN pays payNat ON payNat.pays_id = c.paysNationalite_id\n" +
        "INNER JOIN typeInscription tpInsc ON tpInsc.typeInscription_id = i.typeInscription_id\n" +
        "INNER JOIN groupePedagogique gp ON gp.groupePedagogique_id = i.groupePedagogique_id and gp.etablissement_id = i.etablissement_id\n" +
        "INNER JOIN typeSituation tpSit	ON tpSit.typeSituation_id = i.typeSituation_id\n" +
        "LEFT JOIN prescription prescH ON prescH.prescription_id = i.prescription_id\n" +
        "LEFT JOIN natureHandicap natureH ON natureH.natureHandicap_id = i.natureHandicap_id\n" +
        "LEFT JOIN typeHandicap typeH ON typeH.typeHandicap_id = natureH.typeHandicap_id\n" +
        "LEFT JOIN choixCandidat chCan ON chCan.candidat_id = i.candidat_id and chCan.numeroDossier = i.numeroDossier and chCan.etablissement_id = i.etablissement_id\n" +
        "LEFT JOIN structure choixEtabCandi ON choixEtabCandi.structure_id = chCan.choixEtablissement_id\n" +
        "LEFT JOIN serie choixSerieCandi ON choixSerieCandi.serie_id = chCan.serie_id" +
        "       ;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewCandidatJury() throws SQLException{
       Statement stmtt = this.connexion.createStatement();
       stmtt.execute("DROP VIEW IF EXISTS viewCandidatJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCandidatJury AS\n"
                + "	SELECT c.*,i.*,sess.*,serie.*,vilcompo.*,str.*,j.*,r.*,ces.*\n"
                + "	FROM candidat c\n"
                + "	INNER JOIN inscription i ON i.candidat_id = c.candidat_id\n"
                + "	INNER JOIN structure str ON str.structure_id = i.etablissement_id\n"
                + "	INNER JOIN session sess ON sess.session_id = i.session_id\n"
                + "	INNER JOIN localite vilcompo ON vilcompo.localite_id = i.centreExamen_Id\n"
                + "	INNER JOIN serie ON serie.serie_id = i.serie_id\n"
                + "	LEFT JOIN candidatJury cj ON cj.candidat_id = c.candidat_id\n"
                + "     LEFT JOIN centreSecondaire ces ON ces.centreSecondaire_id = cj.centreSecondaire_id\n"
                + "	LEFT JOIN jury j ON j.jury_id = cj.jury_id\n"
                + "	LEFT JOIN resultat r ON r.candidat_id = i.candidat_id and r.session_id = i.session_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createViewCandidatPosteJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewCandidatPosteJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCandidatPosteJury AS\n"
                + "	SELECT cpj.*,ecpj.*,e.*,sess.*,str.*,poste.*,\n" +
                "     commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
                "     provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
                "     regio.localite_id as region_id,regio.nomLocalite as nom_region,\n" +
                "       typS.typeStructure_id as type_id,typS.typeStructureLibelle as type_libelle\n" +
                "	FROM candidatPosteJury cpj\n" +
                "	LEFT JOIN epreuveCandidatPosteJury ecpj ON ecpj.candidat_id = cpj.candidat_id and ecpj.structure_id = cpj.structure_id\n" +
                "	LEFT JOIN epreuve e ON e.epreuve_id= ecpj.epreuve_id\n" +
                "	INNER JOIN session sess ON sess.session_id = cpj.session_id\n" +
                "	INNER JOIN structure str ON str.structure_id = cpj.structure_id\n" +
                "       INNER JOIN typeStructure typS ON typS.typeStructure_id = str.typeStructure_id\n" +
                "       LEFT JOIN localite commu ON commu.localite_id = cpj.localiteCandidat_id\n" +
                "       LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
                "       LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
                "       INNER JOIN posteMembreJury poste ON poste.poste_id = cpj.poste_id\n" +
                "     ;";
                
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewUser() throws SQLException{
     //   Statement stmtt = this.connexion.createStatement();
     //   stmtt.execute("DROP VIEW IF EXISTS viewUser;");
        String sql = "CREATE VIEW IF NOT EXISTS viewUser AS\n"
                + "SELECT pr.*,u.*,pe.*,m.jury_id,s.structure_id as userStructId,\n" +
                "     s.nomStructure as userStructLibelle,\n" +
                "     ts.typeStructure_id as userTypeStructId,ts.typeStructureLibelle as userTypeStructLibelle,\n" +
                "	 commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
                "	 provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
                "	 regio.localite_id as region_id,regio.nomLocalite as nom_region\n" +
                "     FROM user u\n" +
                "     INNER JOIN profil pr ON pr.profil_id = u.profil_id\n" +
                "     LEFT JOIN personnel pe ON pe.personnel_id = u.personnel_id\n" +
                "     LEFT JOIN membreJury m ON pe.personnel_id = m.personnel_id\n" +
                "     LEFT JOIN structure s ON s.structure_id = u.structure_id\n" +
                "	 LEFT JOIN localite commu ON commu.localite_id = s.localite_id\n" +
                "	 LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
                "	 LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
                "     LEFT JOIN typeStructure ts ON ts.typeStructure_id = s.typeStructure_id"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewPrescriptionHandicap() throws SQLException{
    //    Statement stmtt = this.connexion.createStatement();
    //    stmtt.execute("DROP VIEW IF EXISTS viewPrescriptionHandicap;");
        String sql = "CREATE VIEW IF NOT EXISTS viewPrescriptionHandicap AS\n"
                + "select prescri.*,nature.* from prescriptionHandicap preH \n"
                + "inner join prescription prescri on prescri.prescription_id = preH.prescription_id \n"
                + "inner join natureHandicap nature on nature.natureHandicap_id = preH.natureHandicap_id \n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);          
    }
    
    public void createViewConcoursSerie() throws SQLException{
    //    Statement stmtt = this.connexion.createStatement();
    //    stmtt.execute("DROP VIEW IF EXISTS viewConcoursSerie;");
        String sql = "CREATE VIEW IF NOT EXISTS viewConcoursSerie AS\n"
                + "select concours.*,ser.* from concoursSerie conSer \n"
                + "inner join concoursRattache concours on concours.concoursRattache_id = conSer.concoursRattache_id \n"
                + "inner join serie ser on ser.serie_id = conSer.serie_id \n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }  
    public void createViewCritereModalitePoste() throws SQLException{
    //    Statement stmtt = this.connexion.createStatement();
//        stmtt.execute("DROP VIEW IF EXISTS viewCritereModalitePoste;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCritereModalitePoste AS\n"
                + "select post.*,crit.*,moda.*,critPos.* "
                + "from criterePosteJury critPos\n"
                + "inner join posteMembreJury post on post.poste_id = critPos.poste_id\n"
                + "inner join critere crit on crit.critere_id = critPos.critere_id "
                + "inner join modalite moda on moda.modalite_id = critPos.modalite_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewCentreExamen() throws SQLException{
        String sql = "CREATE VIEW IF NOT EXISTS viewCentreExamen AS\n"
                + "select \n" +
                "cen.centre_identifiant,\n" +
                "cen.session_id,\n" +
                "commu.localite_id as communeId,\n" +
                "commu.nomLocalite as nomCommune,\n" +
                "provi.localite_id as provinceId,\n" +
                "provi.nomLocalite as nomProvince,\n" +
                "regio.localite_id as regionId,\n" +
                "regio.nomLocalite as nomRegion,\n" +
                "cen.centre_id as centreExamenId,centreExam.nomLocalite as nomCentre,\n" +
                "typeC.typeCentre_id as typeId,typeC.typeCentreLibelle as typeLibelle\n" +
                "from centre cen\n" +
                "inner join localite commu on commu.localite_id = cen.localite_id\n" +
                "inner join localite provi on provi.localite_id = commu.parentLocalite\n" +
                "inner join localite regio on regio.localite_id = provi.parentLocalite\n" +
                "inner join localite centreExam on centreExam.localite_id = cen.centre_id\n" +
                "inner join typeCentre typeC on typeC.typeCentre_id = cen.typeCentre_id"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    public void createViewLocalite() throws SQLException{
     //   Statement stmtt = this.connexion.createStatement();
     //   stmtt.execute("DROP VIEW IF EXISTS viewLocalite;");
        String sql = "CREATE VIEW IF NOT EXISTS viewLocalite AS\n"
                + "SELECT l.*,tpL.*,parent.nomLocalite as nomParent  "
                + "FROM localite l\n"
                + "inner join typeLocalite tpL on tpL.typeLocalite_id = l.typeLocalite_id\n"
                + "Left join localite parent on parent.localite_id = l.parentLocalite "
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
        stmt.close();        
    }
    
    public void insertMenu() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "INSERT INTO menu(menuParent_id,menuLibelle,action,icons)\n"
                + "	values(null,'Paramètre',null,'@/images/home.png'),(1,'Menu','openMenu',null),(2,'Profil','openProfil',null)\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void insertMenuProfil() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "INSERT INTO profilMenus (profil_id,menu_id)\n"
                + "	values(6,1),(6,2),(6,3)\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void insertUser() throws SQLException{
        
        // SQL statement for creating a new table
        String sql = "INSERT INTO user(profil_id,structure_id,personnel_id,username,pwd,statut)\n"
                + "	values(6,1,3,'root','7c4a8d09ca3762af61e59520943dc26494f8941b',true)\n"
                + ";";
        
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }
    
    public void createViewProfilMenu() throws SQLException{
        String sql ="CREATE VIEW IF NOT EXISTS viewProfilMenu AS\n"
            +"SELECT pr.profil_id,pr.profilLibelle,\n" +
            "menParent.menu_id,\n" +
            "menParent.menuLibelle,\n"
                + "menParent.action," +
            "menFils.menu_id as parentId,\n" +
            "menFils.menuLibelle as parentLibelle,\n" +
            "menFils.icons as parentIcon\n" +
            "FROM profilMenus pM\n" +
            "INNER JOIN profil pr ON pr.profil_id = pM.profil_id\n" +
            "INNER JOIN menu menParent ON menParent.menu_id = pM.menu_id\n" +
            "LEFT JOIN menu menFils ON menFils.menu_id =  menParent.menuParent_id"
            + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
      //  this.connexion.close();
       stmt.close();       
    }
    
    public void createViewCandidatsInscrits() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS createViewCandidatsInscrits;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCandidatsInscrits AS \n"
                + "SELECT \n" +
"		c.candidat_id,c.nom,c.prenom,c.sexe,c.typeDateNaissance,c.dateNaissance,c.numeroActeNaissance,c.lieuNaissance,\n" +
"		i.numeroDossier,i.sport,i.dernierDiplome,i.anneeDernierDiplome,c.nomPere,c.prenomPere,i.telephone,c.nomMere,c.prenomMere,i.telephoneDeux,\n" +
"		sess.*,\n" +
"		option.*,\n" +
"		str.*,\n" +
"		concour.*,\n" +
"		typeCa.*,\n" +
"        pay.pays_id,pay.indicatif,pay.nomPays,\n" +
"		payNat.pays_id as nationalite_id,payNat.nationalite,\n" +
"        zo.localite_id as zone_id,zo.nomLocalite as nom_zone,\n" +
"        vilcompo.centre_identifiant as centrId,\n" +
"        centreExam.localite_id as centreExamenId,centreExam.nomLocalite as nomCentre,\n" +
"        typLoca.typeLocalite_id as centreType,\n" +
"        typLo.typeLocaliteLibelle as libelleTypeLocal,\n" +
"        commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
"        provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
"        regio.localite_id as region_id,regio.nomLocalite as nom_region,\n" +
"        tpInsc.typeInscription_id as typeInsc_id,tpInsc.typeInscriptionLibelle as typeInsc_libelle,\n" +
"        gp.groupePedagogique_id as gp_id,gp.groupePedagogiqueLibelle as gp_libelle,\n" +
"        tpSit.typeSituation_id as tpSituation_id,tpSit.typeSituationLibelle as tpSituation_libelle,\n" +
"        prescH.prescription_id as presci_id,prescH.prescriptionLibelle as presci_libelle,\n" +
"        natureH.natureHandicap_id as natureH_id,natureH.natureHandicapLibelle as natureH_libelle,\n" +
"        typeH.typeHandicap_id as typeH_id,typeH.typeHandicapLibelle as typeH_libelle\n" +
"        FROM candidat c\n" +
"        INNER JOIN inscription i ON i.candidat_id = c.candidat_id and i.numeroDossier = c.numeroDossier and i.etablissement_id = c.etablissement_id\n" +
"		INNER JOIN session sess ON sess.session_id = i.session_id\n" +
"		INNER JOIN option ON option.option_id = i.option_id\n" +
"        INNER JOIN structure str ON str.structure_id = i.etablissement_id\n" +
"        INNER JOIN concoursRattache concour ON concour.concoursRattache_id = i.concoursRattache\n" +
"		INNER JOIN typeCandidat typeCa ON typeCa.typeCandidat_id = i.typeCandidat_id\n" +
"		INNER JOIN pays pay ON pay.pays_id = c.paysNaissance_id\n" +
"        INNER JOIN pays payNat ON payNat.pays_id = c.paysNationalite_id\n" +
"        INNER JOIN localite zo ON zo.localite_id = i.zone_id\n" +
"        INNER JOIN centre vilcompo ON vilcompo.centre_identifiant = i.centreExamen_Id and vilcompo.centre_id = i.centre_id and vilcompo.localite_id = i.localite_id\n" +
"	 INNER JOIN localite centreExam on centreExam.localite_id = vilcompo.centre_id \n" +
"        INNER JOIN localite typLoca on typLoca.localite_id = vilcompo.localite_id\n" +
"        INNER JOIN typeLocalite typLo ON typLO.typeLocalite_id = typLoca.typeLocalite_id\n" +
"        LEFT JOIN localite commu ON commu.localite_id = vilcompo.localite_id\n" +
"        LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
"	 LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
"        INNER JOIN typeInscription tpInsc ON tpInsc.typeInscription_id = i.typeInscription_id\n" +
"        INNER JOIN groupePedagogique gp ON gp.groupePedagogique_id = i.groupePedagogique_id and gp.etablissement_id = i.etablissement_id\n" +
"        INNER JOIN typeSituation tpSit	ON tpSit.typeSituation_id = i.typeSituation_id\n" +
"        LEFT JOIN prescription prescH ON prescH.prescription_id = i.prescription_id\n" +
"        LEFT JOIN natureHandicap natureH ON natureH.natureHandicap_id = i.natureHandicap_id\n" +
"        LEFT JOIN typeHandicap typeH ON typeH.typeHandicap_id = natureH.typeHandicap_id;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    
     public void createViewDistinctCandidatPosteJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewDistinctCandidatPosteJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewDistinctCandidatPosteJury AS\n"
                + "	SELECT cpj.candidat_id,cpj.nom,cpj.prenom,cpj.sexe,cpj.telephone,cpj.matricule,cpj.nip,cpj.etatCandidature,\n" +
                "	sess.*,str.*,poste.*,\n" +
                "     commu.localite_id as commune_id,commu.nomLocalite as nom_commune,\n" +
                "     provi.localite_id as province_id,provi.nomLocalite as nom_province,\n" +
                "     regio.localite_id as region_id,regio.nomLocalite as nom_region,\n" +
                "	 typS.typeStructure_id as type_id,typS.typeStructureLibelle as type_libelle\n" +
                "FROM candidatPosteJury cpj\n" +
                "INNER JOIN session sess ON sess.session_id = cpj.session_id\n" +
                "INNER JOIN structure str ON str.structure_id = cpj.structure_id\n" +
                "INNER JOIN typeStructure typS ON typS.typeStructure_id = str.typeStructure_id\n" +
                "LEFT JOIN localite commu ON commu.localite_id = cpj.localiteCandidat_id\n" +
                "LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite\n" +
                "LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite\n" +
                "INNER JOIN posteMembreJury poste ON poste.poste_id = cpj.poste_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
     
     //Par Etablissement
    public void createViewStatistiqueByEtab() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueEtabBySerie;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueByEtab AS "
                + "SELECT vp.nomStructure,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.structure_id = vp.structure_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.structure_id = vp.structure_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.structure_id = vp.structure_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.structure_id = vp.structure_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.structure_id = vp.structure_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.nomStructure ORDER BY vp.nomStructure;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueActeurByEtab() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueActeurByEtab;");
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueActeurByEtab AS "
                + "SELECT cp.structure_id,cp.nomStructure,\n" +
        "(SELECT count(p.candidat_id) from viewDistinctCandidatPosteJury p WHERE p.structure_id = cp.structure_id and p.posteLibelle = 'Président') AS nbPresident,\n" +
        "(SELECT count(s.candidat_id) from viewDistinctCandidatPosteJury s WHERE s.structure_id = cp.structure_id and s.posteLibelle = 'Secrétaire') AS nbSecretaire,\n" +
        "(SELECT count(c.candidat_id) from viewDistinctCandidatPosteJury c WHERE c.structure_id = cp.structure_id and c.posteLibelle = 'Correcteur') AS nbCorrecteur,\n" +
        "(SELECT count(sup.candidat_id) from viewDistinctCandidatPosteJury sup WHERE sup.structure_id = cp.structure_id and sup.posteLibelle = 'Superviseur pédagogique') AS nbSuperviseur,\n" +
        "(SELECT count(vp.candidat_id) from viewDistinctCandidatPosteJury vp WHERE vp.structure_id = cp.structure_id and vp.posteLibelle = 'Vice-président') AS nbVicePresident,\n" +
        "(SELECT count(pcs.candidat_id) from viewDistinctCandidatPosteJury pcs WHERE pcs.structure_id = cp.structure_id and pcs.posteLibelle = 'Président de centre secondaire') AS nbPresidentCentreSecondaire\n" +
                "FROM viewDistinctCandidatPosteJury cp GROUP BY cp.structure_id;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
       
    public void createViewStatistiqueEtabByOption() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueEtabByOption;");
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueEtabByOption AS "
                + "SELECT vp.nomStructure,vp.optionLibelle,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.structure_id = vp.structure_id and ti.option_id = vp.option_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.structure_id = vp.structure_id and vg.option_id = vp.option_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.structure_id = vp.structure_id and vf.option_id = vp.option_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.structure_id = vp.structure_id and va.option_id = vp.option_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.structure_id = vp.structure_id and vi.option_id = vp.option_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.optionLibelle,vp.nomStructure ORDER BY vp.nomStructure,vp.optionLibelle;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueEtabBySituation() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueEtabBySituation;");
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueEtabBySituation AS "
                + "SELECT vp.nomStructure,vp.tpSituation_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.structure_id = vp.structure_id and ti.tpSituation_id = vp.tpSituation_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM  viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.structure_id = vp.structure_id and vg.tpSituation_id = vp.tpSituation_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM  viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.structure_id = vp.structure_id and vf.tpSituation_id = vp.tpSituation_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM  viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.structure_id = vp.structure_id and va.tpSituation_id = vp.tpSituation_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM  viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.structure_id = vp.structure_id and vi.tpSituation_id = vp.tpSituation_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.tpSituation_libelle,vp.nomStructure ORDER BY vp.nomStructure,vp.tpSituation_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
                 //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueEtabByHandicap() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueEtabByHandicap;");
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueEtabByHandicap AS "
                + "SELECT vp.nomStructure,vp.typeH_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM  viewCandidatsInscrits ti WHERE ti.structure_id = vp.structure_id and ti.typeH_id = vp.typeH_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM  viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.structure_id = vp.structure_id and vg.typeH_id = vp.typeH_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM  viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.structure_id = vp.structure_id and vf.typeH_id = vp.typeH_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM  viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.structure_id = vp.structure_id and va.typeH_id = vp.typeH_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM  viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.structure_id = vp.structure_id and vi.typeH_id = vp.typeH_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.typeH_libelle,vp.nomStructure ORDER BY vp.nomStructure,vp.typeH_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
                 //  this.connexion.close();
       stmt.close(); 
    }
    
    //Par Province
    
    public void createViewStatistiqueByProvince() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueByProvince;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueByProvince AS "
                + "SELECT vp.nom_province,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.province_id = vp.province_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.province_id = vp.province_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.province_id = vp.province_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.province_id = vp.province_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.province_id = vp.province_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.nom_province ORDER BY vp.nom_province;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueActeurByProvince() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueActeurByProvince;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueActeurByProvince AS "
                + "SELECT cp.province_id,cp.nom_province,\n" +
        "(SELECT count(p.candidat_id) from viewDistinctCandidatPosteJury p WHERE p.province_id = cp.province_id and p.posteLibelle = 'Président') AS nbPresident,\n" +
        "(SELECT count(s.candidat_id) from viewDistinctCandidatPosteJury s WHERE s.province_id = cp.province_id and s.posteLibelle = 'Secrétaire') AS nbSecretaire,\n" +
        "(SELECT count(c.candidat_id) from viewDistinctCandidatPosteJury c WHERE c.province_id = cp.province_id and c.posteLibelle = 'Correcteur') AS nbCorrecteur,\n" +
        "(SELECT count(sup.candidat_id) from viewDistinctCandidatPosteJury sup WHERE sup.province_id = cp.province_id and sup.posteLibelle = 'Superviseur pédagogique') AS nbSuperviseur,\n" +
        "(SELECT count(vp.candidat_id) from viewDistinctCandidatPosteJury vp WHERE vp.province_id = cp.province_id and vp.posteLibelle = 'Vice-président') AS nbVicePresident,\n" +
        "(SELECT count(pcs.candidat_id) from viewDistinctCandidatPosteJury pcs WHERE pcs.province_id = cp.province_id and pcs.posteLibelle = 'Président de centre secondaire') AS nbPresidentCentreSecondaire\n" +
                "FROM viewDistinctCandidatPosteJury cp GROUP BY cp.province_id;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
       
    public void createViewStatistiqueProvinceByOption() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueProvinceByOption;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueProvinceByOption AS "
                + "SELECT vp.nomStructure,vp.optionLibelle,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.province_id = vp.province_id and ti.option_id = vp.option_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.province_id = vp.province_id and vg.option_id = vp.option_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.province_id = vp.province_id and vf.option_id = vp.option_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.province_id = vp.province_id and va.option_id = vp.option_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.province_id = vp.province_id and vi.option_id = vp.option_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.optionLibelle,vp.nom_province ORDER BY vp.nom_province,vp.optionLibelle;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueProvinceBySituation() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueProvinceBySituation;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueProvinceBySituation AS "
                + "SELECT vp.nom_province,vp.tpSituation_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.province_id = vp.province_id and ti.tpSituation_id = vp.tpSituation_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.province_id = vp.province_id and vg.tpSituation_id = vp.tpSituation_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.province_id = vp.province_id and vf.tpSituation_id = vp.tpSituation_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.province_id = vp.province_id and va.tpSituation_id = vp.tpSituation_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.province_id = vp.province_id and vi.tpSituation_id = vp.tpSituation_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.tpSituation_libelle,vp.nom_province ORDER BY vp.nom_province,vp.tpSituation_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
                 //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueProvinceByHandicap() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueProvinceBySerie;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueProvinceByHandicap AS "
                + "SELECT vp.nom_province,vp.typeH_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.province_id = vp.province_id and ti.typeH_id = vp.typeH_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.province_id = vp.province_id and vg.typeH_id = vp.typeH_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.province_id = vp.province_id and vf.typeH_id = vp.typeH_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.province_id = vp.province_id and va.typeH_id = vp.typeH_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.province_id = vp.province_id and vi.typeH_id = vp.typeH_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.typeH_libelle,vp.nom_province ORDER BY vp.nom_province,vp.typeH_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
                 //  this.connexion.close();
       stmt.close(); 
    }
    
    //Par Region
    
    public void createViewStatistiqueByRegion() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueByRegion;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueByRegion AS "
                + "SELECT vp.nom_region,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.region_id = vp.region_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.region_id = vp.region_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.region_id = vp.region_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.region_id = vp.region_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.region_id = vp.region_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.nom_region ORDER BY vp.nom_region;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueActeurByRegion() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueActeurByRegion;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueActeurByRegion AS "
                + "SELECT cp.region_id,cp.nom_region,\n" +
        "(SELECT count(p.candidat_id) from viewDistinctCandidatPosteJury p WHERE p.region_id = cp.region_id and p.posteLibelle = 'Président') AS nbPresident,\n" +
        "(SELECT count(s.candidat_id) from viewDistinctCandidatPosteJury s WHERE s.region_id = cp.region_id and s.posteLibelle = 'Secrétaire') AS nbSecretaire,\n" +
        "(SELECT count(c.candidat_id) from viewDistinctCandidatPosteJury c WHERE c.region_id = cp.region_id and c.posteLibelle = 'Correcteur') AS nbCorrecteur,\n" +
        "(SELECT count(sup.candidat_id) from viewDistinctCandidatPosteJury sup WHERE sup.region_id = cp.region_id and sup.posteLibelle = 'Superviseur pédagogique') AS nbSuperviseur,\n" +
        "(SELECT count(vp.candidat_id) from viewDistinctCandidatPosteJury vp WHERE vp.region_id = cp.region_id and vp.posteLibelle = 'Vice-président') AS nbVicePresident,\n" +
        "(SELECT count(pcs.candidat_id) from viewDistinctCandidatPosteJury pcs WHERE pcs.region_id = cp.region_id and pcs.posteLibelle = 'Président de centre secondaire') AS nbPresidentCentreSecondaire\n" +
                "FROM viewDistinctCandidatPosteJury cp GROUP BY cp.region_id;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
       
    public void createViewStatistiqueRegionByOption() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueRegionByOption;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueRegionByOption AS "
                + "SELECT vp.nom_region,vp.optionLibelle,\n" +
                "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.region_id = vp.region_id and ti.option_id = vp.option_id) as tatalInscrits,\n" +
                "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.region_id = vp.region_id and vg.option_id = vp.option_id) as nbG,\n" +
                "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.region_id = vp.region_id and vf.option_id = vp.option_id) as nbF,\n" +
                "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.region_id = vp.region_id and va.option_id = vp.option_id) as nbApte,\n" +
                "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.region_id = vp.region_id and vi.option_id = vp.option_id) as nbInapte\n" +
                "\n" +
                "FROM viewCandidatsInscrits vp GROUP BY vp.optionLibelle,vp.nom_region ORDER BY vp.nom_region,vp.optionLibelle;";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
         //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueRegionBySituation() throws SQLException{
       /* Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueRegionBySituation;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueRegionBySituation AS "
                + "SELECT vp.nom_region,vp.tpSituation_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.region_id = vp.region_id and ti.tpSituation_id = vp.tpSituation_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.region_id = vp.region_id and vg.tpSituation_id = vp.tpSituation_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.region_id = vp.region_id and vf.tpSituation_id = vp.tpSituation_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.region_id = vp.region_id and va.tpSituation_id = vp.tpSituation_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.region_id = vp.region_id and vi.tpSituation_id = vp.tpSituation_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.tpSituation_libelle,vp.nom_region ORDER BY vp.nom_region,vp.tpSituation_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
                 //  this.connexion.close();
       stmt.close(); 
    }
    
    public void createViewStatistiqueRegionByHandicap() throws SQLException{
        /*Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewStatistiqueRegionByHandicap;");*/
        String sql = "CREATE VIEW IF NOT EXISTS viewStatistiqueRegionByHandicap AS "
                + "SELECT vp.nom_region,vp.typeH_libelle,\n" +
        "	(SELECT count(ti.candidat_id) FROM viewCandidatsInscrits ti WHERE ti.region_id = vp.region_id and ti.typeH_id = vp.typeH_id) as tatalInscrits,\n" +
        "	(SELECT count(vg.candidat_id) FROM viewCandidatsInscrits vg WHERE vg.sexe='Masculin' and vg.region_id = vp.region_id and vg.typeH_id = vp.typeH_id) as nbG,\n" +
        "	(SELECT count(vf.candidat_id) FROM viewCandidatsInscrits vf WHERE vf.sexe='Feminin' and vf.region_id = vp.region_id and vf.typeH_id = vp.typeH_id) as nbF,\n" +
        "	(SELECT count(va.candidat_id) FROM viewCandidatsInscrits va WHERE va.sport = 'Apte' and va.region_id = vp.region_id and va.typeH_id = vp.typeH_id) as nbApte,\n" +
        "	(SELECT count(vi.candidat_id) FROM viewCandidatsInscrits vi WHERE vi.sport = 'Inapte' and vi.region_id = vp.region_id and vi.typeH_id = vp.typeH_id) as nbInapte\n" +
        "\n" +
        "FROM viewCandidatsInscrits vp GROUP BY vp.typeH_libelle,vp.nom_region ORDER BY vp.nom_region,vp.typeH_libelle;";
                Statement stmt = this.connexion.createStatement();
                stmt.execute(sql);
       
       stmt.close(); 
    }

    public void createViewCreationCentreComposition() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewCreationCentreComposition;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCreationCentreComposition AS\n"
            + "	SELECT struct.*,c.* ,z.*\n"
            + "	FROM structure struct \n"
            + "	INNER JOIN etablissement e ON e.etablissement_id = struct.structure_id \n"
            + "	LEFT JOIN centreComposition c ON c.etablissement_id = e.etablissement_id \n"
            + "	LEFT JOIN localite z ON z.localite_id = c.zone_id \n"
            + "	LEFT JOIN session sess ON sess.session_id = c.session_id \n"
            + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createViewCentreComposition() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewCentreComposition;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCentreComposition AS \n"
                + "	SELECT struct.*,ce.*,c.*,z.*,prov.localite_id as provId,prov.nomLocalite as province,reg.localite_id as regId,reg.nomLocalite as region \n"
                + "	FROM structure struct \n"
                + "	INNER JOIN centreComposition c ON c.etablissement_id = struct.structure_id \n"
                + "	INNER JOIN localite ce ON ce.localite_id = struct.localite_id \n"
                + "	INNER JOIN localite prov ON prov.localite_id = ce.parentLocalite \n"
                + "	INNER JOIN localite reg ON reg.localite_id = prov.parentLocalite \n"
                + "	LEFT JOIN localite z ON z.localite_id = c.zone_id \n"
                + "	INNER JOIN session sess ON sess.session_id = c.session_id \n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
    }

    public void createViewCritereCandidatPosteJury() throws SQLException{
        Statement stmtt = this.connexion.createStatement();
        stmtt.execute("DROP VIEW IF EXISTS viewCritereCandidatPosteJury;");
        String sql = "CREATE VIEW IF NOT EXISTS viewCritereCandidatPosteJury AS\n"
                + "	SELECT cpj.*,sess.*,str.*,poste.*,ccpj.*\n"
                + "	FROM candidatPosteJury cpj\n"
                + "	INNER JOIN session sess ON sess.session_id = cpj.session_id\n"
                + "	INNER JOIN structure str ON str.structure_id = cpj.structure_id\n"
                + "	INNER JOIN posteMembreJury poste ON poste.poste_id = cpj.poste_id\n"
                + "	INNER JOIN critereCandidatPosteJury ccpj ON ccpj.candidat_id = cpj.candidat_id AND ccpj.poste_id = cpj.poste_id AND ccpj.structure_id = cpj.structure_id\n"
                + "	INNER JOIN criterePosteJury critPJ ON ccpj.poste_id = critPJ.poste_id AND ccpj.critere_id = critPJ.critere_id AND ccpj.modalite_id = critPJ.modalite_id\n"
                + ";";
        Statement stmt = this.connexion.createStatement();
        stmt.execute(sql);
        this.connexion.close();
        stmt.close();
    } 
}
