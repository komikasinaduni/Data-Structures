import java.util.*;
import java.io.*;
public class DS2_Printer_Queue{
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        System.out.print("Enter job file name: \n");
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
        System.out.print("");
        System.out.print("");
        int herro = 0;
        int wow = queue.size();
        double avg = 0;
        int it = 0;
        int lpe = 0;
        for(int j = 0; j<wow; j++){
            if(queue.element().getSubmissionTime() > lpe){
                it += queue.element().getSubmissionTime() - lpe;
                queue.element().setBufferingStart(queue.element().getSubmissionTime());
            } else {
                queue.element().setBufferingStart(lpe);
            }
            queue.element().setBufferingEnd(queue.element().getBufferingStart()+3);
            queue.element().setPrintStart(queue.element().getBufferingEnd());
            queue.element().setPrintEnd(queue.element().getPrintStart()+5*queue.element().getPages());
            System.out.println("Time " + queue.element().getSubmissionTime() + "s: Job #" + queue.element().getJobNumber() + " Received (" + queue.element().getPages() + " pages)");
            System.out.println("Time " + queue.element().getBufferingStart() + "s: Job #" + queue.element().getJobNumber() + " Buffering Started");
            System.out.println("Time " + queue.element().getBufferingEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Buffering and Started Printing");
            System.out.println("Time " + queue.element().getPrintEnd() + "s: Job #" + queue.element().getJobNumber() + " Finished Printing");
            lpe = queue.element().getPrintEnd();
            herro += queue.element().getPages();
            avg += queue.element().getPrintStart()-queue.element().getSubmissionTime();
            queue.poll();
            System.out.println();
        }
        avg /=wow;
        System.out.println("Printing Simulation Complete.");
        System.out.println("Total Print Jobs: " + wow);
        System.out.println("Total Pages: "+ herro);
        System.out.printf("Average Job Wait Time: %.1fs\n", avg);
        System.out.println("Idle Time: "+ it +"s");

    }
}
