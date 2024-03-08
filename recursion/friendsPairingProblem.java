public class friendsPairingProblem {

    static int findWays(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        // for single standing
        int sWays = findWays(n - 1);

        // for paired standing
        int pWays = (n - 1) * findWays(n - 2);

        int totalWays = sWays + pWays;

        return totalWays;
    }

    public static void main(String[] args) {
        int ways = findWays(3);
        System.out.println(ways);
    }
}
