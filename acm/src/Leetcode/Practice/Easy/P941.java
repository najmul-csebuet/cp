package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P941 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P941 o = new P941();

        l.add(o.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}) == false);
        l.add(o.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}) == false);
        l.add(o.validMountainArray(new int[]{}) == false);
        l.add(o.validMountainArray(new int[]{2, 1}) == false);
        l.add(o.validMountainArray(new int[]{3, 5, 5}) == false);
        l.add(o.validMountainArray(new int[]{0, 3, 2, 1}) == true);
        l.add(o.validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}) == true);
        l.add(o.validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}) == false);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public boolean validMountainArray(int[] A) {

        if (A.length < 3) return false;

        int max = 0;
        for (; max <= A.length - 3; max++) {
            if (A[max] == A[max + 1]) return false;
            if (A[max] > A[max + 1]) break;
        }

        if (max == 0) return false;

        for (; max < A.length - 1; max++) {
            if (A[max] <= A[max + 1]) return false;
        }

        return true;
    }
}