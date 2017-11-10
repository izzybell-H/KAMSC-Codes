//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   12 February 2017
//PROBLEM ID        :   Cow Queue
//DESCRIPTION       :   Determines tie for cows to get through wall
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class cowqueue
{
    public static void main (String[] args) throws IOException
    {
       //Opening files for input and output
       Scanner in = new Scanner (new File("cowqueue.in"));
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
       
       int num = in.nextInt();
       int [][] time = new int [num][2];
       int element=0, min = 0, startTime =0, endTime=0;
       boolean first = true;
       
       //Inputs cow times
       for(int j=0; j<num; j++)
       {
           for(int k=0; k<2; k++)
           {
               time[j][k] = in.nextInt();
           }
       }
       
       //Calculates cow times
       for(int j=0; j<num; j++)
       {
           //Finds next cow in line
           element = 0;
           min = time[0][0];
           for (int i = 0; i < num; i++)
           {
               if (time[i][0] < min)
               {
                   min = time[i][0];
                   element = i;
               }
           }
           
           //Calculates times
           if(first)
           {
               endTime = time[element][0] + time[element][1];
               first = false;
               time[element][0] = 1000001;
           }
           else
           {
               if(time[element][0]  > endTime)
               {
                   endTime = time[element][0] + time[element][1];
                   time[element][0] = 1000001;
               }
               else if (time[element][0]  < endTime)
               {
                   endTime += time[element][1];
                   time[element][0] = 1000001;  
               }
               else if (time[element][0] == endTime)
               {
                   endTime += time[element][1];
                   time[element][0] = 1000001;
               }
           }
       }
       
       out.println(endTime);
       out.close();
    }
}