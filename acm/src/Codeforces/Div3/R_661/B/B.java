package Codeforces.Div3.R_661.B;

import java.io.*;
import java.util.*;

public class B {

    private class Gift {
        int a, b;
        Gift(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void solution(Integer[] a, Integer[] b) {

        List<Gift> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(new Gift(a[i], b[i]));
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int minA = a[0];
        int minB = b[0];

        long moveCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).a > minA && list.get(i).b > minB) {
                int min = Math.min(list.get(i).a - minA, list.get(i).b - minB);

                list.get(i).a -= min;
                list.get(i).b -= min;

                moveCount += min;
            }

            if (list.get(i).a > minA) {
                int min = list.get(i).a - minA;
                list.get(i).a -= min;
                moveCount += min;
            }

            if (list.get(i).b > minB) {
                int min = list.get(i).b - minB;
                list.get(i).b -= min;
                moveCount += min;
            }
        }

        out.println(moveCount);
        out.flush();
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = B.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = B.class.getPackage() != null;
        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            int aLength = sc.nextInt();

            Integer[] a = new Integer[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            Integer[] b = new Integer[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                b[aIndex] = sc.nextInt();
            }

            new B().solution(a, b);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(B.class.getResource("ans.txt").getFile()));
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
