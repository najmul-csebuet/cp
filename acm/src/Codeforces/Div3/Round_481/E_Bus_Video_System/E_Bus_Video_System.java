package Codeforces.Div3.Round_481.E_Bus_Video_System;

import java.io.*;
import java.util.*;

public class E_Bus_Video_System {

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = E_Bus_Video_System.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? E_Bus_Video_System.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();
            int w = sc.nextInt();

            int[] b = new int[n];

            for (int bIndex = 0; bIndex < b.length; bIndex++) {
                b[bIndex] = sc.nextInt();
            }

            new E_Bus_Video_System().solution(n, w, b);
        }

        if (fileInOut) {
            verify(E_Bus_Video_System.class.getResource("ans.txt").getFile());
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

    public void solution(int n, int w, int[] B) {

        int minB = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;

        int currentPassengerCount = 0;
        for (int i = 0; i < B.length; i++) {
            currentPassengerCount += B[i];
            minB = Math.min(minB, currentPassengerCount);
            maxB = Math.max(maxB, currentPassengerCount);
        }

        if (maxB > w) {
            out.println(0);
            return;
        }

        int l = 0;
        int r = w;

        if (minB < 0) {
            l = -minB;
        }

        if (maxB > 0) {
            r = w - maxB;
        }

        if (l > r) {
            out.println(0);
            return;
        }

        out.println(r - l + 1);
    }
}
