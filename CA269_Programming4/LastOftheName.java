import java.util.Scanner;

public class LastLetter
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = in.next();
        int len = name.length();
        int lenstart = len - 1;
        String last = name.substring(lenstart, len);
        System.out.println("The last letter of your name is " + last + ".");
    }
}
