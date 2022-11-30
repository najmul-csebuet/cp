//package Codementor.AzizAlmutlaq;

import java.util.Arrays;
import java.util.Scanner;

class GitExercise {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = getNumOfIntegers(input);

        int[] array = getNumbersFromUser(num, input);
        sortAscending(array);
        printArray(array, "Sorted list of integers:");

        //feature 1
        int number = getNumOfIntegers(input);
        int[] arr = getNumbersFromUser(num, input);
        sortDescending(arr);

        printArray(arr, "Sorted list of integers in a descending order is: ");
    }

    private static int getNumOfIntegers(Scanner input) {
        System.out.println("Enter the number of integers to sort:");
        return input.nextInt();
    }

    private static void printArray(int[] arr, String message) {
        System.out.println(message);
        for (int a = 0; a < arr.length; a++) {
            System.out.println(arr[a]);
        }
    }

    private static int[] getNumbersFromUser(int num, Scanner input) {
        int i;
        int[] array = new int[num];

        System.out.println("Enter " + num + " integers: ");

        for (i = 0; i < num; i++)
            array[i] = input.nextInt();
        return array;
    }

    public static void sortDescending(int[] arr) {
        int number = arr.length;
        for (int a = 0; a < (number - 1); a++) {
            for (int f = 0; f < number - a - 1; f++) {
                if (arr[f] < arr[f + 1]) {
                    int tempr = arr[f];
                    arr[f] = arr[f + 1];
                    arr[f + 1] = tempr;
                }
            }
        }
    }

    public static void sortAscending(int[] array) {
        int num = array.length;
        for (int i = 0; i < (num - 1); i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

