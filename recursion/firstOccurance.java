public class firstOccurance {

    static int search(int arr[], int key, int i) {
        
        if (arr[i] == key) {
            return i;
        }

        if (i == arr.length - 1) {
            return -1; // base case of not found
        }


        return search(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k = 10;
        System.out.println("Key found at : " + search(a, k, 0));
    }

}
