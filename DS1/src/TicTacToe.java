import java.util.*;
import java.io.*;
public class TicTacToe {
    public static String board(String hi){
        if(hi==null){
            return "   |   |   \n___________\n   |   |   \n___________\n   |   |   ";
        } else{
            return hi;
        }
    }
    public static void main(String[] args){
        try{
            File hi = new File("TicTacToe.txt");
            if(!hi.exists())
                hi.createNewFile();
            FileWriter fw = new FileWriter(hi, true);
            PrintWriter pw = new PrintWriter(fw);
            Scanner yo = new Scanner(System.in);
            int herro = 0;
            int wassup = 0;
            char[][] wow = {{'\0', '\0', '\0'},{'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
            while(herro!=3||wassup!=3){
                pw.println(board(null));
                pw.println("Entering a three for the column or row will save the game.");
                pw.println("Enter a column from 0 to 2:");
                herro = yo.nextInt();
                pw.println("Enter a row from 0 to 2:");
                wassup = yo.nextInt();
                if(herro!=3&&wassup!=3){
                    wow[herro][wassup] = 'X';
                    int yay = (int)(Math.random()*3);
                    int yoy = (int)(Math.random()*3);
                    while(wow[yay][yoy]!='\n'){
                        yay = (int)(Math.random()*3);
                        yoy = (int)(Math.random()*3);
                    }
                    wow[yay][yoy]='O';
                    if(herro==0){
                        if(wassup==0){
                            board()
                        }
                    }
                }

            }
            fw.close();
            pw.close();
            yo.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}