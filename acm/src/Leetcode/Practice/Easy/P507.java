package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

public class P507 {

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

        P507 s = new P507();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.checkPerfectNumber(28) == true);

        checkTestCases(l);
    }

    public boolean checkPerfectNumber(int num) {

        if (num < 2) return false;

        int divSum = -num;

        int sqrt = (int) Math.sqrt(num);

        for (int i = 1; i < sqrt; i++) {

            if (num % i == 0) {
                divSum += i;
                divSum += num / i;
            }

            if (divSum > num) return false;
        }

        if (sqrt * sqrt == num) {
            divSum += sqrt;
        } else if (num % sqrt == 0) {
            divSum += sqrt;
            divSum += num / sqrt;
        }

        return divSum == num;
    }
}