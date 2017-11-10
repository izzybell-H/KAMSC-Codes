/*
 PROG: wormhole
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   13 May 2017
//PROBLEM ID        :   Wormhole
//DESCRIPTION       :   Determines how many infinite
//                      wormhole loops there are
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class wormhole
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        final int MAX_N = 12;
        int n;
        int [] x = new int[MAX_N+1];
        int [] y = new int[MAX_N+1];
        int [] pair = new int[MAX_N+1];
        int [] nextOnRight = new int[MAX_N+1];
        
        //Inputs data
        n = in.nextInt();
        for (int i=1; i<=n; i++)
        {
              x[i] = in.nextInt();
              y[i] = in.nextInt();;
        }
      
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (x[j] > x[i] && y[i] == y[j])
                {
                    if (x[j]-x[i] < x[nextOnRight[i]]-x[i] || nextOnRight[i] == 0 )
                    {
                        nextOnRight[i] = j;
                    }
                }
            }
        }
    
        //Calls recursive method and outputs
        out.println(wormhole.solve(nextOnRight, pair, n));
        out.close();
    }

    public static boolean cycle_exists(int[] nextOnRight, int[] pair, int n)
    {
        for (int start=1; start<=n; start++) 
        {
            // does there exist a cylce starting from start
            int pos = start;
            for (int count=0; count<n; count++)
            {
                pos = nextOnRight[pair[pos]];
            }
            if (pos != 0) 
            {
                return true;
            }
        }
        return false;
    }
    
    // count all solutions
    public static int solve(int [] nextOnRight, int [] pair, int n) 
    {
        //Finds any unpaired wormholes
        int i, total=0;
        for (i=1; i<=n; i++) 
        {
            if (pair[i] == 0) 
            {
                break;
            }
        }
        
        //Checks to make sure all are paired
        if (i > n)
        {
            if (wormhole.cycle_exists(nextOnRight, pair, n))
            {
                return 1;
            }
            else 
            {
                return 0;
            }
        }
        
        //Trys pairing i with all possible other j wormholes, uses recursion
        for (int j=i+1; j<=n; j++)
        {
            if (pair[j] == 0)
            {
              pair[i] = j;
              pair[j] = i;
              total += wormhole.solve(nextOnRight, pair, n);
              pair[i] = pair[j] = 0;
            }
        }
        return total;
    }      
}

         