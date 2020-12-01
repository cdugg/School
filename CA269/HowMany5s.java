public class Test {
	public static int countFives(int [] num)
	{
		int count = 0;
		for(int i = 0; i < num.length; i++)
		{
			if(num[i] == 5)
			{
				count++;
			}
		}
		return count;
	}
}
