import java.util.*;
import java.io.File;
public class DS1_CH4 {
    public static int largestAreaSum(String fileName){
        int[][] hi = null;
        try {
            Scanner yoh = new Scanner(new File(fileName));
            String[] lol = yoh.nextLine().split("X");
            hi = new int[Integer.parseInt(lol[1])][Integer.parseInt(lol[0])];
            for(int i = 0; i<hi.length; i++){
                for(int j = 0; j<hi[0].length; j++){
                    if (yoh.hasNextInt()) {
                        hi[i][j] = yoh.nextInt();
                    }
                }
            }
            yoh.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int heyyy = Integer.MIN_VALUE;
        for (int i = 0; i<hi.length; i++){
            for (int j = 0; j<hi[0].length; j++){
                int sum = hi[i][j];
                if (i>0) {
                    sum += hi[i-1][j];
                }
                if (i < hi.length-1){
                    sum += hi[i+1][j];
                }
                if (j > 0){
                    sum += hi[i][j-1];
                }
                if (j < hi[0].length - 1){
                    sum += hi[i][j+1];
                }
                heyyy = Math.max(heyyy, sum);
            }
        }
        return heyyy;
    }
}
