import java.util.Scanner;

public class TwoTimes
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
		int input = in.nextInt();       
        input = input * 2;
        System.out.print("Times two is: ");
        System.out.println(input);        
    }
}
