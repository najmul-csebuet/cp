package Codility.Lessons.L1;

import java.io.*;
import java.util.*;

public class BinaryGap {

    public int solution(int N) {

        int maxGap = Integer.MIN_VALUE;
        int runningGap = 0;

        String binaryString = Integer.toBinaryString(N);
        for (int i = 0; i < binaryString.length(); i++) {

            char ch = binaryString.charAt(i);
            if (ch == '0') {
                ++runningGap;
                continue;
            }

            maxGap = Math.max(maxGap, runningGap);
            runningGap = 0;
        }

        return maxGap;
    }

    public static void main(String[] args) throws IOException {

        BinaryGap s = new BinaryGap();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(9) == 2);
        l.add(s.solution(529) == 4);
        l.add(s.solution(20) == 1);
        l.add(s.solution(15) == 0);
        l.add(s.solution(32) == 0);

        checkTestCases(l);
    }

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            Boolean result = l.get(i);
            if (!result) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        if (allPassed) {
            System.out.println("All Test Cases Passed!");
        }
    }
}