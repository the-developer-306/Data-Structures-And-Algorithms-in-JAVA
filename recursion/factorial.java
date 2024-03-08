public class factorial {

    static int fact(int n) { 
        
        if(n==0) { 
            return 1;
        }
        int factorial = fact(n-1)*n;
        return factorial;
    }

    public static void main(String[] args) { 
        int num = 5;
        int f = fact(num);
        System.out.println(f);
    }
}
