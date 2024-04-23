/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.reporting;

import bf.menapln.entity.Candidat;
import bf.menapln.entity.CandidatJury;
import bf.menapln.entity.Objet;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kadsuke
 */
public class ListeCandidatJury extends PDF{
    public ListeCandidatJury(){
        this.setSubFolder("ListeCandidat");
        this.setPageSize(PageSize.A4.rotate());
        this.fonction[0] = "Le Proviseur/Directeur";
        this.signataire[0] = "";
        this.signataire[0] = this.signataire[0].concat(" somda");
        this.signataire[1] = "SD";
        
    }
    @Override
    public void setTableBody(Table table) {
        if (!this.liste.isEmpty()) {
                for(Objet o : this.liste){
                    CandidatJury candidat = (CandidatJury)o;
                    table.addCell(candidat.getCandidat().getNom());
                    table.addCell(candidat.getCandidat().getPrenom());
                    table.addCell(candidat.getCandidat().getSexe().toString());
                    table.addCell(formatDate(candidat.getCandidat().getDateNaissance(),candidat.getCandidat().getTypeDateNaissance())+" à "+candidat.getCandidat().getLieuNaissance());
                    table.addCell(candidat.getCandidat().getSport());
                    table.addCell(candidat.getCandidat().getOption().getOptionLibelle());
                    table.addCell(candidat.getCandidat().getCentreExamen().getNomLoclite()); 
                    table.addCell(candidat.getJury().getJuryLibelle());
            }       
        }

        
    }
    
    @Override
    public void body() {
        super.body();
        Table tab = new Table(this.tableHeaderData.length);
        tab.setWidth(UnitValue.createPercentValue(100));
        this.setTableHeader(tab);
        this.setTableBody(tab);
        this.document.add(tab);
    }
    
    public String formatDate(LocalDate date, String typeDate){
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = null;
        if(date != null){
            if(!typeDate.equalsIgnoreCase("Le")){
                formattedDate = typeDate+" "+date_formatter.format(date);
            }else{
                formattedDate = "Le "+DATE_FORMATTER.format(date);
            }
        }
         //formattedDate = date != null ? DATE_FORMATTER.format(date) : "";
        return formattedDate;
    }
}