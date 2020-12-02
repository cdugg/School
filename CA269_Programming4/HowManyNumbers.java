import java.util.Scanner;

public class HowManyNumbers {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		int num = in.nextInt();
		int count = 0;
		while(num != -1)
		{
			count++;
			num = in.nextInt();
		}
		System.out.println(count + " numbers were entered.");
	}
}
