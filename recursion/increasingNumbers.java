import java.util.Scanner;
public class increasingNumbers {

    static void func(int n) {
        if (n==1) {
            System.out.print(n);
            return;
        }
        func(n-1);
        System.out.print(", "+n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Upto what number there is need to print");
        int num = input.nextInt();
        input.close();
        func(num);
     }
    
}
