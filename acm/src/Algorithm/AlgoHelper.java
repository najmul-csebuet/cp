package Algorithm;

import java.io.PrintWriter;
import java.util.*;

class AlgoHelper {

    public static Map<Integer, Integer> getFreqMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : list) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map;
    }

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
        if (inputSet.size() < inputList.size())
            return true;
        return false;
    }

    public static boolean checkDuplicate(int[] input) {
        List inputList = Arrays.asList(input);
        Set inputSet = new HashSet(inputList);
        if (inputSet.size() < inputList.size())
            return true;
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

    static void printArray(PrintWriter out, int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            out.print(array[i] + " ");
        }

        out.println(array.length > 0 ? array[array.length - 1] : "");
    }
}

class PrimeDivisor {

    Integer divisor;
    Integer power;

    public PrimeDivisor(int divisor, Integer power) {
        this.divisor = divisor;
        this.power = power;
    }
}
