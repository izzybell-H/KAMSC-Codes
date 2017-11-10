// NAME             :   Isabel Holtan
// GROUP            :   APCS
// LAST MODIFIED    :   10 March 2017
// PROBLEM ID       :   Bubble Sort
// DESCRIPTION      :   Sorts a string of numbers using an efficient bubble sort                
// SOURCES/HELPERS  :   Mr. H, Java Software Solutions

import java.util.*;
import java.text.*;
import java.lang.*;

public class bubbleSort2
{
    public static void main (String[] args)
    {
        System.out.println ("Isabel Holtan\nAPCS\nBubble Sort\n\n");

        Scanner input = new Scanner (System.in);

        System.out.print("Input number of runs: ");
        int numRuns = input.nextInt();

        for (int o=0; o<numRuns; o++)
        {
            final int NUMS = 7;
            int[] numbers = new int[NUMS];
            int[] sorted = new int[NUMS];

            System.out.print("\n\nInput the numbers to be sorted ");
            for (int k=0; k<NUMS; k++)
            {
                numbers[k] = input.nextInt();
                sorted[k] = numbers[k];
            }

            Arrays.sort(sorted);
            System.out.println("");

            System.out.print("The unsorted array is: ");
            for (int i=0; i<NUMS; i++)
            {
                System.out.print (numbers[i] + " ");
            }

            System.out.println();

            boolean equal = false;
            int compares=0, pass=0, swaps=0;

            for (int j=0; j<NUMS; j++)
            {
                for (int i=0; i<NUMS-1-j; i++)
                {
                    compares++;

                    if (numbers[i] > numbers[i+1])
                    {
                        swaps++;
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }

                    if (deepEquals(numbers, sorted))
                    {
                        equal = true;
                    }
                }
                pass++;
                if(equal)
                {
                    break;
                }
            }

            System.out.print("The sorted array is: ");
            for (int i=0; i<NUMS; i++)
            {
                System.out.print (numbers[i] + " ");
            }
            System.out.println();

            System.out.println("The number of compares: " + compares);
            System.out.println("The number of passes: " + pass);
            System.out.println("The number of swaps: " + swaps);
        }
    }

    //Determines if  the array is completely sorted
    public static boolean deepEquals(int[] array, int[] sorted) 
    {
        boolean equal = true;
        for (int i=0; i<array.length; i++)
        {
            if (array[i]!=sorted[i])
            {
                equal = false;
                break;
            }
        }
        return (equal);

    }
}
