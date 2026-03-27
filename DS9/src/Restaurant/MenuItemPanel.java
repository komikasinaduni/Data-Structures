package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuItemPanel extends JPanel {

    private JLabel lblName;
    private JLabel lblDesc;
    private JLabel lblPrice;
    private JTextField txtQty;
    private JButton btnAdd;
    private JButton btnRemove;

    public MenuItemPanel(OrderItem item, ArrayList<OrderItem> cart){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        lblName = new JLabel(item.getName());
        lblDesc = new JLabel(item.getDescription());
        lblPrice = new JLabel("$" + item.getPrice());
        txtQty = new JTextField("0",3);
        txtQty.setEditable(false);

        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnRemove.setEnabled(false);

        btnAdd.addActionListener(e -> {
            item.addQuantity();
            txtQty.setText("" + item.getQuantity());
            btnRemove.setEnabled(item.getQuantity() > 0);
            if(!cart.contains(item)) cart.add(item);
        });

        btnRemove.addActionListener(e -> {
            item.removeQuantity();
            txtQty.setText("" + item.getQuantity());
            btnRemove.setEnabled(item.getQuantity() > 0);
            if(item.getQuantity() == 0) cart.remove(item);
        });

        gbc.gridx=0; gbc.gridy=0; add(lblName, gbc);
        gbc.gridy=1; add(lblDesc, gbc);
        gbc.gridy=2; add(lblPrice, gbc);
        gbc.gridx=1; gbc.gridy=0; add(txtQty, gbc);
        gbc.gridy=1; add(btnAdd, gbc);
        gbc.gridy=2; add(btnRemove, gbc);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}