public class Word
{
	public static boolean allDone(String word, String guessed)
	{
		String [] letters;
		letters = new String [word.length()];
		for(int i = 0; i < word.length(); i++)
		{
			letters[i] = word.substring(i, i + 1);
		}
		for(int i = 0; i < guessed.length(); i++)
		{
			for(int j = 0; j < letters.length; j++)
			{
				if(letters[j].equals(guessed.substring(i, i + 1)))
				{
					letters[j] = "";
				}
			}
		}
		boolean end = true;
		for(int i = 0; i < letters.length; i ++)
		{
			if(letters[i] != "")
			{
				end = false;
				i = letters.length;
			}
		}
		return end;
	}
}
