package Codeforces.Easy_Problems_Bootcamp.day4;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class P35 {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !P35.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = io.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int H = io.nextInt();
            int M = io.nextInt();
            new P35().solution(H, M);
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

    public void solution(int h, int m) {
        int hour = 24 - h;
        io.println(hour * 60 - m);
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

    static class PrimeDivisor {

        Integer divisor;
        Integer power;

        public PrimeDivisor(int divisor, Integer power) {
            this.divisor = divisor;
            this.power = power;
        }
    }

    static class AlgoHelper {

        public static boolean checkDuplicateUsingAdd(String[] input) {
            Set tempSet = new HashSet();
            for (String str : input) {
                if (!tempSet.add(str)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean checkDuplicate(String[] input) {
            List inputList = Arrays.asList(input);
            Set inputSet = new HashSet(inputList);
            if (inputSet.size() < inputList.size()) return true;
            return false;
        }

        public static boolean checkDuplicate(int[] input) {
            List inputList = Arrays.asList(input);
            Set inputSet = new HashSet(inputList);
            if (inputSet.size() < inputList.size()) return true;
            return false;
        }

        public static void printMissingNumber(int[] numbers, int count) {
            int missingCount = count - numbers.length;
            BitSet bitSet = new BitSet(count);
            for (int number : numbers) {
                bitSet.set(number - 1);
            }
            System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
            int lastMissingIndex = 0;
            for (int i = 0; i < missingCount; i++) {
                lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
                System.out.println(++lastMissingIndex);
            }
        }

        public static String rotateLeft(String S, int amount) {

            amount %= S.length();
            StringBuilder sb = new StringBuilder(S + S);

            String substring = sb.substring(amount, amount + S.length());
            return substring;
        }

        public static String rotateRight(String S, int amount) {

            amount %= S.length();
            StringBuilder sb = new StringBuilder(S + S);

            String substring = sb.substring(S.length() - amount, S.length() - amount + S.length());
            return substring;
        }

        public static int reverseNumber(int x) {

            if (x == 0) return 0;
            boolean isNegative = x < 0;
            x = Math.abs(x);
            while (x % 10 == 0) {
                x /= 10;
            }

            long reversed = 0;
            while (x > 0) {
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }

            reversed = isNegative ? -reversed : reversed;
            return Math.abs(reversed) > Integer.MAX_VALUE ? 0 : (int) reversed;
        }

        static List<PrimeDivisor> getPrimeDivisorsOf(int n) {

            List<PrimeDivisor> divisorList = new ArrayList<>();
            ArrayList<Integer> primeList = AlgoHelper.getPrimesUpto((int) Math.sqrt(n));

            for (int i = 0; i < primeList.size(); i++) {

                int primeDivisor = primeList.get(i);
                if (n % primeDivisor != 0) continue;

                List<Integer> powerOf = AlgoHelper.getPowerOf(primeDivisor, n);
                n = powerOf.get(1);

                divisorList.add(new PrimeDivisor(primeDivisor, powerOf.get(0)));
            }

            if (n > 1) {
                //then it is a prime number.
                divisorList.add(new PrimeDivisor(n, 1));
            }

            return divisorList;
        }

        static int getDivisorCountImproved(int n) {

            int count = 1;
            ArrayList<Integer> primeList = AlgoHelper.getPrimesUpto((int) Math.sqrt(n));

            for (int i = 0; i < primeList.size(); i++) {
                int primeDivisor = primeList.get(i);
                if (n % primeDivisor != 0) continue;
                List<Integer> powerOf = AlgoHelper.getPowerOf(primeDivisor, n);
                count *= (powerOf.get(0) + 1);
                n = powerOf.get(1);
            }

            if (n > 1) {
                //then it is a prime number.
                count *= 2;
            }

            return count;
        }

        static int getDivisorCount(int N) {
            int i = 1;
            int result = 0;

            while (i * i < N) {
                if (N % i == 0) result += 2;
                ++i;
            }

            if (i * i == N) {
                ++result;
            }

            return result;
        }

        static List<Integer> getPowerOf(int divisor, int inN) {
            int count = 0;
            while (inN % divisor == 0) {
                ++count;
                inN /= divisor;
            }
            return Arrays.asList(count, inN);
        }

        static ArrayList<Integer> getPrimesUpto(int n) {

            boolean[] sieve = new boolean[n + 1];
            //true means composite / non prime
            //false means prime
            sieve[0] = sieve[1] = true;

            int i = 2;
            while (i * i <= n) {
                if (sieve[i]) {
                    ++i;
                    continue;
                }
                int k = i * i;
                while (k <= n) {
                    sieve[k] = true;
                    k += i;
                }
                ++i;
            }

            ArrayList<Integer> primeList = new ArrayList<>();

            for (int j = 0; j < sieve.length; j++) {
                if (!sieve[j]) {
                    primeList.add(j);
                }
            }

            return primeList;
        }
    }
}
