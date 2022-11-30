package mylib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumbers {
    static List<Integer> getPrimeNumbers(int n) {
        if (n < 2) return Collections.emptyList();

        var isComposite = new boolean[n + 1];

        for (int j = 2 * 2; j <= n; j += 2) isComposite[j] = true;

        for (int i = 3; i * i <= n; i += 2) {
            if (isComposite[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isComposite[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!isComposite[i]) list.add(i);
        }

        return list;
    }
}
