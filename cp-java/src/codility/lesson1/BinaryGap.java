package codility.lesson1;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class BinaryGap {

    public static void main(String[] args) throws IOException {
        var l = new ArrayList<Boolean>();
        var s = new BinaryGap();

        l.add(s.solution() == 0);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        var nn = sc.nextInt();
        String s = Integer.toBinaryString(nn);
        char[] chars = s.toCharArray();
        int c = 0, best = -1;
        for (char aChar : chars) {
            if (aChar == '1') {
                best = Math.max(c, best);
                c = 0;
            } else {
                ++c;
            }
        }
        out.println(best);
        return best;
    }
}