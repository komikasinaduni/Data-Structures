import java.util.ArrayList;
import java.util.Scanner;

public class DS2_Infix_Postfix_Calculator {
    private static int popo(String op) {
        if (op.equals("+") || op.equals("-")){
            return 1;
        }
        if (op.equals("*") || op.equals("/")) {
            return 2;
        }
        if (op.equals("^")) return 3;
        return 0;
    }
    public static String infixToPostfix(String infix){
        MyStack<String> yo = new MyStack<>();
        String[] infixr = infix.split(" ");
        ArrayList<String> yo2 = new ArrayList<>();
        for(int i = 0; i<infixr.length; i++){
            if (infixr[i].equals("+")||infixr[i].equals("-") || infixr[i].equals("*") || infixr[i].equals("/") || infixr[i].equals("^")) {
                while (!yo.isEmpty() && !yo.peek().equals("(") && popo(yo.peek()) >= popo(infixr[i])) {
                    yo2.add(yo.pop());
                }
                yo.push(infixr[i]);
            } else if((infixr[i].equals("("))){
                yo.push(infixr[i]);
            } else if (infixr[i].equals(")")) {
                while (!yo.isEmpty() && !yo.peek().equals("(")) {
                    yo2.add(yo.pop());
                }
                if (!yo.isEmpty() && yo.peek().equals("(")) {
                    yo.pop();
                }
            }else{
                yo2.add(infixr[i]);
            }
        }
        while(!yo.isEmpty()) {
            yo2.add(yo.pop());
        }
        String yooo = "";
        for(int l = 0; l< yo2.size(); l++){
            if(l==yo2.size()-1){
                yooo+=yo2.get(l);
                break;
            }
            yooo+=yo2.get(l) + " ";
        }
        return yooo;
    }
    public static Double solvePostfix (String postfix){
        MyStack<String> herro = new MyStack<>();
        String[] postfixr = postfix.split(" ");
        String herro2 = "";
        for (int i = 0; i < postfixr.length; i++) {
            String tk = postfixr[i];
            if (!(tk.equals("+")|| tk.equals("-")|| tk.equals("*")|| tk.equals("/") || tk.equals("^"))) {
                herro.push(tk);
            } else {
                double wow1 = Double.parseDouble(herro.pop());
                double wow2 = Double.parseDouble(herro.pop());
                if (tk.equals("+")) {
                    herro.push(""+(wow2+wow1));
                } else if(tk.equals("-")) {
                    herro.push(""+(wow2-wow1));
                } else if(tk.equals("*")) {
                    herro.push(""+(wow2*wow1));
                } else if(tk.equals("/")) {
                    herro.push(""+(wow2/wow1));
                } else if(tk.equals("^")) {
                    herro.push(""+Math.pow(wow2,wow1));
                }
            }
        }
        return Double.parseDouble(herro.peek());
    }

    public static void main (String[] args){
        Scanner hi = new Scanner(System.in);
        System.out.print("Enter an equation in infix form (separating values and operators with spaces): ");
        String infix = hi.nextLine();
        System.out.println();
        System.out.println("Postfix Form: " + infixToPostfix(infix));
        System.out.printf("Result: %.2f%n", solvePostfix(infixToPostfix(infix)));

    }
}