package catalog.listeners;

import catalog.Frontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveItemAction implements ActionListener {
    private final Logic logicClass;
    private final Frontend frontendClass;

    public SaveItemAction(Logic logicClass, Frontend frontendClass) {
        this.logicClass = logicClass;
        this.frontendClass = frontendClass;
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
