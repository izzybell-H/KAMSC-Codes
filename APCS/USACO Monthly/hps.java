//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   14 January 2017 
//PROBLEM ID        :   HPS
//DESCRIPTION       :   Determines the most games a cow could win
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class hps
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        
        int firstWayWin=0, secondWayWin=0, thirdWayWin=0;
        
        int numGames = in.nextInt();
        
        for(int j= 0; j< numGames; j++)
        {
            int cow1 = in.nextInt();
            int cow2 = in.nextInt();

            if((cow1 == (1) && cow2==(3)) || (cow1==(2) && cow2==(1)) || (cow1==(3) && cow2==(2)))
            {
                firstWayWin++;
                
            }
            if((cow1==(2) && cow2==(1)) || (cow1==(3) && cow2==(2)) || (cow1==(1) && cow2==(3)))
            {
                secondWayWin++;
                
            }
            if((cow1==(3) && cow2==(1)) || (cow1==(1) && cow2==(2)) || (cow1==(2) && cow2==(3)))
            {
                thirdWayWin++;
                
            }
        }
        
        if(firstWayWin > secondWayWin || firstWayWin > thirdWayWin)
        {
            out.println(firstWayWin);
        }
        else if(secondWayWin > firstWayWin || secondWayWin > thirdWayWin)
        {
            out.println(secondWayWin);
        }
        else if(thirdWayWin > firstWayWin || thirdWayWin > secondWayWin)
        {
            out.println(thirdWayWin);
        }
        
        //Ensures program ends properly
       out.close();
    }  
}
