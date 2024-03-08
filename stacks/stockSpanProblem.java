import java.util.Stack;
//stock span refers to the maximum number of consecutive days for which 
//today's stock price >= stock prices untill such a price is encountered which is greater than today's 
public class stockSpanProblem {
    
    static void calculateSpan(int stocks[], int span[]) {

        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);

        for (int i = 1; i < span.length; i++) {

            int currStockValue = stocks[i];

            while (!s.isEmpty() && currStockValue > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i+1;
            }
            else {
                span[i] =  i - s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {

         int stocks[] = {100,80,60,70,60,85,100};

         int span[] = new int[7];

         calculateSpan(stocks,span);

         System.out.println("The Stock Span values are:");

        for (int i=0;i<7;i++)  {
            System.out.print(span[i] + " ");  //Printing the Stock Span values of each day
        }
    }
}
