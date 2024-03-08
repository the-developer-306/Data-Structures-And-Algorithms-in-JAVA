public class clear_bit {
 
    public static void main(String[] args) {

        int n = 5;
        int pos = 2;

        int bitMask = 1<<pos;

        int bitMaskNOT = ~(bitMask);

        int output = bitMaskNOT & n;

        System.out.println("Number after clearing bit is: "+ output);
     }
}
