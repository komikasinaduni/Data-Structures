public class DS0_CH9 {
    public static int summation(int A, int B){
        if(A==B){
            return A;
        } else{
            return A+summation(A+1, B);
        }
    }
}
