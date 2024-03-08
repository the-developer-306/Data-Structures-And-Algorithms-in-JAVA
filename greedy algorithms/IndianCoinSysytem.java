import java.util.*;

public class IndianCoinSysytem {
    public static void main(String[] args) {
        
        int coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;

        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(coins);

        for (int i = coins.length-1; i >= 0; i--) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    answer.add(coins[i]);
                    amount = amount - coins[i];
                }
            }
        }

        System.out.println("Minimum number of coins required: " + answer.size());
        System.out.println("Coins used are: " + answer);
    }
}
