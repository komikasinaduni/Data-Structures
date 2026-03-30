package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuItemPanel extends JPanel {

    private JLabel lblImage;
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

        java.net.URL url = getClass().getResource("/Restaurant/images/" + item.getName().replaceAll(" ", "").toLowerCase() + ".jpg");
        ImageIcon icon;
        if(url != null){
            Image img = new ImageIcon(url).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
        } else {
            System.out.println("Missing: " + item.getName());
            icon = new ImageIcon();
        }
        lblImage = new JLabel(icon);

        lblName = new JLabel(item.getName());
        lblName.setFont(new Font("Arial", Font.BOLD, 14));

        lblDesc = new JLabel(item.getDescription());

        lblPrice = new JLabel("$" + String.format("%.2f", item.getPrice()));

        txtQty = new JTextField("0",3);
        txtQty.setEditable(false);

        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnRemove.setEnabled(false);

        btnAdd.addActionListener(e -> {
            item.addQuantity();
            txtQty.setText("" + item.getQuantity());
            btnRemove.setEnabled(item.getQuantity() > 0);

            if(!cart.contains(item)){
                cart.add(item);
            }
        });

        btnRemove.addActionListener(e -> {
            item.removeQuantity();
            txtQty.setText("" + item.getQuantity());
            btnRemove.setEnabled(item.getQuantity() > 0);

            if(item.getQuantity() == 0){
                cart.remove(item);
            }
        });


        gbc.gridx = 0; gbc.gridy = 0; gbc.gridheight = 3;
        add(lblImage, gbc);

        gbc.gridheight = 1;

        gbc.gridx = 1; gbc.gridy = 0;
        add(lblName, gbc);

        gbc.gridy = 1;
        add(lblDesc, gbc);

        gbc.gridy = 2;
        add(lblPrice, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        add(txtQty, gbc);

        gbc.gridy = 1;
        add(btnAdd, gbc);

        gbc.gridy = 2;
        add(btnRemove, gbc);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}