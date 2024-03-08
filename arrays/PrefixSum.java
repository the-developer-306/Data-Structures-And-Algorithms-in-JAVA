public class PrefixSum {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int prefix[] = new int[arr.length]; 
        
        int currSum;
        int maxSum = Integer.MIN_VALUE;

        // calculation of prefix array
        prefix[0] = arr[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                
                if (i == 0) {
                    currSum = prefix[j];
                }
                else { 
                    currSum = prefix[j] - prefix[i-1];
                }

                if(currSum > maxSum){

                    maxSum = currSum;
                }
                
            }
            
        }
        System.out.println(maxSum);
    }
}
