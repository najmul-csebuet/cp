package Codeforces.Div3.R_555.D;

import java.io.*;
import java.util.*;

public class D {

    public void solve(int n, int k) {

        int[] ans = new int[k+1];
        for (int i = 1; i <= k; i++) {
            ans[i] = i;
        }

        int a = (k*(k+1)) >> 1;
        int remainingForEach = (n - a) / k;

        for (int i = 1; i <= k; i++) {
            ans[i] += remainingForEach;
        }

        int remainingTotal = (n - a) % k;

        //Now distribute remaining problems
        int remaining = remainingTotal;

        for (int i = k; i > 1; i--) {

            int lastHas = ans[i];
            int prevOfLastHas = ans[i-1];
            int maximumConsumeable = (prevOfLastHas << 1) - lastHas;
            remaining -= maximumConsumeable;

            if (remaining > 0) {
                ans[i] += maximumConsumeable;
            }
            else {
                if (remaining < 0) {
                    remaining += maximumConsumeable;
                    ans[i] += remaining;
                    remaining = 0;
                }
                else
                    ans[i] += maximumConsumeable;

                break;
            }
        }
        ans[1] += remaining;
        printResult(n, k, ans);
    }

    private void printResult(int n, int k, int[] ans) {

        //Check invalidity case

        //First a1 < a2 <= 2*a1
        for (int i = 2; i <= k; i++) {
            if (ans[i-1] >= ans[i] || (ans[i-1] << 1) < ans[i]) {
                out.println("NO");
                return;
            }
        }

        //Now Sum
        long sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += ans[i];
        }

        if (sum != n) {
            out.println("NO");
            return;
        }

        //Valid now
        out.println("YES");
        for (int j = 1; j < k; j++) {
            out.print(ans[j] + " ");
        }
        out.print(ans[k] + "\n");
        out.flush();
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = D.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            new D().solve(N, K);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(D.class.getResource("ans.txt").getFile()));
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
