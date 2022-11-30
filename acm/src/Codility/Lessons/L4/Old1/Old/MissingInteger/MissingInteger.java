package Codility.Lessons.L4.Old1.Old.MissingInteger;

import java.io.*;
import java.util.*;

public class MissingInteger {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = MissingInteger.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? MissingInteger.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int aLength = sc.nextInt();
            int[] a = new int[aLength];

            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new Solution().solution(a);
        }

        if (fileInOut) {

            verify(MissingInteger.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
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

class Solution {

    public static PrintWriter out;

    public int solution(int[] A) {

        Arrays.sort(A);

        int positiveIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1)continue;

            positiveIndex = i;
            break;
        }

        if (positiveIndex == -1 || A[positiveIndex] > 1) {
            out.println(1);
            return 1;
        }

        for (; positiveIndex < A.length - 1; positiveIndex++) {

            if (A[positiveIndex] == A[positiveIndex + 1])continue;
            if (A[positiveIndex] + 1 == A[positiveIndex + 1])continue;

            out.println(A[positiveIndex] + 1);
            return A[positiveIndex] + 1;
        }

        if (positiveIndex == A.length - 1) {
            out.println(A[positiveIndex]+1);
            return A[positiveIndex]+1;
        }

        return positiveIndex;
    }

    private void printArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            out.print(A[i] + " ");
        }
        if(A.length > 0) {
            out.println(A[A.length - 1]);
        }
    }
}
