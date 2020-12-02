public class Test {
	public static int countEven(int [] num)
	{
		int count = 0;
		for(int i = 0; i < num.length; i ++)
		{
			if(num[i] % 2 == 0)
			{
				count++;
			}
		}
		return count;
	}
}
