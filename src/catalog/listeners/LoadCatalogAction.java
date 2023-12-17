package catalog.listeners;

import catalog.CatalogItem;
import catalog.Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadCatalogAction implements ActionListener {

    private final Logic logicClass;
    private final JFrame catalog;

    public LoadCatalogAction(Logic logicClass, JFrame catalog) {
        this.logicClass = logicClass;
        this.catalog = catalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        catalog.setVisible(true);
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            makeItemObject(logicClass.getItems().get(i));
        }
    }

    public void makeItemObject(CatalogItem item) {
        JPanel object = new JPanel();
        JLabel name = new JLabel(item.getName());
        JLabel type = new JLabel(item.getType());
        JLabel price = new JLabel(item.getPrice());
        object.add(name);
        object.add(type);
        object.add(price);
        catalog.add(object);
    }
}
