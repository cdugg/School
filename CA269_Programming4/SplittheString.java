import java.util.Scanner;
public class SplitWord {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = in.next();
		int i = word.length();
		int n = 0;
		while(n < (i - 1))
		{
			System.out.println(word.substring(n, n + 2));
			n++;
		}
	}
}
