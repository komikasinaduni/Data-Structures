package WumpusWorld;

public class WumpusPlayer {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    private int direction;
    private int col;
    private int row;
    private boolean arrow;
    private boolean gold;

    public WumpusPlayer() {
        direction = NORTH;
        arrow = true;
        gold = false;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int d) {
        direction = d;
    }

    public boolean hasArrow() {
        return arrow;
    }

    public void setArrow(boolean a) {
        arrow = a;
    }

    public boolean hasGold() {
        return gold;
    }

    public void setGold(boolean g) {
        gold = g;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        col = c;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }
}