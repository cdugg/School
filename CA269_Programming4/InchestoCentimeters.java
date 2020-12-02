import java.util.Scanner;

public class Inches2cm
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a quantity in inches: ");
        int input = in.nextInt();
        double centis = input * 2.54;
        System.out.println(input + " inch is " + centis + " cm");
    }
}
