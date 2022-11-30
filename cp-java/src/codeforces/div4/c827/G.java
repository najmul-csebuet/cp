package codeforces.div4.c827;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class G {
    private static FastIO io;

    private static void solution() {
        var ar = io.nextInts();
        Arrays.sort(ar, (a, b) -> {
            String bs1 = Integer.toBinaryString(a);
            String bs2 = Integer.toBinaryString(b);
            return bs2.length() - bs1.length();
        });
        io.print(ar);
    }

    public static void main(String[] args) throws IOException {
        io = FastIO.getFastIO();
        int totalTC = io.nextInt();
        //int totalTC = FastIO.fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) solution();
        FastIO.verifyOutput();
    }

    private static class FastIO extends PrintWriter {
        static boolean fileInOut;
        BufferedReader br;
        StringTokenizer st;

        public FastIO(boolean fileInOut) throws FileNotFoundException {
            super(fileInOut ? new FileOutputStream("out.txt") : System.out, true);
            br = new BufferedReader(new InputStreamReader(fileInOut ? new FileInputStream("in.txt") : System.in));
        }

        public static FastIO getFastIO() throws FileNotFoundException {
            fileInOut = !G.class.getPackage().getName().isEmpty();
            var io = new FastIO(fileInOut);
            return io;
        }

        public static void verifyOutput() throws IOException {
            if (!fileInOut) {
                return;
            }
            String[] ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText))
                System.out.println("ALL TEST CASES PASSED!");
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
            int N = nextInt();
            return nextInts(N);
        }

        Integer[] nextInts(int N) {
            var res = new Integer[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        void print(int[] n) {
            print(n, " ");
        }

        void print(int[] n, String separator) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                print(n[i] + separator);
            }
            println(n[n.length - 1]);
        }

        void reversePrint(int[] n) {
            reversePrint(n, " ");
        }

        void reversePrint(int[] n, String separator) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                print(n[i] + separator);
            }
            println(n[0]);
        }

        void print(Integer[] n) {
            print(n, " ");
        }

        void print(Integer[] n, String separator) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                print(n[i] + separator);
            }
            println(n[n.length - 1]);
        }

        void reversePrint(Integer[] n) {
            reversePrint(n, " ");
        }

        void reversePrint(Integer[] n, String separator) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                print(n[i] + separator);
            }
            println(n[0]);
        }

        void print(List<Integer> n) {
            print(n, " ");
        }

        void print(List<Integer> n, String separator) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                print(n.get(i) + separator);
            }
            println(n.get(n.size() - 1));
        }

        void reversePrint(List<Integer> n) {
            reversePrint(n, " ");
        }

        void reversePrint(List<Integer> n, String separator) {
            if (n.size() == 0) return;
            for (int i = n.size() - 1; i > 0; i--) {
                print(n.get(i) + separator);
            }
            println(n.get(0));
        }
    }
}
