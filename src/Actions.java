import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions implements ActionListener {
    private Frontend frontend = new Frontend();
    private Logic logic = new Logic();

    @Override
    public void actionPerformed(ActionEvent e) {

        frontend.makeItem.addActionListener(this);
        frontend.saveCatalog.addActionListener(this);
        frontend.loadCatalog.addActionListener(this);

        if (e.getSource() == frontend.makeItem){
            logic.makeItem();
        }
        if (e.getSource() == frontend.saveCatalog){
            logic.saveCatalog();
        }
        if (e.getSource() == frontend.loadCatalog){
            logic.loadCatalog();
        }

    }
}
