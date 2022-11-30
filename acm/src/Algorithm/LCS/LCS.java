package Algorithm.LCS;

import java.io.*;
import java.util.*;

public class LCS {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = LCS.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? LCS.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            String first = sc.next();
            String second = sc.next();
            new Solution().solve(first, second);
        }

        if (fileInOut) {

            verify(LCS.class.getResource("ans.txt").getFile());
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

    public void solve(String first, String second) {

        int maxLcsLength = getLCSLength(first, second, first.length() - 1, second.length() - 1);
        out.println(maxLcsLength);
    }

    private int getLCSLength(String first, String second, int m, int n) {

        if (m == -1 || n == -1) {
            return 0;
        }

        if(first.charAt(m) == second.charAt(n)) {
            return getLCSLength(first, second, m - 1, n - 1) + 1;
        }

        return Math.max(getLCSLength(first, second, m, n - 1),
                        getLCSLength(first, second, m - 1, n));
    }
}
