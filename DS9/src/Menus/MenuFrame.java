package Menus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuFrame extends JFrame {
    private JMenuBar nb_mainMenuBar = new JMenuBar();
    private JMenu m_file = new JMenu("File");
    private JMenuItem mi_exit = new JMenuItem("Exit");
    private JMenu m_screenSize = new JMenu("Screen Size");
    private JMenuItem mi_200 = new JMenuItem("200x200");
    private JMenuItem mi_300 = new JMenuItem("300x300");
    private JMenuItem mi_400 = new JMenuItem("400x400");
    private JMenuItem m_colors = new JMenu("Background Color");
    private JMenuItem mi_red = new JMenuItem("Red");
    private JMenuItem mi_green = new JMenuItem("Green");
    private JMenuItem mi_blue = new JMenuItem("Blue");
    private JMenu m_screen = new JMenu("Screen");

    public MenuFrame(){
        super("Menu Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setLayout(null);
        setJMenuBar(nb_mainMenuBar);
        nb_mainMenuBar.add(m_file);
        nb_mainMenuBar.add(m_screen);
        m_file.add(mi_exit);
        mi_exit.addActionListener(e-> exit());
        m_screen.add(m_screenSize);
        m_screen.add(m_colors);
        m_screenSize.add(mi_200);
        m_screenSize.add(mi_300);
        m_screenSize.add(mi_400);
        mi_200.addActionListener(e->setSize(e));
        mi_300.addActionListener(e->setSize(e));
        mi_400.addActionListener(e->setSize(e));
        m_colors.add(mi_red);
        m_colors.add(mi_green);
        m_colors.add(mi_blue);
        mi_200.addActionListener(e->setSize(e));
        mi_300.addActionListener(e->setSize(e));
        mi_400.addActionListener(e->setSize(e));
        setVisible(true);
    }

    public void setSize(ActionEvent e){
        if(e.getActionCommand().equals("200x200")){
            setSize(200, 200);
        } else if(e.getActionCommand().equals("300x300")){
            setSize(300,300);
        } else{
            setSize(400,400);
        }
    }

    public void setBackground(ActionEvent e){
        if(e.getActionCommand().equals("Red")){
            getContentPane().setBackground(Color.RED);
        } else if(e.getActionCommand().equals("Green")){
            getContentPane().setBackground(Color.GREEN);
        } else{
            getContentPane().setBackground(Color.BLUE);
        }
    }

    public void exit(){
        dispose();
    }

}
