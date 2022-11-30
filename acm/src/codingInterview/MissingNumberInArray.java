package codingInterview;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumberInArray {

    public static void main(String[] args) {
        // one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n",
                Arrays.toString(iArray), missing);
    }

    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }


    private static void printMissingNumber(int[] numbers, int totalShouldBe) {
        int missing = totalShouldBe - numbers.length;
        BitSet bitSet = new BitSet(totalShouldBe);
        for (int num : numbers) {
            bitSet.set(num - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), totalShouldBe);

        int lastMissingIndex = 0;
        for (int i = 0; i < missing; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }
}
