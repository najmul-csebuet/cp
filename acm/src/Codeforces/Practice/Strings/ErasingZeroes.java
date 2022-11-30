package Codeforces.Practice.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ErasingZeroes {

    public static Scanner sc;

    public static void main(String[] args) throws IOException {

        boolean testLocally = !ErasingZeroes.class.getPackage().getName().isEmpty();

        if (testLocally) {
            List<Boolean> l = new ArrayList<>();
            ErasingZeroes s = new ErasingZeroes();

            l.add(s.solution("010011") == 2);
            l.add(s.solution("0") == 0);
            l.add(s.solution("1111000") == 0);
            //l.add(Arrays.equals(s.solution(), new int[]{));

            if (!l.contains(false)) out.println("All Test Cases Passed.");
            else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
        } else {
            sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int totalTC = sc.nextInt();
            for (int t = 1; t <= totalTC; t++) {
                String S = sc.next();
                new ErasingZeroes().solution(S);
            }
        }
    }

    public int solution(String s) {
        
        int count = 0;
        int f = -1, l = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                f = i;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                l = i;
                break;
            }
        }

        if (f == -1 || l == -1) {
            out.println(0);
            return 0;
        }

        for (int i = f; i <= l; i++) {
            if (s.charAt(i) == '0') ++count;
        }

        out.println(count);
        return count;
    }
}
