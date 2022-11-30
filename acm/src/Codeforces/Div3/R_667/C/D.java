package Codeforces.Div3.R_667.C;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !D.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            var n = sc.next();
            int s = sc.nextInt();
            new D().solution(n, s);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(D.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String n, int s) {
        var chars = n.toCharArray();
        int sum = 0;
        int i = 0;
        while (sum < s && i < chars.length) {
            sum += (chars[i++] - '0');
        }
        if (sum <= s) {
            out.println(0);
            return;
        }
        --i;
        long ans = 0;
        for (int j = 0; j < chars.length; j++) {

        }
    }
}
