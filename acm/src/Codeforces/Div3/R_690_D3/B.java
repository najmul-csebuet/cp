package Codeforces.Div3.R_690_D3;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class B {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !B.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int N = sc.nextInt();
            String S = sc.next();
            new B().solution(S);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(B.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String s) {
        int n = s.length();
        if(n < 4) {
            out.println("NO");
            return;
        }

        if (s.endsWith("2020")) {
            out.println("YES");
            return;
        }

        if (s.startsWith("2") && s.endsWith("020")) {
            out.println("YES");
            return;
        }

        if (s.startsWith("20") && s.endsWith("20")) {
            out.println("YES");
            return;
        }
        if (s.startsWith("202") && s.endsWith("0")) {
            out.println("YES");
            return;
        }
        if (s.startsWith("2020")) {
            out.println("YES");
            return;
        }
        out.println("NO");
    }
}
