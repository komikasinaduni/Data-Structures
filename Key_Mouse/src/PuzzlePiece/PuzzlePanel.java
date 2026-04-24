package PuzzlePiece;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Collections;
import java.util.ArrayList;

public class PuzzlePanel extends JPanel implements MouseListener {
    private PuzzlePiece[][] grid;
    private int moves;
    private boolean isImageMode;
    private boolean isSolved;
    private BufferedImage fullImage;

    private int emptyRow;
    private int emptyCol;

    private JButton newGameBtn;
    private JButton toggleBtn;

    public PuzzlePanel() {
        this.setPreferredSize(new Dimension(500, 600));
        this.setLayout(null);
        this.addMouseListener(this);

        isImageMode = false;
        isSolved = false;
        moves = 0;

        setupButtons();
        loadMainImage();
        createNewGame();
    }

    private void setupButtons() {
        newGameBtn = new JButton("New Game");
        newGameBtn.setBounds(50, 20, 120, 30);
        newGameBtn.addActionListener(e -> {
                createNewGame();

        });
        this.add(newGameBtn);

        toggleBtn = new JButton("Images");
        toggleBtn.setBounds(330, 20, 120, 30);
        toggleBtn.addActionListener(e -> {
            isImageMode = !isImageMode;
            if (isImageMode) {
                toggleBtn.setText("Numbers");
            } else {
                toggleBtn.setText("Images");
            }
            repaint();
        });
        this.add(toggleBtn);
    }

    private void loadMainImage() {
        try {
            BufferedImage original = ImageIO.read(new File("src\\PuzzlePiece\\puzzle_bg.jpg"));
            fullImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
            Graphics g = fullImage.getGraphics();
            g.drawImage(original, 0, 0, 400, 400, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println("Error loading puzzle image: " + e.getMessage());
        }
    }


    private void createNewGame() {
        grid = new PuzzlePiece[4][4];

        int val = 1;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                BufferedImage subImg = null;
                if (fullImage != null && val != 16) {
                    int imgR = (val - 1) / 4;
                    int imgC = (val - 1) % 4;
                    int x = imgC * 100;
                    int y = imgR * 100;
                    int w = Math.min(100, fullImage.getWidth() - x);
                    int h = Math.min(100, fullImage.getHeight() - y);
                    subImg = fullImage.getSubimage(x, y, w, h);
                }
                grid[r][c] = new PuzzlePiece(val, subImg);
                val++;
            }
        }
        emptyRow = 3;
        emptyCol = 3;

        java.util.Random rand = new java.util.Random();
        int iterations = 200;
        for (int i = 0; i < iterations; i++) {
            ArrayList<Point> possibleMoves = new ArrayList<>();
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int j = 0; j < 4; j++) {
                int nr = emptyRow + dr[j];
                int nc = emptyCol + dc[j];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
                    possibleMoves.add(new Point(nr, nc));
                }
            }
            Point move = possibleMoves.get(rand.nextInt(possibleMoves.size()));

            PuzzlePiece temp = grid[move.x][move.y];
            grid[move.x][move.y] = grid[emptyRow][emptyCol];
            grid[emptyRow][emptyCol] = temp;
            emptyRow = move.x;
            emptyCol = move.y;
        }

        moves = 0;
        isSolved = false;
        repaint();
    }

    private void checkWin() {
        int expected = 1;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (grid[r][c].getValue() != expected) {
                    return;
                }
                expected++;
            }
        }
        isSolved = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(200, 0, 200));
        g.fillRect(0, 0, 500, 600);
        g.setColor(Color.BLACK);
        g.fillRect(330, 60, 120, 30);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Moves: " + moves, 340, 80);
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int x = 50 + (c * 100);
                int y = 100 + (r * 100);
                if (grid[r][c].getValue() != 16) {
                    if (isImageMode && grid[r][c].getImage() != null) {
                        g.drawImage(grid[r][c].getImage(), x, y, 100, 100, null);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, 100, 100);
                    } else {
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, 100, 100);
                        g.setColor(new Color(100, 200, 150));
                        int[] xPts = {x+50, x+100, x+50, x};
                        int[] yPts = {y, y+50, y+100, y+50};
                        g.fillPolygon(xPts, yPts, 4);
                        g.setColor(Color.RED);
                        g.setFont(new Font("Serif", Font.ITALIC, 40));
                        g.drawString("" + grid[r][c].getValue(), x + 30, y + 65);
                    }
                }
            }
        }

        if (isSolved) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 250, 500, 100);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("YOU WIN! Moves: " + moves, 100, 310);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isSolved) {
            return;
        }
        int mouseX = e.getX();
        int mouseY = e.getY();
        int c = (mouseX - 50) / 100;
        int r = (mouseY - 100) / 100;
        if (r >= 0 && r < 4 && c >= 0 && c < 4) {
            boolean isAdjacent = false;
            if (Math.abs(r - emptyRow) == 1 && c == emptyCol) isAdjacent = true;
            if (Math.abs(c - emptyCol) == 1 && r == emptyRow) isAdjacent = true;

            if (isAdjacent) {
                PuzzlePiece temp = grid[r][c];
                grid[r][c] = grid[emptyRow][emptyCol];
                grid[emptyRow][emptyCol] = temp;

                emptyRow = r;
                emptyCol = c;
                moves++;
                checkWin();
                repaint();
            }
        }
    }

    public void mouseClicked(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
}