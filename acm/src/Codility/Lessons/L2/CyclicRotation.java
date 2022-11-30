package Codility.Lessons.L2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) throws IOException {

        CyclicRotation s = new CyclicRotation();
        ArrayList<Boolean> l = new ArrayList<>();

        //Define Test Cases
        l.add(Arrays.equals(s.solution(new int[]{3, 8, 9, 7, 6}, 3), new int[]{9, 7, 6, 3, 8}));
        l.add(Arrays.equals(s.solution(new int[]{0, 0, 0}, 1), new int[]{0, 0, 0}));
        l.add(Arrays.equals(s.solution(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4}));

        //Checking
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

    public int[] solution(int[] A, int K) {

        if (A.length == 0 || K % A.length == 0) {
            return A;
        }

        K %= A.length;

        int[] ans = new int[A.length];

        int index = -1;
        for (int i = A.length - K; i < A.length; i++) {
            ans[++index] = A[i];
        }

        for (int i = 0; i < A.length - K; i++) {
            ans[++index] = A[i];
        }

        return ans;
    }
}