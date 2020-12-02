public class WordScore {
	static String word;
	int score;
	public WordScore(String w)
	{
		word = w;
	}
	public static int score(String s)
	{
		String[] splited;
		if(s.substring(0, 1).equals(" "))
		{
			splited = s.substring(1, s.length()).split("\\s+");
			//return Integer.parseInt(splited[0]);
		}
		else
		{
			splited = s.split("\\s+");
			//return Integer.parseInt(splited[0]);
		}
		for(int i = 0; i < splited.length; i ++)
		{
			if(splited[i].equals(word))
			{
				return Integer.parseInt(splited[0]);
			}
		}
		return -1;
	}
}
