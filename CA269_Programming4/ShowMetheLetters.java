public class Word {
	public static String showLetters(String word, String guesses)
	{
		String line = "";
		for(int i=0;i<word.length();i++)
		{
			if(containsLetter(guesses, word.charAt(i)))
				{
				line=line+word.substring(i, i+1);
				}
			else
				{
				line = line+"_";
				}
		}
		return line;
	}
	
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
