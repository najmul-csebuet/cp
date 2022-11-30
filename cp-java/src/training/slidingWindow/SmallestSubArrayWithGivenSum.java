package training.slidingWindow;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new SmallestSubArrayWithGivenSum();

        l.add(s.solution(new int[]{4, 2, 2, 7, 8, 1, 2, 8, 1, 0}, 8) == 1);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A, int minimumSum) {

        var s = 0;
        var smallestSize = A.length;

        for (int windowEnd = 0, windowStart = 0; windowEnd < A.length; windowEnd++) {

            s += A[windowEnd];

            while (s >= minimumSum) {
                int size = windowEnd - windowStart + 1;
                smallestSize = Math.min(smallestSize, size);
                s -= A[windowStart];
                windowStart++;
            }
        }

        return smallestSize;
    }
}