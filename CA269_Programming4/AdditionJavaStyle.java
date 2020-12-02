import java.util.Scanner;

public class SumIt
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int output = input1 + input2;
        System.out.println(input1 + " and " + input2 + " is " + output);
    }
}
