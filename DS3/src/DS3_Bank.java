import java.io.File;
import java.util.Scanner;

public class DS3_Bank {
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter the file name: \n");
        String yo1 = yo.nextLine();
        DS3_Map<String, Double> hero = new DS3_Map<>();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            while (fromFile.hasNextLine()) {
                String line = fromFile.nextLine();
                String[] hoho = line.split(" ");
                if(line.contains("OPEN")){
                    if(hero.containsKey(hoho[1])){
                        System.out.println("\tAccount " + hoho[1] + " already exists");
                    }else{
                        hero.put(hoho[1], 0.0);
                        System.out.println("\tAccount " + hoho[1] + " opened with balance 0.0");
                    }
                } else if(line.contains("DEPOSIT")){
                    hero.put(hoho[1], hero.get(hoho[1])+Double.parseDouble(hoho[2]));
                    System.out.println("\tDeposited " + hoho[2] + "into " + hoho[1] + ", new balance " + hero.get(hoho[1]));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
