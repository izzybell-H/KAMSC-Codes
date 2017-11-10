//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   17 October 2016
//PROBLEM ID        :   Lewis 3.2 and 3.3 Calender
//DESCRIPTION       :   Determines if the year entered is a leap year
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.*;
import java.text.*;

public class Calender
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 3.2 and 3.3 Calender\n");
        
        //Declares Variables
        int year;
        Scanner scan = new Scanner (System.in);
        final int SENTINAL_VALUE = 0, INVALID_YEAR = 1582;
        
        //Repeats until 0 is the input
        do
        {   
            //Prompts user for the year
            System.out.print("Input the year:  ");
            year = scan.nextInt();
            
            //Ends the program when the sentinal value is the input
            if(year == SENTINAL_VALUE)
            {
                break;
            }
            
            //Determines if the year is valid
            if(year < INVALID_YEAR)
            {
                System.out.println("\nError: This year is from before the Gregorian Calendar was adopted\n\n");
                continue;
            }
            
            //Determines if the year is a leap year and tells the user
            if(year%400 == 0 || (year % 4 == 0 && year% 100 != 0))
            {
                System.out.println("\nThis year is a leap year\n\n");
                
            }
            else
            {
                System.out.println("\nThis is not a leap year\n\n");
            }
        } while(year != SENTINAL_VALUE);
    }
}