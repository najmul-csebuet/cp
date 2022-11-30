package Codility.Lessons.L7.Brackets;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public int solution(String S) {

        if (S.isEmpty()) {
            out.println(1);
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        boolean good = true;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {

                if (stack.isEmpty()) {
                    good = false;
                    break;
                }

                Character pop = stack.pop();
                if (pop == '(' && ch == ')')continue;
                if (pop == '{' && ch == '}')continue;
                if (pop == '[' && ch == ']')continue;

                good = false;
                break;
            }
        }

        if (stack.isEmpty() && good) {
            out.println(1);
            return 1;
        }

        out.println(0);
        return 0;
    }

    static class AlgoHelper {

        static HashSet<Integer> getSetFromArray(int[] A) {
            HashSet<Integer> mySet = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                mySet.add(A[i]);
            }
            return mySet;
        }
        static int[] getPrefixSumArray(int[] A) {

            int[] prefixSum = new int[A.length];
            prefixSum[0] = A[0];
            for (int i = 1; i < A.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            }

            return prefixSum;
        }
        static int[] getSuffixSumArray(int[] A) {

            int[] suffixSum = new int[A.length];
            suffixSum[A.length - 1] = A[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + A[i];
            }

            return suffixSum;
        }

        private static void printArray(int[] array) {

            for (int i = 0; i < array.length - 1; i++) {
                out.print(array[i] + " ");
            }

            if (array.length > 0)
                out.println(array[array.length - 1]);
            else
                out.println();
        }
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            String S = sc.next();
            new Solution().solution(S);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(Solution.class.getResource("ans.txt").getFile()));
            BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            boolean areEqual = true;
            int lineNum = 1;

            while (line1 != null || line2 != null) {

                if (line1 == null || line2 == null) {

                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {

                    areEqual = false;
                    break;
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();

                lineNum++;
            }

            if (areEqual) {

                System.out.println("All Test Cases Passed !");
            } else {

                System.out.println("Output differ at line " + lineNum);
                System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
            }

            reader1.close();
            reader2.close();
        }
    }
}
