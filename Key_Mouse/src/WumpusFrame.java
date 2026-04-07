import javax.swing.*;

public class WumpusFrame extends JFrame {
    public WumpusFrame(){
        setTitle("Wumpus World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WumpusPanel panel = new WumpusPanel();
        add(panel);
        pack();
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args){
        new WumpusFrame();
    }
}