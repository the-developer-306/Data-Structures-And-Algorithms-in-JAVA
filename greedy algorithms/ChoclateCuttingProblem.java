/*
    We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate
    into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive
    integer. This cost does not depend on the size of the part that is being broken but only depends on
    the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines
    with xl, x2,.., xm-l and along horizontal lines with YI, Y2,..., yn-l.
    Compute the minimal cost of breaking the whole chocolate into single squares.
*/

import java.util.Arrays;
import java.util.Collections;

public class ChoclateCuttingProblem {
    public static void main(String[] args) {
        
        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0, v = 0;
        int horPieces = 1, verPieces = 1;
        int totalCost = 0;

        // approach is that whichever cut is expensive, make that one first.

        while (h < costHor.length && v < costVer.length) {
            
            //case1: horizontal cut
            if (costVer[v] < costHor[h]) {
                totalCost = totalCost + (costHor[h] * verPieces);
                horPieces++;
                h++;
            }
            //case2: vertical cut
            else {
                totalCost = totalCost + (costVer[v] * horPieces);
                verPieces++;
                v++;
            }
        }

        // making remaining cuts if any

        while (h < costHor.length) {
            totalCost = totalCost + (costHor[h] * verPieces);
            horPieces++;
            h++;
        }

        while (v < costVer.length) {
            totalCost = totalCost + (costVer[v] * horPieces);
            verPieces++;
            v++;
        }

        System.out.println("Minimum cost of cutting: " + totalCost);
    }
}
