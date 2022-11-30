package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P189 {

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

        P189 s = new P189();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(Arrays.equals(s.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3), new int[]{5, 6, 7, 1, 2, 3, 4}));

        checkTestCases(l);
    }

    public int[] rotate(int[] nums, int k) {

        if (nums.length == 0) return nums;

        k = k % nums.length;
        int[] ans = new int[nums.length];
        int index = -1;
        for (int i = nums.length - k; i < nums.length; i++) {
            ans[++index] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            ans[++index] = nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = ans[i];
        }
        return nums;
    }
}