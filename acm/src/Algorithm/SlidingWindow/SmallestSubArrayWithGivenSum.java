package Algorithm.SlidingWindow;

import java.io.*;
import java.util.*;

public class SmallestSubArrayWithGivenSum {

    public int solution(int[] A, int sum) {
        return 0;
    }

    public static void main(String[] args) throws IOException {

        SmallestSubArrayWithGivenSum obj = new SmallestSubArrayWithGivenSum();
        int[] array = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        System.out.println("Case 1: " + (obj.solution(array, 8) == 1));
        System.out.println("Case 2: " + (obj.solution(array, 19) == 4));
    }
}