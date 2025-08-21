public class DS0_CH4 {
    public static boolean balanced (int[][] grid){
        boolean x = false;
        int hello = 0;
        for(int i = grid.length; i>0; i++){
            if(i== grid.length){
                hello+=i;
            } else{
                hello*=i;
            }
        }
        int[] left = new int[hello];
        int[] right = new int[hello];
        for(int i = 0; i<left.length; i++){
            if(i==left.length-1){
                i+=0;
            } else{
                left[i] = grid[i][i+1];
            }
        }
        for(int i = 0; i<right.length; i++){
            if(i==right.length-1){
                i+=0;
            } else{
                right[i] = grid[i][i-1];
            }
        }
        return x;
    }
}
