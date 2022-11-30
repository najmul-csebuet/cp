package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

public class P633 {

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

        P633 s = new P633();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.judgeSquareSum(5) == true);
        l.add(s.judgeSquareSum(0) == true);
        l.add(s.judgeSquareSum(61) == true);
        l.add(s.judgeSquareSum(11) == false);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            int a = i * i;
            int bSquare = c - a;
            int t = (int) Math.sqrt(bSquare);
            if (t * t == bSquare) return true;
        }
        return false;
    }
}