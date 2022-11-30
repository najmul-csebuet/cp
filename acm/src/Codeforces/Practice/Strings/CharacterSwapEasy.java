package Codeforces.Practice.Strings;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharacterSwapEasy {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !CharacterSwapEasy.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CharacterSwapEasy.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int N = sc.nextInt();
            String S = sc.next();
            String T = sc.next();
            new CharacterSwapEasy().solution(S, T);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(CharacterSwapEasy.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String s, String t) {
        int firstDiff = -1;
        int secondDiff = -1;

        int diffCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ++diffCount;
                if (firstDiff == -1)firstDiff = i;
                else if (secondDiff == -1)secondDiff = i;
            }
        }

        if (diffCount != 2) {
            out.println("No");
        }
        else {
            if (s.charAt(firstDiff) == s.charAt(secondDiff) && t.charAt(secondDiff) == t.charAt(firstDiff)) {
                out.println("Yes");
            }
            else {
                out.println("No");
            }
        }
    }
}
