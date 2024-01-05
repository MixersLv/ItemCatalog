package catalog.listeners;

import catalog.CatalogItem;
import catalog.ItemDeleteFrontend;
import catalog.Logic;
import catalog.components.JConfirmDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteButtonAction implements ActionListener {

    private final CatalogItem currentItem;
    private final Logic logic;
    private final JPanel currentItemPanel;
    private final JFrame deleteItemFrame;

    public DeleteButtonAction(CatalogItem currentItem, Logic logic, JFrame deleteItemFrame, JPanel currentItemPanel) {
        this.currentItem = currentItem;
        this.logic = logic;
        this.currentItemPanel = currentItemPanel; // added so i can remove the panel from the frame after item is deleted
        this.deleteItemFrame = deleteItemFrame; // same thing ^
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JConfirmDialog dialog = new JConfirmDialog("Do you want to delete this item?", () -> {
            //add a confirm delete function
            logic.getItems().remove(currentItem);
            deleteItemFrame.remove(currentItemPanel);
            deleteItemFrame.repaint();
            //maybe need to refresh the catalog again as well, but it works
            try {
                logic.saveCatalog();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        dialog.show();
    }
}
