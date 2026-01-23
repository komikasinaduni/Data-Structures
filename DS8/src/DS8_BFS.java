import java.awt.Point;
public class DS8_BFS{
    public static int breadthFirstSearch_Portals(char[][] maze){
        Point start = null;
        Point end = null;
        int[][] distance = new int[maze.length][maze[0].length];
        DS8_Queue<Point> queue = new DS8_Queue<>();
        for (int i = 0; i<maze.length; i++){
            for (int j = 0; j<maze[0].length; j++){
                if (maze[i][j]=='S'){
                    start = new Point(i, j);
                }
                if (maze[i][j]=='E'){
                    end = new Point(i, j);
                }
                distance[i][j] = -1;
            }
        }
        queue.offer(start);
        distance[start.x][start.y] = 0;
        while (!queue.isEmpty()){
            Point location = queue.poll();
            int x = location.x;
            int y = location.y;
            if (distance[end.x][end.y]!=-1){
                return distance[end.x][end.y];
            }
            if(x-1>=0 && distance[x-1][y]==-1 && maze[x-1][y]!='W'){
                queue.offer(new Point(x-1, y));
                distance[x-1][y] = distance[x][y]+1;
            }
            if(x+1<maze.length && distance[x+1][y]==-1 && maze[x+1][y]!='W'){
                queue.offer(new Point(x+1, y));
                distance[x+1][y] = distance[x][y]+1;
            }
            if(y-1>=0 && distance[x][y-1]==-1 && maze[x][y-1]!='W'){
                queue.offer(new Point(x, y-1));
                distance[x][y-1] = distance[x][y]+1;
            }
            if(y+1<maze[0].length && distance[x][y+1]==-1 && maze[x][y+1]!='W'){
                queue.offer(new Point(x, y+1));
                distance[x][y+1] = distance[x][y]+1;
            }
            char cell = maze[x][y];
            if(Character.isLetter(cell) && cell!='S' && cell!='E'){
                char target;
                if(Character.isUpperCase(cell)){
                    target = Character.toLowerCase(cell);
                } else{
                    target = Character.toUpperCase(cell);
                }
                for (int i = 0; i<maze.length; i++){
                    for (int j = 0; j<maze[0].length; j++){
                        if (maze[i][j]==target && distance[i][j]==-1){
                            queue.offer(new Point(i, j));
                            distance[i][j] = distance[x][y]+1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static String breadthFirstSearch_Unweighted(String[] edges, String vertices, char start, char end){
        DS8_Queue<String> queue = new DS8_Queue<>();
        boolean[] visited = new boolean[vertices.length()];
        queue.offer("" + start);
        visited[vertices.indexOf(start)] = true;
        while (!queue.isEmpty()){
            String path = queue.poll();
            char current = path.charAt(path.length()-1);
            if (current==end){
                return path;
            }
            for(int i = 0; i<edges.length; i++){
                char a = edges[i].charAt(0);
                char b = edges[i].charAt(1);
                char next = 0;
                if (a==current){
                    next = b;
                } else if(b==current){
                    next = a;
                }
                if(next!=0){
                    int index = vertices.indexOf(next);
                    if (!visited[index]){
                        visited[index] = true;
                        queue.offer(path + next);
                    }
                }
            }
        }
        return null;
    }

}

