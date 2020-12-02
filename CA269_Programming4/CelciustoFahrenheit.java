import java.util.Scanner;

public class Cent2Fahr
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        double convert = (double) (9.0/5.0);
        double centis = input * convert + 32;
        System.out.println(input + " " + centis);
    }
}
