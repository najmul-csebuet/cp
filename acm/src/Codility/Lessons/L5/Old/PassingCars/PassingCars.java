package Codility.Lessons.L5.Old.PassingCars;

import java.io.*;
import java.util.*;

public class PassingCars {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = PassingCars.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? PassingCars.class.getResourceAsStream("in.txt") : System.in)));
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

            verify(PassingCars.class.getResource("ans.txt").getFile());
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

        if (A.length < 1){
            out.println(0);
            return 0;
        }

        long passingCarCount = 0;
        int[] prefixSum = new int[A.length];

        for (int i = 1; i < A.length; i++) {

            //prefixSum[i] = prefixSum[i-1] + 1 - A[i-1];
            if (A[i-1] == 0) {
                prefixSum[i] = prefixSum[i-1] + 1;
            } else {
                prefixSum[i] = prefixSum[i-1];
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] == 1) {
                passingCarCount = passingCarCount + prefixSum[i];
            }
        }

        if (passingCarCount > 1e9) {
            out.println(-1);
            return -1;
        }

        out.println(passingCarCount);
        return (int) passingCarCount;
    }

    private void printArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            out.print(A[i] + ' ');
        }
        if (A.length > 0) {
            out.println(A[A.length - 1]);
        }
    }
}
