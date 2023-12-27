package catalog.listeners;

import catalog.Frontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemAction implements ActionListener {
    Logic logicClass;
    Frontend frontendClass;

    public DeleteItemAction(Logic logicClass, Frontend frontendClass) {
        this.logicClass = logicClass;
        this.frontendClass = frontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logicClass.deleteItem();
    }
}
