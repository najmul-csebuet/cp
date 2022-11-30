package Codeforces.Practice.Strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MemoryAndTrident {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !MemoryAndTrident.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? MemoryAndTrident.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            String S = sc.next();
            new MemoryAndTrident().solution(S);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(MemoryAndTrident.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String s) {

        if (s.length() % 2 == 1) {
            out.println(-1);
            return;
        }

        int x = 0, y = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') --x;
            else if (ch == 'R') ++x;
            else if (ch == 'U') ++y;
            else --y;
        }

        x = Math.abs(x);
        y = Math.abs(y);

        if (x % 2 == 0) {
            out.println(x / 2 + y / 2);
            return;
        }

        --x;
        ++y;

        out.println(x / 2 + y / 2);
    }
}
