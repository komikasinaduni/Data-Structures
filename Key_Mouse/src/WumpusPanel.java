import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int TILE_SIZE = 50;

    private BufferedImage floor, fog, ladder, arrow, gold, pit, breeze, wumpus, deadWumpus, stench, playerUp, playerDown, playerLeft, playerRight;
    private WumpusMap map;
    private WumpusPlayer player;
    private boolean cheat = false;
    private String message = "";
    private int status = 0;

    public WumpusPanel() {
        setPreferredSize(new Dimension(500,600));
        setFocusable(true);
        addKeyListener(this);
        loadImages();
        map = new WumpusMap();
        player = new WumpusPlayer(map.getLadderRow(), map.getLadderCol());
        map.getSquare(player.getRow(), player.getCol()).setVisited(true);
    }

    private void loadImages() {
        try{
            floor = ImageIO.read(new File("src\\Images\\Floor.gif"));
            fog = ImageIO.read(new File("src\\Images\\black.GIF"));
            ladder = ImageIO.read(new File("src\\Images\\ladder.gif"));
            arrow = ImageIO.read(new File("src\\Images\\arrow.gif"));
            gold = ImageIO.read(new File("src\\Images\\gold.gif"));
            pit = ImageIO.read(new File("src\\Images\\pit.gif"));
            breeze = ImageIO.read(new File("src\\Images\\breeze.gif"));
            wumpus = ImageIO.read(new File("src\\Images\\wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src\\Images\\deadwumpus.GIF"));
            stench = ImageIO.read(new File("src\\Images\\stench.gif"));
            playerUp = ImageIO.read(new File("src\\Images\\playerUp.png"));
            playerDown = ImageIO.read(new File("src\\Images\\playerDown.png"));
            playerLeft = ImageIO.read(new File("src\\Images\\playerLeft.png"));
            playerRight = ImageIO.read(new File("src\\Images\\playerRight.png"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        JTextArea messagesDialog = new JTextArea();
        messagesDialog.setBounds(20, 510, 50, 100);
        messagesDialog.
        super.paintComponent(g);
        for(int r=0; r<10; r++){
            for(int c=0; c<10; c++){
                int x = c*TILE_SIZE;
                int y = r*TILE_SIZE;
                g.drawImage(floor, x, y, null);
                if(!map.getSquare(r,c).isVisited() && !cheat)
                    g.drawImage(fog, x, y, null);
            }
        }
        WumpusSquare sq = map.getSquare(player.getRow(), player.getCol());
        if(sq.hasLadder()) {
            g.drawImage(ladder, player.getCol()*TILE_SIZE, player.getRow()*TILE_SIZE, null);
        }
        BufferedImage playerImg = playerUp;
        if(player.getDirection()==WumpusPlayer.NORTH) {
            playerImg=playerUp;
        } else if(player.getDirection()==WumpusPlayer.SOUTH) {
            playerImg=playerDown;
        } else if(player.getDirection()==WumpusPlayer.WEST) {
            playerImg=playerLeft;
        } else if(player.getDirection()==WumpusPlayer.EAST) {
            playerImg=playerRight;
        }
        g.drawImage(playerImg, player.getCol()*TILE_SIZE, player.getRow()*TILE_SIZE, null);
        g.setColor(Color.WHITE);
        g.drawString(message, 20, 250);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e){
        int r = player.getRow();
        int c = player.getCol();
        WumpusSquare sq = map.getSquare(r,c);
        char k = e.getKeyChar();

        if(k=='w') {
            player.setRow(r-1);
            player.setDirection(WumpusPlayer.NORTH);
        } else if(k=='s'){
            player.setRow(r+1);
            player.setDirection(WumpusPlayer.SOUTH);
        } else if(k=='a'){
            player.setCol(c-1); player.setDirection(WumpusPlayer.WEST);
        } else if(k=='d'){
            player.setCol(c+1);
            player.setDirection(WumpusPlayer.EAST);
        } else if(k=='*'){
            cheat = !cheat;
        } else if(k=='p' && sq.hasGold()){
            player.setGold(true); sq.setGold(false);
            message="Gold picked up!";
        }
        if(player.getRow()<0){
            player.setRow(0);
        }
        if(player.getRow()>9) {
            player.setRow(9);
        }
        if(player.getCol()<0) {
            player.setCol(0);
        }
        if(player.getCol()>9) {
            player.setCol(9);
        }

        map.getSquare(player.getRow(), player.getCol()).setVisited(true);
        sq = map.getSquare(player.getRow(), player.getCol());
        if(sq.hasPit()){
            message="You fell down a pit to your death!";
            status=1;
        } else if(sq.hasWumpus()){
            message="You are eaten by the Wumpus!";
            status=1;
        } else if(sq.hasGold()){
            message="You see a glimmer!";
        } else if(sq.hasBreeze()){
            message="You feel a breeze.";
        } else if(sq.hasStench()){
            message="You smell a stench.";
        } else {
            message="";
        }
        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}