import java.awt.Point;
public class DS8_DFS{
    public static boolean depthFirstSearch_Simple(char[][] maze){
        Point start = null;
        Point end = null;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DS8_Stack<Point> stack = new DS8_Stack<>();
        for (int i = 0; i<maze.length; i++){
            for (int j = 0; j<maze[0].length; j++){
                if (maze[i][j]=='S'){
                    start = new Point(i, j);
                }
                if (maze[i][j]=='E'){
                    end = new Point(i, j);
                }
            }
        }
        stack.push(start);
        visited[start.x][start.y] = true;
        while (!stack.isEmpty()){
            Point location = stack.pop();
            if (visited[end.x][end.y]){
                return true;
            }
            int x = location.x;
            int y = location.y;
            if (x-1>=0 && !visited[x-1][y] && maze[x-1][y]!='W'){
                stack.push(new Point(x-1, y));
                visited[x-1][y] = true;
            }
            if (x+1<maze.length && !visited[x+1][y] && maze[x+1][y]!='W'){
                stack.push(new Point(x+1, y));
                visited[x+1][y] = true;
            }
            if (y-1>=0 && !visited[x][y-1] && maze[x][y-1]!='W'){
                stack.push(new Point(x, y-1));
                visited[x][y-1] = true;
            }
            if (y+1<maze[0].length && !visited[x][y+1] && maze[x][y+1]!='W'){
                stack.push(new Point(x, y+1));
                visited[x][y+1] = true;
            }
        }
        return false;
    }

    public static boolean depthFirstSearch_Portals(char[][] maze){
        Point start = null;
        Point end = null;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DS8_Stack<Point> stack = new DS8_Stack<>();
        for (int i = 0; i<maze.length; i++){
            for (int j = 0; j<maze[0].length; j++){
                if (maze[i][j]=='S'){
                    start = new Point(i, j);
                }
                if (maze[i][j]=='E'){
                    end = new Point(i, j);
                }
            }
        }
        stack.push(start);
        visited[start.x][start.y] = true;
        while (!stack.isEmpty()){
            Point location = stack.pop();
            if (visited[end.x][end.y]){
                return true;
            }
            int x = location.x;
            int y = location.y;
            if (x-1>=0 && !visited[x-1][y] && maze[x-1][y]!='W'){
                stack.push(new Point(x-1, y));
                visited[x-1][y] = true;
            }
            if (x+1<maze.length && !visited[x+1][y] && maze[x+1][y]!='W'){
                stack.push(new Point(x+1, y));
                visited[x+1][y] = true;
            }
            if (y-1>=0 && !visited[x][y-1] && maze[x][y-1]!='W'){
                stack.push(new Point(x, y-1));
                visited[x][y-1] = true;
            }
            if (y+1<maze[0].length && !visited[x][y+1] && maze[x][y+1]!='W'){
                stack.push(new Point(x, y+1));
                visited[x][y+1] = true;
            }
            char cell = maze[x][y];
            if (Character.isLetter(cell) && cell!='S' && cell!='E'){
                char target;

                if (Character.isUpperCase(cell)){
                    target = Character.toLowerCase(cell);
                } else{
                    target = Character.toUpperCase(cell);
                }
                for (int i = 0; i<maze.length; i++){
                    for (int j = 0; j<maze[0].length; j++){
                        if (maze[i][j]==target && !visited[i][j]){
                            stack.push(new Point(i, j));
                            visited[i][j] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
