package catalog.components;

import catalog.listeners.BuyButtonAction;
import catalog.objects.CatalogItem;

import javax.swing.*;

public class JCatalogItem {
    private JPanel currentObjectPanel = new JPanel();
    public JCatalogItem(CatalogItem currentItem) {
        JLabel name = new JLabel(currentItem.getName());
        JLabel type = new JLabel(currentItem.getType());
        JLabel price = new JLabel(currentItem.getPrice());
        currentObjectPanel.add(name);
        currentObjectPanel.add(type);
        currentObjectPanel.add(price);
        JButton buyButton = new JButton("Buy");
        buyButton.addActionListener(new BuyButtonAction(this));
        currentObjectPanel.add(buyButton);
    }

    public JPanel getCurrentObjectPanel() {
        return currentObjectPanel;
    }
}
