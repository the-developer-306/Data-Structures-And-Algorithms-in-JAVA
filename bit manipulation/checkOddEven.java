public class checkOddEven {
    
    public static void main(String[] args) {

        int n = 4;
        
        int pos = 0;

        int bitMask = 1<<pos;

        int var = bitMask&n;

        if (var==0) {
            System.out.println("Number is even");
        }
        else {
            System.out.println("Number is odd");
         }



     }
}
