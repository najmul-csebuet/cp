package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

public class convertToTitle {

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

        convertToTitle s = new convertToTitle();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.convertToTitle(1).equals("A"));
        l.add(s.convertToTitle(26).equals("Z"));
        l.add(s.convertToTitle(27).equals("AA"));
        l.add(s.convertToTitle(28).equals("AB"));
        l.add(s.convertToTitle(701).equals("ZY"));
        l.add(s.convertToTitle(52).equals("AZ"));
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    private char getChar(int n) {
        return (char) ('A' + n - 1);
    }

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();

        /*String s = Integer.toString(n, 26);
        System.out.println(s);*/

        while (n > 0) {
            int mod = n%26 != 0 ? n %26 : 26;
            sb.append(getChar(mod));
            n -= mod;
            n /= 26;
        }

        return sb.reverse().toString();
    }
}