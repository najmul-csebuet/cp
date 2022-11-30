package Java11;

import java.util.*;

public class SwapNumber {
    public static void main(String[] args) {
        int ans = digitSwapper(12345);
        if (ans == 13254) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        String ansst = letterSwapper("abcde");
        if (ansst.equals("acbed")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static int digitSwapper(int a) {

        int temp = a;
        List<Integer> list = new ArrayList<>();

        while (temp > 0) {
            int d = temp % 10;
            temp /= 10;
            list.add(0, d);
        }

        //1,2,3,4
        //4,3,2,1
        int i = list.size() % 2;
        for (; i < list.size(); i += 2) {
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            list.set(i, a2);
            list.set(i + 1, a1);
        }
        //Even length, start from 0
        //4,3,2,1 to 3,4,1,2
        //then 3,4,1,2 to 2,1,4,3
        //Convert 2,1,4,3 to an integer 2143

        int multiplier = 1;
        int sum = 0;

        for (int j = list.size() - 1; j >= 0; j--) {
            sum = list.get(j) * multiplier + sum;
            multiplier *= 10;
        }

        return sum;
    }

    public static String letterSwapper(String a) {

        char[] chars = a.toCharArray();

        for (int i = chars.length % 2; i < chars.length; i += 2) {
            char ch1 = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = ch1;
        }

        return String.valueOf(chars);
    }
}
