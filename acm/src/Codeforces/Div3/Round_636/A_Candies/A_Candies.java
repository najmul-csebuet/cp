package Codeforces.Div3.Round_636.A_Candies;

import java.io.*;
import java.util.*;

public class A_Candies {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = A_Candies.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A_Candies.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = sc.nextInt();//fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            new A_Candies().solution(N);
        }

        if (fileInOut) {
            verify(A_Candies.class.getResource("ans.txt").getFile());
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

    public void solution(int n) {
        for (int k = 2; k < 32; ++k) {
            int a = (1 << k) - 1;
            if (n % a == 0) {
                out.println(n / a);
                return;
            }
        }
    }
}
