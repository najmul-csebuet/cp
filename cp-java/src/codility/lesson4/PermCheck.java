package codility.lesson4;

import java.util.*;

import static java.lang.System.out;

public class PermCheck {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new PermCheck();

        // TDD
        l.add(s.solution(new int[]{1, 3, 2, 4}) == 1);
        l.add(s.solution(new int[]{1, 3, 4}) == 0);
        l.add(s.solution(new int[]{1, 1}) == 0);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        int[] array = Arrays.stream(A).distinct().toArray();
        return array.length == A.length && A.length == max ? 1 : 0;
    }
}