package Codeforces.Practice.Adhoc.AntonAndDanik;//package Codeforces.Practice.AntonAndDanik;

import java.io.*;
import java.util.*;

public class AntonAndDanik {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = AntonAndDanik.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? AntonAndDanik.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            new AntonAndDanik().solve(sc.nextInt(), sc.next());
        }

        if (fileInOut) {
            verify(AntonAndDanik.class.getResource("ans.txt").getFile());
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

    public void solve(int n, String next) {
        int a = 0, b = 0;
        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) == 'A')++a;
            else ++b;
        }

        if (a > b)out.println("Anton");
        else if (a < b)out.println("Danik");
        else out.println("Friendship");
    }
}
