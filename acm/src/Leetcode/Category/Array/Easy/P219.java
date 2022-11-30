package Leetcode.Category.Array.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P219 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P219 s = new P219();

        l.add(s.containsNearbyDuplicate(new int[] {1,2,3,4,5,1}, 2) == true);
        //l.add(Arrays.equals(s.solution(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}