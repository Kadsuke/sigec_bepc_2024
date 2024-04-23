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

public class WordExporter {

    public static  void exportToWord(TableView<?> tableView, String filePath) {
        try (XWPFDocument document = new XWPFDocument()) {
            // Create a new paragraph for the title
            XWPFParagraph titleParagraph = document.createParagraph();
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setBold(true);
            titleRun.setFontSize(14);
            titleRun.setText("Titre du Word Document");

            // Create a new paragraph for the table
            XWPFParagraph tableParagraph = document.createParagraph();

            // Create the table
            XWPFTable table = document.createTable();

            // Set column names as the first row
            List<TableColumn<?, ?>> columns = (List<TableColumn<?, ?>>) tableView.getColumns();
            XWPFTableRow headerRow = table.getRow(0);
            for (int i = 0; i < columns.size(); i++) {
                if (headerRow == null) {
                    headerRow = table.createRow();
                    }

                    while (headerRow.getTableCells().size() < 4) {
                        headerRow.createCell();
                    }
                headerRow.getCell(i).setText(columns.get(i).getText());
            }

            // Populate the table with data
            ObservableList<?> items = tableView.getItems();
            for (Object item : items) {
                XWPFTableRow row = table.createRow();
                for (int i = 0; i < columns.size(); i++) {
                    XWPFTableCell cell = row.getCell(i);
                    cell.setText(getCellValue((TableColumn<Object, Object>) columns.get(i), item));
                }
            }

            // Save the document
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(TableColumn<Object, Object> column, Object item) {
        try {
            ObservableValue<Object> cellValue = column.getCellObservableValue(item);
            if (cellValue != null && cellValue.getValue() != null) {
                return cellValue.getValue().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

    

