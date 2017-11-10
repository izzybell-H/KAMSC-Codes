// NAME             :   Isabel Holtan
// GROUP            :   APCS
// LAST MODIFIED    :   4 June 2017
// PROBLEM ID       :   Grade Calculator
// DESCRIPTION      :   Takes in a students scores and calulates their final grades            
// SOURCES/HELPERS  :   Mr. H, Lewis and Loftus

import javax.swing.JOptionPane;
import java.util.*;
import java.lang.*;
import java.text.*;
public class GradeCalc
{
    //Declares instance variables
    private static String name, quartScore, hwPt, prgmPt, testPt, examPt, letterGrade;
    private static double hwPts, prgmPts, testPts, examPts, quarterAvgFirst, hwAvg, prgmAvg, testAvg, examAvg, qrtAvg, semAvg, repeat;
    private static final double HW_TOTAL = 176, PRGM_TOTAL = 70, TEST_TOTAL = 199, EXAM_TOTAL = 131, AVG = 3;
    private static DecimalFormat percent = new DecimalFormat ("###.0");
    public static void main (String[] args)
    {
        //Repeates until user indicates not to
        do 
        {
            //Has user input information in string form in a  input box
            name = JOptionPane.showInputDialog ("Enter Your Name: ");
            quartScore = JOptionPane.showInputDialog ("Enter Your Average for First Quarter: ");
            hwPt = JOptionPane.showInputDialog ("Enter Your Homework Point with Extra Credit: ");
            prgmPt = JOptionPane.showInputDialog ("Enter Your Program Point with Extra Credit: ");
            testPt = JOptionPane.showInputDialog ("Enter Your Test Point with Extra Credit: ");
            examPt = JOptionPane.showInputDialog ("Enter Your Exam Score: ");

            //Converts string data into doubles
            quarterAvgFirst = Double.parseDouble(quartScore);
            hwPts = Double.parseDouble(hwPt);
            prgmPts = Double.parseDouble(prgmPt);
            testPts = Double.parseDouble(testPt);
            examPts = Double.parseDouble(examPt);

            //Calculates percentages in each catagory
            hwAvg = (hwPts / HW_TOTAL)*100;
            prgmAvg = (prgmPts / PRGM_TOTAL)*100;
            testAvg = (testPts / TEST_TOTAL)*100;
            examAvg = (examPts / EXAM_TOTAL)*100;
            qrtAvg = (hwAvg +prgmAvg + testAvg) / AVG;

            //Outputs the score averages in a dialoge box
            JOptionPane.showMessageDialog (null, name + "\nHomework Percentage: " + percent.format(hwAvg) + "%\nProgram Average: " + percent.format(prgmAvg) + "%\nTest Average: " + percent.format(testAvg) + "%\nQuarter Average: " + percent.format(qrtAvg) + "%");

            //Calculates the total semester score and letter grade
            semAvg = (qrtAvg * .4) + (quarterAvgFirst *.4) + (examAvg  *.2);
            if (semAvg >= 96)
            {
                letterGrade = ("A+");
            }
            else if (semAvg >= 92)
            {
                letterGrade = ("A");
            }
            else if (semAvg >= 90)
            {
                letterGrade = ("A-");
            }
            else if (semAvg >= 86)
            {
                letterGrade = ("B+");
            }
            else if (semAvg >= 82)
            {
                letterGrade = ("B");
            }
            else if (semAvg >= 80)
            {
                letterGrade = ("B-");
            }
            else if (semAvg >= 76)
            {
                letterGrade = ("C+");
            }
            else if (semAvg >= 72)
            {
                letterGrade = ("C");
            }
            else if (semAvg >= 70)
            {
                letterGrade = ("C-");
            }
            else if (semAvg >= 66)
            {
                letterGrade = ("D+");
            }
            else if (semAvg >= 62)
            {
                letterGrade = ("D");
            }
            else if (semAvg >= 60)
            {
                letterGrade = ("D-");
            }
            else
            {
                letterGrade = ("F");
            }

            //Outputs in a dialogue box, information about final scores
            JOptionPane.showMessageDialog (null, name + "\nFinal Exam Average: " + percent.format(examAvg) + "%\nSemester Average: " + percent.format(semAvg) + "%\nLetter Grade: " + letterGrade);

            //Asks the user if they would like to do another student with a yes or no box
            repeat = JOptionPane.showConfirmDialog (null, "Would you like to repeat?");
        }
        while (repeat == JOptionPane.YES_OPTION);
    }
}
