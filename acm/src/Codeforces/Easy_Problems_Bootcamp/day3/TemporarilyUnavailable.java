package Codeforces.Easy_Problems_Bootcamp.day3;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class TemporarilyUnavailable {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !TemporarilyUnavailable.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = io.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            Integer A = io.nextInt();
            Integer B = io.nextInt();
            Integer C = io.nextInt();
            Integer R = io.nextInt();

            new TemporarilyUnavailable().solution(A, B, C, R);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else {
                for (int i = 0; i < ansFileText.length; i++) {
                    if (i >= outFileText.length) {
                        System.out.println("<NO OUTPUT> ------> " + ansFileText[i]);
                    } else if (!ansFileText[i].equals(outFileText[i])) {
                        System.out.println(outFileText[i] + " ------> " + ansFileText[i]);
                    } else {
                        System.out.println(outFileText[i]);
                    }
                }
            }
        }
    }

    public void solution(Integer a, Integer b, Integer c, Integer r) {
        // ensure a <= b
        int t1 = Math.min(a, b);
        int t2 = Math.max(a, b);
        a = t1;
        b = t2;
        // So now a <= b
        int ns = Math.max(a, c - r);
        int ne = Math.min(b, c + r);

        int ans = b - a - Math.max(0, ne - ns);
        io.println(ans);
    }

    public void solution1(Integer a, Integer b, Integer c, Integer r) {
        // ensure a <= b
        int t1 = Math.min(a, b);
        int t2 = Math.max(a, b);
        a = t1;
        b = t2;
        // So now a <= b
        int totalPointFromAtoB = b - a + 1;

        if (a <= c && c <= b) {
            // So c is inside
            // find effective l and r of network of C
            int left = Math.max(c - r, a);
            int right = Math.min(c + r, b);
            int p = right - left + 1;
            io.println(totalPointFromAtoB - p);
            return;
        }

        // find effective left network range _____C_____
        int el = 0;
        if (c > b && (c - r <= b)) {
            el = b - (c - r) + 1;
        }

        int er = 0;
        if (c < a && (c + r >= a)) {
            er = (c + r) - a + 1;
        }

        int x = el + er > 0 ? totalPointFromAtoB - el - er : totalPointFromAtoB - 1;
        io.println(Math.max(x, 0));
    }

    static class FastIO extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        public FastIO(boolean fileInOut) throws FileNotFoundException {
            super(fileInOut ? new FileOutputStream("out.txt") : System.out, true);
            br = new BufferedReader(new InputStreamReader(fileInOut ? new FileInputStream("in.txt") : System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer[] nextInts() {
            Integer N = nextInt();
            return nextInts(N);
        }

        Integer[] nextInts(Integer N) {
            var res = new Integer[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        void print(Integer[] n) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                io.print(n[i] + " ");
            }
            io.println(n[n.length - 1]);
        }

        void reversePrint(Integer[] n) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                io.print(n[i] + " ");
            }
            io.println(n[0]);
        }

        void print(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(n.size() - 1));
        }

        void reversePrint(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = n.size() - 1; i > 0; i--) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(0));
        }
    }
}

/*
for _ in range(int(input())):
    a, b, c, r = map(int, input().split())
    l = max(min(a, b), c - r)
    r = min(max(a, b), c + r)
    time = max(a, b) - min(a, b) - max(0, r - l)
    print(time)
 */
