//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   14 January 2017
//PROBLEM ID        :   Don't Be Last
//DESCRIPTION       :   Determines the cow that makes
//                  :   The second to last amount of milk
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class notlast
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("notlast.in"));
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
              
        //Inputs dimentions and scale factor
        final int NUM_COWS=7;
        
        int numEntries = in.nextInt();
        
        String[] cowNames = {"Annabelle", "Elsie", "Bessie", "Gertie", "Daisy", "Maggie", "Henrietta"};
        int[] milkAmount = {0,0,0,0,0,0,0};
        int lowest =0, tie =0;
        String outputCow = "";
        boolean check = true;
        
        //Inputs the cows and their milk totals
        for(int j=0; j < numEntries; j++)
        {
            String cow = in.next();
            for(int k=0; k < NUM_COWS; k++)
            {
                if(cowNames[k].equals(cow))
                {
                    milkAmount[k] += in.nextInt();
                }
            }
        }

        int[] milkAmountSorted = milkAmount.clone();  
        Arrays.sort(milkAmountSorted);
        
        for(int k=0; k < NUM_COWS; k++)
        {
            if(k == 6)
            {
                out.println("Tie");
                check = false;
                break;
            }
            if(milkAmountSorted[k+1] > milkAmountSorted[k] && milkAmountSorted[k+1] < milkAmountSorted[k+2])
            {
                lowest = milkAmountSorted[k+1]; 
                break;
            }
        }
        
        for(int k=0; k < NUM_COWS; k++)
        {
            if(lowest == milkAmount[k])
            {
                tie++;
                outputCow = cowNames[k];
            }
        }
        
        if(tie > 1 && check)
        {
            out.println("Tie");
        }
        else if (check)
        {
            out.println(outputCow);
        }  
             
        //Ensures program ends properly
       out.close();
    }
}