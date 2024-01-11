package catalog.components;

import catalog.Logic;
import catalog.listeners.BuyButtonAction;
import catalog.objects.CatalogItem;

import javax.swing.*;

public class JCatalogItem {
    private final Logic logicClass;
    private JPanel currentObjectPanel = new JPanel();
    private String strname;
    private String strtype;
    private String strprice;
    public JCatalogItem(CatalogItem currentItem, Logic logicClass) {
        this.logicClass = logicClass;

        JLabel name = new JLabel(currentItem.getName());
        JLabel type = new JLabel(currentItem.getType());
        JLabel price = new JLabel(currentItem.getPrice());

        strname = currentItem.getName();
        strtype = currentItem.getType();
        strprice = currentItem.getPrice();

        currentObjectPanel.add(name);
        currentObjectPanel.add(type);
        currentObjectPanel.add(price);
        JButton buyButton = new JButton("Buy");
        buyButton.addActionListener(new BuyButtonAction(this, this.logicClass));
        currentObjectPanel.add(buyButton);
    }

    public JPanel getCurrentObjectPanel() {
        return currentObjectPanel;
    }

    public String getStrname() {
        return strname;
    }
    public String getStrtype() {
        return strtype;
    }
    public String getStrprice() {
        return strprice;
    }
}
