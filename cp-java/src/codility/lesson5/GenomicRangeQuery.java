package codility.lesson5;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class GenomicRangeQuery {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new GenomicRangeQuery();

        // for array compare
        l.add(Arrays.equals(s.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}), new int[]{2, 4, 1}));
        l.add(Arrays.equals(s.solution("T", new int[]{0, 0, 0}, new int[]{0, 0, 0}), new int[]{4, 4, 4}));


        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int[] solution(String S, int[] P, int[] Q) {

        var count = new Count[S.length() + 1];
        count[0] = new Count(0, 0, 0, 0);
        for (int i = 1; i < count.length; i++) {
            count[i] = new Count(count[i - 1], S.charAt(i - 1));
        }

        var ans = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            var x = P[i];
            var y = Q[i];
            Count diff = count[y + 1].minus(count[x]);
            if (diff.a > 0) ans[i] = 1;
            else if (diff.c > 0) ans[i] = 2;
            else if (diff.g > 0) ans[i] = 3;
            else if (diff.t > 0) ans[i] = 4;
        }
        return ans;
    }

    static class Count {
        int a, c, g, t;

        public Count(Count count, char ch) {
            a = count.a;
            c = count.c;
            g = count.g;
            t = count.t;

            switch (ch) {
                case 'A':
                    a++;
                    break;
                case 'C':
                    c++;
                    break;
                case 'G':
                    g++;
                    break;
                case 'T':
                    t++;
            }
        }

        public Count(int a, int c, int g, int t) {
            this.a = a;
            this.c = c;
            this.g = g;
            this.t = t;
        }

        public Count minus(Count c) {
            var diff = new Count(a - c.a, this.c - c.c, g - c.g, t - c.t);
            return diff;
        }
    }
}