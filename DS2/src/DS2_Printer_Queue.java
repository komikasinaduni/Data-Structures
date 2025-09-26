import java.util.*;
import java.io.*;
public class DS2_Printer_Queue{
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter job file name: ");
        String yo1 = yo.nextLine();
        int i = 0;
        MyQueue<Job> queue = new MyQueue<>();
        try {
            Scanner fromFile = new Scanner(new File(yo1));
            int k = 0;
            while (fromFile.hasNextLine()) {
                String line = fromFile.nextLine();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    i++;
                    Job wassup = new Job(i, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    wassup.setBufferingStart(k);
                    wassup.setBufferingEnd(k+3);
                    wassup.setPrintEnd(wassup.getBufferingEnd()+(5* wassup.getPages()));
                    k = wassup.getPrintEnd();
                    queue.offer(wassup);
                }
            }
            fromFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        int herro = 0;
        int wow = queue.size();
        int avg = 0;
        for(int j = 0; j<wow; j++){
            System.out.println("Time " + queue.element().getSubmissionTime() + "s: Job #" + queue.element().getJobNumber() + " Received (" + queue.element().getPages() + " pages)");
            System.out.println("Time " + queue.element().getBufferingStart() + "s: Job #" + queue.element().getJobNumber() + " Buffering Started");
            System.out.println("Time " + queue.element().getBufferingEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Buffering and Started Printing");
            System.out.println("Time " + queue.element().getPrintEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Printing");
            avg+=queue.element().getPrintEnd()-queue.element().getBufferingStart();
            herro+=queue.element().getPages();
            queue.poll();
            System.out.println();
        }
        avg /=wow;
        System.out.println("Printing Simulation Complete.");
        System.out.println("Total Print Jobs: " + wow);
        System.out.println("Total Pages: "+ herro);
        System.out.println("Average Job Wait Time: " + avg + "s");
        System.out.println("Idle Time: 0s");

    }
}
