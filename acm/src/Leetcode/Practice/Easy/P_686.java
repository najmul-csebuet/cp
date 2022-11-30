package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P_686 {

    public static void main(String[] args) throws IOException {
        Integer c;

        c = new P_686().repeatedStringMatch("abaabaa", "abaababaab");
        out.println(c.equals(-1));

        c = new P_686().repeatedStringMatch("abcd", "cdabcdab");
        out.println(c.equals(3));

        c = new P_686().repeatedStringMatch("abcd", "zcdabcdab");
        out.println(c.equals(-1));

        c = new P_686().repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba");
        out.println(c.equals(2));

        c = new P_686().repeatedStringMatch("bb", "bbbbbbb");
        out.println(c.equals(4));
    }

    public int repeatedStringMatch(String A, String B) {

        int k = B.length() / A.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(A);
        }

        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(B) >= 0)return k + i;
            sb.append(A);
        }

        return -1;
    }
}