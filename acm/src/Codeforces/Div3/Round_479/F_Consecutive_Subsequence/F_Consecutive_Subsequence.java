package Codeforces.Div3.Round_479.F_Consecutive_Subsequence;

import java.io.*;
import java.util.*;

public class F_Consecutive_Subsequence {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = F_Consecutive_Subsequence.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? F_Consecutive_Subsequence.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int aLength = sc.nextInt();
            int[] A = new int[aLength];

            for (int aIndex = 0; aIndex < A.length; aIndex++) {
                A[aIndex] = sc.nextInt();
            }

            new Solution().solve(A);
        }

        if (fileInOut) {

            verify(F_Consecutive_Subsequence.class.getResource("ans.txt").getFile());
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

    public void solve(int[] A) {

        HashMap<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            Integer max = Math.max(dp.getOrDefault(A[i], 0), dp.getOrDefault(A[i] - 1, 0) + 1);
            dp.put(A[i], max);
        }

        Integer maxSeqLength = 0;
        Integer last = 0;

        for (int i = 0; i < A.length; i++) {
            Integer value = dp.getOrDefault(A[i], 0);
            if (maxSeqLength < value) {
                last = A[i];
                maxSeqLength = value;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = A.length - 1, j = maxSeqLength; j > 0 && i >= 0; i--) {
            if (A[i] == last) {
                arrayList.add(i+1);
                --last;
                --j;
            }
        }

        out.println(maxSeqLength);
        for (int i = arrayList.size() - 1; i > 0; i--) {
            out.print(arrayList.get(i) + " ");
        }
        if (arrayList.size() >= 1) {
            out.println(arrayList.get(0));
        }
    }
}
