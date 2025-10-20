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
                String line = fromFile.nextLine().trim(); // remove leading/trailing whitespace
                if (line.isEmpty()) continue;              // skip blank lines
                String[] hoho = line.split("\\s+");       // split on any whitespace
                System.out.println(line);
                if (line.contains("OPEN")) {
                    if (hero.containsKey(hoho[1])) {
                        System.out.println("\tAccount " + hoho[1] + " already exists");
                    } else {
                        hero.put(hoho[1], 0.0);
                        System.out.println("\tAccount " + hoho[1] + " opened with balance 0.0");
                    }
                } else if (line.contains("DEPOSIT")) {
                    if (!hero.containsKey(hoho[1])) {
                        System.out.println("\tAccount not found for deposit into " + hoho[1]);
                    } else {
                        hero.put(hoho[1], hero.get(hoho[1]) + Double.parseDouble(hoho[2]));
                        System.out.println("\tDeposited " + Double.parseDouble(hoho[2]) + " into " + hoho[1] + ", new balance " + hero.get(hoho[1]));
                    }
                } else if (line.contains("CLOSE")) {
                    if (!hero.containsKey(hoho[1])) {
                        System.out.println("\tAccount not found for closing " + hoho[1]);
                    } else {
                        hero.remove(hoho[1]);
                        System.out.println("\tAccount " + hoho[1] + " closed");
                    }
                } else if (line.contains("WITHDRAW")) {
                    if (!hero.containsKey(hoho[1])) {
                        System.out.println("\tAccount not found for withdrawal from " + hoho[1]);
                    } else if (hero.get(hoho[1]) - Double.parseDouble(hoho[2]) < 0) {
                        System.out.println("\tInsufficient funds for withdrawal from " + hoho[1]);
                    } else {
                        hero.put(hoho[1], hero.get(hoho[1]) - Double.parseDouble(hoho[2]));
                        System.out.println("\tWithdrew " + Double.parseDouble(hoho[2]) + " from " + hoho[1] + ", new balance " + hero.get(hoho[1]));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
