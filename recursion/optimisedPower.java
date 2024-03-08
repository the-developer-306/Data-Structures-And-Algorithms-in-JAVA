import java.util.Scanner;

public class optimisedPower {

    static int optPower(int a, int n) {

        if (n == 0) {
            return 1;
        }

        // this method reduces two function calls
        // hence time complexity is reduced in this only
        int halfpow = optPower(a, n / 2);
        int pow = halfpow * halfpow;

        // condition for n being odd
        if (n % 2 != 0) {
            pow = a * pow;
        }

        return pow;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int power = input.nextInt();
        input.close();
        int answer = optPower(num, power);
        System.out.println(answer);

    }
}
