//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   17 October 2016
//PROBLEM ID        :   Lewis 2.13 Random Phone
//DESCRIPTION       :   Generates 10 phone numbers
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.*;
import java.text.*;

public class RandomPhone
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 2.13 Random Phone\n\n");
        
        //Declares Variables
        Random generator = new Random();
        int num1, num2, num3, num4, num5;
        
        
        //Repeats for ten times
        for(int j=0; j<10; j++)
        {
            //Generates the phone number
            num1 = generator.nextInt(8);
            num2 = generator.nextInt(8);
            num3 = generator.nextInt(8);
            num4 = generator.nextInt(643) + 100;
            num5 = generator.nextInt(9000) + 1000;
            
            //Outputs the phone numbers
            System.out.println("" + num1 + num2 + num3 + "-" + num4 + "-" + num5);            
        }
    }
}