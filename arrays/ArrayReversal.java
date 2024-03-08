public class ArrayReversal {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int last = arr.length - 1;
        int first;
        int temp;

        for (int i = 0; i < arr.length / 2; i++) {

            first = i;

            temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            last--;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
