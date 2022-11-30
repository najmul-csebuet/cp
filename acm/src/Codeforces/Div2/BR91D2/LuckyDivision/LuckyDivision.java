package Codeforces.Div2.BR91D2.LuckyDivision;

import java.io.*;
import java.util.*;

public class LuckyDivision {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = LuckyDivision.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? LuckyDivision.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            /*int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }*/

            int n = sc.nextInt();
            new Solution().solve(n);
        }

        if (fileInOut) {

            verify(LuckyDivision.class.getResource("ans.txt").getFile());
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
            } else if (!line1.equalsIgnoreCase(line2)) {

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

    public void solve(int n) {

        for (int i = 1; i <= n ; i++) {

            if (n % i != 0) {
                continue;
            }

            String st = String.valueOf(i);

            boolean isLucky = true;
            for (char ch : st.toCharArray()) {
                if (ch != '4' && ch != '7') {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                out.println("YES");
                return;
            }
        }

        out.println("NO");
    }
}
