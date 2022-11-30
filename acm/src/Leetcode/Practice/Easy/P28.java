package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P28 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P28 o = new P28();

        l.add(o.strStr("", "ad") == -1);
        l.add(o.strStr("", "") == 0);
        l.add(o.strStr("hello", "") == 0);
        l.add(o.strStr("hello", "ll") == 2);
        l.add(o.strStr("aaaaa", "bba") == -1);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}