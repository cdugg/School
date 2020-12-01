import java.util.Scanner;
public class NumToTwenty {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = in.nextInt();
		for(;num <= 20; num ++)
		{
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
