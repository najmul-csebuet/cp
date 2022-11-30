package Codeforces.Practice.Adhoc;

import java.io.*;
import java.util.*;

public class DesignTutorialLearnFromMath {

    public void solve(int n) {
        if (n%2 == 0) {
            out.printf("%d %d\n", n-4, 4);
        }
        else {
            out.printf("%d %d\n", n-9, 9);
        }
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = DesignTutorialLearnFromMath.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? DesignTutorialLearnFromMath.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            new DesignTutorialLearnFromMath().solve(N);
        }

        if (fileInOut) {
            verify(DesignTutorialLearnFromMath.class.getResource("ans.txt").getFile());
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
