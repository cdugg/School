import java.util.Scanner;

public class OneToNum
{
    public static void main(String [] args)
    {
    	Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int n = 1;
        while(n < (i+1))
        {
            System.out.print(n + " ");
            n++;
        }
        System.out.println(); 
    }
}
