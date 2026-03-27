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

        // Setup menu bar
        setJMenuBar(menuBar);
        menuBar.add(menuMenu);
        menuMenu.add(mi_appetizers);
        menuMenu.add(mi_entrees);
        menuMenu.add(mi_desserts);
        menuMenu.add(mi_viewCart);

        // Create menu panels
        appetizersPanel = new MenuPanel("Appetizers", createAppetizers(), cart);
        entreesPanel = new MenuPanel("Entrees", createEntrees(), cart);
        dessertsPanel = new MenuPanel("Desserts", createDesserts(), cart);
        cartPanel = new CartPanel(cart);

        mainPanel.add(appetizersPanel, "Appetizers");
        mainPanel.add(entreesPanel, "Entrees");
        mainPanel.add(dessertsPanel, "Desserts");
        mainPanel.add(cartPanel, "Cart");

        // Menu actions
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

    // Sample data
    private ArrayList<OrderItem> createAppetizers(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Mozzarella Sticks", "Fried cheese sticks with marinara sauce", 5.99));
        list.add(new OrderItem("Garlic Bread", "Toasted bread with garlic butter", 3.99));
        list.add(new OrderItem("Bruschetta", "Grilled bread with tomato topping", 4.99));
        list.add(new OrderItem("Stuffed Mushrooms", "Mushrooms stuffed with cheese and herbs", 6.49));
        list.add(new OrderItem("Buffalo Wings", "Spicy chicken wings", 7.99));
        list.add(new OrderItem("Onion Rings", "Crispy fried onion rings", 4.49));
        return list;
    }

    private ArrayList<OrderItem> createEntrees(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Spaghetti Bolognese", "Pasta with meat sauce", 12.99));
        list.add(new OrderItem("Grilled Chicken", "Served with vegetables", 13.49));
        list.add(new OrderItem("Steak", "8oz sirloin steak", 18.99));
        list.add(new OrderItem("Salmon", "Grilled salmon with lemon butter", 16.99));
        list.add(new OrderItem("Chicken Alfredo", "Pasta with creamy sauce", 14.99));
        list.add(new OrderItem("Veggie Burger", "Served with fries", 11.99));
        list.add(new OrderItem("BBQ Ribs", "Half rack with sauce", 17.49));
        list.add(new OrderItem("Taco Plate", "3 tacos with toppings", 12.49));
        list.add(new OrderItem("Fried Shrimp", "Served with cocktail sauce", 15.49));
        list.add(new OrderItem("Meatloaf", "Classic meatloaf with gravy", 13.99));
        list.add(new OrderItem("Chicken Parmesan", "Breaded chicken with marinara and cheese", 14.49));
        list.add(new OrderItem("Seafood Pasta", "Pasta with shrimp and clams", 16.99));
        return list;
    }

    private ArrayList<OrderItem> createDesserts(){
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("Cheesecake", "Classic New York cheesecake", 6.99));
        list.add(new OrderItem("Chocolate Cake", "Rich chocolate layer cake", 5.99));
        list.add(new OrderItem("Ice Cream", "Vanilla ice cream scoop", 3.99));
        list.add(new OrderItem("Apple Pie", "Homemade apple pie slice", 4.99));
        return list;
    }

    public static void main(String[] args){
        new RestaurantFrame();
    }
}