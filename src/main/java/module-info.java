module bf.menapln.sigec {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.xerial.sqlitejdbc;
    requires java.sql;
    requires java.base;
    
    opens bf.menapln.sigec to javafx.fxml;
    opens bf.menapln.view.controller to javafx.fxml;
    opens bf.menapln.controller to javafx.base;
    opens bf.menapln.entity to javafx.base;
    opens bf.menapln.dataModel to javafx.base;
    exports bf.menapln.controller;
    exports bf.menapln.view.controller;
    exports bf.menapln.sigec;
    requires jbcrypt;
    requires org.apache.pdfbox;
    requires barcodes;
    requires icepdf.core;
    requires icepdf.viewer;
    requires itextpdf;
    requires javafx.swingEmpty;
    requires javafx.swing;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.commons.lang3;
    requires org.apache.commons.io;
    requires de.jensd.fx.glyphs.fontawesome;
    requires kernel;
    requires io;
    requires layout;

      
}
