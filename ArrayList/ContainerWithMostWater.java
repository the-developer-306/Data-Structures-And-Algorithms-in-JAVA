import java.util.ArrayList;
import java.util.Collections;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        Collections.addAll(height, 1,8,6,2,5,4,8,3,7);

        int size = height.size();
        int currWater = 0;
        int maxWater = 0;      
        
        
        //brute force approach O(n^2)
        for (int i=0;i < size;i++) {
            for (int j = i+1;j<size ;j++ ) {  
                int minH = Math.min(height.get(i), height.get(j));
                int breadth = j-i;
                currWater = minH * breadth;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        System.out.println(maxWater);

        //optimised solution using two pointers O(n)
        Collections.sort(height);
        int lp = 0;
        int rp = size -1;
        while(lp<rp) {
            int minH = Math.min(height.get(lp), height.get(rp));
            int breadth = rp-lp;
            currWater = minH * breadth;
            maxWater = Math.max(maxWater, currWater);

            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else {
                rp--;
            }
        }
        System.out.println(maxWater);

    
    }
}
