package codingInterview.ArcDev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.lang.System.out;

public class C {

    public static void main(String[] args) throws IOException {
        // String exp = "(2 / (2 + 3.33) * 4) - 6";
        // String exp = "(2 / (2 + 3.33) * 4) - -6";
        String exp = "(1 - -1)";
        out.println(infixToPostfix(exp));
        double v = myCalculator(infixToPostfix(exp));
        System.out.println(v);
    }

    private static int getPrecedence(String ch) {
        if (Arrays.asList("+", "-").contains(ch)) {
            return 1;
        }
        if (Arrays.asList("*", "/").contains(ch)) {
            return 2;
        }
        return -1;
    }

    private static List<String> infixToPostfix(String exp) {

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String temp = "";
        boolean negationSeen = false;

        for (int i = 0; i < exp.length(); ++i) {

            char c = exp.charAt(i);
            if (Character.isWhitespace(c)) {
                negationSeen = false;
                continue;
            }

            if (c == '-') {
                for (int k = i - 1; k >= 0; --k) {
                    char ch = exp.charAt(k);
                    if (Character.isLetterOrDigit(ch) || ch == '.' || ch == '(' || ch == ')') {
                        negationSeen = false;
                        break;
                    }

                    if (ch == ' ') {
                        continue;
                    }

                    negationSeen = true;
                    break;
                }

                if (negationSeen) {
                    continue;
                }
            }

            if (negationSeen && c == '(') {
                int depth = 0;
                int j = i;
                for (; j < exp.length(); j++) {
                    if(exp.charAt(j) == '(') {
                        ++depth;
                        continue;
                    }

                    if(exp.charAt(j) == ')') {
                        --depth;
                    }

                    if(depth == 0) {
                        break;
                    }
                }

                double v = myCalculator(infixToPostfix(exp.substring(i, j + 1)));
                v = -v;
                result.add(String.valueOf(v));
                i = j;
                continue;
            }

            if (negationSeen && c == ')') {
                result.add("-" + temp);
                negationSeen = false;
                temp = "";
                continue;
            }

            if (Character.isLetterOrDigit(c) || c == '.') {
                temp += c;
                if (i + 1 >= exp.length() || (!Character.isLetterOrDigit(exp.charAt(i + 1)) && exp.charAt(i + 1) != '.')) {

                    if (negationSeen) {
                        result.add("-" + temp);
                    } else {
                        result.add(temp);
                    }
                    negationSeen = false;
                    temp = "";
                }
            } else if (c == '(') {
                stack.push(String.valueOf(c));
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPrecedence(String.valueOf(c)) <= getPrecedence(stack.peek())) {
                    result.add(stack.pop());
                }
                stack.push(String.valueOf(c));
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static double myCalculator(List<String> strings) {

        Stack<String> stack = new Stack<>();

        for (String num : strings) {
            if (!"*/+-".contains(num)) {
                stack.push(num);
                continue;
            }
            Double b = Double.parseDouble(stack.pop());
            Double a = stack.isEmpty() ? 0.0 : Double.parseDouble(stack.pop());

            double t = 0.0;
            String op = num;
            switch (op) {
                case "*":
                    t = a * b;
                    break;
                case "/":
                    t = a / b;
                    break;
                case "+":
                    t = a + b;
                    break;
                case "-":
                    t = a - b;
            }

            stack.push(t + "");
        }

        String pop = stack.pop();
        if(pop.equals("("))return 0.0;

        double ans = Double.parseDouble(pop);
        return ans;
    }
}