package mylib.SuffixArray;

import java.util.Arrays;

public class SuffixArray {

    int[] suffixArray(String S) {

        var s = (S + "$").toCharArray();
        int n = s.length;
        var p = new int[n];
        var c = new int[n];

        {
            var a = new SuffixPair[n];
            for (int i = 0; i < n; i++)
                a[i] = new SuffixPair(new int[]{s[i]}, i);
            Arrays.sort(a);

            for (int i = 0; i < n; i++)
                p[i] = a[i].second;

            c[p[0]] = 0;
            for (int i = 1; i < n; i++) {
                c[p[i]] = c[p[i - 1]];
                if (!Arrays.equals(a[i].first, a[i - 1].first)) {
                    c[p[i]] += 1;
                }
            }
        }

        int k = 0;
        while ((1 << k) < n) {
            // k -> k + 1
            var a = new SuffixPair[n];
            for (int i = 0; i < n; i++) {
                a[i] = new SuffixPair(new int[]{c[i], c[(i + (1 << k)) % n]}, i);
            }
            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                p[i] = a[i].second;
            }

            c[p[0]] = 0;
            for (int i = 1; i < n; i++) {
                c[p[i]] = c[p[i - 1]];
                if (!Arrays.equals(a[i].first, a[i - 1].first)) {
                    c[p[i]] += 1;
                }
            }
            ++k;
        }

        for (int i = 1; i < n; i++) {
            System.out.println(p[i] + " " + S.substring(p[i]));
        }

        return p;
    }

    static class SuffixPair implements Comparable<SuffixPair> {
        int[] first;
        int second;

        public SuffixPair(int[] items, int second) {
            this.first = items;
            this.second = second;
        }

        @Override
        public int compareTo(SuffixPair suffixPair) {
            for (int i = 0; i < first.length; i++) {
                if (first[i] != suffixPair.first[i]) {
                    return first[i] - suffixPair.first[i];
                }
            }
            return second - suffixPair.second;
        }
    }

    public static void main(String[] args) {
        SuffixArray suffixArray = new SuffixArray();
        int[] array = suffixArray.suffixArray("adasdas");
        // use this array for searching
    }
}
