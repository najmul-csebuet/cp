package Algorithm.SlidingWindow;

import java.io.*;
import java.util.*;

public class ExistsSumInArray {

    public boolean solution(int[] A, int targetSum) {

        int localSum = 0;
        int back = 0;

        for (int i = 0; i < A.length; i++) {

            localSum += A[i];

            while (localSum > targetSum) {
                localSum -= A[back];
                ++back;
            }

            if (localSum == targetSum)return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Case 1: " + (new ExistsSumInArray().solution(new int[]{13,14,6,2,7,4,1,3,6}, 12) == true));
        System.out.println("Case 2: " + (new ExistsSumInArray().solution(new int[]{13,14,6,2,7,4,1,3,6}, 13) == true));
    }
}