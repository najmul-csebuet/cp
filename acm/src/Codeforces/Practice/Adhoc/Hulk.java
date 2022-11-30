package Codeforces.Practice.Adhoc;

import java.io.*;
import java.util.*;

public class Hulk {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Hulk.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Hulk.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            new Hulk().solve(sc.nextInt());
        }

        if (fileInOut) {
            verify(Hulk.class.getResource("ans.txt").getFile());
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

    public void solve(int n) {
        String hate = "I hate that";
        String love = "I love that";
        String feelings = "";

        for (int i = 0; i < n - 1; i++) {
            if (i%2 == 1)feelings += (love + " ");
            else feelings += (hate + " ");
        }

        if (n%2 == 1)feelings += "I hate it";
        else feelings += "I love it";

        out.println(feelings);
    }
}
