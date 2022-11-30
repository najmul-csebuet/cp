package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

public class reverse7 {

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

        reverse7 s = new reverse7();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.reverse7(123) == 321);
        l.add(s.reverse7(-123) == -321);
        l.add(s.reverse7(120) == 21);
        l.add(s.reverse7(0) == 0);
        l.add(s.reverse7(1534236469) == 0);

        checkTestCases(l);
    }

    public int reverse7(int x) {

        if (x == 0) return 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);
        while (x % 10 == 0) {
            x /= 10;
        }

        long reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        reversed = isNegative ? -reversed : reversed;
        return Math.abs(reversed) > Integer.MAX_VALUE ? 0 : (int) reversed;
    }
}