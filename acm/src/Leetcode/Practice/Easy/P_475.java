package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P_475 {

    public static void main(String[] args) throws IOException {

        List<Boolean> l = new ArrayList<>();
        P_475 o = new P_475();

        l.add(o.s(new int[]{1, 2, 3, 5, 15, 30, 31}, new int[]{2, 30}) == 13);
        l.add(o.s(new int[]{1, 5}, new int[]{10}) == 9);
        l.add(o.s(new int[]{1, 5}, new int[]{2}) == 3);
        l.add(o.s(new int[]{1, 2, 3}, new int[]{2}) == 1);
        l.add(o.s(new int[]{1, 2, 3, 4}, new int[]{1, 4}) == 1);
        l.add(o.s(new int[]{1, 3, 6}, new int[]{4}) == 3);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public int s(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = Integer.MIN_VALUE;

        for (int house : houses) {

            //Find most nearer heater to this house
            int binarySearch = Arrays.binarySearch(heaters, house);
            if (binarySearch >= 0) {
                radius = Math.max(radius, 0);
                continue;
            }

            binarySearch = -binarySearch -1;
            if (binarySearch == 0) {
                radius = Math.max(radius, heaters[binarySearch] - house);
            }
            else if (binarySearch == heaters.length) {
                radius = Math.max(radius, house - heaters[binarySearch - 1]);
            }
            else {
                int m = Math.min(house - heaters[binarySearch - 1], heaters[binarySearch] - house);
                radius = Math.max(radius, m);
            }

        }

        return radius;
    }
}