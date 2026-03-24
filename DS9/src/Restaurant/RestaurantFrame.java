package Restaurant;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class RestaurantFrame extends JFrame{
    private JTabbedPane tabs = new JTabbedPane();
    private File saveDir = new File("Saves");
    private JMenuBar bar = new JMenuBar();
    private JMenu menuMenu = new JMenu("Menu");
    private JMenuItem mi_appetizers = new JMenuItem("Appetizers");
    private JMenuItem mi_entrees = new JMenuItem("Entrees");
    private JMenuItem mi_desserts = new JMenuItem("Desserts");
    private JMenu checkOutMenu = new JMenu("Check out");
    private JMenuItem mi_viewCart = new JMenuItem("View Cart");
}
