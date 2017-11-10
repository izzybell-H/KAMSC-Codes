//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   13 December 2016
//PROBLEM ID        :   Triangle Coordinate Program 4
//DESCRIPTION       :   Finds the lenght of the x-axis that
//                  :   Intersects two sides of a triangle
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class Program4Triangle
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("PROGRAM4.dat"));
        
        //Signture
        System.out.println ("Isabel Holtan and Shelby Martel\nAPSC\nComCon Program 4\n");
        
        for(int m=0; m<5; m++)
        {
            //Declares variabels
            int [][] points = new int [2][3];
            int x1 = 1000, x2 = 1000, x3 = 1000;
        
            for(int k = 0; k<3; k++)
            {
                points [0][k] = in.nextInt();
                points [1][k] = in.nextInt();
            }
             
            //Calculates x-intercept
            if (points[1][1]-points[1][0] != 0)
			{
				x1 = (int)(points[0][0] - (((double)(points[0][1]-points[0][0]))/((double)(points[1][1]-points[1][0])))*(double)points[1][0]);
			}
			if (points[1][2]-points[1][1] != 0)
			{
				x2 = (int)(points[0][1] - (((double)(points[0][2]-points[0][1]))/((double)(points[1][2]-points[1][1])))*(double)points[1][1]);
			}
			if (points[1][0]-points[1][2] != 0)
			{
				x3 = (int)(points[0][2] - (((double)(points[0][0]-points[0][2]))/((double)(points[1][0]-points[1][2])))*points[1][2]);
			}
			
			int [] finalX = new int [2];
			int smallestY = points [1][0];
			
			for(int k=0; k<3; k++)
			{
			    if(points[1][k] < smallestY)
			    {
			        smallestY = points[1][k];
			    }
			}
			
			if (x1 != 100000 && x2 != 100000 && x3 != 100000)
			{
				int biggest = points[0][0];
				for (int j=0; j<3; j++)
				{
					if (biggest < points [0][j])
					{
						biggest = points[0][j];
					}
				}
				
				int smallest = points[0][0];
				for (int j=0; j<3; j++)
				{
					if (smallest > points [0][j])
					{
						smallest = points[0][j];
					}
				}
								
				int counter = 0;
				
				//System.out.println ("" + x1 +  " " + x2 + " " + x3);
				
				if (x1 <= biggest &&  x1>=smallest)
				{
					//System.out.println("PRINT");
					finalX[counter] = x1;
					counter++;
				}
				
				if (x2 <= biggest && x2 >= smallest)
				{
					finalX[counter] = x2;
					counter++;
				}
				
				if (x3 <= biggest && x3 >= smallest)
				{
					finalX[counter] = x3;
					counter++;
				}
				
				//System.out.println ("" + finalX[0] + " " + finalX[1]);
			}
			
			else
			{
				if ( x1 == 100000)
				{
					finalX[0] = x2;
					finalX[1]= x3;
				}
				else if (x2 == 100000)
				{
					finalX[0] = x1;
					finalX[1]= x3;
				}
				else if (x3 == 100000)
				{
					finalX[0] = x1;
					finalX[1]= x2;
				}
			}
			
			if (smallestY >= 0)
			{
				finalX[0] = 0;
				finalX[1] = 0;
			}
			
			System.out.println ("" + (Math.abs(finalX[0] - finalX[1])));
			
			
        }   
    }
}