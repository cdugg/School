public class Word
{
	public static boolean containsLetter(String word, char letter)
	{
		String s = String.valueOf(letter);
		for(int i = 0; i < word.length(); i++)
		{
			if(s.equals(word.substring(i,i+1)))
			{
				return true;
			}
		}
		return false;
	}
}
