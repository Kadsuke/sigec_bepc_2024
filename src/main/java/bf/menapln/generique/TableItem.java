/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.menapln.generique;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author LENOVO
 */
 public class TableItem<T> {
    private T data;
    private final EventHandler<ActionEvent> editAction;
    private final EventHandler<ActionEvent> deleteAction;

    public TableItem(T data, EventHandler<ActionEvent> editAction, EventHandler<ActionEvent> deleteAction) {
        this.data = data;
        this.editAction = editAction;
        this.deleteAction = deleteAction;
    }

    public T getData() {
        return data;
    }

    public EventHandler<ActionEvent> getEditAction() {
        return editAction;
    }

    public EventHandler<ActionEvent> getDeleteAction() {
        return deleteAction;
    }
}
