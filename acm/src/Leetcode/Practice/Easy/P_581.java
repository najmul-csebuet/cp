package Leetcode.Practice.Easy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class P_581 {

    public static void main(String[] args) throws IOException {
        Integer c;
        P_581 obj = new P_581();

        c = obj.solve(new int[]{1, 3, 5, 4, 2});
        out.println(c.equals(4));

        c = obj.solve(new int[]{2, 1, 5, 3, 4});
        out.println(c.equals(5));

        c = obj.solve(new int[]{1, 3, 5, 2, 4});
        out.println(c.equals(4));

        c = obj.solve(new int[]{1, 2, 4, 5, 3});
        out.println(c.equals(3));

        c = obj.solve(new int[]{2, 3, 3, 2, 4});
        out.println(c.equals(3));

        c = obj.solve(new int[]{1, 1});
        out.println(c.equals(0));

        c = obj.solve(new int[]{1, 3, 2, 2, 2});
        out.println(c.equals(4));

        c = obj.solve(new int[]{2, 6, 4, 8, 10, 9, 15});
        out.println(c.equals(5));

        c = obj.solve(new int[]{1, 2, 3, 4, 5});
        out.println(c.equals(0));
    }

    public int solve(int[] nums) {

        int l1 = -1, r1 = -1, l2 = -1, r2 = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    l1 = i;
                    r1 = j;
                    break;
                }
            }
            if (l1 != -1)break;
        }

        if (l1 == -1) return 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    l2 = j;
                    r2 = i;
                    break;
                }
            }
            if (l2 != -1)break;
        }

        //if (l2 <= l1 && r1 <= r2) return r2 - l2 + 1;
        //if (l1 <= l2 && r2 <= r1) return r1 - l1 + 1;

        List<Integer> integers = Arrays.asList(l1, r1, l2, r2);
        integers.sort(Comparator.naturalOrder());

        return integers.get(3) - integers.get(0) + 1;

        /*for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                l1 = i;
                break;
            }
        }

        if (l1 != -1) {
            for (int i = l1 + 1; i < nums.length; i++) {
                if (nums[l1] > nums[i]) {
                    r1 = i;
                } else {
                    break;
                }
            }
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                r2 = i;
                break;
            }
        }

        if (r2 != -1) {
            for (int i = r2 - 1; i >= 0; i--) {
                if (nums[r2] < nums[i]) {
                    l2 = i;
                } else {
                    break;
                }
            }
        }

        if (l1 == -1) return 0;

        if (l2 <= l1 && r1 <= r2) return r2 - l2 + 1;
        if (l1 <= l2 && r2 <= r1) return r1 - l1 + 1;

        List<Integer> integers = Arrays.asList(l1, r1, l2, r2);
        integers.sort(Comparator.naturalOrder());

        return integers.get(3) - integers.get(0) + 1;*/
    }
}