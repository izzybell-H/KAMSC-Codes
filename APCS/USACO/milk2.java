/*
PROG: milk2
ID: 02isabe1
LANG: JAVA
 */

// NAME             :   Isabel Holtan
// GROUP            :   APCS
// LAST MODIFIED    :   13 January 2017
// PROBLEM ID       :   Milk2
// DESCRIPTION      :   Calcultes when cows are milked and when they are not
// SOURCES/HELPERS  :   USACO website, Mr. H, Lewis text, Java API, 

import java.io.*;
import java.util.*;
import java.lang.*;

public class milk2
{
    public static void main (String[] args) throws IOException
    {
        //Opens up file readers
        Scanner scan = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("milk2.out")));
        
        //Inputs the number of farmers
        int numFarm = scan.nextInt();
        int[] count = new int[1000001];
        int startTime = 1000000;
        int finishTime = 0;
        String s="";
        
        //loops through each farmer
        for (int m = 0; m < numFarm; m++) 
        {
            s = scan.nextLine();
            
            //Inputs start and finish numbers
            int start = scan.nextInt();
            int finish = scan.nextInt();
            
            //Calculates the start and finish times
            startTime = Math.min(start, startTime);
            finishTime = Math.max(finish, finishTime);
            
            for (int j = start; j < finish; j++)
            {
                count[j]++;
            }
        }
       
        
        // initializes times and temp variables to 0
        int time1 = 0;
        int time2 = 0;
        int temp1 = 0;
        int temp2 = 0;
        
        for (int m = startTime; m < finishTime; m++) 
        {
            if (count[m] > 0) {
                temp1++;
                temp2 = 0;
            }
            else {
                temp2++;
                temp1 = 0;
            }

            //Sets times to max values
            time1 = Math.max(time1, temp1);
            time2 = Math.max(time2, temp2);
        }
        
        //Outputs results
        out.write("" + time1 + " " + time2 + "\n");
        
        //Exits program
        out.close();
    }
}
