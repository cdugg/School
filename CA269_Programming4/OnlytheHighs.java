import java.util.Scanner;
public class OnlyHigh {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = in.next();
		int i = 0;
		int n = word.length();
		while(i < (n - 1))
		{
			if(word.substring(i, i + 2).equals("hi"))
			{
				System.out.println("hi");
			}
			i++;
		}
	}
}
