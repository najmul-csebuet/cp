package Codeforces.Div3.R_555.B;

import java.io.*;
import java.util.*;

public class B {

    public void solve(int n, String a, int[] digitMapping) {

        boolean started = false;
        StringBuilder stringBuilder = new StringBuilder(a);

        for (int i = 0; i < a.length(); i++) {
            int charAt = stringBuilder.charAt(i) - '0';

            if (charAt >= digitMapping[charAt] && !started)continue;
            if (charAt > digitMapping[charAt] && started)break;

            stringBuilder.setCharAt(i, (char) (digitMapping[charAt] + '0'));
            started = true;
        }
        out.println(stringBuilder);
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = B.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            String A = sc.next();
            int[] digitMapping = new int[10];
            for (int i = 1; i <= 9; i++) {
                digitMapping[i] = sc.nextInt();
            }
            new B().solve(N, A, digitMapping);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(B.class.getResource("ans.txt").getFile()));
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
