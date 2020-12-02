import java.util.Scanner;
public class NoMinusOne {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		int num = in.nextInt();
		int prev = num;
		while(num != -1)
		{
			prev = num;
			num = in.nextInt();
		}
		System.out.println("The penultimate number was: " + prev);;
	}
}
