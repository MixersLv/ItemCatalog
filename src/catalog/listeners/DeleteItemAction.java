package catalog.listeners;

import catalog.Frontend;
import catalog.ItemDeleteFrontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemAction implements ActionListener {
    private Logic logicClass;
    private final Frontend frontendClass;
    private ItemDeleteFrontend itemDeleteFrontendClass;

    public DeleteItemAction(Logic logicClass, Frontend frontendClass, ItemDeleteFrontend itemDeleteFrontendClass) {
        this.logicClass = logicClass;
        this.frontendClass = frontendClass;
        this.itemDeleteFrontendClass = itemDeleteFrontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemDeleteFrontendClass.runDeleteGUI();
    }
}
