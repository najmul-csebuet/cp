package Codeforces.Div3.R_667.B;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !B.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {

            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int N = sc.nextInt();

            long solution1 = new B().solution(A, B, X, Y, N);
            long solution2 = new B().solution(B, A, Y, X, N);
            out.println(Math.min(solution1, solution2));
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(B.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public long solution(int a, int b, int x, int y, int n) {
        /*if (a < b) {
            var t = a;
            a = b;
            b = t;

            t = x;
            x = y;
            y = t;
        }*/

        if (b - n < y) {
            a -= (n - (b - y));
            if (a < x) a = x;
            b = y;
        } else {
            b -= n;
        }
        long A = a;
        long B = b;
        long C = A * B;

        return C;
    }
}
