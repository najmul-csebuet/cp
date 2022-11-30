package Common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

import static java.lang.System.out;

public class RotateString {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        RotateString s = new RotateString();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution("Bismillah") == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    private String rotateLeft(String S, int amount) {

        amount %= S.length();
        StringBuilder sb = new StringBuilder(S + S);

        String substring = sb.substring(amount, amount + S.length());
        return substring;
    }

    private String rotateRight(String S, int amount) {

        amount %= S.length();
        StringBuilder sb = new StringBuilder(S + S);

        String substring = sb.substring(S.length() - amount, S.length() - amount + S.length());
        return substring;
    }

    public int solution(String S) {

        String abcd0 = rotateLeft("abcd", 0);
        String abcd1 = rotateLeft("abcd", 1);
        String abcd2 = rotateLeft("abcd", 2);
        String abcd3 = rotateLeft("abcd", 3);
        String abcd4 = rotateLeft("abcd", 4);


        String rabcd0 = rotateRight("abcd", 0);
        String rabcd1 = rotateRight("abcd", 1);
        String rabcd2 = rotateRight("abcd", 2);
        String rabcd3 = rotateRight("abcd", 3);
        String rabcd4 = rotateRight("abcd", 4);

        return 0;
    }
}