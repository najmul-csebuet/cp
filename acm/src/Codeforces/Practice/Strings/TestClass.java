package Codeforces.Practice.Strings;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class TestClass {

    public static Scanner sc;

    public static void main(String[] args) throws IOException {

        boolean testLocally = !TestClass.class.getPackage().getName().isEmpty();

        if (testLocally) {
            List<Boolean> l = new ArrayList<>();
            TestClass s = new TestClass();

            l.add(s.solution() == 0);
            //l.add(Arrays.equals(s.solution(), new int[]{));

            if (!l.contains(false)) out.println("All Test Cases Passed.");
            else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
        } else {
            sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int totalTC = sc.nextInt();
            for (int t = 1; t <= totalTC; t++) {
                new TestClass().solution();
            }
        }
    }

    public int solution() {
        out.println(0);
        return 0;
    }
}
