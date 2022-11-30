package Codeforces.Div3.Round_479.C_Less_or_Equal;

import java.io.*;
import java.util.*;

public class C_Less_or_Equal {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = C_Less_or_Equal.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C_Less_or_Equal.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int aLength = n;
            Integer[] a = new Integer[aLength];

            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new Solution().solution(n, k, a);
        }

        if (fileInOut) {

            verify(C_Less_or_Equal.class.getResource("ans.txt").getFile());
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

    public void solution(int n, int k, Integer[] a) {
        Arrays.sort(a);
        if (k == 0) {
            out.println(a[0] == 1 ? -1 : a[0] - 1);
        }
        else if (k == n || a[k] > a[k-1]) {
            out.println(a[k-1]);
        } else {
            out.println(-1);
        }
    }
}
