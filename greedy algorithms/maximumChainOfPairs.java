/*
    You are given n pairs of numbers. In every pair, the first number is always smaller than the
    second number. A pair (c, d) can come after pair (a, b) if b < c
    Find the longest chain which can be formed from a given set of pairs. 
*/

// this question is just another version of activity selection.
import java.util.*;
public class maximumChainOfPairs {
    public static void main(String[] args) {
        
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};

        int chainLength = 0;
        int lastPairEnd = 0;

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // the first pair will automatically go into the chain.
        chainLength++;
        lastPairEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] >= lastPairEnd) {
                chainLength++;
                lastPairEnd = pairs[i][1];
            }
        }

        System.out.println("Maximum chain length: " + chainLength);
    }
}
