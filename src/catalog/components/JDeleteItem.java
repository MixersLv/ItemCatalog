package catalog.components;

import catalog.CatalogItem;
import catalog.Logic;
import catalog.listeners.DeleteButtonAction;

import javax.swing.*;

public class JDeleteItem {
    private final JPanel currentItemPanel = new JPanel();

    public JDeleteItem(CatalogItem currentItem, Logic logicClass, JFrame deleteItemFrame) {
        //PANEL
        JLabel currentItemName = new JLabel(currentItem.getName());
        JLabel currentItemType = new JLabel(currentItem.getType());
        JLabel currentItemPrice = new JLabel(currentItem.getPrice());
        currentItemPanel.add(currentItemName);
        currentItemPanel.add(currentItemType);
        currentItemPanel.add(currentItemPrice);
        //DELETE BUTTON
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonAction(currentItem, logicClass, deleteItemFrame, currentItemPanel));
        currentItemPanel.add(deleteButton);
    }

    public JPanel getCurrentItemPanel() {
        return currentItemPanel;
    }
}
