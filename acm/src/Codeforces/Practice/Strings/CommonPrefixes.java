package Codeforces.Practice.Strings;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonPrefixes {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {
        boolean fileInOut = !CommonPrefixes.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CommonPrefixes.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {

            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i)N[i] = sc.nextInt();

            new CommonPrefixes().solution(N);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(CommonPrefixes.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int[] n) {
        List<StringBuilder> list = new ArrayList<>();
        for(int a : n) {
            if (list.isEmpty()) {
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();

                if (a == 0) {
                    s1.append('a');
                    s2.append('b');
                    list.add(s1);
                    list.add(s2);
                    continue;
                }

                for (int i = 0; i < a; i++) {
                    s1.append('a');
                    s2.append('a');
                }

                list.add(s1);
                list.add(s2);
                continue;
            }

            StringBuilder last = list.get(list.size() - 1);

            if (a == 0) {
                StringBuilder newSb = new StringBuilder();
                char ch = (char) (((last.charAt(0) - 'a' + 1) % 26) + 'a');
                newSb.append(ch);
                list.add(newSb);
                continue;
            }

            if (last.length() < a) {
                for (int i = 0; i <= a - last.length(); i++) {
                    last.append(last.charAt(0));
                }
                list.set(list.size() - 1, last);
            }

            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < a; i++) {
                newSb.append(last.charAt(0));
            }
            list.add(newSb);
        }

        for(StringBuilder sb : list)out.println(sb.toString());
        
        out.println();
    }
}
