import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class LoadNDraw_Frame extends JFrame {
    private BufferedImage ladder = null;
    private BufferedImage floor = null;

    public LoadNDraw_Frame(){
        super("Load and draw 2 WumpusWorld.Images");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            floor = ImageIO.read((new File("src\\WumpusWorld.Images\\Floor.gif")));
            ladder = ImageIO.read((new File("src\\WumpusWorld.Images\\ladder.gif")));
            System.out.println("All images were loaded Properly.");
        } catch(Exception e){
            System.out.println("Error Loading WumpusWorld.Images: " + e.getMessage());
            e.printStackTrace();
        }
        setSize(250,150);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(), getHeight());

        g.drawImage(ladder, 50, 50, null);
        g.drawImage(floor, 150, 50, null);
    }

}