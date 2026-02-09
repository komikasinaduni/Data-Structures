import java.util.ArrayList;
import java.awt.Point;

public class DS8_Dijkstras{
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end){
        ArrayList<DS8_Weighted_Node> list = new ArrayList<>();
        boolean[] visited = new boolean[vertices.length()];
        for (int i = 0; i<vertices.length(); i++){
            char v = vertices.charAt(i);
            if(v==start){
                list.add(new DS8_Weighted_Node(v, 0));
            } else{
                list.add(new DS8_Weighted_Node(v, Integer.MAX_VALUE));
            }
            visited[i] = false;
        }
        while(true){
            DS8_Weighted_Node cur = null;
            int currIn = -1;
            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i<list.size(); i++){
                if(!visited[i] && list.get(i).getDistance()<smallest){
                    smallest = list.get(i).getDistance();
                    cur = list.get(i);
                    currIn = i;
                }
            }
            if(cur==null){
                break;
            }
            if(cur.getDistance()==Integer.MAX_VALUE){
                break;
            }
            if(cur.getLocation()==end){
                return cur.getDistance();
            }
            visited[currIn] = true;
            for (int i = 0; i<edges.length; i++){
                char from = edges[i].charAt(0);
                char to = edges[i].charAt(1);
                int w = Integer.parseInt(edges[i].substring(2));
                if(from==cur.getLocation()){
                    for (int j = 0; j<list.size(); j++){
                        if(list.get(j).getLocation()==to && !visited[j]){
                            int d = cur.getDistance()+w;
                            if(d<list.get(j).getDistance()){
                                list.get(j).setDistance(d);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int dijkstras_Topographical(char[][] grid,ArrayList<DS8_TerrainCost> travelCosts){
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dist=new int[rows][cols];
        boolean[][] visited=new boolean[rows][cols];
        Point start=null;
        Point end=null;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist[i][j]=-1;
                if(grid[i][j]=='S'){
                    start=new Point(i,j);
                }
                if(grid[i][j]=='E'){
                    end=new Point(i,j);
                }
            }
        }
        ArrayList<DS8_Terrian_Node> nodes=new ArrayList<>();
        nodes.add(new DS8_Terrian_Node(start,0));
        dist[start.x][start.y]=0;
        while(nodes.size()>0){
            int minIndex=0;
            for(int i=1;i<nodes.size();i++){
                if(nodes.get(i).getDistance()<nodes.get(minIndex).getDistance()){
                    minIndex=i;
                }
            }
            DS8_Terrian_Node current=nodes.remove(minIndex);
            Point p=current.getLocation();
            int x=p.x;
            int y=p.y;
            if(visited[x][y]){
                continue;
            }
            visited[x][y]=true;
            if(x==end.x && y==end.y){
                return dist[x][y];
            }
            if(x-1>=0 && !visited[x-1][y]){
                int cost=getTerrianCost(grid[x-1][y],travelCosts);
                if(cost!=-1){
                    int nd=dist[x][y]+cost;
                    if(dist[x-1][y]==-1 || nd<dist[x-1][y]){
                        dist[x-1][y]=nd;
                        nodes.add(new DS8_Terrian_Node(new Point(x-1,y),nd));
                    }
                }
            }
            if(x+1<rows && !visited[x+1][y]){
                int cost=getTerrianCost(grid[x+1][y],travelCosts);
                if(cost!=-1){
                    int nd=dist[x][y]+cost;
                    if(dist[x+1][y]==-1 || nd<dist[x+1][y]){
                        dist[x+1][y]=nd;
                        nodes.add(new DS8_Terrian_Node(new Point(x+1,y),nd));
                    }
                }
            }
            if(y-1>=0 && !visited[x][y-1]){
                int cost=getTerrianCost(grid[x][y-1],travelCosts);
                if(cost!=-1){
                    int nd=dist[x][y]+cost;
                    if(dist[x][y-1]==-1 || nd<dist[x][y-1]){
                        dist[x][y-1]=nd;
                        nodes.add(new DS8_Terrian_Node(new Point(x,y-1),nd));
                    }
                }
            }
            if(y+1<cols && !visited[x][y+1]){
                int cost=getTerrianCost(grid[x][y+1],travelCosts);
                if(cost!=-1){
                    int nd=dist[x][y]+cost;
                    if(dist[x][y+1]==-1 || nd<dist[x][y+1]){
                        dist[x][y+1]=nd;
                        nodes.add(new DS8_Terrian_Node(new Point(x,y+1),nd));
                    }
                }
            }
        }
        return -1;
    }

    private static int getTerrianCost(char terrian,ArrayList<DS8_TerrainCost> travelCosts){
        for(int i=0;i<travelCosts.size();i++){
            if(travelCosts.get(i).getType()==terrian){
                return travelCosts.get(i).getCost();
            }
        }
        return -1;
    }

}
