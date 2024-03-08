public class p12 {
    public static void main(String args[])
    {
        for(int i=1; i<=5;i++)
        {
            int spaces = 5-i;
            for(int j=1;j<=spaces;j++)
            {
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }        
    }
    
}
