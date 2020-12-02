import java.util.Scanner;
public class HiCounter {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a phrase: ");
		String word = in.next();
		int i = 0;
		int n = word.length();
		int count = 0;
		while(i < (n - 1))
		{
			if(word.substring(i, i + 2).equals("hi"))
			{
				count++;
			}
			i++;
		}
		System.out.println(count);
	}
}
