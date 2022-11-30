package mylib;

public class PrefixSumSuffixSum {
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
}
