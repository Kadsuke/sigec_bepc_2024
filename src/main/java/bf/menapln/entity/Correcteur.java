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
public class Correcteur extends Membre{
    private EpreuveOptions epreuveOption;
    private Epreuve epreuve;
    private Integer nbCopie;
    
    public Correcteur(Map data) {
        super(data);
        this.setEpreuve((Epreuve) data.get("epreuve"));
    }
    
    public Correcteur(ResultSet rs) throws SQLException{
        super(rs);
    }
    
    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Integer getNbCopie() {
        return nbCopie;
    }

    public void setNbCopie(Integer nbCopie) {
        this.nbCopie = nbCopie;
    }
    
    
    
    @Override
    public String toString(){
        return this.getPersonnel().getId()+"-"+this.getPersonnel().getNom()+" "+this.getPersonnel().getPrenom();
    }

    public EpreuveOptions getEpreuveOption() {
        return epreuveOption;
    }

    public void setEpreuveOption(EpreuveOptions epreuveOption) {
        this.epreuveOption = epreuveOption;
    }
}
