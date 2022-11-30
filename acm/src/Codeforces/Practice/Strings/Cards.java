package Codeforces.Practice.Strings;

import Common.Verifier;

import java.io.*;
import java.util.*;

public class Cards {

    public void solution(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char ch : chars) {
            if (ch == 'z') list.add(0);
            else if (ch == 'n') list.add(1);
        }

        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size())
                out.println(list.get(i));
            else
                out.print(list.get(i) + " ");
        }

        out.flush();
    }

    public static void main(String[] args) throws IOException {
        boolean fileInOut = Cards.class.getPackage() != null;
        int totalTC = fileInOut ? sc.nextInt() : 1;

        for (int tc = 1; tc <= totalTC; tc++) {
            int l = sc.nextInt();
            String S = sc.next();
            new Cards().solution(S);
        }

        if (fileInOut) Verifier.verify(Cards.class.getResource("ans.txt").getFile());
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = Cards.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Cards.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
