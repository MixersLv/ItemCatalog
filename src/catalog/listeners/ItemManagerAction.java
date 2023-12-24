package catalog.listeners;

import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemManagerAction implements ActionListener {
    private final Logic logicClass;

    public ItemManagerAction(Logic logicClass) {
        this.logicClass = logicClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logicClass.makeItem();
    }
}
