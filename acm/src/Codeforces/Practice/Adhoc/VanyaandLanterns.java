package Codeforces.Practice.Adhoc;//package Codeforces.Practice;

import java.io.*;
import java.util.*;

public class VanyaandLanterns {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = VanyaandLanterns.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? VanyaandLanterns.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int lights[] = new int[N];
            for (int i = 0; i < N; i++) {
                lights[i] = sc.nextInt();
            }
            new VanyaandLanterns().solve(N, L, lights);
        }

        if (fileInOut) {
            verify(VanyaandLanterns.class.getResource("ans.txt").getFile());
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

    public void solve(int n, int l, int[] lights) {

        Arrays.sort(lights);

        double leftD = 0;
        double rightD = 0;
        double middleD = 0;

        if (lights[0] != 0) {
            leftD = lights[0];
        }

        if (lights[n - 1] != l) {
            rightD = l - lights[n - 1];
        }

        for (int i = 0; i < n - 1; i++) {
            double t = lights[i + 1] - lights[i];
            if (middleD < t) {
                middleD = t;
            }
        }

        middleD /= 2.0;

        double max = Math.max(Math.max(leftD, rightD), middleD);
        out.printf("%.10f\n", max);
    }
}
