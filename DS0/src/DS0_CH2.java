public class DS0_CH2 {
    public static void commonNeighbors (int[] list){
        int[] hi = new int[list.length];
        for(int i = 0; i<list.length; i++){
            hi[i]=list[i];
        }
        if(list.length==1){
            list[0]=0;
        } else{
            for(int i = 0; i<list.length; i++){
                if(i==0){
                    if(list[i+1]!=list[i])
                        hi[i]=0;
                } else if(i==list.length-1){
                    if(list[i-1]!=list[i]){
                        hi[i]=0;
                        System.out.println("line 20");
                    }
                } else {
                    if (list[i] != list[i-1] && list[i] != list[i+1]) {
                        hi[i] = 0;
                    }
                }
            }
            for(int i = 0; i<hi.length; i++){
                list[i]=hi[i];
            }
        }
    }
}
