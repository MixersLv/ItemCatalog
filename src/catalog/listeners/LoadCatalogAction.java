package catalog.listeners;

import catalog.objects.CatalogItem;
import catalog.Logic;
import catalog.components.JCatalogItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadCatalogAction implements ActionListener {

    private final Logic logicClass;
    private final JFrame catalog;

    public LoadCatalogAction(Logic logicClass, JFrame catalog) {
        this.logicClass = logicClass;
        this.catalog = catalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refreshItemsList(); // refreshes items before loading the catalog for real time updates
        catalog.getContentPane().removeAll(); // removes everything from the frame
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            makeItemObject(logicClass.getItems().get(i)); // makes the objects and adds them back to the catalog frame
        }
        catalog.setVisible(true);
    }
    public void refreshItemsList(){
        logicClass.getItems().clear(); // refreshes the list by clearing it
        try {
            logicClass.readCatalog(); // reads from file and readds everything to the list
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void makeItemObject(CatalogItem item) {
        JCatalogItem curItem = new JCatalogItem(item); // makes a new JCatalog item that has all the prompts in it
        catalog.add(curItem.getCurrentObjectPanel()); // adds the newly made item using a getter
    }
}
