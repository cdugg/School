public class Test {
	public static String firstShallBeLast(String word)
	{
		int len = word.length();
		word = word.substring((len - 1), (len)) + word.substring(1, (len - 1)) + word.substring(0, 1);
		return word;
	}
}
