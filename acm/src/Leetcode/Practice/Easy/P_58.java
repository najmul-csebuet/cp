package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P_58 {

    public static void main(String[] args) throws IOException {
        Integer c;

        c = new P_58().lengthOfLastWord("Hello World");
        out.println(c.equals(5));

        c = new P_58().lengthOfLastWord("Hello World   d");
        out.println(c.equals(1));

        c = new P_58().lengthOfLastWord("");
        out.println(c.equals(0));

        c = new P_58().lengthOfLastWord("a");
        out.println(c.equals(1));
    }

    public int lengthOfLastWord(String s) {

        int first = s.length() - 1;
        for (; first >= 0; first--) {
            if (Character.isAlphabetic(s.charAt(first))) {
                break;
            }
        }

        if (first == -1)return 0;

        int second = first - 1;
        for (; second >= 0; second--) {
            char ch = s.charAt(second);
            if (Character.isSpaceChar(ch)) {
                break;
            }
        }

        if (second == -1)return first + 1;

        return first - second;
    }
}