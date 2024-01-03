package catalog.listeners;

import catalog.Frontend;
import catalog.ItemDeleteFrontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemAction implements ActionListener {
    private Logic logicClass;
    private final Frontend frontendClass;
    private ItemDeleteFrontend itemDeleteFrontendClass = new ItemDeleteFrontend(logicClass);

    public DeleteItemAction(Logic logicClass, Frontend frontendClass) {
        this.logicClass = logicClass;
        this.frontendClass = frontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemDeleteFrontendClass.runDeleteGUI();
    }
}
