package Codility.Lessons.L3;

import java.io.*;
import java.util.*;

public class FrogJmp {

    public static void main(String[] args) throws IOException {

        FrogJmp s = new FrogJmp();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(10, 85, 30) == 3);

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

    public int solution(int X, int Y, int D) {
        double step = Math.ceil((Y * 1.0 - X) / D);
        return (int) step;
    }
}