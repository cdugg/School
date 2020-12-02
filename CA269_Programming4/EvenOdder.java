import java.util.*;

public class EvenOdd
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int n = in.nextInt();
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		while (n != -1)
		{
			if(n % 2 == 0)
				even.add(n);
			else
				odd.add(n);
			n = in.nextInt();
		}
		String s = "";
		for(int i = 0; i < odd.size(); i ++)
			s += Integer.toString(odd.get(i)) + ", ";
		System.out.println("Odd: " + s.substring(0, s.length() - 2));
		s = "";
		for(int i = 0; i < even.size(); i ++)
			s += Integer.toString(even.get(i)) + ", ";
		System.out.println("Even: " + s.substring(0, s.length() - 2));		
	}
}
