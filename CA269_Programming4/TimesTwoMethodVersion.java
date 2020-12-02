import java.util.Scanner;

public class TwoTimes
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");        
        int num = in.nextInt();
        int result = Helper.twoTimes(num);
        System.out.println("Times two is: " + result);
    }
}
