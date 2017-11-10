/*
ID: 02isabe1
LANG: JAVA
TASK: milk
 */

// NAME             :   Isabel Holtan
// GROUP            :   APCS
// LAST MODIFIED    :   January 1, 2017
// PROBLEM ID       :   Mixing Milk
// DESCRIPTION      :   Calculates the minimum amount of 
//                  :   money to spend on milk
// SOURCES/HELPERS  :   Mr. H, Lewis

import java.util.*;
import java.io.*;

public class milk
{
    public static void main(String[] args)throws IOException
    {
        //Opens files for input and output
        Scanner scan=new Scanner(new File("milk.in"));
        PrintWriter out=new PrintWriter (new File("milk.out"));
        
        //Inputs required milk and number of farmers
        int milkNeed = scan.nextInt();
        int numFarmers = scan.nextInt();
        
        //Declares variables
        int[] cost = new int[numFarmers];
        int holder1 = 0, holder2 = 0, total = 0;
        int[] numUnits = new int[numFarmers];
        
        //Inputs the farmers information
        for (int j=0; j<numFarmers; j++)
        {
            cost[j]=scan.nextInt();
            numUnits[j]=scan.nextInt();
        }

        //Calculates costs 
        for (int j=0; j<numFarmers-1; ++j) 
        {
            for (int k=0; k<numFarmers-1; ++k) 
            {
                if (cost[k]>cost[k+1]) 
                 {
                    holder1=numUnits[k];
                    numUnits[k]=numUnits[k+1];
                    numUnits[k+1]=holder1;  
                    
                    holder2=cost[k];
                    cost[k]=cost[k+1];
                    cost[k+1]=holder2;              
                }
            }
        }

        //Cycles through farmers
        for (int j=0; j<numFarmers; j++)
        {
            int count=numUnits[j];
            while (count!=0 && milkNeed!=0)
            {
                milkNeed--;
                count--;
                total+=cost[j];
            }
        }     
        
        //Outputs total
        out.println(total);
        
        //Ensures program ends properly
        out.close();
    }
}
