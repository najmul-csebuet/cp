package Codeforces.Div2.Round_579.A;

import java.io.*;
import java.util.*;

public class A {
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = A.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            new A().solution(l,r);
        }

        if (fileInOut) {
            verify(A.class.getResource("ans.txt").getFile());
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

    public void solution(int l, int r) {
        for (int i = l; i <= r; i++) {

            int n = i;

            Set<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;

            while (n > 0) {
                int remainder = n % 10;
                if (set.contains(remainder)) {
                    hasDuplicate = true;
                    break;
                } else {
                    set.add(remainder);
                    n /= 10;
                }
            }

            if (!hasDuplicate) {
                out.println(i);
                return;
            }
        }

        out.println(-1);
    }
}
