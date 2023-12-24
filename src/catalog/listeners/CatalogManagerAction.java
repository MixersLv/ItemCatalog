package catalog.listeners;

import catalog.Frontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogManagerAction  implements ActionListener {
    Logic logicClass;
    // Frontend frontendClass;
    public CatalogManagerAction(Logic logicClass) {
        this.logicClass = logicClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // frontendClass.initframe
    }
}
