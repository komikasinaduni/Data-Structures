import java.util.*;
import java.io.*;
public class TicTacToe {
    public static String board(char[][] wow){
        String wow1 = (wow[0][0]+"  |" + wow[0][1]+"  |"+wow[0][2]+"  \n"+"___________\n"+wow[1][0]+"  |" + wow[1][1]+"  |"+wow[1][2]+"  \n"+"___________\n"+wow[2][0]+"  |" + wow[2][1]+"  |"+wow[2][2]+"  ");
        return wow1;
    }
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        int herro = 0;
        int wassup = 0;
        char[][] wow = {{' ', ' ', ' '},{' ', ' ', ' '}, {' ', ' ', ' '}};
        String yiyi = null;
        while(herro!=3||wassup!=3){
            System.out.println(board(wow));
            System.out.println("Entering a three for the column or row will save the game.");
            System.out.println("Enter a column from 0 to 2:");
            herro = yo.nextInt();
            System.out.println("Enter a row from 0 to 2:");
            wassup = yo.nextInt();
            if(herro!=3&&wassup!=3){
                wow[wassup][herro] = 'X';
                int yay = (int)(Math.random()*3);
                int yoy = (int)(Math.random()*3);
                while(wow[yay][yoy]!=' '){
                    yay = (int)(Math.random()*3);
                    yoy = (int)(Math.random()*3);
                }
                wow[yay][yoy]='O';
            } else{
                System.out.println("Save complete");
                System.out.println("Good bye");
                yiyi = board(wow);
                break;
            }
        }
        try{
            File hi = new File("TicTacToe.txt");
            if(!hi.exists())
                hi.createNewFile();
            FileWriter fw = new FileWriter(hi, false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(yiyi);
            fw.close();
            pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}