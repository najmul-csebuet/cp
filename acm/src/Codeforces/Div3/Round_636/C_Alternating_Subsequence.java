package Codeforces.Div3.Round_636;

import java.io.*;
import java.util.*;

public class C_Alternating_Subsequence {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = C_Alternating_Subsequence.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C_Alternating_Subsequence.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = sc.nextInt();//fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int j = 0; j < N; j++) {
                array[j] = sc.nextInt();
            }
            new C_Alternating_Subsequence().solution(array);
        }

        if (fileInOut) {
            verify(C_Alternating_Subsequence.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
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

    boolean isOpposite(long a, long b) {
        if (a > 0 && b < 0)return true;
        return a < 0 && b > 0;
    }
    public void solution(int[] array) {

        long sum = 0;

        for (int i = 0; i < array.length; i++) {
            long max = Integer.MIN_VALUE;
            for (int j = i; j < array.length; j++) {
                if (max == Integer.MIN_VALUE) {
                    max = array[j];

                    if (j + 1 == array.length) {
                        sum += max;
                        i = j;
                    }
                    continue;
                }

                if (!isOpposite(max, array[j])) {
                    max = Math.max(max, array[j]);

                    if (j + 1 == array.length) {
                        sum += max;
                        i = j;
                    }
                    continue;
                }

                sum += max;
                i = j - 1;
                break;
            }
        }

        out.println(sum);
    }
}
