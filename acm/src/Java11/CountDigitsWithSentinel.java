package Java11;

// This is a template for the partial program you should write and test
// before writing the whole complete program. Delete this comment from
// your program.

//**********************************************************************
// Class: CSCI1301-Section OL-1, Term: FA-20
// Programmer: Khalfani Bozeman
// Problem Description:
//   Counts the number of odd, even, and zero digits in an integer value
//**********************************************************************

import java.util.Scanner;

public class CountDigitsWithSentinel {
    //-----------------------------------------------------------------
    //  Counts the number of odd, even, and zero digits in an integer
    //  input value. Repeat as long as the user wishes to continue
    //-----------------------------------------------------------------
    public static void main(String[] args) {
        // Declare the identifiers
        final String SENTINEL = "-99";

        Scanner scan = new Scanner(System.in);

        // Display the programmer's information
        System.out.println("Class: CSCI1301-Section OL-1, Term: FA-20");
        System.out.println("Programmer: Khalfani Bozeman");
        System.out.print("Problem Description:");
        System.out.println("Counts the number of odd, even, and zero digits in an integer value");


        while(true) {

            // Declare the remaining identifiers ...
            String userInput;
            int zeroDigit = 0;
            int evenDigit = 0;
            int oddDigit = 0;

            // Input an integer number
            System.out.println("Enter an integer value: ");

            userInput = scan.next();
            if (userInput.equals(SENTINEL)) {
                System.out.println("\nHave a nice day!");
                break;
            }

            for (int i = 0; i < userInput.length(); i++) {
                char c = userInput.charAt(i);
                if (c != '-') {
                    int digit = c - '0';
                    if (digit == 0) {
                        ++zeroDigit;
                    } else if (digit % 2 == 0) {
                        ++evenDigit;
                    } else {
                        ++oddDigit;
                    }
                }
            }

            System.out.println("The number " + userInput + " contains");


        /*int zeroDigitCount = 0;
        char finder;
        int userInput2;

        zeroDigit = userInput.indexOf("0");
        userInput2 = userInput.charAt(0);*/


            //while ((zeroDigitCount <= userInput.length()-1) && (finder != 'P')) {
        /*if (userInput.charAt(0) == 0) {
            int i = 0;
            for (i = 0 ; i <= userInput.length()-1 ; ++zeroDigitCount) {
                if (userInput.charAt('0') == '0') {
                    ++zeroDigitCount;
                }
                char userInput = userInput.charAt(1);
            }
        }*/


            //userInput = userInput.replace(userInput.charAt(0), userInput.charAt(

	       /* if (finder.equals(0)) {
	               ++zeroDigitCount;
	               finder = userInput.charAt(finder+1);
	        }
	        else {
	           userInput.replace(finder,'P');
	        }

	     }*/

            // Display the counts
            System.out.println("Zero digits: " + zeroDigit);
            System.out.println("Even digits: " + evenDigit);
            System.out.println("Odd digits: " + oddDigit);
            System.out.println();
        }
    }
}
