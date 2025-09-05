import java.io.File;
import java.util.*;
public class DS1_CH2 {
    public static int vowelNames(String fileName){
        String vowels = "AaEeIiOoUu";
        ArrayList<String> yo = new ArrayList<>();
        try{
            Scanner hi = new Scanner(new File(fileName));
            while(hi.hasNextLine()){
                String line = hi.nextLine();
                String yo2 = ""+ line.charAt(0);
                if(vowels.contains(yo2)){
                    yo.add(line);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return yo.size();
    }
}
