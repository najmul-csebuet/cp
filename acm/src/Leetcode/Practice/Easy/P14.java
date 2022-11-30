package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P14 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P14 o = new P14();

        l.add(o.longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl"));
        l.add(o.longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals(""));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)return "";
        if (strs.length == 1)return strs[0];

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i)return ans.toString();
                char c = strs[j].charAt(i);
                if (ch != c)return ans.toString();
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}