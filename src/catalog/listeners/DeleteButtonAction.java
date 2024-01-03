package catalog.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonAction implements ActionListener {
    private final int index;

    public DeleteButtonAction(int index) {
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(index);//TEST
    }
}
