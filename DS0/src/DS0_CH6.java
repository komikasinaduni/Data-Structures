import java.util.ArrayList;
public class DS0_CH6 {
    public static ArrayList<Integer> absoluteDifference(ArrayList<Integer> listA, ArrayList<Integer> listB){
        ArrayList<Integer> wassup = new ArrayList<>();
        for(int i = 0; i<listA.size(); i++){
            wassup.add(Math.abs(listA.get(i)-listB.get(i)));
        }
        return wassup;
    }
}
