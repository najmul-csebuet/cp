package Codeforces.Div3.R479.C;

import java.io.*;
import java.util.*;

public class C {

    public void solve(int n, int k, Integer[] integers) {

        Arrays.sort(integers);

        if (k == 0) {
            if (integers[0] == 1) {
                out.println(-1);
            }
            else {
                out.println(integers[0]-1);
            }
            return;
        }

        if (k == n) {
            out.println(integers[k - 1]);
            return;
        }

        if (integers[k - 1].equals(integers[k])) {
            out.println(-1);
        }
        else {
            out.println(integers[k - 1]);
        }
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = C.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            Integer[] n = new Integer[N];

            for (int nIndex = 0; nIndex < n.length; nIndex++) {
                n[nIndex] = sc.nextInt();
            }

            new C().solve(N, K, n);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(C.class.getResource("ans.txt").getFile()));
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
