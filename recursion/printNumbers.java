import java.util.Scanner;
public class printNumbers {

    static void func(int n) {
        if (n ==1 ) {
            System.out.print(n);
            return;
        }
        System.out.print(n+", ");
        func(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        sc.close();
        func(num);
     }
    
}
