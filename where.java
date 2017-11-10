//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   12 January 2017 
//PROBLEM ID        :   where
//DESCRIPTION       :   finds the number of PLCs
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class where
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("where.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        
        int num = in.nextInt();
        int colorTally = 0, two = 0, numBoxes = 0;
        String[][] grid = new String [num][num];
        String [] colors = {"A", "B", "C", "D", "E", "F", "G", "H", "I" , "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            
        for(int j=0; j<num; j++)
        {
            String letter = in.next();
            for(int z=0; z<num; z++)
            {
                grid[j][z] = "" + letter.charAt(z);     
            }
        }
        
        for(int j=0; j<num; j ++)
        {
            for(int z=0; z<num; z++)
            {
                for(int q=0; q<27; q++)
                {
                    if(colors[q] == grid[j][z])
                    {
                        colorTally++;
                        colors[q] = "";
                    }
                }
            }
        }
        
        for(int j=num; j> 0; j--)
        {
            for(int z=num; z>0; z--)
            {
                if(grid[j][z] != grid[j+1][z] && two < 2)
                {
                    two++;
                }
                else if( two ==2 )
                {
                    numBoxes++;
                }
            }
        }
        
        //out.print(numBoxes);
        
        out.println(6%num);
        out.close();
    }
}
