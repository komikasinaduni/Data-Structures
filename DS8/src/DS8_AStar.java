import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_AStar{

    public static DS8_Path_Solution<Point> aStar_Simple(char[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;

        Point start = null;
        Point end = null;

        for(int y=0;y<rows;y++){
            for(int x=0;x<cols;x++){
                if(maze[y][x]=='S'){
                    start = new Point(x,y);
                }
                if(maze[y][x]=='E'){
                    end = new Point(x,y);
                }
            }
        }

        ArrayList<DS8_AStar_Node<Point>> open = new ArrayList<>();
        ArrayList<Point> closed = new ArrayList<>();

        open.add(new DS8_AStar_Node<>(start,null,0,0));

        while(open.size()>0){
            Collections.sort(open);
            DS8_AStar_Node<Point> curr = open.remove(0);
            Point p = curr.getLocation();
            if(closed.contains(p)){
                continue;
            }
            if(p.equals(end)){
                ArrayList<Point> path = new ArrayList<>();
                DS8_AStar_Node<Point> temp = curr;
                while(temp!=null){
                    path.add(0,temp.getLocation());
                    temp = temp.getParent();
                }
                return new DS8_Path_Solution<>(path,path.size()-1);
            }

            closed.add(p);

            int x = p.x;
            int y = p.y;

            if(y-1>=0 && maze[y-1][x]!='W'){
                addNeighbor(new Point(x,y-1),curr,end,open,closed);
            }
            if(y+1<rows && maze[y+1][x]!='W'){
                addNeighbor(new Point(x,y+1),curr,end,open,closed);
            }
            if(x-1>=0 && maze[y][x-1]!='W'){
                addNeighbor(new Point(x-1,y),curr,end,open,closed);
            }
            if(x+1<cols && maze[y][x+1]!='W'){
                addNeighbor(new Point(x+1,y),curr,end,open,closed);
            }
        }
        return null;
    }

    private static void addNeighbor(Point next,DS8_AStar_Node<Point> current,Point end,
                                    ArrayList<DS8_AStar_Node<Point>> open,ArrayList<Point> closed){
        if(closed.contains(next)){
            return;
        }
        int g = current.getG() + 1;
        int h = Math.abs(next.x-end.x) + Math.abs(next.y-end.y);
        DS8_AStar_Node<Point> node = new DS8_AStar_Node<>(next,current,g,h);
        for(int i = 0;i<open.size();i++){
            if(open.get(i).equals(node) && open.get(i).getG()<=g){
                return;
            }
        }
        open.add(node);
    }

    public static int aStar_JetPack(char[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        Point start = null;
        Point end = null;
        for(int y = 0;y<rows;y++){
            for(int x = 0;x<cols;x++){
                if(maze[y][x]=='S'){
                    start = new Point(x,y);
                }
                if(maze[y][x]=='E'){
                    end = new Point(x,y);
                }
            }
        }
        ArrayList<DS8_AStar_Node<Point>> open = new ArrayList<>();
        ArrayList<Point> closed = new ArrayList<>();
        int h = Math.max(Math.abs(start.x-end.x),Math.abs(start.y-end.y));
        open.add(new DS8_AStar_Node<>(start,null,0,h));
        int[][] dirs = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
        while(open.size()>0){
            Collections.sort(open);
            DS8_AStar_Node<Point> current = open.remove(0);
            Point p = current.getLocation();
            if(closed.contains(p)){
                continue;
            }
            if(p.equals(end)){
                return current.getG();
            }
            closed.add(p);
            for(int[] d:dirs){
                int nx = p.x + d[0];
                int ny = p.y + d[1];
                if(nx<0 || ny<0 || nx>=cols || ny>=rows){
                    continue;
                }
                Point next = new Point(nx,ny);
                if(closed.contains(next)){
                    continue;
                }
                int cost = 0;
                if(maze[ny][nx]=='O'){
                    cost = 1;
                }
                int g = current.getG() + cost;
                DS8_AStar_Node<Point> node = new DS8_AStar_Node<>(next,current,g,0);
                boolean worse = false;
                for(DS8_AStar_Node<Point> o:open){
                    if(o.equals(node) && o.getG()<=g){
                        worse = true;
                        break;
                    }
                }
                if(!worse){
                    open.add(node);
                }
            }
        }
        return -1;
    }
}