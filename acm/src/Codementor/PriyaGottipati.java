package Codementor;

import java.util.Scanner;

/*
Bobby Roberts is totally bored in his algorithms class, so he  has developed a little solitaire game.  He writes down a sequence of positive integers and then begins removing them one at a time.  The cost of each removal is equal to the greatest common divisor (GCD) of the two curronding numbers (wrapping around either end if necessary).

 For example, if the sequence of number was 2, 3, 4, 5 he coule remove the 3 at a cost of 2 (=gcd(2,4)) or
 he could remove the 4 at a cost of 1 (=gcd(3,5)).

The cost of removing 2 would be 1 and the removal of 5 would cost 2.

Note that if the 4 is removed first, the removal of the 3 afterwards now has a cost only 1.

Bobby keeps a running total of each removal cost.  When he ends up with just two numbers ramaining he takes their gcd, adds that cost to the running total, and ends the game by removing them both.  The object of the game is to remove all of the numbers at the minimum total cost.
Input: input contains multiple test cases. Each case consists of a single line starting with an integer n which indicates the number of values in the sequence (2<=n<=100).  This is followed by n positive integers which make up the sequence of values in the game.  All of these integers will be <= 1000.  Input terminates with a line containing a signle 0.  zthere are at most 1000 test cases.
Output: For each test case, disply the minimum cost of removing all of the numbers.
Sample run:
input:
4 2 3 4 5
5 14 2 4 6 8
0
Output:
3
8
Requirement:
1. You can choose either Java or C programming language;
2. Your code must compile and run on EECS Linux workstation, e.g, spirit.eecs.csuohio.edu
3. create a submission folder, by concatenate your Linux user name and homework ID, e.g., hwang_hw8.  then copy your source code to the folder created
4. Submission instruction:  log in grail.eecs.csuohio.edu and make sure you are at the parent directory of your submission folder and run the following command
$ turnin -c cis390w   -p hw8    YOUR_SUBMISSION_FOLDER_NAME
 */
public class PriyaGottipati {

    public static void main(String[] args) {
        new PriyaGottipati().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int[] N = new int[n];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            findCost(N);
        }
    }

    private void findCost(int[] n) {
        int nc = gcd(2,4);
        System.out.println();
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
