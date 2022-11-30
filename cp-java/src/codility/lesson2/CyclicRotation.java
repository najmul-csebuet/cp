package codility.lesson2;

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class CyclicRotation {

    public static void main(String[] args) throws IOException {
        var l = new ArrayList<Boolean>();
        var s = new CyclicRotation();

        //1
        l.add(Arrays.equals(s.solution(new int[]{1, 2, 3, 4}, 1), new int[]{4, 1, 2, 3}));

        //2
        l.add(Arrays.equals(s.solution(new int[]{1, 2, 3, 4}, 2), new int[]{3, 4, 1, 2}));

        //3
        l.add(Arrays.equals(s.solution(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4}));

        //4
        l.add(Arrays.equals(s.solution(new int[]{1, 2, 3, 4}, 5), new int[]{4, 1, 2, 3}));

        //5
        l.add(Arrays.equals(s.solution(new int[]{}, 5), new int[]{}));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int[] solution(int[] inputArray, int k) {

        int length = inputArray.length;
        if (length != 0) {
            k %= length;
        }

        if (k == 0 || length == 0) {
            return inputArray;
        }

        var rotatedArray = new int[length];
        int j = -1;
        for (int i = length - k; i < length; i++) {
            rotatedArray[++j] = inputArray[i];
        }

        for (int i = 0; i < length - k; i++) {
            rotatedArray[++j] = inputArray[i];
        }

        return rotatedArray;
    }
}