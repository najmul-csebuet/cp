package Codeforces.Practice.Strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PolandBallAndGame {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !PolandBallAndGame.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? PolandBallAndGame.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            List<String> N = new ArrayList<>();
            for (int i = 0; i < n; ++i) N.add(sc.next());

            List<String> M = new ArrayList<>();
            for (int i = 0; i < m; ++i) M.add(sc.next());

            new PolandBallAndGame().solution(N, M);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(PolandBallAndGame.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(List<String> n, List<String> m) {

        List<String> commonList = new ArrayList<>(n);

        //intersection
        commonList.retainAll(m);

        //minus
        n.removeAll(commonList);
        m.removeAll(commonList);

        if (commonList.size() % 2 == 0) {
            if (n.size() > m.size()) out.println("YES");
            else out.println("NO");
        } else {
            if (m.size() > n.size()) out.println("NO");
            else out.println("YES");
        }
    }
}
