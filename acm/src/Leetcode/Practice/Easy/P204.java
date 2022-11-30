package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

public class P204 {

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

        P204 s = new P204();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.countPrimes(0) == 0);
        l.add(s.countPrimes(1) == 0);
        l.add(s.countPrimes(2) == 0);
        l.add(s.countPrimes(3) == 1);
        l.add(s.countPrimes(5) == 2);
        l.add(s.countPrimes(10) == 4);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    private boolean isPrime(int a) {
        if (a == 2) return true;
        if (a % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(a);
        for (int i = 3; i <= sqrt; i += 2) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n < 3) return 0;
        if (n == 3) return 1;
        int ans = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) ++ans;
        }
        return ans;
    }
}