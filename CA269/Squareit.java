import java.util.Scanner;

public class SquareIt
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i = in.nextInt();        
        System.out.print(i);
        i = i * i;
        System.out.print(" squared is ");
        System.out.println(i);
    }
}
