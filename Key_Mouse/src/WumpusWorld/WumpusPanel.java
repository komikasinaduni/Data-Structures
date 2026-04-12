package WumpusWorld;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;
    private int status;
    private WumpusPlayer player;
    private WumpusMap map;
    private BufferedImage buffer;
    private boolean cheatMode = false;
    private ArrayList<String> messages = new ArrayList<>();
    private BufferedImage floor;
    private BufferedImage arrow;
    private BufferedImage fog;
    private BufferedImage gold;
    private BufferedImage ladder;
    private BufferedImage pit;
    private BufferedImage breeze;
    private BufferedImage wumpus;
    private BufferedImage deadWumpus;
    private BufferedImage stench;
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;

    public WumpusPanel() {
        this.setPreferredSize(new Dimension(550, 650));
        this.addKeyListener(this);
        this.setFocusable(true);
        loadImages();
        reset();
    }

    private void loadImages() {
        try {
            floor = ImageIO.read(new File("src/WumpusWorld/Images/Floor.gif"));
            fog = ImageIO.read(new File("src/WumpusWorld/Images/black.GIF"));
            ladder = ImageIO.read(new File("src/WumpusWorld/Images/ladder.gif"));
            arrow = ImageIO.read(new File("src/WumpusWorld/Images/arrow.gif"));
            gold = ImageIO.read(new File("src/WumpusWorld/Images/gold.gif"));
            pit = ImageIO.read(new File("src/WumpusWorld/Images/pit.gif"));
            breeze = ImageIO.read(new File("src/WumpusWorld/Images/breeze.gif"));
            wumpus = ImageIO.read(new File("src/WumpusWorld/Images/wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src/WumpusWorld/Images/deadwumpus.GIF"));
            stench = ImageIO.read(new File("src/WumpusWorld/Images/stench.gif"));
            playerUp = ImageIO.read(new File("src/WumpusWorld/Images/playerUp.png"));
            playerDown = ImageIO.read(new File("src/WumpusWorld/Images/playerDown.png"));
            playerLeft = ImageIO.read(new File("src/WumpusWorld/Images/playerLeft.png"));
            playerRight = ImageIO.read(new File("src/WumpusWorld/Images/playerRight.png"));
            // For school bc apparently windows runs different than mac when loading images??
            /*
            floor = ImageIO.read(new File("src\\WumpusWorld\\Images\\Floor.gif"));
            fog = ImageIO.read(new File("src\\WumpusWorld\\Images\\black.GIF"));
            ladder = ImageIO.read(new File("src\\WumpusWorld\\Images\\ladder.gif"));
            arrow = ImageIO.read(new File("src\\WumpusWorld\\Images\\arrow.gif"));
            gold = ImageIO.read(new File("src\\WumpusWorld\\Images\\gold.gif"));
            pit = ImageIO.read(new File("src\\WumpusWorld\\Images\\pit.gif"));
            breeze = ImageIO.read(new File("src\\WumpusWorld\\Images\\breeze.gif"));
            wumpus = ImageIO.read(new File("src\\WumpusWorld\\Images\\wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src\\WumpusWorld\\Images\\deadwumpus.GIF"));
            stench = ImageIO.read(new File("src\\WumpusWorld\\Images\\stench.gif"));
            playerUp = ImageIO.read(new File("src\\WumpusWorld\\Images\\playerUp.png"));
            playerDown = ImageIO.read(new File("src\\WumpusWorld\\Images\\playerDown.png"));
            playerLeft = ImageIO.read(new File("src\\WumpusWorld\\Images\\playerLeft.png"));
            playerRight = ImageIO.read(new File("src\\WumpusWorld\\Images\\playerRight.png"));
             */
        }
        catch (Exception e){
            System.out.println("Image Error: " + e.getMessage());
        }
    }

    public void reset() {
        status = PLAYING;
        map = new WumpusMap();
        player = new WumpusPlayer();
        player.setRow(map.getLadderRow());
        player.setCol(map.getLadderCol());
        updateMessages();
        repaint();
    }

    private void updateMessages() {
        if (status != PLAYING) {
            return;
        }
        messages.clear();
        WumpusSquare sq = map.getSquare(player.getRow(), player.getCol());
        sq.setVisited(true);

        if (sq.isPit()) {
            status = DEAD;
            messages.add("You fell down a pit to your death.");
            messages.add("Game Over. (N for new game)");
        } else if (sq.isWumpus()) {
            status = DEAD;
            messages.add("You are eaten by the Wumpus.");
            messages.add("Game Over. (N for new game)");
        } else {
            if (sq.isBreeze()) {
                messages.add("You feel a breeze.");
            }
            if (sq.isStench()) {
                messages.add("You smell a stench.");
            }
            if (sq.isGold()) {
                messages.add("You see a glimmer.");
            }
            if (sq.isLadder()) {
                messages.add("You bump into the ladder.");
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buffer == null) {
            buffer = (BufferedImage) createImage(550, 650);
        }
        Graphics bg = buffer.getGraphics();
        bg.setColor(Color.GRAY);
        bg.fillRect(0, 0, 550, 650);
        bg.setColor(Color.BLACK);
        bg.fillRect(25, 25, 500, 500);
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                WumpusSquare sq = map.getSquare(r, c);
                int x = 25 + (c * 50);
                int y = 25 + (r * 50);
                if (sq.isVisited() == false && cheatMode == false) {
                    bg.drawImage(fog, x, y, 50, 50, null);
                }
                else {
                    bg.drawImage(floor, x, y, 50, 50, null);
                    if (sq.isPit()) bg.drawImage(pit, x, y, 50, 50, null);
                    if (sq.isBreeze()) bg.drawImage(breeze, x, y, 50, 50, null);
                    if (sq.isStench()) bg.drawImage(stench, x, y, 50, 50, null);
                    if (sq.isWumpus()) bg.drawImage(wumpus, x, y, 50, 50, null);
                    if (sq.isDeadWumpus()) bg.drawImage(deadWumpus, x, y, 50, 50, null);
                    if (sq.isGold()) bg.drawImage(gold, x, y, 50, 50, null);
                    if (sq.isLadder()) bg.drawImage(ladder, x, y, 50, 50, null);
                }
            }
        }

        BufferedImage pImg = playerUp;
        if (player.getDirection() == 1) {
            pImg = playerRight;
        }
        else if (player.getDirection() == 2) {
            pImg = playerDown;
        }
        else if (player.getDirection() == 3) {
            pImg = playerLeft;
        }
        bg.drawImage(pImg, 25 + (player.getCol() * 50), 25 + (player.getRow() * 50), 50, 50, null);
        bg.setColor(Color.BLACK);
        bg.fillRect(0, 550, 550, 100);
        bg.setColor(Color.WHITE);
        bg.drawLine(170, 555, 170, 645);
        bg.setColor(Color.RED);
        bg.setFont(new Font("Monospaced", Font.BOLD, 22));
        bg.drawString("Inventory:", 10, 575);
        if (player.hasArrow()) {
            bg.drawImage(arrow, 25, 585, 20, 45, null);
        }
        if (player.hasGold()) {
            bg.drawImage(gold, 70, 590, 35, 35, null);
        }
        bg.drawString("Messages:", 185, 575);
        bg.setColor(Color.CYAN);
        bg.setFont(new Font("Monospaced", Font.BOLD, 15));
        for (int i = 0; i < messages.size(); i++) {
            bg.drawString(messages.get(i), 185, 595 + (i * 18));
        }
        g.drawImage(buffer, 0, 0, null);
    }

    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
        if (k == 'n'){
            reset();
            return;
        }
        if (status != PLAYING) {
            return;
        }
        int r = player.getRow();
        int c = player.getCol();
        boolean actionTaken = false;
        if (k == 'w' && r > 0) {
            player.setRow(r - 1);
            player.setDirection(0);
            actionTaken = true;
        }
        else if (k == 's' && r < 9) {
            player.setRow(r + 1);
            player.setDirection(2);
            actionTaken = true;
        }
        else if (k == 'a' && c > 0) {
            player.setCol(c - 1);
            player.setDirection(3);
            actionTaken = true;
        }
        else if (k == 'd' && c < 9) {
            player.setCol(c + 1);
            player.setDirection(1);
            actionTaken = true;
        }
        else if (k == 'p' && map.getSquare(r, c).isGold()) {
            player.setGold(true);
            map.getSquare(r, c).setGold(false);
            messages.add("You picked up the gold!");
        }
        else if (k == 'c' && map.getSquare(r, c).isLadder()) {
            if (player.hasGold()) {
                status = WON;
                messages.clear();
                messages.add("You Win. (N for new game)");
            } else {
                messages.add("You need the gold to climb out!");
            }
        } else if (k == '*') {
            cheatMode = !cheatMode;
        } else if (k == 'i' || k == 'j' || k == 'k' || k == 'l') {
            shoot(k);
        }
        if (actionTaken) {
            updateMessages();
        }
        repaint();
    }

    private void shoot(char k) {
        if (player.hasArrow() == false) {
            return;
        }
        player.setArrow(false);
        int r = player.getRow();
        int c = player.getCol();
        while (r >= 0 && r < 10 && c >= 0 && c < 10) {
            if (k == 'i') {
                r--;
            } else if (k == 'k') {
                r++;
            } else if (k == 'j') {
                c--;
            } else if (k == 'l') {
                c++;
            }
            WumpusSquare s = map.getSquare(r, c);
            if (s != null && s.isWumpus()) {
                s.setWumpus(false);
                s.setDeadWumpus(true);
                messages.add("You hear a scream");
                break;
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}