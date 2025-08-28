public class DS0_CH12 {
    public static void floodFill(char[][] grid, int col, int row, char toReplace, char newValue){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return;
        }
        if(grid[row][col]!=toReplace){
            return;
        }
        grid[row][col] = newValue;
        floodFill(grid, col+1, row, toReplace, newValue);
        floodFill(grid, col-1, row, toReplace, newValue);
        floodFill(grid, col, row+1, toReplace, newValue);
        floodFill(grid, col, row-1, toReplace, newValue);
    }
}