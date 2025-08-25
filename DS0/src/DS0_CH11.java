public class DS0_CH11 {
    public static boolean isSolvable(char[][] maze, boolean[][] beenThere, int column, int row) {
        if (row<0 || column<0 || row>=maze.length || column>=maze[0].length) {
            return false;
        }
        if (beenThere[row][column]) {
            return false;
        }
        if (maze[row][column]=='W') {
            return false;
        }
        if (maze[row][column]=='E') {
            return true;
        }
        beenThere[row][column] = true;
        return isSolvable(maze, beenThere, column, row-1) || isSolvable(maze, beenThere, column+1, row) || isSolvable(maze, beenThere, column, row+1) || isSolvable(maze, beenThere, column-1, row);
    }
}
