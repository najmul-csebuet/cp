package codility.lesson3;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class FrogJmp {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new FrogJmp();

        l.add(s.solution(10, 85, 30) == 3);
        l.add(s.solution(1, 1, 1) == 0);
        l.add(s.solution(1, 2, 1) == 1);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int x, int y, int d) {
        double diff = y - x;
        int step = (int) Math.ceil(diff / d);
        return step;
    }
}