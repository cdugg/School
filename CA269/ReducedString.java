import java.util.Scanner;

public class ReducedString
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer and a string: ");
        int pos = in.nextInt();
        String name = in.next();
        int len = name.length();      
        String last = name.substring(0, pos) + name.substring(pos + 1, len);
        System.out.println(last);
    }
}
