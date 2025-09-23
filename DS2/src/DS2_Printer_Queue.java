import java.util.*;
import java.io.*;

public class DS2_Printer_Queue {

    public static int[] sumLines(String fileName) {
        ArrayList<Integer> hi = new ArrayList<>();
        try {
            Scanner fromFile = new Scanner(new File(fileName));
            while (fromFile.hasNextLine()) {
                String line = fromFile.nextLine();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    int oh = 0;
                    for (int i = 0; i<parts.length; i++) {
                        oh += Integer.parseInt(parts[i]);
                    }
                    hi.add(oh);
                }
            }
            fromFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] yo = new int[hi.size()];
        for (int i = 0; i < hi.size(); i++) {
            yo[i] = hi.get(i);
        }
        return yo;
    }

    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        try{
            File hi = new File("TicTacToe.txt");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
