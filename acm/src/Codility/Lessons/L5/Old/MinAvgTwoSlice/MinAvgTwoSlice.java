package Codility.Lessons.L5.Old.MinAvgTwoSlice;

import java.io.*;
import java.util.*;

class MyPrintWriter extends PrintWriter {

    public MyPrintWriter(BufferedOutputStream bufferedOutputStream, boolean autoFlash) {
        super(bufferedOutputStream, autoFlash);
    }

    public void print(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            print(A[i] + ' ');
        }
        if (A.length > 0) {
            println(A[A.length - 1]);
        }
    }
}

public class MinAvgTwoSlice {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = MinAvgTwoSlice.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? MinAvgTwoSlice.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new MyPrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

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

            verify(MinAvgTwoSlice.class.getResource("ans.txt").getFile());
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

    public static MyPrintWriter out;

    public int solution(int[] A) {

        long[] prefixSum = new long[A.length];

        //Compute prefixSum
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        double minAvg = +100000;
        int minAvgStart = -1;

        for (int sliceLength = 2; sliceLength <= 3; sliceLength++) {
            for (int startIndex = 0; startIndex <= A.length - sliceLength; startIndex++) {

                int endIndex = startIndex + sliceLength - 1;

                long sliceSum = prefixSum[endIndex] - (startIndex > 0 ? prefixSum[startIndex - 1] : 0);
                double sliceAvg = (double) sliceSum / sliceLength;

                if (minAvg > sliceAvg) {
                    minAvg = sliceAvg;
                    minAvgStart = startIndex;
                }
            }
        }

        out.println(minAvgStart);
        return minAvgStart;
    }
}
