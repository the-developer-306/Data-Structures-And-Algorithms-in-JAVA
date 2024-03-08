import java.util.ArrayList;
import java.util.Collections;

public class PairSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 11,15,6,8,9,10);

        //brute force approach is simply finding all the pairs in the 
        //array and checking if their sum equals to target value

        //optimised solution
        //as we see this is sorted and a rotated array thus we need to find the pivot point and 
        //make use of circular updation of pointers
        int n = list.size();

        //searching pivot point
        int pivotPoint = -1;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i+1)) {
                pivotPoint = i;
                break;                
            }
        }

        //initialising two pointers
        int rp = pivotPoint;
        int lp = pivotPoint + 1;

        int pairSum = 0;

        while (lp != rp) {
            pairSum = list.get(lp) + list.get(rp);
            if (pairSum == 16) {
                System.out.println(list.get(lp) + "+" + list.get(rp) + "=" + 16);
                break;
            }    
            if (pairSum < 16) {
                lp = (lp+1)%n; //circular updation
            }
            else {
                rp = (n+rp-1)%n; //circular updation
            }
        }
    }
}
