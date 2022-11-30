package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.*;

public class buddyStrings {

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

    public static void main(String[] args) throws IOException {

        buddyStrings s = new buddyStrings();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.buddyStrings("ab", "ba"));
        l.add(s.buddyStrings("aa", "aa"));
        l.add(s.buddyStrings("abab", "abab"));
        l.add(s.buddyStrings("aaaaaaabc", "aaaaaaacb"));

        l.add(!s.buddyStrings("ab", "ab"));
        l.add(!s.buddyStrings("", "aa"));
        l.add(!s.buddyStrings("", ""));
        l.add(!s.buddyStrings("aa", ""));
        l.add(!s.buddyStrings("abcd", "badc"));

        checkTestCases(l);
    }

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length())return false;
        if (A.length() == 0)return false;

        HashMap<Character, Integer> map = new HashMap<>();

        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
            }
            for(Character ch: map.keySet()) {
                if (map.getOrDefault(ch, 0) >= 2) {
                    return true;
                }
            }
            return false;
        }

        //Now A and B is not equal
        int countUnequal = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                ++countUnequal;
                list.add(i);
            }
        }

        if (countUnequal != 2) return false;

        //Now there are 2 mismatch
        if (A.charAt(list.get(0)) != B.charAt(list.get(1)))return false;
        if (A.charAt(list.get(1)) != B.charAt(list.get(0)))return false;

        return true;
    }
}