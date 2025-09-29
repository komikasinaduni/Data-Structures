import java.util.ArrayList;

public class DS2_Infix_Postfix_Calculator {
    public static String infixToPostfix(String infix){
        MyStack<String> yo = new MyStack<>();
        String[] infixr = infix.split(" ");
        ArrayList<String> yo2 = new ArrayList<>();

        // PEMDAS
        for(int i = 0; i<infixr.length; i++){
            if((infixr[i]=="+"||infixr[i]=="-"||infixr[i]=="*"||infixr[i]=="/"||infixr[i]=="^")&&!((infixr[i]=="(")||(infixr[i]==")"))){
                if((yo.peek()=="+"||yo.peek()=="-")&&(infixr[i]=="+"||infixr[i]=="-")){
                    yo2.add(infixr[i]);
                } else if((yo.peek()=="+"||yo.peek()=="-")&&(infixr[i]=="*"||infixr[i]=="/")){
                    yo2.add(infixr[i]);
                } else if((yo.peek()=="*"||yo.peek()=="/")&&(infixr[i]=="*"||infixr[i]=="/")) {
                    yo2.add(infixr[i]);
                } else if((yo.peek()=="*"||yo.peek()=="/")&&(infixr[i]=="^")) {
                    yo2.add(infixr[i]);
                } else{
                    yo.push(infixr[i]);
                }
            } else if((infixr[i]=="(")){
                yo.push(infixr[i]);
            } else if((infixr[i]==")")) {
                int hi = yo.size();
                for(int k = 0; k<hi; k++){
                    if((yo.peek()=="+"||yo.peek()=="-"||yo.peek()=="*"||yo.peek()=="/"||yo.peek()=="^")) {
                        yo2.add(yo.pop());
                    } else if(yo.peek()=="("){
                        yo2.remove("(");
                        yo2.remove(")");
                    }
                }
            }else{
                yo2.add(infixr[i]);
            }
        }
        int hi = yo.size();
        for(int k = 0; k<hi; k++){
            if((yo.peek()=="+"||yo.peek()=="-"||yo.peek()=="*"||yo.peek()=="/"||yo.peek()=="^")) {
                yo2.add(yo.pop());
            }
        }
        String yooo = "";
        for(int l = 0; l< yo2.size(); l++){
            yooo+=yo2.get(l) + " ";
        }
        return yooo;
    }
    public static String solvePostfix (String postfix){
        MyStack<String> herro = new MyStack<>();
        String[] postfixr = postfix.split(" ");
        String herro2 = "";
        // PEMDAS
        for(int i = 0; i<postfixr.length; i++){
            if(!(postfixr[i]=="+"||postfixr[i]=="-"||postfixr[i]=="*"||postfixr[i]=="/"||postfixr[i]=="^")){
                herro.push(postfixr[i]);
            } else if((postfixr[i]=="+"||postfixr[i]=="-"||postfixr[i]=="*"||postfixr[i]=="/"||postfixr[i]=="^")){
                double wow1 = Double.parseDouble(herro.pop());
                double wow2 = Double.parseDouble(herro.pop());

                if(postfixr[i]=="+"){
                    herro.push(String.valueOf(wow2+wow1));
                } else if(postfixr[i]=="-"){
                    herro.push(String.valueOf(wow2-wow1));
                } else if(postfixr[i]=="*"){
                    herro.push(String.valueOf(wow2*wow1));
                } else if(postfixr[i]=="/"){
                    herro.push(String.valueOf(wow2/wow1));
                } else if(postfixr[i]=="^") {
                    herro.push(String.valueOf(Math.pow(wow2, wow1)));
                }
            }
        }
        return herro.peek();
    }
}



/*if((herro.peek()=="+"||herro.peek()=="-")&&(postfixr[i]=="+"||postfixr[i]=="-")){
                    herro2+= " " + postfixr[i];
                } else if((herro.peek()=="+"||herro.peek()=="-")&&(postfixr[i]=="*"||postfixr[i]=="/")){
                    herro2+= " " + postfixr[i];
                } else if((herro.peek()=="*"||herro.peek()=="/")&&(postfixr[i]=="*"||postfixr[i]=="/")) {
                    herro2+= " " + postfixr[i];
                } else if((herro.peek()=="*"||herro.peek()=="/")&&(postfixr[i]=="^")) {
                    herro2+= " " + postfixr[i];
                } else{
                    herro.push(postfixr[i]);
                }*/