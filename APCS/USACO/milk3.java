/*
 ID: 02isabe1
 TASK: milk3
 LANG: JAVA
 */

//NAME              :       Isabel Holtan
//GROUP             :       APCS
//LAST MODIFIED     :       15 MAY 2017
//PROBLEM ID        :       milk3
//DESCRIPTION       :       Finds a list of all the possible amounts 
//                          of milk that can be in bucket C when bucket
//                          A is empty.
//SOURCES/HELPERS   :       Mr. H., Lewis and Loftus


import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class milk3 
{
    private static int A, B, C;
    private static boolean[] amount = new boolean[21];
    private static boolean[][] done = new boolean[21][21];

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        //Initializing
        StringTokenizer input = new StringTokenizer(in.readLine());
        A = Integer.parseInt(input.nextToken());
        B = Integer.parseInt(input.nextToken());
        C = Integer.parseInt(input.nextToken());
        
        //Call method
        check(0,0,C);
        for (int i = 0;i < C;i++) 
        {
            if (amount[i]) 
            {
                out.print(i + " ");
            }
        }
        out.println(C);
        out.close();
    }

    private static void check(int x, int y, int z)
    {
        //Checks the amount of milk in each bucket to make sure that the milk is dispensed to 
        //each bucket appropriately
        if(done[x][y]) 
        {
            return;
        }
        done[x][y] = true;
        if(x == 0)
        {
            amount[z] = true;
        }
        if (x>0 && y<B)
        {
            check(max(0,x+y-B),min(B,x+y),z);
        }
        if (x>0 && z<C) 
        {
            check(max(0,x+z-C),y,min(C,x+z));
        }
        if (y>0 && x<A) 
        {
            check(min(A,y+x),max(0,y+x-A),z);
        }
        if (y>0 && z<C) 
        {
            check(x,max(0,y+z-C), min(C,y+z));
        }
        if (z>0 && x<A) 
        {
            check(min(A,z+x),y,max(0,z+x-A));
        }
        if (z>0 && y<B) 
        {
            check(x,min(B,z+y),max(0,z+y-B));
        }
    }
}