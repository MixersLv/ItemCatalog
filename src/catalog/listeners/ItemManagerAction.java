package catalog.listeners;

import catalog.Frontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemManagerAction implements ActionListener {
    private final Frontend frontendClass;

    public ItemManagerAction(Frontend frontendClass) {
        this.frontendClass = frontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frontendClass.initItemManager();
    }
}
