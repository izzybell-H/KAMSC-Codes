//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   12 January 2017 
//PROBLEM ID        :   Pair Up
//DESCRIPTION       :   Pairs cows up in a way that maximizes cow milking
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class pairup
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        
        int n = in.nextInt();
        int[][] cow = new int [n][2];
        
        for(int j=0; j<n; j++)
        {
            for(int k = 0; k< 2; k++)
            {
                cow[j][k] = in.nextInt();
            }        
        }
        int sum = 0;
        for(int j=0; j<n; j++)
        {
            sum += cow [j][0];
        }
        
        int[] milk = new int[sum];
        int location = 0;
        
        System.out.print("Milk aray; ");
        for(int j=0; j<n; j++)
        {
            for(int k=0; k< cow[j][0]; k++)
            {
                milk[location] = cow[j][1];
                System.out.print(milk[location] + " ");
                location++;               
            }
        }
        
        Arrays.sort(milk);
        int added =0;
        int biggest = 0;
        
        for(int j=0; j< sum/2; j++)
        {
            added = milk[j] + milk[milk.length - j - 1];
            if(added > biggest)
            {
                biggest = added;
            }
        }       
        
        out.print(biggest);
        

        out.close();
    }
}