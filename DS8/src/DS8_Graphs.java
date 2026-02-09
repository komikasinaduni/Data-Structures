import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices){
        ArrayList<Character> yo = new ArrayList<>();
        DS8_Stack<Character> stack = new DS8_Stack<>();
        for(int i = 0; i< edges.length; i++){
            char[] yo2 = edges[i].toCharArray();
            yo.add(yo2[0]);
            yo.add(yo2[1]);
            stack.push(yo2[0]);
            stack.push(yo2[1]);
        }
        ArrayList<Integer> repeat = new ArrayList<>();
        ArrayList<Character> yo3 = new ArrayList<>();
        for(int i = 0; i<stack.size(); i++){
            int size = 0;
            char curr = stack.pop();
            yo3.add(curr);
            for(int j = 0; j<yo.size(); j++){
                if(yo.get(j).equals(curr)){
                    size++;
                }
            }
            repeat.add(size);
        }
        ArrayList<String> wow = new ArrayList<>();
        if(repeat.contains(1)){
            char win = ' ';
            for(int i = 0; i<yo3.size(); i++){
                if(repeat.get(i)==1){
                    win = yo3.get(i);
                    for(int j = 0; j< edges.length; j++){
                        char[] hi = edges[i].toCharArray();
                        if(hi[0]==win||hi[1]==win){
                            wow.add(edges[j]);
                        }
                    }
                }
            }
            return wow;
        }
        return null;
    }

}
