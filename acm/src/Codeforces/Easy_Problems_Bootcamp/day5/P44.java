package Codeforces.Easy_Problems_Bootcamp.day5;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class P44 {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !P44.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int N = io.nextInt();
            new P44().solution(N);
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

    public void solution(int n) {
        /*
            1 = 1

            2 = 1 + 1
              = 2

            3 = 1 + 1 + 1
              = 1 + 2
              = 2 + 1

            4 = 1 + 1 + 1 + 1
              = 1 + 1 + 2
              = 1 + 2 + 1
              = 2 + 1 + 1
              = 2 + 2

            5 = 1 + 1 + 1 + 1 + 1 (1)
              = 1 + 1 + 1 + 2 (4)
              = 1 + 2 + 2
              = 2 + 1 + 2
              = 2 + 2 + 1
            6 = 1 + 1 + 1 + 1 + 1 + 1 (1)
              = 1 + 1 + 1 + 1 + 2 (5)
              = 1 + 1 + 2 + 2 ()
              = 1 + 2 + 1 + 2
              = 1 + 2 + 2 + 1
              = 2 + 1 + 2 + 1
              = 2 + 2 + 1 + 1
              = 2 + 1 + 1 + 2
              = 2 + 2 + 2
         */
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        io.println(b);
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
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

        int[] nextInts() {
            int N = nextInt();
            return nextInts(N);
        }

        int[] nextInts(int N) {
            var res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        void print(int[] n) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                io.print(n[i] + " ");
            }
            io.println(n[n.length - 1]);
        }

        void reversePrint(int[] n) {
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
