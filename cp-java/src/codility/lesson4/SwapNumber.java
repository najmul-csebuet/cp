package codility.lesson4;

import java.util.*;

import static java.lang.System.out;

public class SwapNumber {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new SwapNumber();

        //l.add(s.slow_solution(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3) == true);
        l.add(s.fast_solution(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3) == true);
        l.add(s.fast_solution(new int[]{1, 2, 3}, new int[]{1, 1, 2}, 3) == true);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public boolean slow_solution(int[] A, int[] B, int m) {

        int sum1 = Arrays.stream(A).sum();
        int sum2 = Arrays.stream(B).sum();

        for (int a : A) {
            for (int b : B) {
                int change = b - a;
                sum1 += change;
                sum2 -= change;
                if (sum1 == sum2) {
                    return true;
                }
                sum1 -= change;
                sum2 += change;
            }
        }

        return false;
    }

    public boolean fast_solution(int[] A, int[] B, int m) {

        int sum1 = Arrays.stream(A).sum();
        int sum2 = Arrays.stream(B).sum();

        // total = sum1 + sum2 must be even.
        // because if total is not even we can split it into 2 equal sum part
        // so total will be even if both are odd or even. in that case diff between
        // sum1 and sum2 must be even
        var total = sum1 + sum2;
        if (total % 2 == 1) {
            return false;
        }

        /*
        A: ============
        B: ========
         */

        var diff = sum1 - sum2;
        var shiftAmount = diff / 2;

        // B - A == shiftAmount
        // (B- shiftAmount) = A

        // count B
        var count = new int[m + 1];
        for (int b : B) count[b]++;

        for (var a : A) {
            var b = a - shiftAmount;
            if (0 <= b && b <= m && count[b] > 0) {
                return true;
            }
        }

        return false;
    }
}