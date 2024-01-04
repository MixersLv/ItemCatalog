package catalog.listeners;

import catalog.CatalogItem;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteButtonAction implements ActionListener {

    private final CatalogItem currentItem;
    private final Logic logic;

    public DeleteButtonAction(CatalogItem currentItem, Logic logic) {
        this.currentItem = currentItem;
        this.logic = logic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logic.getItems().remove(currentItem);
        try {
            logic.saveCatalog();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
