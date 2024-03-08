public class get_bit {

    public static void main(String args[]){

        int n = 5;
        int pos = 2;
        int bitMask = 1<<pos;

        if ((bitMask & n) == 0) {
            System.out.println("Bit at the given position was 0");
        }
        else{
            System.out.println("Bit at the given position was 1");
        }

        
    }
    
}
