package catalog.listeners;

import catalog.ItemDeleteFrontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteConfirmAction implements ActionListener {
    private final ItemDeleteFrontend itemDeleteFrontendClass;

    public DeleteConfirmAction(ItemDeleteFrontend itemDeleteFrontendClass) {
        this.itemDeleteFrontendClass = itemDeleteFrontendClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemDeleteFrontendClass.
    }
}
