import java.awt.Point;
public class DS8_DFS {
    public static boolean depthFirstSearch_Simple(char[][] maze){
        Point start = null;
        Point end = null;
        boolean[][] visited = new boolean[(maze.length)][(maze[0].length)];
        DS8_Stack<Point> stack = new DS8_Stack<>();
        for(int i = 0; i< maze.length; i++){
            for(int j = 0; j<maze[0].length; j++){
                if(maze[i][j]=='S'){
                    start = new Point(i, j);
                    stack.push(start);
                    visited[i][j]=true;
                    break;
                }
            }
        }
        for(int i = 0; i< maze.length; i++){
            for(int j = 0; j<maze[0].length; j++){
                if(maze[i][j]=='E'){
                    end = new Point(i, j);
                    break;
                }
            }
        }
        while(!(stack.isEmpty())){
            Point location = stack.pop();
            if(visited[end.x][end.y]==true){
                return true;
            }
            if(location.x==0){
                if (location.y==0){
                    stack.push(new Point(0, 1));
                    stack.push(new Point(1, 0));
                }
            }
        }

    }

}