import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;
public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices) {
        ArrayList<String> result = new ArrayList<>();
        int vc = vertices.length();
        for (int i = 0; i <edges.length; i++) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int a = 0; a<vc; a++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j<edges.length; j++) {
                if (j==i) {
                    continue;
                }
                char a = edges[j].charAt(0);
                char b = edges[j].charAt(1);
                int ai = vertices.indexOf(a);
                int bi = vertices.indexOf(b);
                graph.get(ai).add(bi);
                graph.get(bi).add(ai);
            }
            boolean[] visited = new boolean[vc];
            dfs(0, graph, visited);
            int visc = 0;
            for (int k = 0; k<visited.length; k++) {
                if (visited[k]) {
                    visc++;
                }
            }
            if (visc<vc) {
                result.add(edges[i]);
            }
        }
        if (result.size()==0) {
            return null;
        }
        Collections.sort(result);
        return result;
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i<graph.get(v).size(); i++) {
            int next = graph.get(v).get(i);
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    public static String[] stronglyConnectedRegions(String[] edges, String vertices) {
        int vc = vertices.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> opp = new ArrayList<>();
        for (int i = 0; i < vc; i++) {
            graph.add(new ArrayList<>());
            opp.add(new ArrayList<>());
        }
        for (int i = 0; i<edges.length; i++) {
            char from = edges[i].charAt(0);
            char to = edges[i].charAt(1);
            int f = vertices.indexOf(from);
            int t = vertices.indexOf(to);
            graph.get(f).add(t);
            opp.get(t).add(f);
        }
        boolean[] used = new boolean[vc];
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i<vc; i++) {
            if (used[i]) {
                continue;
            }
            boolean[] forw = new boolean[vc];
            boolean[] back = new boolean[vc];
            dfsDirected(i, graph, forw);
            dfsDirected(i, opp, back);
            String region = "";
            int count = 0;
            for (int j = 0; j<vc; j++) {
                if (forw[j] && back[j]) {
                    region+= vertices.charAt(j);
                    count++;
                }
            }
            if(count>1) {
                for (int j = 0; j<vc; j++) {
                    if (forw[j] && back[j]) {
                        used[j] = true;
                    }
                }
                result.add(region);
            }
        }
        if (result.size()==0) {
            return null;
        }
        for(int i=0;i<result.size()-1;i++){
            for(int j=0;j<result.size()-1-i;j++){
                if(result.get(j).compareTo(result.get(j+1))>0){
                    String temp=result.get(j);
                    result.set(j,result.get(j+1));
                    result.set(j+1,temp);
                }
            }
        }
        if (result.size()==0){
            return null;
        }
        String[] arr = result.toArray(new String[0]);
        return arr;
    }

    private static void dfsDirected(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i<graph.get(v).size(); i++){
            int next = graph.get(v).get(i);
            if (!visited[next]){
                dfsDirected(next, graph, visited);
            }
        }
    }
}
