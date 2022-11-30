//package Codementor.AzizAlmutlaq;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {

        test1();
        test2();

        System.out.println("2 test passed");
    }

    private static void test1() {
        int[] arrayInput = {3, 2, 1};
        int[] arrayExpected = {1, 2, 3};
        GitExercise.sortAscending(arrayInput);
        assert Arrays.equals(arrayInput, arrayExpected);
    }

    private static void test2() {
        int[] arrayInput2 = {1, 2, 3};
        int[] arrayExpected2 = {3, 2, 1};
        GitExercise.sortDescending(arrayInput2);
        assert Arrays.equals(arrayInput2, arrayExpected2);
    }
}
