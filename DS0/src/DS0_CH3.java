public class DS0_CH3 {
    public static int[] fewest(int cents){
        int[] hi = new int[10];
        if (cents%10<5) {
            hi[0] = cents%5;
            hi[1] = (cents%10)/5;
            System.out.println("Line 7");
        } else {
            hi[0] = cents%5;
            hi[1] = 0;
            hi[2] = 1;
            System.out.println("Line 12");
        }
        if (cents>=10000) {
            hi[9] = cents/10000;
            cents -= hi[9]*10000;
        }
        if (cents>=5000) {
            hi[8] = cents/5000;
            cents -= hi[8]*5000;
        }
        if (cents>=2000) {
            hi[7] = cents/2000;
            cents -= hi[7]*2000;
        }
        if (cents>=1000) {
            hi[6] = cents/1000;
            cents -= hi[6]*1000;
        }
        if (cents>=500) {
            hi[5] = cents/500;
            cents -= hi[5]*500;
        }
        if (cents>=100) {
            hi[4] = cents/100;
            cents -= hi[4]*100;
        }
        if (cents>=25) {
            hi[3] = cents/25;
            cents -= hi[3]*25;
        }
        int hello = cents;
        if (hello>=20) {
            hi[2] = 2;
            hello -= 20;
        } else if (hello>=10) {
            hi[2] = 1;
            hello -= 10;
        } else {
            hi[2] = 0;
        }
        if (hello>=5) {
            hi[1] = 1;
            hello -= 5;
        } else {
            hi[1] = 0;
        }
        hi[0] = hello;
        return hi;
    }
}
