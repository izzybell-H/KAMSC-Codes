//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   15 November 2016
//PROBLEM ID        :   Cow Signal
//DESCRIPTION       :   Scales up a signal by a given scale factor
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class cowsignal
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
              
        //Inputs dimentions and scale factor
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        
        //Creates signal arrays
        String [][] origSignal = new String[m][1];
        String [][] newSignal = new String [m][1];
        
        //Initializes array
        for(int j=0; j<m; j++)
        {
            newSignal[j][0] = "";
        }
        
        //Reads in signal
        for(int j=0; j<m; j++)
        {
            origSignal[j][0] = in.next();
        }
        
        //Scales up signal on n axis
        for(int j=0; j<m; j++)
        {
            for(int g=0; g<n; g++)
            {
                for(int h=0; h<k; h++)
                {
                    newSignal[j][0] = newSignal[j][0].concat("" + (origSignal[j][0].charAt(g)));
                }                
            }
        }
         
        //Outputs signal scales up on m axis
        for(int j=0; j<m; j++)
        {
            for(int g=0; g<k; g++)
            {
                out.println(newSignal[j][0]);
            }
        }
     
        //Ensures program ends properly
        out.close();

    }
}
        