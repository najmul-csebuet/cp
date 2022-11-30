package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P914 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P914 o = new P914();

        l.add(o.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}) == true );
        l.add(o.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}) == true);
        l.add(o.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}) == false);
        l.add(o.hasGroupsSizeX(new int[]{1}) == false);
        l.add(o.hasGroupsSizeX(new int[]{1, 1}) == true);
        l.add(o.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}) == true);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    int gcd(List<Integer> list) {
        int ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans = gcd(ans, list.get(i));
        }
        return ans;
    }

    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : deck) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Find min freq count
        int min = Integer.MAX_VALUE;
        for (int a : map.keySet()) {
            min = Math.min(min, map.get(a));
        }

        if (min == 1) return false;

        /*for (int a : map.keySet()) {
            if (map.get(a) % min != 0) return false;
        }*/

        List<Integer> list = new ArrayList<>();
        for (int a : map.values()) {
            list.add(a);
        }

        int gcd = gcd(list);

        if (gcd > 1) return true;
        return false;
    }
}