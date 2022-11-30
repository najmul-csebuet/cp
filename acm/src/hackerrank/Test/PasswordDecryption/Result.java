package hackerrank.Test.PasswordDecryption;

import java.io.*;
import java.util.*;

public class Result {

    public String solution(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for (; i < chars.length; i++) {
            Character ch = chars[i];
            if (Character.isAlphabetic(ch))break;
            stack.add(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (i < chars.length) {

            char ch = chars[i];

            if (ch == '0') {
                stringBuilder.append(stack.pop());
                ++i;
                continue;
            }

            if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '*') {
                stringBuilder.append(ch);
                ++i;
                continue;
            }

            //ch is Uppercase then
            if (i+1 < chars.length && Character.isLowerCase(chars[i+1])) {
                if (i+2 < chars.length && chars[i+2] == '*') {
                    stringBuilder.append(chars[i+1]);
                    stringBuilder.append(chars[i]);
                    i += 2;
                }
                else {
                    stringBuilder.append(ch);
                }
            }
            else {
                stringBuilder.append(ch);
            }

            ++i;
        }

        String x = stringBuilder.toString();
        out.println(x);
        return x;
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = Result.class.getPackage() != null;
        sc = getScanner(fileInOut);
        try {
            out = getPrintWriter(fileInOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner getScanner(boolean fileInOut) {
        return new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Result.class.getResourceAsStream("in.txt") : System.in)));
    }

    private static PrintWriter getPrintWriter(boolean fileInOut) throws FileNotFoundException {
        return new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Result.class.getPackage() != null;
        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            String S = sc.next();
            new Result().solution(S);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(Result.class.getResource("ans.txt").getFile()));
            BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            boolean areEqual = true;
            int lineNum = 1;

            while (line1 != null || line2 != null) {

                if (line1 == null || line2 == null) {

                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {

                    areEqual = false;
                    break;
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();

                lineNum++;
            }

            if (areEqual) {

                System.out.println("All Test Cases Passed !");
            } else {

                System.out.println("Output differ at line " + lineNum);
                System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
            }

            reader1.close();
            reader2.close();
        }
    }
}
