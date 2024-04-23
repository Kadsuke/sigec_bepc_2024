/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.generique;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ActionButtonTableCell<T> extends TableCell<T, Void> {
    private final Button editButton = new Button();
    private final Button deleteButton = new Button();

    
    public ActionButtonTableCell(
        EventHandler<ActionEvent> editAction, 
        EventHandler<ActionEvent> deleteAction
    ) {
        Image editIcon = new Image(getClass().getResourceAsStream("/images/edit.png"));
        Image deleteIcon = new Image(getClass().getResourceAsStream("/images/delete.png"));

        // Créez les ImageView avec les icônes
        ImageView editImageView = new ImageView(editIcon);
        ImageView deleteImageView = new ImageView(deleteIcon);

        // Ajustez la taille des icônes si nécessaire
        editImageView.setFitWidth(18);
        editImageView.setFitHeight(18);
        deleteImageView.setFitWidth(18);
        deleteImageView.setFitHeight(18);
        // Définissez les ImageView comme graphiques des boutons
        editButton.setGraphic(editImageView);
        deleteButton.setGraphic(deleteImageView);
        editButton.setStyle("-fx-background-color: lightblue;");
        deleteButton.setStyle("-fx-background-color: lightcoral;");
        editButton.setOnAction(event -> {
            if (getTableRow() != null) {
                T item = getTableView().getItems().get(getIndex());
                editAction.handle(new ActionEvent(item, null));
            }
        });

        deleteButton.setOnAction(event -> {
            if (getTableRow() != null) {
                T item = getTableView().getItems().get(getIndex());
                deleteAction.handle(new ActionEvent(item, null));
            }
        });
        
        HBox.setMargin(deleteButton, new Insets(0, 0, 0, 8));
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(new HBox(editButton, deleteButton));
        }
    }

    public static <T> TableColumn<T, Void> createTableColumn(
        TableView<T> tableView,
        EventHandler<ActionEvent> editAction, 
        EventHandler<ActionEvent> deleteAction
    ) {
        TableColumn<T, Void> column = new TableColumn<>("Actions");
        column.setCellFactory(param -> new ActionButtonTableCell<>(editAction, deleteAction));
        tableView.getColumns().add(column);
        return column;
    }
}
