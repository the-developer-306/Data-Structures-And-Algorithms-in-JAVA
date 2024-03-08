public class checkIfArrayIsSorted {

    static boolean isSorted(int arr[], int i) {

        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 6, 8, 7 };
        System.out.println(isSorted(a, 0));
    }

}
