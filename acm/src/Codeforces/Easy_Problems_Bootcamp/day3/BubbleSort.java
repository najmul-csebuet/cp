package Codeforces.Easy_Problems_Bootcamp.day3;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class BubbleSort {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !BubbleSort.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int[] A = io.nextInts();
            new BubbleSort().solution(A);
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

    public void solution(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    //a[j] ^= a[j + 1] ^= a[j];
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }

            io.print(a);
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
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
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

        void print(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(n.size() - 1));
        }
    }
}
