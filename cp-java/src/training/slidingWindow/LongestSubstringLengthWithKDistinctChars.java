package training.slidingWindow;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class LongestSubstringLengthWithKDistinctChars {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new LongestSubstringLengthWithKDistinctChars();

        /*l.add(s.solution("AAAHHIBC", 2) == 5);
        l.add(s.solution("AAAHHIBC", 3) == 6);
        l.add(s.solution("AAAHHIBC", 1) == 3);*/
        l.add(s.solution("AAAHHIBC", 5) == 8);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(String s, int k) {

        var longestLength = 0;
        var hm = new MyHashMap<Character, Integer>();

        for (int end = 0, start = 0; end < s.length(); end++) {

            var c = s.charAt(end);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            longestLength = Math.max(longestLength, end - start + 1);

            if ((hm.size() <= k)) {
                continue;
            }

            while (hm.size() > k) {
                var startChar = s.charAt(start++);
                hm.put(startChar, hm.get(startChar) - 1);
                if (hm.get(startChar) == 0) {
                    hm.remove(startChar);
                }
            }
        }

        return longestLength;
    }

    static class MyHashMap<T1, T2> extends HashMap<T1, T2> {

    }
}