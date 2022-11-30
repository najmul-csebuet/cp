package codility.lesson5;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class MinAvgTwoSlice {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new MinAvgTwoSlice();

        l.add(s.solution(new int[]{4, 2, 2, 5, 1, 5, 8}) == 1);
        l.add(s.solution(new int[]{4, 5}) == 0);
        l.add(s.solution(new int[]{4, 5, 1}) == 1);
        l.add(s.solution(new int[]{-3, -5, -8, -4, -10, -100}) == 2);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A) {
        var p = new int[A.length + 1];
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + A[i - 1];
        }

        int I = 0;
        double minAvg = Double.MAX_VALUE;
        for (int len = 2; len <= Math.min(3, A.length); len++) {
            for (int i = 0; i <= A.length - len; i++) {
                int j = i + len - 1;
                int sum = p[j + 1] - p[i];
                double avg = sum * 1.0 / (j - i + 1);
                if (avg < minAvg) {
                    minAvg = avg;
                    I = i;
                }
            }
        }
        /*for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = p[j + 1] - p[i];
                double avg = sum * 1.0 / (j - i + 1);
                if (avg < minAvg) {
                    minAvg = avg;
                    I = i;
                }
            }
        }*/
        return I;
    }
}