package mylib;

import java.util.List;

public class GcdLcm {
    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(List<Integer> list) {
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            ans = gcd(ans, list.get(i));
        }
        return ans;
    }

    static int lcm(List<Integer> list) {
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            ans = lcm(ans, list.get(i));
        }
        return ans;
    }
}
