public class DS0_CH4 {
    public static boolean balanced(int[][] grid){
        int spots = 0;
        for(int i = grid.length; i>0; i--){
            spots+=i-1;
        }
        int li = 0;
        int ri = 0;
        int[] left = new int[spots];
        int[] right = new int[spots];
        boolean x = false;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(j<i){
                    left[li++] = grid[i][j];
                } else if(j>i){
                    right[ri++] = grid[i][j];
                }
            }
        }

        int lsum = 0;
        int rsum = 0;
        for(int i = 0; i<spots; i++){
            lsum+= left[i];
            rsum+= right[i];
        }
        if(lsum==rsum){
            x = true;
        }
        return x;
    }
}
