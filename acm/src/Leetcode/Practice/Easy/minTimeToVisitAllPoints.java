package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

public class minTimeToVisitAllPoints {

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

    public static void main(String[] args) throws IOException {

        minTimeToVisitAllPoints s = new minTimeToVisitAllPoints();
        ArrayList<Boolean> l = new ArrayList<>();

        int[][] inp = {{1, 1}, {3, 4}, {-1, 0}};
        l.add(s.minTimeToVisitAllPoints(inp) == 7);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public int minTimeToVisitAllPoints(int[][] points) {

        int ans = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int xDiff = Math.abs(points[i][0] - points[i+1][0]);
            int yDiff = Math.abs(points[i][1] - points[i+1][1]);
            ans += Math.max(xDiff, yDiff);
        }

        return ans;
    }
}