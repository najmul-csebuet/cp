package Codeforces.Practice.Adhoc.BearAndBigBrother;

import java.io.*;
import java.util.*;

public class BearAndBigBrother {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = BearAndBigBrother.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? BearAndBigBrother.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            new BearAndBigBrother().solve(a, b);
        }

        if (fileInOut) {
            verify(BearAndBigBrother.class.getResource("ans.txt").getFile());
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
            }
            else if (!line1.equals(line2)) {
                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {
            System.out.println("All Test Cases Passed !");
        }
        else {
            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solve(double a, double b) {

        /*double log = Math.log(b / a);
        double log1 = Math.log(3.0 / 2);
        double a1 = log / log1;
        double ceil = Math.ceil(a1);
        int ans = (int) ceil;
        out.println(ans);*/

        int count = 0;
        while (a <= b) {
            a = 3*a;
            b = 2*b;
            ++count;
        }
        out.println(count);
    }
}
