package Codility.Interview.Medium;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution s = new Solution();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution("ABBBCCDDCCC", 3) == 5);
        l.add(s.solution("AAAAAAAAAAABXXAAAAAAAAAA", 3) == 3);
        l.add(s.solution("ABCDDDEFG", 2) == 6);

        checkTestCases(l);
    }

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

    String compress(String S) {

        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            int count = 1;
            int j = i + 1;
            for (; j < charArray.length; j++) {
                if (ch == charArray[j]) {
                    ++count;
                } else {
                    break;
                }
            }
            i = j - 1;

            if (count == 1) {
                sb.append(ch);
            } else {
                sb.append(count).append(ch);
            }
        }

        return sb.toString();
    }

    String compress(String S, int s, int e) {

        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (s <= i && i <= e) continue;
            char ch = charArray[i];
            int count = 1;
            int j = i + 1;
            for (; j < charArray.length; j++) {
                if (s <= j && j <= e) continue;
                if (ch == charArray[j]) {
                    ++count;
                } else {
                    break;
                }
            }
            i = j - 1;

            if (count == 1) {
                sb.append(ch);
            } else {
                sb.append(Integer.toString(count) + ch);
            }
        }

        return sb.toString();
    }

    public int solution(String S, int K) {

        if (K + 1 == S.length()) {
            return 1;
        }

        if (K == 0) {
            return compress(S).length();
        }

        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(S);

        for (int i = 0; i < S.length() - K; i++) {
//            StringBuilder replace = sb.replace(i, i + K, "");
//            String compressed = compress(replace.toString());
            String compressed = compress(sb.toString(), i, i + K - 1);
            min = Math.min(min, compressed.length());
        }
        // write your code in Java SE 8
        return min;
    }
}