import java.util.Stack;
//stock span refers to the maximum number of consecutive days for which 
//today's stock price >= stock prices untill such a price is encountered which is greater than today's 
public class maximumHistogramArea {
    
    static void calculateNextSmallerElementTowardsRight(int arr[], int nsr[]) {

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {

                nsr[i] = arr.length;
            } 
            else {

                nsr[i] = s.peek();
            }

            s.push(i); 
        }
    }

    static void calculateNextSmallerElementTowardsLeft(int arr[], int nsl[]) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {

                nsl[i] = -1;
            } 
            else {

                nsl[i] = s.peek();
            }

            s.push(i); 
        }
    }

    static int calculateMaxArea(int arr[], int nsl[], int nsr[]) {

        int currArea = 0;
        int maxArea = 0;
        int width = 0;
        for (int i = 0; i < arr.length; i++) {
            width = nsr[i]-nsl[i]-1;
            currArea = arr[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int arr[] = {2,1,5,6,2,3};

        int nsl[] = new int[arr.length];

        int nsr[] = new int[arr.length];

        calculateNextSmallerElementTowardsLeft(arr, nsl);
        calculateNextSmallerElementTowardsRight(arr, nsr);  
        
        System.out.println("Maximum area is: " + calculateMaxArea(arr, nsl, nsr));
    }
}
