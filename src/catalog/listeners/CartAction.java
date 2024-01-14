package catalog.listeners;

import catalog.Frontend;
import catalog.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartAction implements ActionListener {
    private final Frontend frontendClass;
    private Logic logicClass;

    public CartAction(Frontend frontendClass, Logic logicClass) {
        this.frontendClass = frontendClass;
        this.logicClass = logicClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
