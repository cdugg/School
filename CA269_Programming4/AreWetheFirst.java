public class Word
{
	public static boolean isFirstLetter(String word, char letter)
	{
		String s = String.valueOf(letter);
		return word.substring(0, 1).equals(s);
	}
}
