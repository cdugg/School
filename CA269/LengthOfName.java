import java.util.Scanner;

public class LengthOfName
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.next();
        int len = name.length();
        System.out.println("Hello " + name + ", your name has " + len + " letters.");
    }
}
