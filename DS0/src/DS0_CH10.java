public class DS0_CH10 {
    public static long factorial(long a) {
        if(a==1)
            return 1;
        else
            return a*factorial(a - 1);
    }
}
