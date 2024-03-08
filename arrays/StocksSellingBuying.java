public class StocksSellingBuying {

    public static void main(String[] args) {
        int arr[] = new int[] { 7, 1, 5, 3, 6, 4 };
        int min = Integer.MAX_VALUE;
        int sp;
        int profit;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sp = arr[i];
            min = Math.min(min, arr[i]);
            profit = sp - min;
            maxProfit = Math.max(maxProfit, profit);
        }
        System.out.println(maxProfit);
    }

}
