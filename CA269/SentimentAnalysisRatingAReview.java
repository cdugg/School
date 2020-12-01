import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.*;

public class Sentiment
{
    public static double sentiment(String review, String rfilename) throws FileNotFoundException
    {
        String [] words = review.split(" ");
        double score = 0;
        double count = 0;
        int num;
        for(String word:words)
        {
            double scores = insentence(word, rfilename);
            if(scores != -1)
            {
                score += scores;
                count ++;
            }
        }
        if(count == 0)
        {
            return -1;
        }
        return score/count;
    }
    public static double insentence(String word, String filen) throws FileNotFoundException
    {
        double totalscore = 0;
        double totalcount = 0;
        String s;
        int num;
        Scanner in = new Scanner(new File(filen));
        while(in.hasNextLine())
        {
            s = in.nextLine();
            num = Integer.parseInt(s.substring(0,1));
            String [] wonder = s.split(" ");
            if(word.equals(".") || word.equals(","))
            {
                if(s.contains(word))
                {
                    totalscore += num;
                    totalcount++;
                }
            }
            else
            {
                for(String full:wonder)
                {
                    if(full.equals(word))
                    {
                        totalscore += num;
                        totalcount++;
                        break;
                    }
                }
            }
        }
        in.close();
        if(totalscore == 0)
        {
            return -1;
        }
        return totalscore / totalcount;
    }
}
