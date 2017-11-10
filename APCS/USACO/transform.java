/*
 ID: 02isabe1
 PROG: transform
 LANG: JAVA
 */
//  NAME                :       Isabel Holtan
//  GROUP               :       APCS
//  LAST MODIFIED       :       13 January 2017
//  PROBLEM ID          :       USACO Transformation
//  DESCRIPTION         :       Determines what transformation 
//                      :       has been done to a given image
//  SOURCES/HELPERS     :       USACO, Mr. H

import java.util.*;
import java.io.*;

public class transform
{
    public static void main(String[] args) throws IOException
    {
        // Opens files for input and output
        Scanner scan = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));
    
        int dimensions = scan.nextInt();

        //Inputs original  image
        char[][] origImage = new char[dimensions][dimensions];
        for(int i=0; i<dimensions; i++) 
        {
            String symbol = scan.next();
            for(int j=0; j<origImage[i].length; j++) 
            {
                origImage[i][j] = symbol.charAt(j);
            }
        }

        //Inputs transformed image
        char[][] newImage = new char[dimensions][dimensions];
        for(int i=0; i<newImage.length; i++) 
        {
            String symbol = scan.next();
            for(int j=0; j<newImage[i].length; j++) 
            {
                newImage[i][j] = symbol.charAt(j);
            }
        }
        
        //90 degree rotation
        char[][] trans1 = new char[dimensions][dimensions];
        for(int i=0; i<dimensions; i++) 
        {
            for(int j=0; j<dimensions; j++) 
            {
                trans1[j][dimensions-i-1] = origImage[i][j];
            }
        }
        
        //180 degree rotation
        char[][] trans2 = new char[dimensions][dimensions];
        
        for(int i=0; i<dimensions; i++) 
        {
            for(int j=0; j<dimensions; j++) 
            {
                trans2[j][dimensions-i-1] = trans1[i][j];
            }
        }
        
        //270 degree rotation
        char[][] trans3 = new char[dimensions][dimensions];
        for (int k=1; k<=3; k++)
        {
             for(int i=0; i<dimensions; i++) 
            {
                for(int j=0; j<dimensions; j++) 
                {
                    trans3[j][dimensions-i-1] = trans2[i][j];
                }
            }
        }
        
        //Reflection
        char[][] trans4 = new char[dimensions][dimensions];
        for(int i=0; i<dimensions; i++) 
        {
            for(int j=0; j<dimensions; j++) 
            {
                trans4[i][j] = origImage[i][dimensions-j-1];
            }
        }
        
        //Combination 1
        char[][] Trans15 = new char[dimensions][dimensions];
        for(int i=0; i<dimensions; i++) 
        {
            for(int j=0; j<dimensions; j++) 
            {
                Trans15[j][dimensions-i-1] = trans4[i][j];
            }
        }
        
        //Combination 2
        char[][] Trans25 = new char[dimensions][dimensions];
        for (int k=1; k<=2; k++)
        {
             for(int i=0; i<dimensions; i++) 
            {
                for(int j=0; j<dimensions; j++) 
                {
                    Trans25[j][dimensions-i-1] = Trans15[i][j];
                }
            }
        }
        
        //Combination 3
        char[][] Trans35 = new char[dimensions][dimensions];
        for (int k=1; k<=3; k++)
        {
             for(int i=0; i<dimensions; i++) 
            {
                for(int j=0; j<dimensions; j++) 
                {
                    Trans35[j][dimensions-i-1] = Trans25[i][j];
                }
            }
        }
        
        //Prints the transformation number
        if (Arrays.deepEquals(trans1, newImage)) 
        {
            out.println("1");
        } else if (Arrays.deepEquals(trans2, newImage)) 
        {
            out.println("2");
        } else if (Arrays.deepEquals(trans3, newImage)) 
        {
            out.println("3");
        } else if (Arrays.deepEquals(trans4, newImage)) 
        {
            out.println("4");
        } else if ((Arrays.deepEquals(Trans15, newImage)) ||
                  (Arrays.deepEquals(Trans25, newImage)) ||
                  (Arrays.deepEquals(Trans35, newImage))) 
        {
            out.println("5");
        }
        else if (Arrays.deepEquals(origImage, newImage))
        {
            out.println("6");
        } else 
        {
            out.println("7");
        }
        
        //Closes program correctly
        out.close();
    }
}
