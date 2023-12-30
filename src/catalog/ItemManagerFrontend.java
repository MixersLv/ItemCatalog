package catalog;

import catalog.listeners.AddItemAction;

import javax.swing.*;
import java.awt.*;

public class ItemManagerFrontend {

    private JFrame makeItemFrame;
    private JTextField nameTextField;
    private JTextField typeTextField;
    private JTextField priceTextField;
    private JButton addItemButton;
    private Logic logicClass;

    public ItemManagerFrontend(Logic logicClass) {
        this.logicClass = logicClass;
    }

    public void makeMakeItemFrame(){
        makeItemFrame = new JFrame("Make Item");
        makeItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeItemFrame.setSize(600,400);
        makeItemFrame.setLocationRelativeTo(null);
        makeItemFrame.setLayout(null);
        makeTextFields();
        makeMakeItemButtons();
        makeMakeItemText();
    }
    private void makeTextFields(){
        nameTextField = new JTextField();
        typeTextField = new JTextField();
        priceTextField = new JTextField();

        nameTextField.setBounds(30,50,150,50);
        typeTextField.setBounds(210,50,150,50);
        priceTextField.setBounds(390,50,150,50);

        nameTextField.setFont(new Font("Arial",Font.BOLD,20));
        typeTextField.setFont(new Font("Arial",Font.BOLD,20));
        priceTextField.setFont(new Font("Arial",Font.BOLD,20));

        makeItemFrame.add(nameTextField);
        makeItemFrame.add(typeTextField);
        makeItemFrame.add(priceTextField);
    }

    private void makeMakeItemButtons(){
        addItemButton = new JButton("Add Item");
        //make AL
        AddItemAction addItemListener = new AddItemAction(logicClass,this);
        //add AL
        addItemButton.addActionListener(addItemListener);

        addItemButton.setBounds(235,150,100,50);

        makeItemFrame.add(addItemButton);
    }

    private void makeMakeItemText(){
      JTextArea itemNameText = new JTextArea("Item Name");
      JTextArea itemTypeText = new JTextArea("Item Type");
      JTextArea itemPriceText = new JTextArea("Item Price");

      itemNameText.setEditable(false);
      itemTypeText.setEditable(false);
      itemPriceText.setEditable(false);

      itemNameText.setFocusable(false);
      itemTypeText.setFocusable(false);
      itemPriceText.setFocusable(false);

      itemNameText.setFont(new Font("Consolas", Font.BOLD,20));
      itemTypeText.setFont(new Font("Consolas", Font.BOLD,20));
      itemPriceText.setFont(new Font("Consolas", Font.BOLD,20));

      itemNameText.setBounds(35,20,120,20);
      itemTypeText.setBounds(235,20,120,20);
      itemPriceText.setBounds(405,20,120,20);

      makeItemFrame.add(itemNameText);
      makeItemFrame.add(itemTypeText);
      makeItemFrame.add(itemPriceText);

    }
    public void initMakeItemFrame(){
        makeItemFrame.setVisible(true);
    }
    public void closeMakeItemFrame(){
        makeItemFrame.setVisible(false);
    }

    //GETTERS
    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getTypeTextField() {
        return typeTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }
}
