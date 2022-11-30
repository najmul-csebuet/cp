package training.slidingWindow;

import java.util.*;

import static java.lang.System.out;

/*
    Find Max sum sub array of size k
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new MaxSumSubArray();

        l.add(s.solution(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3) == 16);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A, int k) {

        int best = 0;
        for (int i = 0; i < k; i++) {
            best += A[i];
        }

        int localSum = best;
        for (int i = k; i < A.length; i++) {
            localSum += A[i];
            localSum -= A[i - k];
            best = Math.max(best, localSum);
        }

        return best;
    }
}