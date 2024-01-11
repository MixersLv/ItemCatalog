package catalog.listeners;

import catalog.Logic;
import catalog.components.JCatalogItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyButtonAction implements ActionListener {
    private final JCatalogItem currentItem;
    private final Logic logicClass;
    public BuyButtonAction(JCatalogItem currentItem, Logic logicClass){ // prob will need more params such as logicclass for the shopping list
        this.currentItem = currentItem;
        this.logicClass = logicClass;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        logicClass.addItemToCart(currentItem);
        System.out.println("----------------------");
        logicClass.testCart();
    }
}
