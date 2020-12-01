import java.util.Scanner;

public class Hangman
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        // First get the word
        int wordSeed = in.nextInt();

        String word = Word.getWord(wordSeed);
        
        System.out.println("The word is");
        String line = "";
        for(int i=0;i<word.length();i++)
        {
            line=line+"_";
        }
        Boolean cont= new Boolean(true);
        String guess= "";
            System.out.println(line);
        
        while(cont)
            {
            System.out.println("Guess a letter:");
            String newguess = in.next();
            guess=guess+newguess;
            String answer= Word.showLetters(word, guess);
            System.out.println(answer);
            if(answer.equals(word))
                {
                    cont= false;
                    System.out.println("Well Done, the word was "+word+".");
                }
                
		    }
		
    }
    
}

        // Now you have the word ... encourage the user to guess.
