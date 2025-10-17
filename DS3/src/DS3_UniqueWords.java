import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class DS3_UniqueWords {
    public static void main(String[] args) {
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter the file name: \n");
        String yo1 = yo.nextLine();
        DS3_Set<String> hero = new DS3_Set<>();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            while(fromFile.hasNextLine()){
                String line = fromFile.nextLine();
                line= line.toLowerCase();
                //searched this part up
                line = line.replaceAll("[\\p{Punct}&&[^_]]", "");
                String[] wow = line.split(" ");
                for(int i = 0; i<wow.length; i++){
                    hero.add(wow[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> herro = hero.iterator();
        for(int i = 0; i< hero.size(); i++){
            System.out.print(herro.next() + "\n");
        }
    }
}