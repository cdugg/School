public class Word
{
	public static String showLetter(String word, char guess)
	{
		String [] wordArray= word.split("");
		String guessValue = String.valueOf(guess); 
		for(int i=0;i<wordArray.length;i++)
		{
			if(! wordArray[i].equals(guessValue))
			wordArray[i] = "_";
		}
		String line= "";
		for(int i=0;i<wordArray.length;i++)
		{
			line= line+wordArray[i];
		}
		return line;
	}
}
