import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
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
        DS3_Set<Integer> ooh = new DS3_Set<>();
        while (herro.hasNext()) {
            Integer ok = herro.next();
            if(ok!=null){
                ooh.add(ok);
            }
        }
        while (wassup.hasNext()) {
            Integer yea = wassup.next();
            if (yea!=null){
                ooh.add(yea);
            }
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        Iterator<Integer> wassup2 = ooh.iterator();
        while (wassup2.hasNext()) {
            arrList.add(wassup2.next());
        }
        java.util.Collections.sort(arrList);
        for (int i = 0; i < arrList.size(); i++) {
            Union.add(arrList.get(i));
        }
        Iterator<Integer> yo2 = SetA.iterator();
        Iterator<Integer> yo3 = SetB.iterator();
        System.out.println("");
        DS3_Set<Integer> Intersection = new DS3_Set<>();
        DS3_Set<Integer> notInA = new DS3_Set<>();
        DS3_Set<Integer> notInB = new DS3_Set<>();
        System.out.println("Union: " + Union);
        while (yo2.hasNext()) {
            int wow = yo2.next();
            if (SetB.contains(wow)) {
                Intersection.add(wow);
            } else {
                notInB.add(wow);
            }
        }
        while (yo3.hasNext()) {
            int wow = yo3.next();
            if (!SetA.contains(wow)) {
                notInA.add(wow);
            }
        }
        System.out.println("Intersection: " + Intersection);
        System.out.println("A - B (Elements in A not in B): " + notInB);
        System.out.println("B - A (Elements in B not in A): " + notInA);
    }

}