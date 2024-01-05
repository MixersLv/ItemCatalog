package catalog.components;

import javax.swing.*;
import java.awt.*;

public class JConfirmDialog {
    private final JFrame confirmFrame = new JFrame();

    public JConfirmDialog(String title, Runnable onConfirmed) {
        confirmFrame.setTitle(title);
        confirmFrame.setSize(400, 100);
        confirmFrame.setLayout(new FlowLayout());

        JButton confirmButton = new JButton("YES");
        JButton abortButton = new JButton("NO");

        confirmButton.addActionListener((e) -> {
            onConfirmed.run();
            confirmFrame.setVisible(false);
        });
        abortButton.addActionListener((e) -> confirmFrame.setVisible(false));

        confirmFrame.add(confirmButton);
        confirmFrame.add(abortButton);

        //position frame centered
        confirmFrame.setLocationRelativeTo(null);
    }

    public void show() {
        confirmFrame.setVisible(true);
    }

}
