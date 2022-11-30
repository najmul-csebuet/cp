package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

public class P605 {

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

        P605 s = new P605();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1) == true);
        l.add(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2) == false);
        l.add(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2) == false);
        l.add(s.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 3) == true);
        l.add(s.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 2) == true);
        l.add(s.canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 2) == true);
        l.add(s.canPlaceFlowers(new int[]{0, 1, 0, 0, 0}, 2) == false);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i >= 1 && flowerbed[i - 1] == 1) continue;
            if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) continue;
            ++ans;
            flowerbed[i] = 1;
        }
        return ans >= n;
    }
}