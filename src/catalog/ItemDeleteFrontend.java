package catalog;

import catalog.listeners.DeleteButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ItemDeleteFrontend {

    private JFrame deleteItemFrame;
    private Logic logicClass;
    private int currentItemCount = logicClass.getItems().size();

    public ItemDeleteFrontend(Logic logicClass) {
        this.logicClass = logicClass;
    }

    public void runDeleteGUI(){
        makeDeleteItemFrame();
        getPanelProperties();
        initDeleteItemFrame();
    }
    private void makeDeleteItemFrame(){
        deleteItemFrame = new JFrame("Item Delete GUI");
        deleteItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteItemFrame.setSize(200,500);
        deleteItemFrame.setLayout(new BoxLayout(deleteItemFrame.getContentPane(), BoxLayout.Y_AXIS));
    }
    private void getPanelProperties(){
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            CatalogItem currentItem = logicClass.getItems().get(i);
            makeDeleteItems(currentItem);
        }
    }

    private void makeDeleteItems(CatalogItem currentItem){
        for (int i = 0; i < currentItemCount; i++) {
            //PANELS
            JPanel currentItemPanel = new JPanel();
            JLabel currentItemName = new JLabel(currentItem.getName());
            JLabel currentItemType = new JLabel(currentItem.getType());
            JLabel currentItemPrice = new JLabel(currentItem.getPrice());
            currentItemPanel.add(currentItemName);
            currentItemPanel.add(currentItemType);
            currentItemPanel.add(currentItemPrice);

            //DELETE BUTTONS
            JButton deleteButton = new JButton("Delete");
            deleteButton.putClientProperty("index",i);
            deleteButton.addActionListener(new DeleteButtonAction(i));
            currentItemPanel.add(deleteButton);
        }
    }


    public void initDeleteItemFrame(){
        deleteItemFrame.setVisible(true);
    }

}
