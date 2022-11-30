package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P69 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P69 o = new P69();

        l.add(o.mySqrt(4) == 2);
        l.add(o.mySqrt(8) == 2);
        l.add(o.mySqrt(0) == 0);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}