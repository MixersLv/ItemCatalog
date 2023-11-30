import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frontend {
    JFrame frame;
    JButton makeItem;
    JButton saveCatalog;
    JButton loadCatalog;

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

    public void makeButtons(){
        Actions actions = new Actions();

        makeItem = new JButton("Make Item");
        saveCatalog = new JButton("Save Catalog");
        loadCatalog = new JButton("Load Catalog");
            makeItem.addActionListener(actions);
            saveCatalog.addActionListener(actions);
            loadCatalog.addActionListener(actions);
    }

}
