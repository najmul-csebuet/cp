package codility.lesson3;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class TapeEquilibrium {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new TapeEquilibrium();

        l.add(s.solution(new int[]{3, 1, 2, 4, 3}) == 1);
        l.add(s.solution(new int[]{3, 1, 2}) == 0);
        l.add(s.solution(new int[]{3, 1}) == 2);
        l.add(s.solution(new int[]{-1000, 1000}) == 2000);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A) {
        int[] prefix = new int[A.length + 1];
        //   1 2 3
        // 0 1 3 6
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        int diffMin = Integer.MAX_VALUE;

        for (int p = 1; p < A.length; p++) {
            int seg1Sum = prefix[p];
            int seg2Sum = prefix[A.length] - seg1Sum;
            int diff = Math.abs(seg2Sum - seg1Sum);
            if (diff < diffMin) {
                diffMin = diff;
            }
        }

        return diffMin;
    }
}