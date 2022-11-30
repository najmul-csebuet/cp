package Common;

import java.util.*;

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
        //int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n",
                Arrays.toString(iArray), 4);
    }

    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int num : numbers) {
            bitSet.set(num - 1);
        }

        int fromIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            int nextClearBit = bitSet.nextClearBit(fromIndex);
            fromIndex = nextClearBit + 1;
            System.out.println(nextClearBit + 1);
        }

        System.out.println();
    }

    public static boolean checkDuplicate(String[] input) {
        List inputList = Arrays.asList(input);
        Set inputSet = new HashSet(inputList);
        if (inputSet.size() < inputList.size())
            return true;
        return false;
    }

    public static boolean checkDuplicate(int[] input) {
        List inputList = Arrays.asList(input);
        Set inputSet = new HashSet(inputList);
        if (inputSet.size() < inputList.size())
            return true;
        return false;
    }

    public static boolean checkDuplicateUsingAdd(String[] input) {
        Set tempSet = new HashSet();
        for (String str : input) {
            if (!tempSet.add(str)) {
                return true;
            }
        }
        return false;
    }
}
