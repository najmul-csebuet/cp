package codility.lesson3;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class PermMissingElem {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new PermMissingElem();

        l.add(s.solution(new int[] {2, 3, 1, 5}) ==4);
        l.add(s.solution(new int[] {2}) == 1);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] ar) {
        long n = ar.length + 1;
        long sum = n * (n + 1) / 2;
        for (var a : ar) sum -= a;
        return (int) sum;
    }
}