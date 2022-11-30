package Algorithm.SlidingWindow;

import java.io.*;
import java.util.*;

public class MaxSumOfArrSizeK {

    public int solution(int[] A, int K) {

        int max = Integer.MIN_VALUE;
        int runningSum = 0;

        for (int i = 0; i < A.length; i++) {
            runningSum += A[i];
            if (i < K - 1)continue;
            max = Math.max(max, runningSum);
            runningSum -= A[i - K + 1];
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Case 1: " + (new MaxSumOfArrSizeK().solution(new int[]{4,2,1,7,8,1,2,8,1,0}, 3) == 16));
        System.out.println("Case 2: " + (new MaxSumOfArrSizeK().solution(new int[]{4,2,1,7,8,1,2,8,1,0}, 4) == 19));
    }
}