public class spiralMatrix {
    public static void main(String[] args) {

        int arr[][] = new int[][] { { 1, 2, 3, 4 }, 
                                    { 5, 6, 7, 8 }, 
                                    { 9, 10, 11, 12 }, 
                                    { 13, 14, 15, 16 } };


        int startCol = 0;
        int startRow = 0;
        int endCol = arr[0].length - 1;
        int endRow = arr.length - 1;

        while (startRow <= endRow && startCol <= endCol) { 

            //printing topmost row
            for (int i = startCol; i <= endCol; i++) { 
                System.out.print(arr[startRow][i] + ", ");
            }

            //printing rightmost coloumn
            for (int i = startRow+1; i <= endRow; i++) { 
                System.out.print(arr[i][endCol] + ", ");
            }

            //printing bottommost row
            for (int i = endCol-1; i>=startCol; i--) {
                System.out.print(arr[endRow][i] + ", ");
            }

            //printing leftmost coloumn
            for (int i = endRow-1; i > startRow; i--) { 
                System.out.print(arr[i][startCol] + ", ");
            }

            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }
    }
}


//asked in google, amazon, apple, adobe, microsoft, oracle