public class p14 {
    public static void main(String[] args) 
    {
        for(int i=1; i<=4;i++)
        {
            int spaces = 4-i;
            for(int j=1;j<=spaces;j++)
            {
                System.out.print("  ");
            }

            for (int k = 1; k <= i; k++) 
            { 
                System.out.print("* ");
            }

            for (int k = 2; k <= i; k++) 
            {
                System.out.print("* ");
            }

            System.out.println();
        }    
        
        
        for(int i=3; i>=1;i--)
        {
            int spaces = 4-i;
            for(int j=1;j<=spaces;j++)
            {
                System.out.print("  ");
            }

            for (int k = 1; k <= i; k++) 
            { 
                System.out.print("* ");
            }

            for (int k = 2; k <= i; k++) 
            {
                System.out.print("* ");
            }

            System.out.println();
        }    
    }
    
}
