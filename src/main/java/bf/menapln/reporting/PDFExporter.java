/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.reporting;

import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;

import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author Kadsuke
 */

public class PDFExporter {
    private static String ministere;
    private static String region;
    private static String dreps;
    private static String dpeps;
    private static String etablissement;

    public static void setMinistere(String ministere) {
        PDFExporter.ministere = ministere;
    }

    public static void setRegion(String region) {
        PDFExporter.region = region;
    }

    public static void setDreps(String dreps) {
        PDFExporter.dreps = dreps;
    }

    public static void setDpeps(String dpeps) {
        PDFExporter.dpeps = dpeps;
    }

    public static void setEtablissement(String etablissement) {
        PDFExporter.etablissement = etablissement;
    }

     public static void exportToPDF(TableView<?> tableView, String filePath,boolean isLandscape) {
         Document document;
          if (isLandscape) {
                document = new Document(PageSize.A4.rotate());
            } else {
                document = new Document(PageSize.A4);
            }
        // = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Créer une table à deux colonnes pour l'en-tête
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);

            // Ajouter la partie gauche de l'en-tête
            addLeftHeader(headerTable);

            // Ajouter la partie droite de l'en-tête
            addRightHeader(headerTable);

            document.add(headerTable);
           // addHeaderValues(document);
            // Ajouter le titre en gras
            Font fontTitre = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Paragraph titre = new Paragraph("Titre du PDF", fontTitre);
            titre.setAlignment(Element.ALIGN_CENTER);
            document.add(titre);

            // Ajouter une ligne pour séparer le titre de la table
            document.add(new Chunk("\n"));

            PdfPTable pdfTable = createPdfTable(tableView);

            document.add(pdfTable);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }


    private static void addHeaderRIGHTValue(Document document, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Paragraph paragraph = new Paragraph(value);
                paragraph.setAlignment(Element.ALIGN_RIGHT);
                document.add(paragraph);
                document.add(new Paragraph("----------------------------"));
            } catch (DocumentException ex) {
                Logger.getLogger(PDFExporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void addLeftHeader(PdfPTable headerTable) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        headerTable.addCell(createCell( ministere, font,Element.ALIGN_LEFT));
        headerTable.addCell(createCell( region, font,Element.ALIGN_LEFT));
        headerTable.addCell(createCell(dreps, font,Element.ALIGN_LEFT));
        headerTable.addCell(createCell(dpeps, font,Element.ALIGN_LEFT));
        headerTable.addCell(createCell(etablissement, font,Element.ALIGN_LEFT));
    }

    private static void addRightHeader(PdfPTable headerTable) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        headerTable.addCell(createCell("Burkina Faso",font, Element.ALIGN_RIGHT));
        headerTable.addCell(createCell("Unité-Progrès-Justice", font, Element.ALIGN_RIGHT));
    }

    private static PdfPCell createCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private static PdfPCell createCell(String text, Font font, int alignment) {
        PdfPCell cell = createCell(text, font);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }

private static PdfPTable createPdfTable(TableView<?> tableView) {
    PdfPTable pdfTable = new PdfPTable(tableView.getColumns().size());
    Font font = FontFactory.getFont(FontFactory.HELVETICA, 7);

    for (TableColumn<?, ?> colonne : tableView.getColumns()) {
        pdfTable.addCell(new Paragraph(colonne.getText(),font));
    }

    ObservableList<?> items = tableView.getItems();
    for (Object item : items) {
        for (TableColumn<?, ?> colonne : tableView.getColumns()) {
            pdfTable.addCell(new Paragraph(getCellValue((TableColumn<Object, Object>) colonne, item).toString(),font));
        }
    }

    pdfTable.addCell(new Paragraph("Arrête la présente liste à "+ items.size(),font));
    return pdfTable;
}

private static String getCellValue(TableColumn<Object, Object> colonne, Object item) {
    try {
        ObservableValue<Object> cellValue = colonne.getCellObservableValue(item);
        if (cellValue != null && cellValue.getValue() != null) {
            return cellValue.getValue().toString();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "";
    }

}

    

