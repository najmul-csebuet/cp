package Codeforces.Div2.Round_579.Div2.Round_579;

import java.io.*;
import java.util.*;

public class B {
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = B.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int h = sc.nextInt();
            int w = sc.nextInt();

            int rLength = h;
            int[] r = new int[rLength];

            for (int rIndex = 0; rIndex < r.length; rIndex++) {
                r[rIndex] = sc.nextInt();
            }

            int cLength = w;
            int[] c = new int[cLength];

            for (int cIndex = 0; cIndex < c.length; cIndex++) {
                c[cIndex] = sc.nextInt();
            }


            new B().solution(h, w, r, c);
        }

        if (fileInOut) {
            verify(B.class.getResource("ans.txt").getFile());
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

    public void solution(int h, int w, int[] row, int[] column) {
        int[][] grid = new int[h][w];

        for (int r = 0; r < h; r++) {
            for (int i = 0; i < row[r]; i++) {
                grid[r][i] = 1;
            }
            if (row[r] == 0) {
                grid[r][0] = 1;
                continue;
            }
            if (row[r] == w-1) {
                grid[r][w-1] = 1;
                continue;
            }
        }

        for (int c = 0; c < w; c++) {
            for (int i = 0; i < column[c]; i++) {
                grid[i][c] = 1;
            }
            if (column[c] == 0) {
                grid[0][c] = 1;
                continue;
            }
            if (column[c] == h-1) {
                grid[h-1][c] = 1;
                continue;
            }
        }

        int count = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0)++count;
            }
        }

        int ans = count > 0 ? 1 : 0;
        for (int i = 1; i <= count; i++) {
            ans = (ans*2) % 1000000007;
        }

        out.println(ans);
    }
}

