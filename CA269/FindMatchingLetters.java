import java.util.Scanner;
public class FindMatchingLetters {
	public static void main(String [] arg)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two lines:");
		String line1 = in.nextLine();
		String line2 = in.nextLine();
		int i = 0;
		int count = 0;
		
		while (i < (line1.length()) && i < (line2.length()))
		{
			if ((line1.substring(i,i+1)).equals(line2.substring(i,i+1)))
				{
				count ++;
				}
			i ++;
		}
		System.out.println("There are " + count + " corresponding characters.");
	}
}
