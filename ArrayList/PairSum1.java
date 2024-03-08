import java.util.ArrayList;
import java.util.Collections;

public class PairSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,8,6,2,5,4,8,3,7);

        // brute force approach is simply finding all the pairs in the 
        //array and checking if their sum equals to target value

        //optimised solution
        int n = list.size();
        Collections.sort(list); // sort the array first so that we can use two pointers technique
        int lp = 0;
        int rp = n-1;
        int pairSum = 0;
        while (lp < rp) {
            pairSum = list.get(lp) + list.get(rp);
            if (pairSum == 9) {
                System.out.println(list.get(lp) + "+" + list.get(rp) + "=" + 9);
                break;
            }    
            if (pairSum < 9) {
                lp++;
            }
            else {
                rp--;
            }
        }
    }
}
