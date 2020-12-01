import java.util.*;

public class ListSort
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int n = in.nextInt();
		List<Integer> odd = new ArrayList<Integer>();
		while (n != -1)
		{
			odd.add(n);
			n = in.nextInt();
		}
		Collections.sort(odd);
		String s = "";
		for(int i = 0; i < odd.size(); i ++)
			s += Integer.toString(odd.get(i)) + ", ";
		System.out.println("Sorted: " + s.substring(0, s.length() - 2));
	}
}
