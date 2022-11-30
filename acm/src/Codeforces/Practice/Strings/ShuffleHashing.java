package Codeforces.Practice.Strings;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShuffleHashing {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !ShuffleHashing.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? ShuffleHashing.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            String P = sc.next();
            String H = sc.next();
            new ShuffleHashing().solution(P, H);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(ShuffleHashing.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String p, String h) {

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);

        for (int i = 0; i <= h.length() - p.length(); ++i) {
            String substring = h.substring(i, i + p.length());
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);

            if (Arrays.equals(pChars, chars)) {
                out.println("YES");
                return;
            }
        }

        out.println("NO");
    }
}
