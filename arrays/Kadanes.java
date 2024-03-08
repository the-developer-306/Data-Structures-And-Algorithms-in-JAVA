public class Kadanes {

    public static void main(String[] args) {

        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            currSum = currSum<0 ? 0 : currSum;

            maxSum = Math.max(currSum, maxSum);

        }
        System.out.println(maxSum);
    }

}
