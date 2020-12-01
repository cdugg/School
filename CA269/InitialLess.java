import java.util.Scanner;

public class InitialLess
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Tell me your name: ");
        String name = in.next();
        int len = name.length();      
        String last = name.substring(1, len);
        System.out.println("Initialless, your name is " + last + ".");
    }
}
