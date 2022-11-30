package Codility.Lessons.L3;

import java.io.*;
import java.util.*;

public class TapeEquilibrium {

    public static void main(String[] args) throws IOException {

        TapeEquilibrium s = new TapeEquilibrium();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{3, 1, 2, 4, 3}) == 1);
        l.add(s.solution(new int[]{-1000, 1000}) == 2000);

        checkTestCases(l);
    }

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        System.out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public int solution(int[] A) {

        int[] prefixSumArray = AlgoHelper.getPrefixSumArray(A);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            int first = prefixSumArray[i];
            int second = prefixSumArray[A.length - 1] - first;
            minDiff = Math.min(minDiff, Math.abs(first - second));
        }

        return minDiff;
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
                        return i;
                    }
                }
            }

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
                System.out.print(array[i] + " ");
            }

            System.out.println(array.length > 0 ? array[array.length - 1] : "");
        }
    }
}