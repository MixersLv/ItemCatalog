package catalog.listeners;

import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveCatalogAction implements ActionListener {

    private final Logic logicClass;
    public SaveCatalogAction(Logic logicClass) {
        this.logicClass = logicClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            logicClass.saveCatalog();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
