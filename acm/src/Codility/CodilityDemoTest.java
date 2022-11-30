package Codility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CodilityDemoTest {

    public static void main(String[] args) throws IOException {

        CodilityDemoTest s = new CodilityDemoTest();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{1, 3, 6, 4, 1, 2}) == 5);
        l.add(s.solution(new int[]{1, 2, 3}) == 4);
        l.add(s.solution(new int[]{-1, -3}) == 1);

        checkTestCases(l);
    }

    private static void checkTestCases(ArrayList<Boolean> l) {
        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            Boolean result = l.get(i);
            if (!result) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        if (allPassed) {
            System.out.println("All Test Cases Passed!");
        }
    }

    public int solution(int[] A) {

        Arrays.sort(A);

        int expected = 1;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < 1) continue;
            if (A[i] != expected) break;

            if (i + 1 == A.length || A[i + 1] != expected) {
                ++expected;
            }
        }

        return expected;
    }
}