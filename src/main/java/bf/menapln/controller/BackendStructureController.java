/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.controller;

import bf.menapln.entity.Localite;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Structure;
import bf.menapln.entity.Type;
import bf.menapln.exception.EmptyDataException;
import bf.menapln.service.LocaliteService;
import bf.menapln.service.StructureService;
import bf.menapln.service.TypeService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author LENOVO
 */
public class BackendStructureController {
    
    
    private StructureService service;
    private TypeService typeService;
    private LocaliteService localiteService;
    private List provinces = new ArrayList();
    private List communes = new ArrayList();
    private List statuts = new ArrayList();
    private List offres = new ArrayList();
    
    public BackendStructureController() throws SQLException {
        this.service = new StructureService();
    }
    //Get la liste de toutes les structures
    public List<Objet> getAll(String structure) throws SQLException{
        return this.service.getAll(structure);
}
    
    //Get la liste de toutes les province
    public List<Objet> getEtabByLocalite(String type,Localite localite) throws SQLException{
        return this.service.getByTypeLocaliteAndId(type,localite);
    }
        
    //Get la liste de toutes les province
    public List<Objet> getAllTypeStructure(String type) throws SQLException{
        return this.service.getAllTypeStructure(type);
    }
    
    //Enregistrement d'une struture
    public void save(HashMap<String,String> formData) throws SQLException, EmptyDataException, exception.EmptyDataException{
        service.setFormData(formData);
        service.save();
    }
    
    //Get la liste de toutes les province
    public List<Objet> getEtabByCommune(String type,Localite localite) throws SQLException{
        return this.service.getByCommuneId(type,localite);
    }
    
    //Get la liste de toutes les province
    public List<Objet> getEtabByProvince(String type,Localite localite) throws SQLException{
        return this.service.getByProvinceId(type,localite);
    }
    
    public List<Objet> getEtabByRegion(String type,Localite localite) throws SQLException{
        return this.service.getByRegionId(type,localite);
    }
    
    public String removeAccent(String chaine){
        String [] search  = {"À", "Á", "Â", "Ã", "Ä", "Å", "Ç", "È", "É", "Ê", "Ë", "Ì", "Í", "Î", "Ï", "Ò", "Ó", "Ô", "Õ", "Ö", "Ù", "Ú", "Û", "Ü", "Ý", "à", "á", "â", "ã", "ä", "å", "ç", "è", "é", "ê", "ë", "ì", "í", "î", "ï", "ð", "ò", "ó", "ô", "õ", "ö", "ù", "ú", "û", "ü", "ý", "ÿ"};
        String [] replace = {"A", "A", "A", "A", "A", "A", "C", "E", "E", "E", "E", "I", "I", "I", "I", "O", "O", "O", "O", "O", "U", "U", "U", "U", "Y", "a", "a", "a", "a", "a", "a", "c", "e", "e", "e", "e", "i", "i", "i", "i", "o", "o", "o", "o", "o", "o", "u", "u", "u", "u", "y", "y"};
        return this.removeSpecial(StringUtils.replaceEach(chaine, search, replace).trim());
    }

    public String removeSpecial(String chaine){
        return chaine.replace("[^a-zA-Z0-9]", "");
    }
    // ExcelSave
    public String saveFiles(String chemin,Type typeStruc) throws SQLException, IOException {
        String ligneEchec = null;
            FileInputStream excelFile = new FileInputStream(new File(chemin));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            if(typeStruc.getLibelle().equalsIgnoreCase("Etablissement")){
                 ligneEchec = saveExcelEtablissementValue(workbook, typeStruc);
            }
          //  String ligneEchec = saveExcelEntityValue(workbook, typeStruc);
        return ligneEchec;
    }
    
    
    // Save ETablissement
    private String saveExcelEtablissementValue(XSSFWorkbook workbook, Type typeStruct) throws SQLException {
        this.typeService = new TypeService();
        this.localiteService = new LocaliteService();
        this.service = new StructureService();
        
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        int rowNumber = 0;
        String ligneEchec = null;
        System.out.println("## debut lecture");
        while (rows.hasNext()) {
            Row currentRow = rows.next();
            int ligneBon = 0;
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }
            rowNumber++;
            Iterator<Cell> cellsInRow = currentRow.iterator();
            int cellIdx = 0;
            String region= null;
            String province= null;
            String commune= null;
            String nomStructure= null;
            String sigleStructure = null;
            String statut=null;
            String offreEnseigne = null;
            
            this.statuts = this.typeService.getAll("Statut étab.");
            this.provinces = this.service.getAll("province");
            this.communes = this.localiteService.getAll("commune");
            this.offres = this.typeService.getAll("Offre ens.");
                   
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();
                switch (cellIdx) {
                case 0:
                    region = currentCell.getStringCellValue();
                break;
                case 1:
                    province = currentCell.getStringCellValue();
                break;
                case 2:
                    commune = currentCell.getStringCellValue();
                break;
                case 3:
                    nomStructure = currentCell.getStringCellValue();
                break;
                case 4:
                    sigleStructure = currentCell.getStringCellValue();
                break;
                case 5:
                    statut = currentCell.getStringCellValue();
                break;
                case 6:
                    offreEnseigne = currentCell.getStringCellValue();
                break;
                default:
                    break;
                }
                cellIdx++;
            }
            
            Objet prov_id = this.getElement(this.provinces, province,"structure");
            Objet statut_id = this.getElement(this.statuts, statut, "type");
            Objet offre_id = this.getElement(this.offres, offreEnseigne, "type");
            Objet commune_id = this.getElement(this.communes, commune, "localite");
            
            HashMap formData = new HashMap<>();
            Boolean isValid = validation(typeStruct, prov_id, statut_id, offre_id, commune_id, nomStructure);
            System.out.println("Check valid "+isValid+" ligne "+rowNumber);
            if(isValid.toString().equalsIgnoreCase("true")){
                try {
                    if(!sigleStructure.isEmpty() && !sigleStructure.equalsIgnoreCase("Néant")){
                        formData = createFormData(typeStruct, prov_id, statut_id, offre_id, commune_id, nomStructure,sigleStructure);
                    }else{ 
                        formData = createFormData(typeStruct, prov_id, statut_id, offre_id, commune_id, nomStructure,sigleStructure);
                    }
                    this.service = new StructureService();
                    service.setFormData(formData);
                    service.save();
                } catch (exception.EmptyDataException ex) {
                    Logger.getLogger(BackendStructureController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                ligneEchec= ligneEchec+" "+rowNumber;
                System.out.print("Error"+ ligneEchec);
            }
            
        }
        return ligneEchec;
    }
    
    public Objet getElement(List data, String libelle, String entity){
        Objet id = null;
        switch (entity) {
            case "localite":
                System.out.println("Localite "+libelle+"Taille======="+data.size());
                Localite loca = ((Localite)data.stream().filter(m->this.removeAccent(((Localite)m).getNomLoclite()).equalsIgnoreCase(this.removeAccent(libelle).toUpperCase())).findAny().orElse(null));
                id= loca;
                System.out.println("ID************************ "+id);
                break;
            case "type":
                System.out.println("Type "+libelle);
                Type typ = ((Type)data.stream().filter(m->this.removeAccent(((Type)m).getLibelle()).equalsIgnoreCase(this.removeAccent(libelle))).findAny().orElse(null));
                id= typ;
                break;
            case "structure":
                System.out.println("Struc "+libelle);
                Structure struct = ((Structure)data.stream().filter(m->(this.removeAccent(((Structure)m).getAcronymeStructure())).equalsIgnoreCase(this.removeAccent(libelle))).findAny().orElse(null));
                id= struct;
                break;
            default:
                break;
        }
        return id;
    }
    
    public HashMap createFormData(Objet typeStruc,Objet structureParente, Objet statut_id, 
            Objet offreEnseignement, Objet localite_id, String nomStruc,String acronyme){
            Type typeStrucTr =  (Type) typeStruc;
            Structure struc =  (Structure) structureParente;
            Type statu =  (Type) statut_id;
            Type offr =  (Type) offreEnseignement;
            Localite local =  (Localite) localite_id;
        HashMap formData = new HashMap<>();
        formData.put("typoField", typeStrucTr.getLibelle());
        formData.put("typeStructure", typeStrucTr);
        formData.put("localiteStructure", local);
        formData.put("structureParente", struc);
        formData.put("codeStructure", "");
        formData.put("nomStructure", nomStruc);
        formData.put("acronymeStructure", acronyme);
        formData.put("statutEtablissement",statu);
        formData.put("offreEnseignement", offr);
        return formData;
    }
    
    public Boolean validation(Objet idTypeStruc,Objet stucturePar, Objet statut_id, Objet offreEnseignement, Objet localite_id, String nomStruc){
        Boolean valide = false;
       // System.out.print("Type ================="+idTypeStruc.getId());
       // System.out.print("Statut ================="+statut_id.getId());
       // System.out.print("DPEPS ================="+stucturePar.getId());
       // System.out.print("Commune ================="+localite_id.getId());
       // System.out.print("Offre ================="+offreEnseignement.getId());
       // System.out.print("Nom Etab ================="+nomStruc);
        if( idTypeStruc.getId()!= null && statut_id.getId() !=null && stucturePar.getId() != null && localite_id.getId() != null && offreEnseignement.getId() != null && !nomStruc.isEmpty()){
            valide = true;
        }
        
        return valide;
    }
    
}
