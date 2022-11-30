package Codility.Lessons.L3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) throws IOException {

        PermMissingElem s = new PermMissingElem();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{2, 3, 1, 5}) == 4);
        l.add(s.solution(new int[]{}) == 1);

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

        if (A.length == 0) return 1;

        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {
            if (i != A[i - 1]) {
                return i;
            }
        }

        return A.length + 1;
    }
}