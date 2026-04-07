public class WumpusPlayer {
    public static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;

    private int direction;
    private boolean arrow;
    private boolean gold;
    private int row, col;

    public WumpusPlayer(int startRow, int startCol) {
        this.direction = NORTH;
        this.arrow = true;
        this.gold = false;
        this.row = startRow;
        this.col = startCol;
    }

    // getters and setters
    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    public boolean hasArrow() { return arrow; }
    public void setArrow(boolean arrow) { this.arrow = arrow; }

    public boolean hasGold() { return gold; }
    public void setGold(boolean gold) { this.gold = gold; }

    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }

    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }
}