package catalog.listeners;

import catalog.ItemManagerFrontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeItemAction implements ActionListener {
    private final Logic logicClass;
    private final ItemManagerFrontend itemManagerFrontend;

    public MakeItemAction(Logic logicClass, ItemManagerFrontend itemManagerFrontend) {
        this.logicClass = logicClass;
        this.itemManagerFrontend = itemManagerFrontend;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemManagerFrontend.makeMakeItemFrame();
        itemManagerFrontend.initMakeItemFrame();
    }
}
