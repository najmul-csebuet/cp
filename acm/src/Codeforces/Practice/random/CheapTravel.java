package Codeforces.Practice.random;

import java.io.*;
import java.util.*;

public class CheapTravel {

    public void solve(int n, int m, int a, int b) {

        double mUnit = (double) b / m;
        if (a <= mUnit) {
            out.println(n*a);
            return;
        }

        int tripCountForM = n / m;
        if (n % m != 0) {
            out.println(tripCountForM*b + Math.min(b, (n%m)*a));
        }
        else {
            out.println(tripCountForM*b);
        }
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = CheapTravel.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CheapTravel.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            new CheapTravel().solve(N,M,A,B);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(CheapTravel.class.getResource("ans.txt").getFile()));
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
