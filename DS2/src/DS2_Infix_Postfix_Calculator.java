public class DS2_Infix_Postfix_Calculator {
    public static String infixToPostfix(String infix){
        MyStack<String> yo = new MyStack<>();
        String[] infixr = infix.split(" ");
        String yo2 = "";
        // PEMDAS
        for(int i = 0; i<infixr.length; i++){
            if(infixr[i]=="+"||infixr[i]=="-"||infixr[i]=="*"||infixr[i]=="/"||infixr[i]=="^"){
                if((yo.peek()=="+"||yo.peek()=="-")&&(infixr[i]=="+"||infixr[i]=="-")){
                    yo2+= " " + infixr[i];
                } else if((yo.peek()=="+"||yo.peek()=="-")&&(infixr[i]=="*"||infixr[i]=="/")){
                    yo2+= " " + infixr[i];
                } else if((yo.peek()=="*"||yo.peek()=="/")&&(infixr[i]=="*"||infixr[i]=="/")) {
                    yo2+= " " + infixr[i];
                } else if((yo.peek()=="*"||yo.peek()=="/")&&(infixr[i]=="^")) {
                    yo2+= " " + infixr[i];
                } else{
                    yo.push(infixr[i]);
                }
            }
        }

    }
}
