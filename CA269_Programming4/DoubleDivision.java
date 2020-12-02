import java.util.Scanner;

public class DoubleDivision
{
    public static void main(String [] args)
    {
    	Scanner in = new Scanner(System.in);
    	System.out.print("Please enter two floating point numbers: ");
    	float input1 = in.nextFloat();
    	float input2 = in.nextFloat();
    	float output = (float) (input1/input2);
    	System.out.println(input1 + " / " + input2 + " is " + output);
    }
}
