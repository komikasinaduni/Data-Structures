import java.io.File;
import java.util.Scanner;

public class DS3_UniqueWords {
    public static void main(String[] args) {
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter the file name: \n");
        String yo1 = yo.nextLine();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            String line = fromFile.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}