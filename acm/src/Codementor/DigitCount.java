package Codementor;

// Java implementation of above idea

import java.util.HashSet;
import java.util.Vector;

class DigitCount {

    static int MAX = 1000000;
    static Vector<Integer> Prefix = new Vector<>();

    static int repeated_digit(int n) {
        HashSet<Integer> a = new HashSet<>();
        int d;
        while (n != 0) {
            d = n % 10;
            if (a.contains(d))
                return 0;
            a.add(d);
            n /= 10;
        }
        return 1;
    }

    static void pre_calculations() {
        Prefix.add(0);
        Prefix.add(repeated_digit(1));
        for (int i = 2; i < MAX + 1; i++)
            Prefix.add(repeated_digit(i) + Prefix.elementAt(i - 1));
    }

    static int calculate(int L, int R) {
        return Prefix.elementAt(R) - Prefix.elementAt(L - 1);
    }

    public static void main(String[] args) {
        int L = 1, R = 100;
        pre_calculations();
        System.out.println(calculate(L, R));
    }
}
