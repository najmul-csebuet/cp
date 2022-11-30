package Codeforces.Easy_Problems_Bootcamp.day5;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class P43 {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !P43.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            new P43().solution(io.nextInt());
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

    public void solution(int N) {
//        long ans = 0;
        long fact = 1;
        for (int i = 1; i <= N; i++) {
            fact *= i;
        }

        /*for (int i = 1; i < N; i++) {
            ans += (fact / (i * (i + 1)));
        }

        ans += (fact / (N * (1)));*/

        io.println(fact);
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

    static class Util {

        public static List<Integer> getPrimeNumbers(int n) {
            if (n < 2) return Collections.emptyList();

            var isComposite = new boolean[n + 1];

            for (int j = 2 * 2; j <= n; j += 2) isComposite[j] = true;

            for (int i = 3; i * i <= n; i += 2) {
                if (isComposite[i]) continue;
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(2);
            for (int i = 3; i <= n; i += 2) {
                if (!isComposite[i]) list.add(i);
            }

            return list;
        }

        static int[] getPrefixSumArray(int[] A) {

            int[] prefixSum = new int[A.length];
            prefixSum[0] = A[0];
            for (int i = 1; i < A.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            }

            return prefixSum;
        }

        static int[] getSuffixSumArray(int[] A) {

            int[] suffixSum = new int[A.length];
            suffixSum[A.length - 1] = A[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + A[i];
            }

            return suffixSum;
        }

        public static int hex2Decimal(String s) {
            String digits = "0123456789ABCDEF";
            s = s.toUpperCase();
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int d = digits.indexOf(c);
                val = 16 * val + d;
            }
            return val;
        }

        // precondition:  d is a nonnegative integer
        public static String decimal2Hex(int d) {
            String digits = "0123456789ABCDEF";
            if (d == 0) return "0";
            String hex = "";
            while (d > 0) {
                int digit = d % 16;                // rightmost digit
                hex = digits.charAt(digit) + hex;  // string concatenation
                d = d / 16;
            }
            return hex;
        }

        static int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }

        static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        static int gcd(List<Integer> list) {
            int ans = 1;
            for (int i = 0; i < list.size(); i++) {
                ans = gcd(ans, list.get(i));
            }
            return ans;
        }

        static int lcm(List<Integer> list) {
            int ans = 1;
            for (int i = 0; i < list.size(); i++) {
                ans = lcm(ans, list.get(i));
            }
            return ans;
        }
    }
}
