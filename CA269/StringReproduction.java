import java.util.Scanner;
public class StringReproduction {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer and a string: ");
		int times = in.nextInt();
		String word = in.next();
		int i = 0;
		while(i < times) {
			System.out.print(word);
			i++;
		}
		System.out.println();
	}
}
