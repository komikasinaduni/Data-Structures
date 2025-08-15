import java.util.ArrayList;
public class DS0_CH1 {
    public static int uniqueCount(int[] list){
        ArrayList<Integer> hi = new ArrayList<>();
        for(int i = 0; i< list.length; i++){
            if(!(hi.contains(list[i]))) {
                hi.add(list[i]);
            }
        }
        return hi.size();
    }
}