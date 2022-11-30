package Codeforces.Div3.Round_496.E1;

import java.io.*;
import java.util.*;

public class E1 {

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = E1.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? E1.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] p = new int[n];

            for (int pIndex = 0; pIndex < p.length; pIndex++) {
                p[pIndex] = sc.nextInt();
            }

            new E1().solution(n, m, p);
        }

        if (fileInOut) {
            verify(E1.class.getResource("ans.txt").getFile());
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

    public void solution(int n, int m, int[] P) {

        int sum = 0;
        long ans = 0;
        boolean mFound = false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int r = 0; r < n; r++) {

            if (P[r] < m) {
                --sum;
            } else if(P[r] > m) {
                ++sum;
            } else {
                mFound = true;
            }

            if (!mFound) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            } else {
                ans += (map.getOrDefault(sum, 0) + map.getOrDefault(sum - 1, 0));
            }
        }

        out.println(ans);
    }
}
