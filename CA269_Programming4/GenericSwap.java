public class Swap {
	public static <TYPE> TYPE[] swap(TYPE [] num, int i, int j)
	{
		TYPE temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		return num;
	}
}
