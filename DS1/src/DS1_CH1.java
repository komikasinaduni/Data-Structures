/* sumLines- The method will receive a file name. The file will contain an unknown number of lines and each line will contain an unknown number of int values, seperated by commans. The method will find the sum of each line and add each sum to an int array. After processing the file, the method should return resulting array. Assume that the received file exisits and is in the correct format.
 *@param (String) fileName - the name of the file
 *@return (int[]) - the int array containing the line sums.
 */

/*Example File:
numFile3.txt
3,4,7,8,-9
        -14,6
        7

Example Call:
sumLines("numFile3.txt") -> [13, -8, 7]*/

import java.util.*;
public class DS1_CH1 {
    public static int[] sumLines(String fileName){
        ArrayList<Integer> hi = new ArrayList<>();
        try{
            Scanner fromFile = new Scanner(fileName);
            while(fromFile.hasNextInt()){
                hi.add(fromFile.nextInt());
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        int[] yo = new int[hi.size()];
        for(int i = 0; i< yo.length; i++){
            yo[i]=hi.get(i);
        }
        return yo;
    }
}
