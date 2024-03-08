public class set_bit {
    public static void main(String[] args) {

        int n = 5;
        int pos = 1;
        int bitMask = 1<<pos;

        int output = bitMask|n;
        System.out.println("The number after setting bit is: "+output);
     }
}
