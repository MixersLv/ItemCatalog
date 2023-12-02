import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frontend implements ActionListener{
    JFrame frame;
    JFrame catalogframe;
    JButton makeItem;
    JButton saveCatalog;
    JButton loadCatalog;
    Logic logicClass = new Logic();

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
    public void makeCatalogFrame(){
        catalogframe = new JFrame();
        catalogframe.setTitle("Item Catalog");
        catalogframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        catalogframe.setSize(300,600);
        catalogframe.setBackground(Color.gray);
        catalogframe.setLayout(new FlowLayout());

    }

    public void makeItemObject(String objectName, String objectType, String objectPrice){
        JPanel object = new JPanel();
        JLabel name = new JLabel(objectName);
        JLabel type = new JLabel(objectType);
        JLabel price = new JLabel(objectPrice);
        object.add(name);
        object.add(type);
        object.add(price);
        catalogframe.add(object);
    }

    public void makeButtons(){
        Actions actions = new Actions();

        makeItem = new JButton("Make Item");
        saveCatalog = new JButton("Save Catalog");
        loadCatalog = new JButton("Load Catalog");
            makeItem.addActionListener(this);
            saveCatalog.addActionListener(this);
            loadCatalog.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==makeItem){
                logicClass.makeItem();
        }
        if (e.getSource()==saveCatalog){
            try {
                logicClass.saveCatalog();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource()==loadCatalog){
            catalogframe.setVisible(true);
            try {
                    logicClass.loadCatalog();
                    makeItemObject(logicClass.itemName, logicClass.itemType, logicClass.itemPrice);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
