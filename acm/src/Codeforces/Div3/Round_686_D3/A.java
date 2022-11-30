package Codeforces.Div3.Round_686_D3;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !A.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int N = sc.nextInt();
            new A().solution(N);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(A.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int n) {
        for (int i = 2; i <= n; i++) {
            out.print(i + " ");
        }
        out.println(1);
    }
}
