public class Test
{
	public static int largest(int a, int b, int c) 
	{
		int big = a;
		if (b > big)
			big = b;
		if (c > big)
			big = c;
		return big;	
	}
}
