package Codility.Lessons.L12.CommonPrimeDivisors;

import java.io.*;
import java.util.*;

public class Solution {

    public int solution(int[] A, int[] B) {

        int maxNumber = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            maxNumber = Math.max(maxNumber, Math.max(a, b));
        }

        ArrayList<Integer> primesUptoLargestNumber = AlgoHelper.getPrimesUpto(maxNumber);

        int ans = 0;

        for (int i = 0; i < A.length; i++) {

            int a = A[i];
            int b = B[i];

            List<PrimeDivisor> primeDivisorsOfa = AlgoHelper.getPrimeDivisorsOf(a, primesUptoLargestNumber);
            List<PrimeDivisor> primeDivisorsOfb = AlgoHelper.getPrimeDivisorsOf(b, primesUptoLargestNumber);

            if (primeDivisorsOfa.size() != primeDivisorsOfb.size()) {
                continue;
            }

            Boolean flag = true;
            for (int j = 0; j < primeDivisorsOfa.size(); j++) {
                if (primeDivisorsOfa.get(j).divisor != primeDivisorsOfb.get(j).divisor) {
                    flag = false;
                    break;
                }
            }

            if (flag)++ans;
        }

        out.println(ans);
        return ans;
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

        static List<PrimeDivisor> getPrimeDivisorsOf(int n, ArrayList<Integer> primeList) {

            List<PrimeDivisor> divisorList = new ArrayList<>();
            int sqrt = (int) Math.sqrt(n);

            for (int i = 0; i < primeList.size() && primeList.get(i) <= sqrt; i++) {

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
            int compositeCount = 2;

            int i = 2;
            while (i * i <= n) {
                if (sieve[i]) {
                    ++i;
                    continue;
                }
                int k = i * i;
                while (k <= n) {
                    sieve[k] = true;
                    ++compositeCount;
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

        static int getMaxProfit(int[] A) {

            if (A.length < 2) {
                return 0;
            }

            int maxProfit = 0;
            int minPurchasePrice = A[0];

            for (int i = 1; i < A.length; i++) {
                if (minPurchasePrice > A[i]) {
                    minPurchasePrice = A[i];
                } else {
                    maxProfit = Math.max(maxProfit, A[i] - minPurchasePrice);
                }
            }

            return maxProfit;
        }

        static int getMaxSum(int[] A) {

            int localSum = 0;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < A.length; i++) {
                localSum = Math.max(0, localSum + A[i]);
                maxSum = Math.max(maxSum, localSum);
            }

            return maxSum;
        }

        static int getMaxSumNonEmptySlice(int[] A) {

            int localSum = 0;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < A.length; i++) {
                localSum = Math.max(A[i], localSum + A[i]);
                maxSum = Math.max(maxSum, localSum);
            }

            return maxSum;
        }

        static int getLeader(int[] A) {

            Map<Integer, Integer> map = new HashMap<>();
            for (int a : A) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            int maxValue = -1;
            int maxKey = -1;

            for (int key : map.keySet()) {
                if (map.get(key) > maxValue) {
                    maxKey = key;
                    maxValue = map.get(key);
                }
            }

            if ((maxValue << 1) > A.length) {

                for (int i = 0; i < A.length; i++) {
                    if (A[i] == maxKey) {
                        out.println(i);
                        return i;
                    }
                }
            }

            out.println(-1);
            return -1;
        }

        static HashSet<Integer> getSetFromArray(int[] A) {
            HashSet<Integer> mySet = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                mySet.add(A[i]);
            }
            return mySet;
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

        static void printArray(int[] array) {

            for (int i = 0; i < array.length - 1; i++) {
                out.print(array[i] + " ");
            }

            if (array.length > 0)
                out.println(array[array.length - 1]);
            else
                out.println();
        }
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = Solution.class.getPackage() != null;
        sc = getScanner(fileInOut);
        try {
            out = getPrintWriter(fileInOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner getScanner(boolean fileInOut) {
        return new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
    }

    private static PrintWriter getPrintWriter(boolean fileInOut) throws FileNotFoundException {
        return new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;
        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            int aLength = sc.nextInt();
            int[] a = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            int[] b = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                b[aIndex] = sc.nextInt();
            }

            new Solution().solution(a, b);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(Solution.class.getResource("ans.txt").getFile()));
            BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            boolean areEqual = true;
            int lineNum = 1;

            while (line1 != null || line2 != null) {

                if (line1 == null || line2 == null) {

                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {

                    areEqual = false;
                    break;
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();

                lineNum++;
            }

            if (areEqual) {

                System.out.println("All Test Cases Passed !");
            } else {

                System.out.println("Output differ at line " + lineNum);
                System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
            }

            reader1.close();
            reader2.close();
        }
    }
}
