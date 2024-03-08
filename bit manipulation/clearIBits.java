public class clearIBits {
    
    public static void main(String[] args) {

        int n = 15;
        int pos = 2;

        int bitMask = (~0)<<pos;

        int output = bitMask&n;

        System.out.println(output);
     }
}
