package Codeforces.CFEdu.SuffixArray.old;

import java.io.*;
import java.util.*;

public class SuffixArray {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean testLocally = !SuffixArray.class.getPackage().getName().isEmpty();
        out = new PrintWriter(new BufferedOutputStream(testLocally ? new FileOutputStream("out.txt") : System.out), true);

        if (testLocally) {
            List<Boolean> l = new ArrayList<>();
            SuffixArray s = new SuffixArray();

            l.add(Arrays.equals(s.solution("ababba"), new int[]{6, 5, 0, 2, 4, 1, 3}));

            if (!l.contains(false)) System.out.println("All Test Cases Passed.");
            else for (int i = 0; i < l.size(); i++) if (!l.get(i)) System.out.println("Case " + (i + 1) + ": Failed");
        } else {
            sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int[] solution = new SuffixArray().solution(sc.next());
            for (int i = 0; i < solution.length; i++) {
                out.print(solution[i] + " ");
            }
            out.println();
        }
    }

    public int[] solution(String s) {
        s += "$";
        int n = s.length();
        var a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(s.charAt(i), i);
        }
        Arrays.sort(a);
        Arrays.sort(a, (p,q) -> p.a - q.b);

        var p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = a[i].b;
        }

        var c = new int[n];
        c[p[0]] = 0;
        for (int i = 1; i < n; i++) {
            if(a[i].a == a[i-1].a) {
                c[p[i]] = c[p[i-1]];
            }
            else {
                c[p[i]] = c[p[i-1]] + 1;
            }
        }

        int k = 0;
        while((1 << k) < n) {
            var ar = new Triple[n];
            for (int i = 0; i < n; i++) {
                ar[i] = new Triple(new Pair(c[i], c[(i + (1 << k)) % n]), i);
            }
            Arrays.sort(ar);

            for (int i = 0; i < n; i++) {
                p[i] = ar[i].c;
            }

            c[p[0]] = 0;
            for (int i = 1; i < n; i++) {
                Pair pair = ar[i - 1].pair;
                Pair pair1 = ar[i].pair;
                if(pair.compareTo(pair1) == 0) {
                    c[p[i]] = c[p[i-1]];
                }
                else {
                    c[p[i]] = c[p[i-1]] + 1;
                }
            }

            ++k;
        }
        return p;
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if(a != o.a)
                return a - o.a;
            return b - o.b;
        }
    }

    static class Triple implements Comparable<Triple> {
        Pair pair;
        int c;

        public Triple(Pair pair, int index) {
            this.pair = pair;
            this.c = index;
        }

        @Override
        public int compareTo(Triple o) {
            int compareTo = pair.compareTo(o.pair);
            if(compareTo != 0)
                return compareTo;
            return c - o.c;
        }
    }
}
