package Codeforces.Div3.Round_481.D_Almost_Arithmetic_Progression;

import java.io.*;
import java.util.*;

public class D_Almost_Arithmetic_Progression {

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = D_Almost_Arithmetic_Progression.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D_Almost_Arithmetic_Progression.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int BLength = sc.nextInt();
            int[] B = new int[BLength];

            for (int BIndex = 0; BIndex < B.length; BIndex++) {
                B[BIndex] = sc.nextInt();
            }

            new D_Almost_Arithmetic_Progression().solution(B);
        }

        if (fileInOut) {
            verify(D_Almost_Arithmetic_Progression.class.getResource("ans.txt").getFile());
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

    public void solution(int[] B) {

        if (B.length < 3) {
            out.println(0);
            return;
        }

        int best = Integer.MAX_VALUE;

        int[] ops = { 0, -1, +1};

        for (int i = 0; i < ops.length; i++) {
            for (int j = 0; j < ops.length; j++) {
                for (int k = 0; k < ops.length; k++) {

                    int a = B[0] + ops[i];
                    int b = B[1] + ops[j];
                    int c = B[2] + ops[k];

                    if ((a - b) != (b - c))continue;

                    int commonDiff = b - a;
                    int firstNumber = a;

                    int count = 0;
                    for (int l = 0; l < B.length; l++) {

                        if (Math.abs(firstNumber - B[l]) > 1) {
                            count = Integer.MAX_VALUE;
                            break;
                        }

                        if (Math.abs(firstNumber - B[l]) == 1) {
                            ++count;
                        }

                        firstNumber = firstNumber + commonDiff;
                    }

                    if (best > count) {
                        best = count;
                    }
                }
            }
        }

        out.println(best == Integer.MAX_VALUE ? -1 : best);
    }
}
