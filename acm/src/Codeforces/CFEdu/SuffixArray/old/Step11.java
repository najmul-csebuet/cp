package Codeforces.CFEdu.SuffixArray.old;

import java.util.*;

public class Step11 {

    static class Pair implements Comparable<Pair> {

        public char ch;
        public int index;

        public Pair(char charAt, int index) {
            this.ch = charAt;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return ch - o.ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        new Step11().solve(s);
    }

    private void solve(String s) {

        s += '$';
        int n = s.length();

        List<Pair> a = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) a.add(new Pair(s.charAt(i), i));
        Collections.sort(a);

        int[] p = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < a.size(); i++) {
            p[i] = a.get(i).index;
        }

        c[p[0]] = 0;

        for(int i = 1; i < n; ++i) {
            if(a.get(i).compareTo(a.get(i - 1)) == 0) {
                c[p[i]] = c[p[i-1]];
            }
            else {
                c[p[i]] = c[p[i-1]] + 1;
            }
        }

        // Now transition from k to k + 1
        int k = 0;
        while((1 << k) < n) {
            // This loop will run log(n) times

            List<List<Integer>> aList = new ArrayList<>();

            for(int i = 0; i < n; ++i) {
                List<Integer> l = new ArrayList<>();
                l.add(c[i]);
                l.add(c[(i + (1 << k)) % n]);
                l.add(i);
                aList.add(l);
            }

            aList.sort((a1, a2) -> {
                if (a1.get(0) < a2.get(0)) return -1;
                if (a1.get(0) > a2.get(0)) return +1;
                return a1.get(1) - a2.get(1);
            });

            //p.clear();
            //c.clear();

            for (int i = 0; i < aList.size(); i++) {
                p[i] = aList.get(i).get(2);
            }


            c[p[0]] = 0;

            for(int i = 1; i < n; ++i) {
                if(aList.get(i).get(0).equals(aList.get(i - 1).get(0)) && aList.get(i).get(1).equals(aList.get(i - 1).get(1))) {
                    c[p[i]] = c[p[i-1]];
                }
                else {
                    c[p[i]] = c[p[i-1]] + 1;
                }
            }
            ++k;
        }

        for(int i = 0; i < p.length - 1; ++i) {
            System.out.print(p[i] + " ");
        }

        System.out.println(p[p.length - 1]);
    }
}
