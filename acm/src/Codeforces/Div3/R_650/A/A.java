package Codeforces.Div3.R_650.A;

import Common.Verifier;

import java.io.*;
import java.util.*;

public class A {

    public void solution(String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(b.charAt(0));
        for (int i = 1; i < b.length() - 1; i += 2) {
            sb.append(b.charAt(i));
        }
        sb.append(b.charAt(b.length() - 1));
        out.println(sb.toString());
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        boolean fileInOut = A.class.getPackage() != null;
        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();

        for (int tc = 1; tc <= totalTC; tc++) {
            String b = sc.next();
            new A().solution(b);
        }

        if (fileInOut) Verifier.verify(A.class.getResource("ans.txt").getFile());
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = A.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
