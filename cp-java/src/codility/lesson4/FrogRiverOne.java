package codility.lesson4;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.System.out;

public class FrogRiverOne {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new FrogRiverOne();

        l.add(s.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}) == 6);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int X, int[] A) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            set.add(a);
            if (set.size() == X) {
                return i;
            }
        }
        return -1;
    }
}