package Codeforces.Easy_Problems_Bootcamp.day3;

import Common.Verifier;

import java.io.*;
import java.util.*;

public class NewYearGarland {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !NewYearGarland.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = io.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int R = io.nextInt();
            int G = io.nextInt();
            int B = io.nextInt();
            new NewYearGarland().solution(R, G, B);
        }

        if (fileInOut) {
            Verifier.verify();
        }
    }

    public void solution(int r, int g, int b) {
        List<Integer> integers = Arrays.asList(r, g, b);
        Collections.sort(integers);
        if (1 + integers.get(0) + integers.get(1) >= integers.get(2)) {
            io.println("Yes");
        } else {
            io.println("No");
        }
    }

    public void solution1(int r, int g, int b) {
        // r g b r g b
        // r g r b g b
        var a = new ArrayList<Integer>();
        a.add(r);
        a.add(g);
        a.add(b);
        Collections.sort(a);
        // 10 5 5
        // rg rg rg rg rg rb rb rb rb rb
        // rgrb rgrb rgrb rgrb rgrbr
        // rgb + br
        // rbgrb + grbg = rgb rgb rgb
        Integer rgbTripleCount = a.get(0);
        a.set(1, a.get(1) - rgbTripleCount);
        a.set(2, a.get(2) - rgbTripleCount);
        a.remove(0);

        a.set(1, a.get(1) - a.get(0));
        a.remove(0);

        if (a.get(0) <= rgbTripleCount + 1) {
            io.println("Yes");
        } else {
            io.println("No");
        }
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
  a = list(map(int, input().split()))
  a.sort()
  print('No' if a[0] + a[1] - a[2] < -1 else 'Yes')
 */