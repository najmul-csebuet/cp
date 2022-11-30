package codility.lesson5;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class PassingCars {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new PassingCars();

        l.add(s.solution(new int[]{0, 1, 0, 1, 1}) == 5);

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
            p[i] = p[i - 1] + (1 - A[i - 1]);
        }
        long ans = 0L;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                ans += p[i];
            }
        }
        if (ans > 1e9) {
            return -1;
        }
        return (int) ans;
    }
}