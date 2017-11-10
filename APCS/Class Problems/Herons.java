//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   30 September 2016
//PROBLEM ID        :   Lewis 2.10 Heron's Formula
//DESCRIPTION       :   Calculates the distance between two
//                  :   Points using the distancSe formula
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class Herons
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 2.10 Heron's Formula\n");
        
        //Declares Variables
        int numRuns;
        double s1, s2, s3, halfPerim, area, diff1, diff2, diff3;
        final double HALF=2;
        Scanner scan = new Scanner (System.in);
        
        //Declares decimal format
        DecimalFormat fmt = new DecimalFormat ("0.000");
        
        //Prompts user for the number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = scan.nextInt();
        
        for (int j=1; j<= numRuns; j++)
        {            
            //Sets delimiters for string
            scan.useDelimiter("[\\p{javaWhitespace}(),]+");
            
            //Promts user for triangle side lengths
            System.out.print("\nPlease input the three sides in (s1,s2,s3) format:  ");
            s1 = scan.nextDouble();  
            s2 = scan.nextDouble();
            s3 = scan.nextDouble();          
            
            //Calculates the distance area fo the triangle
            halfPerim = (s1+s2+s3)/HALF;
            diff1 = halfPerim-s1;
            diff2 = halfPerim-s2;
            diff3 = halfPerim-s3;
            area = Math.sqrt(halfPerim*diff1*diff2*diff3);
            
            //Outputs the area of the triangle
            System.out.print("\nThe area of the triangle is " + fmt.format(area) + "\n\n");            
        }
        
    }
}
