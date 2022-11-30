package Codility.Interview.Easy;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution s = new Solution();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution("ABDCA", new int[]{2,-1,-4,-3,3}, new int[]{2,-2,4,1,-3}) == 3);
        l.add(s.solution("ABB", new int[]{1,-2,-2}, new int[]{1,-2,2}) == 1);
        l.add(s.solution("CCD", new int[]{1,-1,2}, new int[]{1,-1,-2}) == 0);
        l.add(s.solution("A", new int[]{0}, new int[]{0}) == 1);

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

    class Point {

        char label = 'A';
        int x,y;
        double dist;

        public Point(char label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
            dist = Math.sqrt(1.0*x*x + 1.0*y*y);
        }
    }

    public int solution(String S, int[] X, int[] Y) {
        // write your code in Java SE 8
        ArrayList<Point> pointList = new ArrayList<>();
        ArrayList<Point> takenPointList = new ArrayList<>();

        for (int i = 0; i < X.length; i++) {
            Point p = new Point(S.charAt(i), X[i], Y[i]);
            pointList.add(p);
        }

        pointList.sort((a,b) -> {
            if (a.dist <= b.dist)return -1;
            return 1;
        });

        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < pointList.size(); i++) {

            Point point = pointList.get(i);

            if (i == 0) {
                map.put(point.label, true);
                takenPointList.add(point);
                continue;
            }

            Point prevPoint = takenPointList.get(i - 1);
            if (prevPoint.dist == point.dist && prevPoint.label == point.label) {
                takenPointList.remove(i-1);
                break;
            }

            if (map.getOrDefault(point.label, false)) {
                break;
            }

            map.put(point.label, true);
            takenPointList.add(point);
        }

        return takenPointList.size();
    }
}