package Codility.Lessons.L4;

import java.io.*;
import java.util.*;

public class FrogRiverOne {

    public static void main(String[] args) throws IOException {

        FrogRiverOne s = new FrogRiverOne();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{}) == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

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

        return 0;
    }
}