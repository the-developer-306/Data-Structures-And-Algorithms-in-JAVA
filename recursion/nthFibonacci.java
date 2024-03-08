import java.util.Scanner;
public class nthFibonacci {
    
    static int fibonacci(int n) {
        if(n == 0 || n == 1) { 
            return n;
        }
        int fibo = fibonacci(n-1) + fibonacci(n-2);
        return fibo;
    }

    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which fibonacci number to print");
        int num = input.nextInt();
        int f = fibonacci(num);
        System.out.println(f);
        input.close();
    }
}
