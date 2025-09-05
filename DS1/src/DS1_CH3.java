import java.io.File;
import java.util.*;
public class DS1_CH3 {
    public static int[] rowSums(String fileName){
        ArrayList<Integer> hi = new ArrayList<>();
        try {
            Scanner fromFile = new Scanner(new File(fileName));
            while (fromFile.hasNextLine()) {
                String line = fromFile.nextLine();
                if(line.contains("X")){
                    continue;
                } else{
                    if (!line.isEmpty()) {
                        String[] parts = line.split(" ");
                        int oh = 0;
                        for (int i = 0; i<parts.length; i++) {
                            oh += Integer.parseInt(parts[i]);
                        }
                        hi.add(oh);
                    }
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

    public static int[] columnSums(String fileName){
        ArrayList<Integer> hi = new ArrayList<>();
        try {
            Scanner fromFile = new Scanner(new File(fileName));
            String firstline = fromFile.nextLine();
            int[][] wassup = null;
            wassup = new int[Integer.parseInt(String.valueOf(firstline.charAt(2)))][Integer.parseInt(String.valueOf(firstline.charAt(0)))];
            String line = null;
            while (fromFile.hasNextLine()) {
            line = fromFile.nextLine();
            if (!line.contains("X")) {
                for (int i = 0; i < wassup.length; i++) {
                    for (int j = 0; j < wassup[0].length; j++) {
                        String[] parts = line.split(" ");
                        for (int k = 0; k < parts.length; k++) {
                            wassup[i][k] = Integer.parseInt(parts[k]);
                        }
                    }
                }
            }
            for (int i = 0; i < wassup[0].length; i++) {
                int colsum = 0;
                for (int j = 0; j < wassup.length; j++) {
                    colsum += wassup[j][i];
                }
                hi.add(colsum);
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
}