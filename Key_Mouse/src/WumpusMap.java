import java.util.Random;

public class WumpusMap {
    public static final int NUM_ROWS = 10, NUM_COLS = 10, NUM_PITS = 10;
    private WumpusSquare[][] grid;
    private int ladderRow, ladderCol;
    private Random rand = new Random();

    public WumpusMap() {
        createMap();
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_ROWS][NUM_COLS];
        for(int r = 0; r < NUM_ROWS; r++)
            for(int c = 0; c < NUM_COLS; c++)
                grid[r][c] = new WumpusSquare();

        // Ladder first
        ladderRow = rand.nextInt(NUM_ROWS);
        ladderCol = rand.nextInt(NUM_COLS);
        grid[ladderRow][ladderCol].setLadder(true);

        // Place pits
        int pitsPlaced = 0;
        while(pitsPlaced < NUM_PITS){
            int r = rand.nextInt(NUM_ROWS);
            int c = rand.nextInt(NUM_COLS);
            if(!grid[r][c].hasPit() && !grid[r][c].hasLadder()){
                grid[r][c].setPit(true);
                // place breeze around pit
                for(int dr=-1; dr<=1; dr++){
                    for(int dc=-1; dc<=1; dc++){
                        int nr = r+dr, nc = c+dc;
                        if(nr>=0 && nr<NUM_ROWS && nc>=0 && nc<NUM_COLS && !(dr==0 && dc==0))
                            grid[nr][nc].setBreeze(true);
                    }
                }
                pitsPlaced++;
            }
        }

        // Place Wumpus
        while(true){
            int r = rand.nextInt(NUM_ROWS);
            int c = rand.nextInt(NUM_COLS);
            if(!grid[r][c].hasPit() && !grid[r][c].hasLadder()){
                grid[r][c].setWumpus(true);
                // stench
                for(int dr=-1; dr<=1; dr++){
                    for(int dc=-1; dc<=1; dc++){
                        int nr = r+dr, nc=c+dc;
                        if(nr>=0 && nr<NUM_ROWS && nc>=0 && nc<NUM_COLS && !(dr==0 && dc==0))
                            grid[nr][nc].setStench(true);
                    }
                }
                break;
            }
        }

        // Place gold
        while(true){
            int r = rand.nextInt(NUM_ROWS);
            int c = rand.nextInt(NUM_COLS);
            if(!grid[r][c].hasPit() && !grid[r][c].hasLadder() && !grid[r][c].hasWumpus()){
                grid[r][c].setGold(true);
                break;
            }
        }
    }

    public WumpusSquare getSquare(int r, int c){
        if(r>=0 && r<NUM_ROWS && c>=0 && c<NUM_COLS)
            return grid[r][c];
        return null;
    }

    public int getLadderRow(){ return ladderRow; }
    public int getLadderCol(){ return ladderCol; }
}