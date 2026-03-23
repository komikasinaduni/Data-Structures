package PanelAndTabbed;
import javax.swing.*;
import java.awt.*;

public class TabbedPanelFrame extends JFrame{
    private JPanel jp_red = new JPanel();
    private JPanel jp_green = new JPanel();
    private JPanel jp_blue = new JPanel();
    private JTabbedPane tp_coloredPanels = new JTabbedPane();

    public TabbedPanelFrame(){
        super("TabbedPane with JPanels Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        tp_coloredPanels.setBounds(20, 20, 350, 310);
        add(tp_coloredPanels);

        jp_red.setBackground(Color.RED);
        jp_green.setBackground(Color.GREEN);
        jp_blue.setBackground(Color.BLUE);

        tp_coloredPanels.addTab("Red", jp_red);
        tp_coloredPanels.addTab("Green", jp_green);
        tp_coloredPanels.addTab("Blue", jp_blue);

        tp_coloredPanels.setTitleAt(1, "Turtles");
        tp_coloredPanels.remove(2);

        setVisible(true);

    }
}
