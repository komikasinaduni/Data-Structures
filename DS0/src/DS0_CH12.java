public class DS0_CH12 {
    public static void floodFill(char[][] grid, int col, int row, char toReplace, char newValue){
        /*
        ['x','i','x'],
        ['x','x','i'],
        ['i','x','i']

        ['c','i','x'],
        ['c','c','i'],
        ['i','c','i']
         */
        if(row>0 && col>0 && row< grid.length &&col<grid[0].length){
            return;
        }
        if(row<grid.length-1 && col<grid[0].length-1  && row>0 && col>0 && grid[row][col]==toReplace) {
            grid[row][col] = newValue;
            floodFill(grid, col + 1, row + 1, toReplace, newValue);
        }
        if(row<grid.length-1 && col< grid[0].length-1  && row>0 && col>0 && grid[row+1][col-1]==toReplace){
            grid[row+1][col-1] = newValue;
            floodFill(grid, col-1, row+1, toReplace, newValue);
        }
        if (row<grid.length-1 && col<grid[0].length-1  && row>1 && col>1 && grid[row-1][col+1]==toReplace){
            grid[row-1][col+1] = newValue;
            floodFill(grid, col+1, row-1, toReplace, newValue);
        }
        if (row<grid.length-1 && col< grid[0].length-1  && row>0 && col>0 && grid[row-1][col-1]==toReplace){
            grid[row-1][col-1] = newValue;
            floodFill(grid, col-1, row-1, toReplace, newValue);
        }
    }
}