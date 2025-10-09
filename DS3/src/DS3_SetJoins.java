import java.util.*;
import java.io.*;
import java.util.Iterator;
public class DS3_SetJoins {
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter the file name: \n");
        String yo1 = yo.nextLine();
        DS3_Set<Integer> SetA = new DS3_Set<>();
        DS3_Set<Integer> SetB = new DS3_Set<>();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            String line = fromFile.nextLine();
            String[] parts = line.split(" ");
            for(int i = 0; i< parts.length; i++){
                SetA.add(Integer.valueOf(parts[i]));
            }
            line = fromFile.nextLine();
            parts = line.split(" ");
            for(int i = 0; i< parts.length; i++){
                SetB.add(Integer.valueOf(parts[i]));
            }
            fromFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Set A: "+SetA.toString());
        System.out.println("Set B: "+SetB.toString());
        DS3_Set<Integer> Union = new DS3_Set<>();
        Iterator<Integer> herro = SetA.iterator();
        Iterator<Integer> wassup = SetB.iterator();
        Iterator<Integer> wassup2 = Union.iterator();
        for(int i = 0; i<SetA.size(); i++){
            Union.add(herro.next());
            Union.add(wassup.next());
        }
        for(int i = 0; i< Union.size(); i++){
            if(wassup2.next()>wassup2.next()){

            }
        }
        Iterator<Integer> yo2 = SetA.iterator();
        Iterator<Integer> yo3 = SetB.iterator();
        System.out.println("");
        DS3_Set<Integer> Intersection = new DS3_Set<>();
        DS3_Set<Integer> notInA = new DS3_Set<>();
        DS3_Set<Integer> notInB = new DS3_Set<>();
        System.out.println("Union: " + Union);
        for(int i = 0; i<SetA.size(); i++){
            int wow = yo2.next();
            if(SetB.contains(wow)){
                Intersection.add(wow);
            } else {
                notInB.add(wow);
            }
        }
        for(int i = 0; i<SetA.size(); i++){
            int wow = yo3.next();
            if(SetA.contains(wow)){
                i+=0;
            } else{
                notInA.add(wow);
            }
        }
        System.out.println("Intersection: " + Intersection);
        System.out.println("A - B (Elements in A not in B): " + notInB);
        System.out.println("B - A (Elements in B not in A): " + notInA);
    }

}