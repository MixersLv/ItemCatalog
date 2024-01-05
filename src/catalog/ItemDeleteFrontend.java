package catalog;

import catalog.listeners.DeleteButtonAction;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemDeleteFrontend {

    private JFrame deleteItemFrame;
    private Logic logicClass;

    public ItemDeleteFrontend(Logic logicClass) {
        this.logicClass = logicClass;
    }

    public void runDeleteGUI(){
        makeDeleteItemFrame();
        createDeletePanels();
        initDeleteItemFrame();
    }
    private void makeDeleteItemFrame(){
        deleteItemFrame = new JFrame("Item Delete GUI");
        deleteItemFrame.setSize(200,500);
        deleteItemFrame.setLayout(new BoxLayout(deleteItemFrame.getContentPane(), BoxLayout.Y_AXIS));
    }
    private void createDeletePanels(){
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            CatalogItem currentItem = logicClass.getItems().get(i);
            makeDeleteItem(currentItem);
        }
    }

    private void makeDeleteItem(CatalogItem currentItem){
            //PANEL
            JPanel currentItemPanel = new JPanel();
            JLabel currentItemName = new JLabel(currentItem.getName());
            JLabel currentItemType = new JLabel(currentItem.getType());
            JLabel currentItemPrice = new JLabel(currentItem.getPrice());
            currentItemPanel.add(currentItemName);
            currentItemPanel.add(currentItemType);
            currentItemPanel.add(currentItemPrice);
            //DELETE BUTTON
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new DeleteButtonAction(currentItem,logicClass, deleteItemFrame, currentItemPanel, this));
            currentItemPanel.add(deleteButton);
            deleteItemFrame.add(currentItemPanel);
    }

    public void confirmDelete(){
        JFrame confirmFrame = new JFrame("Confirm delete");
        confirmFrame.setSize(200,100);
        confirmFrame.setLayout(new FlowLayout());

        JButton confirmDeleteButton = new JButton("YES");
        JButton denyDeleteButton = new JButton("NO");

        confirmDeleteButton.addActionListener();
        denyDeleteButton.addActionListener();

        confirmFrame.add(confirmDeleteButton);
        confirmFrame.add(denyDeleteButton);

        confirmFrame.setVisible(true);
    }

    public void initDeleteItemFrame(){
        deleteItemFrame.setVisible(true);
    }

}
