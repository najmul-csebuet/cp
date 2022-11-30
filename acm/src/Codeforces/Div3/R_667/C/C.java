package Codeforces.Div3.R_667.C;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !C.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            new C().solution(n, x, y);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(C.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int n, int x, int y) {
        int dist = y - x;
        int gapCountBetweenXY = n - 1;

        while (dist % gapCountBetweenXY != 0) --gapCountBetweenXY;
        var d = dist / gapCountBetweenXY;

        var t = n - gapCountBetweenXY - 1;
        while (t > 0) {
            x -= d;
            --t;
        }

        while (x < 0) {
            x += d;
        }

        for (int i = 0; i < n - 1; i++) {
            out.print((x + i * d) + " ");
        }
        out.println(x + (n - 1) * d);
    }
}
