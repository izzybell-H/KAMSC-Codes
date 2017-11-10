/*
 PROG: gift1
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   15 November 2016
//PROBLEM ID        :   Greedy Gift Givers
//DESCRIPTION       :   A group of friends are giving gifts. They
//                      give a way an amount evenly to the number of
//                      recievers
//                      and the remainder goes into their account.
//                      They also recieve an amount
//                      from the other givers,and they with to know
//                      their finished bank account balance
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class gift1
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        //Inputs group
        int groupSize = in.nextInt();
        
        //Declares variables
        int [] bankAcount = new int[groupSize];
        String [] names = new String[groupSize];
        
   
        for(int j=0; j<groupSize; j++)
        {
            names[j] = in.next();
            bankAcount[j] = 0;
        }
        
        for(int m=0; m<groupSize; m++)
        {
            String giver = in.next();
            int giveAway = in.nextInt();
            int numRecievers = in.nextInt();
            
            if(numRecievers == 0)
            {
                continue;
            }
            
            for(int k=0; k<groupSize; k++)
            {
                if(giver.equals(names[k]))
                {
                    bankAcount[k]-= giveAway;
                    bankAcount[k] += (giveAway%numRecievers);
                }                
            }
            for(int n=0; n<numRecievers; n++)
            {
                String reciever = in.next();
                for(int l=0; l<groupSize; l++)
                {
                    if(reciever.equals(names[l]))
                    {
                        bankAcount[l] += (giveAway/numRecievers);
                    }
                }
            }
        }
        
        for(int d=0; d<groupSize; d++)
        {
            out.println("" + names[d] + " " + bankAcount[d]);
        }
        
        //Ensures program ends properly
        out.close();
    }
}
        
        
        
