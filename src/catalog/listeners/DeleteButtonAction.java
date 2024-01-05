package catalog.listeners;

import catalog.CatalogItem;
import catalog.ItemDeleteFrontend;
import catalog.Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteButtonAction implements ActionListener {

    private final CatalogItem currentItem;
    private final Logic logic;
    private final JPanel currentItemPanel;
    private final JFrame deleteItemFrame;
    private final ItemDeleteFrontend itemDeleteFrontend;

    public DeleteButtonAction(CatalogItem currentItem, Logic logic, JFrame deleteItemFrame, JPanel currentItemPanel, ItemDeleteFrontend itemDeleteFrontend) {
        this.currentItem = currentItem;
        this.logic = logic;
        this.itemDeleteFrontend = itemDeleteFrontend; // to run deleteconfirm
        this.currentItemPanel = currentItemPanel; // added so i can remove the panel from the frame after item is deleted
        this.deleteItemFrame = deleteItemFrame; // same thing ^
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemDeleteFrontend.confirmDelete();
        //add a confirm delete function
        logic.getItems().remove(currentItem);
        deleteItemFrame.remove(currentItemPanel);
        //maybe need to refresh the catalog again aswell, but it works
        try {
            logic.saveCatalog();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
