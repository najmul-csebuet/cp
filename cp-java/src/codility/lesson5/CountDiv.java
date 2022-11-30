package codility.lesson5;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class CountDiv {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new CountDiv();

        l.add(s.solution(6, 11, 2) == 3);
        l.add(s.solution(0, 11, 3) == 4);
        l.add(s.solution(1, 11, 3) == 3);
        l.add(s.solution(6, 7, 3) == 1);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int A, int B, int K) {
        return A != 0 ? B / K - (A - 1) / K : B / K + 1;
    }
}
