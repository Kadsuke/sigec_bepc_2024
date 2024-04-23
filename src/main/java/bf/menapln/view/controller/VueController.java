/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.view.controller;

import bf.menapln.enumeration.Sexe;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import bf.menapln.entity.*;
import bf.menapln.sigec.App;
import bf.menapln.view.controller.StatistiqueEtablissementController.DataObject;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.application.Platform;




import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author Kadsuke
 */
public abstract class VueController {
    SessionManager sessionManager = SessionManager.getInstance();
    protected App app;
    @FXML
    public TableView tableView;
    public boolean toutEstCocher =false;

    public void infoBoxSuccess(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
    public void infoBoxError(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
    
    public LocalDate formatDate(String str){
        //String test="2023/10/27";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate theDate = LocalDate.parse(str,format);
        
        return theDate;
    }
    
    public String pluriel(Integer taille){
        return (taille>1)? "s":"";
    }

    public String toUpper(String text){
        return text.toUpperCase();
    }
    
    public String firstLetterUpper(String str){
        String text = "";
        if (str == null || str.length() == 0) {
            text = str;
        }else{
            if(str.length() == 1){
                text = str.substring(0, 1).toUpperCase() + str.substring(1);
            }else{
                String[] tab = str.split(" ");
                for(int i=0; i<tab.length; i++){
                    text+=" "+tab[i].substring(0, 1).toUpperCase() + tab[i].substring(1);
                }
            }
        }
        
        return text;
    }
    public void filterOnComboBox(ComboBox<Object> combobox, ObservableList<Object> listOfData) {
        combobox.getEditor().addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            String filterItem = combobox.getEditor().getText().toLowerCase();

            // Utiliser une tâche en arrière-plan pour le filtrage
            Platform.runLater(() -> {
                ObservableList<Object> filteredItems = FXCollections.observableArrayList();
                for (Object objet : listOfData) {
                    if (objet.toString().toLowerCase().contains(filterItem)) {
                        filteredItems.add(objet);
                    }
                }

                // Mettre à jour l'interface utilisateur
                Platform.runLater(() -> {
                    combobox.setItems(filteredItems);
                    combobox.show();
                });
            });
        });
        
    
    }
    
     public ObservableList<Statistique> listStatistiqueToFxList(List liste){
        return FXCollections.observableArrayList(liste);
    }
    
    public ObservableList<StatistiqueActeur> listStatistiqueActToFxList(List liste){
        return FXCollections.observableArrayList(liste);
    }
    
    
    public ObservableList<Object> convertToFxList(List liste){
        return FXCollections.observableArrayList(liste);
    }


    public List<Objet> convertToList(ObservableList<Object> observableList) {
        List<Objet> resultList = new ArrayList<>();
        for (Object obj : observableList) {
            if (obj instanceof Objet) {
                resultList.add((Objet) obj);
            } else {
                throw new IllegalArgumentException("Unexpected type in ObservableList");
            }
        }
        return resultList;
    }


    
    public LongProperty toLongProperty(Long value){
        return new SimpleLongProperty(value);
    }
    
    public String fromEnumToString(Sexe sexe){
        if (sexe == Sexe.Masculin) {
            return "Masculin";
        } else if (sexe == Sexe.Feminin) {
            return "Feminin";
        }   else {
        return "";  // Gérez d'autres valeurs de l'enum ici si nécessaire
    }
    }
    public StringProperty toStringProperty(String value){
        return new SimpleStringProperty(value);
    }
    
    public String localDateToString(LocalDate date) {
       return date.toString();
   }
    
    public IntegerProperty toIntegerProperty(Integer value){
        return new SimpleIntegerProperty(value);
    }
    
    public DoubleProperty toDoubleProperty(Double value){
        return new SimpleDoubleProperty(value);
    }
    
    public <T> void filtrerTableView(TableView<T> tableView, String searchText) {
        // Obtenir la liste filtrée actuelle du TableView        
        FilteredList<T> filteredList = new FilteredList<>(tableView.getItems());
        // Effacer le filtre précédent
        filteredList.setPredicate(null);
        // Vérifier si le texte de recherche est vide
        if (searchText == null || searchText.isEmpty()) {
            // Afficher toutes les lignes si le texte de recherche est vide
            tableView.setItems(filteredList);
            return;
        }
        // Convertir le texte de recherche en minuscules pour une recherche insensible à la casse
        String lowerCaseSearchText = searchText.toLowerCase();
        // Définir le nouveau prédicat de filtrage
        filteredList.setPredicate(item -> {
            // Parcourir toutes les colonnes du TableView
            for (int i = 0; i < tableView.getColumns().size(); i++) {
                if (tableView.getColumns().get(i).getCellData(item)!= null) {
                    // Obtenir la valeur de la cellule dans la colonne actuelle
                   String cellValue = tableView.getColumns().get(i).getCellData(item).toString();
                   if (cellValue!=null) {
                        // Vérifier si la valeur de la cellule contient le texte de recherche
                        if (cellValue.toLowerCase().contains(lowerCaseSearchText)) {
                            return true; // Retourner true si une correspondance est trouvée
                        }
                   }
                }
            }
            return false; // Retourner false si aucune correspondance n'est trouvée
        });
        // Afficher les lignes filtrées dans le TableView
        tableView.setItems(filteredList);
    }
    
    public static <T> void setupTableWithCheckBoxes(TableView<T> tableView, List<T> elements) {
        // Créez une colonne pour les cases à cocher
        TableColumn<T, Boolean> checkBoxColumn = new TableColumn<>("Sélection");
        checkBoxColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<T, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<T, Boolean> param) {
                return new SimpleBooleanProperty(false);
            }
        });
        checkBoxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxColumn));

        // Ajoutez la colonne de cases à cocher au TableView
        tableView.getColumns().add(checkBoxColumn);

        // Créez des colonnes dynamiques pour les autres propriétés de l'objet
        if (!elements.isEmpty()) {
            T sampleElement = elements.get(0);
            for (Object property : sampleElement.getClass().getDeclaredFields()) {
                TableColumn<T, Object> column = new TableColumn<>(property.toString());
                column.setCellValueFactory(new PropertyValueFactory<>(property.toString()));
                tableView.getColumns().add(column);
            }
        }

        // Ajoutez les éléments au TableView
        tableView.getItems().addAll(elements);
    }
    
        public static void MaskWithNumberTextField(TextField textField, int maxLength) {
            Pattern numberPattern = Pattern.compile("\\d{0," + maxLength + "}");
            UnaryOperator<TextFormatter.Change> filter = change -> {
                String newText = change.getControlNewText();
                if (numberPattern.matcher(newText).matches() || newText.isEmpty()) {
                    return change;
                }
                return null; // Rejet de la modification
            };

            StringConverter<String> stringConverter = new StringConverter<>() {
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    return string;
                }
            };

            TextFormatter<String> textFormatter = new TextFormatter<>(stringConverter, null, filter);
            textField.setTextFormatter(textFormatter);
        }

    public void exportToExcel(TableView<Candidat> tableView,String titreFichier) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Données Candidat");

        // En-têtes de colonnes
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < tableView.getColumns().size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(tableView.getColumns().get(i).getText());
        }

        // Données
        for (int row = 0; row < tableView.getItems().size(); row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < tableView.getColumns().size(); col++) {
                Cell cell = dataRow.createCell(col);
                cell.setCellValue(String.valueOf(tableView.getColumns().get(col).getCellData(row)));
            }
        }

        // Enregistrement du fichier Excel
        try {
           // FileChooser fileChooser = new FileChooser();
           // fileChooser.setInitialFileName(titreFichier);
            String documentsFolderPath = "document/";
            File file = new File(documentsFolderPath,titreFichier);
           // fileChooser.setInitialDirectory(documentsFolder);
           // File file = fileChooser.showSaveDialog(new Stage());
            //if (file != null) {
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut);
                }
                
                infoBoxSuccess("Enregistrer avec succes", "Succes", null);
            //}
        } catch (IOException e) {
            infoBoxError("Une Erreur est survenu lors de l'enregistrement,Veuillez réessayer", "Erreur", null);
            // Gérer les erreurs d'exportation
        }
    }

    public String charArrToSTring(char[] tab){
        String str = "";
        for(char caracter : tab){
            str += caracter;
        }
        return str;
    }

    public String encrypte(String text){
        String encruptedText = null;
        try   
        {  
            MessageDigest m = MessageDigest.getInstance("SHA-1");  
            m.update(text.getBytes());  
              
            byte[] bytes = m.digest();  
              
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            encruptedText = s.toString();  
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
        return encruptedText;
    }
    
    
    public void exportTableViewToPdf(TableView<?> tableView, String fileName) {
        // Création d'un objet WritableImage pour stocker la capture d'écran
        WritableImage image = tableView.snapshot(new SnapshotParameters(), null);

        // Enregistrement de l'image dans un fichier
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("tableview_snapshot.png"));

            // Création d'un document PDF
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Ajout de l'image au document PDF
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(PDImageXObject.createFromFile("tableview_snapshot.png", document), 20, 20);
            contentStream.close();

            // Sauvegarde du document PDF
            document.save(fileName);
            document.close();

            System.out.println("Tableau exporté avec succès en tant que PDF : " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation du tableau en tant que PDF : " + e.getMessage());
        }
    }
    
    public void exportTableViewToWordControl(TableView<?> tableView, String fileName) {
        XWPFDocument document = new XWPFDocument();

        // Créer un paragraphe pour le titre
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("TableView Export");

        // Ajouter une ligne vide
        document.createParagraph();

        // Créer un tableau pour les données du TableView
        XWPFTable table = document.createTable();
        ObservableList<TableColumn<?, ?>> columns = (ObservableList<TableColumn<?, ?>>) tableView.getColumns();
        XWPFTableRow headerRow = table.getRow(0);
        
        // Ajouter les en-têtes de colonne au tableau
        for (int i = 0; i < columns.size(); i++) {
            if (headerRow == null) {
            headerRow = table.createRow();
            }

            while (headerRow.getTableCells().size() < 12) {
                headerRow.createCell();
            }
            headerRow.getCell(i).setText(columns.get(i).getText());
        }

        // Ajouter les données au tableau
        ObservableList<?> items = tableView.getItems();
        /*for (int i = 0; i < items.size(); i++) {
            XWPFTableRow tableRow = table.createRow();
            List<?> cells = (List<?>) items.get(i);

            for (int j = 0; j < cells.size(); j++) {
                tableRow.getCell(j).setText(cells.get(j).toString());
            }
        }*/
        for (int i = 0; i < items.size(); i++) {
            XWPFTableRow tableRow = table.createRow();
            DataObject dataObject = (DataObject) items.get(i);
            //Object item = items.get(i);
            tableRow.getCell(0).setText(dataObject.getSituation());
            tableRow.getCell(1).setText(String.valueOf(dataObject.getSituationGarcon()));
            tableRow.getCell(2).setText(String.valueOf(dataObject.getSituationFilles()));
            tableRow.getCell(3).setText(String.valueOf(dataObject.getSituationTotal()));
            
        }
        // Enregistrer le document Word
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            document.write(out);
            System.out.println("TableView exporté avec succès en tant que document Word : " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation du TableView en tant que document Word : " + e.getMessage());
        }
    }
    
    private String toStringObjectProperty(Object obj, String propertyName) {
        try {
            // Assuming JavaFX property naming conventions (e.g., "getPropertyName")
            Method method = obj.getClass().getMethod("get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
            Object value = method.invoke(obj);
            return (value != null) ? value.toString() : "";
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately for your application
            return "";
        }
    }
    
    
    public void setApp(App app){
        this.app = app;
    }
    
    public App getApp(){
        return this.app;
    }
    
    // Cocher ou décocher tout
    public void toutCocher(){
        if (toutEstCocher) {
            for (Object object : this.tableView.getItems()) {
                ((Objet)object).setChecked(false);
            }
            toutEstCocher = false;
        } else {
            for (Object object : this.tableView.getItems()) {
                ((Objet)object).setChecked(true);
            }
            toutEstCocher =true;
        }
        this.tableView.refresh();
    }

    
}
