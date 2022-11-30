package Codeforces.Practice.Strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZuhairAndStrings {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !ZuhairAndStrings.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? ZuhairAndStrings.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {

            int N = sc.nextInt();
            int K = sc.nextInt();
            String S = sc.next();
            new ZuhairAndStrings().solution(N, K, S);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(ZuhairAndStrings.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int n, int k, String s) {

        int level = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int step = 0; step <= n - k; step++) {
            boolean found = true;
            for (int i = 0; i < k - 1; i++) {
                if (s.charAt(step + i) != s.charAt(step + i + 1)) {
                    found = false;
                    step = step + i;
                    break;
                }
            }
            if (found) {
                map.put(s.charAt(step), map.getOrDefault(s.charAt(step), 0) + 1);
                step = step + k - 1;
            }
        }

        for (Character ch : map.keySet()) {
            level = Math.max(level, map.get(ch));
        }
        out.println(level);
    }
}
