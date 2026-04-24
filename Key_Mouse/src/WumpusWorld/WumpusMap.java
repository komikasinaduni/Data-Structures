package WumpusWorld;

public class WumpusMap
{
    private WumpusSquare[][] grid;
    private int ladderRow;
    private int ladderCol;
    public WumpusMap() {
        createMap();
    }
    public void createMap() {
        grid = new WumpusSquare[10][10];
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                grid[r][c] = new WumpusSquare();
            }
        }

        for (int i = 0; i < 10; i++) {
            int r = (int)(Math.random() * 10);
            int c = (int)(Math.random() * 10);
            grid[r][c].setPit(true);

            addBreeze(r, c);
        }

        ladderRow = (int)(Math.random() * 10);
        ladderCol = (int)(Math.random() * 10);
        grid[ladderRow][ladderCol].setLadder(true);
        int goldR = (int)(Math.random() * 10);
        int goldC = (int)(Math.random() * 10);
        while (grid[goldR][goldC].isPit() || grid[goldR][goldC].isLadder()) {
            goldR = (int)(Math.random() * 10);
            goldC = (int)(Math.random() * 10);
        }
        grid[goldR][goldC].setGold(true);
        int wumpusR = (int)(Math.random() * 10);
        int wumpusC = (int)(Math.random() * 10);

        while (grid[wumpusR][wumpusC].isPit() || grid[wumpusR][wumpusC].isLadder()) {
            wumpusR = (int)(Math.random() * 10);
            wumpusC = (int)(Math.random() * 10);
        }
        grid[wumpusR][wumpusC].setWumpus(true);

        addStench(wumpusR, wumpusC);
    }

    private void addBreeze(int r, int c) {
        if (r > 0) {
            grid[r - 1][c].setBreeze(true);
        }

        if (r < 9) {
            grid[r + 1][c].setBreeze(true);
        }

        if (c > 0) {
            grid[r][c - 1].setBreeze(true);
        }

        if (c < 9) {
            grid[r][c + 1].setBreeze(true);
        }
    }

    private void addStench(int r, int c) {
        if(r == ladderRow && c == ladderCol){
            grid[r][c].setStench(false);
        }
        if (r > 0) {
            grid[r - 1][c].setStench(true);
        }
        if (r < 9) {
            grid[r + 1][c].setStench(true);
        }
        if (c > 0) {
            grid[r][c - 1].setStench(true);
        }
        if (c < 9) {
            grid[r][c + 1].setStench(true);
        }
    }

    public WumpusSquare getSquare(int r, int c) {
        if (r >= 0 && r < 10 && c >= 0 && c < 10) {
            return grid[r][c];
        }
        return null;
    }

    public int getLadderRow() {
        return ladderRow;
    }

    public int getLadderCol() {
        return ladderCol;
    }
}