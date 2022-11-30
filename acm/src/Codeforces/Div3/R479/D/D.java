package Codeforces.Div3.R479.D;

import java.io.*;
import java.util.*;

public class D {

    private int pow3(Long num) {
        int count = 0;
        while (num%3L == 0L) {
            num /= 3L;
            ++count;
        }
        return count;
    }

    public void solve(Long[] a) {
        Arrays.sort(a, (t,e) -> {
            if (pow3(t) > pow3(e))return -1;
            if (pow3(t) < pow3(e))return +1;
            if (t <= e)return -1;
            return +1;
        });

        for (int i = 0; i < a.length - 1; i++) {
            out.print(a[i] + " ");
        }
        out.println(a[a.length - 1]);
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = D.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int aLength = sc.nextInt();
            Long[] a = new Long[aLength];

            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextLong();
            }

            new D().solve(a);
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
