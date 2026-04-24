package PuzzlePiece;
import javax.swing.JFrame;

public class PuzzleFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("15 Puzzle");
        PuzzlePanel gamePanel = new PuzzlePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}