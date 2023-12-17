package catalog;

import catalog.listeners.LoadCatalogAction;
import catalog.listeners.MakeItemAction;
import catalog.listeners.SaveCatalogAction;

import javax.swing.*;
import java.awt.*;

public class Frontend {
    JFrame frame;
    JFrame catalogframe;
    JButton makeItem;
    JButton saveCatalog;
    JButton loadCatalog;
    //Bob
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
        catalogframe.setLayout(new FlowLayout());

    }


    public void makeButtons() {
        MakeItemAction makeNewItemButtonListener = new MakeItemAction(logicClass);
        SaveCatalogAction saveCatalogListener = new SaveCatalogAction(logicClass);
        LoadCatalogAction loadCatalogListener = new LoadCatalogAction(logicClass, catalogframe);
        makeItem = new JButton("Make Item");
        saveCatalog = new JButton("Save Catalog");
        loadCatalog = new JButton("Load Catalog");
        makeItem.addActionListener(makeNewItemButtonListener);
        saveCatalog.addActionListener(saveCatalogListener);
        loadCatalog.addActionListener(loadCatalogListener);
    }
}
