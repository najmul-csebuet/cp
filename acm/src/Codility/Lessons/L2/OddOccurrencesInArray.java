package Codility.Lessons.L2;

import java.io.IOException;
import java.util.ArrayList;

public class OddOccurrencesInArray {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        System.out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        OddOccurrencesInArray s = new OddOccurrencesInArray();
        ArrayList<Boolean> l = new ArrayList<>();

        //Test Cases

        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));
        l.add(s.solution(new int[]{9, 3, 9, 3, 9, 7, 9}) == 7);
        l.add(s.solution(new int[]{7}) == 7);

        checkTestCases(l);
    }

    public int solution(int[] A) {
        int ans = 0;
        for (int a : A) ans ^= a;
        return ans;
    }
}