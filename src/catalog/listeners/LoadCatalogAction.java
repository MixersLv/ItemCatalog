package catalog.listeners;

import catalog.CatalogItem;
import catalog.Logic;

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
        catalog.getContentPane().removeAll();
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            makeItemObject(logicClass.getItems().get(i));
        }
        catalog.setVisible(true);
    }
    public void refreshItemsList(){
        logicClass.getItems().clear();
        try {
            logicClass.readCatalog();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void makeItemObject(CatalogItem item) {
        JPanel currentObject = new JPanel();
        JLabel name = new JLabel(item.getName());
        JLabel type = new JLabel(item.getType());
        JLabel price = new JLabel(item.getPrice());
        currentObject.add(name);
        currentObject.add(type);
        currentObject.add(price);
        catalog.add(currentObject);
    }
}
