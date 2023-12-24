package catalog;

import catalog.listeners.CatalogManagerAction;
import catalog.listeners.LoadCatalogAction;
import catalog.listeners.ItemManagerAction;
import catalog.listeners.SaveCatalogAction;

import javax.swing.*;
import java.awt.*;

public class Frontend {
    JFrame frame;
    JFrame catalogframe;
    JButton makeItem;
    JButton saveCatalog;
    JButton loadCatalog;
    JFrame itemGUI;
    JButton makeItemButton;
    JButton saveItemButton;
    JButton deleteItemButton;
    Logic logicClass;

    public Frontend(Logic logicClass) {
    this.logicClass = logicClass;
    }

    public void makeFrame() {
        makeButtons();
        frame = new JFrame();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(1, 1, 1, 1));
        frame.add(makeItem);
        frame.add(saveCatalog);
        frame.add(loadCatalog);
        frame.setVisible(true);
    }

    public void makeCatalogFrame() {
        catalogframe = new JFrame();
        catalogframe.setTitle("Item Catalog");
        catalogframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        catalogframe.setSize(300, 600);
        catalogframe.setBackground(Color.gray);
        catalogframe.setLayout(new BoxLayout(catalogframe.getContentPane(), BoxLayout.Y_AXIS));
    }

    public void makeCatalogManagerFrame(){
        itemGUI = new JFrame();
        itemGUI.setSize(400,200);
        itemGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemGUI.setTitle("Catalog Manager");
        itemGUI.setLocationRelativeTo(null);
        itemGUI.setLayout(new FlowLayout());
        makeCatalogManagerButtons();
    }
    public void makeCatalogManagerButtons(){
        makeItemButton = new JButton("Make Item");
        saveItemButton = new JButton("Save Item");
        deleteItemButton = new JButton("Delete item");
        //Make listener object for each button
        CatalogManagerAction makeItemListener = new CatalogManagerAction(logicClass);
        CatalogManagerAction saveItemListener =  new CatalogManagerAction(logicClass);
        CatalogManagerAction deleteItemListener = new CatalogManagerAction(logicClass);
        //add acion listener to each button
        makeItemButton.addActionListener(makeItemListener);
        saveItemButton.addActionListener(saveItemListener);
        deleteItemButton.addActionListener(deleteItemListener);
        //add buttons to manager frame
        itemGUI.add(makeItemButton);
        itemGUI.add(saveItemButton);
        itemGUI.add(deleteItemButton);
    }
    public void initItemManager(){
        itemGUI.setVisible(true);
    }

    public void makeButtons() {
        ItemManagerAction makeNewItemButtonListener = new ItemManagerAction(logicClass);
        SaveCatalogAction saveCatalogListener = new SaveCatalogAction(logicClass);
        LoadCatalogAction loadCatalogListener = new LoadCatalogAction(logicClass, catalogframe);
        makeItem = new JButton("Catalog Manager");
        saveCatalog = new JButton("Save Catalog");
        loadCatalog = new JButton("Load Catalog");
        makeItem.addActionListener(makeNewItemButtonListener);
        saveCatalog.addActionListener(saveCatalogListener);
        loadCatalog.addActionListener(loadCatalogListener);
    }
}
