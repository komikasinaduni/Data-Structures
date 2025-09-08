public class herro {
    public static String text(String s)
    {
        if(s.length()<3)
            return "A";
        else if(s.length()%2==0)
        {
            s=s.substring(1);
            return s.charAt(0)+text(s);
        }
        else
        {
            s=s.substring(0,s.length()-1);
            return s.charAt(1)+text(s);
        }
    }

    public static void main(String[] args){
        System.out.println(text("strings"));
    }
}
