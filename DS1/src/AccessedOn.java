import java.util.*;
import java.io.*;
//every import below this was searched up
import java.time.*;
import java.time.format.*;
import java.util.TimeZone.*;
public class AccessedOn {
    public static void main(String[] args) {
        try {
            File hi = new File("AccessedOn.txt");
            if(!hi.exists())
                hi.createNewFile();
            FileWriter fw = new FileWriter(hi, true);
            PrintWriter pw = new PrintWriter(fw);
            // Everything below this and above the next comment was searched up
            LocalDateTime hey = LocalDateTime.now();
            DateTimeFormatter herro = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss ");
            DateTimeFormatter yo = DateTimeFormatter.ofPattern("yyyy");
            //-----------------------------------------------------------------------------
            pw.println(hey.format(herro)+"CDT "+hey.format(yo));
            fw.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}