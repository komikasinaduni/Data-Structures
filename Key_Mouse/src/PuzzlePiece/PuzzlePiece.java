package PuzzlePiece;

import java.awt.image.BufferedImage;

public class PuzzlePiece {
    private int value;
    private BufferedImage image;

    public PuzzlePiece(int value, BufferedImage image) {
        this.value = value;
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public BufferedImage getImage() {
        return image;
    }
}