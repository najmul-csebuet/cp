package Codeforces.Practice.Strings;

import Common.Verifier;

import java.io.*;
import java.util.*;

public class R_376_D2_A {

    public void solution(String string) {

        int cost = 0;
        int lastChar = 0;

        for (char ch : string.toCharArray()) {
            int value = ch - 'a';

            int d1 = Math.abs(lastChar - value);
            int d2 = Math.min(lastChar + 26 - value, value + 26 - lastChar);

            cost += Math.min(d1, d2);

            lastChar = value;
        }

        out.println(cost);
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        boolean fileInOut = R_376_D2_A.class.getPackage() != null;
        int totalTC = fileInOut ? sc.nextInt() : 1;

        for (int tc = 1; tc <= totalTC; tc++) {
            String ss = sc.next();
            new R_376_D2_A().solution(ss);
        }

        if (fileInOut) Verifier.verify(R_376_D2_A.class.getResource("ans.txt").getFile());
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = R_376_D2_A.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? R_376_D2_A.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
