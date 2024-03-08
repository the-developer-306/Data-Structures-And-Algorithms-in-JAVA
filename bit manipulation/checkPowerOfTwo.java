public class checkPowerOfTwo {

    public static void main(String[] args) {

        int n = 16;

        if ((n&(n-1)) == 0) {
            System.out.println("The number can be represented in power's of two");
        }
        else {
            System.out.println("The number cannot be represented in power's of two");
         }

     }

}
