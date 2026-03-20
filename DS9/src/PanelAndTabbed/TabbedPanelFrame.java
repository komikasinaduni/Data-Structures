package PanelAndTabbed;
import javax.swing.*;
import java.awt.*;

public class TabbedPanelFrame extends JFrame{
    private JPanel jp_red = new JPanel();
    private JPanel jp_green = new JPanel();
    private JPanel jp_blue = new JPanel();
    private JButton btn_test = new JButton("test");

    public TabbedPanelFrame(){
        super("TabbedPane with JPanels Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLayout(null);

        jp_red.setBounds(20, 20, 200, 150);
        jp_red.setBackground(Color.RED);
        jp_red.add(btn_test);
        add(jp_red);

        jp_green.setBounds(20, 200, 200, 40);
        jp_green.setBackground(Color.GREEN);
        add(jp_green);

        jp_blue.setBounds(20, 300, 200, 40);
        jp_blue.setBackground(Color.BLUE);
        add(jp_blue);

        setVisible(true);

    }
}
