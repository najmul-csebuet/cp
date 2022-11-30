package codingInterview.ArcDev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class A {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();

        l.add(countChange(4, Arrays.asList(1, 2, -7)) == 3);
        l.add(countChange(10, Arrays.asList(5, 2, 3)) == 4);
        l.add(countChange(11, Arrays.asList(5, 7)) == 0);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public static Integer countChange(Integer money, List<Integer> coins) {

        if (money < 0) {
            return 0;
        }

        if (coins == null || coins.isEmpty()) {
            return 0;
        }

        List<Integer> positiveCoins = coins.stream().filter(t -> t > 0).collect(Collectors.toList());

        int[] dp = new int[money + 1];
        dp[0] = 1;

        for (int currentCoin : positiveCoins) {
            for (int j = currentCoin; j <= money; j++) {
                dp[j] += dp[j - currentCoin];
            }
        }

        return dp[money];
    }
}