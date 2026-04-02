import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class LoadNDraw_Frame extends JFrame {
    private BufferedImage ladder = null;
    private BufferedImage Floor = null;

    public LoadNDraw_Frame(){
        super("Load and draw 2 Images");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            Floor = ImageIO.read((new File("Images\\Floor.gif")));
            ladder = ImageIO.read((new File("Images\\ladder.gif")));
            System.out.println("All images were loaded Properly.");
        } catch(Exception e){
            System.out.println("Error Loading Images: " + e.getMessage());
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
        g.drawImage(Floor, 150, 50, null);
    }

}