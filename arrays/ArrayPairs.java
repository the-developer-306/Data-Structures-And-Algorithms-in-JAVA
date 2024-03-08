public class ArrayPairs {
    public static void main(String[] args) {

        int arr[] = new int[] { 1,2,3,4,5,6,7,8,9 };

        for (int i = 0; i < arr.length; i++) { 

            for (int j = i+1; j < arr.length; j++) {
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();
        }
    }
}
