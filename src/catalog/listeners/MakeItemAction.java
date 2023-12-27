package catalog.listeners;

import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeItemAction implements ActionListener {
    private final Logic logicClass;

    public MakeItemAction(Logic logicClass) {
        this.logicClass = logicClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logicClass.makeItem();
    }
}
