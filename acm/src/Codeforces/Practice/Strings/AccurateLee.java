package Codeforces.Practice.Strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AccurateLee {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !AccurateLee.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? AccurateLee.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            new AccurateLee().solution();
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(AccurateLee.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++) if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution() {

        int lenS = sc.nextInt();
        String s = sc.next();

        int first1 = -1;
        int last0 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                first1 = i;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                last0 = i;
                break;
            }
        }

        if (first1 == -1 || last0 == -1 || first1 > last0) {
            out.println(s);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first1; i++) {
            sb.append(0);
        }

        sb.append(0);

        for (int i = 0; i < s.length() - last0 - 1; i++) {
            sb.append(1);
        }

        out.println(sb.toString());
    }
}
