//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   29 September 2016
//PROBLEM ID        :   Lewis 2.8 Distance
//DESCRIPTION       :   Calculates the distance between two
//                  :   Points using the distancSe formula
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner;
import java.text.DecimalFormat;

public class IHoltanDistance
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 2.8 Distance\n");
        
        //Declares Variables
        int numRuns;
        double x1, y1, x2, y2, distance;
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
            
            //Promts user for the two points
            System.out.print("\nPlease input the two points in (x,y) format:  ");
            x1 = scan.nextDouble();  
            y1 = scan.nextDouble();
            x2 = scan.nextDouble();
            y2 = scan.nextDouble();            
            
            //Calculates the distance between the two points
            distance = Math.sqrt (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            
            //Outputs the distance betwee the two points
            System.out.print("\nThe distance between is " + fmt.format(distance) + "\n\n");            
        }
        
    }
}
