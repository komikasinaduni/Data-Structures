import java.util.*;
import java.io.*;
public class DS2_Printer_Queue{
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        System.out.println("Enter job file name: ");
        String yo1 = yo.nextLine();
        int i = 0;
        MyQueue<Job> queue = new MyQueue<>();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            while (fromFile.hasNextLine()) {
                String line = fromFile.nextLine();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    i++;
                    queue.offer(new Job(i, Integer.parseInt(parts[1]), Integer.parseInt(parts[0])));
                }
            }
            fromFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        for(int j = 0; j<queue.size(); j++){
            System.out.println("Time " + queue.element().getSumbissionTime + "s: Job #" + queue.element().getJobNumber() + " Received (" + queue.element().getPages() + " pages)");
            System.out.println("Time " + queue.element().getBufferingStart() + "s: Job #" + queue.element().getJobNumber() + " Buffering Started");
            System.out.println("Time " + queue.element().getBufferingEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Buffering and Started Printing");
            System.out.println("Time " + queue.element().getPrintEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Printing");
            queue.poll();
            System.out.println();
        }
    }
}
