package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantFrame extends JFrame {

    private JPanel mainPanel = new JPanel(new CardLayout());
    private JMenuBar menuBar = new JMenuBar();

    private JMenu menuMenu = new JMenu("Menu");
    private JMenuItem mi_appetizers = new JMenuItem("Appetizers");
    private JMenuItem mi_entrees = new JMenuItem("Entrees");
    private JMenuItem mi_desserts = new JMenuItem("Desserts");
    private JMenuItem mi_viewCart = new JMenuItem("View Cart");

    private ArrayList<OrderItem> cart = new ArrayList<>();

    private MenuPanel appetizersPanel;
    private MenuPanel entreesPanel;
    private MenuPanel dessertsPanel;
    private CartPanel cartPanel;

    public RestaurantFrame() {

        setTitle("Restaurant Ordering System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(mainPanel, BorderLayout.CENTER);

        setJMenuBar(menuBar);
        menuBar.add(menuMenu);
        menuMenu.add(mi_appetizers);
        menuMenu.add(mi_entrees);
        menuMenu.add(mi_desserts);
        menuMenu.add(mi_viewCart);

        appetizersPanel = new MenuPanel("Appetizers", createAppetizers(), cart);
        entreesPanel = new MenuPanel("Entrees", createEntrees(), cart);
        dessertsPanel = new MenuPanel("Desserts", createDesserts(), cart);
        cartPanel = new CartPanel(cart);
        mainPanel.add(appetizersPanel, "Appetizers");
        mainPanel.add(entreesPanel, "Entrees");
        mainPanel.add(dessertsPanel, "Desserts");
        mainPanel.add(cartPanel, "Cart");
        mi_appetizers.addActionListener(e -> showPanel("Appetizers"));
        mi_entrees.addActionListener(e -> showPanel("Entrees"));
        mi_desserts.addActionListener(e -> showPanel("Desserts"));
        mi_viewCart.addActionListener(e -> {
            cartPanel.refreshTable();
            showPanel("Cart");
        });

        setVisible(true);
    }

    private void showPanel(String name){
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, name);
    }

    private ArrayList<OrderItem> createAppetizers(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Mozzarella Sticks", "Fried cheese sticks with marinara sauce", 5.99));
        list.add(new OrderItem("Garlic Bread", "Toasted bread with garlic butter", 3.99));
        list.add(new OrderItem("Bruschetta", "Grilled bread with tomato topping", 4.99));
        list.add(new OrderItem("Spring Rolls", "Crispy or fresh, handheld delights", 6.49));
        list.add(new OrderItem("Gobi Manchurian", "Crispy cauliflower, spicy umami glaze", 7.99));
        list.add(new OrderItem("Onion Samosa", "Crispy triangular pastry with onion filling", 4.49));
        return list;
    }

    private ArrayList<OrderItem> createEntrees(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Biryani", "Fragrant, spiced, and layered rice dish", 12.99));
        list.add(new OrderItem("Noodles", "Stir-fried Indo-Chinese wheat noodles", 13.49));
        list.add(new OrderItem("Pizza", "Freshly baked dough, sauce, cheese.", 11.99));
        list.add(new OrderItem("Veggie Salad", "Freshly chopped greens and veggies", 16.99));
        list.add(new OrderItem("Omelette", "Fluffy beaten eggs, folded hot.", 14.99));
        list.add(new OrderItem("Mashed Potatoes", "Potatoes that are crushed to perfection", 11.99));
        list.add(new OrderItem("Naan Paneer", "Pillowy bread, creamy spiced cheese", 17.49));
        list.add(new OrderItem("Taco", "Tortilla folded over tasty fillings.", 12.49));
        list.add(new OrderItem("Enchilada", "Tortillas rolled, sauced, baked, cheesy", 15.49));
        list.add(new OrderItem("Mac and Cheese", "Gooey noodles bathed in cheese", 13.99));
        list.add(new OrderItem("Fried Rice", "Sizzling grains tossed with umami", 14.49));
        list.add(new OrderItem("Pasta", "Boiled wheat shapes, sauce coated", 16.99));
        return list;
    }

    private ArrayList<OrderItem> createDesserts(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Cheesecake", "Classic New York cheesecake", 6.99));
        list.add(new OrderItem("Chocolate Cake", "Rich chocolate layer cake", 5.99));
        list.add(new OrderItem("Ice Cream", "Vanilla ice cream scoop", 3.99));
        list.add(new OrderItem("Apple Pie", "Homemade apple pie slice", 4.99));
        list.add(new OrderItem("Falooda", "Floral, chilled, noodles, creamy layers", 6.99));
        return list;
    }

    public static void main(String[] args){
        new RestaurantFrame();
    }
}