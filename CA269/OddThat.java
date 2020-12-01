import java.util.Scanner;

public class EvenOdd
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = in.nextInt();
        int mod = num % 2;
        if (mod == 1)
        {
        	System.out.println(num + " is odd.");
        }
        else
        {
        	System.out.println(num + " is even.");
        }
    }
}
