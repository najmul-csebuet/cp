package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P532 {

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

        P532 s = new P532();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.P532(new int[]{3, 1, 4, 1, 5}, 2) == 2);
        l.add(s.P532(new int[]{1, 2, 3, 4, 5}, 1) == 4);
        l.add(s.P532(new int[]{1, 2, 3, 4, 5}, -1) == 4);
        l.add(s.P532(new int[]{1, 3, 1, 5, 4}, 0) == 1);
        l.add(s.P532(new int[]{1, 1, 1, 1, 1}, 0) == 1);
        l.add(s.P532(new int[]{1, 1, 2, 2, 3, 3}, 0) == 3);
        l.add(s.P532(new int[]{1, 1, -2, -2, 3, 3}, 0) == 3);
        l.add(s.P532(new int[]{1, 3, -1, -2, 3, 3}, 2) == 2);

        checkTestCases(l);
    }

    public int P532(int[] nums, int k) {

        if (k < 0) return 0;

        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Integer> mapFreq = new HashMap<>();
        Map<Integer, ArrayList<Integer>> pairList = new HashMap<>();

        for (int a : nums) {
            map.put(a, true);
            mapFreq.put(a, mapFreq.getOrDefault(a, 0) + 1);
        }

        int ans = 0;

        if (k == 0) {
            for (int a : mapFreq.keySet()) {
                if (mapFreq.get(a) > 1) ++ans;
            }
            return ans;
        }

        for (int a : map.keySet()) {
            if (map.getOrDefault(a - k, false)) {
                ArrayList<Integer> list = pairList.getOrDefault(a - k, new ArrayList<>());
                if (list.contains(a)) continue;
                ++ans;
                ArrayList<Integer> list1 = pairList.getOrDefault(a, new ArrayList<>());
                list1.add(a - k);
                pairList.put(a, list1);
            }

            if (map.getOrDefault(a + k, false)) {
                ArrayList<Integer> list = pairList.getOrDefault(a + k, new ArrayList<>());
                if (list.contains(a)) continue;
                ++ans;
                ArrayList<Integer> list1 = pairList.getOrDefault(a, new ArrayList<>());
                list1.add(a + k);
                pairList.put(a, list1);
            }
        }

        return ans;
    }
}