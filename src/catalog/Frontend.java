package catalog;

import catalog.listeners.*;

import javax.swing.*;
import java.awt.*;

public class Frontend {
    private JFrame frame;
    private JFrame catalogframe;
    private JButton catalogManager;
    private JButton loadCatalog;
    private JFrame itemGUI;
    private JButton makeItemButton;
    private JButton saveItemButton;
    private JButton deleteItemButton;
    private final Logic logicClass;
    private final ItemManagerFrontend itemManagerFrontend;
    private ItemDeleteFrontend itemDeleteFrontendClass;

    public Frontend(Logic logicClass, ItemManagerFrontend itemManagerFrontend, ItemDeleteFrontend itemDeleteFrontendClass) {
        this.logicClass = logicClass;
        this.itemManagerFrontend = itemManagerFrontend;
        this.itemDeleteFrontendClass = itemDeleteFrontendClass;
    }

    public void makeFrame() {
        makeButtons();
        frame = new JFrame();
        frame.setTitle("Store");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(1, 1, 1, 1));
        frame.add(catalogManager);
        frame.add(loadCatalog);
        frame.setVisible(true);
    }

    public void makeCatalogFrame() {
        catalogframe = new JFrame();
        catalogframe.setTitle("Item Catalog");
        catalogframe.setLocationRelativeTo(null);
        catalogframe.setSize(300, 600);
        catalogframe.setBackground(Color.gray);
        catalogframe.setLayout(new BoxLayout(catalogframe.getContentPane(), BoxLayout.Y_AXIS));
    }
    //should be just a method that calls this but the whole thing should be in itemManagerFrontend Class
    public void makeCatalogManagerFrame(){
        itemGUI = new JFrame();
        itemGUI.setSize(400,200);
        itemGUI.setTitle("Catalog Manager");
        itemGUI.setLocationRelativeTo(null);
        itemGUI.setLayout(new FlowLayout());
        makeCatalogManagerButtons();
    }
    //This whole thing should probably be moved to the ItemManagerFrontend Class
    public void makeCatalogManagerButtons(){
        makeItemButton = new JButton("Make Item");
        saveItemButton = new JButton("Save");
        deleteItemButton = new JButton("Delete item");
        //Make listener object for each button
        MakeItemAction makeItemListener = new MakeItemAction(logicClass,itemManagerFrontend);
        SaveItemAction saveItemListener =new SaveItemAction(logicClass,this);
        DeleteItemAction deleteItemListener = new DeleteItemAction(logicClass,this, itemDeleteFrontendClass);
        //add acion listener to each button
        makeItemButton.addActionListener(makeItemListener);
        saveItemButton.addActionListener(saveItemListener);
        deleteItemButton.addActionListener(deleteItemListener);
        //add buttons to manager frame
        itemGUI.add(makeItemButton);
        itemGUI.add(saveItemButton);
        itemGUI.add(deleteItemButton);
    }
    //this should be moved too
    public void initItemManager(){
        itemGUI.setVisible(true);
    }

    public void makeButtons() {
        ItemManagerAction itemManagerListener = new ItemManagerAction(this);
        LoadCatalogAction loadCatalogListener = new LoadCatalogAction(logicClass, catalogframe);
        catalogManager = new JButton("Catalog Manager");
        loadCatalog = new JButton("Catalog");
        catalogManager.addActionListener(itemManagerListener);
        loadCatalog.addActionListener(loadCatalogListener);
    }

}
