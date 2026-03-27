package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {

    public MenuPanel(String heading, ArrayList<OrderItem> items, ArrayList<OrderItem> cart){

        setLayout(new BorderLayout());

        JLabel lblHeading = new JLabel(heading);
        lblHeading.setFont(new Font("Arial", Font.BOLD, 24));
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        add(lblHeading, BorderLayout.NORTH);

        JPanel itemsContainer = new JPanel();
        itemsContainer.setLayout(new BoxLayout(itemsContainer, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(itemsContainer);
        add(scroll, BorderLayout.CENTER);

        Color c1 = new Color(245,245,245);
        Color c2 = new Color(220,220,220);

        for(int i=0;i<items.size();i++){
            OrderItem item = items.get(i);
            MenuItemPanel mip = new MenuItemPanel(item, cart);
            mip.setBackground(i%2==0 ? c1 : c2);
            itemsContainer.add(mip);
        }
    }
}