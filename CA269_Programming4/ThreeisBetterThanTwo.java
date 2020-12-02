import java.util.Scanner;

public class Thrice
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int input3 = in.nextInt();
        int output = input1 * input2 * input3;
        System.out.println("The product is " + output);
    }
}
