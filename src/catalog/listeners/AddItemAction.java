package catalog.listeners;

import catalog.ItemManagerFrontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemAction implements ActionListener {
    private final Logic logicClass;
    private final ItemManagerFrontend itemManagerFrontendClass;

    public AddItemAction(Logic logicClass, ItemManagerFrontend itemManagerFrontendClass) {
        this.logicClass = logicClass;
        this.itemManagerFrontendClass = itemManagerFrontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logicClass.takeItemProperties();
        logicClass.addItemToList();
        itemManagerFrontendClass.closeMakeItemFrame();
    }
}
