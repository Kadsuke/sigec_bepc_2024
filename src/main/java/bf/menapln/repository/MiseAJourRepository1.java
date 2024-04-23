/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.repository;

import bf.menapln.dto.Factory;
import bf.menapln.dto.InterfaceDAO;
import bf.menapln.entity.*;
import bf.menapln.entity.Pays;
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
public class MiseAJourRepository1 extends Repository implements InterfaceDAO{

    public MiseAJourRepository1(Factory factory) {
        super(factory);
    }
    
    public boolean saveDirection() throws SQLException {
        boolean success = true;
        List<String> sqlList = new ArrayList<>();
        sqlList.add("UPDATE structure set localite_id = 1506 WHERE structure_id = 1");
        sqlList.add("UPDATE structure set localite_id = 1902 WHERE structure_id = 2");
        sqlList.add("UPDATE structure set localite_id = 2214 WHERE structure_id = 3");
        sqlList.add("UPDATE structure set localite_id = 4049 WHERE structure_id = 4");
        sqlList.add("UPDATE structure set localite_id = 2553 WHERE structure_id = 5");
        sqlList.add("UPDATE structure set localite_id = 3195 WHERE structure_id = 6");
        sqlList.add("UPDATE structure set localite_id = 5005 WHERE structure_id = 7");
        sqlList.add("UPDATE structure set localite_id = 6603 WHERE structure_id = 8");
        sqlList.add("UPDATE structure set localite_id = 7421 WHERE structure_id = 9");
        sqlList.add("UPDATE structure set localite_id = 8284 WHERE structure_id = 10");
        sqlList.add("UPDATE structure set localite_id = 5448 WHERE structure_id = 11");
        sqlList.add("UPDATE structure set localite_id = 7294 WHERE structure_id = 12");
        sqlList.add("UPDATE structure set localite_id = 5841 WHERE structure_id = 13");
        sqlList.add("UPDATE structure set localite_id = 986  WHERE structure_id = 14");
        sqlList.add("UPDATE structure set localite_id = 1152 WHERE structure_id = 15");
        sqlList.add("UPDATE structure set localite_id = 1411 WHERE structure_id = 16");
        sqlList.add("UPDATE structure set localite_id = 1506 WHERE structure_id = 17");
        sqlList.add("UPDATE structure set localite_id = 1702 WHERE structure_id = 18");
        sqlList.add("UPDATE structure set localite_id = 1870 WHERE structure_id = 19");
        sqlList.add("UPDATE structure set localite_id = 1902 WHERE structure_id = 20");
        sqlList.add("UPDATE structure set localite_id = 2201 WHERE structure_id = 21");
        sqlList.add("UPDATE structure set localite_id = 2214 WHERE structure_id = 22");
        sqlList.add("UPDATE structure set localite_id = 4049 WHERE structure_id = 23");
        sqlList.add("UPDATE structure set localite_id = 4259 WHERE structure_id = 24");
        sqlList.add("UPDATE structure set localite_id = 4358 WHERE structure_id = 25");
        sqlList.add("UPDATE structure set localite_id = 4534 WHERE structure_id = 26");
        sqlList.add("UPDATE structure set localite_id = 2553 WHERE structure_id = 27");
        sqlList.add("UPDATE structure set localite_id = 2788 WHERE structure_id = 28");
        sqlList.add("UPDATE structure set localite_id = 3039 WHERE structure_id = 29");
        sqlList.add("UPDATE structure set localite_id = 3195 WHERE structure_id = 30");
        sqlList.add("UPDATE structure set localite_id = 3413 WHERE structure_id = 31");
        sqlList.add("UPDATE structure set localite_id = 3704 WHERE structure_id = 32");
        sqlList.add("UPDATE structure set localite_id = 4653 WHERE structure_id = 33");
        sqlList.add("UPDATE structure set localite_id = 4772 WHERE structure_id = 34");
        sqlList.add("UPDATE structure set localite_id = 5005 WHERE structure_id = 35");
        sqlList.add("UPDATE structure set localite_id = 478 WHERE structure_id = 36");
        sqlList.add("UPDATE structure set localite_id = 6603 WHERE structure_id = 37");
        sqlList.add("UPDATE structure set localite_id = 6429 WHERE structure_id = 38");
        sqlList.add("UPDATE structure set localite_id = 6861 WHERE structure_id = 39");
        sqlList.add("UPDATE structure set localite_id = 570 WHERE structure_id = 40");
        sqlList.add("UPDATE structure set localite_id = 800 WHERE structure_id = 41");
        sqlList.add("UPDATE structure set localite_id = 7421 WHERE structure_id = 42");
        sqlList.add("UPDATE structure set localite_id = 7613 WHERE structure_id = 43");
        sqlList.add("UPDATE structure set localite_id = 8284 WHERE structure_id = 44");
        sqlList.add("UPDATE structure set localite_id = 7688 WHERE structure_id = 45");
        sqlList.add("UPDATE structure set localite_id = 7814 WHERE structure_id = 46");
        sqlList.add("UPDATE structure set localite_id = 7976 WHERE structure_id = 47");
        sqlList.add("UPDATE structure set localite_id = 5109 WHERE structure_id = 48");
        sqlList.add("UPDATE structure set localite_id = 5448 WHERE structure_id = 49");
        sqlList.add("UPDATE structure set localite_id = 5596 WHERE structure_id = 50");
        sqlList.add("UPDATE structure set localite_id = 5619 WHERE structure_id = 51");
        sqlList.add("UPDATE structure set localite_id = 5684 WHERE structure_id = 52");
        sqlList.add("UPDATE structure set localite_id = 7087 WHERE structure_id = 53");
        sqlList.add("UPDATE structure set localite_id = 7130 WHERE structure_id = 54");
        sqlList.add("UPDATE structure set localite_id = 7294 WHERE structure_id = 55");
        sqlList.add("UPDATE structure set localite_id = 5841 WHERE structure_id = 56");
        sqlList.add("UPDATE structure set localite_id = 6127 WHERE structure_id = 57");
        sqlList.add("UPDATE structure set localite_id = 6225 WHERE structure_id = 58");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2658");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2659");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2660");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2661");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2662");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2663");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2664");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2665");
        sqlList.add("UPDATE structure set localite_id = 4031 WHERE structure_id = 2666");
        
        
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Bandéo-Naponé' WHERE structure_id = 3009");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Baognè' WHERE structure_id = 3010");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Batondo' WHERE structure_id = 3011");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Bavila' WHERE structure_id = 3012");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Bonyolo' WHERE structure_id = 3013");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Bounga' WHERE structure_id = 3014");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Carrefour' WHERE structure_id = 3015");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de DASSA' WHERE structure_id = 3016");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Didyr' WHERE structure_id = 3017");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Doudou' WHERE structure_id = 3018");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Ekoulkoala' WHERE structure_id = 3019");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Godyr' WHERE structure_id = 3020");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Goundi' WHERE structure_id = 3021");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Gourou' WHERE structure_id = 3022");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Kandarzana' WHERE structure_id = 3023");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Kordié' WHERE structure_id = 3024");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Koukouldi' WHERE structure_id = 3025");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Kya' WHERE structure_id = 3026");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Kyon' WHERE structure_id = 3027");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Laba' WHERE structure_id = 3028");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Mogueya' WHERE structure_id = 3029");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Mousséo' WHERE structure_id = 3030");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Naton' WHERE structure_id = 3031");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Nédialpoun' WHERE structure_id = 3032");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Nemelaye' WHERE structure_id = 3033");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Ninion' WHERE structure_id = 3034");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Perkoa' WHERE structure_id = 3035");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Poa' WHERE structure_id = 3036");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Pouni' WHERE structure_id = 3037");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Pouni-Nord' WHERE structure_id = 3038");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Réo' WHERE structure_id = 3039");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Sémaga' WHERE structure_id = 3040");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Ténado' WHERE structure_id = 3041");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tialgo' WHERE structure_id = 3042");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tienlour' WHERE structure_id = 3043");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tiodié' WHERE structure_id = 3044");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tiogo' WHERE structure_id = 3045");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tita' WHERE structure_id = 3046");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Tiyéllé' WHERE structure_id = 3047");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Valiou' WHERE structure_id = 3048");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Villy-Bongo' WHERE structure_id = 3049");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Zamo' WHERE structure_id = 3050");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Zawara' WHERE structure_id = 3051");
        sqlList.add("UPDATE structure set nomStructure = 'Candidat libre de Zoula' WHERE structure_id = 3052");
        
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3641");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3642");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3643");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3644");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3646");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3647");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3648");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3649");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3650");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3651");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3652");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3653");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3654");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3655");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3656");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3657");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3658");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3659");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3660");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3661");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3662");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3663");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3664");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3665");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3666");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3667");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3668");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3669");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3670");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3671");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3672");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3673");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3674");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3675");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3676");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3677");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3678");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3679");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3680");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3681");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3682");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3683");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3684");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3685");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3686");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3687");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3688");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3690");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3691");
        sqlList.add("UPDATE localite set parentLocalite = 9091 WHERE localite_id = 3692");
        
        
        
        sqlList.add("UPDATE localite set nomLocalite = 'IMASGO' WHERE localite_id = 4021");
        sqlList.add("UPDATE localite set nomLocalite = 'IMASGO' WHERE localite_id = 4023");
        sqlList.add("UPDATE localite set nomLocalite = 'Villy-Bongo' WHERE localite_id = 4258");
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
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9231','Loc8831','4','3983','ZIGA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9232','Loc8832','4','2503','BARGASGHO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9233','Loc8833','4','3021','Pissi')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9234','Loc8834','4','4772','Kampala')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9235','Loc8835','4','4772','Songo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9236','Loc8836','4','4796','Boungou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9237','Loc8837','4','4796','Guenon')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9238','Loc8838','4','4796','Kaya-Navio')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9239','Loc8839','4','4796','Tangassogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9240','Loc8840','4','4874','Guelwongo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9241','Loc8841','4','4874','Toungou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9242','Loc8842','4','5359','TANGAYE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9243','Loc8843','4','5359','ZANRE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9244','Loc8844','4','5841','Noumousso')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9245','Loc8845','4','5841','Doufiguisso')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9246','Loc8846','4','5841','OUOLONKOTO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9247','Loc8847','4','6297','ZOUGO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9248','Loc8848','4','6297','NIOUMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9249','Loc8849','4','6319','IMIOUGOU')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9250','Loc8850','4','6319','SEGUEDIN')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9251','Loc8851','4','6319','BOORE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9252','Loc8852','4','6365','BOULMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9253','Loc8853','4','6390','LOUNGO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9254','Loc8854','4','6408','TEBO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9255','Loc8855','4','6429','ROUMTENGA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9256','Loc8856','4','6429','DOURE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9257','Loc8857','4','6634','ZIGA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9258','Loc8858','4','6861','MINIMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9259','Loc8859','4','6903','ROBA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9260','Loc8860','3','526','NAMISSIGUIMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9261','Loc8861','4','9260','NAMISSIGUIMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9262','Loc8862','4','478','TITAO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9263','Loc8863','4','7673','WAN')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9264','Loc8864','4','4358','SANGA')");
        sqlList.add("INSERT INTO natureHandicap (natureHandicap_id, typeHandicap_id, natureHandicapLibelle) VALUES ('6', '3', 'Moteur')");
        sqlList.add("INSERT INTO prescriptionHandicap (natureHandicap_id, prescription_id) VALUES ('6', '3')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9092','Loc8695','4','1278','KIRA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9093','Loc8696','4','1278','Tiénékuy')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9094','Loc8697','4','1718','BOUNOU/NAYALA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9095','Loc8698','4','1718','KERA/NAYALA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9096','Loc8699','4','1737','BOUNA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9097','Loc8700','4','1477','BWAN')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9098','Loc8701','4','1566','KOSSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9099','Loc8702','4','1537','BLADI')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9100','Loc8703','4','1589','KONGOBA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9101','Loc8704','4','1624','ZEKUY')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9102','Loc8705','4','3704',' Basnéré')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9103','Loc8706','4','3704',' Delga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9104','Loc8707','4','3813',' Silmidougou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9105','Loc8708','4','3764',' Baskoudré/Sanmatenga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9106','Loc8709','4','3764',' Yimiougou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9107','Loc8710','4','9091',' Forgui')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9108','Loc8711','4','9091',' Koutoumtenga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9109','Loc8712','4','9091',' Songodin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9110','Loc8713','4','9091',' Tagalla')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9111','Loc8714','4','9091',' Louda')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9112','Loc8715','4','9091',' Nessemtenga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9113','Loc8716','4','9091',' Boussouma')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9114','Loc8717','4','3895',' Tanyoko')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9115','Loc8718','4','3141',' Bourzanga ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9116','Loc8719','4','3195',' Loagha')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9117','Loc8720','4','3195',' Rissiam')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9118','Loc8721','4','3195',' Temnaoré')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9119','Loc8722','4','3195',' Lourgou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9120','Loc8723','4','3290',' Rouko')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9121','Loc8724','4','3331',' Manègtaba')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9122','Loc8725','4','3182',' Niangouèla')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9123','Loc8726','4','3182',' Guibaré ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9124','Loc8727','4','7113','Tansèga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9125','Loc8728','4','6924','Koankin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9126','Loc8729','4','7007','Koulwéogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9127','Loc8730','4','6924','Nédogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9128','Loc8731','4','7198','Bargo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9129','Loc8732','4','7198','Gounghin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9130','Loc8733','4','7198','Largo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9131','Loc8734','4','7238','Bendogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9132','Loc8735','4','7238','Donsin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9133','Loc8736','4','7238','Silmiougou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9134','Loc8737','4','7258','Watinoma')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9135','Loc8738','4','7258','Signoghin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9136','Loc8739','4','7332','Bissiga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9137','Loc8740','4','7332','Sadaba')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9138','Loc8741','4','7332','Zitenga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9139','Loc8742','4','7294','Laongo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9140','Loc8743','4','7294','Ziga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9141','Loc8744','4','7294','Sonpelcé')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9142','Loc8745','4','7294','Pèlegtenga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9143','Loc8746','4','7170','Gonsin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9144','Loc8747','4','7185','Douré')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9145','Loc8748','4','7130','Sao')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9146','Loc8749','4','7130','Ritigue-Palogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9147','Loc8750','4','7153','Napalgué')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9148','Loc8751','4','7153','Mouni')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9149','Loc8752','4','7688','BAMAKO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9150','Loc8753','4','7814','MEBAR')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9151','Loc8754','4','7862','BOUNI')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9152','Loc8755','4','7862','DAHORE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9153','Loc8756','4','7837','MOU')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9154','Loc8757','4','7951','ZOUOLO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9155','Loc8758','4','8031','KOSSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9156','Loc8759','4','8337','TOBO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9157','Loc8760','4','8284','HOLLY')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9158','Loc8761','4','8284','SIDOUMOUKAR')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9159','Loc8762','4','8613','KOUTENA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9160','Loc8763','4','8520','KORO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9161','Loc8764','4','8520','LOKOSSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9162','Loc8765','4','8520','YEREFOULA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9163','Loc8766','4','2088','SOKOURA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9164','Loc8767','4','2088','SIKANADJO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9165','Loc8768','4','4695','Pissi')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9166','Loc8769','4','4621','Sambin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9167','Loc8770','4','4653','Guirgho')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9168','Loc8771','4','4772','Kampala')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9169','Loc8772','4','4772','Songo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9170','Loc8773','4','4796','Boungou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9171','Loc8774','4','4796','Guenon')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9172','Loc8775','4','4796','Kaya-Navio')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9173','Loc8776','4','4796','Tangassogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9174','Loc8777','4','4874','Guelwongo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9175','Loc8778','4','4874','Toungou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9176','Loc8779','4','4989','Bilbalogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9177','Loc8780','4','6037','OUERE')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9178','Loc8781','4','6066','DAN (KÉNÉDOUGOU)')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9179','Loc8782','4','6076','FARA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9180','Loc8783','4','6105','SILOROLA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9181','Loc8784','4','6225','KARI')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9182','Loc8785','4','6225','KIÉRÉ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9183','Loc8786','4','6238','KAYAO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9184','Loc8787','4','6225','KOHO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9185','Loc8788','4','6225','KARABA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9186','Loc8789','4','5841','FARAKO-BÂ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9187','Loc8790','4','5841','YÉGUÉRESSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9188','Loc8791','4','5841','KOUENTOU')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9189','Loc8792','4','5841','DINGASSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9190','Loc8793','4','5841','LÉGUÉMA')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9191','Loc8794','4','5841','BARÉ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9192','Loc8795','4','5841','SOGOSSAGASSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9193','Loc8796','4','5841','KOTÉDOUGOU')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9194','Loc8797','4','5841','DAFINSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9195','Loc8798','4','5899','SOROBI')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9196','Loc8799','4','5899','YÉGUÉRÉ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9197','Loc8800','4','5899','KARANGASSO-VIGUÉ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9198','Loc8801','4','5841','NASSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9199','Loc8802','4','5841','KOUMI')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9200','Loc8803','4','5841','KOUAKOUALÉ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9201','Loc8804','4','5841','KORO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9202','Loc8805','4','5841','LOGOFOUROUSSO')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9203','Loc8806','4','7007','Tanghin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9204','Loc8807','4','7058','Wayen')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9205','Loc8808','4','7025','Gouhingo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9206','Loc8809','4','7049','Zamsé')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9207','Loc8810','4','7673','WAN')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9208','Loc8811','4','4011','Tanghin Kibraogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9209','Loc8812','4','4049','Boulsin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9210','Loc8813','4','4070','Tampelga')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9211','Loc8814','4','4080','Séguédin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9212','Loc8815','4','4080','Soum')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9213','Loc8816','4','4092','Godo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9214','Loc8817','4','4103','Gogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9215','Loc8818','4','4126','Nabadogogo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9216','Loc8819','4','4139','Séguédin')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9217','Loc8820','4','4153','Rakalo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9218','Loc8821','4','4160','Guirgo             ')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9219','Loc8822','4','4166','Bangré')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9220','Loc8823','4','4166','Sogpelcé')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9221','Loc8824','4','4111','Sambisgo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9222','Loc8825','4','4233','Poa')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9223','Loc8826','4','4259','Baognè')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9224','Loc8827','4','4259','Nédialpoun')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9225','Loc8828','4','4272','Doudou')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9226','Loc8829','4','4490','Névry')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9227','Loc8830','4','4490','Taré')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9228','Loc8831','4','4471','Sapo')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9229','Loc8832','4','2214','KAMBOINSIN')");
        sqlList.add("INSERT INTO localite (localite_id, codeLocalite, typeLocalite_id, parentLocalite, nomLocalite) VALUES('9230','Loc8833','5','9091','Zone 1')");

        
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
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5644', '', '1', '16', '1411', 'CANDIDATS LIBRES DE NOUNA', 'CL NOUNA', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5645', '', '1', '16', '1411', 'CANDIDATS LIBRES DE DJIBASSO', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5646', '', '1', '17', '1477', 'LYCEE PRIVE NAABA BAOGO DE KOUMANA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5647', '', '1', '17', '1506', 'CANDIDATS LIBRES DE DEDOUGOU', 'CL DDG', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5648', '', '1', '17', '1477', 'CANDIDATS LIBRES DE BONDOUKUY', 'CL BDK', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5649', '', '1', '17', '1566', 'CANDIDATS LIBRES DE OURAKOYE', 'CL OUARKOYE', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5650', '', '1', '17', '1548', 'CANDIDATS LIBRES DE KONA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5651', '', '1', '17', '1589', 'CANDIDATS LIBRES DE SAFANE', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5652', '', '1', '17', '1624', 'CANDIDATS LIBRES DE TCHERIBA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5653', '', '1', '15', '1152', 'CANDIDATS LIBRES DE SOLENZO', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5654', '', '1', '15', '1100', 'CANDIDATS LIBRES DE KOUKA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5655', '', '1', '19', '1870', 'CANDIDATS LIBRES DE TOUGAN', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5656', '', '1', '18', '1702', 'CANDIDATS LIBRES DE TOMA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5657', '', '1', '18', '1718', 'CANDIDATS LIBRES DE YABA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5658', '', '1', '18', '1737', 'CANDIDATS LIBRES DE YE', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5659', '', '1', '14', '986', 'CANDIDATS LIBRES DE BOROMO', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5660', '', '1', '14', '995', 'CANDIDATS LIBRES DE FARA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5661', '', '1', '14', '1062', 'CANDIDATS LIBRES DE POURA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5662', '', '1', '14', '1070', 'CANDIDATS LIBRES DE SIBY', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5663', '', '1', '14', '1021', 'CANDIDATS LIBRES DE OURY', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5664', '', '1', '14', '947', 'CANDIDATS LIBRES DE BAGASSI', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5665', '', '1', '14', '975', 'CANDIDATS LIBRES DE BANA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5666', '', '1', '14', '1079', 'CANDIDATS LIBRES DE YAHO', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5667', '', '1', '14', '1041', 'CANDIDATS LIBRES DE PA', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5668', '', '1', '14', '986', 'CANDIDATS LIBRES DE OUAHABOU', '', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5669', '', '1', '17', '1506', 'LYCEE PRIVE DOMINIQUE SYANO KONATE DE DEDOUGOU', 'LPDSK', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5670', '', '1', '15', '1152', 'LYCEE MUNICIPAL DANIEL OUEZZIN COULIBALY', 'LMDOC', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5671', '', '1', '16', '1325', 'COLLEGE D''ENSEIGNEMENT GENERAL DE KAMADENA', 'CEG KAM', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5672', '', '1', '16', '1411', 'LYCEE MUNICIPAL DE NOUNA', 'LM NOUNA', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5673', '', '1', '14', '947', 'CEG DE SAYARO', 'CEG SAYARO', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5674', '', '1', '14', '975', 'CEG DE YONA', 'CEG YONA', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5675', '', '1', '14', '986', 'LM BOROMO', 'LM BOROMO', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5676', '', '1', '14', '1062', 'CEG DE DARSALAM', 'CEG DARSALAM', '')");
        sqlList.add("INSERT INTO  structure ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5677', '', '1', '14', '947', 'LYCÉE DE BOUNOU', 'L BOUNOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5678', '', '1', '14', '986', 'LYCÉE DE BOROMO', 'L BOROMO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5679', '', '1', '14', '986', 'LYCÉE PROVINCIAL DE BOROMO', 'LP BOROMO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5680', '', '1', '14', '1021', 'LYCÉE DE DAH', 'L DAH', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5681', '', '1', '14', '1021', 'LYCÉE DE SÉRÉNA', 'L SÉRÉNA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5682', '', '1', '14', '1070', 'LYCÉE DE SOUHO', 'L. SOUHO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5683', '', '1', '22', '2320', 'Collège Privé Franco-Arabe la Bienfaisance', 'CP Franco Arabe la Bienfaisance', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5684', '', '1', '22', '2320', 'Lycée Privé Renato Grandi', 'Lprenato Grandi', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5685', '', '1', '22', '2214', 'Complexe Scolaire Sainte Théraph', 'CS Sainte Théraph', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5686', '', '1', '22', '2214', 'LYCEE MUNICIPAL DE KOUBRI NAMANEGBA', 'LM NAMANEGBA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5687', '', '1', '22', '2234', 'lycée privé Evangélique Rayi-Zalkem', 'LPE Rayi Zalkem', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5688', '', '1', '22', '2234', 'Lycée privé Evangelique Tarwendpanga', 'LPE Tarwendpanga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5689', '', '1', '22', '2234', 'lycée privé Evangélique Christoin', 'LP Evangélique Christoin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5690', '', '1', '22', '2234', 'lycée privé Evangélique Grâce Divine ', 'LPE Grâce Divine', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5691', '', '1', '22', '2234', 'lycée privé Evangélique Ichtus', 'LPE Ichtus', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5692', '', '1', '22', '2214', 'lycée privé les décideurs de demain ', 'LP décideurs', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5693', '', '1', '22', '2214', 'Complexe Scolaire Privé  Wend Zoodo', 'CSP Wend Zoodo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5694', '', '1', '22', '2214', 'collège privé Gira Imana', 'CP Gira Imana', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5695', '', '1', '22', '2214', 'lycée privé Gueswend-bala HK', 'LP Gueswend-bala HK', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5696', '', '1', '22', '2234', 'CEG municipal de Bangma', 'CEG Municipal Bangma', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5697', '', '1', '22', '2234', 'Lycée privé les Ambitieux', 'LP Ambitieux', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5698', '', '1', '22', '2234', 'lycée privé Evangélique Christoin', 'LP Evangélique Christoin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5699', '', '1', '22', '2215', 'lycée privé les Elus Bounga Zanré ', 'LP Elus Bounga Zanré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5700', '', '1', '22', '2215', 'lycée privé Pierre Joseph la Clorivière', 'LP Pierre J La Clorivière', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5701', '', '1', '22', '2214', 'Juvenat Saint Camille Fille de Dassasgho', 'J St Camille Fille', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5702', '', '1', '22', '2214', 'CEG Municipal de Goughin Sud ', 'CEG Municipal Goughin Sud', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5703', '', '1', '22', '2214', 'collège privé Somnoma', 'CP Somnoma', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5704', '', '1', '22', '2214', 'lycée Sainte Marie de Marcoussis', 'L Ste Marie Marcoussis', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5705', '', '1', '22', '2214', 'lycée privé Guetabamba', 'L P Guetamba', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5706', '', '1', '22', '2214', 'CEG de Toukin', 'CEG Toukin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5707', '', '1', '22', '2214', 'Lycée privé Pass-Yam de Yagma', 'LP Pass-Yam Yagma ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5708', '', '1', '22', '2214', 'lycée privé Siguian', 'LP Siguian', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5709', '', '1', '22', '2214', 'collège privé Naan Fatima', 'CP Naan Fatima', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5710', '', '1', '22', '2214', 'Lycée de Zongo', 'Lycée Zongo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5711', '', '1', '22', '2214', 'Lycée privé Emergence ''C''', 'LP Emergence C', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5712', '', '1', '22', '2214', 'Lycée Municipal Naba Piiga de Dayongo', 'LM Naaba Piiga Dayongo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5713', '', '1', '22', '2214', 'Lycée Daroul Hikmah', 'L Daroul Hikmah', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5714', '', '1', '22', '2214', 'Cours du soir UPA du lycée Municipal Vénégré', 'CS UPA Venegré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5715', '', '1', '22', '2214', 'collège privé Islamique An-nadjah', 'CP Islamique An-nadjah', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5716', '', '1', '22', '2214', 'Lycée privé Gouwendmanegré', 'LP Gouwendmanegré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5717', '', '1', '22', '2214', 'collège privé Wendtoin Lucien', 'CP Wendtoin Lucien', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5718', '', '1', '22', '2214', 'lycée privé Larlé Naaba Tigré', 'LP Larlé Naaba Tigré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5719', '', '1', '22', '2214', 'lycée privé du complexe scolaire Petite Helene', 'LP Complexe scolaire Petite Hélène ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5720', '', '1', '22', '2214', 'Lycée Municipal de Bassinko', 'LM Bassinko ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5721', '', '1', '22', '2214', 'CEG de Sakoula ', 'CEG Sakoula', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5722', '', '1', '22', '2320', 'lycée privé le partenariat de Goundrin', 'LP Partenariat Goundrin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5723', '', '1', '22', '2320', 'Collège privé évangélique Wendpanga Nioko 1', 'CP Evangélique Wendpanga Nioko1', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5724', '', '1', '22', '2271', 'CEG de Peelé', 'CEG Peelé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5725', '', '1', '22', '2271', 'Lycée de Didri', 'Lycée Didri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5726', '', '1', '22', '2320', 'Collège privé Toongr-be-Ne-Wendé', 'CP Toongr-be-ne-Wendé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5727', '', '1', '27', '2553', 'ÉCOLE DÉMOCRATIQUE ET POPULAIRE DE TENKODOGO', 'EDP DE TENKODOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5728', '', '1', '27', '2398', 'CANDIDATS LIBRES DE BAGRÉ', 'CL DE BAGRÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5729', '', '1', '27', '2503', 'CANDIDATS LLIBRES DE BARGASGHO', 'CL DE BARGASGHO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5730', '', '1', '27', '2461', 'CANDIDATS LIBRES DE BITTOU', 'CL DE BITTOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5731', '', '1', '27', '2644', 'CANDIDATS LIBRES DE BISSAYA', 'CL DE BISSAYA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5732', '', '1', '27', '2488', 'CANDIDATS LIBRES DE BOUSSOUMA', 'CL DE BOUSSOUMA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5733', '', '1', '27', '2553', 'CANDIDATS LIBRES DE GANDO', 'CL DE GANDO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5734', '', '1', '27', '2503', 'CANDIDATS LIBRES DE GARANGO', 'CL DE GARANGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5735', '', '1', '27', '2644', 'CANDIDATS LIBRES DE GASSOUGOU', 'CL DE GASSOUGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5736', '', '1', '27', '2533', 'CANDIDATS LIBRES DE KOMTOÈGA', 'CL DE KOMTOÈGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5737', '', '1', '27', '2488', 'CANDIDATS LIBRES DE LENGHA', 'CL DE LENGHA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5738', '', '1', '27', '2503', 'CANDIDATS LIBRES DE LERGHO', 'CL DE LERGHO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5739', '', '1', '27', '2553', 'CANDIDATS LIBRES DE MALENGA-NAGSORÉ', 'CL DE MALENGA-NAGSORÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5740', '', '1', '27', '2545', 'CANDIDATS LIBRES DE NIAOGHO ', 'CL DE NIAOGHO ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5741', '', '1', '27', '2503', 'CANDIDATS LIBRE DE OUARÉGOU', 'CL DE OUARÉGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5742', '', '1', '27', '2553', 'CANDIDATS LIBRES DE OUÉGUÉDO', 'CL DE OUÉGUÉDO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5743', '', '1', '27', '2553', 'CANDIDATS LIBRES DE OUÉLOGUIN', 'CL DE OUÉLOGUIN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5744', '', '1', '27', '2553', 'CANDIDATS LIBRES DE OUNZÉOGO', 'CL DE OUNZÉOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5745', '', '1', '27', '2503', 'CANDIDATS LIBRES DE SANOGHO', 'CL DE SANOGHO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5746', '', '1', '27', '2553', 'CANDIDATS LIBRES DE TENKODOGO', 'CL DE TENKODOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5747', '', '1', '27', '2644', 'CANDIDATS LIBRES DE WANGALA', 'CL DE WANGALA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5748', '', '1', '27', '2644', 'CANDIDATS LIBRES DE YOUNGOU', 'CL DE YOUNGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5749', '', '1', '27', '2644', 'CANDIDATS LIBRES DE ZABRÉ', 'CL DE ZABRÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5750', '', '1', '27', '2553', 'CANDIDATS LIBRES DE ZANO', 'CL DE ZANO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5751', '', '1', '27', '2503', 'CANDIDATS LIBRES DE ZIGLA-KOULPÉLÉ', 'CL DE ZIGLA-KOULPÉLÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5752', '', '1', '27', '2686', 'CANDIDATS LIBRES DE ZOAGA', 'CL DE ZOAGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5753', '', '1', '27', '2700', 'CANDIDATS LIBRES DE ZONSÉ', 'CL DE ZONSÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5754', '', '1', '28', '2870', 'COURS DU SOIR EXCELLENCE DE CINKANSÉ', 'CSEC', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5755', '', '1', '28', '2724', 'CANDIDATS LIBRES DE COMIN-YANGA', 'CL DE COMIN-YANGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5756', '', '1', '28', '2870', 'CANDIDATS LIBRES DE CINKANSÉ', 'CL DE CINKANSÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5757', '', '1', '28', '2759', 'CANDIDATS LIBRES DE DOURTENGA', 'CL DE DOURTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5758', '', '1', '28', '2772', 'CANDIDATS LIBRES DE LALGAYE', 'CL DE LALGAYE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5759', '', '1', '28', '2788', 'CANDIDATS LIBRES DE OUARGAYE', 'CL DE OUARGAYE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5760', '', '1', '28', '2801', 'CANDIDATS LIBRES DE SANGA', 'CL DE SANGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5761', '', '1', '28', '2870', 'CANDIDATS LIBRES DE YARGATENGA', 'CL DE YARGATENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5762', '', '1', '28', '2886', 'CANDIDATS LIBRES DE YONDÉ', 'CL DE YONDÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5763', '', '1', '29', '3039', 'COURS DU SOIR CERFI', 'CS/CERFI DE KOUPÉLA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5764', '', '1', '29', '3039', 'CANDIDATS LIBRES DU KOURITTENGA', 'CL DU KOURITTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5765', '', '1', '29', '2912', 'CANDIDATS LIBRES DE ANDEMTENGA', 'CL DE ANDEMTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5766', '', '1', '29', '2912', 'CANDIDATS LIBRES DE GUÉFOURGOU', 'CL DE GUÉFOURGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5767', '', '1', '29', '2912', 'CANDIDATS LIBRES DE OUENGA', 'CL DE OUENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5768', '', '1', '29', '2912', 'CANDIDATS LIBRES DE SABRABINATENGA', 'CL DE SABRABINATENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5769', '', '1', '29', '2912', 'CANDIDATS LIBRES DE FINOUGOU', 'CL DE FINOUGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5770', '', '1', '29', '2912', 'CANDIDATS LIBRES DE TAMBOGO', 'CL DE TAMBOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5771', '', '1', '29', '2912', 'CANDIDATS LIBRES DE SONGRÉTENGA', 'CL DE SONGRÉTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5772', '', '1', '29', '2939', 'CANDIDATS LIBRES DE BASKOURÉ', 'CL DE BASKOURÉ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5773', '', '1', '29', '2939', 'CANDIDATS LIBRES DE NAKABA', 'CL DE NAKABA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5774', '', '1', '29', '2949', 'CANDIDATS LIBRES DE DIALGAYE', 'CL DE DIALGAYE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5775', '', '1', '29', '2949', 'CANDIDATS LIBRES DE DAGAMTENGA', 'CL DE DAGAMTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5776', '', '1', '29', '2949', 'CANDIDATS LIBRES DE DASSUI', 'CL DE DASSUI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5777', '', '1', '29', '2949', 'CANDIDATS LIBRES DE LIOULGOU', 'CL DE LIOULGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5778', '', '1', '29', '2949', 'CANDIDATS LIBRES DE NÉNÉOGO', 'CL DE NÉNÉOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5779', '', '1', '29', '2949', 'CANDIDATS LIBRES DE ZÉGUÉDÉGA', 'CL DE ZÉGUÉDÉGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5780', '', '1', '29', '2979', 'CANDIDATS LIBRES DE GOUNGHIN', 'CL DE GOUNGHIN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5781', '', '1', '29', '2979', 'CANDIDATS LIBRES DE KABÈGA', 'CL DE KABÈGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5782', '', '1', '29', '3021', 'CANDIDATS LIBRES DE KANDO', 'CL DE KANDO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5783', '', '1', '29', '3039', 'CANDIDATS LIBRES DE KOUPÉLA', 'CL DE KOUPÉLA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5784', '', '1', '29', '3039', 'CANDIDATS LIBRES DE LIGUIDI MALGUEM', 'CL DE LIGUIDI MALGUEM', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5785', '', '1', '29', '3039', 'CANDIDATS LIBRES DE ZAOGO', 'CL DE ZAOGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5786', '', '1', '29', '3078', 'CANDIDATS LIBRES DE POUYTENGA', 'CL DE POUYTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5787', '', '1', '29', '3095', 'CANDIDATS LIBRES DE TENSOBTENGA', 'CL DE TENSOBTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5788', '', '1', '29', '3122', 'CANDIDATS LIBRES DE YARGO', 'CL DE YARGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5789', '', '1', '29', '3122', 'CANDIDATS LIBRES DE KOKOSSE TANDAGA', 'CL DE KOKOSSE TANDAGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5790', '', '1', '29', '3122', 'CANDIDATS LIBRES DE KANOUGOU', 'CL DE KANOUGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5791', '', '1', '31', '3400', 'Collège d''Enseignement Général de Boala', 'CEG de Boala', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5792', '', '1', '31', '3400', 'Collège d''Enseignement Général de Lédéré', 'CEG de Lédéré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5793', '', '1', '31', '3400', 'Lycée Départemental de Boala', 'LD de Boala', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5794', '', '1', '31', '3400', 'Candidats Libres de Boala', 'CL de Boala', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5795', '', '1', '31', '3413', 'Collège d''Enseignement Général de Banrin', 'CEG de Banrin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5796', '', '1', '31', '3413', 'Collège d''Enseignement Général de Bèlga', 'CEG de Bèlga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5797', '', '1', '31', '3413', 'Collège d''Enseignement Général de Bonam', 'CEG de Bonam', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5798', '', '1', '31', '3413', 'Collège d''Enseignement Général de Boulsa', 'CEG de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5799', '', '1', '31', '3413', 'Collège d''Enseignement Général de Mokin', 'CEG de Mokin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5800', '', '1', '31', '3413', 'Collège d''Enseignement Général de Nièga', 'CEG de Nièga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5801', '', '1', '31', '3413', 'Collège d''Enseignement Général de Yargo', 'CEG de Yargo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5802', '', '1', '31', '3413', 'Collège d''Enseignement Général de Zambanga', 'CEG de Zambanga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5803', '', '1', '31', '3413', 'Collège d''Enseignement Général de Zomnogo-Mossi', 'CEG de Zomnogo-Mossi', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5804', '', '1', '31', '3413', 'Lycée Départemental de Boulsa', 'LD de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5805', '', '1', '31', '3413', 'Lycée Municipal de Boulsa', 'LM de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5806', '', '1', '31', '3413', 'Lycée Provincial de Boulsa', 'LP de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5807', '', '1', '31', '3413', 'Lycée Professionnel JAN VERVOORT de Boulsa', 'LPJV de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5808', '', '1', '31', '3413', 'Collège Privé Gueswendé de Boulsa', 'CPrG de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5809', '', '1', '31', '3413', 'Collège Privé La Sagesse de Boulsa', 'CPrLS Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5810', '', '1', '31', '3413', 'Lycée Privé La Référence de Boulsa', 'LPrLR Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5811', '', '1', '31', '3413', 'Lycée Privé RELWENDE de Boulsa', 'LPrR de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5812', '', '1', '31', '3413', 'Lycée Privé PAAM-PAONGO de Zambanga', 'LPrP de Zambanga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5813', '', '1', '31', '3413', 'Candidats Libres de Boulsa', 'CL de Boulsa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5814', '', '1', '31', '3413', 'Candidats Libres de Nièga', 'CL de Nièga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5815', '', '1', '31', '3447', 'Lycée Départemental de Bouroum', 'LD de Bouroum', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5816', '', '1', '31', '3447', 'Candidats Libres de Bouroum', 'CL Bouroum', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5817', '', '1', '31', '3481', 'Collège d''Enseignement Général de Boko', 'CEG de Boko', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5818', '', '1', '31', '3481', 'Collège d''Enseignement Général de Dargo', 'CEG de Dargo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5819', '', '1', '31', '3481', 'Collège d''Enseignement Général de Kogosablogo', 'CEG de Kogosablogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5820', '', '1', '31', '3481', 'Collège d''Enseignement Général de Kossodin', 'CEG de Kossodin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5821', '', '1', '31', '3481', 'Collège d''Enseignement Général de Yaongo', 'CEG de Yaongo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5822', '', '1', '31', '3481', 'Lycée Départemental de Dargo', 'LD de Dargo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5823', '', '1', '31', '3481', 'Candidats Libres de Dargo', 'CL de Dargo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5824', '', '1', '31', '3499', 'Collège d''Enseignement Général de Kouini', 'CEG de Kouini', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5825', '', '1', '31', '3499', 'Lycée Départemental de Nagbingou', 'LD de Nagbingou', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5826', '', '1', '31', '3499', 'Candidats Libres de Nagbingou', 'CL de Nagbingou', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5827', '', '1', '31', '3514', 'Collège d''Enseignement Général de Dabossomnoré', 'CEG de Dabossomnoré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5828', '', '1', '31', '3514', 'Collège d''Enseignement Général de Taffogo', 'CEG de Taffogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5829', '', '1', '31', '3514', 'Collège d''Enseignement Général de Tougouri', 'CEG de Tougouri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5830', '', '1', '31', '3514', 'Collège d''Enseignement Général de Toyogdin', 'CEG de Toyogdin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5831', '', '1', '31', '3514', 'Lycée Départemental de Tougouri', 'LD de Tougouri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5832', '', '1', '31', '3514', 'Lycée Privé Marie Gabrielle de Tougouri', 'LPrMG de Tougouri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5833', '', '1', '31', '3514', 'Lycée Privé Source d''Espoir de Tougouri', 'LPrSE de Tougouri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5834', '', '1', '31', '3514', 'Candidats Libres de Tougouri', 'CL de Tougouri', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5835', '', '1', '31', '3550', 'Collège d''Enseignement Général de Taparko', 'CEG de Taparko', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5836', '', '1', '31', '3550', 'Collège d''Enseignement Général de Yalgo', 'CEG de Yalgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5837', '', '1', '31', '3550', 'Lycée Départemental de Yalgo', 'LD de Yalgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5838', '', '1', '31', '3550', 'Collège Privé Catholique Valentina Giumelli  de Yalgo', 'CPrCVG de Yalgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5839', '', '1', '31', '3550', 'Collège Privé les Elites Naba Bouly de Yalgo', 'CPrENB de Yalgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5840', '', '1', '31', '3550', 'Candidats Libres de Yalgo', 'CL de Yalgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5841', '', '1', '31', '3561', 'Collège d''Enseignement Général de Boumtenga', 'CEG de Boumtenga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5842', '', '1', '31', '3561', 'Collège d''Enseignement Général de Lilougou', 'CEG de Lilougou', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5843', '', '1', '31', '3561', 'Collège d''Enseignement Général de Zéguédéguin', 'CEG de Zéguédéguin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5844', '', '1', '31', '3561', 'Lycée Départemental de Zéguédéguin', 'LD de Zéguédéguin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5845', '', '1', '31', '3561', 'Candidats Libres de  Zéguédéguin', 'CL de Zéguédéguin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5846', '', '1', '23', '4011', 'Lycée de Tanghin Kibraogo', 'L. Tanghin Kibraogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5847', '', '1', '23', '4049', 'Collège d''Enseignement général de Boulsin', 'CEG de Boulsin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5848', '', '1', '23', '4070', 'Collège d''Enseignement général de Tampelga', 'CEG de Tampelga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5849', '', '1', '23', '4080', 'Collège d''Enseignement général de Séguédin', 'CEG de Séguédin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5850', '', '1', '23', '4080', 'Lycée de Soum', 'L. Soum', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5851', '', '1', '23', '4092', 'Collège d''Enseignement général de Godo', 'CEG de Godo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5852', '', '1', '23', '4103', 'Collège d''Enseignement général de Gogo', 'CEG de Gogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5853', '', '1', '23', '4126', 'Collège d''Enseignement général de Nabadogogo', 'CEG de Nabadogogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5854', '', '1', '23', '4139', 'Collège d''Enseignement général de Séguédin', 'CEG de Séguédin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5855', '', '1', '23', '4153', 'Collège d''Enseignement général de Rakalo', 'CEG de Rakalo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5856', '', '1', '23', '4160', 'Collège d''Enseignement général de Guirgo', 'CEG de Guirgo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5857', '', '1', '23', '4166', 'Collège d''Enseignement général de Bangré', 'CEG de Bangré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5858', '', '1', '23', '4166', 'Lycée de Sogpelcé', 'L. Sogpelcé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5859', '', '1', '25', '4314', 'Lycée Départemental de Biéha', 'LD Biéha', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5860', '', '1', '25', '4314', 'Collège d''Enseignement Général de Biéha', 'CEG Biéha', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5861', '', '1', '25', '4314', 'Collège d''Enseignement Général de Koumbogoro', 'CEG Koumbogoro', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5862', '', '1', '25', '4314', 'Collège d''Enseignement Général de Koumbo', 'CEG Koumbo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5863', '', '1', '25', '4314', 'Collège d''Enseignement Général de Néboun', 'CEG Néboun', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5864', '', '1', '25', '4314', 'Collège d''Enseignement Général de Yallé', 'CEG Yallé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5865', '', '1', '25', '4314', 'Collège d''Enseignement Général de Prata', 'CEG Prata', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5866', '', '1', '25', '4314', 'Collège d''Enseignement Général Batoini Jean-Robert NIGNAN de Yelbouga', 'CEG Yelbouga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5867', '', '1', '25', '4314', 'Lycée Privé Shémida de Néboun', 'LP Shémida', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5868', '', '1', '25', '4314', 'Collège Privé de Livara', 'CP Livara', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5869', '', '1', '25', '4314', 'Candidats libres de Biéha', 'CL Biéha', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5870', '', '1', '25', '4314', 'Candidats libres de Koumbogoro', 'CL Koumbogoro', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5871', '', '1', '25', '4314', 'Candidats libres de Koumbo', 'CL Koumbo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5872', '', '1', '25', '4314', 'Candidats libres de Néboun', 'CL Néboun', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5873', '', '1', '25', '4314', 'Candidats libres de  Yallé', 'CL  Yallé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5874', '', '1', '25', '4314', 'Candidats libres de Prata', 'CL  Prata', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5875', '', '1', '25', '4314', 'Candidats libres du Collège d''Enseignement Général Batoini Jean-Robert NIGNAN de Yelbouga', 'CL  Yelbouga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5876', '', '1', '25', '4314', 'Collége d''Enseignement Général de Pissaï', 'CEG Pissaï', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5877', '', '1', '25', '4314', 'Candidats libres de Pissaï', 'CL Pissaï', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5878', '', '1', '24', '4233', 'Collège d''Enseignement Général de Poa', 'CEG de Poa', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5879', '', '1', '24', '4259', 'Collège d''Enseignement Général de Baognè', 'CEG de Baognè', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5880', '', '1', '24', '4259', 'Collège d''Enseignement Général de Nédialpoun', 'CEG de Nédialpoun', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5881', '', '1', '24', '4272', 'Lycée de Doudou', 'Lycée de Doudou', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5882', '', '1', '26', '4534', 'LYCEE PROVINCIAL DE SAPOUY', 'L.P. SAPOUY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5883', '', '1', '26', '4534', 'LYCEE DEPARTEMENTAL DE SAPOUY', 'L.D. SAPOUY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5884', '', '1', '26', '4534', 'LYCEE MUNICIPAL DE SAPOUY', 'L.M. SAPOUY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5885', '', '1', '26', '4534', 'COLLEGE D''ENSEIGNEMENT GENERAL DU SECTEUR 2 DE SAPOUY', 'CEG DU SECTEUR 2/SAPOUY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5886', '', '1', '26', '4534', 'COLLEGE D''ENSEIGNEMENT GENERAL DE TIARE', 'CEG DE TIARE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5887', '', '1', '26', '4534', 'COLLEGE D''ENSEIGNEMENT GENERAL DE BAOUIGA', 'CEG DE BAOUIGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5888', '', '1', '26', '4534', 'COLLEGE D''ENSEIGNEMENT GENERAL DE POUN', 'CEG DE POUN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5889', '', '1', '26', '4534', 'COLLEGE D''ENSEIGNEMENT GENERAL DE NAPO-NABILPAGA', 'CEG DE NAPO-NABILPAGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5890', '', '1', '26', '4534', 'LYCEE PRIVE CATHOLIQUE MICHELLE GUILLAUME', 'L.P.C. MICHELLE GUILLAUME', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5891', '', '1', '26', '4534', 'LYCEE PRIVE LE SUCCES', 'L.P. LE SUCCES', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5892', '', '1', '26', '4534', 'LYCEE PRIVE SAINT AURIEL', 'L.P. ST AURIEL', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5893', '', '1', '26', '4534', 'LYCEE PRIVE GREAT PROVIDER ACADEMY', 'L.P. GPA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5894', '', '1', '26', '4534', 'LYCEE PRIVE WEND-PANGA', 'L.P. WEND-PANGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5895', '', '1', '26', '4534', 'LYCEE PRIVE AICHA', 'L.P. AICHA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5896', '', '1', '26', '4534', 'LYCEE PRIVE EVANGELIQUE EL ADONAI', 'L.P. EL ADONAI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5897', '', '1', '26', '4534', 'LYCEE PRIVE LA PERSEVERANCE', 'L.P. LA PERSEVERANCE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5898', '', '1', '26', '4534', 'COLLEGE PRIVE LE PINAL', 'C.P. LE PINAL', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5899', '', '1', '26', '4534', 'COLLEGE PRIVE LA GRACE', 'C.P. LA GRACE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5900', '', '1', '26', '4534', 'COLLEGE PRIVE LA SAGESSE', 'C.P. LA SAGESSE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5901', '', '1', '26', '4534', 'COLLEGE PRIVE DE L''ESPOIR', 'C.P. L''ESPOIR', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5902', '', '1', '26', '4534', 'COLLEGE PRIVE YIPENE', 'C.P. YIPENE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5903', '', '1', '26', '4534', 'COLLEGE PRIVE JATHNIEL PLUS', 'C.P. JATHNIEL PLUS', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5904', '', '1', '26', '4534', 'COLLEGE PRIVE YIBADOIN', 'C.P. YIBADOIN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5905', '', '1', '26', '4534', 'COLLEGE PRIVE L''EXCELLENCE', 'C.P. EXCELLENCE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5906', '', '1', '26', '4534', 'COURS DU SOIR LE SUCCES', 'COUR DU SOIR LE SUCCES', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5907', '', '1', '26', '4534', 'CANDIDATS LIBRES DE SAPOUY', 'CL SAPOUY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5908', '', '1', '26', '4534', 'CANDIDATS LIBRES BAOUIGA', 'CL BAOUIGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5909', '', '1', '26', '4490', 'LYCEE DEPARTEMENTAL DE CASSOU', 'L.D. CASSOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5910', '', '1', '26', '4490', 'LYCEE COMMUNAL DE CASSOU', 'L.C. CASSOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5911', '', '1', '26', '4490', 'COLLEGE D''ENSEIGNEMENT GENERAL DE TARE', 'CEG DE TARE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5912', '', '1', '26', '4490', 'COLLEGE D''ENSEIGNEMENT GENERAL DE NEVRY', 'CEG DE NEVRY', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5913', '', '1', '26', '4490', 'COLLEGE D''ENSEIGNEMENT GENERAL DE OUAYOU', 'CEG DE OUAYOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5914', '', '1', '26', '4490', 'COLLEGE D''ENSEIGNEMENT GENERAL DE THIAO', 'CEG DE THIAO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5915', '', '1', '26', '4490', 'COLLEGE D''ENSEIGNEMENT GENERAL DE KONDUI', 'CEG DE KONDUI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5916', '', '1', '26', '4490', 'COLLEGE PRIVE DU COMPLEXE SCOLAIRE CHLOE DE CASSOU', 'C.P. CHLOE DE CASSOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5917', '', '1', '26', '4490', 'COLLEGE PRIVE TEEGAWENDE DE VRASSAN', 'C.P. TEEGAWENDE DE VRASSAN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5918', '', '1', '26', '4490', 'CANDIDATS LIBRES DE CASSOU', 'CL CASSOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5919', '', '1', '26', '4490', 'CANDIDATS LIBRES DE TARE', 'CL TARE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5920', '', '1', '26', '4471', 'COLLEGE D''ENSEIGNEMENT GENERAL DE SAPO', 'CEG DE SAPO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5921', '', '1', '26', '4471', 'CANDIDATS LIBRES DE SAPO', 'CL SAPO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5922', '', '1', '33', '4653', 'Lycée Naaba Boulga de Guirgho', 'LNB de Guirgho', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5923', '', '1', '33', '4653', 'Collège privé la Solidarité', 'CP la Solidarité', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5924', '', '1', '33', '4621', 'Collège d''Enseignement Général de Sambin', 'CEG de Sambin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5925', '', '1', '33', '4695', 'Lycée de Pissi', 'L Pissi', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5926', '', '1', '34', '4757', 'Collège d''Enseignement Général de Boala', 'CEG de Boala', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5927', '', '1', '35', '4899', 'Collège d''Enseignement Général de Sondré', 'CEG de Sondré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5928', '', '1', '35', '4989', 'Collège d''Enseignement Général de Koakin', 'CEG de Koakin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5929', '', '1', '35', '4989', 'Collège d''Enseignement Général de Boura', 'CEG de Boura', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5930', '', '1', '35', '4989', 'Lycée Naaba Kaongo de Bilbalogo', 'LNK de Bilbalogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5931', '', '1', '35', '4938', 'Collège d''Enseignement Général de Kopelin', 'CEG de Kopelin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5932', '', '1', '35', '5005', 'Collège d''Enseignement Général de Siltouko', 'CEG de Siltouko', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5933', '', '1', '35', '5005', 'Collège d''Enseignement Général de Koulpeuloghin', 'CEG de Koulpeuloghin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5934', '', '1', '35', '5017', 'Collège d''Enseignement Général de Tampouy', 'CEG de Tampouy', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5935', '', '1', '35', '5017', 'Collège privé Pagnibsome de Zanghin', 'CPP de Zanghin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5936', '', '1', '35', '5017', 'Lycée de Seloghin', 'L de Seloghin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5937', '', '1', '58', '6225', 'Lycée de Kari', 'Lycée de Kari', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5938', '', '1', '58', '6225', 'Collège d''Enseignement Général de Kiéré', 'CEG de Kiéré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5939', '', '1', '58', '6238', 'Collège d''Enseignement Général de Kayao', 'CEG de Kayao', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5940', '', '1', '58', '6225', 'Collège d''Enseignement Général de Koho', 'CEG de Koho', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5941', '', '1', '58', '6225', 'Collège d''Enseignement Général de Karaba', 'CEG de Karaba', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5942', '', '1', '56', '5990', 'Lycée Privé Norbert Oula', 'LPNO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5943', '', '1', '56', '5899', 'CL Karangasso-Vigué', 'CL/KV', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5944', '', '1', '38', '6297', 'CEG DE ZOUGO', 'CEG DE ZOUGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5945', '', '1', '38', '6408', 'CEG DE TEBO', 'CEG DE TEBO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5946', '', '1', '38', '6429', 'CEG DE DOURE', 'CEG DE DOURE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5947', '', '1', '38', '6429', 'CEG DE ROUMTENGA', 'CEG DE ROUMTENGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5948', '', '1', '37', '6459', 'COLLEGE D''ENSEIGNEMENT GENERAL DE DINGUIRI', 'CEG DE DINGUIRI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5949', '', '1', '37', '3852', 'COLLEGE D''ENSEIGNEMENT GENERAL DE KONONGA', 'CEG DE KONONGA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5950', '', '1', '37', '3852', 'COLLEGE D''ENSEIGNEMENT GENERAL MOGOMBOULI', 'CEG DE MOGOMBOULI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5951', '', '1', '37', '3852', 'COLLEGE D''ENSEIGNEMENT GENERA DE NAMISSIGUIMA', 'CEG DE NAMISSIGUIMA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5952', '', '1', '37', '3852', 'LYCEE COMMUNAL DE TOUGOU', 'LC TOUGOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5953', '', '1', '38', '6390', 'CEG DE LOUNGO', 'CEG DE LOUNGO', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5954', '', '1', '37', '3852', 'LYCEE DEPARTEMENTAL DE NAMISSIGUIMA', 'LD NAMISSIGUIMA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5955', '', '1', '53', '6994', 'CEG de Tollingui', 'CEG Tol', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5956', '', '1', '53', '7007', 'CEG de Koulwéogo', 'CEG Koul', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5957', '', '1', '53', '6924', 'CL de OUAYALGUI V2', 'CL OUAY V2', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5958', '', '1', '53', '7007', 'CL Kougdoughin', 'CL Kougd', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5959', '', '1', '53', '7058', 'CL Rapadama', 'CL Rap', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5960', '', '1', '54', '7170', 'Lycée de Gonsin', 'L.Gsn', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5961', '', '1', '54', '7185', 'Collègue d''Enseignement Général de Douré', 'CEG de Douré ', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5962', '', '1', '54', '7130', 'Collègue d''Enseignement Général de Sao', 'CEG de Sao', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5963', '', '1', '54', '7130', 'Collègue d''Enseignement Général de Ritigue-Palogo', 'CEG de Ritigue-Palogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5964', '', '1', '54', '7153', 'Collègue d''Enseignement Général de Napalgué', 'CEG Napalgué', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5965', '', '1', '54', '7153', 'Lycée de Mouni', 'L.de Mouni', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5966', '', '1', '42', '7421', 'LYCEE MUNICIPAL DE DORI', 'LM DORI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5967', '', '1', '42', '7421', 'LYCEE DEPARTEMENTAL DE DORI', 'LD DORI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5968', '', '1', '42', '7421', 'LYCEE MUNICIPAL DOCTEUR SALIFOU DIALLO', 'LMDS DORI', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5969', '', '1', '42', '7421', 'LYCEE DE WENDOU', 'LYCEE DE WENDOU', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5970', '', '1', '42', '7421', 'COLLEGE  D''ENSEIGNEMENT GENERAL DE NYARALA', 'CEG DE NYARALA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5971', '', '1', '40', '570', 'CANDIDATS LIBRES MARKOYE', 'CL MARKOYE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5972', '', '1', '22', '2214', 'cours du soir de l''amitié', ' Cours du soir Amitié', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5973', '', '1', '22', '2214', 'CEG Municipal de Goughin Sud ', 'CEG Municipal Goughin Sud', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5974', '', '1', '22', '2214', 'groupe scolaire Boblawendé', 'GS Boblawendé', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5975', '', '1', '22', '2214', 'complexe scolaire Bass-Yiiré', 'C S Bass Yirré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5976', '', '1', '22', '2214', 'CEG municipal de Ouidtenga', 'CEG municipal Ouidtenga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5977', '', '1', '22', '2214', 'collège privé Israêl', 'CP Israêl', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5978', '', '1', '22', '2214', 'lycée privé Mixte  Wend Yam ', 'LP Mixte Wend Yam', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5979', '', '1', '22', '2214', 'collège privé Evangélique Nabasnogo', 'CPE Nabasnogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5980', '', '1', '22', '2214', 'Complexe Scolaire Sainte Théraph', 'CS Sainte Théraph', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5981', '', '1', '22', '2214', 'CANDIDATS LIBRES DE KAMBOINSE', 'CL Kamboinsin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5982', '', '1', '22', '2214', 'CANDIDATS LIBRES DU COURS DU SOIR KAMTENGA', 'CL Cours du soir Kamtenga', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5983', '', '1', '22', '2214', 'COURS DU SOIR LYCEE PRIVE DU FUTUR', 'CS LP du Futur', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5984', '', '1', '22', '2214', 'LYCEE DE JEUNES FILLES DE KAMBOINSE', 'lycée Jeunes filles Kamboinsin', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5985', '', '1', '22', '2214', 'LYCEE PRIVE BELEMTIISE', 'LYCEE PRIVE BELEMTIISE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5986', '', '1', '22', '2214', 'LYCEE PRIVE LA GENESE DE WOBRIGRE', 'LYCEE PRIVE LA GENESE DE WOBRIGRE', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5987', '', '1', '16', '1411', 'LYCEE PROVINCIAL DE NOUNA', 'LPN', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5988', '', '1', '16', '1411', 'CENTRE DE FORMATION PROFESSIONNEL FRANCO-ARABE', 'CFPFA', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5989', '', '1', '17', '1506', 'LYCEE PRIVE PINGDWINDE', 'LPP', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5990', '', '1', '24', '4239', 'Collège d''Enseignement Général de Villy-Bongo', 'CEG de Villy-Bongo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5991', '', '1', '53', '6994', 'CEG de Tollingui', 'CEG Tol', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5992', '', '1', '53', '7007', 'CEG de Koulwéogo', 'CEG Koul', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5993', '', '1', '53', '6924', 'CL de OUAYALGUI V2', 'CL OUAY V2', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5994', '', '1', '53', '7007', 'CL Kougdoughin', 'CL Kougd', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5995', '', '1', '53', '7058', 'CL Rapadama', 'CL Rap', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5996', '', '1', '54', '7170', 'Lycée de Gonsin', 'L.Gsn', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5997', '', '1', '54', '7185', 'Collègue d'Enseignement Général de Douré', 'CEG de Douré', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5998', '', '1', '54', '7130', 'Collègue d'Enseignement Général de Sao', 'CEG de Sao', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('5999', '', '1', '54', '7130', 'Collègue d'Enseignement Général de Ritigue-Palogo', 'CEG de Ritigue-Palogo', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6000', '', '1', '54', '7153', 'Collègue d'Enseignement Général de Napalgué', 'CEG Napalgué', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6001', '', '1', '54', '7153', 'Lycée de Mouni', 'L.de Mouni', '')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6002', '', '1', '53', '6924', 'CEG de Nédogo', 'CGE NDG', '')");
        
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6003',' ','1','17','1506','COURS  DU SOIR EVEIL','C SOIR EVEIL','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6004',' ','1','17','1506','COURS  DU SOIR CSPE','CS CSPE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6005',' ','1','17','1506','LYCEE PRIVE CREUSET D EVEIL','LPCE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6006',' ','1','24','4175','Lycée Départemental de Dassa','LD DASSA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6007',' ','1','24','4175','Collège Enseignement Général de Dassa','CEG DE DASSA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6008',' ','1','24','4175','Collège Enseignement Général de Doh','CEG DE DOH','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6009',' ','1','24','4175','Collège Enseignement Général de Farba','CEG DE Farba','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6010',' ','1','24','4183','Collège Enseignement Général de Didyr','CEG DE DIDYR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6011',' ','1','24','4183','Collège Enseignement Général de Mousséo','CEG DE MOUSSEO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6012',' ','1','24','4183','Collège Enseignement Général de Pouni-Nord','CEG POUNI NORD','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6013',' ','1','24','4183','Collège Enseignement Général de Lapio','CED DE LAPIO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6014',' ','1','24','4183','Collège Enseignement Général de Youloupo','CEG DE YOULOUPO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6015',' ','1','24','4183','Collège Enseignement Général de Mogueya','CEG DE MOGUEYA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6016',' ','1','24','4183','Collège Enseignement Général de Kya','CEG DE KYA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6017',' ','1','24','4183','Lycée Départemental de Didyr','L.D DIDYR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6018',' ','1','24','4183','Lycée privé Catholique La Sagesse de Didyr','LP LA SAGESSE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6019',' ','1','24','4183','Lycée privé Les Elites Jean Paul de Didyr','LP LES ELITES','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6020',' ','1','24','4183','Lycée privé Nabonswendé de Mogueya','LP NABONSWENDE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6021',' ','1','24','4183','Lycée privé Kélègnin de Didyr','LP KELEGNIN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6022',' ','1','24','4200','Collège Enseignement Général de Bissou','CEG de Bissou','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6023',' ','1','24','4200','Collège Enseignement Général de Godyr','CEG de Godyr','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6024',' ','1','24','4200','Lycée de Gourou','Lycée de GOUROU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6025',' ','1','24','4200','Collège Enseignement Général de Semaga','CEG de Semaga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6026',' ','1','24','4200','Collège Enseignement Général de Konega','CEG de konega','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6027',' ','1','24','4200','Lycée de Tienlour','Lycée de Tienlour','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6028',' ','1','24','4200','Lycée de Kandarzana','Lycée de Kandarzana','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6029',' ','1','24','4200','Lycée Départemental de Godyr','L. D GODYR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6030',' ','1','24','4200','Collège privé Payidnaba de Godyr','CP PAYIDNABA ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6031',' ','1','24','4216','Lycée de Kordié','Lycée de Kordié','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6032',' ','1','24','4216','Collège Enseignement Général de Ninion','CEG de Ninion','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6033',' ','1','24','4216','Lycée Départemental de Kordié','L. D KORDIE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6034',' ','1','24','4216','Collège privé Yiworèga de Kordié','CP YIWOREGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6035',' ','1','24','4216','Collège privé Zood-Nooma de Kordié','CP ZOOD-NOOMA ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6036',' ','1','24','4233','Collège Enseignement Général de Kyon','CEG de Kyon','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6037',' ','1','24','4233','Collège Enseignement Général de Nagarpoulou','CEG NAGARPOULOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6038',' ','1','24','4233','Lycée Départemental de Kyon','L. D Kyon','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6039',' ','1','24','4233','Collège privé Sainte Inès de Kyon','CP STE INES','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6040',' ','1','24','4233','Lycée privé Piayiboula de Kyon','L.P PIAYIBOULA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6041',' ','1','24','4174','Collège Enseignement Général de Tita','CEG DE TITA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6042',' ','1','24','4174','Collège Enseignement Général de Bandéo-Naponé','CEG de Bandéo-Naponé','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6043',' ','1','24','4174','Collège Enseignement Général de Baganapoun','CEG BAGANAPOUN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6044',' ','1','24','4174','Collège Enseignement Général de Naton','CEG de Naton','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6045',' ','1','24','4174','Collège Enseignement Général de Pouni-Sud','CEG de Pouni Sud','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6046',' ','1','24','4174','Lycée de Tiyéllé','Lycée de Tiyéllé','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6047',' ','1','24','4174','Collège Enseignement Général de Valiou','CEG de Valiou','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6048',' ','1','24','4174','Collège Enseignement Général de Villy','CEG VILLY','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6049',' ','1','24','4174','Lycée Départemental de Pouni','L. D POUNI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6050',' ','1','24','4174','Lycée Départemental de Tita','L D Tita','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6051',' ','1','24','4174','Lycée privé Excellence des Professeurs de Tita','LP EXCELLENCE DES PROF','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6052',' ','1','24','4174','Collège privé Espérance de Tita','CP  ESPERANCE ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6053',' ','1','24','4174','Collège privé Koirabéré de Pouni','CP KOIRABERE ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6054',' ','1','24','4174','Collège privé Yipéné de Bandéo-Naponé','C.P.YIPENE DE B-N','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6055',' ','1','24','4174','Lycée privé Les Cracks Antoine Badéma de Tita','LP LES CRACKS ANTOINE BADEMA ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6056',' ','1','24','4174','Collège privé Wend-Lamita de Tita','C P WEND-LAMITA ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6057',' ','1','24','4174','Lycée privé Saint Augustin de Tita','LP SAINT AUGUSTIN ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6058',' ','1','24','4174','Lyceé privé La Sagesse de Tita','LP LA SAGESSE ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6059',' ','1','24','4174','Lycée privé la Référence de Tita','LP la Référence de Tita','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6060',' ','1','24','4174','Collège privé Notre Dame de Fatima de Tita','CP N. DAME DE FATIMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6061',' ','1','24','4259','Collège Enseignement Général de Bonyolo','CEG de Bonyolo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6062',' ','1','24','4259','Collège Enseignement Général de Ekoulkoala','CEG de Ekoulkoala','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6063',' ','1','24','4259','Collège Enseignement Général de Goundi','CEG de Goundi','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6064',' ','1','24','4259','Collège Enseignement Général de Perkoa','CEG de Perkoa','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6065',' ','1','24','4259','Lycée de Piokoura','Lycée de Piokoura ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6066',' ','1','24','4259','Collège Enseignement Général de Réo','CEG de Réo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6067',' ','1','24','4259','Lycée Moderne de Gomédyr ','L M GOMEDYR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6068',' ','1','24','4259','Lycée de Zoula','Lycée de Zoula','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6069',' ','1','24','4259','Lycée Municipal de Réo','L. M REO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6070',' ','1','24','4259','Lycée Provincial de Réo','L. P REO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6071',' ','1','24','4259','Collège privé O. BAMA de Zoula','C P.O. BAMA DE ZOULA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6072',' ','1','24','4259','Lycée privé Wendbénédo ','LP Wendbénédo ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6073',' ','1','24','4259','Collège privé Chéléyi','C.P CHELEYI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6074',' ','1','24','4259','Collège privé des Nations','C.P DES NATIONS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6075',' ','1','24','4259','Lycée privé Le Plateau','L.P LE PLATEAU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6076',' ','1','24','4259','Collège privé Saint Anthyme de Réo','C.P SAINT ANTHYME','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6077',' ','1','24','4259','Collège privé Sainte Cécile de Réo','C.P SAINTE CECILE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6078',' ','1','25','4314','Lycée de Néboun','L NEBOUN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6079',' ','1','25','4336','Collège Enseignement Général de Yoro','CEG YORO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6080',' ','1','22','2214','cours du soir amitié',' Cours du soir Amitié','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6081',' ','1','22','2214','CEG Municipal de Goughin Sud ','CEG Municipal Goughin Sud','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6082',' ','1','22','2214','groupe scolaire Boblawendé','GS Boblawendé','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6083',' ','1','22','2214','complexe scolaire Bass-Yiiré','C S Bass Yirré','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6084',' ','1','22','2214','CEG municipal de Ouidtenga','CEG municipal Ouidtenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6085',' ','1','22','2214','collège privé Israêl','CP Israêl','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6086',' ','1','22','2214','lycée privé Mixte  Wend Yam ','LP Mixte Wend Yam','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6087',' ','1','22','2214','collège privé Evangélique Nabasnogo','CPE Nabasnogo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6088',' ','1','22','2214','COLLEGE PRIVE CLEMENT VICTOR','CPCV','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6089',' ','1','22','2214','COURS DU SOIR ECP/LMBOG','CSEL','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6090',' ','1','22','2214','LYCEE PRIVE AXE DU SUCCES II','LPASIII','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6091',' ','1','22','2214','COLLEGE PRIVE WEND PANGA DE SANDOGO','CPWD SANDOGOP','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6092',' ','1','22','2214','LYCEE PRIVE MIXTE WEND YAM','LPPWYAMI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6093',' ','1','22','2214','COMPLEXE SCOLAIRE PRIVE WEND ZOODO','CPWZ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6094',' ','1','22','2214','LYCEE PRIVE DU COMPLEXE S. FIRNASW ','LPCSF','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6095',' ','1','22','2214','COLLEGE PRIVE LES AS','CPLA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6096',' ','1','22','2214','LYCEE PRIVE LES SOMMITES','LPLS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6097',' ','1','22','2214','LYCEE PRIVE KEPLER','LLPK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6098',' ','1','22','2214','LYCEE PRIVE DE LA JEUNESSE','LDLJ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6099',' ','1','22','2214','LYCEE PRIVE ALFRED D. KI-ZERBO','LPADZ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6100',' ','1','22','2214','LYCEE PRIVE SAINTE ELISABETH','LPSE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6101',' ','1','22','2214','LYCEE PRIVE KALO SANOU','LPKS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6102',' ','1','22','2214','LYCEE PRIVE MARIE POUSSEPIN','LPMP','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6103',' ','1','22','2320','LYCEE PRIVE CANA','LLPC','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6104',' ','1','22','2214','COLLEGE PRIVE LA PROVIDENCE ','CPLP','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6105',' ','1','22','2214','LYCEE NABA PIIGA DE DAYONGO ','LPDD','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6106',' ','1','22','2214','COURS DU SOIR LA TROUSSE','CSLT','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6107',' ','1','22','2214','LYCEE PRIVE JATHNIEL','LLPJ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6108',' ','1','22','2214','LYCEE PRIVE EXCELLENCE TASLIM','LPET','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6109',' ','1','22','2214','LYCEE PRIVE DAROUL INCHAAD','LPDI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6110',' ','1','22','2214','LYCEE PRIVE ALFOURQUANE','LLPA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6111',' ','1','22','2214','COUR DU SOIR ECOLE KOSSYAM','CSEK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6112',' ','1','22','2214','LYCEE PRIVE LA SOLUTION II','LLSI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6113',' ','1','22','2214','LYCEE PRIVE WENDBARAKA DE TINSOUKA','LWDT','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6114',' ','1','22','2214','COMPLEXE SCOLAIRE SAINT JUSTIN','CSSJ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6115',' ','1','22','2214','LYCEE PRIVE NOTRE DAME DE EXCELLENCE','LPNDE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6116',' ','1','22','2214','L. P. C. S. NONGTABA','L. P. C. S. NONGTABA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6117',' ','1','22','2214','COLLEGE PRIVE RAKISSWENDE','CCPR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6118',' ','1','22','2214','LYCEE P. Dr ABLASSE OUEDRAOGO','LDAO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6119',' ','1','22','2214','LYCEE PRIVE TINGUISSOM','LLPT','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6120',' ','1','22','2214','L.P. M. KOTYB','LPMK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6121',' ','1','22','2214','COURS DU SOIR KOTYB','CDSK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6122',' ','1','22','2214','LYCEE PRIVE ALBARAKA','LLPA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6123',' ','1','22','2214','COLLEGE PRIVE EVANGELIQUE JOSHUE  ZIRE ','CEJZ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6124',' ','1','22','2214','COLLEGE PRIVE TILGRE','CCPT','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6125',' ','1','22','2214','COURS DU SOIR MHEB','CDSM','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6126',' ','1','22','2214','LYCEE PRIVE SION SHIMRI SSHEMIDA','LSSS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6127',' ','1','22','2214','COURS PÈRE LOUIS Q. ST VIATEUR','CPLQSV','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6128',' ','1','22','2214','LYCEE PRIVE CHARLES GUSTAVE','LPCG','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6129',' ','1','22','2346','CEG DE TAONSGHO','CCDT','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6130',' ','1','22','2214','COLLEGE PRIVE AL-HOUDA','CPAH','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6131',' ','1','22','2214','COMPLEXE SCOLAIRE SAINT THERAPH','CSST','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6132',' ','1','22','2214','CEG M. JOSEPH HAGE','CMJH','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6133',' ','1','22','2214','COLLEGE PRIVE MARIE CURIE','CPMC','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6134',' ','1','22','2214','LYCEE PRIVE LA RENAISSANCE','LPLR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6135',' ','1','22','2214','COLLEGE PRIVE MOS AB BENOUMAIR','CMAB','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6136',' ','1','22','2214','COLLEGE LE PETIT MONDE','CLPM','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6137',' ','1','22','2214','GROUPE SCOLAIRE ADO','GGSA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6138',' ','1','22','2298','LYCEE PRIVE SAINT MICHEL','LPSM','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6139',' ','1','22','2214','LYCEE PRIVE WAMALGBA','LLPW','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6140',' ','1','32','3983','Collège Enseignement Général de Guibtenga','CEG de Guibtenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6141',' ','1','32','3983','Collège Enseignement Général de Soubeira-Natenga','CEG Soubeira-Natenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6142',' ','1','32','3983','Collège Enseignement Général de Ziga','CEG Ziga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6143',' ','1','32','3983','Lycée Départemental de Ziga','LD Ziga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6144',' ','1','32','3983','Lycée Privé le Chercheur de Ziga','LPrC Ziga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6145',' ','1','32','3983','Lycée Privé Melchisedeck de Soubeira-Natenga','LPrM Soubeira-Natenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6146',' ','1','32','3983','Lycée de Soubeira-Natenga','Lycée Soubeira-Natenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6147',' ','1','32','3983','Collège Enseignement Général de Samboaga','CEG Samboaga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6148',' ','1','32','3983','Candidat Libre de Ziga','CL Ziga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6149',' ','1','32','3983','Candidat Libre de Soubeira-Natenga','CL Soubeira-Natenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6150',' ','1','32','3983','Candidat Libre de Guibtenga','CL Guibtenga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6151',' ','1','32','3983','Candidat Libre de Samboaga','CL Samboaga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6152',' ','1','33','4578','Lycée privé la Fraternité de Doulougou','LPLFD','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6153',' ','1','33','4695','Collège privé Ecovie de Saponé','CPES','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6154',' ','1','34','4772','Ecole Démocratique et Populaire ( EDP) de Pô','EPD PO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6155',' ','1','34','4772','Groupe Scolaire Atta Oudié ( GSAO) de  Pô','GSAO PO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6156',' ','1','34','4863','Collège privé Al Nouraïne de Konkoa','CPANK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6157',' ','1','34','4874','Lycée Mixte Privé Anaafo Douko ( LMPAD) de Guewongo','LMPAD G','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6158',' ','1','34','4772','Centre de Formation des Arts et Métiers - Pô','CFAM-Pô','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6159',' ','1','34','4772','Lycée Privé Technique Le Technicien Comptable','L P T Le Technicien Comptable','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6160',' ','1','33','4653','Collège enseignement Technique et de Formation Profressionnel de Tampinko','CETFP Tampinko','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6161',' ','1','35','5005','Collège enseignement Technique et de Formation Profressionnel de Manga','CETFP Manga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6162',' ','1','35','5005','Candidat libre de Manga','CL Manga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6163',' ','1','35','5005','Lycée Professionnel Régional de Manga','LPR Manga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6164',' ','1','35','5005','Lycée Provincial Naaba Baongo de Manga','LPNB Manga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6165',' ','1','33','4653','Candidat libre de Kombissiri','CL Kombissiri','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6166',' ','1','34','4772','Lycée privé Technique La Vision','LPT la Vision de PÔ','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6167',' ','1','48','5289','CEG DE DABESMA','CDAB','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6168',' ','1','48','5042','LYCEE DEPARTEMENTAL DE BILANGA','LDB','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6169',' ','1','49','5448','LYCEE PROFESSIONNEL REGIONAL YENDABILI','LPRY','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6170',' ','1','49','5448','CENTRE DE FORMATION PROFESSIONNELLE','CFP/FADA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6171',' ','1','56','5841','LYCEE PRIVE RIDWANE','LP RIDWANE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6172',' ','1','56','5841','CL de la Fraternité','CL F','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6173',' ','1','56','5841','Cours du soir Promotion des études','CSPE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6174',' ','1','56','5841','LYCEE PRIVE MYETIMA','LPMY','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6175',' ','1','56','5841','LYCEE PRIVE SALYA','LPSA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6176',' ','1','56','5930','LYCEE PRIVE EVANGELIQUE ETOILE DE L ESPOIR','LPEEE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6177',' ','1','38','6263','Candidats Libres de Arbollé','CL ARBOLLE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6178',' ','1','38','6263','Candidats Libres de Kaba','CL KABA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6179',' ','1','38','6263','Candidats Libres de Boulkon','CL BOULKON','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6180',' ','1','38','6263','Candidats Libres de Kaba','CL KABA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6181',' ','1','38','6263','Candidats Libres de Ouisga','CL Ouisga','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6182',' ','1','38','6263','Candidats Libres de Pathiri','CL Pathiri','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6183',' ','1','38','6297','Candidats Libres de Bagaré','CL Bagaré','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6184',' ','1','38','6297','Candidats Libres de Niouma','CL Niouma','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6185',' ','1','38','6297','Candidats Libres de Zougo','CL Zougo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6186',' ','1','38','6319','Candidats Libres de Bokin','CL BOKIN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6187',' ','1','38','6319','Candidats Libres de Tema','CL TEMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6188',' ','1','38','6319','Candidats Libres de Sarma','CL SARMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6189',' ','1','38','6319','Candidats Libres de Guipa','CL GUIPA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6190',' ','1','38','6319','Candidats Libres de Yaké','CL YAKE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6191',' ','1','38','6319','Candidats Libres de Imiougou','CL IMIOUGOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6192',' ','1','38','6319','Candidats Libres de Séguédin','CL SEGUEDIN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6193',' ','1','38','6365','Candidats Libres de Gomponsom','CL GOMPONSOM','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6194',' ','1','38','6365','Candidats Libres de Boulma','CL BOULMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6195',' ','1','38','6378','Candidats Libres de Kirsi','CL KIRSI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6196',' ','1','38','6378','Candidats Libres de Kapon','CL KAPON','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6197',' ','1','38','6390','Candidats Libres de Latoden','CL LATODEN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6198',' ','1','38','6390','Candidats Libres de Loungo','CL Loungo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6199',' ','1','38','6390','Candidats Libres de  Minissia','CL MINISSIA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6200',' ','1','38','6402','Candidats Libres de Pilimpikou','CL PILIMPIKOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6201',' ','1','38','6402','Candidats Libres de Rakoungou','CL RAKOUNGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6202',' ','1','38','6408','Candidats Libres de Samba','CL SAMBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6203',' ','1','38','6408','Candidats Libres de Batono','CL BATONO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6204',' ','1','38','6408','Candidats Libres de Tébo','CL TEBO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6205',' ','1','38','6429','Candidats Libres de Yako','CL YAKO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6206',' ','1','38','6429','Candidats Libres de Douré','CL DOURE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6207',' ','1','38','6429','Candidats Libres de Roumtenga','CL ROUMTENGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6208',' ','1','38','6429','Candidats Libres de Song-Naba','CL SONG-NABA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6209',' ','1','38','6429','Candidats Libres de Tindila','CL TINDILA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6210',' ','1','39','6835','Candidats Libres de 6835','CL BASSI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6211',' ','1','39','6848','Candidats Libres de 6848','CL BOUSSOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6212',' ','1','39','6861','Candidats Libres de Gourcy','CL GOURCY','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6213',' ','1','39','6861','Candidats Libres de Minima','CL MINIMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6214',' ','1','39','6861','Candidats Libres de Niessega','CL NIESSEGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6215',' ','1','39','6893','Candidats Libres de Leba','CL LEBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6216',' ','1','39','6903','Candidats Libres de Tougo','CL TOUGO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6217',' ','1','39','6903','Candidats Libres de Bascorma','CL BASCORMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6218',' ','1','39','6903','Candidats Libres de Roba','CL ROBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6219',' ','1','37','6459','COLLEGE ENSEIGNEMENT GENERAL DE DINGUIRI','CEG DE DINGUIRI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6220',' ','1','37','9260','COLLEGE ENSEIGNEMENT GENERAL DE KONONGA','CEG DE KONONGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6221',' ','1','37','9260','COLLEGE ENSEIGNEMENT GENERAL MOGOMBOULI','CEG DE MOGOMBOULI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6222',' ','1','37','9260','COLLEGE ENSEIGNEMENT GENERA DE NAMISSIGUIMA','CEG DE NAMISSIGUIMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6223',' ','1','37','9260','LYCEE COMMUNAL DE TOUGOU','LC TOUGOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6224',' ','1','37','9260','LYCEE DEPARTEMENTAL DE NAMISSIGUIMA','LD NAMISSIGUIMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6225',' ','1','37','6480','Candidats libres de BEMA-SILMIMOSSE','CL BEMA-SILMIMOSSE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6226',' ','1','37','6708','Candidats libres de GAMBO','CL GAMBO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6227',' ','1','37','9260','Candidats libres de NAMISSIGUIMA','CL NAMISSIGUIMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6228',' ','1','37','6634','Candidats libres de LOUGOURI','CL LOUGOURI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6229',' ','1','37','6793','Candidats libres de THIOU','CL THIOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6230',' ','1','37','6820','Candidats libres de ZOGORE','CL ZOGORE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6231',' ','1','37','6765','Candidats libres de TANGAYE','CL TANGAYE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6232',' ','1','37','6689','Candidats libres de RAMBO','CL RAMBO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6233',' ','1','37','6689','Candidats libres de POURRA','CL POURRA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6234',' ','1','37','6480','Candidats libres de RONDO','CL RONDO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6235',' ','1','37','6459','Candidats libres de BARGA','CL BARGA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6236',' ','1','37','6531','Candidats libres de KOSSOUKA','CL KOSSOUKA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6237',' ','1','37','6550','Candidats libres de KOUMBRI','CL KOUMBRI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6238',' ','1','36','478','Candidats libres de TITAO','CL TITAO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6239',' ','1','45','7688','CANDIDATS LIBRES DE LOTO','CL  LOTO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6240',' ','1','45','7688','CANDIDATS LIBRES DE NANE','CL  NANE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6241',' ','1','45','7688','CANDIDATS LIBRES DE BAMAKO',' CL  BAMAKO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6242',' ','1','45','7688','CANDIDATS LIBRES DE NAVIELGANE','CL  NAVIELGANE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6243',' ','1','45','7688','CANDIDATS LIBRES DE DIEBOUGOU','CL DIEBOUGOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6244',' ','1','45','7688','CANDIDATS LIBRES DE BAPLA','CL BAPLA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6245',' ','1','45','7673','CANDIDATS LIBRES DE BONDIGUI','CL BONDIGUI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6246',' ','1','45','7673','CANDIDATS LIBRES DE MOUGUE','CL MOUGUE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6247',' ','1','45','7673','CANDIDATS LIBRES DE WAN','CL WAN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6248',' ','1','45','7719','CANDIDATS LIBRES DE DOLO','CL DOLO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6249',' ','1','45','7719','CANDIDATS LIBRES DE SAPTAN','CL SAPTAN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6250',' ','1','45','7719','CANDIDATS LIBRES DE NICEO','CL NICEO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6251',' ','1','45','7734','CANDIDATS LIBRES DE IOLONIORO','CL IOLONIORO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6252',' ','1','45','7734','CANDIDATS LIBRES DE TOMENA','CL TOMENA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6253',' ','1','45','7734','CANDIDATS LIBRES DE DIASSARA','CL DIASSARA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6254',' ','1','45','7776','CANDIDATS LIBRES DE TIANKOURA','CL TIANKOURA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6255',' ','1','45','7776','CANDIDATS LIBRES DE TIOYO','CL TIOYO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6256',' ','1','46','7814','CANDIDATS LIBRES DE DANO','CL DANO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6257',' ','1','46','7814','CANDIDATS LIBRES DE BOLEMBAR','CL BOLEMBAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6258',' ','1','46','7814','CANDIDATS LIBRES DE DAYERE','CL DAYERE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6259',' ','1','46','7814','CANDIDATS LIBRES DE GNIGBAMAN','CL GNIGBAMAN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6260',' ','1','46','7814','CANDIDATS LIBRES DE MEBAR','CL MEBAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6261',' ','1','46','7814','CANDIDATS LIBRES DE SARBA','CL SARBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6262',' ','1','46','7814','CANDIDATS LIBRES DE YABOGANE','CL YABOGANE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6263',' ','1','46','7837','CANDIDATS LIBRES DE DISSIN','CL DISSIN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6264',' ','1','46','7837','CANDIDATS LIBRES DE BENVAR','CL BENVAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6265',' ','1','46','7837','CANDIDATS LIBRES DE GORA','CL GORA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6266',' ','1','46','7837','CANDIDATS LIBRES DE KOKOLIBOU','CL KOKOLIBOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6267',' ','1','46','7837','CANDIDATS LIBRES DE MOU','CL MOU','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6268',' ','1','46','7837','CANDIDATS LIBRES DE NAKAR','CL NAKAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6269',' ','1','46','7837','CANDIDATS LIBRES DE OUIZINE','CL OUIZINE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6270',' ','1','46','7837','CANDIDATS LIBRES DE SAALA','CL SAALA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6271',' ','1','46','7862','CANDIDATS LIBRES DE GUEGUERE','CL GUEGUERE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6272',' ','1','46','7862','CANDIDATS LIBRES DE BADONE','CL BADONE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6273',' ','1','46','7862','CANDIDATS LIBRES DE BOUNI','CL BOUNI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6274',' ','1','46','7862','CANDIDATS LIBRES DE DAHORE','CL DAHORE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6275',' ','1','46','7862','CANDIDATS LIBRES DE GOGOBA','CL GOGOBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6276',' ','1','46','7862','CANDIDATS LIBRES DE NARO','CL NARO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6277',' ','1','46','7862','CANDIDATS LIBRES DE TAMPOUOR','CL TAMPOUOR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6278',' ','1','46','7862','CANDIDATS LIBRES DE TENOULE','CL TENOULE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6279',' ','1','46','7862','CANDIDATS LIBRES DE WALALA','CL WALALA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6280',' ','1','46','7897','CANDIDATS LIBRES DE KOPER','CL KOPER','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6281',' ','1','46','7897','CANDIDATS LIBRES DE LOPAL','CL LOPAL','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6282',' ','1','46','7919','CANDIDATS LIBRES DE NIEGO','CL NIEGO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6283',' ','1','46','7919','CANDIDATS LIBRES DE VARPOUO','CL VARPOUO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6284',' ','1','46','7928','CANDIDATS LIBRES DE ORONKUA','CL ORONKUA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6285',' ','1','46','7928','CANDIDATS LIBRES DE GNITEGBA','CL GNITEGBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6286',' ','1','46','7928','CANDIDATS LIBRES DE ORPOUNE','CL ORPOUNE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6287',' ','1','46','7928','CANDIDATS LIBRES DE POULEBA','CL POULEBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6288',' ','1','46','7943','CANDIDATS LIBRES DE OUESSA','CL OUESSA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6289',' ','1','46','7943','CANDIDATS LIBRES DE HAMELE','CL HAMELE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6290',' ','1','46','7943','CANDIDATS LIBRES DE KOLINKA','CL KOLINKA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6291',' ','1','46','7951','CANDIDATS LIBRES DE ZAMBO','CL ZAMBO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6292',' ','1','46','7951','CANDIDATS LIBRES DE DJIKOLOGO','CL DJIKOLOGO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6293',' ','1','46','7951','CANDIDATS LIBRES DE FOROTEON','CL FOROTEON','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6294',' ','1','46','7951','CANDIDATS LIBRES DE TOVOR','CL TOVOR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6295',' ','1','46','7951','CANDIDATS LIBRES DE ZOUOLO','CL ZOUOLO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6296',' ','1','47','7976','CANDIDATS LIBRESDE BATIE','CL BATIE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6297',' ','1','47','7976','CANDIDATS LIBRESDE GANGALMA','CL GANGALMA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6298',' ','1','47','7976','CANDIDATS LIBRESDE KORIBA','CL KORIBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6299',' ','1','47','8081','CANDIDATS LIBRESDE LEGMOIN','CL LEGMOIN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6300',' ','1','47','8081','CANDIDATS LIBRESDE DANKANA','CL DANKANA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6301',' ','1','47','8081','CANDIDATS LIBRESDE BOPIEL','CL BOPIEL','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6302',' ','1','47','8031','CANDIDATS LIBRESDE BOUSSOUKOULA','CL BOUSSOUKOULA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6303',' ','1','47','8031','CANDIDATS LIBRESDE KOSSO','CL KOSSO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6304',' ','1','47','8127','CANDIDATS LIBRESDE MIDEBDO','CL MIDEBDO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6305',' ','1','47','8069','CANDIDATS LIBRESDE KPUERE','CL KPUERE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6306',' ','1','44','8284','CANDIDATS LIBRES DE GAOUA','CL GAOUA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6307',' ','1','44','8284','CANDIDATS LIBRES DE BARKPERENA','CL BARKPERENA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6308',' ','1','44','8284','CANDIDATS LIBRES DE BONKO','CL BONKO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6309',' ','1','44','8284','CANDIDATS LIBRES DE HELLO','CL HELLO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6310',' ','1','44','8284','CANDIDATS LIBRES DE HOLLY','CL HELLO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6311',' ','1','44','8284','CANDIDATS LIBRES DE SIDOUMOUKAR','CL SIDOUMOUKAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6312',' ','1','44','8180','CANDIDATS LIBRES DE BOUROUM-BOUROUM','CL BOUROUM-BOUROUM','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6313',' ','1','44','8180','CANDIDATS LIBRES DE BANLO','CL BANLO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6314',' ','1','44','8180','CANDIDATS LIBRES DE TIKITIONAO','CL TIKITIONAO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6315',' ','1','44','8200','CANDIDATS LIBRES DE BOUSSERA','CL BOUSSERA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6316',' ','1','44','8200','CANDIDATS LIBRES DE DONKO','CL DONKO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6317',' ','1','44','8337','CANDIDATS LIBRES DE GBOMBLORA','CL GBOMBLORA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6318',' ','1','44','8337','CANDIDATS LIBRES DE TOBO','CL TOBO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6319',' ','1','44','942','CANDIDATS LIBRES DE KAMPTI','CL KAMPTI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6320',' ','1','44','942','CANDIDATS LIBRES DE PASSENA','CL PASSENA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6321',' ','1','44','942','CANDIDATS LIBRES DE GALGOULI','CL GALGOULI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6322',' ','1','44','8520','CANDIDATS LIBRES DE LOROPENI','CL LOROPENI','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6323',' ','1','44','8520','CANDIDATS LIBRES DE DIPEO','CL DIPEO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6324',' ','1','44','8520','CANDIDATS LIBRES DE DJEGONAO','CL DJEGONAO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6325',' ','1','44','8520','CANDIDATS LIBRES DE LOKOSSO','CL LOKOSSO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6326',' ','1','44','8520','CANDIDATS LIBRES DE KORO','CL KORO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6327',' ','1','44','8520','CANDIDATS LIBRES DE YEREFOULA','CL YEREFOULA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6328',' ','1','44','8583','CANDIDATS LIBRES DE MALBA','CL MALBA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6329',' ','1','44','8613','CANDIDATS LIBRES DE BALARKAR','CL BALARKAR','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6330',' ','1','44','8613','CANDIDATS LIBRES DE NAKO','CL NAKO','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6331',' ','1','44','8613','CANDIDATS LIBRES DE DAPOLA','CL DAPOLA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6332',' ','1','44','8613','CANDIDATS LIBRES DE KOUTENA','CL KOUTENA','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6333',' ','1','44','8683','CANDIDATS LIBRES DE PERIGBAN','CL PERIGBAN','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6334',' ','1','25','4358','Lycée Privé Bangre-Nooma','L.P Bangre-Nooma Léo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6335',' ','1','25','4358','Collège Privé Wendmanegré de Léo','C.P Wendmanegré Léo','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6336',' ','1','25','4336','Collège Enseignement Général de Boura','CEG Boura','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6337',' ','1','56','5841','LYCEE PRIVE LA BELLE PORTE','LP BELLE PORTE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6338',' ','1','56','5975','Collège Privé Amadou Sanou de Satiri','CPASS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6339',' ','1','56','5841','Lycée Privé Vision de l Excellence','LPVE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6340',' ','1','56','5841','Lycée Privé la Nouvelle Génération','LPNG','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6341',' ','1','56','5859','Collège Privé Noni Lawali','CPNL','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6342',' ','1','56','5841','Collège Privé Moderne la Sorbonne','CPMS','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6343',' ','1','56','5841','Lycée Privé Evangélique Sol Béni','LPESB','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6344',' ','1','57','6076','Collège Privé Amitié de Kabala','CPAK','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6345',' ','1','58','6225','Lycée Privé Wanmi','LPW','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6346',' ','1','58','6225','Collège Privé Sabéré Hatiko','CPSH','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6347',' ','1','56','5841','CEG DE DARSALAMY','CEG/D','')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5644', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5645', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5646', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5647', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5648', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5649', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5650', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5651', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5652', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5653', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5654', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5655', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5656', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5657', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5658', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5659', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5660', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5661', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5662', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5663', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5664', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5665', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5666', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5667', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5668', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5669', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5670', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5671', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5672', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5673', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5674', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5675', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5676', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5677', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5678', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5679', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5680', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5681', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5682', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5683', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5684', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5685', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5686', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5687', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5688', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5689', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5690', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5691', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5692', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5693', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5694', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5695', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5696', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5697', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5698', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5699', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5700', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5701', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5702', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5703', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5704', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5705', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5706', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5707', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5708', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5709', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5710', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5711', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5712', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5713', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5714', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5715', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5716', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5717', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5718', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5719', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5720', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5721', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5722', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5723', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5724', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5725', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5726', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5727', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5728', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5729', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5730', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5731', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5732', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5733', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5734', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5735', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5736', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5737', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5738', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5739', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5740', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5741', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5742', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5743', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5744', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5745', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5746', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5747', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5748', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5749', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5750', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5751', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5752', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5753', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5754', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5755', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5756', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5757', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5758', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5759', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5760', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5761', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5762', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5763', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5764', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5765', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5766', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5767', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5768', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5769', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5770', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5771', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5772', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5773', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5774', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5775', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5776', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5777', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5778', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5779', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5780', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5781', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5782', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5783', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5784', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5785', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5786', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5787', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5788', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5789', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5790', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5791', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5792', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5793', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5794', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5795', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5796', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5797', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5798', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5799', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5800', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5801', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5802', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5803', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5804', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5805', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5806', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5807', '1', '2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5808', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5809', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5810', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5811', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5812', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5813', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5814', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5815', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5816', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5817', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5818', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5819', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5820', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5821', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5822', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5823', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5824', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5825', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5826', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5827', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5828', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5829', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5830', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5831', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5832', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5833', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5834', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5835', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5836', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5837', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5838', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5839', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5840', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5841', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5842', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5843', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5844', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5845', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5846', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5847', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5848', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5849', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5850', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5851', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5852', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5853', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5854', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5855', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5856', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5857', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5858', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5859', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5860', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5861', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5862', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5863', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5864', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5865', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5866', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5867', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5868', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5869', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5870', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5871', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5872', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5873', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5874', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5875', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5876', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5877', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5878', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5879', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5880', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5881', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5882', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5883', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5884', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5885', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5886', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5887', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5888', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5889', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5890', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5891', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5892', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5893', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5894', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5895', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5896', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5897', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5898', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5899', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5900', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5901', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5902', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5903', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5904', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5905', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5906', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5907', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5908', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5909', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5910', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5911', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5912', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5913', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5914', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5915', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5916', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5917', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5918', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5919', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5920', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5921', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5922', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5923', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5924', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5925', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5926', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5927', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5928', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5929', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5930', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5931', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5932', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5933', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5934', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5935', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5936', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5937', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5938', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5939', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5940', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5941', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5942', '2', '2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5943', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5944', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5945', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5946', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5947', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5948', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5949', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5950', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5951', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5952', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5953', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5954', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5955', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5956', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5957', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5958', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5959', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5960', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5961', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5962', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5963', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5964', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5965', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5966', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5967', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5968', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5969', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5970', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5971', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5972', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5973', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5974', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5975', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5976', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5977', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5978', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5979', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5980', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5981', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5982', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5983', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5984', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5985', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5986', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5987', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5988', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5989', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5990', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5991', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5992', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5993', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5994', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5995', '2', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5996', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5997', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5998', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('5999', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6000', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6001', '1', '1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6002', '1', '1')");
       
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6003','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6004','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6005','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6006','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6007','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6008','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6009','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6010','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6011','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6012','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6013','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6014','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6015','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6016','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6017','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6018','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6019','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6020','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6021','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6022','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6023','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6024','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6025','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6026','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6027','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6028','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6029','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6030','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6031','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6032','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6033','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6034','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6035','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6036','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6037','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6038','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6039','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6040','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6041','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6042','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6043','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6044','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6045','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6046','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6047','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6048','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6049','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6050','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6051','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6052','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6053','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6054','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6055','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6056','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6057','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6058','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6059','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6060','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6061','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6062','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6063','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6064','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6065','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6066','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6067','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6068','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6069','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6070','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6071','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6072','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6073','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6074','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6075','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6076','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6077','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6078','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6079','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6080','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6081','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6082','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6083','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6084','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6085','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6086','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6087','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6088','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6089','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6090','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6091','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6092','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6093','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6094','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6095','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6096','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6097','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6098','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6099','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6100','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6101','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6102','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6103','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6104','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6105','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6106','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6107','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6108','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6109','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6110','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6111','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6112','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6113','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6114','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6115','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6116','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6117','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6118','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6119','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6120','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6121','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6122','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6123','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6124','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6125','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6126','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6127','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6128','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6129','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6130','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6131','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6132','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6133','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6134','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6135','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6136','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6137','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6138','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6139','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6140','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6141','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6142','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6143','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6144','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6145','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6146','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6147','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6148','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6149','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6150','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6151','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6152','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6153','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6154','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6155','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6156','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6157','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6158','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6159','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6160','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6161','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6162','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6163','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6164','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6165','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6166','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6167','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6168','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6169','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6170','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6171','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6172','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6173','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6174','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6175','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6176','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6177','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6178','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6179','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6180','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6181','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6182','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6183','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6184','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6185','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6186','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6187','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6188','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6189','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6190','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6191','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6192','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6193','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6194','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6195','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6196','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6197','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6198','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6199','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6200','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6201','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6202','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6203','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6204','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6205','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6206','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6207','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6208','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6209','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6210','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6211','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6212','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6213','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6214','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6215','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6216','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6217','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6218','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6219','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6220','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6221','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6222','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6223','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6224','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6225','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6226','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6227','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6228','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6229','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6230','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6231','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6232','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6233','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6234','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6235','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6236','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6237','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6238','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6239','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6240','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6241','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6242','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6243','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6244','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6245','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6246','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6247','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6248','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6249','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6250','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6251','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6252','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6253','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6254','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6255','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6256','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6257','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6258','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6259','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6260','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6261','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6262','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6263','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6264','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6265','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6266','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6267','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6268','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6269','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6270','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6271','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6272','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6273','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6274','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6275','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6276','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6277','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6278','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6279','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6280','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6281','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6282','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6283','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6284','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6285','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6286','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6287','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6288','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6289','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6290','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6291','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6292','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6293','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6294','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6295','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6296','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6297','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6298','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6299','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6300','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6301','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6302','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6303','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6304','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6305','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6306','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6307','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6308','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6309','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6310','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6311','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6312','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6313','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6314','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6315','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6316','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6317','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6318','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6319','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6320','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6321','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6322','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6323','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6324','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6325','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6326','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6327','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6328','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6329','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6330','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6331','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6332','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6333','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6334','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6335','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6336','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6337','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6338','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6339','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6340','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6341','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6342','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6343','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6344','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6345','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6346','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6347','1','1')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6348',' ','1','55','7298','Lycée privé technique 3AE de Goundry','LPrT3AE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6348',' ','1','55','7298','Lycée privé technique 3AE de Goundry','LPrT3AE','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6349',' ','1','53','7087','Lycée professionnel de Zorgho','LPROF ZRG','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6350',' ','1','24','4200','Candidats Libres de Bissou','CL BISSOU','')");
        
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6351',' ','1','22','2214','COURS DU SOIR AURORE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6352',' ','1','22','2214','CANDIDATS LIBRES ZONE 1','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6353',' ','1','22','2214','CANDIDATS LIBRES ZONE 2','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6354',' ','1','22','2214','CANDIDATS LIBRES ZONE 3','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6355',' ','1','22','2214','CANDIDATS LIBRES ZONE 4','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6356',' ','1','22','2214','CANDIDATS LIBRES ZONE 5','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6357',' ','1','22','2214','CANDIDATS LIBRES ZONE 6','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6358',' ','1','22','2214','CANDIDATS LIBRES ZONE 7','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6359',' ','1','22','2214','CANDIDATS LIBRES ZONE 8','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6360',' ','1','22','2214','CANDIDATS LIBRES ZONE 9','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6361',' ','1','22','2214','CANDIDATS LIBRES ZONE 10','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6362',' ','1','22','2234','CANDIDATS LIBRES KOMSILGA','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6363',' ','1','22','2215','CANDIDATS LIBRES KOMKI IPAALA','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6364',' ','1','22','2346','CANDIDATS LIBRES TANGHIN DASSOURI','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6365',' ','1','22','2271','CANDIDATS LIBRES KOUBRI','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6366',' ','1','22','2320','CANDIDATS LIBRES SAABA','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6367',' ','1','22','2214','CANDIDATS LIBRES KAMBOISIN','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6368',' ','1','22','2298','CANDIDATS LIBRES PABRE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6369',' ','1','22','2320','COLLEGE PRIVE SOMNAMANEGRE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6370',' ','1','22','2214','COURS DU SOIR PAWENTAORE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6371',' ','1','22','2214','LYCEE PRIVE LES DELICES DE L''ETERNEL','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6372',' ','1','22','2214','LYCEE PRIVE MODERNE CARDINAL PHILIPPE OUEDRAOGO','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6373',' ','1','22','2234','LYCEE PRIVE RAAGA DE SABTENGA','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6374',' ','1','22','2214','LYCEE PRIVE DE LA CHARTE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6375',' ','1','22','2298','COURS DU SOIR EBEN EZER','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6376',' ','1','22','2234','LYCEE PRIVE WEND KATO','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6377',' ','1','22','2214','COURS DU SOIR CERCLE','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6378',' ','1','22','2298','COLLEGE PRIVE EBEN EZER','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6379',' ','1','22','2214','COURS DU SOIR KOTYB','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6380',' ','1','22','2214','LYCEE PRIVE MODERNE KOTYB','','')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6381',' ','1','22','2214','GROUPE SCOLAIRE PRIVE WENDKUUNI','','')");
        
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6382',' ','1','22','2214',' LYCEE PRIVE LA SOLUTION DE BASSINKO','LP LA SOLUTION DE BASSINKO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6383',' ','1','22','2214','C S wendtoin ','CS Wendtoin',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6384',' ','1','22','2214','COLLEGE EBEN-EZER','C EBEN-EZER',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6385',' ','1','22','2214','COLLEGE PRIVE AL -BARAKAH','CP AL-BARAKAH',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6386',' ','1','22','2214','COLLEGE PRIVE AL HOUDA','XP AL HOUDA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6387',' ','1','22','2320','COLLEGE PRIVE BOBLWENDE','CP BOBLWENDE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6388',' ','1','22','2214','COLLEGE PRIVE CLEMENT VICTOR','CPC VICTOR',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6389',' ','1','22','2214','collège privé El Héloim Bayouresom','CP El Heloim Bayouresom',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6390',' ','1','22','2346','COLLEGE PRIVE EVANGELIQUE WEND-TILGODO SHABACH','CPEWT WHA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6391',' ','1','22','2271','collège privé Jamaat Islamique Ahmadiyya','CP Jamaat I, Ahamadiyya',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6392',' ','1','22','2214','collège privé La Providence','CP La Providence',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6393',' ','1','22','2214','COLLEGE PRIVE SAINT LAURENT DE TANGHIN','CP ST LAURENT DE TANGHIN',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6394',' ','1','22','2320','collège Privé Sati','CP Sati ',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6395',' ','1','22','2214','collège privé Wend Panga de Sandogo','CP Wend Panga',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6396',' ','1','22','2320','COLLEGE PRIVE WENDVENEGDO','CP WENDVENEGDO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6397',' ','1','22','2271','COLLEGE PRIVE WEND-POUIRE L''EXCELLENCE','CP W. L''EXCELLENCE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6398',' ','1','22','2320','COLLGE PRIVE EL SCHEKINA','CP EL SCHEKINA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6399',' ','1','22','2214','COMPLEXE SCOLAIRE ZANDE','CS ZANDE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6400',' ','1','22','2214','COUR DU SOIR UPA LYCEE MUNICIPAL DE SIG-NOGHIN','CS UPA LM SIG-NOGHIN',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6401',' ','1','22','2214','COURS DU SOIR CERCLE','CS CERCLE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6402',' ','1','22','2214','cours du soir CIF- JEC','C Sr CIF -JEC',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6403',' ','1','22','2214','COURS DU SOIR COURS D''ALPHABETISATION ET ENTRAIDE CULTUREL (CAEC) 1200 LOGEMENTS','CS CAEC',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6404',' ','1','22','2320','COURS DU SOIR DAYAGNEWENDE','CS DAYAGNEWENDE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6405',' ','1','22','2214','cours du soir Ecole de Kossyam','CSr Kossyam',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6406',' ','1','22','2320','COURS DU SOIR LA VISION','CS LA VISION',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6407',' ','1','22','2214','cours du soir Lycée Thomas Sankara','Csr Lycée Thomas Sankara',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6408',' ','1','22','2320','cours du soir Mère Thérésa','CSr Mère Thérésa',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6409',' ','1','22','2214','COURS DU SOIR PAWEND-TAORE DE TANGHIN','CS PAWEND-TAORE DE TANGHIN',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6410',' ','1','22','2214','COURS DU SOIR REMALIA','CS REMALIA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6411',' ','1','22','2214','COURS DU SOIR SAINT DOMINIQUE DE ZONGO','CS ST DOMINIQUE ZONGO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6412',' ','1','22','2214','cours du Soir UPA Rimvougre ','C Sr UPA Rimvougré',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6413',' ','1','22','2320','cours du Soir Wend Yam','C Sr Wend Yam',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6414',' ','1','22','2214','GROUPE SCOLAIRE PRIVE WEND-KUNI','GSP WEND-KUNI',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6415',' ','1','22','2320','GROUPE SCOLAIRE SAINTE MERE THERESA','GS STE MERE THERESA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6416',' ','1','22','2214','Groupe scolaire Wend-Denda','GS Wend Denda',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6417',' ','1','22','2298','LYCCE PRIVE SAINT MICHEL DE PABRE','LP ST MICHEL DE PABRE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6418',' ','1','22','2214','LYCEE PRIVE ALFRED DIBAN KI-ZERBO','LP AD KZ',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6419',' ','1','22','2320','LYCEE PRIVE ALLIANCE DIVINE','LPALLIANCE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6420',' ','1','22','2214','LYCEE PRIVE ANAIA','LP ANAIA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6421',' ','1','22','2214','LYCEE PRIVE BANGR-NOOMA DE ZAGTOULI','LP BN DE ZAGTOULI',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6422',' ','1','22','2214','LYCEE PRIVE BURKINDI','LP BIRKINDI',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6423',' ','1','22','2320','LYCEE PRIVE CANA','LPCANA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6424',' ','1','22','2214','LYCEE PRIVE CARDINAL PAUL ZOUNGRANA','LP C. PAUL ZOUNGRANA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6425',' ','1','22','2214','lycée privé Classique de Nagrin','LP Classique Nagrin',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6426',' ','1','22','2214','lycée privé du Groupe scolaire EDIF','LP Groupe Scolaire EDIF',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6427',' ','1','22','2234','LYCEE PRIVE EVANGELIQUE EZRA','LP EVANGELIQUE EZRA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6428',' ','1','22','2320','LYCEE PRIVE EVANGELIQUE LA RESTAURATION','LPE REST',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6429',' ','1','22','2214','LYCEE PRIVE GUETA WENDE','LP GUETA W',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6430',' ','1','22','2214','LYCEE PRIVE KADIOGO III','LPKAD',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6431',' ','1','22','2214','lycée privé Kepler de Dayongo','LP Kepler Dayongo',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6432',' ','1','22','2214','lycée privé la Gloire de l''Eternel','LP Gloire de l''Eternel',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6433',' ','1','22','2320','lycée privé le Chandelier du Faso','LP Chandelier du Faso',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6434',' ','1','22','2320','lycée privé le Partenariat de Gambela','LP Partenariat Gambela',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6435',' ','1','22','2214','LYCEE PRIVE LE RENOUVEAU DE BOGODOGO','LP RENOUVEAU BOGODOGO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6436',' ','1','22','2214','LYCEE PRIVE LUEUR D''ESPOIR','LP LUEUR D''ESPOIR',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6437',' ','1','22','2214','LYCEE PRIVE NOTRE DAME DE YAGMA','LPN DAME YAGMA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6438',' ','1','22','2298','LYCEE PRIVE PAWEND-TAORE DE BENDATEOGA','LP PAWEND TAORE DE BENDATEOGA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6439',' ','1','22','2298','lycée privé Raaga de Sabtenga','LP Raaga de Sabtenga',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6440',' ','1','22','2320','lycée privé Rhema','LP Rhema',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6441',' ','1','22','2298','LYCEE PRIVE SHEMIDA','LYCEE PRIVE SHEMIDA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6442',' ','1','22','2271','lycée privé Sion Shimri Shemida','LP Sion Shimri Shemida',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6443',' ','1','22','2214','lycée privé Sougri-Nooma','LP Sougri Nooma',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6444',' ','1','22','2320','LYCEE PRIVE TINGUISSOM','LP TINGUISSOM',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6445',' ','1','22','2214','lycée privé Uncle Sam','LP Uncle Sam',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6446',' ','1','22','2214','LYCEE PRIVE WEND BARAKA TINSOUKA','LP WB TINSOUKA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6447',' ','1','22','2320','lycée privé Wend Yam','LP Wend Yam',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6448',' ','1','22','2234','LYCEE PRIVE WEND-DENDA DE SAONRE','LP WD DE SAONRE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6449',' ','1','22','2320','LYCEE PRIVE YOUSRA','LP YOUSRA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6450',' ','1','22','2214','UPA Lycée SONG-TAABA','UPA L. SONG-TAABA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6451',' ','1','22','2234','lycée privé Evangélique Tarwenpanga','LP EVANGELIQUE Tarwendpanga',' ')");

        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6452',' ','1','22','2234','LYCEE PRIVE SAINTE MARIE ELISE','L P S M E',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6453',' ','1','22','2271','CEG DE TENSOABTENGA','',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6454',' ','1','22','2214','COLLEGE PRIVE EVANGELIQUE JOSHUE  ZIRE ','C P JOSHUE ZIRE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6455',' ','1','22','2214','collège privé Evangélique Nabasnogo','CPE Nabasnogo',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6456',' ','1','22','2214','collège privé Israêl','CP Israêl',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6457',' ','1','22','2214','COLLEGE PRIVE LES AS','C P LES AS',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6458',' ','1','22','2214','COLLEGE PRIVE MOS AB BENOUMAIR','C P AB BENOUMAIR',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6459',' ','1','22','2214','COLLEGE PRIVE RAKISSWENDE','C P RAKISSWENDE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6460',' ','1','22','2214','COLLEGE PRIVE TILGRE','CP TILGRE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6461',' ','1','22','2214','COLLEGE PRIVE WEND TEENDA','CP W TEENDA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6462',' ','1','22','2214','COLLEGE SAINT LAURENT','C SAINTE LAURENT',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6463',' ','1','22','2214','complexe scolaire Bass-Yiiré','C S Bass Yirré',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6464',' ','1','22','2214','COMPLEXE SCOLAIRE PRIVE WEND ZOODO','C S WEND ZOODO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6465',' ','1','22','2214','COMPLEXE SCOLAIRE SAINT JUSTIN','CS ST JUSTIN',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6466',' ','1','22','2214','COMPLEXE SCOLAIRE SAINT THERAPH','C S SAINT THERAPH',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6467',' ','1','22','2214','COURS DU SOIR ECP/LMBOG','C Sr ECP LMBOG',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6468',' ','1','22','2214','COURS DU SOIR LA TROUSSE','C Sr LA TROUSSE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6469',' ','1','22','2214','cours du soir Parents d''élèves de Pissy',' C S PARENTS D''ELEVES',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6470',' ','1','22','2214','COURS DU SOIR ZAID','C S Z',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6471',' ','1','22','2214','GROUPE SCOLAIRE ADO','G S ADO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6472',' ','1','22','2214','L. P. C. S. NONGTABA','L P. S NONGTABA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6473',' ','1','22','2214','LYCEE PRIVE ALBARAKA','LP AL BARAKA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6474',' ','1','22','2214','LYCEE PRIVE CHARLES GUSTAVE','LP CH GUSTAVE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6475',' ','1','22','2214','LYCEE PRIVE EXCELLENCE TASLIM','LP EXCELLENCE TASLIM',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6476',' ','1','22','2214','LYCEE PRIVE JATHNIEL','LPJAT',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6477',' ','1','22','2214','LYCEE PRIVE LA RENAISSANCE','LP LA RENAISSANCE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6478',' ','1','22','2214','LYCEE PRIVE LA SOLUTION II','L P LA SOLUTION II',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6479',' ','1','22','2214','LYCEE PRIVE L''AXE DU SUCCES II','L P SUCCES II',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6480',' ','1','22','2214','LYCEE PRIVE LES SOMMITES','L P LES SOMMITES',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6481',' ','1','22','2214','LYCEE PRIVE L''OASIS DU SAVOIR','L P O S',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6482',' ','1','22','2214','LYCEE PRIVE LUMIERE','LP LUMIERE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6483',' ','1','22','2214','LYCEE PRIVE MARIE POUSSEPIN','L P MARIE POUSSEPIN',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6484',' ','1','22','2214','lycée privé Mixte  Wend Yam ','LP Mixte Wend Yam',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6485',' ','1','22','2214','LYCEE PRIVE NOTRE DAME DE L''EXCELLENCE','L P DAME DE L EXCELLENCE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6486',' ','1','22','2320','LYCEE PRIVE SAINT JOSEPH ARTISAN',' L P S J A',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6487',' ','1','22','2320','COLLEGE PRIVE SAINTE PERPETUE','CP STE PERPETUE',' ')");

        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6348','2','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6349','1','2')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6350','2','1')");
        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6351','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6352','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6353','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6354','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6355','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6356','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6357','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6358','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6359','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6360','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6361','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6362','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6363','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6364','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6365','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6366','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6367','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6368','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6369','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6370','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6371','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6372','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6373','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6374','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6375','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6376','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6377','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6378','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6379','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6380','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6381','2','1')");
        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6382','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6383','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6384','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6385','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6386','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6387','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6388','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6389','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6390','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6391','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6392','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6393','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6394','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6395','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6396','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6397','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6398','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6399','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6400','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6401','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6402','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6403','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6404','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6405','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6406','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6407','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6408','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6409','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6410','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6411','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6412','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6413','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6414','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6415','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6416','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6417','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6418','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6419','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6420','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6421','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6422','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6423','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6424','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6425','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6426','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6427','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6428','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6429','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6430','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6431','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6432','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6433','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6434','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6435','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6436','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6437','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6438','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6439','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6440','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6441','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6442','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6443','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6444','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6445','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6446','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6447','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6448','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6449','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6450','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6451','2','1')");
        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6452','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6453','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6454','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6455','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6456','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6457','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6458','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6459','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6460','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6461','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6462','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6463','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6464','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6465','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6466','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6467','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6468','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6469','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6470','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6471','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6472','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6473','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6474','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6475','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6476','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6477','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6478','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6479','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6480','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6481','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6482','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6483','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6484','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6485','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6486','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6487','2','1')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6488',' ','1','22','2214','COURS DU SOIR NEWTON DESCARTES','C S N D',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6489',' ','1','22','2214','C S WENDTOIN','C S W',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6490',' ','1','22','2214','LYCEE PRIVE MONT CARMEL','L P M C',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6491',' ','1','22','2214','COURS DU SOIR TANGHIN','C S T',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6492',' ','1','22','2214','COURS DU SOIR UPA LYCEE SONG TAABA','C S UPA L ST',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6493',' ','1','22','2214','COURS DU SOIR BAMBATA','C S B',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6494',' ','1','22','2214','LYCEE PRIVE BAOWEND SOMNOM DE TANGHIN','L P B S',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6495',' ','1','22','2320','COLLEGE PRIVE B EL SHADDAI','C P B EL SH',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6496',' ','1','22','2271','LYCEE PRIVE LES ERUDITS DE KOUBA','L P E K',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6497',' ','1','22','2234','LYCEE PRIVE SION SHIMRI SHEMIDA','L ¨P S S S',' ')");

        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6498',' ','1','37','6603','candidat libre Ouahigouya','CL Ouahigouya',' ')");    
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6499',' ','1','37','6480','candidat libre Kalsaka','CL Kalsaka',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6500',' ','1','37','6634','candidat libre Oula','CL Oula',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6501',' ','1','37','6480','candidat libre Berenga','CL berenga',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6502',' ','1','37','6708','candidat libre Séguénéga','CL Séguénéga',' ')");

        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6488','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6489','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6490','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6491','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6492','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6493','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6494','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6495','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6496','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6497','2','1')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6498','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6499','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6500','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6501','1','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6502','1','1')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6503',' ','1','22','2214','COURS DU SOIR SOMBLOM','CSSO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6504',' ','1','22','2214','COURS DU SOIR WENDKOUNI','CSW',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6505',' ','1','22','2214','LYCEE PRIVE SOMTA  BANGRE','LPSB',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6506',' ','1','22','2320','COURS DU SOIR DAYAGNEWENDE','CSDA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6507',' ','1','22','2320','COLLEGE PRIVE OLYMPIA','CPO',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6508',' ','1','22','2271','COLLEGE PRIVE WEND POUIRE L''EXCELLENCE','CPWPE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6509',' ','1','22','2234','COLLEGE PRIVE RABASSISSIDA','CPRB',' ')");

        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6503','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6504','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6505','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6506','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6507','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6508','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6509','2','1')");
        
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6510',' ','1','22','2214','lycee privé Daroul Houda','L P D H',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6511',' ','1','22','2214','cours du soir Benaja','C S Benaja',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6512',' ','1','28','2724','CANDIDATS LIBRES DE COMIN-YANGA','CL DE COMIN-YANGA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6513',' ','1','28','2870','CANDIDATS LIBRES DE CINKANSÉ','CL DE CINKANSÉ',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6514',' ','1','28','2759','CANDIDATS LIBRES DE DOURTENGA','CL DE DOURTENGA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6515',' ','1','28','2772','CANDIDATS LIBRES DE LALGAYE','CL DE LALGAYE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6516',' ','1','28','2788','CANDIDATS LIBRES DE OUARGAYE','CL DE OUARGAYE',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6517',' ','1','28','2801','CANDIDATS LIBRES DE SANGHA','CL DE SANGHA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6518',' ','1','28','2870','CANDIDATS LIBRES DE YARGATENGA','CL DE YARGATENGA',' ')");
        sqlList.add("INSERT INTO  structure  ( structure_id ,  codeStructure ,  typeStructure_id ,  parent_id ,  localite_id ,  nomStructure ,  acronymeStructure ,  capaciteEtablissement ) VALUES ('6519',' ','1','28','2886','CANDIDATS LIBRES DE YONDÉ','CL DE YONDÉ',' ')");
        
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6510','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6511','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6512','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6513','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6514','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6515','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6516','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6517','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6518','2','1')");
        sqlList.add("INSERT INTO etablissement (etablissement_id, statut_id, offreEnseignement_id) VALUES ('6519','2','1')");

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
     //   sqlList.add("DROP TABLE IF EXISTS candidat;");
     //   sqlList.add("DROP TABLE IF EXISTS inscription;");
     //   sqlList.add("DROP TABLE IF EXISTS choixCandidat");
        sqlList.add("DROP TABLE IF EXISTS candidatPosteJury");
        sqlList.add("DROP TABLE IF EXISTS critereCandidatPosteJury");
        sqlList.add("DROP TABLE IF EXISTS epreuveCandidatPosteJury");
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
        
        /*createSqlList.add("CREATE TABLE IF NOT EXISTS candidat (\n"
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
                + ");");
        createSqlList.add("CREATE TABLE IF NOT EXISTS inscription (\n"
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
                + ");");
        createSqlList.add("CREATE TABLE IF NOT EXISTS choixCandidat (\n"
            + "	serie_id integer NOT NULL REFERENCES serie(serie_id),\n"
            + "	session_id integer NOT NULL REFERENCES session(session_id),\n"
            + "	choixEtablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"            
            + "	etablissement_id integer NOT NULL REFERENCES etablissement(etablissement_id),\n"
            + "	candidat_id integer NOT NULL REFERENCES candidat(candidat_id),\n"
            + "	numeroDossier integer NOT NULL REFERENCES candidat(numeroDossier),\n" 
            + "	ordre integer,\n"
            + "	FOREIGN KEY(session_id,etablissement_id,candidat_id,numeroDossier) REFERENCES inscription(session_id,etablissement_id,candidat_id,numeroDossier)\n"
            + ");");*/
        
        createSqlList.add("CREATE TABLE IF NOT EXISTS candidatPosteJury (\n"
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
                + "     UNIQUE(session_id,candidat_id,matricule,structure_id),\n"
                + "	FOREIGN KEY(session_id) REFERENCES session(session_id),\n"
                + "	FOREIGN KEY(localiteCandidat_id) REFERENCES localite(localite_id),\n"
                + "	FOREIGN KEY(structure_id) REFERENCES structure(structure_id),\n"
                + "	FOREIGN KEY(poste_id) REFERENCES posteMembreJury(poste_id)\n"
                + ");");
        
        createSqlList.add("CREATE TABLE IF NOT EXISTS critereCandidatPosteJury (\n"
                + "	candidat_id integer NOT NULL,\n"
                + "	session_id integer NOT NULL,\n"
                + "	critere_id integer ,\n"
                + "	poste_id integer ,\n"
                + "	structure_id integer ,\n"
                + "	modalite_id integer ,\n"
                + "	PRIMARY KEY(candidat_id,structure_id,session_id,critere_id,poste_id,modalite_id),\n"
                + "	FOREIGN KEY(session_id,critere_id,poste_id,modalite_id) REFERENCES criterePosteJury(session_id,critere_id,poste_id,modalite_id),\n"
                + "	FOREIGN KEY(candidat_id,structure_id) REFERENCES candidatPosteJury(candidat_id,structure_id)\n"
                + ");");
        
        createSqlList.add("CREATE TABLE IF NOT EXISTS epreuveCandidatPosteJury (\n"
                + "	candidat_id integer NOT NULL,\n"
                + "	epreuve_id integer NOT NULL,\n"
                + "	option_id integer NOT NULL,\n"
                + "	structure_id integer ,\n"
                + "	PRIMARY KEY(candidat_id,structure_id,epreuve_id,option_id),\n"
                + "	FOREIGN KEY(candidat_id,structure_id) REFERENCES candidatPosteJury(candidat_id,structure_id),\n"
                + "	FOREIGN KEY(epreuve_id) REFERENCES epreuve(epreuve_id),\n"
                + "	FOREIGN KEY(option_id) REFERENCES option(option_id)\n"
                + ");");
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
