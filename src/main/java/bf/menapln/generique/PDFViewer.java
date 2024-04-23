/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.generique;

import bf.menapln.entity.Candidat;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
/**
 *
 * @author Kadsuke
 */
public class PDFViewer {
    public static void afficherPDF(String pdfFilePath, Stage primaryStage) {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            // Afficher la première page du PDF
            BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // 300 DPI
            Image fxImage = javafx.embed.swing.SwingFXUtils.toFXImage(image, null);
            ImageView imageView = new ImageView(fxImage);

            // Mettre l'ImageView dans une StackPane (ou tout autre conteneur de votre choix)
            StackPane root = new StackPane();
            root.getChildren().add(imageView);

            // Créer la scène et afficher la fenêtre
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("PDF Viewer");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
