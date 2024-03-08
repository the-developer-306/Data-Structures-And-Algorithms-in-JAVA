public class StaircaseSearch {

    public static boolean search(int matrix[][], int key) { 
        
        int row = 0;
        int col = matrix[0].length -1;

        //taking topmost right element as reference
        while (row < matrix.length && col >= 0) { 
            if (matrix[row][col] == key) {
                System.out.println("key found at (" + row + "," + col + ")");
                return true;
            }
            else if (key > matrix[row][col]) { 
                row++;
            }
            else if (key < matrix[row][col]) { 
                col--;
            }
        }
        System.out.println("key not found");
        return false;
        
    }

    public static void main(String[] args) { 
        int arr[][] = new int[][] { {10,20,30,40},
                                    {15,25,35,45},
                                    {27,29,37,48},
                                    {32,33,39,50}};

        int element = 27;

        boolean result = search(arr, element);
        System.out.println(result);
    }
    
}
