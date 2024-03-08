public class p13 {
    public static void main(String args[])
    {
        for(int i=1; i<=5;i++)
        {
            int spaces = 5-i;
            for(int j=1;j<=spaces;j++)
            {
                System.out.print("  ");
            }

            for(int l = i; l >= 1; l--)
            {
                System.out.print(l+" ");
            }

            for (int k = 2; k <= i; k++) 
            {
                System.out.print(k+" ");
            }


            System.out.println();
        }
    }
    
}
