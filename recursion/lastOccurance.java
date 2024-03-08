public class lastOccurance {

    static int lastFound(int arr[], int key, int i) { 
 
        if (i == arr.length-1) { 
            return -1;
        }

        int isFound = lastFound(arr, key, i + 1);

        if (key == arr[i] || isFound == -1) { 
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) { 
        int a[] = {1,2,3,4,5,6,7,8,9};
        int k = 936;
        System.out.println("Key found at : " + lastFound(a, k , 0));
    }
    
}
