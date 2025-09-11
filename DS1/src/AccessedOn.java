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
            DateTimeFormatter yo = DateTimeFormatter.ofPattern(" yyyy");
            Calendar calendar = new GregorianCalendar();
            TimeZone timeZone = calendar.getTimeZone();
            DateTimeFormatter zoneAbbreviationFormatter
                    = DateTimeFormatter.ofPattern("zzz", Locale.ENGLISH);
            //-----------------------------------------------------------------------------
            pw.println(hey.format(herro) + ZonedDateTime.now(timeZone.toZoneId()).format(zoneAbbreviationFormatter) + hey.format(yo));
            fw.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}