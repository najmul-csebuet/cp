package Codeforces.Easy_Problems_Bootcamp.day8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class P72 {
    private static FastIO io;

    private static void solution() {
        // Also AC
        var T = io.next();
        StringBuilder pt = new StringBuilder(), wat = new StringBuilder();
        char[] chars = T.toCharArray();
        for (char ch : chars) {
            if (ch != 'a') wat.append(ch);
            pt.append(ch);
            if ((pt.length() + wat.length() == T.length()) && (pt + wat.toString()).equals(T)) {
                io.println(pt);
                return;
            }
        }
        io.println(":(");
    }

    private static void solutionAC() {
        var T = io.next();
        int[] map = new int[26];
        for (char ch : T.toCharArray()) map[ch - 'a']++;
        int sum = 0;
        for (int i = 1; i < 26; ++i) sum += map[i];
        if (sum % 2 == 1) {
            io.println(":(");
            return;
        }

        if (sum == 0) {
            io.println(T);
            return;
        }

        int half = sum / 2;
        int i = T.length() - 1;
        for (; i >= 0; --i) {
            if (T.charAt(i) == 'a') break;
            --half;
            if (half == 0) break;
        }

        if (i < 0 || (T.charAt(i) == 'a' && half > 0)) {
            io.println(":(");
            return;
        }

        var aa = T.substring(0, i);
        var bb = T.substring(i);

        if (aa.replaceAll("a", "").equals(bb)) {
            io.println(aa);
        } else {
            io.println(":(");
        }
    }

    public static void main(String[] args) throws IOException {
        io = FastIO.getFastIO();
        int totalTC = FastIO.fileInOut ? io.nextInt() : 1;
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
            fileInOut = !P72.class.getPackage().getName().isEmpty();
            var io = new FastIO(fileInOut);
            return io;
        }

        public static void verifyOutput() throws IOException {
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

        void print(int[] n, String separator) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                print(n[i] + separator);
            }
            println(n[n.length - 1]);
        }

        void reversePrint(int[] n, String separator) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                print(n[i] + separator);
            }
            println(n[0]);
        }

        void print(Integer[] n, String separator) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                print(n[i] + separator);
            }
            println(n[n.length - 1]);
        }

        void reversePrint(Integer[] n, String separator) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                print(n[i] + separator);
            }
            println(n[0]);
        }

        void print(List<Integer> n, String separator) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                print(n.get(i) + separator);
            }
            println(n.get(n.size() - 1));
        }

        void reversePrint(List<Integer> n, String separator) {
            if (n.size() == 0) return;
            for (int i = n.size() - 1; i > 0; i--) {
                print(n.get(i) + separator);
            }
            println(n.get(0));
        }
    }

    private static class Util {

        static int lower_bound(Integer[] arr, int l, int r, int X) {
            int mid;

            // Initialise starting index and
            // ending index
            int low = l;
            int high = r;

            // Till low is less than high
            while (low < high) {
                mid = low + (high - low) / 2;
                if (X > arr[mid]) {
                    // If X is greater arr[mid]
                    // then find in right subarray
                    low = mid + 1;
                } else {
                    // If X is less than or equal
                    // to arr[mid], then find in
                    // left subarray
                    high = mid;
                }
            }

            // if X is greater than arr[n-1]
            if (low <= r && arr[low] < X) {
                low++;
            }

            // Return the lower_bound index
            return low;
        }

        // tested ok
        static int upper_bound(Integer[] arr, int l, int r, int X) {
            int mid;

            // Initialise starting index and
            // ending index
            int low = l;
            int high = r;

            // Till low is less than high
            while (low < high) {
                // Find the middle index
                mid = low + (high - low) / 2;

                // If X is greater than or equal
                // to arr[mid] then find
                // in right subarray
                if (X >= arr[mid]) {
                    low = mid + 1;
                }

                // If X is less than arr[mid]
                // then find in left subarray
                else {
                    high = mid;
                }
            }

            // if X is greater than arr[n-1]
            if (low <= r && arr[low] <= X) {
                low++;
            }

            // Return the upper_bound index
            return low;
        }

        static List<Integer> getPrimeNumbers(int n) {
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
