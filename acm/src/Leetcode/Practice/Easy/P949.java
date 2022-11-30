package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

public class P949 {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        System.out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        P949 s = new P949();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.largestTimeFromDigits(new int[]{1, 9, 6, 0}).equals("19:06"));
        l.add(s.largestTimeFromDigits(new int[]{1, 2, 3, 4}).equals("23:41"));
        l.add(s.largestTimeFromDigits(new int[]{5, 5, 5, 5}).equals(""));

        checkTestCases(l);
    }

    public String largestTimeFromDigits(int[] A) {
        int[] count = new int[10];
        for (int a : A) {
            ++count[a];
        }

        for (int a = 2; a >= 0; a--) {
            if (count[a] == 0) continue;
            --count[a];
            for (int b = 9; b >= 0; b--) {
                if (count[b] == 0) continue;
                --count[b];
                int hour = 10 * a + b;
                if (hour > 23) {
                    ++count[b];
                    continue;
                }
                for (int c = 9; c >= 0; c--) {
                    if (count[c] == 0) continue;
                    --count[c];
                    for (int d = 9; d >= 0; d--) {
                        if (count[d] == 0) continue;
                        --count[d];
                        int min = 10 * c + d;
                        if (min > 59) {
                            ++count[d];
                            continue;
                        }

                        String s = "" + a + b + ":" + c + d;
                        return s;
                    }
                    ++count[c];
                }
                ++count[b];
            }
            ++count[a];
        }

        return "";
    }
}