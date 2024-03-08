public class tilingProblem {

    static int tileWaysCalc(int n) { // for 2xn floor

        if (n == 0 || n == 1) {
            return 1;
        }

        // for vertical arrangement
        int fnm1 = tileWaysCalc(n - 1);
        
        // for horizontal arrangement
        int fnm2 = tileWaysCalc(n - 2);

        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    public static void main(String[] args) {

        int ways = tileWaysCalc(10);
        System.out.println(ways);
    }
}
