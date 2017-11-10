/*
 PROG: friday
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   17 October 2016
//PROBLEM ID        :   Friday the Thirteenth
//DESCRIPTION       :   Determines if the year entered is a leap year
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class friday
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        RandomAccessFile in = new RandomAccessFile ("README.txt","r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

       //Initializing arrays and variables        
       int[] dayOfWeek = {0,0,0,0,0,0,0};
       int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31,  30, 31 };
       int daysNum = 0, yearsNum;
       final int DAY_MOD=7, LEAP_YR_LENGTH=29, FEB_LENGTH=28, STARTING_YEAR=1900, CENTURY_MOD=400, LEAP_MOD=4, NOT_CENTURY_MOD=100, WEEK_LENGTH=7;

       //Reads in number of years
       yearsNum = in.readInt();
	
       // Loops for number of years
       for (int j=STARTING_YEAR; j<=STARTING_YEAR+yearsNum-1; j++)
       {
            //If a leap year
            if (j % CENTURY_MOD == 0 || j % LEAP_MOD == 0 && j % NOT_CENTURY_MOD != 0)
        	{
        	    //Set February length to 29 days
        	    monthDays[1]=LEAP_YR_LENGTH;
        	}
        	//If not a leap year
        	else
        	{
        	    //Keep the length of January at 28 days
        	    monthDays[1]=FEB_LENGTH;
        	   }

        	//Incrementing months
        	for (int i=0; i<12; i++)
        	{
        	    //Adds one to 13th counter
        	    dayOfWeek[daysNum%DAY_MOD]++;

        	    //Finds next 13th by adding length of the month to previous month lengths
        	    daysNum+=monthDays[i];
        	}
       }

       //Repeats for all the days of a week
       for (int j=0; j<WEEK_LENGTH; j++)
        {
            
            //If Sunday through Friday
            if (j<6)
            {
                //Outputs number of times the 13th fell on Sunday through Friday
                System.out.print(dayOfWeek[j] + " ");
    		}
    		//If Saturday
    		else
    		{
    		    //Outputs number of time the 13th fell on Saturday
    		    System.out.println(dayOfWeek[j]);
    		}
    
    	}					
    	
       //Ensures program ends properly
       out.close();
    }
}
        