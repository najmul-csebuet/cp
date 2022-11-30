package Codility.Lessons.L6.Old.MaxProductOfThree;

import java.io.*;
import java.util.*;

public class MaxProductOfThree {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = MaxProductOfThree.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? MaxProductOfThree.class.getResourceAsStream("in.txt") : System.in)));
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

            verify(MaxProductOfThree.class.getResource("ans.txt").getFile());
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

class Solution {

    public static MyPrintWriter out;

    public int solution(int[] A) {

        Arrays.sort(A);

        int n = A.length;
        int ans = Math.max(A[0] * A[1] * A[n-1], A[n-1] * A[n-2] * A[n-3]);
        out.println(ans);
        return ans;

        /*int probableAns = A[n-1] * A[n-2] * A[n-3];

        if (A.length == 3 || A[0] >= 0 || A[1] >= 0) {

            out.println(probableAns);
            return probableAns;
        }

        //n >= 4 and first 2 element are negative

        if (A[n-1] < 0) {
            out.println(probableAns);
            return probableAns;
        }

        if (A[n-2] < 0) {
            out.println(A[0] * A[1] * A[n-1]);
            return A[0] * A[1] * A[n-1];
        }

        if (A[n-3] < 0) {
            out.println(A[0] * A[1] * A[n-1]);
            return A[0] * A[1] * A[n-1];
        }

        //n >= 5 and first 2 element are negative and last 3 element are positive
        if(A[0]*A[1]*A[n-1] > probableAns) {
            probableAns = A[0]*A[1]*A[n-1];
        }

        out.println(probableAns);
        return probableAns;*/
    }
}
