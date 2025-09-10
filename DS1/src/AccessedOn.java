import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.TimeZone.*;
public class AccessedOn {
    public static void main(String[] args) {
        try {
            File fileRef = new File("AccessedOn.txt");
            if(!fileRef.exists())
                fileRef.createNewFile();
            FileWriter fw = new FileWriter(fileRef, true);
            PrintWriter pw = new PrintWriter(fw);
            LocalDateTime hey = LocalDateTime.now();
            DateTimeFormatter herro = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss ");
            DateTimeFormatter yo = DateTimeFormatter.ofPattern("yyyy");
            pw.println(hey.format(herro)+"CDT "+hey.format(yo));
            fw.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}