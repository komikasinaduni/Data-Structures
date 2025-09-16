import java.util.*;
import java.io.*;
public class TicTacToe {
    public static String board(char[][] wow){
        String wow1 = (" "+wow[0][0]+" | " + wow[0][1]+" | "+wow[0][2]+" \n"+"___________\n "+wow[1][0]+" | " + wow[1][1]+" | "+wow[1][2]+"  \n"+"___________\n "+wow[2][0]+" | " + wow[2][1]+" | "+wow[2][2]+" ");
        return wow1;
    }
    public static void main(String[] args){
        Scanner yo = new Scanner(System.in);
        int herro = 0;
        int wassup = 0;
        char[][] wow = {{' ', ' ', ' '},{' ', ' ', ' '}, {' ', ' ', ' '}};
        boolean win = false;
        try {
            File hi = new File("TicTacToe.txt");
            if(hi.exists()) {
                Scanner fr = new Scanner(hi);
                int r = 0;
                boolean loaded = false;
                while (fr.hasNextLine()&&r<3) {
                    String line = fr.nextLine();
                    if (line.contains("|")) {
                        String[] parts = line.split("\\|");
                        for (int c = 0; c<3; c++) {
                            char ko = ' ';
                            if(parts[c].indexOf('X')!=-1){
                                ko = 'X';
                            } else if(parts[c].indexOf('O')!=-1){
                                ko = 'O';
                            }
                            wow[r][c] = ko;
                        }
                        r++;
                        loaded=true;
                    }
                }
                if(loaded) {
                    System.out.println("Game save loaded");
                }
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(herro!=3||wassup!=3){
            System.out.println(board(wow));
            System.out.println("Entering a three for the column or row will save the game.");
            System.out.println("Enter a column from 0 to 2:");
            herro = yo.nextInt();
            System.out.println("Enter a row from 0 to 2:");
            wassup = yo.nextInt();
            if(herro!=3&&wassup!=3&&wow[wassup][herro]==' ') {
                wow[wassup][herro] = 'X';
                int yay = (int) (Math.random() * 3);
                int yoy = (int) (Math.random() * 3);
                while (wow[yay][yoy] != ' ') {
                    yay = (int) (Math.random() * 3);
                    yoy = (int) (Math.random() * 3);
                }
                wow[yay][yoy] = 'O';
            } else if(herro != 3 && wassup != 3){
                System.out.println("That spot is already taken. Try again.");
                continue;
            }
            else{
                System.out.println("Save complete");
                System.out.println("Good bye");
                break;
            }
            for(int i = 0; i < 3; i++){
                if(wow[i][0]!= ' '&& wow[i][0]==wow[i][1]&&wow[i][1]==wow[i][2]){
                    System.out.println(wow[i][0]+" Wins.");
                    win = true;
                }
                if(wow[0][i]!=' '&&wow[0][i]==wow[1][i]&&wow[1][i]==wow[2][i]){
                    System.out.println(wow[0][i] + " Wins.");
                    win = true;
                }
            }
            if(wow[0][0]!=' '&&wow[0][0]==wow[1][1]&&wow[1][1]==wow[2][2]){
                System.out.println(wow[0][0] + " Wins.");
                win = true;
            }
            if(wow[0][2]!=' '&&wow[0][2]==wow[1][1]&&wow[1][1]==wow[2][0]){
                System.out.println(wow[0][2] + " Wins.");
                win = true;
            }
            if(win) break;
        }
        try{
            File hi = new File("TicTacToe.txt");
            FileWriter fw = new FileWriter(hi, false);
            PrintWriter pw = new PrintWriter(fw);
            if(!win){
                pw.println(board(wow));
            }
            fw.close();
            pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}