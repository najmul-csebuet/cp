package training.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinExchange {

    public static void main(String[] args) {
        var ce = new CoinExchange();
        var c = List.of(1, 2, 5, 10, 20, 50, 100, 200);
        var coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        var amount = 520;
        ce.solve(coins, amount);
    }

    private void solve(int[] coins, int amount) {
        var usedCoins = new ArrayList<Coin>();
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            int coinValue = coins[i];
            var coin = new Coin(coinValue, amount / coinValue);
            usedCoins.add(coin);
            amount = amount % coinValue;
        }
        for (Coin c : usedCoins) {
            if (c.count > 0)
                System.out.println(c);
        }
    }

    static class Coin {
        int value, count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("Coin: %d, %d times.", value, count);
        }
    }
}
