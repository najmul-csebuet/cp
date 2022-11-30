package codingInterview.tts;

import java.util.Stack;

public class B {
    public static void main(String[] args) {
        rpnCalculator("1 2 3 * +");
        rpnCalculator("1156 12 11 * +");
        rpnCalculator("5 2 + 3 *");
        rpnCalculator("5 2 * 2 * 4 +");
        rpnCalculator("5 2 + 2 + 4 +");
        rpnCalculator("3 2 + 2 4 + *");
        rpnCalculator("3 2 2 4 + + *");
        rpnCalculator("5");
        rpnCalculator("0 1 *");
        rpnCalculator("5 5 + 6 6 + 1 1 + * +");
    }

    private static void rpnCalculator(String expr) {
        String[] strings = expr.split(" ");

        var stack = new Stack<String>();

        for (int i = 0; i < strings.length; i++) {
            String num = strings[i];
            if (!"*+".contains(num)) {
                stack.push(num);
                continue;
            }
            var a = Integer.parseInt(stack.pop());
            var b = Integer.parseInt(stack.pop());
            int t = num.equals("+") ? a + b : a * b;
            stack.push(t + "");
        }

        int ans = Integer.parseInt(stack.pop());
        System.out.println(ans);
    }
}
