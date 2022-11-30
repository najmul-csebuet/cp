package Codeforces.Div3.Round_555.LongNumber;

import java.io.*;
import java.util.*;

public class LongNumber {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = LongNumber.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? LongNumber.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            
            int aLength = sc.nextInt();
            char[] aCh = sc.next().toCharArray();

            int[] a = new int[aLength];
            for (int j = 0; j < aLength; j++) {
                a[j] = (int) aCh[j] - 48;
            }

            int[] mapping = new int[10];
            for (int j = 1; j <= 9 ; j++) {
                mapping[j] = sc.nextInt();
            }

            new Solution().solve(a, mapping);
        }

        if (fileInOut) {

            verify(LongNumber.class.getResource("ans.txt").getFile());
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

    public void solve(int[] a, int[] mapping) {

        int i = 0;
        for (; i < a.length; i++) {

            if (a[i] >= mapping[a[i]]) {
                continue;
            }

            break;
        }

        for (int j = i; j < a.length; j++) {
            if (a[j] <= mapping[a[j]]) {
                a[j] = mapping[a[j]];
                continue;
            }
            break;
        }

        for (int j = 0; j < a.length; j++) {
            out.print(a[j]);
        }

        out.println();
    }
}
