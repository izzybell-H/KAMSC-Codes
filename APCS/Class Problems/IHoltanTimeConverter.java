//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   20 September 2016
//PROBLEM ID        :   2.6 and 2.7 Lewis and Loftus
//DESCRIPTION       :   Program that takes can either convert hours, minutes, and seconds 
//                      into the total number of seconds or convert a total number of seconds
//                      into hours, minutes and seconds.
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner;
import java.text.DecimalFormat;

public class IHoltanTimeConverter
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nJava 2.6 and 2.7\n");
        
        //Declares variables
        int numRuns=0, userChoice=0, secondsInput ;
        final int HOUR_SEC = 3600, MIN_SEC = 60, USER_INPUT=1;
        Scanner scan = new Scanner (System.in);
        
        //Declares decimal format
        DecimalFormat fmt = new DecimalFormat ("00");
        
        //Prompts user for the number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = scan.nextInt();
        
        //Repeats for a user determined number of times
        for ( int j = 1; j <= numRuns; j++)
        {
            //Prompts user for type of input
            System.out.print ("\nPlease indicate 1) To convert from hours, minutes, and seconds to a total seconds or 2) To convert a total\nseconds into hours, minutes, and seconds: ");
            userChoice = scan.nextInt();
            
            //
            if( userChoice == USER_INPUT)
            {
                int secondsA = 0, minA=0, hourA=0, seconds=0; 
                //Sets delimiter for string
                scan.useDelimiter(" |:|\n");
                
                //Prompts user for the hours, minutes, and seconds
                System.out.print ("\nInput hours, minutes, and seconds:  ");
                hourA = scan.nextInt();
                minA = scan.nextInt();
                secondsA = scan.nextInt();

                //Computes number of seconds in time given
                seconds += hourA * HOUR_SEC + minA * MIN_SEC + secondsA;
                
                //Outputs the time in seconds
                System.out.println ("\nThe total number of seconds is " + seconds + "\n");

            }
            else
            {          
                int hourB = 0, minB = 0, secondsB = 0;
                //Prompts user for the number of seconds
                System.out.print ("\nInput total number of seconds:  ");
                secondsInput = scan.nextInt();
                
                //Calcutlates number of hours, minutes, and seconds in given time
                hourB += secondsInput / HOUR_SEC;
                minB += secondsInput % HOUR_SEC / MIN_SEC;
                secondsB += secondsInput % HOUR_SEC % MIN_SEC;
                
                //Outputs calculated time
                System.out.println ("\nThe number of hours, minutes, and seconds in " + secondsInput + " seconds is " + fmt.format(hourB) + ":" + fmt.format(minB) + ":" + fmt.format(secondsB) + "\n");               
                
            }
        }
    }
}
        
        
        
        