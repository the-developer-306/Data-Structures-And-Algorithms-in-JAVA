public class DiagonalSum {
    public static void main(String[] args) { 
        int arr[][] = new int[][] {{1,2,3},
                                   {4,5,6},
                                   {7,8,9}};
        
        int sum = 0;


        for (int i = 0; i < arr.length; i++) { 
            sum = sum + arr[i][i];
            
            if (i != arr.length - i -1) { 
                sum = sum + arr[i][arr.length - i - 1];
            }

        }

        System.out.println(sum);
                                     
    }

}
