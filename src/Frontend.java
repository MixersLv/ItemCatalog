import javax.swing.*;
import java.awt.*;

public class Frontend {
    private JFrame frame;
    JButton makeItem;
    JButton saveCatalog;
    JButton loadCatalog;

    public void makeFrane() {

        frame = new JFrame();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(1, 1, 1, 1));
            makeButtons();
        frame.add(makeItem);
        frame.add(saveCatalog);
        frame.add(loadCatalog);
            frame.setVisible(true);

    }

    public void makeButtons() {
        makeItem = new JButton("Make Item");
        saveCatalog = new JButton("Save Catalog");
        loadCatalog = new JButton("Load Catalog");
    }

}
