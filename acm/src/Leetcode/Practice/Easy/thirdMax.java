package Leetcode.Practice.Easy;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;

public class thirdMax {

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

        thirdMax s = new thirdMax();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.thirdMax(new int[]{3, 2, 1}) == 1);
        l.add(s.thirdMax(new int[]{1, 2}) == 2);
        l.add(s.thirdMax(new int[]{2, 2, 3, 1}) == 1);
        l.add(s.thirdMax(new int[]{1, 2, -2147483648}) == -2147483648);
        l.add(s.thirdMax(new int[]{1, 1, -2147483648}) == 1);
        l.add(s.thirdMax(new int[]{1, 1, 1, -2147483648, -2147483648, -2147483648, -2147483648}) == 1);

        checkTestCases(l);
    }

    public int thirdMax(int[] nums) {

        if (nums.length < 3) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }

        Long max1 = Long.MIN_VALUE;
        Long max2 = Long.MIN_VALUE;
        Long max3 = Long.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {

            Long a = (long) nums[i];

            if (max1 <= a) {
                if (max1.equals(a)) continue;
                max3 = max2;
                max2 = max1;
                max1 = a;
            } else if (max2 <= a) {
                if (max2.equals(a)) continue;
                max3 = max2;
                max2 = a;
            } else if (max3 <= a) {
                max3 = a;
            }
        }

        if (max3 == Long.MIN_VALUE) return Math.toIntExact(max1);

        return Math.toIntExact(max3);
    }
}