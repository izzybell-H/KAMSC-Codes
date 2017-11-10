//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   18 September 2016
//PROBLEM ID        :   2.2 and 2.3 Lewis and Loftus
//DESCRIPTION       :   Program that takes takes three numbers and finds the sum, 
//                      average, and product of them
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner;
import java.text.DecimalFormat;

public class IHoltanSumAvgProd
{
    public static void main (String[] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nJava 2.3 and 2.4\n");
        
        //Declares Variables
        double num1, num2, num3, sum, prod, avg, numRuns;
        final double DIVISOR = 3;
        Scanner scan = new Scanner(System.in);
        
        //Prompts user for number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = scan.nextInt();
        
        //Repeats for user determined number of times
        for (int j = 1; j <= numRuns; j++)
        {
            //User inputs three numbers
            System.out.print ("\nInput three numbers:  ");
            num1 = scan.nextDouble();
            num2 = scan.nextDouble();
            num3 = scan.nextDouble();
        
            //Sum, average, and product are calculated from the three numbers
            sum = num1 + num2 + num3;
            avg = sum / DIVISOR;
            prod = num1 * num2 * num3;
            
            DecimalFormat fmt = new DecimalFormat ("0.###");
        
            //The sum, average, and product are output
            System.out.println ("\nThe sum of the three numbers is:  " + fmt.format(sum) + "\nThe average of the three numbers is:  " + fmt.format(avg) + "\nThe product of the three numbers is:  " + fmt.format(prod) + "\n");
        }
    }
}
    