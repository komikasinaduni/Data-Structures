import java.util.*;
import java.io.*;

public class TicTacToe {
    public static String board(char[][] wow) {
        String wow1 = (" " + wow[0][0] + " | " + wow[0][1] + " | " + wow[0][2] + " \n" + "___________\n " + wow[1][0] + " | " + wow[1][1] + " | " + wow[1][2] + "  \n" + "___________\n " + wow[2][0] + " | " + wow[2][1] + " | " + wow[2][2] + " ");
        return wow1;
    }

    public static void main(String[] args) {
        Scanner yo = new Scanner(System.in);
        int herro = 0;
        int wassup = 0;
        char[][] wow = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        try {
            File hi = new File("TicTacToe.txt");
            if (hi.exists()) {
                Scanner fr = new Scanner(hi);
                int r = 0;
                boolean loaded = false;
                while (fr.hasNextLine() && r < 3) {
                    String line = fr.nextLine();
                    if (line.contains("|")) {
                        String[] parts = line.split("\\|");
                        for (int c = 0; c < 3; c++) {
                            char ko = ' ';
                            if (parts[c].indexOf('X') != -1) {
                                ko = 'X';
                            } else if (parts[c].indexOf('O') != -1) {
                                ko = 'O';
                            }
                            wow[r][c] = ko;
                        }
                        r++;
                        loaded = true;
                    }
                }
                if (loaded) {
                    System.out.println("Game save loaded");
                }
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean gameIsOver = false;
        while (!gameIsOver) {
            System.out.println(board(wow));
            System.out.println("Entering a three for the column or row will save the game.");
            System.out.println("Enter a column from 0 to 2:");
            herro = yo.nextInt();
            System.out.println("Enter a row from 0 to 2:");
            wassup = yo.nextInt();

            if (herro == 3 || wassup == 3) {
                System.out.println("Save complete");
                System.out.println("Good bye");
                gameIsOver = true;
            } else if (herro >= 0 && herro <= 2 && wassup >= 0 && wassup <= 2 && wow[wassup][herro] == ' ') {
                wow[wassup][herro] = 'X';
                if (isWinner(wow, 'X')) {
                    System.out.println(board(wow));
                    System.out.println("X wins.");
                    gameIsOver = true;
                } else if (isCat(wow)) {
                    System.out.println(board(wow));
                    System.out.println("Cat's game.");
                    gameIsOver = true;
                } else {
                    int yay = (int) (Math.random() * 3);
                    int yoy = (int) (Math.random() * 3);
                    while (wow[yay][yoy] != ' ') {
                        yay = (int) (Math.random() * 3);
                        yoy = (int) (Math.random() * 3);
                    }
                    wow[yay][yoy] = 'O';
                    if (isWinner(wow, 'O')) {
                        System.out.println(board(wow));
                        System.out.println("O wins.");
                        gameIsOver = true;
                    } else if (isCat(wow)) {
                        System.out.println(board(wow));
                        System.out.println("Cat's game.");
                        gameIsOver = true;
                    }
                }
            } else {
                System.out.println("That spot is already taken or your input is out of range. Try again.");
            }
        }

        try {
            File hi = new File("TicTacToe.txt");
            if (gameIsOver) {
                hi.delete();
            } else {
                FileWriter fw = new FileWriter(hi, false);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(board(wow));
                pw.close();
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            yo.close();
        }
    }

    public static boolean isCat(char[][] board) {
        if (isWinner(board, 'X') || isWinner(board, 'O')) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}