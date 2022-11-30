package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

public class P1480 {

    public static void main(String[] args) throws IOException {

        P1480 s = new P1480();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(Arrays.equals(s.runningSum(new int[]{1,2,3,4}), new int[] {1,3,6,10}));
        l.add(Arrays.equals(s.runningSum(new int[]{1,1,1,1,1}), new int[] {1,2,3,4,5}));
        l.add(Arrays.equals(s.runningSum(new int[]{3,1,2,10,1}), new int[] {3,4,6,16,17}));

        checkTestCases(l);
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

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}