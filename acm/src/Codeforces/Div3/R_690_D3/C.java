package Codeforces.Div3.R_690_D3;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !C.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int x = sc.nextInt();
            new C().solution(x);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(C.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int x) {
        if (x > 45) {
            out.println(-1);
            return;
        }
        int s = 9;
        StringBuilder sb = new StringBuilder();
        while (x > s) {
            sb.append(s);
            x -= s;
            --s;
        }
        if(x > 0)
            sb.append(x);
        sb.reverse();
        out.println(sb.toString());
    }
}
