package catalog;

import catalog.components.JDeleteItem;

import javax.swing.*;

public class ItemDeleteFrontend {

    private JFrame deleteItemFrame;
    private Logic logicClass;

    public ItemDeleteFrontend(Logic logicClass) {
        this.logicClass = logicClass;
    }

    public void runDeleteGUI() {
        makeDeleteItemFrame();
        createDeletePanels();
        initDeleteItemFrame();
    }

    private void makeDeleteItemFrame() {
        deleteItemFrame = new JFrame("Item Delete GUI");
        deleteItemFrame.setSize(200, 500);
        deleteItemFrame.setLayout(new BoxLayout(deleteItemFrame.getContentPane(), BoxLayout.Y_AXIS));
    }

    private void createDeletePanels() {
        for (int i = 0; i < logicClass.getItems().size(); i++) {
            CatalogItem currentItem = logicClass.getItems().get(i);
            makeDeleteItem(currentItem);
        }
    }

    private void makeDeleteItem(CatalogItem currentItem) {
        JDeleteItem item = new JDeleteItem(currentItem, logicClass, deleteItemFrame);
        deleteItemFrame.add(item.getCurrentItemPanel());
    }

    public void initDeleteItemFrame() {
        deleteItemFrame.setVisible(true);
    }

}
