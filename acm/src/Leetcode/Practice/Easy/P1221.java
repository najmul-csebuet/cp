package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P1221 {

    public static void main(String[] args) throws IOException {

        P1221 s = new P1221();
        ArrayList<Boolean> l = new ArrayList<>();

        out.println(s.solution("RLRRLLRLRL") == 4);
        out.println(s.solution("RLLLLRRRLR") == 3);
        out.println(s.solution("LLLLRRRR") == 1);
        out.println(s.solution("RLRRRLLRLL") == 2);
        //l.add(s.solution("RLRRLLRLRL") == 4);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        //checkTestCases(l);
    }

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

    public int solution(String s) {

        int LCount = 0, RCount = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'L') ++LCount;
            else if (s.charAt(i) == 'R') ++RCount;

            if (LCount == RCount && LCount > 0) {
                ++ans;
                LCount = RCount = 0;
            }
        }

        return ans;
    }
}