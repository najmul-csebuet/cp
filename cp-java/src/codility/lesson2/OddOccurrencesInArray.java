package codility.lesson2;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class OddOccurrencesInArray {

    public static void main(String[] args) throws IOException {
        var l = new ArrayList<Boolean>();
        var s = new OddOccurrencesInArray();

        l.add(s.solution(new int[]{1}) == 1);
        l.add(s.solution(new int[]{1, 2, 3, 1, 2}) == 3);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A) {
        int a = A[0];
        for (int i = 1; i < A.length; i++) {
            a ^= A[i];
        }
        return a;
    }
}