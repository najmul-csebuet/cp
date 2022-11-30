package codility.lesson5;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class MashroomPicker {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new MashroomPicker();

        l.add(s.solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 4, 6) == 25);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A, int k, int m) {
        /*
            p = 0,1,2,....,k in left direction and then m - p moves in right direction
            p = 0,1,2,....,(A.length - 1 - k) in right direction and then m - p moves in left direction
         */
        // prefix sum first
        var prefix = new int[A.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        int best = 0;

        // go left first
        for (int p = 0; p <= Math.min(m, k); p++) {

            int leftIndex = k - p;

            int oppositeMoves = m - p;
            int rightIndex = Math.min(Math.max(leftIndex + oppositeMoves, k), A.length - 1);

            best = getBest(prefix, best, leftIndex, rightIndex);
        }

        // go right now
        for (int p = 0; p <= A.length - 1 - k; p++) {

            int rightIndex = k + p;

            int oppositeMoves = m - p;
            int leftIndex = Math.max(Math.min(rightIndex - oppositeMoves, k), 0);

            best = getBest(prefix, best, leftIndex, rightIndex);
        }

        return best;
    }

    private static int getBest(int[] prefix, int best, int leftIndex, int rightIndex) {
        int sum = prefix[rightIndex + 1] - prefix[leftIndex];
        best = Math.max(best, sum);
        return best;
    }
}