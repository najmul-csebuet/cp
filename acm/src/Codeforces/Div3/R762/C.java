package Codeforces.Div3.R762;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class C {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !C.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = io.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            String A = io.next();
            String Sum = io.next();
            new C().solution(A, Sum);
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

    public void solution(String a, String sum) {
        char[] A = a.toCharArray();
        char[] Sum = sum.toCharArray();

        String ans = "";
        int i = A.length - 1;
        int j = Sum.length - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] <= Sum[j]) {
                int i1 = Sum[j] - A[i];
                ans = i1 + ans;
                j--;
            } else {
                if (j == 0) {
                    io.println("-1");
                    return;
                }

                int s1 = 10 * charToInt(Sum[j - 1]) + Sum[j] - A[i];
                if (charToInt(Sum[j - 1]) >= 2 || s1 >= 10 || s1 < 0) {
                    io.println("-1");
                    return;
                }
                ans = s1 + ans;
                j -= 2;
            }
            --i;
        }

        while (j >= 0) {
            ans = Sum[j] + ans;
            --j;
        }

        while (i >= 0) {
            if (A[i] != '0') {
                io.println("-1");
                return;
            }
            --i;
        }

        ans = ans.replaceFirst("^0*", "");
        io.println(ans);
    }

    private int charToInt(char Sum) {
        return Sum - '0';
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
