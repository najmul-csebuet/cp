package Leetcode.Category.Array.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P1346 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P1346 s = new P1346();

        l.add(s.checkIfExist(new int[] {1,2,3,4}) == true);
        //l.add(Arrays.equals(s.solution(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == (arr[j]*2) || arr[j] == (arr[i]*2)) {
                    return true;
                }
            }
        }
        return false;
    }
}