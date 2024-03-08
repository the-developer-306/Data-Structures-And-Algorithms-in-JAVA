public class MaxSumSubArray {
    public static void main(String[] args) {

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum = 0;
            }
            // System.out.println();
        }
        System.out.println(maxSum);
    }
}
