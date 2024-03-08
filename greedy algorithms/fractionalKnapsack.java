/*
    Given the weights and values of N items, put these items in a knapsack of
    capacity W to get the maximum total value in the knapsack.
*/
import java.util.*;
public class fractionalKnapsack {
    public static void main(String[] args) {

        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50; // capacity of knapsack

        double valueByWeightRatio[][] = new double[val.length][2];

        for (int i = 0; i < valueByWeightRatio.length; i++) {
            valueByWeightRatio[i][0] = i;
            valueByWeightRatio[i][1] = (double) val[i]/weight[i];
        }
        // ascending order sorting
        Arrays.sort(valueByWeightRatio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalValue = 0;

        // loop in reverse order so that we get best ratio first
        for (int i = valueByWeightRatio.length-1; i >= 0; i--) {
            
            int index = (int) valueByWeightRatio[i][0];
            
            if (capacity >= weight[index]) { // include full item
                finalValue = finalValue + val[index];
                capacity = capacity - weight[index];
            }
            else { // include fractional item
                finalValue = finalValue + (valueByWeightRatio[i][1] * capacity);
                capacity = 0;
                break;
            }

        }

        System.out.println("Final value of knapsackwill be: " + finalValue);

    }
}
