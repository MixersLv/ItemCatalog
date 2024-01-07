package catalog.listeners;

import catalog.components.JCatalogItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyButtonAction implements ActionListener {
    private final JCatalogItem currentItem;
    public BuyButtonAction(JCatalogItem currentItem){
        this.currentItem = currentItem;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("test BUY " + currentItem.hashCode());
    }
}
