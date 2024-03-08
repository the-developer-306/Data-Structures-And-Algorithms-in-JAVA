import java.util.Stack;
//stock span refers to the maximum number of consecutive days for which 
//today's stock price >= stock prices untill such a price is encountered which is greater than today's 
public class nextGreaterElement {
    
    static void calculateNextGreaterElement(int arr[], int nextGreaterElementArray[]) {

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {

                nextGreaterElementArray[i] = -1;
            } 
            else {

                nextGreaterElementArray[i] = arr[s.peek()];
            }

            s.push(i); 
        }
    }

    public static void main(String[] args) {

         int arr[] = {6,8,0,1,3};

         int nextGreaterElementArray[] = new int[arr.length];

         calculateNextGreaterElement(arr, nextGreaterElementArray);

         System.out.println("The next Greater Elements are:");

        for (int i=0;i<nextGreaterElementArray.length;i++)  {

            System.out.print(nextGreaterElementArray[i] + " ");
        }
    }
}
