package catalog.listeners;

import catalog.CatalogItem;
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

    public DeleteButtonAction(CatalogItem currentItem, Logic logic, JFrame deleteItemFrame, JPanel currentItemPanel) {
        this.currentItem = currentItem;
        this.logic = logic;
        this.currentItemPanel = currentItemPanel;
        this.deleteItemFrame = deleteItemFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
