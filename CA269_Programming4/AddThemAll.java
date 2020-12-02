public class Test {
	public static int getSum(int [] num)
	{
		int total = 0;
		for(int i = 0; i < num.length; i++)
		{
			total = total + num[i];
		}
		return total;
	}
}
