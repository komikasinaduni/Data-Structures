import javax.swing.JFrame;
public class WumpusFrame extends JFrame {
    public WumpusFrame() {
        super("Wumpus World");
        WumpusPanel panel = new WumpusPanel();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WumpusFrame();
    }
}